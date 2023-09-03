package com.example.wordly.dictionary_feature.data.remote.dto

data class Definition(
    val antonyms: List<Any>,
    val definition: String,
    val synonyms: List<Any>
)