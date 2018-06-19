package cn.staynoob.rc.domain.message.model.base

import cn.staynoob.rc.domain.message.content.RcMessage

abstract class AbstractRcMessageModel<out T : RcMessage>(
        val pushContent: String?,
        val pushData: String?
) : RcMessageModel<T>