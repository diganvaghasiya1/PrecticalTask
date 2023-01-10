package com.example.practicaltask.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practicaltask.repo.MainImageRepository
import com.example.practicaltask.viewmodel.MainViewModle

class MainImageFactory(var mainImageRepository: MainImageRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModle(mainImageRepository) as T
    }
}