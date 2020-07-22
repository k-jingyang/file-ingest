package com.kpdoggie.ingest.fileingest

import java.time.LocalDate
import java.time.temporal.ChronoUnit

data class Person(var name: String = "", var dateOfBirth: LocalDate = LocalDate.now(), var gender: Char = 'M') {

    fun getAge(): Int {
        return ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now()).toInt()
    }
}