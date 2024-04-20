package uiutilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UiActionMethods {
	JavascriptExecutor js;
	WebDriver driver;
	public UiActionMethods(WebDriver driver){
		this.driver=driver;
	}
	public void scrollByCordinates(WebDriver driver,int x,int y) {
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy("+x+","+y+")");
	}

}
