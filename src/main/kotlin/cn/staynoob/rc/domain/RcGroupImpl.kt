package cn.staynoob.rc.domain

data class RcGroupImpl(
        override val rcGroupId: String,
        override val rcGroupName: String,
        override val rcLogo: String?
) : RequestBody, RcGroup