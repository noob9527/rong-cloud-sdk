package cn.staynoob.rc.domain.message.content

import cn.staynoob.rc.util.objectMapper

interface RcMessage {
    val type: String

    fun toJson(): String {
        return objectMapper.writeValueAsString(this)
    }
}