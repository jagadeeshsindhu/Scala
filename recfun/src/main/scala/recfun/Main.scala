package recfun
//import common

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Integer, r: Integer): Int =
    if (c < 0 || r < 0)
       0
    else if (c == 0 && r == 0)
       1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  var count: Integer = 0 //> count  : Integer = 0

  def balance(chars: List[Char]): Boolean =
    if (chars.isEmpty) {
      if (count == 0) {
        resetCount
         true
      } else {
        resetCount
         false
      }
    } else {
      if (count < 0) {
        resetCount
         false;
      } else {
        if (chars.head == '(') {
          count = count + 1
          balance(chars.tail)
        } else if (chars.head == ')') {
          count = count - 1
          balance(chars.tail);
        } else {
          balance(chars.tail);
        }
      }
    }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if (coins.isEmpty || money < 0)
       0;
    else if (money == 0)
       1;
    else if (coins.head < 1)
       0;
    else
      countChange(money, coins.tail) + countChange(money - coins.head, coins)

  private def resetCount: Unit = {
    count = 0
  }
}
