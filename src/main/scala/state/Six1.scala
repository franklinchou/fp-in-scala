package state


// Run with: sbt "runMain SixOne"
object Six1 extends App {

  var acc = Seq.empty[Boolean]

  val rng1 = IncrementRng(515)
  val (n1, _) = rng1.nextInt
  acc = acc :+ (n1 == 516)

  // Write a function that uses `nextInt` to generate
  // a positive random integer [0, MaxInt].
  def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (i, r) = rng.nextInt
    (if (i < 0) Math.abs(i) else i, r)
  }

  // Test that given a positive seed, expected # is returned
  val rng2 = IncrementRng(515)
  val (n2, _) = nonNegativeInt(rng2)
  acc = acc :+ (n2 == 515 + 1)

  // Test that given a negative seed, expected # is returned
  val rng3 = IncrementRng(-515)
  val (n3, _) = nonNegativeInt(rng3)
  acc = acc :+ (n3 == 514)

  // Test that given a negative seed = MinValue, expected # is returned
  val rng4 = IncrementRng(Int.MinValue)
  val (n4, _) = nonNegativeInt(rng4)
  acc = acc :+ (n4 == Int.MaxValue)

  // Test that given a negative seed = MaxValue, expected # is returned
  val rng5 = IncrementRng(Int.MaxValue)
  val (n5, _) = nonNegativeInt(rng5)
  acc = acc :+ (n5 == Math.abs(Int.MinValue))

  if (!acc.forall(_ == true)) {
    sys.exit(1)
  }
}
