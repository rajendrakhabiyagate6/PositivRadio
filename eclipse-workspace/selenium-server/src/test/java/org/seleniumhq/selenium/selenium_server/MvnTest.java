package org.seleniumhq.selenium.selenium_server;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MvnTest {

	public String st = System.setProperty("webdriver.chrome.driver", "E:\\ManishBackup\\ChromeDriver\\chromedriver.exe");

	public WebDriver driver = new ChromeDriver();
	String AppURL = "http://poolagency.test.gate6.com:5001/admin/login";
	public WebDriverWait wait = new WebDriverWait(driver, 60);

	@BeforeClass
	public void Open_browser() {

		driver.get(AppURL);
		driver.manage().window().maximize();

	}

	@Test
	public void Login() throws InterruptedException

	{

		WebElement UserName = wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));
		UserName.sendKeys("ram.sagar@gate6.com");

		WebElement Password = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		Password.sendKeys("Gate6@12");

		WebElement Click_login = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		Click_login.click();

		Thread.sleep(4000);

	}

	@AfterClass
	public void Logout()

	{

		WebElement Open_DropDown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='headerLinks']/div[2]/span")));
		Open_DropDown.click();

		WebElement ClickLogout = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='headerLinks']/div[2]/div/ul/li[2]/a")));
		ClickLogout.click();

		driver.close();

	}
}
