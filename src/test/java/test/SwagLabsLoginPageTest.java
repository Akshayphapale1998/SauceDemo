package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabsLoginPage;
import utility.ExtentReport;
import utility.Parametrization;
import utility.SwagLabsPageElement;

@Listeners(utility.Listneres.class)
public class SwagLabsLoginPageTest extends SwagLabsPageElement{

	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReport() {
		reports=ExtentReport.getReports();
		
	}
	
	@BeforeMethod
	public void opnBrowser() {
		
		driver =Browser.openBrowser();
	}
	
	@Test
	public void swagLabsLoginTest() throws EncryptedDocumentException, IOException {
		test=reports.createTest("swagLabsLoginTest");
		SwagLabsLoginPage swagLabsLoginPage= new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUserId(Parametrization.getExcelSheet("Credentials", 0, 0));
		swagLabsLoginPage.enterPassword(Parametrization.getExcelSheet("Credentials", 1, 0));
		swagLabsLoginPage.clickOnLogin();
		String expectedUrl="https://www.saucedemo.com/inventory.htm";
		
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
	}
	
	@AfterMethod
	public void addResults(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else 
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	
	@AfterTest
	public void flushReport() {
		reports.flush();
	}
}
