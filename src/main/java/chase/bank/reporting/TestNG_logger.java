package chase.bank.reporting;

import org.testng.Reporter;

public class TestNG_logger {
	public static void getLog(String msg) {
		Reporter.log(msg + "<br>");
	}
}
