package com.mashup.shopmenu.web

import com.mashup.shopmenu.common.response.ShopMenuResponse
import com.mashup.shopmenu.dto.request.CreateShopRequestDTO
import com.mashup.shopmenu.dto.request.UpdateShopRequestDTO
import com.mashup.shopmenu.service.ShopService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/shop")
@RestController
class ShopController(
    private val shopService: ShopService
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun createShop(@RequestBody createShopRequestDTO: CreateShopRequestDTO): ResponseEntity<Any> {
        return ShopMenuResponse.successOf(shopService.createShop(createShopRequestDTO))
    }

    @GetMapping("/category/{category}")
    fun getShopList(@PathVariable("category") category: String): ResponseEntity<Any> {
        return ShopMenuResponse.successOf(shopService.findByCategory(category))
    }

    @GetMapping("/{shopID}")
    fun getShopDetailInfo(@PathVariable("shopID") shopID: Long): ResponseEntity<Any> {
        return ShopMenuResponse.successOf(shopService.findByShopID(shopID))
    }

    @PutMapping
    fun updateShop(@RequestBody updateShopRequestDTO: UpdateShopRequestDTO): ResponseEntity<Any> {
        return ShopMenuResponse.successOf(shopService.updateShop(updateShopRequestDTO))
    }

    @DeleteMapping("/{shopID}")
    fun deleteShop(@PathVariable("shopID") shopID: Long): ResponseEntity<Any> {
        return ShopMenuResponse.successOf(shopService.deleteShop(shopID))
    }

}