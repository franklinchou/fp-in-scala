package state

// Stateless random integer generator
trait RNG {

  def nextInt: (Int, RNG)

}