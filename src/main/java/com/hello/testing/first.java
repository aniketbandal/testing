package com.hello.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class first {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("hello");
		String uname="rajesh";
		String pass="12345";
		WebDriver driver;
		 System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	   	 
		   	ChromeOptions options = new ChromeOptions();
		   	options.addArguments("--start-maximized");
		    driver = new ChromeDriver(options);
		    
		    //************open the page***************************
		   	 driver.get("http://thedemosite.co.uk/addauser.php");
		   	System.out.println("visited to add a user page in website ");
			String namepage1=driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/p[1]/big/strong")).getText();
	        if (namepage1.contentEquals("3. Add a User"))
			System.out.println("page loaded successfully........ ");
	        else
	        {   Thread.sleep(1000);
	        	System.out.println("page not loaded properly");
	        	System.out.println("exit from browser");
	        	driver.close();
	        }
		
	       //*************add username and pasword**********************
	        driver.findElement(By.name("username")).sendKeys(uname);
			driver.findElement(By.name("password")).sendKeys(pass);
			driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();
	       System.out.println("user with username="+uname+" and password="+pass+" added successfully......");
			//************ display username and password ***************
	       String cusername=driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote")).getText();  
	       System.out.println(cusername);
	       
	       //********************  open and check login page loaded properly *****************
	       driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[2]/small/a")).click();
	       System.out.println("open login page");
			String namepage2=driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/p[1]/big/strong")).getText();
	        if (namepage2.contentEquals("4. Login"))
			System.out.println(" login page loaded successfully........ ");
	        else
	        {
	        	Thread.sleep(1000);
	        	System.out.println("login page not loaded properly");
	        	System.out.println("exit from browser");
	        	driver.close();
	        }
	       
	       //****************** enter user credintial ****************
	       driver.findElement(By.name("username")).sendKeys(uname);
	       driver.findElement(By.name("password")).clear();
	       driver.findElement(By.name("password")).sendKeys(pass);
	       driver.findElement(By.name("FormsButton2")).click();
	       
	       String result= driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText();
	      if(result.equals("**Successful Login**"))
	      {
	       //****************** visit to home page  *********************
	          System.out.println("your username and password are correct and visited to home page");
	          
	          System.out.println("open home page");
	          driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[2]/small/strong/a")).click();
	          String namepage3=driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/p[1]/big/strong")).getText();  
	          if (namepage3.contentEquals("5. Get your Own db online"))
			     System.out.println(" home page loaded successfully........ ");
	          else
	          {
	        	Thread.sleep(1000);
	        	System.out.println("login page not loaded properly");
	        	System.out.println("exit from browser");
	        	driver.close();
	          }
	      
	      
	      }
	      else
	      {
	    	  System.out.println("please enter correct username and password");
	      }
	      System.out.println("all task done properly...");
	      System.out.println("closed the driver and exit");
	      driver.close();
             
	}

}
