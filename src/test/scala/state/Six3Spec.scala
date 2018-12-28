package state

import org.scalatest.FunSpec

class Six3Spec extends FunSpec {

  describe("int double") {
    it ("should generate deterministic result") {
      val r = IncrementRng(4)
      val result = Six3.intDouble(r)
      val expectedInt = 5
      val expectedDouble = expectedInt / Int.MaxValue.toDouble + 1
      assert(result._1 == (expectedInt, expectedDouble))
    }
  }

  describe("double int") {
    it ("should generate deterministic result") {
      val r = IncrementRng(4)
      val result = Six3.doubleInt(r)
      val expectedInt = 5
      val expectedDouble = expectedInt / Int.MaxValue.toDouble + 1
      assert(result._1 == (expectedDouble, expectedInt))
    }
  }

  describe("double3") {
    it ("should generate deterministic result") {
      val r = IncrementRng(4)
      val result = Six3.double3(r)
      val expectedRng = IncrementRng(7)
      assert(result._2 == expectedRng)
    }
  }

}
