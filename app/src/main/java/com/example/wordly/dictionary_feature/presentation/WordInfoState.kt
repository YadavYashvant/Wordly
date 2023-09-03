package com.example.wordly.dictionary_feature.presentation

import com.example.wordly.core.util.Resource
import com.example.wordly.dictionary_feature.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
