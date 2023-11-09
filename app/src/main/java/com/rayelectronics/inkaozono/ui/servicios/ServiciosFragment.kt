package com.rayelectronics.inkaozono.ui.servicios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.rayelectronics.inkaozono.R

class ServiciosFragment : Fragment() {
    private var currentPosition = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_servicios, container, false)
        slider(view)
        return view
    }
    private fun slider(vista: View) {
        val viewPager: ViewPager2 = vista.findViewById(R.id.viewpager_producto)
        val imageUrls = mutableListOf<String>()

        imageUrls.add("drawable/imagen_slider_1")
        imageUrls.add("drawable/imagen_slider_2")
        imageUrls.add("drawable/imagen_slider_3")

        val sliderAdapter = context?.let { ServicionAdapter(it, imageUrls) }
        viewPager.adapter = sliderAdapter
        botonescambiar(viewPager,vista,imageUrls)
    }
    private fun botonescambiar(slider:ViewPager2,vista: View,imageUrls:MutableList<String>){

        val buttonProximo = vista.findViewById<ImageView>(R.id.proximo)
        buttonProximo.setOnClickListener {
            currentPosition++
            if (currentPosition >= imageUrls.size) {
                currentPosition = 0
            }
            slider.setCurrentItem(currentPosition, true)
        }

        val buttonAnterior = vista.findViewById<ImageView>(R.id.anterior)
        buttonAnterior.setOnClickListener {
            currentPosition--
            if (currentPosition < 0) {
                currentPosition = imageUrls.size - 1
            }
            slider.setCurrentItem(currentPosition, true)
        }
    }



}