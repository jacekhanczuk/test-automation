package utils.synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimeoutExceptionMessage {

	public static String getTimeoutMessage(WebDriver driver, WebElement element, String callerClassName) {
		return getCallerMethodFromStackTraceByClassName(callerClassName) + "\nElement: " + element + "\nurl: "
				+ getCurrentUrlMessage(driver);
	}

	public static String getTimeoutMessage(WebDriver driver, String callerClassName) {
		return getCallerMethodFromStackTraceByClassName(callerClassName) + "\nElement: " + " Any of the list was found "
				+ "\nurl: " + getCurrentUrlMessage(driver);
	}

	public static String getTimeoutMessage(WebDriver driver, By locator, String callerClassName) {
		return getCallerMethodFromStackTraceByClassName(callerClassName) + "\nElement: " + locator + "\nurl: "
				+ getCurrentUrlMessage(driver);
	}

	public static String getCausedByMessage(Throwable lastException) {
		return (lastException != null) ? "\nCaused by: " + lastException.getClass().getName() : "";
	}

	public static String getCurrentUrlMessage(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	private static String getCallerMethodFromStackTraceByClassName(String callerClassName) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		for (StackTraceElement element : stackTraceElements) {
			if (element.getClassName().contains(callerClassName))
				return element.getClassName() + "." + element.getMethodName();
		}
		return "";
	}
}