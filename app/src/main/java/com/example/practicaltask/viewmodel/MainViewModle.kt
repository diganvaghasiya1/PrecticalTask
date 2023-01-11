package com.example.practicaltask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicaltask.model.ImageList
import com.example.practicaltask.repo.MainImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModle(val mainImageRepository: MainImageRepository) : ViewModel() {
    val imageList: LiveData<ImageList>
        get() = mainImageRepository.livedata


    fun refresh(){
        viewModelScope.launch(Dispatchers.IO) {

            mainImageRepository.getImageList()
        }
    }
   
}