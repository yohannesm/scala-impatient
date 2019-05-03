import java.time.LocalDate

object InterpolateDate extends App {
  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
    def date(args: Any*): LocalDate = {
      if(args.length != 3) throw new IllegalArgumentException("3 args required")

      for (x <- sc.parts) if(x.length > 0 && !x.equals("-")) throw new IllegalArgumentException("wrong format")

      LocalDate.of(args(0).asInstanceOf[Int], args(1).asInstanceOf[Int], args(2).asInstanceOf[Int])
    }
  }

  val year = 2012
  val month = 11
  val day = 5

  println(date"$year-$month-$day")
}
