package cn.staynoob.rc

class RcApiException(
        val code: Int,
        message: String?
) : RuntimeException(message)