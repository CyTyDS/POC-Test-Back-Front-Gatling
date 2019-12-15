package hello

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost:8080")
		.inferHtmlResources(BlackList(""".*\.css""", """.*\.js""", """.*\.ico"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0")





	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/"))

	setUp(scn
		.inject(atOnceUsers(1), //1 Un seul utilisateur virtuel exécute le scénario
			rampUsersPerSec(10) to(1000) during(30 seconds) //2 La simulation commence avec un ajout de 10 utilisateurs par secondes, puis monte progressivement jusqu'à 1000, et ce pendant 2 minutes.
			)
		.protocols(httpProtocol))
}