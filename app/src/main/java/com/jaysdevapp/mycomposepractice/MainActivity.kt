package com.jaysdevapp.mycomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jaysdevapp.mycomposepractice.navigation.myNavHost
import com.jaysdevapp.mycomposepractice.ui.theme.MyComposePracticeTheme

class MainActivity : ComponentActivity() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyComposePracticeTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text("나의 학습 기록") })
                    }
                ) { innerPadding ->
                    // innerPadding을 적용해줘야 상단바와 겹치지 않아
                    Box(modifier = Modifier.padding(innerPadding)) {

                        myNavHost()
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyComposePracticeTheme {

        myNavHost()
    }
}
