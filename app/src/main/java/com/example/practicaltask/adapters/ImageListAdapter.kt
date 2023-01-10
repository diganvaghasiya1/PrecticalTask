package com.example.practicaltask.adapters

import android.app.Activity
import android.app.Dialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practicaltask.R
import com.example.practicaltask.databinding.RowImageListingBinding
import com.example.practicaltask.model.ImageList
import com.example.practicaltask.model.ImageListItem
import com.example.practicaltask.setImageViewResource


class ImageListAdapter(imageLists: ImageList, mainActivity: Activity) :
    RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {
    class ViewHolder(itemView: RowImageListingBinding) : RecyclerView.ViewHolder(itemView.root) {

        private var view:RowImageListingBinding=itemView
        fun bind(item: ImageListItem) {
            view.data=item
        }

    }

    var imageList = ImageList()
   var activity: Activity

    init {
        this.imageList = imageLists
        activity=mainActivity
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding =
            RowImageListingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = imageList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            showDialog(item)
        }


        Log.e("TAG", "onBindViewHolder: " + item.author)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    fun showDialog(item: ImageListItem) {
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.list_dialog)
        val txtAuthorName = dialog.findViewById(R.id.txtAuthorName) as TextView
        txtAuthorName.text = item.author
        val dialogButton: Button = dialog.findViewById(R.id.btn_dialog) as Button
        val txtImage: ImageView = dialog.findViewById(R.id.txtImage) as ImageView
        Glide.with(activity).load(item.download_url).
        thumbnail(Glide.with(activity).load(R.drawable.ic_loading)).into(txtImage);

        dialogButton.setOnClickListener {
            dialog.dismiss()

        }
        dialog.show()
    }
}