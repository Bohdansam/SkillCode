package com.example.reg_log

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
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

        pickImageView.setOnClickListener {
            imageContract.launch("image/*")
        }
    }
}