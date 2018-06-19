package cn.staynoob.rc.integration

import cn.staynoob.rc.domain.message.content.RcTxtMessage
import cn.staynoob.rc.domain.message.model.RcGroupMessage
import cn.staynoob.rc.domain.message.model.RcPrivateMessage
import cn.staynoob.rc.domain.message.model.RcSystemMessage
import cn.staynoob.rc.domain.message.model.RcTemplateMessage
import cn.staynoob.rc.service.RcMessageService
import cn.staynoob.rc.support.IntegrationTestBase
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class RcMessageServiceIt : IntegrationTestBase() {

    @Autowired
    private lateinit var service: RcMessageService

    @Test
    @DisplayName("send private message test")
    fun test100() {
        val message = RcPrivateMessage(
                fromUserId = testUser1.rcId,
                toUserId = listOf(testUser2.rcId),
                content = RcTxtMessage("content")
        )
        service.sendPrivateMessage(message)
    }

    @Test
    @DisplayName("send system message test")
    fun test200() {
        val message = RcSystemMessage(
                fromUserId = testUser1.rcId,
                toUserId = listOf(testUser2.rcId),
                content = RcTxtMessage("content")
        )
        service.sendSystemMessage(message)
    }

    @Test
    @DisplayName("send group message test")
    fun test250() {
        val message = RcGroupMessage(
                fromUserId = testUser1.rcId,
                toGroupId = listOf(testGroup1.rcGroupId),
                content = RcTxtMessage("content")
        )
        service.sendGroupMessage(message)
    }

    @Test
    @DisplayName("send private template message test")
    fun test300() {
        val placeholder = "{foo}{bar}"
        val template = RcTemplateMessage(
                fromUserId = testUser1.rcId,
                content = RcTxtMessage(placeholder),
                entries = listOf(
                        RcTemplateMessage.MessageEntry(
                                toUserId = testUser2.rcId,
                                value = mapOf(
                                        "foo" to "foo2",
                                        "bar" to "bar2"
                                ),
                                pushContent = placeholder,
                                pushData = placeholder
                        ),
                        RcTemplateMessage.MessageEntry(
                                toUserId = testUser3.rcId,
                                value = mapOf(
                                        "foo" to "foo3",
                                        "bar" to "bar3"
                                ),
                                pushContent = placeholder,
                                pushData = placeholder
                        )
                )
        )
        service.sendPrivateTemplateMessage(template)
    }

    @Test
    @DisplayName("send system template message test")
    fun test400() {
        val placeholder = "{foo}{bar}"
        val template = RcTemplateMessage(
                fromUserId = testUser1.rcId,
                content = RcTxtMessage(placeholder),
                entries = listOf(
                        RcTemplateMessage.MessageEntry(
                                toUserId = testUser2.rcId,
                                value = mapOf(
                                        "foo" to "foo2",
                                        "bar" to "bar2"
                                ),
                                pushContent = placeholder,
                                pushData = placeholder
                        ),
                        RcTemplateMessage.MessageEntry(
                                toUserId = testUser3.rcId,
                                value = mapOf(
                                        "foo" to "foo3",
                                        "bar" to "bar3"
                                ),
                                pushContent = placeholder,
                                pushData = placeholder
                        )
                )
        )
        service.sendSystemTemplateMessage(template)
    }
}