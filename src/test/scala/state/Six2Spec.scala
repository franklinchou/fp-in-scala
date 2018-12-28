package state

import org.scalatest.FunSpec

class Six2Spec extends FunSpec {

  // p. 83
  describe("6-2") {
    it("should return a double") {
      // Second to largest max value
      val rng = IncrementRng(Int.MaxValue - 1)
      val result = Six2.double(rng)._1
      assert(result.isInstanceOf[Double])
    }

    it("should not include 1") {
      val rng0 = IncrementRng(0)
      val rng1 = IncrementRng(1)
      val result0 = Six2.double(rng0)._1
      val result1 = Six2.double(rng1)._1
      assert(result0 == 0.5)
      assert(result1 == 0.5)
    }

    it("should include 0") {
      val rng = IncrementRng(-1)
      val result = Six2.double(rng)._1
      assert(result == 0)
    }

    it("should be positive") {
      val rng = IncrementRng(-39362)
      val result = Six2.double(rng)._1
      assert(result > 0)
    }

  }

}