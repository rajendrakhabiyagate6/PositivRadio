package example;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	File file = new File("ChromeDriver/phantomjs");				
	   
	public String st = System.setProperty("phantomjs.binary.path", file.getAbsolutePath());

	public  WebDriver driver = new PhantomJSDriver();

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