package PR_Signup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class InvalidEmailTest {
		//public String st = System.setProperty("webdriver.chrome.driver", "ChromeDriver/Chromedriver.exe");

	//public WebDriver driver = new ChromeDriver();
	
	public	 WebDriver driver = new HtmlUnitDriver();

	@Test(priority = 1)
	public void InvalidEmail_Validation1() {

		driver.get("http://positivradio.test.gate6.com/web/#/register");
		driver.findElement(By.name("fullName")).sendKeys("Manish Dangas");
		driver.findElement(By.id("email")).sendKeys("manish@.com");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();

	}

	@Test(priority = 2)
	public void InvalidEmail_Validation12() {

		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("@.com");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();

	}

	@BeforeTest
	public void beforeTest() {

		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() {
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/#/register");
		driver.quit();
	}
}
