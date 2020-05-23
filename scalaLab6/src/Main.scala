object Main { //9.	Найти сумму всех положительных чисел в коллекции.

  private var sum : Int = 0

  def ret(x : Int): Unit = {
    if (x > 0) this.sum += x
  }

  def findSum(list : List[Int]): Int = {
    list.foreach(ret)
    this.sum
  }

  def main(args: Array[String]): Unit = {
    var range = scala.util.Random
    var sum : Int = 0
    var list = List[Int]()
    val n : Int = 30
    val min : Int = -100
    val max : Int = 100

    for (i <- 1 to n) {
      list = range.between(min, max) :: list
    }

    list.foreach(println)

    sum = findSum(list)
    if (sum > 0) println("Сумма положительных чисел = " + sum) else println("Положительных чисел не найдено")
  }
}
