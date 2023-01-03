package pomClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	public static String readDataFromPropertFile(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream myFile=new FileInputStream("/Users/utkarsh/eclipse-workspace/Testfire/testfire.properties");
		prop.load(myFile);
		String value = prop.getProperty(key);
		return value;
		
	}
	public static void waitMethod(WebDriver driver,int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
	}
	public static void screenshott(WebDriver driver,String str) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("/Users/utkarsh/Downloads/Screenshot/myScreenshot"+str+".jpg");
		FileHandler.copy(src, dest);					
	}
	public static void scrollIntoView(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView", element);
	}

}
