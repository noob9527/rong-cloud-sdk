package cn.staynoob.rc.service

import cn.staynoob.rc.domain.RcToken
import cn.staynoob.rc.domain.RcUser
import cn.staynoob.rc.domain.RcUserOnlineStatus

interface RcUserService {
    fun getToken(
            id: String,
            name: String,
            portrait: String
    ): RcToken

    fun getToken(user: RcUser): RcToken = getToken(user.rcId, user.rcName, user.rcPortrait)

    fun refresh(
            id: String,
            name: String,
            portrait: String
    )

    fun refresh(user: RcUser) = refresh(user.rcId, user.rcName, user.rcPortrait)

    fun checkOnline(userId: String): RcUserOnlineStatus
}