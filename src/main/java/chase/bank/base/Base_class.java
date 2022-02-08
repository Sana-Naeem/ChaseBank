package chase.bank.base;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import chase.bank.common.Common_methods;
import chase.bank.common.Common_waits;
import chase.bank.pages.ApplicantDetailsPage;
import chase.bank.pages.ApplyNowPage;
import chase.bank.pages.CreditCardsPage;
import chase.bank.pages.FreedomUnlimitedAppPage;
import chase.bank.utilities.Configurable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_class {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor jsExecutor;

	public static Common_waits common_waits;
	public static Common_methods common_methods;
	public Configurable configurable;

	public CreditCardsPage creditCardsPage;
	public ApplyNowPage applyNowPage;
	public FreedomUnlimitedAppPage freedomUnlimitedAppPage;
	public ApplicantDetailsPage applicantDetailsPage;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		initElements();
		driver.get(configurable.getUrl());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(configurable.getPageLoadWait()));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configurable.getElementImplicitWait()));
		wait = new WebDriverWait(driver, Duration.ofSeconds(configurable.getExplicitWait()));
	}

	@AfterMethod
	public void tearUp() {
		driver.quit();
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
