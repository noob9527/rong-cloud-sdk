package cn.staynoob.rc.domain.message.content

import cn.staynoob.rc.domain.message.content.mention.Mention

interface RcGroupMessageContent : RcMessage {
    val mentionedInfo: Mention
}