package pomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base 
{
protected static WebDriver driver;
	
	public void launchChrome() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/utkarsh/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Utility.readDataFromPropertFile("url"));
		Utility.waitMethod(driver, 1000);
	}

}
