package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabsAddToCartPage;
import utility.SwagLabsPageElement;

@Listeners(utility.Listneres.class)
public class SwagLabsAddToCartTest extends SwagLabsPageElement{
	
	@BeforeMethod
	public void openBrowser() {
		
		driver=Browser.openBrowser();
	}
	
	@Test
	public void swagLabsAddToCart() {
		
		SwagLabsAddToCartPage swagLabsAddToCartPage = new SwagLabsAddToCartPage(driver);
		swagLabsAddToCartPage.clickOnAddToCart();
	}

}
