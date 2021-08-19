package com.mashup.shopmenu.domain.repository

import com.mashup.shopmenu.domain.OptionCategory
import org.springframework.data.repository.CrudRepository

interface OptionCategoryRepository: CrudRepository<OptionCategory, Long>{
}