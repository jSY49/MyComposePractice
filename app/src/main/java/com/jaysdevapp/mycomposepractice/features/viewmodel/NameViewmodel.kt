package com.jaysdevapp.mycomposepractice.features.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaysdevapp.mycomposepractice.features.repository.NameRepository
import kotlinx.coroutines.launch

class NameViewmodel(private val nameRepository: NameRepository = NameRepository()) : ViewModel(){

    private val _nameList = mutableStateListOf<String>()
    public val nameList = _nameList

    init{

        loadInitData()
    }

    private fun loadInitData() {

        viewModelScope.launch {
            val remoteData = nameRepository.fetchRemoteNameList()
            _nameList.addAll(remoteData)
        }
    }

    fun addNameList(item : String){
        if(item.isNotEmpty()){
            _nameList.add(item)
        }
    }

    fun removeName(index : Int){
        _nameList.removeAt(index)
    }
}