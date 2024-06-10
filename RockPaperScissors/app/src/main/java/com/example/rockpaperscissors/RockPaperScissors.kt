package com.example.rockpaperscissors

fun main(){
    var computerChoice = ""
    var playerChoice = ""
    var playAgain: Boolean = true
    var playAgainChoice = ""
    var playerScore = 0
    var computerScore = 0
    // while loop to continue playing infinitely upon user request
    while (playAgain) {
        // loop to check user choice correctness
        var correctInput: Boolean = true
        while (correctInput) {
            // suggest user the different choice
            println("Rock, Paper or Scissors? Enter you choice!")
            // read user input
            playerChoice = readln().lowercase()
            if (playerChoice == "rock" || playerChoice == "paper" || playerChoice == "scissors") {
                correctInput = false;
            } else {
                println("Please enter a correct choice")
            }
        }

        // generate random choice for computer
        when ((1..3).random()) {
            1 -> {
                computerChoice = "Rock"
            }

            2 -> {
                computerChoice = "Paper"
            }

            3 -> {
                computerChoice = "Scissors"
            }
        }
        // print computer choice for user feedback
        println("Computer choice: $computerChoice")
        // check who win with when statement
        val winner = when {
            playerChoice == computerChoice -> "Tie"
            playerChoice == "rock" && computerChoice.lowercase() == "scissors" -> "Player"
            playerChoice == "paper" && computerChoice.lowercase() == "rock" -> "Player"
            playerChoice == "scissors" && computerChoice.lowercase() == "paper" -> "Player"
            else -> "Computer"
        }
        // display winner
        if (winner == "Tie") {
            println("It's a tie")
        } else {
            println("The winner is the $winner")
            // count score
            if (winner == "Player"){
                playerScore += 1
            }
            else{
                computerScore += 1
            }
        }
        // ask the user if their want to play again
        println("Would you like to play again? (y/n)")
        playAgainChoice = readln()
        playAgain = when{
            playAgainChoice == "y" -> true
            else -> false
        }
    }
    // exit the game and display final score
    println("Scores:\tPlayer: ${playerScore.toString()}\tComputer: ${computerScore.toString()}")
    println("Well played!")
}