package com.example.diceroller

import android.os.Bundle
import android.widget.Button
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
        when (diceRoll) {
            luckyNumber -> luckyTextView.text = ("You won!")
            1 -> luckyTextView.text = ("So sorry! You rolled a 1. Try again!")
            2 -> luckyTextView.text = ("Sadly, you rolled a 2. Try again!")
            3 -> luckyTextView.text = ("Unfortunately, you rolled a 3. Try again!")
            4 -> luckyTextView.text = ("No luck! You rolled a 4. Try again!")
            5 -> luckyTextView.text = ("Don't cry! You rolled a 5. Try again!")
            6 -> luckyTextView.text = ("Apologies! you rolled a 6. Try again!")
        }
    }
}
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
