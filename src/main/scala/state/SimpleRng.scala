package state

case class SimpleRng(seed: Long) extends RNG {

  def nextInt: (Int, RNG) = {
    val newSeed = (seed* 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFL
    val nextRng = SimpleRng(newSeed)
    val n = (newSeed >>> 16).toInt
    (n, nextRng)
  }

}
