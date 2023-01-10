package com.example.practicaltask

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImageViewResource")
fun ImageView.setImageViewResource(url:String?) {
    Log.e("TAG", "setImageViewResource: $url")
    Glide.with(this).load(url).thumbnail(Glide.with(context).load(R.drawable.ic_loading)).into(this);

}

@BindingAdapter("settexthere")
fun TextView.settexthere(s:String){
    this.text = s
}
