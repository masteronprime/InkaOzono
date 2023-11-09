package com.rayelectronics.inkaozono.ui.servicios

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.rayelectronics.inkaozono.R

class ServicionAdapter(private val context: Context, private val imageUrls: List<String>) : RecyclerView.Adapter<ServicionAdapter.SliderViewHolder>() {

    inner class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewProfile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_slider_view ,parent, false)
        return SliderViewHolder(view)
    }

    @SuppressLint("DiscouragedApi")
    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        val resourceId = context.resources.getIdentifier(imageUrls[position], "drawable", context.packageName)
        if (resourceId != 0) {
            holder.imageView.setImageResource(resourceId)
        } else {
            Toast.makeText(context,"No posee imagenes",Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return imageUrls.size
    }
}
