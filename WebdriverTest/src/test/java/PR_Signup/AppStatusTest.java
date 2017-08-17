package PR_Signup;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class AppStatusTest {
	File file = new File("ChromeDriver/phantomjs");				
	   
	public String st = System.setProperty("phantomjs.binary.path", file.getAbsolutePath());

	public  WebDriver driver = new PhantomJSDriver();

	@Test
	public void CheckApp_Status() {

		driver.get("http://positivradio.test.gate6.com/web/");
		driver.findElement(By.className("facebook"));
		System.out.print("Application is working");

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