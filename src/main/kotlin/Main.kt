package org.example

import org.example.data.CitiesList

import org.example.service.ComputerService
import org.example.service.PlayerService
import java.util.Scanner

fun main() {

    val citiesList: CitiesList = CitiesList()
    val scanner: Scanner = Scanner(System.`in`)
    val computerService: ComputerService = ComputerService(citiesList)
    val playerService: PlayerService = PlayerService(citiesList,scanner)

    while (true){
        val playerCity = scanner.nextLine()
        val computerMove = computerService.computerMove(playerCity)
        println(computerMove)
        val validatePlayerMove = playerService.validatePlayerMove(scanner.nextLine(), computerMove)
        println(validatePlayerMove)
    }

}