package option

import org.scalatest.FunSpec

class Four3Spec extends FunSpec {

  describe("map2") {
    it("should return none") {
      val a = Some(1)
      val b = None
      assert(Four3.map2[Int, Int, Int](a, b)(_ + _).isEmpty)
    }
    it("should return an option result") {
      val a = Some(1)
      val b = Some(2)
      assert(Four3.map2[Int, Int, Int](a, b)(_ + _).contains(3))
    }
  }

  describe("map2 with yield") {
    it("should return none") {
      val a = Some(1)
      val b = None
      assert(Four3.map2yield[Int, Int, Int](a, b)(_ + _).isEmpty)
    }
    it ("should return an option") {
      val a = Some(1)
      val b = Some(2)
      assert(Four3.map2yield[Int, Int, Int](a, b)(_ + _).contains(3))
    }
  }
}
