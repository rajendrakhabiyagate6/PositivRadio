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

public class BlankEmailTest {
	public String st = System.setProperty("webdriver.chrome.driver", "ChromeDriver\\ChromedriverLinux");

	public WebDriver driver = new ChromeDriver();


	@Test
	public void Email_Validation() {

		driver.get("http://positivradio.test.gate6.com/web/#/register");
		driver.findElement(By.name("fullName")).sendKeys("Manish Dangas");
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.name("password")).sendKeys("Gate6@123");
		driver.findElement(By.xpath("//div[4]/div/div/button")).click();
		String URL = driver.getCurrentUrl();

		Assert.assertEquals(URL, "http://positivradio.test.gate6.com/web/#/register");

	}

	@BeforeTest
	public void beforeTest() {

		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}
}