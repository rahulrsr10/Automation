package automationdemopack;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterTest extends BaseTest {
	SoftAssert softassert;

	@Test
	public void testRegiterFunctionality() {
		RegistrationDemoPage registerPage = new RegistrationDemoPage(driver);
		registerPage.enterFirstName("Rahul");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 1000)");
		registerPage.enterLastName("Rode");
		registerPage.selectGender(driver, "Male");
		registerPage.selectExperience(driver, 5);
	}

//	@Test
//	public void testdropdown() throws InterruptedException {
//		RegistrationDemoPage registerPage = new RegistrationDemoPage(driver);
//		registerPage.selectvaluesfromdropdown(driver);
//	}
//	
//	@Test
//	public void exceptionHandling() {
//		RegistrationDemoPage registerPage = new RegistrationDemoPage(driver);
//		registerPage.exceptionHandling(driver);
//		
//		//scrolling
////		 JavascriptExecutor js = (JavascriptExecutor)driver;  
////	        js.executeScript("scrollBy(0, 4500)");
//////	        js.executeScript("alert('Welcome to Guru99');");  
////	        js.executeScript("window.location = 'https://demo.guru99.com/'");	
//	}
}
