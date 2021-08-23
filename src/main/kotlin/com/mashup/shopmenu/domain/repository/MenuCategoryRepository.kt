package com.mashup.shopmenu.domain.repository

import com.mashup.shopmenu.domain.MenuCategory
import org.springframework.data.repository.CrudRepository

interface MenuCategoryRepository: CrudRepository<MenuCategory, Long> {
}