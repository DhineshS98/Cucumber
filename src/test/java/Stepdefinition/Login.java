package Stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
    public static WebDriver driver;
    String loginmessage;


	@Then("it as to navigate to the homepage screen to validate login successful message")
	public void validatehomescreen() {
		System.out.println(driver);
		driver.switchTo().frame(0);
		loginmessage=driver.findElement(By.xpath("//span[@class='bannertxt']")).getText();
	    String loginsuccessfulmessage=driver.findElement(By.xpath("//span[@class='bannertxt']")).getText();
	    System.out.println(loginsuccessfulmessage);
	    Assert.assertEquals(loginmessage, loginsuccessfulmessage);
	    driver.findElement(By.xpath("//a[@title='Sign off']")).click();
	    driver.close();
	}
}
