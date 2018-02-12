package utils.synchronization;

import org.openqa.selenium.WebDriver;
import website.elements.Element;

public class CustomFluentWait {
	private FluentWaitFactory waitFactory;
	private ExpectedEvents expectedEvents;

	public CustomFluentWait(WebDriver driver) {
		waitFactory = new FluentWaitFactory(driver);
		expectedEvents = new ExpectedEvents(driver, this.getClass().getName());
	}

	public void waitForElementDisplayed(final Element element) {
		waitFactory.getCustomWait().until(expectedEvents.elementIsPresent(element));
	}

	public void waitForElementDisplayed(final Element element, final int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.elementIsPresent(element));
	}

	public void waitForElementIsNotPresent(final Element element) {
		waitFactory.getCustomWait().until(expectedEvents.elementIsNotPresent(element));
	}

	public void waitForElementIsNotPresent(final Element element, final int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.elementIsNotPresent(element));
	}

	public void clickElement(final Element element) {
		waitFactory.getCustomWait().until(expectedEvents.elementIsClicked(element));
	}

	public void clickElement(final Element element, final int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.elementIsClicked(element));
	}

	public void selectDropdownValue(final Element element, final String value) {
		waitFactory.getCustomWait().until(expectedEvents.selectValue(element, value));
	}

	public void selectDropdownValue(final Element element, final String value, final int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.selectValue(element, value));
	}

	public String getElementText(final Element element) {
		return waitFactory.getCustomWait().until(expectedEvents.getElementText(element));
	}

	public String getElementText(final Element element, final int timeoutInSeconds) {
		return waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.getElementText(element));
	}

	public String getElementAttribute(final Element element, final String attribute) {
		return waitFactory.getCustomWait().until(expectedEvents.getElementAttribute(element, attribute));
	}

	public String getElementAttribute(final Element element, final String attribute, final int timeoutInSeconds) {
		return waitFactory.getCustomWait(timeoutInSeconds)
				.until(expectedEvents.getElementAttribute(element, attribute));
	}

	public void waitForContentIsLoaded(int timeoutInSeconds) {
		waitFactory.getCustomWait(timeoutInSeconds).until(expectedEvents.jQueryIsNotActive());
	}

}