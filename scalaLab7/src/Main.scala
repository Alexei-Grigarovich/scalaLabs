import scala.io.StdIn.readLine

object Main { //9.	Применить к данным кодирование 8b/10b. При реализации использовать сопоставление с образцом.

  def threeToFourBits(code3b : String, rd : Int): String = {
    code3b match {
      case "000" => if (rd < 0) "1011" else "0100"
      case "001" => if (rd < 0) "0110" else "1001"
      case "010" => if (rd < 0) "1010" else "0101"
      case "011" => if (rd < 0) "1100" else "0011"
      case "100" => if (rd < 0) "1101" else "0010"
      case "101" => if (rd < 0) "0101" else "1010"
      case "110" => if (rd < 0) "1001" else "0110"
      case "111" => if (rd < 0) "0111" else "1000"
    }
  }

  def fiveToSixBits(code5b : String, rd : Int): String = {
    code5b match {
      case "00000" => if (rd < 0) "100111" else "011000"
      case "00001" => if (rd < 0) "011101" else "100010"
      case "00010" => if (rd < 0) "101101" else "010010"
      case "00011" => "110001"
      case "00100" => if (rd < 0) "110101" else "001010"
      case "00101" => "101001"
      case "00110" => "011001"
      case "00111" => if (rd < 0) "111000" else "000111"
      case "01000" => if (rd < 0) "111001" else "000110"
      case "01001" => "100101"
      case "01010" => "010101"
      case "01011" => "110100"
      case "01100" => "001101"
      case "01101" => "101100"
      case "01110" => "011100"
      case "01111" => if (rd < 0) "010111" else "101000"
      case "10000" => if (rd < 0) "011011" else "100100"
      case "10001" => "100011"
      case "10010" => "010011"
      case "10011" => "110010"
      case "10100" => "001011"
      case "10101" => "101010"
      case "10110" => "011010"
      case "10111" => if (rd < 0) "111010" else "000101"
      case "11000" => if (rd < 0) "110011" else "001100"
      case "11001" => "100110"
      case "11010" => "010110"
      case "11011" => if (rd < 0) "110110" else "001001"
      case "11100" => "001110"
      case "11101" => if (rd < 0) "101110" else "010001"
      case "11110" => if (rd < 0) "011110" else "100001"
      case "11111" => if (rd < 0) "101011" else "010100"
    }
  }

  def main(args : Array[String]): Unit = {
    var data : String = ""
    var cont : String = "y"
    var outData : String = ""
    var fiveBits, threeBits, tempBinaryString : String = ""

    var rd : Int = -1
    var zeros, ones : Int = 0


    while (cont == "y") {
      rd = -1
      outData = ""

      println("Введите данные для кодирования")
      data = readLine

      for (i <- 0 to data.length - 1) {
        tempBinaryString = data(i).toBinaryString

        ones = tempBinaryString.count(_ == '1')
        zeros = tempBinaryString.count(_ == '0')

        if (ones > zeros) rd = 1
        else if (zeros > ones) rd = -1

        for (j <- 1 to 8 - tempBinaryString.length) tempBinaryString = "0" + tempBinaryString

        threeBits = tempBinaryString.substring(0, 3)
        fiveBits = tempBinaryString.substring(3)

//        println(threeBits + fiveBits + " = " + fiveToSixBits(fiveBits, rd) + threeToFourBits(threeBits, rd))

        outData += Integer.parseInt(fiveToSixBits(fiveBits, rd) + threeToFourBits(threeBits, rd), 2).toChar
      }

      println(outData)
      println("Хотите повторить?('y' - да)")
      cont = readLine
    }
  }
}
