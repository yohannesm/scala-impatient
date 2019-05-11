
class Time2(private val hours: Int, private val minutes: Int) {
  private val totalMinutes: Int = (hours * 60) + minutes

  def before(otherTime: Time2): Boolean = {
    this.totalMinutes < otherTime.totalMinutes
  }
}
