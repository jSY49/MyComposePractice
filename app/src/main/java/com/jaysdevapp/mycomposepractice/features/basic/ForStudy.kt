package com.jaysdevapp.mycomposepractice.features.basic

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        // 1. 고유 이름표
        val (button, text) = createRefs()

        // 2. 가이드라인 생성 (비율로 잡기 - XML의 Guideline)
        val topGuideline = createGuidelineFromTop(0.2f) // 위에서 20% 지점
        val bottomGuideline = createGuidelineFromTop(0.5f) // 위에서 20% 지점

        Button(
            onClick = { /* 클릭 */ },
            modifier = Modifier.constrainAs(button) {
                // 3. 제약 조건 걸기
                top.linkTo(topGuideline)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(bottomGuideline)
                // horizontalBias : 치우침
                horizontalBias = 0.5f
            }
        ) {
            Text("비율로 배치된 버튼")
        }

        Box(
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(button.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(bottomGuideline)
                    linkTo(parent.start, parent.end, bias = 0.855f) // 가로축으로 85.5% 지점까지 이동
                }
                .background(Color.Yellow)
        ) {
            Text("비율로 배치된 박스 ")
        }
    }
}

@Composable
fun profileCard() {

    val context = LocalContext.current  //함수 안에서 this를 쓰면, Activity를 가리키지 않음

    Column(
        modifier = Modifier
            .padding(10.dp)
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.background(Color.Yellow),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.DarkGray)
            ) {

            }
            Spacer(modifier = Modifier
                .height(20.dp)
                .width(10.dp))
            Column(

            ) {
                Text(text = "ID: jsy", style = MaterialTheme.typography.headlineMedium)
                Text(text = "jetpack compose 다시 공부 중", style = MaterialTheme.typography.bodySmall)
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            Toast.makeText(context, "click! ", Toast.LENGTH_SHORT).show()
        }) {
            Text("click")
        }
    }
}

@Composable
fun CounterState() {

    /*
    * 상태 선언 (기억하고 변할 수 있음)
    * */
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "클릭 횟수: $count",
            style = MaterialTheme.typography.displaySmall
        )

        Spacer(modifier = Modifier.height(24.dp))

        //클릭할 때 상태를 변경
        Row {
            Button(onClick = {
                count++
            }) {
                Text("숫자 올리기")
            }
            Button(onClick = {
                count = 0
            }) {
                Text("reset")
            }
        }

    }
}
