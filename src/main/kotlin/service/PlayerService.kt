package org.example.service

import org.example.data.CITY_MUST_START_WITH
import org.example.data.CitiesList
import java.util.Scanner

class PlayerService(private val citiesList: CitiesList,
    private val scanner: Scanner) {
    fun validatePlayerMove(PlayerCity: String, computerCity: String): String {
        if(!PlayerCity.startsWith(computerCity.getLastChar(), ignoreCase = true)){
            return CITY_MUST_START_WITH.format(computerCity.getLastChar())
        }
        return scanner.nextLine()
    }
}