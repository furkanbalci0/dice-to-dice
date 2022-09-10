package com.furkanbalci.dice_to_dice

import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.furkanbalci.dice_to_dice.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(binding.root)

        //Hide status bar and navigation bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.let {
                //https://medium.com/swlh/modifying-system-ui-visibility-in-android-11-e66a4128898b
                it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                it.hide(WindowInsets.Type.systemBars())
                WindowCompat.setDecorFitsSystemWindows(window, false)
            }
        }

        binding.button.setOnClickListener {
            this.rollDice()
        }
    }

    private fun rollDice() {
        val drawableImage: Int = when (Random.nextInt(6) + 1) {
            1 -> R.drawable.ic_dice_1
            2 -> R.drawable.ic_dice_2
            3 -> R.drawable.ic_dice_3
            4 -> R.drawable.ic_dice_4
            5 -> R.drawable.ic_dice_5
            else -> R.drawable.ic_dice_6
        }
        binding.imageView.setImageResource(drawableImage)
    }
}