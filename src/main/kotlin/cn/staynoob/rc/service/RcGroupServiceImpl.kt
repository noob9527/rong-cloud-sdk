package cn.staynoob.rc.service

import cn.staynoob.rc.domain.response.RcGroupQueryResponse
import cn.staynoob.rc.retrofit.RcGroupClient
import cn.staynoob.rc.util.exec
import cn.staynoob.rc.util.toData

class RcGroupServiceImpl(
        private val rcGroupClient: RcGroupClient
) : RcGroupService {
    override fun create(userId: List<String>, groupId: String, groupName: String) {
        rcGroupClient.create(userId, groupId, groupName).exec()
    }

    override fun join(userId: List<String>, groupId: String, groupName: String) {
        rcGroupClient.join(userId, groupId, groupName).exec()
    }

    override fun quit(userId: List<String>, groupId: String) {
        rcGroupClient.quit(userId, groupId).exec()
    }

    override fun dismiss(userId: String, groupId: String) {
        rcGroupClient.dismiss(userId, groupId).exec()
    }

    override fun refresh(groupId: String, groupName: String) {
        rcGroupClient.refresh(groupId, groupName).exec()
    }

    override fun query(groupId: String): RcGroupQueryResponse {
        return rcGroupClient.query(groupId).toData()
    }

}