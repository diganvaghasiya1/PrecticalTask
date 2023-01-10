package com.example.practicaltask.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.distinctUntilChanged
import com.example.practicaltask.apiInterface.ApiInterface
import com.example.practicaltask.model.ImageList

class MainImageRepository(val apiInterface: ApiInterface) {

    private val liveDataScope = MutableLiveData<ImageList>()
    val livedata: LiveData<ImageList>
        get() = liveDataScope

    suspend fun getImageList() {
        val result = apiInterface.getImageList(2, 20)
        if (result != null) {
            if (result.isSuccessful) {
                if (result.body() != null) {
                    Log.e("TAG", "getImageList: "+ result.body()!!.get(0).download_url)
                    liveDataScope.postValue(result.body())
                }
            }
        }
    }


}