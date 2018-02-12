package website.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import website.webelement.Element;

public class DriverActions {
	private Actions action;

	public DriverActions(WebDriver driver) {
		action = new Actions(driver);
	}

	public void moveTo(Element element) {
		action.moveToElement(element.getWebElement()).perform();
	}

}
