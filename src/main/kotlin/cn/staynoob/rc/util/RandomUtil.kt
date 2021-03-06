package cn.staynoob.rc.util

import java.util.*

private const val upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
private val lower = upper.toLowerCase(Locale.ROOT)
private const val digits = "0123456789"
private val candidate = upper + lower + digits;

fun generateRandomString(length: Int = 16, random: Random? = null): String {
    val rand = random ?: Random()
    val charArray = CharArray(length)
    for (i in 0 until length) {
        charArray[i] = candidate[rand.nextInt(candidate.length)]
    }
    return String(charArray)
}