package com.benidict.typewriter_effect.component

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import kotlinx.coroutines.delay

@Composable
fun TextTypeWriterEffectView(
    text: String,
    animSpeed: Long = 160L,
    style: TextStyle ?= null,
    modifier: Modifier?= null,
    content: @Composable (() -> Unit) ?= null
){
    var textToDisplay by remember { mutableStateOf("") }
    LaunchedEffect(key1 = text) {
        for (i in text.toCharArray()) {
            textToDisplay += i.toString()
            delay(animSpeed)
        }
    }

    Text(
        modifier = modifier?: Modifier,
        text = textToDisplay,
        style = style?: TextStyle()
    )

    content?.let { returnContent ->
        Log.d("makerChecker", "textToDisplay = $textToDisplay, text:$text")
        if (textToDisplay == text)
            returnContent()
    }
}