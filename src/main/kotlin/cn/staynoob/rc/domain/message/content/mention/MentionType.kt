package cn.staynoob.rc.domain.message.content.mention

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class MentionType(
        @get: JsonValue
        val value: Int,
        val displayName: String
) {
    ALL(1, "所有人"),
    SPECIFIED_USER(2, "指定用户"),
    ;

    override fun toString(): String {
        return value.toString()
    }

    companion object {
        private val map = MentionType.values()
                .map { it.value to it }
                .toMap()

        @JvmStatic
        @JsonCreator
        fun fromValue(value: Int): MentionType {
            return map[value]!!
        }
    }
}