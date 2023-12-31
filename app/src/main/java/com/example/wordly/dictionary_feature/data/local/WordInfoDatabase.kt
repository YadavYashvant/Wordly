package com.example.wordly.dictionary_feature.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.wordly.dictionary_feature.data.local.entity.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class WordInfoDatabase: RoomDatabase() {

    abstract val dao: WordInfoDao
}