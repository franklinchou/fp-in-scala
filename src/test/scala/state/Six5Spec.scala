package state

import org.scalatest.FunSpec

class Six5Spec extends FunSpec {

  type Rand[+A] = RNG => (A, RNG)

  describe("map function") {
    it("should return random tuple") {
      val rng: RNG = IncrementRng(1)
      println(Six5.double(rng))
    }
  }


}
