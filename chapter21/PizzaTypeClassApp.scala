

object PizzaTypeClassApp extends App{
  type CrustSize = Int
  type CrustType = String
  type Topping = String

  case class Pizza(
    crustSize: CrustSize,
    crustType: CrustType,
    toppings: Seq[Topping]
  )

  trait PizzaService {
    def addTopping(p: Pizza, t: Topping): Pizza = ???
    def removeTopping(p: Pizza, t: Topping): Pizza = ???
    def removeAllTopping(p: Pizza): Pizza = ???
  }
}
