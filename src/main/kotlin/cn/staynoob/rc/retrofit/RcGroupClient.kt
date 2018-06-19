package cn.staynoob.rc.retrofit

import cn.staynoob.rc.RcHttpResponse
import cn.staynoob.rc.domain.response.RcGroupQueryResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RcGroupClient {
    @POST("group/create.json")
    @FormUrlEncoded
    fun create(
            @Field("userId") userId: List<String>,
            @Field("groupId") groupId: String,
            @Field("groupName") groupName: String
    ): Call<RcHttpResponse<Unit>>

    @POST("group/join.json")
    @FormUrlEncoded
    fun join(
            @Field("userId") userId: List<String>,
            @Field("groupId") groupId: String,
            @Field("groupName") groupName: String
    ): Call<RcHttpResponse<Unit>>

    @POST("group/quit.json")
    @FormUrlEncoded
    fun quit(
            @Field("userId") userId: List<String>,
            @Field("groupId") groupId: String
    ): Call<RcHttpResponse<Unit>>

    @POST("group/dismiss.json")
    @FormUrlEncoded
    fun dismiss(
            @Field("userId") userId: String,
            @Field("groupId") groupId: String
    ): Call<RcHttpResponse<Unit>>

    @POST("group/refresh.json")
    @FormUrlEncoded
    fun refresh(
            @Field("groupId") groupId: String,
            @Field("groupName") groupName: String
    ): Call<RcHttpResponse<Unit>>

    @POST("group/user/query.json")
    @FormUrlEncoded
    fun query(
            @Field("groupId") groupId: String
    ): Call<RcHttpResponse<RcGroupQueryResponse>>
}