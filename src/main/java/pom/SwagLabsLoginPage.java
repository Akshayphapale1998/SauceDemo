package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsLoginPage {
	
	@FindBy (xpath = "//input[@id='user-name']")private WebElement userID;
	@FindBy (xpath = "//input[@id='password']")private WebElement password;
	@FindBy (xpath = "//input[@id='login-button']")private WebElement login;
	@FindBy (xpath = "//div[@class='error-message-container error']")private WebElement errorMsg;
	
	public SwagLabsLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
	public void enterUserId(String UserID) {
		
		userID.sendKeys(UserID);
	}
	
	public void enterPassword(String pass) {
		
		password.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		
		login.click();
	}
	
	public void getErrorMsg() {
		
		errorMsg.getText();
	}
}
