import infixfunction.PrincessMaker
import infixfunction.multiply

fun main(args: Array<String>) {
  println("Hello World!\n" multiply 3)

  PrincessMaker.build {
    name = "Ariel"
    age = 16
  }.also { println(it) }
}