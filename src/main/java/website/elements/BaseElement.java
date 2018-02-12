package website.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.pagefactory.location.ByTypeCreator;
import selenium.pagefactory.location.ElementLocator;

public class BaseElement {
	private By by;
	private WebDriver driver;
	private ElementLocator locator;

	public BaseElement(ElementLocator locator, WebDriver driver) {
		this.driver = driver;
		this.locator = locator;
		initLocationData();
	}

	private void initLocationData() {
		by = ByTypeCreator.getTypeOfFindByObject(locator);
	}

	private void updateLocation() {
		initLocationData();
	}

	public By getLocation() {
		return by;
	}

	public WebElement getWebElement() {
		return driver.findElement(by);
	}

	public List<WebElement> getWebElementList() {
		return driver.findElements(by);
	}

	public boolean isDisplayed() {
		return getWebElement().isDisplayed();
	}

	public boolean isEnabled() {
		return getWebElement().isEnabled();
	}

	public boolean isSelected() {
		return getWebElement().isSelected();
	}

	public BaseElement withValue(String value) {
		locator.insertValueIntoExpression(value);
		updateLocation();
		return this;
	}

}
