package infixfunction

class PrincessMaker(
  private val name: String,
  private val age: Int,
) {

  companion object {
    infix fun build(block: Builder.() -> Unit) = Builder().apply(block).build()

    class Builder {
      var name: String = ""
      var age: Int = 0

      fun build() = PrincessMaker(name, age)
    }
  }

  override fun toString(): String {
    return "PrincessMaker(name=$name, age=$age)"
  }
}