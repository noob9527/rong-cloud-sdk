package cn.staynoob.rc.retrofit

import cn.staynoob.rc.RcHttpResponse
import cn.staynoob.rc.domain.RcToken
import cn.staynoob.rc.domain.RcUserOnlineStatus
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RcUserClient {
    @POST("user/getToken.json")
    @FormUrlEncoded
    fun getToken(
            @Field("userId") userId: String,
            @Field("name") name: String,
            @Field("portrait") portrait: String
    ): Call<RcHttpResponse<RcToken>>

    @POST("user/refresh.json")
    @FormUrlEncoded
    fun refresh(
            @Field("userId") userId: String,
            @Field("name") name: String,
            @Field("portrait") portrait: String
    ): Call<RcHttpResponse<Unit>>

    @POST("user/checkOnline.json")
    @FormUrlEncoded
    fun checkOnline(
            @Field("userId") userId: String
    ): Call<RcHttpResponse<RcUserOnlineStatus>>
}