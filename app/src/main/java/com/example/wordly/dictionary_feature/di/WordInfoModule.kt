package com.example.wordly.dictionary_feature.di

import android.app.Application
import androidx.room.Room
import com.example.wordly.dictionary_feature.data.local.Converter
import com.example.wordly.dictionary_feature.data.local.WordInfoDatabase
import com.example.wordly.dictionary_feature.data.remote.DictionaryApi
import com.example.wordly.dictionary_feature.data.repository.WordInfoRepositoryImpl
import com.example.wordly.dictionary_feature.data.util.GsonParser
import com.example.wordly.dictionary_feature.domain.repository.WordInfoRepository
import com.example.wordly.dictionary_feature.domain.use_cases.GetWordInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: WordInfoDatabase,
        api: DictionaryApi
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app, WordInfoDatabase::class.java, "word_database"
        ).addTypeConverter(Converter(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }
}