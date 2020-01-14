package com.example.appprogrammering2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val darkButton = findViewById<Button>(R.id.button2)
        val background = findViewById<View>(R.id.frontPage)

        // Counter to count button click
        var counter = 0

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
    }

}
