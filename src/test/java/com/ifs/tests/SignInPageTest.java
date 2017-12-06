package com.ifs.tests;

//import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ifs.base.Setup;
import com.ifs.pageobjects.HomePage;
//import com.ifs.pageobjects.SignInPage;


public class SignInPageTest extends Setup{
	
	private WebDriver driver;
	//private SignInPage signInPage;
	private HomePage HomePage;
	
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
		
	@Test(priority=1)
	public void verifySignInEmpty() throws Exception {
		System.out.println("Sign In without information...");
		HomePage = new HomePage(driver);
		Thread.sleep(1000);
		Assert.assertTrue(HomePage.isElementPresent(By.id("txtUsername")));
		Assert.assertTrue(HomePage.isElementPresent(By.xpath("/html/body/div/div/div[2]/form/div[1]/label")));
		Assert.assertTrue(HomePage.isElementPresent(By.id("txtPassword")));
		Assert.assertTrue(HomePage.isElementPresent(By.xpath("/html/body/div/div/div[2]/form/div[2]/label")));
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[contains(.,'Sign In')]")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "Invalid username or password");
	    Thread.sleep(1000);
	}
		
	@Test(priority=2)
	public void verifySignInSingleFailed() throws Exception {
		System.out.println("Sign In failed...");
		HomePage = new HomePage(driver);
		Thread.sleep(1000);
		//signInPage.verifySignIn();
		
		Assert.assertTrue(HomePage.isElementPresent(By.id("txtUsername")));
		driver.findElement(By.id("txtUsername")).sendKeys("qa");
		Assert.assertTrue(HomePage.isElementPresent(By.id("txtPassword")));
		driver.findElement(By.id("txtPassword")).sendKeys("Password1238");
		
		Assert.assertTrue(HomePage.isElementPresent(By.xpath("//button[contains(.,'Sign In')]")));
		driver.findElement(By.xpath("//button[contains(.,'Sign In')]")).click();
	    Thread.sleep(5000);
	}


	@Test(priority=1)
	public void verifySignInSucessfully() throws Exception {
		System.out.println("Sign In sucessfully...");
		HomePage = new HomePage(driver);
		Thread.sleep(1000);
		//signInPage = HomePage.clickSignIn();
		//signInPage.verifyValidSignIn();
		Assert.assertTrue(HomePage.isElementPresent(By.id("txtUsername")));
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("oscar");
		Assert.assertTrue(HomePage.isElementPresent(By.id("txtPassword")));
		driver.findElement(By.id("txtPassword")).sendKeys("qa123!98A");
		//driver.findElement(signInPage.loginBtn).click();
		driver.findElement(By.xpath("//button[contains(.,'Sign In')]")).click();		
		Thread.sleep(2000);
		Assert.assertTrue(HomePage.isElementPresent(By.cssSelector("img[alt=\"IFS\"]")));
	    Assert.assertEquals(driver.findElement(By.cssSelector("img[alt=\"IFS\"]")).getText(), "");   
	    Assert.assertTrue(HomePage.isElementPresent(By.id("navbar")));
	    Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[1]/h1")).getText(), "IFS Support Hub");
	    Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[1]/h3")).getText(), "Newest Accounts");
	    Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/h3")).getText(), "Accounts Down");	    
	    Assert.assertTrue(HomePage.isElementPresent(By.id("account_lkp")));
	    Assert.assertTrue(HomePage.isElementPresent(By.className("panel-heading")));
	}
	
	@Test(priority=2)
	public void verifySignInFailed() throws Exception {
		System.out.println("Sign in Several Attempts...");
		HomePage = new HomePage(driver);
		Thread.sleep(1000);
		//signInPage.verifySignIn();
		
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/a[2]")).click();	
		
		Assert.assertTrue(HomePage.isElementPresent(By.id("txtUsername")));
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("oscar");
		Assert.assertTrue(HomePage.isElementPresent(By.id("txtPassword")));
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("qa123!98Arrr");
		Assert.assertTrue(HomePage.isElementPresent(By.xpath("//button[contains(.,'Sign In')]")));
		driver.findElement(By.xpath("//button[contains(.,'Sign In')]")).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(HomePage.isElementPresent(By.id("txtUsername")));
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("oscar");
		Assert.assertTrue(HomePage.isElementPresent(By.id("txtPassword")));
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("Passord1238");
		Assert.assertTrue(HomePage.isElementPresent(By.xpath("//button[contains(.,'Sign In')]")));
		driver.findElement(By.xpath("//button[contains(.,'Sign In')]")).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(HomePage.isElementPresent(By.id("txtUsername")));
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("oscar");
		Assert.assertTrue(HomePage.isElementPresent(By.id("txtPassword")));
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("Passwd1238");
		Assert.assertTrue(HomePage.isElementPresent(By.xpath("//button[contains(.,'Sign In')]")));
		driver.findElement(By.xpath("//button[contains(.,'Sign In')]")).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(HomePage.isElementPresent(By.id("txtUsername")));
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("oscar");
		Assert.assertTrue(HomePage.isElementPresent(By.id("txtPassword")));
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("Passwdddddddd1238");
		Assert.assertTrue(HomePage.isElementPresent(By.xpath("//button[contains(.,'Sign In')]")));
		driver.findElement(By.xpath("//button[contains(.,'Sign In')]")).click();
		Thread.sleep(3000);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.alert.alert-danger")).getText(), "You have exceeded the maximum number of login attempts within 15 minutes, please wait before trying again");
	    Thread.sleep(1000);
	}
	
	

}