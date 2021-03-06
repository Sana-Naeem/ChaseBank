package chase.bank.base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.opera.OperaDriver;
//import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import chase.bank.common.Common_methods;
import chase.bank.common.Common_waits;
import chase.bank.pages.ApplicantDetailsPage;
import chase.bank.pages.ApplyNowPage;
import chase.bank.pages.CreditCardsPage;
import chase.bank.pages.FreedomUnlimitedAppPage;
import chase.bank.reporting.ExtentManager;
import chase.bank.reporting.ExtentTestManager;
//import chase.bank.reporting.Logger;
import chase.bank.utilities.Configurable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_class {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor jsExecutor;
	private ExtentReports extent;

	public static Common_waits common_waits;
	public static Common_methods common_methods;
	public Configurable configurable;

	public CreditCardsPage creditCardsPage;
	public ApplyNowPage applyNowPage;
	public FreedomUnlimitedAppPage freedomUnlimitedAppPage;
	public ApplicantDetailsPage applicantDetailsPage;

	@BeforeSuite
	public void initiatinExtentReport() {
		extent = ExtentManager.getInstance();
	}

	/**
	 * @BeforeMethod
	public void setUp(String browser) {
		String os = System.getProperty("os.name");
		Logger.log("My OS version is " + os);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("ei")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("safari") && os.contains("Mac")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else {

		}
	 */
	@BeforeMethod
	public void setUp() {WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		initElements();
		driver.get(configurable.getUrl());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(configurable.getPageLoadWait()));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configurable.getElementImplicitWait()));
		wait = new WebDriverWait(driver, Duration.ofSeconds(configurable.getExplicitWait()));
	}

	@BeforeMethod
	public void beforeEachTest(Method method) {
		String className = method.getDeclaringClass().getSimpleName();
		ExtentTestManager.startTest(method.getName());
		ExtentTestManager.getTest().assignCategory(className);
	}

	@AfterMethod
	public void afterEachTest(ITestResult result) {
		for (String testName : result.getMethod().getGroups()) {
			ExtentTestManager.getTest().assignCategory(testName);
		}
		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.getTest().addScreenCaptureFromPath(Common_methods.addScreenShotToLocal(result.getName()));
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
			// commonActions.addScreenShotToLocal(); // Will add to local only
		} else {
			ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		}
		tearUp();
	}

	private void tearUp() {
		driver.quit();
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}

	private void initElements() {
		common_waits = new Common_waits();
		common_methods = new Common_methods();
		configurable = Configurable.getInstance();
		jsExecutor = (JavascriptExecutor) driver;

		creditCardsPage = new CreditCardsPage(driver);
		applyNowPage = new ApplyNowPage(driver);
		freedomUnlimitedAppPage = new FreedomUnlimitedAppPage(driver);
		applicantDetailsPage = new ApplicantDetailsPage(driver);

	}

}
