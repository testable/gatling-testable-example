
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class DemoSimulation extends Simulation {

  val httpConf = http
    .baseUrl("http://sample.testable.io") // Here is the root for all relative URLs
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Testable Demo") // A scenario is a chain of requests and pauses
    .exec(http("request_1")
      .get("/stocks/IBM"))

  setUp(scn.inject(atOnceUsers(Integer.getInteger("users", 1))).protocols(httpConf))
}

