package com.example.insult;

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import com.example.insult.R

class MainActivity : AppCompatActivity() {

    private val cardImages = arrayOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)
    private var currentIndex = 0

    private lateinit var currentCard: WordCard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.imageView)
        val textView: TextView = findViewById(R.id.textView)
        val buttonPrev: Button = findViewById(R.id.buttonPrev)
        val buttonNext: Button = findViewById(R.id.buttonNext)

        currentCard = WordCard(imageView, textView)

        updateCard()

        buttonPrev.setOnClickListener {
            // Обработка нажатия на кнопку "Предыдущая карточка"
            currentIndex = (currentIndex - 1 + cardImages.size) % cardImages.size
            updateCard()
        }

        buttonNext.setOnClickListener {
            // Обработка нажатия на кнопку "Следующая карточка"
            currentIndex = (currentIndex + 1) % cardImages.size
            updateCard()
        }
    }

    private fun updateCard() {
        currentCard.setImage(cardImages[currentIndex])
        currentCard.setText("Карточка ${currentIndex + 1}")
    }
}