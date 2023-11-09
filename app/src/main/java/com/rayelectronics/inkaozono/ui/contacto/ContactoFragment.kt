package com.rayelectronics.inkaozono.ui.contacto


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.rayelectronics.inkaozono.R


class ContactoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_contacto, container, false)
        email(view)
        return view
    }
    private fun email(view:View){
        val sendEmailButton = view.findViewById<AppCompatButton>(R.id.sendEmailButton)
        val subjectEditText = view.findViewById<EditText>(R.id.subjectEditText)
        val messageEditText = view.findViewById<EditText>(R.id.messageEditText)
        sendEmailButton.setOnClickListener {
            val recipient = "example@gmail.com"
            val subject = subjectEditText.text.toString()
            val message = messageEditText.text.toString()

            sendEmail(recipient, subject, message)
        }


    }
    private fun sendEmail(recipient: String, subject: String, message: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, message)

        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context,"No se pudo enviar el email",Toast.LENGTH_SHORT).show()
        }
    }
}