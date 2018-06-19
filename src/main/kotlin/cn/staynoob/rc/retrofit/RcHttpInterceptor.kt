package cn.staynoob.rc.retrofit

import cn.staynoob.rc.RcProperties
import cn.staynoob.rc.util.CheckSumBuilder
import cn.staynoob.rc.util.generateRandomString
import okhttp3.Interceptor
import okhttp3.Response
import java.time.Instant

internal class RcHttpInterceptor(
        private val properties: RcProperties
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val appKey = properties.appKey!!
        val nonce = generateRandomString()
        val timestamp = Instant.now().toEpochMilli()
        val signature = CheckSumBuilder
                .getCheckSum(properties.appSecret!!, nonce, timestamp)

        val request = original.newBuilder()
                .addHeader("App-Key", appKey)
                .addHeader("Nonce", nonce)
                .addHeader("Timestamp", timestamp.toString())
                .addHeader("Signature", signature)
                .build()

        return chain.proceed(request)
    }
}