// run with `sbt "runMain Max"`

// Incrementing the upper bound of Int simply
// results in overflowing to the opposite bound.
object Max extends App {

  // Important to note:
  println(Int.MaxValue + 1 == Int.MinValue)

  println(Int.MinValue - 1 == Int.MaxValue)

}
