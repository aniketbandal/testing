package com.hello.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	WebDriver driver;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	   	ChromeOptions options = new ChromeOptions();
	   	options.addArguments("--start-maximized");
	    //driver = new ChromeDriver(options);
		driver = new HtmlUnitDriver();
        System.out.println("\n\n\n******************************************");  	   	
		System.out.println("driver loaded successfully...");
	}
	
	
	
	@org.testng.annotations.Test
	public void addUser() {
		String uname="Rajesh";
		String pass="12345";
		int flag=0;
		 driver.get("http://thedemosite.co.uk/addauser.php");
		 System.out.println("visited to add a user webpage in website ");
	        driver.findElement(By.name("username")).sendKeys(uname);
			driver.findElement(By.name("password")).sendKeys(pass);
			driver.findElement(By.name("FormsButton2")).click();
			 String cusername=driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote")).getText();		
			System.out.println(cusername);
			 if (cusername.contains(uname))
				if(cusername.contains(pass))
				{
					System.out.println("Page title is: " + driver.getTitle());
				System.out.println("user added successfully.....");
					flag=1;
				    driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[2]/small/a")).click();
				    System.out.println("open login page");
				    
				}
					Assert.assertEquals(1, flag);
	}
	
	@org.testng.annotations.Test
	public void login() throws InterruptedException
	{
		
		String uname="Rajesh";
		String pass="12345";
		int flag=0;
	    //   WebDriverWait wait = new WebDriverWait(driver,10);
	    //   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")));
            
		System.out.println("Page title is: " + driver.getTitle());
	       driver.findElement(By.name("username")).sendKeys(uname);
	       driver.findElement(By.name("password")).clear();
	       driver.findElement(By.name("password")).sendKeys(pass);
	       driver.findElement(By.name("FormsButton2")).click();
	       System.out.println("hello");
	      // WebDriverWait wait = new WebDriverWait(driver,10);
	       // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")));
	       String result= driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText();
	     //String result="**Successful Login...";
	       System.out.println(result);
	       if(result.contains("Successful Login"))
	       {
	    	   System.out.println("Login done successfully......");
	    	   System.out.println("open home page");
		       driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[2]/small/strong/a")).click();
	    	   flag=1;
	    	   System.out.println("opened home page successfully...");
	    	   driver.close();
	       }
	       else
	       {
	    	   System.out.println("login done unsuccessful...");
	    	   System.out.println("invalid username and password for login");
	           flag=0;
	           driver.close();
	       }
	       Assert.assertEquals(1, flag);
	}
}
