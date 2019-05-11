import java.lang.Exception._

class Person(fullName: String, inputAge: Int) {
  var age: Int = if(inputAge < 0 ) 0 else inputAge
  
  val (firstName, lastName) = fullName.split(" ") match {
    case Array(f: String, l: String, _*) => (f, l)
    case _ => throw new RuntimeException("invalid constructor name arguments")
  }
}
