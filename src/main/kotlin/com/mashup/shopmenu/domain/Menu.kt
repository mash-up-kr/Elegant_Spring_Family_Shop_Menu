package com.mashup.shopmenu.domain

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@Entity
class Menu(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private val menuID: Long,
    private val name: String,
    @ManyToOne
    private val menuCategory: MenuCategory
) {

}