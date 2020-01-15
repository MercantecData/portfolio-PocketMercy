package com.example.appprogrammering2

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, secondActivity::class.java)
        val activityButton = findViewById<Button>(R.id.activityButton)
        val inputButton = findViewById<Button>(R.id.sendButton)
        val darkButton = findViewById<Button>(R.id.button2)
        val background = findViewById<View>(R.id.frontPage)
        val inputText = findViewById<View>(R.id.inputText) as TextView
        val textField = findViewById<View>(R.id.textField) as TextView

        // Counter to count button click
        var counter = 0

        fun updateText() {
            val currentText = textField.text.toString()
            textField.text = currentText + "\n" +inputText.text.toString()
        }

        fun switchTheme() {
            if (counter == 0)
            {
                background.setBackgroundColor(Color.GRAY)
                counter = 1
            }
            else if (counter == 1)
            {
                background.setBackgroundColor(Color.WHITE)
                counter = 0
            }
        }

        darkButton.setOnClickListener {
            switchTheme()
        }

        inputButton.setOnClickListener {
            updateText()
            inputText.text = ""
        }

        activityButton.setOnClickListener {
            startActivity(intent)
        }
    }

}
