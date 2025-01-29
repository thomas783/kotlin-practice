package infixfunction

class Assertion<T>(private val target: T) {
  infix fun isEqualTo(other: T) {
    if (target != other) {
      throw AssertionError("Expected $target to be equal to $other")
    }
  }

  infix fun isDifferentFrom(other: T) {
    if (target == other) {
      throw AssertionError("Expected $target to be different from $other")
    }
  }
}