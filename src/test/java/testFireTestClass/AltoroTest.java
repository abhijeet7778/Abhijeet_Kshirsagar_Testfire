package testFireTestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomClasses.Base;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import pomClasses.Utility;

	public class AltoroTest extends Base{
	LoginPage login;
	HomePage home;
	String str="Abhijeet";
	
@BeforeClass
	public void openBrowser() throws IOException, InterruptedException {
		launchChrome();
		
		login=new LoginPage(driver);
		home=new HomePage(driver);
	}
@BeforeMethod
public void signInToAltoroMutual() throws IOException, InterruptedException 
{
	login.clickSignIn(driver);
	login.enterUname(driver, Utility.readDataFromPropertFile("id"));
	login.enterPwd(driver, Utility.readDataFromPropertFile("pwd"));
	login.clickLogin(driver);
	Reporter.log("Username and password correct.Successful login",true);
	home.clickViewSummary();
	home.handleList();
	home.clickGo();
	System.out.println(home.getAvailableBalance());
	
	
	
}
  @Test
  public void validateBalance() throws IOException 
  {
	  Assert.assertNotNull(home.getAvailableBalance(),"TC failed Unable to fetch account Balance" );
	  Utility.screenshott(driver, "ACCBalance");
	  
  }
  @AfterMethod
  public void transferOfFunds() throws IOException, InterruptedException {
	    home.clickTransferFunds();
		home.selectToAccount();
		home.enterAmountTobeTransfered(driver, Utility.readDataFromPropertFile("amt"));
		home.clickTransferButton();
		System.out.println(home.getTransferSuccessMsg());
		home.clickRecentTransaction();
		System.out.println(home.depositText());
		System.out.println(home.WithdrawText());
		
  }
  @AfterClass
  public void signingOff() throws InterruptedException, IOException {
	  home.clickContactUs();
	  home.clickOnlineForm();
	  home.sendTextToComment(Utility.readDataFromPropertFile("txt"));
	  home.clickSubmit();
	  System.out.println(home.getThankYou());
	  home.clickSignOff();
	  Reporter.log("Logged out successfully");
	  driver.close();
  }
}
