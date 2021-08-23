package com.mashup.shopmenu.domain

import com.mashup.shopmenu.domain.value.CreateModifyTime
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@Entity
class MenuCategory(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private val menuCategoryID: Long,
    private val name: String,
    @ManyToOne
    private val shop: Shop,
    @Embedded
    private val createModifyTime: CreateModifyTime
) {
}