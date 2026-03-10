package com.jaysdevapp.mycomposepractice.features.repository

class NameRepository {

    suspend fun fetchRemoteNameList() : List<String>{
        kotlinx.coroutines.delay(2000) // 2초 대기 (임시 네트워크 통신 흉내)
        return listOf("한로로","Guckkasten","wave to earth")
    }
}