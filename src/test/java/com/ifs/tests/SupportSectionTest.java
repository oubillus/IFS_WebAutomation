package com.ifs.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ifs.base.Setup;
//import com.ifs.pageobjects.CreateAccountPage;
import com.ifs.pageobjects.HomePage;


public class SupportSectionTest extends Setup{
	
	private WebDriver driver;
	private HomePage HomePage;
	//private CreateAccountPage createAccountPage;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
	
	@Test(priority=1)
	public void verifyCreateAnAccounPage() throws Exception {
		
			System.out.println("Entering to SupportHub...");
			HomePage = new HomePage(driver);
			Thread.sleep(1000);
			Assert.assertTrue(HomePage.isElementPresent(By.id("txtUsername")));
			driver.findElement(By.id("txtUsername")).clear();
			driver.findElement(By.id("txtUsername")).sendKeys("qa");
			Assert.assertTrue(HomePage.isElementPresent(By.id("txtPassword")));
			driver.findElement(By.id("txtPassword")).sendKeys("Password234");
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
		    
		    System.out.println("Entering to 300...");
		    Assert.assertTrue(HomePage.isElementPresent(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr/td/a")));
		    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[2]/table/tbody/tr/td/a")).click();	
		    Thread.sleep(2000);
		    driver.findElement(By.id("tab-debug")).click();	
		    Thread.sleep(2000);


		    Select oSelect = new Select(driver.findElement(By.name("user_id")));
		    Thread.sleep(2000);
		    oSelect.selectByValue("111121");
		    Thread.sleep(2000);
		    
		    driver.findElement(By.className("btn btn-action")).click();
		    
//		    JavascriptExecutor jse = (JavascriptExecutor) driver;
//		    jse.executeScript("window.scrollBy(0,350)", "");	
//		    Thread.sleep(2000);
//		    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[4]/div/div[10]/div[1]/div[2]/div/form/table/tbody/tr/td[1]/select")).click();
//		    Thread.sleep(2000);
//		    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[4]/div/div[10]/div[1]/div[2]/div/form/table/tbody/tr/td[1]/select/option[2]")).click();
//		    Thread.sleep(2000);
//		    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[4]/div/div[10]/div[1]/div[2]/div/form/table/tbody/tr/td[2]/input")).click();	
//		    Thread.sleep(2000);
//		    
//		    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[4]/div/div[10]/div[1]/div[2]/div/form/table/tbody/tr/td[2]/input")).sendKeys(Keys.CONTROL + "2");
//		    Thread.sleep(5000);
//		    System.out.println("Checking Menu Items...");
		        
		    //driver.get("//html");
		    /*Assert.assertTrue(HomePage.isElementPresent(By.cssSelector("img[alt=\"Sage Service Operations Logo\"]")));System.out.println("OKKK");
		    Assert.assertEquals(driver.findElement(By.cssSelector("img[alt=\"Sage Service Operations Logo\"]")).getText(), "");  System.out.println("OKKK2");
		    driver.findElement(By.cssSelector("img[alt=\"Sage Service Operations Logo\"]")).click();
		    
		    Assert.assertEquals(driver.findElement(By.xpath("/html/body/nav[1]/div[1]/div[3]")).getText(), "Emp. Center");
		    
		    driver.findElement(By.xpath("/html/body/nav[1]/div[1]/div[3]")).sendKeys(Keys.TAB);
		    driver.findElement(By.xpath(" ")).sendKeys(Keys.ENTER);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("/html/body/nav[1]/div[1]/div[3]")).sendKeys(Keys.TAB);
		    driver.findElement(By.xpath(" ")).sendKeys(Keys.ENTER);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("/html/body/nav[1]/div[1]/div[3]")).sendKeys(Keys.TAB);
		    driver.findElement(By.xpath(" ")).sendKeys(Keys.ENTER);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("/html/body/nav[1]/div[1]/div[3]")).sendKeys(Keys.TAB);
		    driver.findElement(By.xpath(" ")).sendKeys(Keys.ENTER);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("/html/body/nav[1]/div[1]/div[3]")).sendKeys(Keys.TAB);
		    driver.findElement(By.xpath(" ")).sendKeys(Keys.ENTER);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("/html/body/nav[1]/div[1]/div[3]")).sendKeys(Keys.TAB);
		    driver.findElement(By.xpath(" ")).sendKeys(Keys.ENTER);
		    Thread.sleep(3000);   */
	}
	
	
}