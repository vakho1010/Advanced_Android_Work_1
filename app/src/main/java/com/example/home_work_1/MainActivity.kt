package com.example.home_work_1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userEmail: EditText = findViewById(R.id.userEmailInput)
        val receiverEmail: EditText = findViewById(R.id.receiverEmailInput)
        val userMessage: EditText = findViewById(R.id.userMessageInput)
        val actionButton: Button = findViewById(R.id.submitButton)

        actionButton.setOnClickListener {
            val emailContent = userEmail.text.toString()
            val recipientContent = receiverEmail.text.toString()
            val messageContent = userMessage.text.toString()

            val validationMessage = checkInputValidity(emailContent, recipientContent, messageContent)

            if (validationMessage == null) {
                val redirectIntent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("EmailKey", emailContent)
                    putExtra("ReceiverEmailKey", recipientContent)
                    putExtra("MessageKey", messageContent)
                }
                Toast.makeText(this, "Message Sent!", Toast.LENGTH_SHORT).show()
                startActivity(redirectIntent)
            } else {
                Toast.makeText(this, validationMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkInputValidity(email: String, recipient: String, message: String): String? {
        return when {
            email.isEmpty() || recipient.isEmpty() || message.isEmpty() ->
                "All fields are required: Email, Recipient, and Message."
            !email.contains("@") || !recipient.contains("@") ->
                "Emails must contain '@' symbol."
            message.length > 250 ->
                "Message exceeds 250 characters."
            else -> null
        }
    }
}
