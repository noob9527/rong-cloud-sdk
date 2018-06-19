package cn.staynoob.rc.domain

data class RcUserImpl(
        override val rcId: String,
        override val rcName: String,
        override val rcPortrait: String
) : RequestBody, RcUser
