package cn.staynoob.rc

import cn.staynoob.rc.util.objectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RcHttpResponseTest {
    data class Foo(val name: String)

    @Test
    @DisplayName("deserialize test")
    fun test100() {
        val json = """
        {
            "code": 0,
            "msg": "msg",
            "name": "foo"
        }
        """.trimIndent()

        val res = objectMapper.readValue<RcHttpResponse<Foo>>(json)

        assertThat(res.code).isEqualTo(0)
        assertThat(res.msg).isEqualTo("msg")
        assertThat(res.data).isEqualTo(Foo("foo"))
    }
}