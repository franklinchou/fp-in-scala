package monoid

object Ten1 {

  val intAddition: Monoid[Int] = new Monoid[Int] {
    def binaryOp(a1: Int, a2: Int): Int = a1 + a2
    val identity: Int = 0
  }

  val intMultiplication: Monoid[Int] = new Monoid[Int] {
    def binaryOp(a1: Int, a2: Int): Int = a1 * a2
    val identity: Int = 1
  }

  val booleanOr: Monoid[Boolean] = new Monoid[Boolean] {
    def binaryOp(a1: Boolean, a2: Boolean): Boolean = a1 || a2
    val identity: Boolean = false
  }

  val booleanAnd: Monoid[Boolean] = new Monoid[Boolean] {
    def binaryOp(a1: Boolean, a2: Boolean): Boolean = a1 && a2
    val identity: Boolean = true
  }

}
