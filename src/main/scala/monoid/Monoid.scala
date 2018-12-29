package monoid

trait Monoid[A] {

  def binaryOp(a1: A, a2: A): A

  val identity: A

}
