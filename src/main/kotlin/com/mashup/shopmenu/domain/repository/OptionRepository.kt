package com.mashup.shopmenu.domain.repository

import com.mashup.shopmenu.domain.Option
import org.springframework.data.repository.CrudRepository

interface OptionRepository: CrudRepository<Option, Long> {
}