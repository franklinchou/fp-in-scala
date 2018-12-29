package option

object Four3 {


  // Generic function that combines two Option values using
  // a binary function. If either option is None, then the return
  // value is None.
  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    (a, b) match {
      case (None, Some(_)) => None
      case (Some(_), None) => None
      case (None, None) => None
      case (Some(as), Some(bs)) => Some(f(as, bs))
    }
  }

  def map2yield[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    for {
      as <- a
      bs <- b
    } yield f(as, bs)
  }
}
