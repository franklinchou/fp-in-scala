package option

object Four5 {

  // Given a list of values, if performing f on all values fails,
  // return None, else return Some with a list of only the values where
  // f is successful.
  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]]  = {
    // TODO: How do I get this into statement, without an assignment?
    val r: List[B] = {
      a.foldLeft[List[B]](List.empty[B]) {
        (acc, i) => f(i).map(v => acc :+ v).getOrElse(acc)
      }
    }

    if (r.isEmpty) {
      None
    } else {
      Some(r)
    }
  }


  def traverse2[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = {
    a.foldLeft[Option[List[B]]](Some(List.empty[B])) {
      (acc, i) => {
        val v: Option[B] = f(i)
        if (v.isDefined) {
          acc.map(l => v.get :: l)
        } else {
          acc
        }
      }
    }
  }



  /**
    * Sequence in terms of traverse [[Four4]]
    */
//  def sequence[A](a: List[Option[A]]): Option[List[A]] = {
//
//  }

}
