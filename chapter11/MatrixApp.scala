

object MatrixApp extends App {
  
  class Matrix private(private val rows: Int, private val cols: Int, private val data: IndexedSeq[Int] ) {

    def apply(row: Int, col: Int): Int = data(row * cols + col)

    def size: (Int, Int) = (rows, cols)
    
    def +(that: Matrix): Matrix = {
      val thisSize = this.size
      if(thisSize != that.size) {
        throw new IllegalArgumentException("diff size matrices")
      }

      Matrix.init(rows, cols)( (row, col) => this(row, col) + that(row, col))
    }
  
  }

  object Matrix {
    private def init(rows: Int, cols: Int)(op: (Int, Int) => Int): Matrix = {
      val data = new Array[Int](rows * cols)
      for( row <- 0 until rows) {
        for( col <- 0 until cols) {
          data(row * cols + col) = op(row, col)
        }
      }

      new Matrix(rows, cols, data)
    }
  }


}
