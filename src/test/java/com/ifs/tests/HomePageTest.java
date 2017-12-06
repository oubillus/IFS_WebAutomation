package com.ifs.tests;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ifs.base.Setup;
import com.ifs.pageobjects.HomePage;

public class HomePageTest extends Setup {
	
private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test(priority=1)
	public void verifyLoadHomePage() throws Exception {
		System.out.println("IFS Homepage | Validation of Homepage Elements");
		HomePage HomePage = new HomePage(driver);
		 Thread.sleep(2000);
		 Assert.assertTrue(HomePage.verifyHomePageTitle(), "Support Hub");
		 assertEquals(driver.findElement(By.cssSelector("img[alt=\"IFS\"]")).getText(), "");
		 assertEquals(driver.findElement(By.xpath("/html/body/div/div/div[2]/h3")).getText(), "Please sign in below:");
		 assertEquals(driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[1]/label")).getText(), "Username");
		 assertEquals(driver.findElement(By.id("txtUsername")).getText(), ""); 
		 assertEquals(driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/label")).getText(), "Password");
		 assertEquals(driver.findElement(By.id("txtPassword")).getText(), ""); 
		 assertEquals(driver.findElement(By.xpath("//button[contains(.,'Sign In')]")).getText(), "Sign In");
		 assertEquals(driver.findElement(By.xpath("/html/body/div/div/div[3]")).getText(), "© 2017 Integrated Field Solutions | v2.8.3");
	}

	
}