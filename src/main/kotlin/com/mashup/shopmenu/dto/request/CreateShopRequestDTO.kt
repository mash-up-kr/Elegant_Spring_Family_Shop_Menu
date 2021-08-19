package com.mashup.shopmenu.dto.request

import com.mashup.shopmenu.common.enum.PaymentType
import org.apache.commons.lang3.StringUtils

data class CreateShopRequestDTO(
    val name: String = "",
    val category: String = StringUtils.SPACE,
    val paymentType: PaymentType? = null,
)
