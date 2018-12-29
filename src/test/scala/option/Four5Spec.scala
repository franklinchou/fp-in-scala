package option

import org.scalatest.FunSpec

import scala.util.Try



class Four5Spec extends FunSpec {

  describe("traverse") {
    it("should return only ints") {
      // convert to int
      val strs = List("123", "45", "abc")
      val r = Four5.traverse[String, Int](strs)(x => Try(x.toInt).toOption)

      // this was more of a pain in the ass to write than the actual exercise
      val testL = r.exists(_.foldLeft[Boolean](true)((acc, i) => i.isInstanceOf[Int] && acc))
      assert(testL)

      // just for fun
      // In fold right, the first item is the right most item in the list
      val testR = r.exists(_.foldRight[Boolean](true)((i, acc) => i.isInstanceOf[Int] && acc))
      assert(testR)
    }

    it("should return None") {
      // convert to int
      val strs = List("ihd", "aa45", "abc")
      val r = Four5.traverse[String, Int](strs)(x => Try(x.toInt).toOption)
      assert(r.isEmpty)
    }
  }

  describe("traverse2") {
    it("should return only ints") {
      // convert to int
      val strs = List("123", "45", "abc")
      val r = Four5.traverse2[String, Int](strs)(x => Try(x.toInt).toOption)
      println(r)
      val test = r.exists(_.foldRight[Boolean](true)((i, acc) => i.isInstanceOf[Int] && acc))
      assert(test)
    }

    it("should return None") {
      // convert to int
      val strs = List("ihd", "aa45", "abc")
      val r = Four5.traverse2[String, Int](strs)(x => Try(x.toInt).toOption)
      assert(r.isEmpty)
    }

  }

}
