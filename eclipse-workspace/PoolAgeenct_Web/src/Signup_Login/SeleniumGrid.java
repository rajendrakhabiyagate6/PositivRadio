package Signup_Login;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumGrid {

	WebDriver driver;
	String baseUrl, nodeURL;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		baseUrl = "https://stage1.tascportal.org";
		nodeURL = "http://10.1.0.129:5556/wd/hub";
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL(nodeURL), capability);

	}

	@BeforeTest
	public void simpleTest() throws InterruptedException {

		driver.get(baseUrl);
		driver.manage().window().maximize();

		driver.get("https://stage1.tascportal.org");

		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void loginlogout() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);

		WebElement builddate = wait.until(ExpectedConditions.elementToBeClickable(By.className("build-number")));
		String st = builddate.getText();

		WebElement copyright = wait.until(ExpectedConditions.elementToBeClickable(By.className("copyright")));
		String copyrightmessage = copyright.getText();
		Assert.assertEquals(copyrightmessage, "Copyright 2017. TASC, A private, non-profit, 501 © (3) corporation.");
		Thread.sleep(2000);
		System.out.println(copyrightmessage);

		// Blank user-name and password entered and click on log-in button

		WebElement UserName = wait.until(ExpectedConditions.elementToBeClickable(By.className("k-textbox")));
		UserName.sendKeys("gate6admin@gate6.com");
		Thread.sleep(3000);

		WebElement Pass = wait.until(ExpectedConditions.elementToBeClickable(By.id("Password")));
		Pass.sendKeys("tags1234");
		Thread.sleep(3000);

		// for button click
		WebElement clickLogin = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frmDefault']/div[5]/input")));
		clickLogin.click();
		Thread.sleep(5000);

		String url = driver.getCurrentUrl();

		Assert.assertEquals(url, "https://stage1.tascportal.org/Admin/UserManagement");

		System.out.println("User login Successfully");

		WebElement clickmyaccount = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dvSlidetop']/a")));
		clickmyaccount.click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@id='frmLogout']/a")).click();

		driver.get("https://stage1.tascportal.org/Home/Default");

		Assert.assertEquals("https://stage1.tascportal.org/Home/Default", driver.getCurrentUrl());

		System.out.println("User logout Successfully");
		Thread.sleep(2000);
	}

	@Test(priority = 1)

	public void verifyremembermecheckbox() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);

		WebElement UserName = wait.until(ExpectedConditions.elementToBeClickable(By.className("k-textbox")));
		UserName.sendKeys("gate6admin@gate6.com");
		Thread.sleep(3000);

		WebElement Pass = wait.until(ExpectedConditions.elementToBeClickable(By.id("Password")));
		Pass.sendKeys("tags1234");
		Thread.sleep(3000);

		WebElement chkremembermecheckbox = wait
				.until(ExpectedConditions.elementToBeClickable(By.className("label_check")));
		chkremembermecheckbox.click();
		Thread.sleep(3000);

		// System.out.println("test");

		WebElement clickLogin = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frmDefault']/div[5]/input")));
		clickLogin.click();
		Thread.sleep(3000);

		WebElement clickmyaccount = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dvSlidetop']/a")));
		clickmyaccount.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='frmLogout']/a")).click();

		WebElement UserName1 = wait.until(ExpectedConditions.elementToBeClickable(By.className("k-textbox")));
		Thread.sleep(2000);
		UserName1.clear();
		Thread.sleep(2000);
	}

	@Test(priority = 2)

	public void testforgetpassword() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);

		WebElement forgotpassword = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frmDefault']/div[3]/strong/a")));
		forgotpassword.click();
		Thread.sleep(2000);

		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://stage1.tascportal.org/Home/RecoverPassword?Length=4");
		System.out.println("Reset password window successfully appeared");

		WebElement UserName = wait.until(ExpectedConditions.elementToBeClickable(By.className("k-textbox")));
		UserName.sendKeys("vishwas9011@gmail.com");
		Thread.sleep(2000);

		WebElement recoverpassword = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frmRecoverPassword']/div[3]/input")));
		recoverpassword.click();
		Thread.sleep(2000);

		WebElement alertmessage = wait.until(ExpectedConditions.elementToBeClickable(By.className("Success")));
		String alertmessage1 = alertmessage.getText();
		Assert.assertEquals(alertmessage1, "Password Send on your email. Please check your email.");
		System.out.println("alertmessage1 is :" + alertmessage1);
		Thread.sleep(2000);

		WebElement backtologin = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frmRecoverPassword']/div[4]/a")));
		backtologin.click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void CloseBrowser() {

		// driver.close();

	}

}
