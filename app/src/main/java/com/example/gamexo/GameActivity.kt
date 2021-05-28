package com.example.gamexo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gamexo.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity(), View.OnClickListener {
    private val buttons = Array(3) {
        arrayOfNulls<Button>(
            3
        )
    }
    private lateinit var binding: ActivityGameBinding

    private var player1Turn = true
    private var roundCount = 0
    private var player1Points = 0
    private var player2Points = 0
    private var textViewPlayer1: TextView? = null
    private var textViewPlayer2: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textViewPlayer1 = binding.textViewP1
        textViewPlayer2 = binding.textViewP2
        for (i in 0..2) {
            for (j in 0..2) {
                val buttonID = "button_$i$j"
                val resID = resources.getIdentifier(buttonID, "id", packageName)
                buttons[i][j] = findViewById(resID)
                buttons[i][j]?.setOnClickListener(this)
            }
        }

        binding.buttonReset.setOnClickListener {
            resetBoard()
        }
    }

    override fun onClick(v: View) {
        if ((v as Button).text.toString() != "") {
            return
        }
        if (player1Turn) {
            v.text = "X"
        } else {
            v.text = "O"
        }
        roundCount++
        if (checkForWin()) {
            if (player1Turn) {
                player1Wins()
            } else {
                player2Wins()
            }
        } else if (roundCount == 9) {
            draw()
        } else {
            player1Turn = !player1Turn
        }
    }

    private fun checkForWin(): Boolean {
        val field = Array(3) {
            arrayOfNulls<String>(
                3
            )
        }
        for (i in 0..2) {
            for (j in 0..2) {
                field[i][j] = buttons[i][j]!!.text.toString()
            }
        }
        for (i in 0..2) {
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2] && field[i][0] != "") {
                return true
            }
        }
        for (i in 0..2) {
            if (field[0][i] == field[1][i] && field[0][i] == field[2][i] && field[0][i] != "") {
                return true
            }
        }
        if (field[0][0] == field[1][1] && field[0][0] == field[2][2] && field[0][0] != "") {
            return true
        }
        return field[0][2] == field[1][1] && field[0][2] == field[2][0] && field[0][2] != ""
    }

    private fun player1Wins() {
        player1Points++
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show()
        updatePointsText()
        resetBoard()
    }

    private fun player2Wins() {
        player2Points++
        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show()
        updatePointsText()
        resetBoard()
    }

    private fun draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show()
        resetBoard()
    }

    @SuppressLint("SetTextI18n")
    private fun updatePointsText() {
        textViewPlayer1!!.text = "Player 1: $player1Points"
        textViewPlayer2!!.text = "Player 2: $player2Points"
    }

    private fun resetBoard() {
        for (i in 0..2) {
            for (j in 0..2) {
                buttons[i][j]!!.text = ""
            }
        }
        roundCount = 0
        player1Turn = true
    }
}