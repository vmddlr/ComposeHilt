package com.example.corrutinasflow.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.request.ImageRequest
import coil.transform.BlurTransformation
import com.example.corrutinasflow.R
import com.example.corrutinasflow.data.model.SportEntity
import com.example.corrutinasflow.databinding.ItemSpotLayoutBinding
import javax.inject.Inject

class WeatherAdapter @Inject constructor(
    private var list: List<SportEntity>
) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.context = parent.context

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_spot_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = this.list[position]

        with(holder) {
            binding.tvName.text = entity.name

            val request = ImageRequest
                .Builder(this@WeatherAdapter.context)
                .data(entity.url)
                .crossfade(true)
                .transformations(listOf(
                    BlurTransformation(context, 25f)
                ))
                .size(1280, 720)
                .target(
                    onStart = {
                        binding.imgPhoto.setImageResource(R.drawable.ic_access_time)
                    },
                    onSuccess = {
                        binding.progressBar.visibility = View.GONE
                        binding.imgPhoto.scaleType = ImageView.ScaleType.CENTER_CROP
                        binding.imgPhoto.setImageDrawable(it)
                    },
                    onError = {
                    binding.progressBar.visibility = View.GONE
                        binding.imgPhoto.setImageResource(R.drawable.ic_error_outline)
                    }
                )
                .build()
            context.imageLoader.enqueue(request)
        }
    }

    override fun getItemCount(): Int = this.list.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemSpotLayoutBinding.bind(view)
    }
}