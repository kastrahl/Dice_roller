package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            rollDice()
        }
    }

    private fun rollDice() {
        val myDice = Dice(6)
        val diceRoll = myDice.roll()
        val luckyNumber = 4
        val resultTextView: TextView = findViewById(R.id.Rollednumber)
        resultTextView.text = diceRoll.toString()
        val luckyTextView: TextView = findViewById(R.id.lucky_text)
        val diceImage: ImageView = findViewById(R.id.dice_image)

        when (diceRoll) {
            luckyNumber -> luckyTextView.text = ("You won!")
            1 -> {
                luckyTextView.text = ("So sorry! You rolled a 1. Try again!")
                diceImage.setImageResource(R.drawable.dice_1)
            }
            2 -> {
                diceImage.setImageResource(R.drawable.dice_2)
                luckyTextView.text = ("Sadly, you rolled a 2. Try again!")
            }
            3 -> {
                diceImage.setImageResource(R.drawable.dice_3)
                luckyTextView.text = ("You rolled a 3. Try again!")
            }
            4 -> {
                diceImage.setImageResource(R.drawable.dice_4)
                luckyTextView.text = ("No luck! You rolled a 4. Try again!")
            }
            5 -> {
                diceImage.setImageResource(R.drawable.dice_5)
                luckyTextView.text = ("Don't cry! You rolled a 5. Try again!")
            }
            6 -> {
                diceImage.setImageResource(R.drawable.dice_6)
                luckyTextView.text = ("Apologies! you rolled a 6. Try again!")
            }
        }
    }
}
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
