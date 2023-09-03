package com.example.wordly.dictionary_feature.domain.model

import com.example.wordly.dictionary_feature.data.remote.dto.DefinitionDto

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)