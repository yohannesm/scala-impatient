

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

  class FactorConversion(val factor: Double) {
    def convert(value: Double): Double = factor * value
  }

  object inchToCm extends FactorConversion(2.54)
  object GalToLtr extends FactorConversion(3.78541178)
  object MilesToKm extends FactorConversion(1.609344)

}
