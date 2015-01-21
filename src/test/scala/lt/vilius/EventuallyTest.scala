package lt.vilius

import java.util.concurrent.TimeUnit
import org.specs2.mutable.SpecificationWithJUnit
import scala.concurrent.duration.Duration

class EventuallyTest extends SpecificationWithJUnit {

  "eventually" should {
    "work properly" in {
      eventually { 1 mustEqual 1 }
    }

    /**
      * Error:(21, 56) type mismatch;
      * found   : org.specs2.matcher.MatchResult[Any]
      * required: org.specs2.matcher.Matcher[?]
      * eventually(5, Duration(1, TimeUnit.SECONDS)) { 1 mustEqual 1 }
      */
    "work properly with custom timeout" in {
      eventually(5, Duration(1, TimeUnit.SECONDS)) { 1 mustEqual 1 }
    }

  }
}
