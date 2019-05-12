

object UnitConversions extends App {
  trait UnitConversion{
    def apply(v: Double): Double
  }

  object InchesToCentimeters extends UnitConversion {
    def apply(v: Double) = v * 2.54
  }

  object GallonsToLiters extends UnitConversion {
    def apply(v: Double) = v * 3.78541
  }

  object MilesToKilometers extends UnitConversion {
    def apply(v: Double) = v * 1.60934
  }

}
