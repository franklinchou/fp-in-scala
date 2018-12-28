package state

class StateActions {

  // NOTE:
  // Q[A <: B] means that class Q can take any class A that is a subclass of B.
  // Q[+B] means that Q can take any class, but if A is a subclass of B, then Q[A]
  // is considered to be a subclass of Q[B]. 
  type Rand[+A] = RNG => (A, RNG)

}
