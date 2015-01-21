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
    "work properly" in {
      eventually { 1 mustEqual 1 }
      1 must eventually(===(1))
      1 must eventually(5, Duration(1, TimeUnit.SECONDS))(===(1))
      1 must beEqualTo(1).eventually
      1 must beEqualTo(1).eventually(5, Duration(1, TimeUnit.SECONDS))
    }

    /**
     * Error:(24, 11) type mismatch;
     * found   : org.specs2.matcher.MatchResult[Any]
     * required: org.specs2.matcher.Matcher[?]
     * 1 mustEqual 1
     */
    "work properly with custom timeout" in {
      eventually(5, Duration(1, TimeUnit.SECONDS)) {
        1 mustEqual 1
      }
    }

  }
}
