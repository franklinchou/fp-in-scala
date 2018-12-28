package state

object Six5 {

  type Rand[+A] = RNG => (A, RNG)

  val int: Rand[Int] = _.nextInt

  def unit[A](a: A): Rand[A] = {
    rng => (a, rng)
  }

  def map[A, B](s: Rand[A])(f: A => B): Rand[B] = {
    rng => {
      val(a, rng2) = s(rng)
      (f(a), rng2)
    }
  }

  // Generate even int greater than or equal to zero
  def nonNegativeEven: Rand[Int] = {
    map(Six1.nonNegativeInt)(i => i - i % 2)
  }

  // Use map to reimplement double in a more elegant way
  // Generate a double between 0 and 1 (not including 1)
  def double(rng: RNG): Rand[Double] = {
    // RNG => (A, RNG)
    map(Six1.nonNegativeInt)(i => i / (Integer.MAX_VALUE.toDouble + 1))
  }

}
