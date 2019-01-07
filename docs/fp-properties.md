# Properties of functional programming languages

What can functional programming do for you?

## Higher order functions

A higher order function: (a) takes a function as an argument; or (b) returns a function as a result.
These two properties allow composability of functions, i.e., `f(g(x))`.

## Functions are first-class citizens

Functions can be stored as values. A simple example of a higher-ordered function is `map`, which
has this general type signature:

`map(c: Seq[A], f: A => B): Seq[B]`

In order for a language to support this type signature it must support the passing of a function, `f`,
as an argument. 

## Idempotence (pure functions)

Pure functions: (a) do not change the values of the input parameters; and (b) are not 
changed themselves regardless of the number of times a function is applied. 
Pure functions have no side-effects. This is extremely useful in concurrent programming
contexts; threads and execution order have _no effect_ on a pure function.

Advantages in testing pure functions.

## Immutability 

1. Failure atomicity. If a method throws an exception, the object should still be usable afterwards.
Program execution is not halted because of the state of the inputs. 
2. Thread-safety and concurrency. Most failures in OOP languages when it comes to concurrency
have to do with passing around shared mutable state.

# What are functions good for?

1. Mapping (the classic example)

2. Control flow
