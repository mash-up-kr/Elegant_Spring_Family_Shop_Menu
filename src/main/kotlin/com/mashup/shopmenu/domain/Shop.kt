package com.mashup.shopmenu.domain

import com.mashup.shopmenu.common.enum.PaymentType
import com.mashup.shopmenu.domain.value.CreateModifyTime
import org.apache.commons.lang3.StringUtils
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@Entity
data class Shop(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private val shopID: Long = 0L,
    private val name: String = StringUtils.SPACE,
    private val paymentType: PaymentType? = null,
    private val category: String = StringUtils.SPACE,
    @CreatedDate
    private var createTime: LocalDateTime = LocalDateTime.MIN,
    @LastModifiedDate
    private var lastModifiedTime: LocalDateTime = LocalDateTime.MIN
) {
}