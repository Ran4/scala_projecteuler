import scala.util.control.Breaks._

val LARGEST_FIBBONACCI_NUMBER = 4e6.toInt

def getFibsUpToImperativeWithMutation(largestFibbonacciNumber: Int): (List[Int]) = {
  var fibs = 1 :: List(1)
  while (true) {
    val candidate = fibs(0) + fibs(1)
    if (candidate >= LARGEST_FIBBONACCI_NUMBER) {
      return fibs
    }
    fibs = candidate :: fibs
  }
  fibs
}

def getFibsUpTo(largestFibbonacciNumber: Int, fibs: List[Int]): (List[Int]) =
  fibs match {
    case x :: xs if x > largestFibbonacciNumber => xs
    case _ => getFibsUpTo(largestFibbonacciNumber, fibs(0) + fibs(1) :: fibs)
  }

val fibs = getFibsUpTo(LARGEST_FIBBONACCI_NUMBER, 1 :: List(1))
val isEven: Int => Boolean = _ % 2 == 0
val evenFibs = fibs filter isEven
// println(evenFibs.toString)
println(evenFibs.sum)
