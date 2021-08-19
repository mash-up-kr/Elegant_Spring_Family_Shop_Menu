package com.mashup.shopmenu.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.mashup.shopmenu.common.enum.PaymentType
import com.mashup.shopmenu.dto.request.CreateShopRequestDTO
import com.mashup.shopmenu.dto.response.CreateShopResponseDTO
import org.junit.jupiter.api.Test
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@AutoConfigureMockMvc
@SpringBootTest
class ShopControllerTest {

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var modelMapper: ModelMapper


    @Test
    fun createTest(): Unit {
        val createShopRequestDTO = CreateShopRequestDTO(name= "myShop1", category = "category1", paymentType = PaymentType.CARD)
        val expect = modelMapper.map(createShopRequestDTO, CreateShopResponseDTO::class.java).copy(shopID = 1L)
        println(objectMapper.writeValueAsString(createShopRequestDTO))
        mockMvc.post("http://localhost:8080/v1/shop") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(createShopRequestDTO)
            accept = MediaType.APPLICATION_JSON
        }
            .andExpect { content { json(objectMapper.writeValueAsString(expect)) } }
    }
}