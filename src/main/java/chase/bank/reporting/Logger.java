package chase.bank.reporting;

public class Logger {
	
	public static void log(String msg) {
		Java_logger.getLog(msg);
		TestNG_logger.getLog(msg);
	}
}
