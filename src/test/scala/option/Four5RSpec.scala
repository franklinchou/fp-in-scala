package option

import org.scalatest.FunSpec

import scala.util.Try

class Four5RSpec extends FunSpec {

  final val f = (x: String) => Try(x.toInt).toOption

  describe("traverse") {
    it("should return None") {
      val test = List("cat", "dog", "1234")
      val r = Four5R.traverse(test)(f)
      assert(r.isEmpty)
    }
    it("should return all elements as ints") {
      val test = List("9348", "1234")
      val r = Four5R.traverse(test)(f)
      assert(r.contains(List(9348, 1234)))
    }
  }

  describe("traverseL") {
    it("should return None") {
      val test = List("cat", "dog", "1234")
      val r = Four5R.traverseL(test)(f)
      assert(r.isEmpty)
    }
    it("should return all elements as ints") {
      val test = List("9348", "1234")
      val r = Four5R.traverseL(test)(f)
      assert(r.contains(List(9348, 1234)))
    }
  }

}
