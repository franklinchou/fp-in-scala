package state

import org.scalatest.FunSpec

class SimpleRngSpec extends FunSpec {

  describe("Should produce a known result") {

    it("if seed is 42") {
      val rng = SimpleRng(42)
      val (n1, rng2) = rng.nextInt
      assert(n1 == 16159453)
      assert(rng2 == SimpleRng(1059025964525L))
    }

  }

}
