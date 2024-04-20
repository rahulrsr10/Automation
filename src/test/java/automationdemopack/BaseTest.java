package automationdemopack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void startup(String browser) {
		  if(browser.equalsIgnoreCase("firefox")) {
			  driver = new FirefoxDriver();	  
		  }else if (browser.equalsIgnoreCase("chrome")) { 
			  driver = new ChromeDriver();
		  } else if(browser.equalsIgnoreCase("edge")) {
			  driver = new EdgeDriver();
		  }
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
