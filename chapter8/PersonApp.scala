

object PersonApp extends App {
  class Person(val name: String) {
    override def toString = s"${getClass.getName}[name=$name]"
  }

  class SecretAgent(codename: String) extends Person(codename) {
    override val name = "secret"
    override val toString = "*redacted"
  }
}
