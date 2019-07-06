

object CryptoLoggerApp extends App {
  trait Logger {
    def log(msg: String): Unit
  }

  trait ConsoleLogger extends Logger {
    override def log(msg: String): Unit = println(msg)
  }

  trait CryptoLogger extends Logger {
    val key = 3
    abstract override def log(msg: String): Unit = {
      super.log(encrypt(msg))
    }

    def encrypt(msg: String): String = {
      msg.map((c: Char) => (c + key).toChar)
    }
  }

  class ConcreteLogger extends ConsoleLogger{}

  def logger1 = new ConcreteLogger
  def logger2 = new ConcreteLogger with CryptoLogger
  def logger3 = new ConcreteLogger with CryptoLogger {override val key = -3 }
  logger1.log("Hello World!") // Hello World!
  logger2.log("Hello World!") // Khoor#Zruog$
  logger3.log("Khoor#Zruog$") // Hello World!
  
}
