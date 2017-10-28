package test.hello

import org.scalatest._

class HelloSpec extends AsyncFreeSpec with MustMatchers {
  "true" in {
    true mustEqual true
  }
}
