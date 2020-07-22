package com.kpdoggie.ingest.fileingest

import java.time.LocalDate
import java.time.temporal.ChronoUnit

data class Person(var name: String = "", var dateOfBirth: LocalDate = LocalDate.now(), var gender: Char = 'M') {

    val age: Int
        get() = ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now()).toInt()
}