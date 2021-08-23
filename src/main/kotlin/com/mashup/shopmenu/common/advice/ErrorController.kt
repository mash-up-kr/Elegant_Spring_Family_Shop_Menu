package com.mashup.shopmenu.common.advice

import com.mashup.shopmenu.common.response.ShopMenuResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorController {

    @ExceptionHandler(Exception::class)
    fun exceptionHandle(exception: Exception): ResponseEntity<String> {
        return ShopMenuResponse.errorOf("Error : ${exception.stackTraceToString()}")
    }
}