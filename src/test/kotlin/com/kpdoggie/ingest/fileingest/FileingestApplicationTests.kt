package com.kpdoggie.ingest.fileingest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

class FileIngestApplicationTests {

    @Test
    fun testGetPersonAge() {
        val mockPerson = Person(dateOfBirth = LocalDate.of(2000, 1, 20))
        assertEquals(mockPerson.age, 20)
    }

}
