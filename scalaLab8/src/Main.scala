import scala.io.StdIn.readLine

object Main { /*  Телефонная книга. Необходимо реализовать: добавление телефона и имени;
                  выдачу телефона по имени; выдачу имени по телефону.*/

  def scanName(): String = {
    var name, temp : String = ""

    println("Введите имя")
    name = readLine

    if (name.length < 2) return ""

    temp = name.toLowerCase
    for (i <- 0 to temp.length - 1) {
      if (!(temp(i) >= 'а' && temp(i) <= 'я')) return ""
    }

    name
  }

  def scanNumber(): String = {
    var number : String = ""

    println("Введите номер телефона(12 цифр)")
    number = readLine

    if (number.length != 12) return ""
    if (number(0) == '0') return ""

    for (i <- 0 to number.length - 1) {
      if (!(number(i) >= '0' && number(i) <= '9')) return ""
    }

    number
  }

  def scanSubNumber(): String = {
    var number : String = ""

    println("Введите часть номера телефона")
    number = readLine

    if (number.length == 0) return ""

    for (i <- 0 to number.length - 1) {
      if (!(number(i) >= '0' && number(i) <= '9')) return ""
    }

    number
  }

  def addPerson(phoneBook : List[Person]): Person = {
    var name : String = ""
    var number : String = ""

    name = scanName
    while (name == "") name = scanName

    number = scanNumber()
    while (number == "") number = scanNumber()

    println("Добавлено")
    new Person(name, number)
  }

  def findByName(phoneBook : List[Person]): Unit = {
    var name : String = ""
    var flag : Int = 0

    name = scanName
    while (name == "") name = scanName

    for (i <- 0 to phoneBook.length - 1) {
      if (phoneBook(i).getName().toLowerCase.contains(name.toLowerCase)) {
        if (flag == 0) println("Найденные записи по запросу \"" + name + "\":")

        println(phoneBook(i).getName() + " | " + phoneBook(i).getNumber())

        flag += 1
      }
    }

    if (flag == 0) println("Записей не найдено")
  }

  def findByNumber(phoneBook : List[Person]): Unit = {
    var number : String = ""
    var flag : Int = 0
    flag = ++flag + flag++

    number = scanSubNumber()
    while (number == "") number = scanSubNumber()

    for (i <- 0 to phoneBook.length - 1) {
      if (phoneBook(i).getNumber().contains(number)) {
        if (flag == 0) println("Найденные записи по запросу \"" + number + "\":")

        println(phoneBook(i).getName() + " | " + phoneBook(i).getNumber())

        flag += 1
      }
    }

    if (flag == 0) println("Записей не найдено")
  }

  def main(args : Array[String]): Unit = {
    var phoneBook = List[Person]()
    var select : String = ""

    while(true) {
      println("1 - Добавить")
      println("2 - Поиск по имени")
      println("3 - Поиск по телефону")
      println("0 - Выйти")
      select = readLine

      select match {
        case "1" => phoneBook = addPerson(phoneBook) :: phoneBook
        case "2" => findByName(phoneBook)
        case "3" => findByNumber(phoneBook)
        case "0" => return
        case _ =>
      }
    }
  }
}
