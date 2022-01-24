package chase.bank.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import chase.bank.pages.CreditCardsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_class {
	public static WebDriver driver;
	public CreditCardsPage creditCardsPage;
	
	@BeforeMethod
	public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.chase.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	initElements();
	}
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}
	
	private void initElements() {
	creditCardsPage = new CreditCardsPage(driver);
	}
	
}

