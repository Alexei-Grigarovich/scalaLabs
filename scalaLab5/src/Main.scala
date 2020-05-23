import scala.annotation.tailrec

object Main { //9.	Найти локальные экстремумы ряда.

  def findLocalExtremesRecursionMin(ms: Array[Int], n: Int, i: Int): Int = {
    if (i == n - 1) ms(i) else {

      var minTemp: Int = findLocalExtremesRecursionMin(ms, n, i + 1)
      if (minTemp < ms(i)) minTemp else ms(i)
    }
  }

  def findLocalExtremesRecursionMax(ms: Array[Int], n: Int, i: Int): Int = {
    if (i == n - 1) ms(i) else {

      var maxTemp: Int = findLocalExtremesRecursionMax(ms, n, i + 1)
      if (maxTemp > ms(i)) maxTemp else ms(i)
    }
  }

  def main(args: Array[String]): Unit = {
    var range = scala.util.Random
    var max: Int = 0
    var min: Int = 0
    val n: Int = 30
    var ms: Array[Int] = new Array[Int](n)

    //Заполним массив рандомными числами
    for (i <- 0 to n - 1) {
      ms(i) = range.between(-100, 100)
    }

    max = ms(0)
    min = ms(0)
    for (i <- 0 to n - 1) {
      if (min > ms(i)) {
        min = ms(i)
      }
      if (max < ms(i)) {
        max = ms(i)
      }
    }

    println("min = " + min + ", max = " + max)
    println("min = " + findLocalExtremesRecursionMin(ms, n, 0) + ", max = " + findLocalExtremesRecursionMax(ms, n, 0))
  }
}
