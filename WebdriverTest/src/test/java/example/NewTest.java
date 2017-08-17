package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
//	public String st = System.setProperty("webdriver.chrome.driver", "ChromeDriver/chromedriver");
//
//	public WebDriver driver = new ChromeDriver();


	public	 WebDriver driver = new HtmlUnitDriver();

	@Test
	public void testEasy() {

		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Demo Guru99 Page"));
	}

	@BeforeTest
	public void beforeTest() {
		driver.get("http://demo.guru99.com/selenium/guru99home/");

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}