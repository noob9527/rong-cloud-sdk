package cn.staynoob.rc

import cn.staynoob.rc.kotlin.KotlinAllOpen
import cn.staynoob.rc.kotlin.NoArgConstructor
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated
import javax.annotation.PostConstruct
import javax.validation.constraints.NotNull

@NoArgConstructor
@Validated
@KotlinAllOpen
@ConfigurationProperties(prefix = "rong-cloud")
data class RcProperties(
        @get: NotNull
        var appKey: String? = null,
        @get: NotNull
        var appSecret: String? = null,
        var apiUrl: String? = null,
        var logLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.NONE
) {

    /**
     * somehow kotlin default param doesn't work
     */
    @Suppress("SENSELESS_COMPARISON")
    @PostConstruct
    private fun init() {
        if (logLevel == null) logLevel = HttpLoggingInterceptor.Level.NONE
        if (apiUrl == null) apiUrl = "http://api.cn.ronghub.com"
    }
}