package state


object Six2 {

  /**
    * Function to generate a double between 0 and 1 (not including 1)
    */
  def double(rng: RNG): (Double, RNG) = {
    val (n, r) = rng.nextInt
    if (n == 0) (0, r)
    else if (n == 1) double(r)
    else (Math.abs(1 / n.toDouble), r)
  }

}