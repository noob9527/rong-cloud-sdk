package cn.staynoob.rc.domain.message.content.mention

data class Mention(
        val type: MentionType,
        val userIdList: List<String>,
        val mentionedContent: String
)