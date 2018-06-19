package cn.staynoob.rc.domain.message.content

import com.fasterxml.jackson.annotation.JsonIgnore

class RcTxtMessage(
        val content: String,
        val extra: String? = null
) : RcMessage {
    @get: JsonIgnore
    override val type: String = RcMessageType.TXT.value
}