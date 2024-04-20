package automationdemopack;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import uiutilities.UiActionMethods;

public class RegisterTest extends BaseTest {
	SoftAssert softassert;
	UiActionMethods uiActions;
	@Test
	public void testRegiterFunctionality() throws InterruptedException {
		RegistrationDemoPage registerPage = new RegistrationDemoPage(driver);
		registerPage.enterFirstName("Rahul");
		registerPage.enterLastName("Rode");
		registerPage.selectGender(driver, "Male");
		registerPage.selectExperience(driver, 5);
	}

	@Test
	public void testdropdown() throws InterruptedException {
		RegistrationDemoPage registerPage = new RegistrationDemoPage(driver);
		registerPage.selectvaluesfromdropdown(driver);
	}
	
	@Test
	public void exceptionHandling() {
		RegistrationDemoPage registerPage = new RegistrationDemoPage(driver);
		registerPage.exceptionHandling(driver);	
	}
}
