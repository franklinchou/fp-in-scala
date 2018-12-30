package option

object Four4 {

  // If a contains None even once, the result of this function
  // should be None, else the result should be the flattened list
  // wrapped inside Some
  def sequence[A](a: List[Option[A]]): Option[List[A]] = {
    val r = {
      a.foldLeft(List.empty[A]) {
        (acc, item) => item.map(v => acc :+ v).getOrElse(return None)
      }
    }
    Some(r)
  }

  // for use in sequence with map
  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    for {
      as <- a
      bs <- b
    } yield f(as, bs)
  }

  // Left arity
  // Here, the items are folded from left to right, the accumulator is,
  // as specified by arg z, an empty list. On the first pass of the fold `:+`
  // is used to append the first element in `a` to the empty list (arg z).
  def sequenceWithMapL[A](a: List[Option[A]]): Option[List[A]] = {
    // In fold left, the first item is arg z
    a.foldLeft[Option[List[A]]](Some(List.empty[A])) {
      (acc, i) => map2(acc, i)(_ :+ _)
    }
  }

  // Right arity
  // Here, the items are folded from right to left, the first item is an
  // item of the list itself, therefore the `::` can be used.
  // Simply put:
  // List() :: 2 doesn't work
  // 2 :: List() works
  def sequenceWithMapR[A](a: List[Option[A]]): Option[List[A]] = {
    // In fold right, the first item is the right most item in the list
    a.foldRight[Option[List[A]]](Some(List.empty[A])) {
      (i, acc) => map2(i, acc)(_ :: _)
    }
  }

}
