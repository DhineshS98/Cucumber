package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Basepage {
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties p;
	public static String firstname;
	public static String FullName;
	public static String sector;
	public static String Mnemonic;
	public static String shortname;

	public void datas(WebDriver driver) throws IOException {
		fis = new FileInputStream("C:\\Users\\Yethi\\eclipse-workspace\\T24\\src\\main\\resources\\Data");
		p.load(fis);
		firstname = p.getProperty("GivenName");
		FullName = p.getProperty("GBfullName");
		sector = p.getProperty("Sector");
		shortname = p.getProperty("GBShortName");
		Mnemonic = p.getProperty("Mnemonic");
	}

	public String getFirstname() {
		return firstname;
	}

	public String getFullName() {
		return FullName;
	}

	public String getSector() {
		return sector;
	}

	public String getShortName() {
		return shortname;
	}

	public String getMnemonic() {
		return Mnemonic;
	}

	// To switch to frames :
	
	public void menuframes(WebDriver driver) {
		WebElement menuframe = driver.findElement(By.xpath("//frame[contains(@id,'menu')]"));
		driver.switchTo().frame(menuframe);
	}

}