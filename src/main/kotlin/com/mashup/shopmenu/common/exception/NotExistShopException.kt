package com.mashup.shopmenu.common.exception

class NotExistShopException(
    message: String = "존재하지 않는 가게입니다."
): Throwable(message = message) {
}