package state


object Six3 {

  // Limited to positive values between 0 (inclusive) and 1 (non-inclusive).
  private def double(int: Int): Double = {
    int / Int.MaxValue.toDouble + 1
  }

  def intDouble(rng: RNG): ((Int, Double), RNG) = {
    val (int, r) = rng.nextInt
    val dbl: Double = double(int)
    ((int, dbl), r)
  }

  def doubleInt(rng: RNG): ((Double, Int), RNG) = {
    val (values, newRng) = intDouble(rng)
    ((values._2, values._1), newRng)
  }

  private def recursiveDbl(rng: RNG,
                           times: Int = 3,
                           result: List[Double] = List.empty[Double]): (List[Double], RNG) = {
    if (times > 0) {
      val (int, rngNext) = rng.nextInt
      val dbl = double(int)
      val l: List[Double] =  dbl :: result
      recursiveDbl(rngNext, times - 1, l)
    } else {
      (result, rng)
    }
  }


  def double3(rng: RNG): ((Double, Double, Double), RNG) = {

    val acc = recursiveDbl(rng)

    // NOTE: Generally this is ill advised because a list's length is
    // unknown, while a tuple's length is set at instantiation.
    val ds: (Double, Double, Double) = acc._1 match {
      case List(a: Double, b: Double, c: Double) => (a, b, c)
      case _ => (0, 0, 0)
    }

    (ds, acc._2)
  }

}
