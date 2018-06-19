package cn.staynoob.rc.util

import cn.staynoob.rc.RcApiException
import cn.staynoob.rc.RcHttpException
import cn.staynoob.rc.RcHttpResponse
import cn.staynoob.rc.domain.FieldsMap
import com.fasterxml.jackson.module.kotlin.readValue
import io.rong.models.Result
import retrofit2.Call
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.reflect.full.memberProperties

internal val paramDateFormatter = DateTimeFormatter
        .ofPattern("yyyyMMddHHmmss")
        .withLocale(Locale.getDefault())
        .withZone(ZoneId.systemDefault())

internal fun Boolean?.toInt(): Int? {
    return this?.let { if (it) 1 else 0 }
}

internal fun Any.internalToFieldsMap(): FieldsMap {
    return this::class.memberProperties
            .map { it.name to it.getter.call(this)?.toString() }
            .toMap()
}

internal fun <T : Result> T.assertOk(): T {
    if (code != 200) {
        throw RcApiException(code, msg)
    }
    return this
}

internal fun <T> Call<out RcHttpResponse<T>>.exec(): RcHttpResponse<T> {
    val res = this.execute()
    if (!res.isSuccessful) {
        val errMsg = res.errorBody()?.string()
        if (errMsg == null) {
            throw RcHttpException(res.code(), res.message())
        } else {
            val response = try {
                objectMapper
                        .readValue<RcHttpResponse<Any>>(errMsg)
            } catch (e: Exception) {
                throw RcHttpException(res.code(), res.message())
            }
            throw RcApiException(response.code, response.msg)
        }
    }
    val body = res.body()!!
    if (body.code != 200) {
        throw RcApiException(body.code, body.msg)
    }
    return body
}

internal fun <T> Call<out RcHttpResponse<T>>.toData(): T {
    return this.exec().data!!
}
