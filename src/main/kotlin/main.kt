package ru.netology

const val MINUTE = 60
const val HOUR = MINUTE * 60
const val DAY = HOUR * 24
const val TODAY = DAY * 2
const val YESTERDAY = TODAY * 3

fun main() {
    val seconds = readLine()!!.toInt()
    val minute = seconds / 60
    val hour = minute / 60
    val textHour = endOfHours(hour)
    val textMinute = endOfMinutes(minute)
    val agoToTexn = timeInterval(seconds, textHour, hour, textMinute, minute)
    println("$agoToTexn")
}

fun timeInterval(
    seconds: Int,
    textHour: String,
    hour: Int,
    textMinute: String,
    minute: Int
): String = when (seconds) {
    in 0..60 -> "был(а) в сети только что"
    in MINUTE + 1..HOUR -> "был(а) в сети $minute $textMinute назад"
    in HOUR + 1..DAY -> "был(а) в сети $hour $textHour назад"
    in DAY + 1..TODAY -> "был(а) в сети сегодня"
    in TODAY + 1..YESTERDAY -> "был(а) в сети вчера"
    else -> "был(а) в сети давно"
}

fun endOfHours(hour: Int): String = when {
    hour == 1 || hour == 21 -> "час"
    hour == 2 || hour == 3 || hour == 4 ||
            hour == 22 || hour == 23 || hour == 24 -> "часа"
    else -> "часов"
}

fun endOfMinutes(minute: Int): String = when {
    minute >= 5 && minute < 21 -> "минут"
    minute == 1 || minute % 10 == 1 -> "минуту"
    minute == 2 || minute == 3 || minute == 4 ||
            minute % 10 == 2 || minute % 10 == 3 || minute % 10 == 4 -> "минуты"
    else -> "минут"
}


