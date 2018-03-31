package website.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import selenium.webelement.Element;

public class DriverAction {
	private Actions action;

	public DriverAction(WebDriver driver) {
		action = new Actions(driver);
	}

	public void moveTo(Element element) {
		action.moveToElement(element.getWebElement()).perform();
	}

}
