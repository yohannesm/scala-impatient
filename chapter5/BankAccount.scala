import java.lang._

class BankAccount {
  private var amount = 0.0
  def deposit( amt : Double ) = amount += amt
  def withdraw( amt: Double ) : Unit = {
    if( amt > amount) throw new RuntimeException("withdraw amount exceed balance")
    amount -= amt
  }

  def balance = amount
}
