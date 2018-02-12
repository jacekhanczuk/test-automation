package utils.synchronization;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

import website.webelement.Element;

public class ExpectedEvents {
	private WebDriver driver;
	private String callerClassName;
	private JavascriptExecutor js;
	private Actions actions;

	public ExpectedEvents(WebDriver driver, String callerClassName) {
		this.driver = driver;
		this.callerClassName = callerClassName;
		js = (JavascriptExecutor) driver;
		actions = new Actions(driver);
	}

	public ExpectedCondition<Boolean> elementIsClicked(final Element element) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				input.findElement(element.getLocation()).click();
				return true;
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, element.getLocation(), callerClassName);
			}
		};
	}

	public ExpectedCondition<String> getElementText(final Element element) {
		return new ExpectedCondition<String>() {

			@Override
			public String apply(WebDriver input) {
				return input.findElement(element.getLocation()).getText().isEmpty() ? null
						: input.findElement(element.getLocation()).getText();
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, element.getLocation(), callerClassName);
			}
		};
	}

	public ExpectedCondition<String> getElementAttribute(final Element element, final String attribute) {
		return new ExpectedCondition<String>() {

			@Override
			public String apply(WebDriver input) {
				return input.findElement(element.getLocation()).getAttribute(attribute);
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, element.getLocation(), callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> selectValue(final Element element, final String value) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				new Select(input.findElement(element.getLocation())).selectByValue(value);
				return true;
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, element.getLocation(), callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> moveToElementAndDisplayTarget(final Element moveToElement,
			final Element targetToBeDisplayedAfterMove) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				actions.moveToElement(input.findElement(moveToElement.getLocation())).perform();
				return input.findElement(targetToBeDisplayedAfterMove.getLocation()).isDisplayed();
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, targetToBeDisplayedAfterMove.getLocation(),
						callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> elementIsPresent(final Element element) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				return input.findElement(element.getLocation()).isDisplayed();
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, element.getLocation(), callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> elementIsNotPresent(final Element element) {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				try {
					input.findElement(element.getLocation()).isDisplayed();
				} catch (WebDriverException e) {
					return true;
				}
				return false;
			}

			@Override
			public String toString() {
				return TimeoutExceptionMessage.getTimeoutMessage(driver, element.getLocation(), callerClassName);
			}
		};
	}

	public ExpectedCondition<Boolean> jQueryIsNotActive() {
		return new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				return (boolean) js.executeScript(" return jQuery.active == 0");
			}
		};
	}

}