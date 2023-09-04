package com.example.wordly.dictionary_feature.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wordly.R
import com.example.wordly.dictionary_feature.domain.model.WordInfo


val fontsignika = FontFamily(
    Font(R.font.signikanegative)
)

@Composable
fun WordInfoItem(
    wordInfo: WordInfo,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = wordInfo.word,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            //color = Color.Black,
            fontFamily = fontsignika
        )
        Text(text = wordInfo.phonetic.toString(), fontWeight = FontWeight.Light, fontFamily = fontsignika)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = wordInfo.origin.toString(), fontFamily = fontsignika)

        wordInfo.meanings.forEach { meaning ->
            Text(text = meaning.partOfSpeech, fontWeight = FontWeight.Bold, fontFamily = fontsignika, fontSize = 20.sp)
            meaning.definitions.forEachIndexed { i, definition ->
                Text(text = "${i + 1}. ${definition.definition}", fontFamily = fontsignika, fontSize = 18.sp )
                Spacer(modifier = Modifier.height(8.dp))
                definition.example?.let { example ->
                    Text(text = "Example: $example", fontFamily = fontsignika, fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}