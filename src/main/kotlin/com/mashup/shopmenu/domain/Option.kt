package com.mashup.shopmenu.domain

import com.mashup.shopmenu.domain.value.CreateModifyTime
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@Entity
class Option(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private val optionID: Long,
    private val name: String,
    @ManyToOne
    private val optionCategory: OptionCategory,
    @Embedded
    private val createModifyTime: CreateModifyTime
) {
}