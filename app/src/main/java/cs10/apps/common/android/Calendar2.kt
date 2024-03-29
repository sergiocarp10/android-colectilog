package cs10.apps.common.android

import java.util.*

class Calendar2 {

    companion object {

        fun getDate() : Triple<Int, Int, Int> {
            val cal = Calendar.getInstance()
            return Triple(cal[Calendar.YEAR], cal[Calendar.MONTH]+1, cal[Calendar.DAY_OF_MONTH])
        }

        fun getETA(minutesOffset: Int) : Calendar {
            return getETA(Calendar.getInstance(), minutesOffset)
        }

        fun getETA(from: Calendar, minutesOffset: Int) : Calendar {
            from.add(Calendar.MINUTE, minutesOffset)
            return from
        }
    }
}