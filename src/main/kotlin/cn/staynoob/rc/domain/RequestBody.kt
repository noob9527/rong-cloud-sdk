package cn.staynoob.rc.domain

import cn.staynoob.rc.util.internalToFieldsMap

interface RequestBody {
    fun toFieldsMap(): FieldsMap {
        return this.internalToFieldsMap()
    }
}