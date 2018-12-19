// A "random number generator" that increments the seed by 1
case class IncrementRng(seed: Int) extends RNG {
  def nextInt: (Int, RNG) = {
    val newSeed = seed + 1
    val nextRng = IncrementRng(newSeed)
    (newSeed, nextRng)
  }
}
