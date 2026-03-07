package com.jaysdevapp.mycomposepractice.features.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jaysdevapp.mycomposepractice.MainActivity.Companion.TAG
import com.jaysdevapp.mycomposepractice.R


@Composable
fun MyFirstScreen( whom: String,  onBack: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize() // 화면 꽉 채우기
            .padding(16.dp), // 사방에 여백 주기
        horizontalAlignment = Alignment.CenterHorizontally, // 가로 중앙 정렬
        verticalArrangement = Arrangement.Center    //세로 중앙 정렬
    ) {
        Text(text = "HELLO ${whom}, It's JetPack Compose")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = onBack) {
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