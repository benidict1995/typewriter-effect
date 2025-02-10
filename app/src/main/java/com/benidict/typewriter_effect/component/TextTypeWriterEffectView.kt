package com.benidict.typewriter_effect.component

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
    delay: Long = 160L,
    style: TextStyle ?= null,
    modifier: Modifier?= null,
    content: @Composable (() -> Unit) ?= null
){
    var textToDisplay by remember { mutableStateOf("") }
    LaunchedEffect(key1 = text) {
        for (i in text.toCharArray()) {
            textToDisplay += i.toString() //Append each character
            delay(delay) // Add a delay for the typing effect
        }
    }

    Text(
        modifier = modifier?: Modifier,
        text = textToDisplay,
        style = style?: TextStyle()
    )

    content?.let { returnContent ->
        if (textToDisplay == text)
            returnContent()
    }
}