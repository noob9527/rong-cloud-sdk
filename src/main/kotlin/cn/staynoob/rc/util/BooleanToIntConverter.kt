package cn.staynoob.rc.util

import com.fasterxml.jackson.databind.util.StdConverter

class BooleanToIntConverter : StdConverter<Boolean?, Int?>() {
    override fun convert(value: Boolean?): Int? {
        return value.toInt()
    }
}