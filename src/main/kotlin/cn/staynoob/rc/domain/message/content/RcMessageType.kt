package cn.staynoob.rc.domain.message.content

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

/**
 * http://www.rongcloud.cn/docs/server.html#message_type
 */
enum class RcMessageType(
        @get: JsonValue
        val value: String
) {
    TXT("RC:TxtMsg"),

    ;

    override fun toString(): String {
        return value
    }

    companion object {
        private val map = RcMessageType.values()
                .map { it.value to it }
                .toMap()

        @JvmStatic
        @JsonCreator
        fun fromValue(value: String): RcMessageType {
            return map[value]!!
        }
    }
}