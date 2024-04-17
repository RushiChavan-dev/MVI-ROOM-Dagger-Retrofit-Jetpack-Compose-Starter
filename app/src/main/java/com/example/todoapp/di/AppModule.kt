package com.example.todoapp.di

import android.app.Application
import androidx.room.Room
import com.example.todoapp.data.local.TemplateDatabase
import com.example.todoapp.data.remote.TemplateService
import com.example.todoapp.data.repository.room.TemplateRepo
import com.example.todoapp.domain.repository.localroom.TemplateRepoImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okio.IOException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://your_base_url.com"
    private const val RATE_LIMIT_PER_MINUTE = 60 // Adjust according to your API rate limit


    /*  ROOM DB START HERE    */
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): TemplateDatabase {
        return Room.databaseBuilder(
            app,
            TemplateDatabase::class.java,
            "note_db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(database: TemplateDatabase): TemplateRepo {
        return TemplateRepoImplementation(database.templateDao)
    }

    /*  ROOM DB END HERE    */


    /*  RETROFIT START HERE    */

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(RateLimitInterceptor(RATE_LIMIT_PER_MINUTE))
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): TemplateService {
        return retrofit.create(TemplateService::class.java)
    }

    private class RateLimitInterceptor(private val limit: Int) : Interceptor {
        private var lastRequestTimestamp = 0L

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            synchronized(this) {
                val currentTime = System.currentTimeMillis() / 1000
                if (currentTime - lastRequestTimestamp < 60) { // 60 seconds in a minute
                    val waitTime = 60 - (currentTime - lastRequestTimestamp)
                    Thread.sleep(waitTime * 1000)
                }
                lastRequestTimestamp = System.currentTimeMillis() / 1000
            }
            return chain.proceed(chain.request())
        }
    }

    /*  RETROFIT END HERE    */
}
