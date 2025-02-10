package com.benidict.typewriter_effect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benidict.typewriter_effect.component.TextTypeWriterEffectView
import com.benidict.typewriter_effect.ui.theme.TypewritereffectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TypewritereffectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        message = "Hello, Developer! This demo showcases the use of the sample TextTypeWriterEffectView.",
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(message: String, modifier: Modifier = Modifier) {
    var isFirstSentenceDone by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier.padding(vertical = 8.dp)
    ) {
        TextTypeWriterEffectView(
            text = message
        ) {
            isFirstSentenceDone = true
        }
        if (isFirstSentenceDone) {
            TextTypeWriterEffectView(
                text = "Another use case involves applying a text style and then calling a different composable after the animation.",
                modifier = Modifier.padding(top = 8.dp),
                delay = 100L
            ) {
                HorizontalDivider(
                    thickness = 2.dp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 8.dp),
                )
                TextTypeWriterEffectView(
                    text = "This is shown after the animation completes.",
                    modifier = Modifier.padding(top = 8.dp),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TypewritereffectTheme {
        Greeting("Hello, Developer! This demo showcases the use of the sample TextTypeWriterEffectView.")
    }
}