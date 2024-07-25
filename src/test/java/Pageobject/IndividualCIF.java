package Pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Basepage;

public class IndividualCIF extends Basepage {
	
	Matcher matcher;
	public static String txnNumber=null;
	Basepage bp=new Basepage();

	
	public void navigatetocustomescreen() {
		bp.menuframes(driver);
		
		//To navigate to customer creation screen
		
		driver.findElement(By.xpath("//span[text()='User Menu']")).click();
		driver.findElement(By.xpath("(//span[text()='Customer'])[1]")).click();
	}
	   public void individualcust() {
		String originalWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[contains(text(),'Individual Customer')]")).click();
		Set<String> windows = driver.getWindowHandles();
		for(String CIFwindow :windows )
		{
			if(!CIFwindow.equals(originalWindow))
			{
				driver.switchTo().window(CIFwindow);
				}
		}
		driver.manage().window().maximize();
	}
	
	public void cifcreation() throws IOException {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	//Entering CIF creating datas
	
	WebElement title = driver.findElement(By.id("fieldName:TITLE"));
	Select s= new Select(title);
	s.selectByValue("MR");
	bp.datas(driver);	
	driver.findElement(By.id("fieldName:GIVEN.NAMES")).sendKeys(bp.getFirstname());
	driver.findElement(By.id("fieldName:NAME.1:1")).sendKeys(bp.getFullName());
	driver.findElement(By.id("fieldName:SHORT.NAME:1")).sendKeys(bp.getShortName());
	driver.findElement(By.xpath("//input[@value='MALE']")).click();
	driver.findElement(By.id("fieldName:MNEMONIC")).sendKeys(bp.getMnemonic());
	driver.findElement(By.id("fieldName:SECTOR")).sendKeys(bp.getSector());
	driver.findElement(By.xpath("//img[@title='Validate a deal']")).click();
	WebElement commit = driver.findElement(By.xpath("//img[@title='Commit the deal']"));
	WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(5));
	waits.until(ExpectedConditions.visibilityOf(commit));
	driver.findElement(By.xpath("//img[@title='Commit the deal']")).click();
	String custID=driver.findElement(By.xpath("//td[@class='message']")).getText();
	Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
	matcher = pattern.matcher(custID);
	}
	public void CIFIDverification() {
	if (matcher.find()) {
        txnNumber = matcher.group();
        System.out.println("Transaction number: " + txnNumber);
    } else {
        System.out.println("Transaction number not generated.");
    }
	
	driver.close();
	}
}
