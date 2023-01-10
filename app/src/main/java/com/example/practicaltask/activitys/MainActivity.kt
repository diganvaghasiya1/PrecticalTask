package com.example.practicaltask.activitys

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicaltask.R
import com.example.practicaltask.adapters.ImageListAdapter
import com.example.practicaltask.apiInterface.ApiClient
import com.example.practicaltask.apiInterface.ApiInterface
import com.example.practicaltask.basemodel.BaseActivity
import com.example.practicaltask.databinding.ActivityMainBinding
import com.example.practicaltask.factory.MainImageFactory
import com.example.practicaltask.repo.MainImageRepository
import com.example.practicaltask.viewmodel.MainViewModle

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    lateinit var apiClient: ApiClient
    lateinit var mainViewModle: MainViewModle
    override fun activityCreated() {

        InIt()
    }


    fun InIt() {
        setTitle("ImageList Screen")
        val imageListClient = ApiClient().getClient().create(ApiInterface::class.java)
        val imageRepository = MainImageRepository(imageListClient)

        mainViewModle = ViewModelProvider(this,
            MainImageFactory(imageRepository)).get(MainViewModle::class.java)


        binding.rvImage.layoutManager = LinearLayoutManager(this)
        binding.rvImage.setHasFixedSize(true)


        mainViewModle.imageList.observe(this) {
            Log.e("TAG", "InIt: "+it.count())
            var imageListAdapter= ImageListAdapter (it,this)
            binding.rvImage.adapter =imageListAdapter

        }

    }

}