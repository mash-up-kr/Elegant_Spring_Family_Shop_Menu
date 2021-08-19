package com.mashup.shopmenu.domain

import com.mashup.shopmenu.domain.value.CreateModifyTime
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@Entity
class OptionCategory(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private val optionCategoryID: Long,
    private val name: String,
    @ManyToOne
    private val menu: Menu,
    @Embedded
    private val createModifyTime: CreateModifyTime
) {
}