package com.mashup.shopmenu.domain

import com.mashup.shopmenu.common.enum.PaymentType
import com.mashup.shopmenu.dto.request.UpdateShopRequestDTO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShopTest {

    @Test
    fun 가게_업데이트_메서드_테스트() {
        val shop = Shop(name = "가게1", category = "카테고리1", paymentType = PaymentType.DIRECT)
        val dto = UpdateShopRequestDTO(name = "가게2", category = "카테고리2", paymentType = PaymentType.CARD)
        val expect = Shop(name = "가게2", category = "카테고리2", paymentType = PaymentType.CARD)
        shop.update(dto)
        assertEquals(expect, shop)
    }
}