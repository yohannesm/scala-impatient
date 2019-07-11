

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

    def *(that: Matrix): Matrix = {
      val (r1, c1) = size
      val (r2, c2) = that.size

      if (c1 != r2) {
        throw new IllegalArgumentException("Matrices can't be multiplied")
      }

      Matrix.init(r1, c2) { (row, col) 
        => (0 until c1).foldLeft(0)( (sum, i) 
          => sum + data(row * c1 + i) * that.data(i * c2 + col))
      }
    }

    def *(value: Int): Matrix = Matrix.init(rows, cols)( (row, col) => this(row, col) * value)

    override def toString = {
      val sb = new StringBuilder
      for (row <- 0 until rows) {
        if (row > 0) {
          sb ++= "\n"
        }

        sb ++= "["
        for (col <- 0 until cols) {
          if (col > 0) {
            sb ++= ", "
          }

          sb.append(data(row * cols + col))
        }
        sb ++= "]"
      }

      sb.toString()
    }
  
  }

  object Matrix {
    def apply(rows: Int, cols: Int)(data: Int*): Matrix = {
      if ((rows * cols) != data.length) {
        throw new IllegalArgumentException("rows cols number and data does not match")
      }

      new Matrix(rows, cols, data.toIndexedSeq)
    }

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
