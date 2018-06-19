package cn.staynoob.rc.domain

data class RcUserOnlineStatus(
        val status: String
) {
    fun isOnline() = status == "1"
}
