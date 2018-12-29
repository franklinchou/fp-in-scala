# Monoids

Monoids are algebraic structures; they are data types that can be defined
entirely by their operations and a set of laws. See p. 176.

## Semigroup

A semigroup is an algebraic structure consisting of a set together with 
an associative binary operation. For example:

1. The set of all natural numbers and addition. (The binary operation, `+`,
is associative, i.e., `for {a, b} in N, a + b = b + a`.)
2. The Empty Set, where the Empty Function is the associative binary
operation. (Note on the Empty Function: A function `f: A => B` is a map
of every element `a` in set `A` (the domain of `f`) to a specific element `b`
in set `B` (the codomain of `f`). The application of that function is commonly
denoted `f(a)`. The result of applying `f` to every element in `A` is an
ordered pair `(a, f(a)) for all a in A`. Consider the case for the Empty
Set. The Empty Function is a function, `f`, which maps every element in the
Empty Set to some codomain, `B`, `f: {} => B`. Since there are no elements
in the Empty Set, no specific elements in `B` will be identified. Therefore
the result of `f` is an empty group of ordered pairs. The Empty Function
is associative: Applying `f({}, b)` and `f(b, {})` are equivalent.) 

## Monoids: Semigroups with Identity

A monoid is simply a semigroup with the identity function. For example:

1. The set of all natural numbers and addition is a semigroup. The set of
all positive integers including 0 is a monoid. (Zero provides the identity.)
2. The set of all natural numbers and multiplication is a semigroup. (One
provides the identity.)
