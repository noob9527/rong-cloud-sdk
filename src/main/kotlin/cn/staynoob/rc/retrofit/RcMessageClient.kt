package cn.staynoob.rc.retrofit

import cn.staynoob.rc.RcHttpResponse
import cn.staynoob.rc.domain.message.content.RcMessage
import cn.staynoob.rc.domain.message.model.RcTemplateMessage
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RcMessageClient {

    @POST("message/private/publish.json")
    @FormUrlEncoded
    fun privatePublish(
            @Field("fromUserId") fromUserId: String,
            @Field("toUserId") toUserId: List<String>,
            @Field("objectName") objectName: String,
            @Field("content") content: String,
            @Field("pushContent") pushContent: String? = null,
            @Field("pushData") pushData: String? = null,
            @Field("count") count: Int? = null,
            @Field("verifyBlacklist") verifyBlacklist: Int? = null,
            @Field("isPersisted") isPersisted: Int? = null,
            @Field("isCounted") isCounted: Int? = null,
            @Field("isIncludeSender") isIncludeSender: Int? = null,
            @Field("contentAvailable") contentAvailable: Int? = null
    ): Call<RcHttpResponse<Unit>>

    @POST("message/system/publish.json")
    @FormUrlEncoded
    fun systemPublish(
            @Field("fromUserId") fromUserId: String,
            @Field("toUserId") toUserId: List<String>,
            @Field("objectName") objectName: String,
            @Field("content") content: String,
            @Field("pushContent") pushContent: String? = null,
            @Field("pushData") pushData: String? = null,
            @Field("isPersisted") isPersisted: Int? = null,
            @Field("isCounted") isCounted: Int? = null,
            @Field("contentAvailable") contentAvailable: Int? = null
    ): Call<RcHttpResponse<Unit>>

    @POST("message/group/publish.json")
    @FormUrlEncoded
    fun groupPublish(
            @Field("fromUserId") fromUserId: String,
            @Field("toGroupId") toGroupId: List<String>,
            @Field("toUserId") toUserId: List<String>,
            @Field("objectName") objectName: String,
            @Field("content") content: String,
            @Field("pushContent") pushContent: String? = null,
            @Field("pushData") pushData: String? = null,
            @Field("isPersisted") isPersisted: Int? = null,
            @Field("isCounted") isCounted: Int? = null,
            @Field("isIncludeSender") isIncludeSender: Int? = null,
            @Field("isMentioned") isMentioned: Int? = null,
            @Field("contentAvailable") contentAvailable: Int? = null
    ): Call<RcHttpResponse<Unit>>

    @POST("message/private/publish_template.json")
    fun privateTemplatePublish(
            @Body message: @JvmSuppressWildcards RcTemplateMessage<RcMessage>
    ): Call<RcHttpResponse<Unit>>

    @POST("message/system/publish_template.json")
    fun systemTemplatePublish(
            @Body message: @JvmSuppressWildcards RcTemplateMessage<RcMessage>
    ): Call<RcHttpResponse<Unit>>
}