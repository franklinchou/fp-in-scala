package option

import org.scalatest.FunSpec

class Four4Spec extends FunSpec {

  describe("Sequence") {
    it("should reduce a list containing one None element to None") {
      val l = List(Some(3), None, Some(4))
       assert(Four4.sequence[Int](l).isEmpty)
    }
    it("should return a list") {
      val l = List(Some(1), Some(2), Some(3))
      assert(Four4.sequence[Int](l).contains(List(1, 2, 3)))
    }
  }

  describe("Sequence with map") {
    it("should reduce a list containing one None element to None") {
      val l = List(Some(3), None, Some(4))
      assert(Four4.sequenceWithMapL[Int](l).isEmpty)
    }
    it("should return a list") {
      val l = List(Some(1), Some(2), Some(3))
      assert(Four4.sequenceWithMapL[Int](l).contains(List(1, 2, 3)))
    }
  }

}
