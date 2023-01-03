package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class HomePage 
{
	@FindBy(id = "MenuHyperLink1")private WebElement summaryButton;
	@FindBy(id = "listAccounts")private WebElement listDetails;
	@FindBy(id = "btnGetAccount")private WebElement goButton;
	@FindBy(xpath = "(//table[@cellspacing='0'])[4]//tr[4]")private WebElement balance;
	@FindBy(xpath = "//a[@id='MenuHyperLink3']")private WebElement transfer;
	@FindBy(id = "toAccount")private WebElement toAccount;
	@FindBy(id = "transferAmount")private WebElement amount;
	@FindBy(xpath = "(//input[@type='submit'])[2]")private WebElement transferButton;
	@FindBy(xpath = "//span[contains(text(),'9876.0 was successfully transferred from Account 800000 into Account 800001')]")private WebElement successMsg;
	@FindBy(xpath = "//a[@id='MenuHyperLink2']")private WebElement recentTransaction;
	@FindBy(xpath = "//table[@id='_ctl0__ctl0_Content_Main_MyTransactions']//tr[2]")private WebElement deposit;
	@FindBy(xpath = "//table[@id='_ctl0__ctl0_Content_Main_MyTransactions']//tr[2]")private WebElement withdraw;
	@FindBy(xpath = "//a[@id='HyperLink3']")private WebElement contactUs;
	@FindBy(xpath = "//a[text()='online form']")private WebElement onlineForm;
	@FindBy(xpath = "//textarea[@name='comments']")private WebElement commentBox;
	@FindBy(xpath = "//input[@name='submit']")private WebElement submit;
	@FindBy(xpath = "//h1[text()='Thank You']")private WebElement thank;
	@FindBy(id="LoginLink")private WebElement signOff;
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickViewSummary() throws InterruptedException {
		summaryButton.click();
		Thread.sleep(1000);
	}
	public void handleList() throws InterruptedException {
		Select s=new Select(listDetails);
		s.selectByValue("800001");
		Thread.sleep(500);
	}
	public void clickGo() throws InterruptedException {
		goButton.click();
		Thread.sleep(500);
	}
	public String getAvailableBalance() {
		String avalBal = balance.getText();
		return avalBal;
	}
	public void clickTransferFunds() throws InterruptedException {
		transfer.click();
		Thread.sleep(500);
	}
	public void selectToAccount() throws InterruptedException {
		Select s = new Select(toAccount);
		s.selectByValue("800001");
		Thread.sleep(500);
	}
	public void enterAmountTobeTransfered(WebDriver driver,String amt) 
	{
		amount.sendKeys(amt);
		Reporter.log("Entered Amount tobe transfered");
		Utility.waitMethod(driver, 1000);
		
	}
	public void clickTransferButton() throws InterruptedException {
		transferButton.click();
		Thread.sleep(500);
	}
	public String getTransferSuccessMsg()
	{
		String msg = successMsg.getText();
		Reporter.log("Getting success message",true);
		return msg;
		
	}
	public void clickRecentTransaction() throws InterruptedException {
		recentTransaction.click();
		Thread.sleep(500);
	}
	public String depositText() {
		String depo = deposit.getText();
		return depo;
	}
	public String WithdrawText() {
		String withdraww = withdraw.getText();
		return withdraww;
	}
	public void clickContactUs() throws InterruptedException {
		contactUs.click();
		Thread.sleep(500);
	}
	public void clickOnlineForm() throws InterruptedException {
		onlineForm.click();
		Thread.sleep(500);
	}
	public void sendTextToComment(String txt) {
		commentBox.sendKeys(txt);
		
	}
	public void clickSubmit() throws InterruptedException {
		submit.click();
		Thread.sleep(1000);
	}
	public String getThankYou() {
		String thankU = thank.getText();
		return thankU;
	}
	public void clickSignOff() throws InterruptedException {
		signOff.click();
		Thread.sleep(1000);
	}

}
