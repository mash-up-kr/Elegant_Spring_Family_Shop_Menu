package com.mashup.shopmenu.domain.repository

import com.mashup.shopmenu.domain.Shop
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ShopRepository: CrudRepository<Shop, Long> {
    fun findAllByCategory(@Param("category") category: String): List<Shop>
}