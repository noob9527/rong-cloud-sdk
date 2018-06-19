package cn.staynoob.rc

class RcHttpException(
        val status: Int,
        message: String?
) : RuntimeException(message)