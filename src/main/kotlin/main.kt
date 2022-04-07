package ru.netology

const val MINUTE = 60
const val HOUR = MINUTE * 60
const val DAY = HOUR * 24
const val TODAY = DAY * 2
const val YESTERDAY = TODAY * 3

fun main() {
    agoToText()
}

fun agoToText() {
    val seconds = readLine()!!.toInt()
    println("${timeInterval(seconds)}")
}

fun timeInterval(
    seconds: Int,
    minute: Int = seconds / 60,
    hour: Int = minute / 60
): String = when (seconds) {
    in 0..60 -> "был(а) в сети только что"
    in MINUTE + 1..HOUR -> "был(а) в сети $minute ${endOfMinutes(minute)} назад"
    in HOUR + 1..DAY -> "был(а) в сети $hour ${endOfHours(hour)} назад"
    in DAY + 1..TODAY -> "был(а) в сети сегодня"
    in TODAY + 1..YESTERDAY -> "был(а) в сети вчера"
    else -> "был(а) в сети давно"
}

fun endOfHours(hour: Int): String = when (hour) {
    1, 21 -> "час"
    in 2..4, in 22..24 -> "часа"
    else -> "часов"
}

fun endOfMinutes(minute: Int): String = when (minute) {
    in 5..20,
    in 25..30,
    in 35..40,
    in 45..50,
    in 55..60 -> "минут"
    1, 21, 31, 41, 51 -> "минуту"
    else -> "минуты"
}


