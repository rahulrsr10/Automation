package automationdemopack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	BasePage(WebDriver driver){
		this.driver=driver;
	}
    
    public void waitForVisibilityOfElements(WebDriver driver,Duration time,WebElement element) {
    	wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void waitForElementToBeClickable(WebDriver driver,Duration time,WebElement element) {
    	wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
