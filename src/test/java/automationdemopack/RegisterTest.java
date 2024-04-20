package automationdemopack;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
	@Test
	public void testRegiterFunctionality() throws InterruptedException, IOException {
		RegistrationDemoPage registerPage = new RegistrationDemoPage(driver);
		registerPage.enterFirstName("Rahul");
		registerPage.enterLastName("Rode");
		registerPage.selectGender(driver, "Male");
		registerPage.selectExperience(driver, 5);
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File("C:\\Users\\HP\\eclipse-workspace\\Automation\\test-output\\1.png");
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	    Files.deleteIfExists(Paths.get("C:\\Users\\HP\\eclipse-workspace\\Automation\\test-output\\1.png"));
	}
//
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
//	}
}
