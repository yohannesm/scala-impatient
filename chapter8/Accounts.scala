

object Accounts extends App {
  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance
    def currentBalance = balance
    def deposit(amount: Double) = {
      balance += amount
      balance
    }
    def withdraw(amount: Double) = {
      balance -= amount
      balance
    }
  }

  class CheckingAccount(initBalance: Double) extends BankAccount(initBalance) {
    val fee = 1
    override def deposit(amount: Double) = {
      super.deposit(amount - fee)
    }

    override def withdraw(amount: Double) = {
      super.withdraw(amount + fee)
    }
  }

  class SavingsAccount(initBalance: Double) extends BankAccount(initBalance) {
    private val monthlyInterest = 0.001
    private val freeTransactionAllowance = 3

    private var currentTransactionCount = 0
    private var balance: Double = initBalance

    def earnMonthlyInterest = {
      currentTransactionCount = 0
      balance = super.deposit(balance * monthlyInterest)
    }

    override def deposit(amount: Double) = {
      super.deposit(amount - fee)
    }

    override def withdraw(amount: Double) = {
      super.deposit(amount + fee)
    }

    private def fee : Double = {
      if(currentTransactionCount < freeTransactionAllowance) {
        currentTransactionCount += 1
        0.0
      }
      1.0
    }
  }

  
  
}
