package com.kpdoggie.ingest.fileingest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FileingestApplication

fun main(args: Array<String>) {
	runApplication<FileingestApplication>(*args)
}
