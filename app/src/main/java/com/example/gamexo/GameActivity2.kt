package com.example.gamexo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gamexo.databinding.ActivityGame2Binding

class GameActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityGame2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGame2Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_game2)
    }
}