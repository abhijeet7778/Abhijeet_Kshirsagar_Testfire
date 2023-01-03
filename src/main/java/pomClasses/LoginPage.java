package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage 
{
	@FindBy(id="LoginLink") private WebElement signIn;
	@FindBy(xpath = "//input[@id='uid']") private WebElement userID;
	@FindBy(id = "passw") private WebElement pass;
	@FindBy(xpath = "(//input[@type='submit'])[2]") private WebElement loginButton;
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignIn(WebDriver driver) 
	{
		signIn.click();
		Utility.waitMethod(driver, 1000);
	}
	public void enterUname(WebDriver driver,String id) 
	{
		userID.sendKeys(id);
		Reporter.log("Entering userName",true);
		Utility.waitMethod(driver, 1000);
		
	}
	public void enterPwd(WebDriver driver,String pwd) 
	{
		pass.sendKeys(pwd);
		Reporter.log("Entering password",true);
		Utility.waitMethod(driver, 1000);
		
	}
	public void clickLogin(WebDriver driver) 
	{
		loginButton.click();
		Utility.waitMethod(driver, 1000);
	}
	

}
