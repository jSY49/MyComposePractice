package com.jaysdevapp.mycomposepractice.features.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class NameViewmodel : ViewModel(){

    private val _nameList = mutableStateListOf<String>()
    public val nameList = _nameList

    fun addNameList(item : String){
        if(item.isNotEmpty()){
            _nameList.add(item)
        }
    }

    fun removeName(index : Int){
        _nameList.removeAt(index)
    }
}