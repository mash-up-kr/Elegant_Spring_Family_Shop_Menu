package com.mashup.shopmenu.dto.response

import org.apache.commons.lang3.StringUtils
import com.mashup.shopmenu.common.enum.PaymentType
data class CreateShopResponseDTO(
    val shopID: Long = 0L,
    val name: String = "",
    val category: String = StringUtils.SPACE,
    val paymentType: PaymentType? = null,
)
