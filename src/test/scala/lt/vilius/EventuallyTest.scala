package lt.vilius

import java.util.concurrent.TimeUnit

import org.specs2.mutable.SpecificationWithJUnit

import scala.concurrent.duration.Duration

/**
 * @author viliusl
 * @since 21/01/15
 */
class EventuallyTest extends SpecificationWithJUnit {

  "eventually" should {
    "work properly without custom timeout" in {
      eventually {
        1 mustEqual 1
      }
    }

    /**
      * Error:(24, 11) type mismatch;
      * found   : org.specs2.matcher.MatchResult[Any]
      * required: org.specs2.matcher.Matcher[?]
      *         1 mustEqual 1
      */
    "work properly with custom timeout" in {
      eventually(5, Duration(1, TimeUnit.SECONDS)) {
        1 mustEqual 1
      }
    }

  }

}
