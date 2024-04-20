package automationdemopack;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegistrationDemoPage extends BasePage {
	WebDriver driver;

	RegistrationDemoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Element Locators
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastName;

	// Action Methods
	public void enterFirstName(String firstName) {
		waitForVisibilityOfElements(driver, Duration.ofSeconds(10), this.firstName);
		this.firstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		waitForVisibilityOfElements(driver, Duration.ofSeconds(10), this.firstName);
		this.lastName.sendKeys(lastName);
//		List<WebElement> list=driver.findElements(By.xpath(""));
//		list.get(0).click();
	}

	public void selectGender(WebDriver driver, String gender) {
		int genderIndex = 0;
		if (gender.equals("Male")) {
			genderIndex = 1;
		} else if (gender.equals("Female")) {
			genderIndex = 2;
		} else {
			Assert.fail("Invalid Gender Selection");
		}
		driver.findElement(By.xpath("(//input[@name='sex'])[" + genderIndex + "]")).click();
	}

	public void selectExperience(WebDriver driver, int exp) {
		if (exp > 0 && exp <= 7) {
			driver.findElement(By.xpath("//input[@value='" + exp + "' and @name='exp']")).click();
		} else {
			Assert.fail("Invalid Experience Selection");
		}

	}

	public void exceptionHandling(WebDriver driver) {
		System.out.println("started");
		try{
			driver.findElement(By.xpath("(//div[contains(text(),'Techlisti')])")).click();
			driver.switchTo().newWindow(WindowType.WINDOW);
			
		}catch(Exception e){
			System.out.println("No elements found");
			driver.switchTo().newWindow(WindowType.TAB);
		}
	}

	public void selectvaluesfromdropdown(WebDriver driver) throws InterruptedException {
		Actions action = new Actions(driver);
		for (int i = 1; i < 8; i++) {
			action.moveToElement(driver.findElement(By.xpath("(//div[@class='dropdown'])[5]"))).build().perform();
			System.out.println(
					driver.findElement(By.xpath("((//div[@class='dropdown'])[5]//div//a)[" + i + "]")).getText());
			driver.findElement(By.xpath("((//div[@class='dropdown'])[5]//div//a)[" + i + "]")).click();
		}
	}

}
