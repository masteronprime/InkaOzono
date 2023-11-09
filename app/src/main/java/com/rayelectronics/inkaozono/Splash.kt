package com.rayelectronics.inkaozono

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_scream)

        Handler().postDelayed({
            val intent = Intent(this, menuprincipal::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}