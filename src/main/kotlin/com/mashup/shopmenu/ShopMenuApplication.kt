package com.mashup.shopmenu

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class ShopMenuApplication

fun main(args: Array<String>) {
    runApplication<ShopMenuApplication>(*args)
}
