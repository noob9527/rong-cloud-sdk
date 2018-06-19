package cn.staynoob.rc.service

import cn.staynoob.rc.domain.message.model.RcGroupMessage
import cn.staynoob.rc.domain.message.model.RcPrivateMessage
import cn.staynoob.rc.domain.message.model.RcSystemMessage
import cn.staynoob.rc.domain.message.model.RcTemplateMessage
import cn.staynoob.rc.retrofit.RcMessageClient
import cn.staynoob.rc.util.exec
import cn.staynoob.rc.util.toInt
import io.rong.RongCloud

class RcMessageServiceImpl(
        private val rcMessageClient: RcMessageClient,
        private val rongCloud: RongCloud
) : RcMessageService {
    override fun sendPrivateMessage(message: RcPrivateMessage<*>) {
        rcMessageClient.privatePublish(
                message.fromUserId,
                message.toUserId,
                message.objectName,
                message.content.toJson(),
                message.pushContent,
                message.pushData,
                message.count,
                message.verifyBlacklist.toInt(),
                message.isPersisted.toInt(),
                message.isCounted.toInt(),
                message.includeSender.toInt(),
                message.contentAvailable.toInt()
        ).exec()
    }

    override fun sendSystemMessage(message: RcSystemMessage<*>) {
        rcMessageClient.systemPublish(
                message.fromUserId,
                message.toUserId,
                message.objectName,
                message.content.toJson(),
                message.pushContent,
                message.pushData,
                message.isPersisted.toInt(),
                message.isCounted.toInt(),
                message.contentAvailable.toInt()
        ).exec()
    }

    override fun sendGroupMessage(message: RcGroupMessage<*>) {
        rcMessageClient.groupPublish(
                message.fromUserId,
                message.toGroupId,
                message.toUserId,
                message.objectName,
                message.content.toJson(),
                message.pushContent,
                message.pushData,
                message.isPersisted.toInt(),
                message.isCounted.toInt(),
                message.isIncludeSender.toInt(),
                message.isMentioned.toInt(),
                message.contentAvailable.toInt()
        ).exec()
    }

    override fun sendSystemTemplateMessage(message: RcTemplateMessage<*>) {
        rcMessageClient.systemTemplatePublish(message).exec()
    }

    override fun sendPrivateTemplateMessage(message: RcTemplateMessage<*>) {
        rcMessageClient.privateTemplatePublish(message).exec()
    }

}