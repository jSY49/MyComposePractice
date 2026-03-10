package com.jaysdevapp.mycomposepractice.features.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaysdevapp.mycomposepractice.data.remote.api.RetrofitInstance
import com.jaysdevapp.mycomposepractice.features.model.UserItem
import kotlinx.coroutines.launch

class UserViewmodel : ViewModel() {

    private val _userList  = mutableStateListOf<UserItem>()
    val userList = _userList

    init {
        loadUsers()
    }

    private fun loadUsers() {

        viewModelScope.launch {

            try {

                val response = RetrofitInstance.retrofitApi.getUsers()
                _userList.clear()
                _userList.addAll(response)

            } catch (e : Exception){
                Log.e("UserViewmodel","$e")
            }

        }
    }

    fun addNameList(item : String){
        if(item.isNotEmpty()){
//            _userList.add()
        }
    }

    fun removeName(index : Int){
        _userList.removeAt(index)
    }
}