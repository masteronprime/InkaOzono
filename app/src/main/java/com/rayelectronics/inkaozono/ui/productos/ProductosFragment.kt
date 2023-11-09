package com.rayelectronics.inkaozono.ui.productos

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.rayelectronics.inkaozono.R

class ProductosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_productos, container, false)
        val videoView = view.findViewById<VideoView>(R.id.VideoProducto)

        val videoUri = Uri.parse("android.resource://" + requireContext().packageName + "/" + R.raw.productos_video)
        videoView.setVideoURI(videoUri)

        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        videoView.start()

        return view
    }

}