package com.example.memorygame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.memorygame.R.drawable.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val button10 = findViewById<Button>(R.id.button10)
        val button11 = findViewById<Button>(R.id.button11)
        val button12 = findViewById<Button>(R.id.button12)

        val cardBack = code
        val images: MutableList<Int> = mutableListOf(camel, coala, fox, lion, monkey, wolf,
            camel, coala, fox, lion, monkey, wolf)

        val buttons: Array<Button> = arrayOf(button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button10, button11, button12)

        var clicked = 0
        var turnedOver = false
        var lastClicked = -1

        images.shuffle()

        for(i in 0..11)
        {
            buttons[i].text = "cardBack"
            buttons[i].textSize = 0.0F
            buttons[i].setOnClickListener{
                if (buttons[i].text == "cardBack" && !turnedOver) {
                    buttons[i].setBackgroundResource(images[i])
                    buttons[i].setText(images[i])
                    if (clicked ==0)
                    {
                        lastClicked = i
                    }
                    clicked++
                }
                else if (buttons[i].text !in "cardBack") {
                    buttons[i].setBackgroundResource(cardBack)
                    buttons[i].text = "cardBack"
                    clicked--
                }
                if (clicked == 2)
                {
                    turnedOver = true
                    if (buttons[i].text == buttons[lastClicked].text)
                    {
                        buttons[i].isClickable = false
                        buttons[lastClicked].isClickable = false
                        turnedOver = false
                        clicked = 0
                    }
                } else if (clicked == 0)
                {
                    turnedOver = false
                }
            }

        }// for
    }


}