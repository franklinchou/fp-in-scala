package option

object Four5R {

  def traverse[A, B](l: List[A])(f: A => Option[B]): Option[List[B]] = {
    // Recall that in foldRight, the first item to be processed is the
    // last item in the list. The items are processed from the last item
    // RIGHT into the accumulator
    l.foldRight[Option[List[B]]](Some(Nil)) {
      (i, acc) => Four4.map2(f(i), acc)(_ :: _)
    }
  }


  // Use foldLeft just for fun
  def traverseL[A, B](l: List[A])(f: A => Option[B]): Option[List[B]] = {
    l.foldLeft[Option[List[B]]](Some(Nil)) {
      (acc, i) =>
        // the accumulator is type Option(List())
        // f(i) is of type Option(item)
        // map2, takes two types (a, b) wrapped in option and creates
        // a new option that combines a with b, given f
        Four4.map2(acc, f(i))(_ :+ _)
    }
  }

  def sequenceViaTraversal[A](a: List[Option[A]]): Option[List[A]] = {
    // since each element in a is an Option[A], the function to map
    // each element to A => Option[B], is simply to examine each element
    // List(Some("a"), Some("b")).map(x => x)
    traverse(a)(x => x)
  }

}
