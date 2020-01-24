package com.example.appprogrammering2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

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
        val spinner: Spinner = findViewById(R.id.color_spinner)

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.color_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        // Counter to count button click
        var counter = 0

        //Update function for input textfield
        fun updateText() {
            val currentText = textField.text.toString()
            textField.text = currentText + "\n" +inputText.text.toString()
        }

        //Switch background color
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

        //Switch activity
        activityButton.setOnClickListener {
            startActivity(intent)
        }
    }
}
