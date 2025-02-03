package inlinefunction

import inlinefunction.TreeNode.Companion.findParentOfType

fun doWithoutInline(lambda: () -> Unit) {
  println("Hi!! I'm doing something without inline")
  lambda()
}

inline fun doWithInline(lambda: () -> Unit) {
  println("Hi!! I'm doing something with inline")
  lambda()
}

//inline fun doWithoutNoinline(lambda1: () -> Unit, lambda2: () -> Unit) {
//  println("Hi!! I'm doing something without noinline")
//  lambda1()
//  doSomething { lambda2() }
//}

inline fun doWithNoinline(lambda1: () -> Unit, noinline lambda2: () -> Unit) {
  println("Hi!! I'm doing something with noinline")
  lambda1()
  doSomething { lambda2() }
}

fun doSomething(lambda: () -> Unit) {
  println("start doing something")
  lambda()
  println("end doing something")
}

inline fun doWithoutCrossinline(noinline block: () -> Unit) {
  println("start without crossinline")
  doSomething {
    println("start without crossinline lambda")
    block()
    println("end without crossinline lambda")
  }
  println("end without crossinline")
}

inline fun doWithCrossinline(crossinline block: () -> Unit) {
  println("start with crossinline")
  doSomething {
    println("start with crossinline lambda")
    block()
    println("end with crossinline lambda")
  }
  println("end with crossinline")
}

class TreeNode {
  var parent: TreeNode? = null

  companion object {
    fun <T> TreeNode.findParentOfType(clazz: Class<T>): T? {
      var p = parent
      while (p != null && !clazz.isInstance(p)) {
        p = p.parent
      }
      @Suppress("UNCHECKED_CAST")
      return p as T?
    }

    inline fun <reified T> TreeNode.findParentOfType(): T? {
      var p = parent
      while (p != null && p !is T) {
        p = p.parent
      }
      return p as T?
    }
  }
}

fun main() {
  val grandFather = TreeNode()
  val father = TreeNode()
  val child = TreeNode()
  father.parent = grandFather
  child.parent = father
  println(child.findParentOfType(TreeNode::class.java))
  println(child.findParentOfType<TreeNode>())
}