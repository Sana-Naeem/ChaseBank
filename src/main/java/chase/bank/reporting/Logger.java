package chase.bank.reporting;

import com.aventstack.extentreports.Status;

public class Logger {
	
	public static void log(String msg) {
		Java_logger.getLog(msg);
		TestNG_logger.getLog(msg);
		ExtentTestManager.getTest().log(Status.INFO, msg);
	}
}
