package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsAddToCartPage {

	@FindBy (xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")private WebElement addToCart;
	
	public SwagLabsAddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddToCart() {
		
		addToCart.click();
	}
}
