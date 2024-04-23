package com.example.reg_log

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.contract.ActivityResultContracts

class AvatarPick : AppCompatActivity() {

    private lateinit var galleryImg: ImageView
    private lateinit var pickImageView: ImageButton

    private val imageContract = registerForActivityResult(ActivityResultContracts.GetContent()){
        galleryImg.setImageURI(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avatar)

        galleryImg = findViewById(R.id.galleryImg)
        pickImageView = findViewById(R.id.pickImageBtn)

        // Получаем логин пользователя из Intent
        val username = intent.getStringExtra("username")

        // Находим TextView для отображения логина
        val usernameTextView: TextView = findViewById(R.id.usernameTextView)

        // Устанавливаем логин в TextView
        usernameTextView.text = "$username"

        pickImageView.setOnClickListener {
            imageContract.launch("image/*")
        }
    }
}
