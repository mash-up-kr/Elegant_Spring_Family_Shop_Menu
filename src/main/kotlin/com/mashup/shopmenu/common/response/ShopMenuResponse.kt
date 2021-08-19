package com.mashup.shopmenu.common.response

import org.springframework.http.ResponseEntity

class ShopMenuResponse {

    companion object {
        fun <T> successOf(body: T): ResponseEntity<T> {
            return ResponseEntity.ok(body)
        }

        fun <T> errorOf(body: T): ResponseEntity<T> {
            return ResponseEntity.status(500).body(body)
        }

        fun <T> errorOfCode(code: Int, body: T): ResponseEntity<T> {
            return ResponseEntity.status(code).body(body)
        }
    }
}