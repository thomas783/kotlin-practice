package infixfunction

infix fun String.multiply(n: Int): String {
  return this.repeat(n)
}