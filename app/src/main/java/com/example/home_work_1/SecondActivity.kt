package com.example.myapplication1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.home_work_1.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val displayEmail: EditText = findViewById(R.id.displayEmailInput)
        val displayReceiverEmail: EditText = findViewById(R.id.displayReceiverEmailInput)
        val displayMessage: EditText = findViewById(R.id.displayMessageInput)
        val resetButton: Button = findViewById(R.id.resetButton)

        val incomingEmail = intent.getStringExtra("EmailKey")
        val incomingRecipientEmail = intent.getStringExtra("ReceiverEmailKey")
        val incomingMessage = intent.getStringExtra("MessageKey")

        displayEmail.setText(incomingEmail)
        displayReceiverEmail.setText(incomingRecipientEmail)
        displayMessage.setText(incomingMessage)

        resetButton.setOnClickListener {
            displayEmail.setText("")
            displayReceiverEmail.setText("")
            displayMessage.setText("")
        }
    }
}
