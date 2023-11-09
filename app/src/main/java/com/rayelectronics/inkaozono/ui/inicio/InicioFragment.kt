package com.rayelectronics.inkaozono.ui.inicio

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.rayelectronics.inkaozono.R

class InicioFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_inicio, container, false)
        val videoView = view.findViewById<VideoView>(R.id.VideoInicio)

        val videoUri = Uri.parse("android.resource://" + requireContext().packageName + "/" + R.raw.video_inicio)
        videoView.setVideoURI(videoUri)

        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        videoView.start()
        imagebutton(view)
        return view
    }
    private fun imagebutton(view:View) {
        val boton1= view.findViewById<ImageButton>(R.id.lineaindustrial)
        val boton2= view.findViewById<ImageButton>(R.id.lineaSalud)
        val boton3= view.findViewById<ImageButton>(R.id.lineaAgroindustrial)
        val boton4= view.findViewById<ImageButton>(R.id.lineaAgroindustrial3)
        val commonClickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.lineaindustrial -> showToast("Click en botón lineaindustrial")
                R.id.lineaSalud -> showToast("Click en botón lineaSalud")
                R.id.lineaAgroindustrial -> showToast("Click en botón lineaAgroindustrial")
                R.id.lineaAgroindustrial3 -> showToast("Click en botón lineaAgroindustrial3")
            }
        }
        boton1.setOnClickListener(commonClickListener)
        boton2.setOnClickListener(commonClickListener)
        boton3.setOnClickListener(commonClickListener)
        boton4.setOnClickListener(commonClickListener)
    }
    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}