package vw.helloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*
import org.slf4j.LoggerFactory
import java.lang.IllegalStateException

@SpringBootApplication
class HelloWorldApplication

fun main(args: Array<String>) {
	runApplication<HelloWorldApplication>(*args)
}

@RestController
class HelloController {
	private val log = LoggerFactory.getLogger("HelloController")

	@GetMapping(value = ["/hello"])
	fun hello(@RequestParam(defaultValue = "world") name: String): String {
		log.info("hello $name")
		return "hello $name"
	}

	@GetMapping(value = ["/hello-error"])
	fun helloError(@RequestParam(defaultValue = "world") name: String): String {
		val error = IllegalStateException("hello $name")
		if (name.isNotBlank()) {
			log.error("hello $name", error)
			throw error
		}
		return "hello $name"
	}
	
	@GetMapping(value = "/hi")
	fun hi(@RequestParam(defaultValue = "world") name: String): String {
		log.info("hi $name")
		return "hi $name"
	}
}

