package com.mashup.shopmenu.domain.repository

import com.mashup.shopmenu.domain.Menu
import org.springframework.data.repository.CrudRepository

interface MenuRepository: CrudRepository<Menu, Long>{
}