package com.jaysdevapp.mycomposepractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jaysdevapp.mycomposepractice.MainActivity.Companion.TAG
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
                        MyFirstScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun MyFirstScreen(){

    Column (
        modifier = Modifier
            .fillMaxSize() // 화면 꽉 채우기
            .padding(16.dp), // 사방에 여백 주기
        horizontalAlignment = Alignment.CenterHorizontally, // 가로 중앙 정렬
        verticalArrangement = Arrangement.Center    //세로 중앙 정렬
    ){
        Text(text = "HELLO JetPack Compose")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
            Log.d(TAG,"click!")
        }) {
            Image(
                painter = painterResource(id = R.drawable.main_btn02),
                contentDescription = "다음 화면", // 접근성을 위한 설명 (필수)
                modifier = Modifier.size(24.dp) // 이미지 크기 조절
            )
            Text(text = "다음화면으로")
            Text(text = "다음화면으로")
        }

        // 1. 가장 추천하는 방식 (Image 컴포넌트 활용)
        Image(
            painter = painterResource(id = R.drawable.main_btn02),
            contentDescription = "메인 버튼",
            contentScale = ContentScale.FillBounds, // XML의 scaleType="fitXY"와 동일 (꽉 채우기)
            modifier = Modifier
                .size(width = 200.dp, height = 60.dp) // 버튼 크기 지정
                .clickable {
                    Log.d(TAG, "이미지 버튼 클릭됨!")
                    // 여기서 다음 화면으로 넘어가는 로직 추가 예정
                }
        )
    }
}

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        // 1. 요소들의 ID(레퍼런스) 생성
        val (button, text) = createRefs()

        // 2. 가이드라인 생성 (비율로 잡기 - XML의 Guideline)
        val topGuideline = createGuidelineFromTop(0.2f) // 위에서 20% 지점

        Button(
            onClick = { /* 클릭 */ },
            modifier = Modifier.constrainAs(button) {
                // 3. 제약 조건 걸기
                top.linkTo(topGuideline)   // 가이드라인에 붙이기
                start.linkTo(parent.start) // 부모 왼쪽에 붙이기
                end.linkTo(parent.end)     // 부모 오른쪽에 붙이기

                // XML의 layout_constraintHorizontal_bias와 동일
                horizontalBias = 0.5f
            }
        ) {
            Text("비율로 배치된 버튼")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyComposePracticeTheme {
//        MyFirstScreen()
        ConstraintLayoutContent()
    }
}