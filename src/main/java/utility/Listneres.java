package utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listneres extends SwagLabsPageElement implements ITestListener{
	
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Is success :" +result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
	   try {
		   Screenshot.takeScreenshot(driver,result.getName());
		   }catch(Exception e) {
			   e.printStackTrace();
		      }		
	}
	
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test Is Skipped : " + result.getName());
	}
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test Is Started : "+ result.getName());
	}
}
