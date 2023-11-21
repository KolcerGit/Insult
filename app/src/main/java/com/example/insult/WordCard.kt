package com.example.insult

import android.widget.ImageView
import android.widget.TextView

class WordCard(private val imageView: ImageView, private val textView: TextView) {

    fun setImage(imageResId: Int) {
        imageView.setImageResource(imageResId)
    }

    fun setText(text: String) {
        textView.text = text
    }
}