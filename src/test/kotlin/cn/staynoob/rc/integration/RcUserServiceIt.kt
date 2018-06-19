package cn.staynoob.rc.integration

import cn.staynoob.rc.service.RcUserService
import cn.staynoob.rc.support.IntegrationTestBase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class RcUserServiceIt : IntegrationTestBase() {

    @Autowired
    private lateinit var service: RcUserService

    @Test
    @DisplayName("getToken test")
    fun test100() {
        val res = service.getToken(
                testUser1.rcId,
                testUser1.rcName,
                testUser1.rcPortrait
        )
        assertThat(res.userId).isEqualTo(testUser1.rcId)
        assertThat(res.token).isNotEmpty()
    }

    @Test
    @DisplayName("refresh test")
    fun test200() {
        service.refresh(
                testUser1.rcId,
                "foo",
                testUser1.rcPortrait
        )
    }

    @Test
    @DisplayName("user online test")
    fun test300() {
        service.checkOnline(testUser1.rcId)
    }
}