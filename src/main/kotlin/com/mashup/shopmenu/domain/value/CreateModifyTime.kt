package com.mashup.shopmenu.domain.value

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.Embeddable

@Embeddable
class CreateModifyTime(
    @CreatedDate
    private val createTime: LocalDateTime,
    @LastModifiedDate
    private val lastModifiedTime: LocalDateTime
) {
}