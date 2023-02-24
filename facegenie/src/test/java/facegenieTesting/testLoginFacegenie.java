package facegenieTesting;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class testLoginFacegenie {

WebDriver driver;
String validemail="testing@gmail.com";
String validpassword="testing@123";
String inValidEmail="testing123@gmail.com";
String inValidPassword="123456";

By Email = By.id("email");
By Password = By.name("password");
By Login = By.xpath("/html/body/div/div/div[1]/div/div/div[2]/div/div[1]/form[2]/button");
By Logout = By.xpath("/html/body/div/div/div[1]/div/div/div/div/nav/div[7]/div[2]/span");
	
@BeforeMethod(alwaysRun=true)

	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver", "C://Users//laksh//Desktop//SimpliLearn Drivers//chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://facegenie-ams-school.web.app/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
	}
	
@Test(priority=1)
	public void Loginwithvalid_validCredintials() {
		
		WebElement email = driver.findElement(Email);
		email.sendKeys(validemail);
		WebElement passWord =driver.findElement(Password);
		passWord.sendKeys(validpassword);
		WebElement login = driver.findElement(Login);
		login.click();
		Assert.assertEquals(driver.getTitle(), "Rai-Test-Bams");
		System.out.println("testPass , entered into anotherPage");
	}
@Test(priority=2)
	public void LoginWithValid_InvaliCredintials() {
	WebElement email = driver.findElement(Email);
	email.sendKeys(validemail);
	WebElement passWord =driver.findElement(Password);
	passWord.sendKeys(inValidPassword);
	WebElement login = driver.findElement(Login);
	login.click();
	System.out.println("login failed");
		
	}

@Test(priority=3)
public void LoginWithInValid_validCredintials() {
		WebElement email = driver.findElement(Email);
		email.sendKeys(inValidEmail);
		WebElement passWord =driver.findElement(Password);
		passWord.sendKeys(validpassword);
		WebElement login = driver.findElement(Login);
		login.click();
		System.out.println("login failed");	
	
}
@Test(priority=4)
public void LoginWithInValid_InvalidCredintials() {
	WebElement email = driver.findElement(Email);
	email.sendKeys(inValidEmail);
	WebElement passWord =driver.findElement(Password);
	passWord.sendKeys(inValidPassword);
	WebElement login = driver.findElement(Login);
	login.click();
	
	System.out.println("login failed");
}

@Test
public void testlogout() {
	WebElement logout =driver.findElement(Logout);
	logout.click();
}
@AfterMethod(lastTimeOnly = true)
public void quitBrowser() {
	driver.close();
	driver.quit();
}
}