package com.example.wordly.dictionary_feature.data.local

import androidx.room.Database
import com.example.wordly.dictionary_feature.data.local.entity.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class],
    version = 1
)
abstract class WordInfoDatabase {
    abstract val dao: WordInfoDao
}