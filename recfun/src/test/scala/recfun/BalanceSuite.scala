package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BalanceSuite extends FunSuite {
  import Main.balance

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("balance: ':-)' is unbalanced") {
    assert(!balance(":-)".toList))
  }

  test("balance: counting is not enough") {
    assert(!balance("())(".toList))
  }

  test("balance: empty string is balances") {
    assert(balance("".toList))
  }

  test("balance: unbalanced close bracket") {
    assert(!balance("this is not balanced))".toList))
  }

  test("balance: unbalanced open bracket") {
    assert(!balance("(i like (ice cream)".toList))
  }

  test("balance: string with no brackets should be balanced") {
    assert(balance("i like chocolates".toList))
  }
  
  test("balance: reverted brackte string") {
    assert(!balance("i )like( chocolates".toList))
  }
}
