package Stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Hooks {
	public static WebDriver driver;
	
	@Before
	public void launch()
	{
		driver=new ChromeDriver();
	    driver.get("http://192.168.2.9:9089/BrowserWeb/servlet/BrowserServlet");
	    driver.manage().window().maximize();
	}
    @BeforeStep
    public void login()
    {
    	    driver.findElement(By.xpath("//input[@class='input_user']")).sendKeys("FTPUSER04");
    	    driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Test@123");
     	    driver.findElement(By.xpath("//input[@type='submit']")).click();
    	}
    
   
    
    }

