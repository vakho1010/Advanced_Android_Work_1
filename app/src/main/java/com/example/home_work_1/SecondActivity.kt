package com.example.home_work_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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

        displayEmail.setText("From: " +incomingEmail)
        displayReceiverEmail.setText("To: "+incomingRecipientEmail)
        displayMessage.setText(incomingMessage)

        resetButton.setOnClickListener {
            displayEmail.setText("")
            displayReceiverEmail.setText("")
            displayMessage.setText("")
            Toast.makeText(this, "All Fields Are Cleared", Toast.LENGTH_SHORT).show()
        }
    }
}
