package monoid

import org.scalatest.FunSpec

class Ten1Spec extends FunSpec {

  describe("Boolean or") {
    it("identity function should work") {
      assert(true || Ten1.booleanOr.identity == true)
      assert(false || Ten1.booleanOr.identity == false)
    }
  }

  describe("Boolean and") {
    it("identity function should work") {
      assert(true && Ten1.booleanAnd.identity == true)
      assert(false == false && Ten1.booleanAnd.identity)

      // This won't work because the `&&` comparison evaluates to
      // false and short-circuits the `==` comparison.
      // assert(false && Ten1.booleanAnd.identity == false)
    }
  }

}
