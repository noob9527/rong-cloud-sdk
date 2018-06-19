package cn.staynoob.rc.domain.message.model

import cn.staynoob.rc.domain.message.content.RcMessage
import cn.staynoob.rc.domain.message.model.base.RcMessageModel
import cn.staynoob.rc.util.BooleanToIntConverter
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

class RcTemplateMessage<out T : RcMessage>(

        override val fromUserId: String,

        @get: JsonIgnore
        override val content: T,

        @get:JsonIgnore
        val entries: List<MessageEntry>,

        /**
         * 是否过滤接收用户黑名单列表，0 表示为不过滤、 1 表示为过滤
         * 默认为 0 不过滤。(可选)
         */
        @get:JsonSerialize(converter = BooleanToIntConverter::class)
        var verifyBlacklist: Boolean? = false,

        /**
         * 针对 iOS 平台，对 SDK 处于后台暂停状态时为静默推送
         * 是 iOS7 之后推出的一种推送方式。
         * 允许应用在收到通知后在后台运行一段代码，且能够马上执行
         * 查看详细。1 表示为开启，0 表示为关闭，默认为 0（可选）
         */
        @get:JsonSerialize(converter = BooleanToIntConverter::class)
        val contentAvailable: Boolean = false
) : RcMessageModel<T> {

    /**
     * rong cloud server doesn't accept json like {"content":""}
     * I have to escape this double-quote like {\"content\":\"\"}
     */
    @get: JsonProperty("content")
    val contentString = content.toJson()

    data class MessageEntry(
            val toUserId: String,
            val value: Map<String, String?>,
            val pushContent: String,
            val pushData: String? = null
    )

    override val toUserId: List<String>
        get() = entries.map { it.toUserId }

    val values: List<Map<String, String?>>
        get() = entries.map { it.value.mapKeys { (key, _) -> "{$key}" } }

    val pushContent: List<String>
        get() = entries.map { it.pushContent }

    val pushData: List<String?>
        get() = entries.map { it.pushData }
}