package cn.staynoob.rc.domain.message.model

import cn.staynoob.rc.domain.message.content.RcMessage
import cn.staynoob.rc.domain.message.model.base.AbstractRcMessageModel

class RcPrivateMessage<out T : RcMessage>(
        override val fromUserId: String,
        override val toUserId: List<String>,
        override val content: T,
        pushContent: String? = null,
        pushData: String? = null,
        val count: Int? = null,
        /**
         * 是否过滤接收用户黑名单列表，0 表示为不过滤、 1 表示为过滤
         * 默认为 0 不过滤。(可选)
         */
        val verifyBlacklist: Boolean = false,
        /**
         * 发送用户自己是否接收消息，0 表示为不接收，1 表示为接收
         * 默认为 0 不接收，只有在 toUserId 为一个用户 Id 的时候有效。（可选）
         */
        val includeSender: Boolean = false,
        /**
         * 针对用户当前使用的客户端版本，如果没有对应 objectName 赋值的消息类型时
         * 客户端收到消息后是否进行存储，0 表示为不存储、 1 表示为存储
         * 默认为 1 存储消息。(可选)
         */
        val isPersisted: Boolean = true,
        /**
         * 针对用户当前使用的客户端版本，如果没有对应 objectName 赋值的消息类型时
         * 客户端收到消息后是否进行未读消息计数，0 表示为不计数、 1 表示为计数
         * 默认为 1 计数，未读消息数增加 1。(可选)
         */
        val isCounted: Boolean = true,
        /**
         * 针对 iOS 平台，对 SDK 处于后台暂停状态时为静默推送
         * 是 iOS7 之后推出的一种推送方式。
         * 允许应用在收到通知后在后台运行一段代码，且能够马上执行
         * 查看详细。1 表示为开启，0 表示为关闭，默认为 0（可选）
         */
        val contentAvailable: Boolean = false
) : AbstractRcMessageModel<T>(pushContent, pushData)
