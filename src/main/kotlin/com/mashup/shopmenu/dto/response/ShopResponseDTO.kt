package com.mashup.shopmenu.dto.response

import com.mashup.shopmenu.common.enum.PaymentType
import org.apache.commons.lang3.StringUtils

class ShopResponseDTO(
    val shopID: Long = 0L,
    val name: String = StringUtils.SPACE,
    val category: String = StringUtils.SPACE,
    val paymentType: PaymentType? = null,
) {

}
