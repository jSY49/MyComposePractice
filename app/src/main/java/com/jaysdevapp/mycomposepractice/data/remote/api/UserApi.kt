package com.jaysdevapp.mycomposepractice.data.remote.api

import com.jaysdevapp.mycomposepractice.features.model.UserItem
import retrofit2.http.GET

interface UserApi {

    @GET("users")
    suspend fun getUsers() : List<UserItem>
}