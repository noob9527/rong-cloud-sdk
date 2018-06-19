package cn.staynoob.rc.domain.message.model.base

import cn.staynoob.rc.domain.message.content.RcMessage

interface RcMessageModel<out T : RcMessage> {
    val fromUserId: String
    val toUserId: List<String>
    val content: T
    val objectName: String
        get() = content.type
}