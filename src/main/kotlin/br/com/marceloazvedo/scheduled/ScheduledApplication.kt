package br.com.marceloazvedo.scheduled

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ScheduledApplication

fun main(args: Array<String>) {
	runApplication<ScheduledApplication>(*args)
}
