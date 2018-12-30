package option

import scala.util.Try


// Misunderstood what the prompt was asking for.
// My behaviour:
// List("123", "456", "cat") => Some(List("123", "456"))
// The intended behaviour is:
// List("123", "456", "cat") => None
// List("123", "456") => Some(List(123, 456))
@deprecated("Use Four5R", "")
object Four5 {


  // given a list of string values parsed to option int
  def parseInts(a: List[String]): Option[List[Int]] = {
    sequence[Int](a.map(i => Try(i.toInt).toOption))
  }


  // Given a list of values, if performing f on all values fails,
  // return None, else return Some with a list of only the values where
  // f is successful.
  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = {
    // TODO: Can I do this without an intermediate assignment?
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

  def traverse2[A, B](l: List[A])(f: A => Option[B]): Option[List[B]] = {
    val all: List[B] = {
      for {
        i <- l
        v <- f(i)
      } yield v
    }
    all match {
      case _ :: _ => Some(all)
      case Nil => None
    }
  }

  // traverse using fold in one line
  def traverseFold1[A, B](l: List[A])(f: A => Option[B]): Option[List[B]] = {
    // Recall that in foldRight, the first item to be processed is the
    // last item in the list. The items are processed from the last item
    // RIGHT into the accumulator
    l.foldRight[Option[List[B]]](Some(Nil)) {
      (i, acc) =>
        Four4.map2(f(i), acc)(_ :: _)
    }
  }


  /**
    * Sequence [[Four4]] in terms of traverse
    */
  def sequence[A](a: List[Option[A]]): Option[List[A]] = {
    // traverse accepts List[A]
    traverse(a)(x => x) // why?
  }

}
