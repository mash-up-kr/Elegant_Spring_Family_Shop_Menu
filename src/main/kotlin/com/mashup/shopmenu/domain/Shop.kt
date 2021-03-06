package com.mashup.shopmenu.domain

import com.mashup.shopmenu.common.enum.PaymentType
import com.mashup.shopmenu.domain.value.CreateModifyTime
import org.apache.commons.lang3.StringUtils
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties

@EntityListeners(AuditingEntityListener::class)
@Entity
data class Shop(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    val shopID: Long = 0L,
    var name: String = StringUtils.SPACE,
    @Enumerated(EnumType.STRING)
    var paymentType: PaymentType? = null,
    var category: String = StringUtils.SPACE,
    @Embedded
    val createModifyTime: CreateModifyTime = CreateModifyTime(),
    @Version
    val shopVersion: Int = 0
) {

    fun update(shopDTO: Any) {
        val dtoClass = shopDTO::class.java
        this::class.memberProperties.forEach {
            if(it is KMutableProperty<*>) {
                val dtoField = dtoClass.getDeclaredField(it.name)
                dtoField.isAccessible = true
                it.setter.call( this, dtoField.get(shopDTO))
            }
        }
    }

}