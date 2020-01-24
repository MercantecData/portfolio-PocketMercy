
package com.example.appprogrammering2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_second.*

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val channelID = "testapp" //notification channel id
        val cameraButton = findViewById<Button>(R.id.camaraButton)
        val titleText = findViewById<TextView>(R.id.titleText)
        val brodText = findViewById<TextView>(R.id.descriptionText)

        var counter = 0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel
            val name = "test"
            val descriptionText = "test"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel(channelID, name, importance)
            mChannel.description = descriptionText
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }

        val notifyButton = findViewById<Button>(R.id.notificationButton)
        fun notifyBuilder(text:String, title:String): NotificationCompat.Builder
        {
            //build notification
            var builder = NotificationCompat.Builder(this, channelID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(text)
            return builder
        }

        notifyButton.setOnClickListener{
            var titleContent = titleText.text.toString()
            var brodTextContent = brodText.text.toString()
            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(counter, notifyBuilder(brodTextContent, titleContent).build())
            }
            counter++
        }

        //Close activity
        activityButton.setOnClickListener {
            finish()
        }

        //Start camera when button click
        cameraButton.setOnClickListener{
            startCamera()
        }
    }

    val REQUEST_IMAGE_CAPTURE = 1
    //Start camera activity
    private fun startCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }
}
