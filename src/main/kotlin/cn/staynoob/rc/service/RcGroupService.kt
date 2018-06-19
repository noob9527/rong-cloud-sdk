package cn.staynoob.rc.service

import cn.staynoob.rc.domain.response.RcGroupQueryResponse

interface RcGroupService {
    fun create(
            userId: List<String>,
            groupId: String,
            groupName: String
    )

    fun join(
            userId: List<String>,
            groupId: String,
            groupName: String
    )

    fun quit(
            userId: List<String>,
            groupId: String
    )

    fun dismiss(
            userId: String,
            groupId: String
    )

    fun refresh(
            groupId: String,
            groupName: String
    )

    fun query(
            groupId: String
    ): RcGroupQueryResponse
}