package chase.bank.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import chase.bank.common.Common_methods;
import chase.bank.common.Common_waits;
import chase.bank.pages.ApplyNowPage;
import chase.bank.pages.CreditCardsPage;
import chase.bank.pages.FreedomUnlimitedAppPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_class {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Robot robot;

	public static Common_waits common_waits;
	public static Common_methods common_methods;

	public CreditCardsPage creditCardsPage;
	public ApplyNowPage applyNowPage;
	public FreedomUnlimitedAppPage freedomUnlimitedAppPage;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chase.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			Assert.fail();
		}
		initElements();
	}

	@AfterMethod
	public void tearUp() {
		driver.quit();
	}

	private void initElements() {
		common_waits = new Common_waits();
		common_methods = new Common_methods();

		creditCardsPage = new CreditCardsPage(driver);
		applyNowPage = new ApplyNowPage(driver);
		freedomUnlimitedAppPage = new FreedomUnlimitedAppPage(driver);
	}

}
