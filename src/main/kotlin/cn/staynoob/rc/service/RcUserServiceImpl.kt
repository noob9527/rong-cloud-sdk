package cn.staynoob.rc.service

import cn.staynoob.rc.domain.RcToken
import cn.staynoob.rc.domain.RcUserOnlineStatus
import cn.staynoob.rc.retrofit.RcUserClient
import cn.staynoob.rc.util.exec
import cn.staynoob.rc.util.toData

class RcUserServiceImpl(
        private val rcUserClient: RcUserClient
) : RcUserService {

    override fun getToken(id: String, name: String, portrait: String): RcToken {
        return rcUserClient.getToken(
                id,
                name,
                portrait
        ).toData()
    }

    override fun refresh(id: String, name: String, portrait: String) {
        rcUserClient.refresh(
                id,
                name,
                portrait
        ).exec()
    }

    override fun checkOnline(userId: String): RcUserOnlineStatus {
        return rcUserClient.checkOnline(userId).toData()
    }

}