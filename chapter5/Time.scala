
class Time(private val hours: Int, private val minutes: Int) {
  def before(otherTime: Time) : Boolean = {
    if (hours < otherTime.hours) true
    else if(hours == otherTime.hours) minutes < otherTime.minutes
    else false
  }
}
