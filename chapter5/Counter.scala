class Counter {

  private var value = 0
  def increment() {
    value = if(value == Int.MaxValue) Int.MaxValue 
            else value + 1
  }

  def current = value
}
