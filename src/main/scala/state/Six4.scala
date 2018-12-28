package state

object Six4 {

  // model this off the tail recursive function in 6-3
  private def recursiveInt(rng: RNG,
                           times: Int,
                           result: List[Int] = List.empty[Int]): (List[Int], RNG) = {

    if (times > 0) {
      val (int, rngNext) = rng.nextInt
      val l = int :: result
      recursiveInt(rngNext, times - 1, l)
    } else {
      (result, rng)
    }
  }


  // 6-4, p. 83
  // generate an arbitrarily long list of pseudo-random integers
  def ints(count: Int, rng: RNG): (List[Int], RNG) = {
    recursiveInt(rng, count)
  }

}
