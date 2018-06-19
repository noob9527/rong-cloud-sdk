package cn.staynoob.rc.service

import cn.staynoob.rc.domain.message.model.RcGroupMessage
import cn.staynoob.rc.domain.message.model.RcPrivateMessage
import cn.staynoob.rc.domain.message.model.RcSystemMessage
import cn.staynoob.rc.domain.message.model.RcTemplateMessage

interface RcMessageService {
    fun sendPrivateMessage(message: RcPrivateMessage<*>)

    fun sendSystemMessage(message: RcSystemMessage<*>)

    fun sendGroupMessage(message: RcGroupMessage<*>)

    fun sendSystemTemplateMessage(message: RcTemplateMessage<*>)

    fun sendPrivateTemplateMessage(message: RcTemplateMessage<*>)
}