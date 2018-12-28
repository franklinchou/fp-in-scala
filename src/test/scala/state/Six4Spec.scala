package state

import org.scalatest.FunSpec

class Six4Spec extends FunSpec {

  describe("ints function") {
    // should create a list of arbitrarily long pseudo-random ints
    it("given counts = 4, result length = 4") {
      val r = IncrementRng(42)
      val results = Six4.ints(4, r)._1
      assert(results.length == 4)
    }
    it("given counts = 200, result length = 200") {
      val r = IncrementRng(243)
      val results = Six4.ints(200, r)._1
      assert(results.length == 200)
    }
  }

}
