package org.example.service

import org.example.data.CITY_NOT_FOUND
import org.example.data.CITY_USED
import org.example.data.CitiesList
import org.example.data.YOU_WIN

class ComputerService(private val citiesList: CitiesList) {

    fun computerMove(city: String): String = validatePlayerCity(city)

   private fun getCityByStartWithChar(char: Char): String {
        for (c in citiesList.cities) {
            if (c.startsWith(char, ignoreCase = true)) {
                return c
            }
        }
        return YOU_WIN
    }

    private fun validatePlayerCity(city: String): String {
        if(citiesList.usedCities.contains(city)) {
            return CITY_USED.format(city)
        }
        if(!citiesList.cities.contains(city)) {
            return CITY_NOT_FOUND.format(city)
        }

        val cityByStartWithChar = getCityByStartWithChar(city.getLastChar())
        citiesList.markCityAsUsed(city)
        citiesList.markCityAsUsed(cityByStartWithChar)
        return cityByStartWithChar
    }
}