package infixfunction

infix fun String.multiply(n: Int): String {
  return this.repeat(n)
}

fun main() {
  println("Hello World!\n" multiply 3)
}