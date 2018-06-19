package cn.staynoob.rc.autoconfigure

import cn.staynoob.rc.RcProperties
import cn.staynoob.rc.retrofit.RcGroupClient
import cn.staynoob.rc.retrofit.RcHttpInterceptor
import cn.staynoob.rc.retrofit.RcMessageClient
import cn.staynoob.rc.retrofit.RcUserClient
import cn.staynoob.rc.service.*
import cn.staynoob.rc.util.objectMapper
import io.rong.RongCloud
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.boot.autoconfigure.AutoConfigureOrder
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Configuration
@AutoConfigureOrder
@EnableConfigurationProperties(RcProperties::class)
class RcAutoConfiguration(
        properties: RcProperties
) {

    private val loggingInterceptor = HttpLoggingInterceptor()
            .apply {
                level = properties.logLevel
            }

    private val apiClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(RcHttpInterceptor(properties))
            .build()

    private val apiRetrofit = Retrofit.Builder()
            .baseUrl(properties.apiUrl!!)
            .addConverterFactory(jacksonConverterFactory)
            .client(apiClient)
            .build()

    companion object {
        private val jacksonConverterFactory =
                JacksonConverterFactory.create(objectMapper)
    }

    private val rongCloud = RongCloud
            .getInstance(properties.appKey, properties.appSecret)

    @Bean
    @ConditionalOnMissingBean
    fun rongCloud(): RongCloud {
        return rongCloud
    }

    @Bean
    @ConditionalOnMissingBean
    fun userService(): RcUserService {
        return RcUserServiceImpl(apiRetrofit.create(RcUserClient::class.java))
    }

    @Bean
    @ConditionalOnMissingBean
    fun messageService(): RcMessageService {
        return RcMessageServiceImpl(apiRetrofit.create(RcMessageClient::class.java), rongCloud)
    }

    @Bean
    @ConditionalOnMissingBean
    fun groupService(): RcGroupService {
        return RcGroupServiceImpl(apiRetrofit.create(RcGroupClient::class.java))
    }
}