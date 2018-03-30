package selenium.pagefactory;

import java.lang.reflect.Field;
import org.openqa.selenium.WebDriver;

import selenium.annotation.Selector;
import selenium.customwebelement.CustomElement;
import selenium.location.Locator;
import selenium.location.SelectorResolver;
import selenium.customwebelement.CustomWebElement;

public class CustomPageFactory {

	private static <T> T createPageInstance(WebDriver driver, Class<T> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static <T> void injectValues(WebDriver driver, T page) {
		Field[] declaredFields = page.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			if (field.isAnnotationPresent(Selector.class)) {
				Selector selector = field.getAnnotation(Selector.class);
				Locator locator = resolveSelectorStatement(selector);
				try {
					field.setAccessible(true);
					field.set(page, new CustomWebElement(locator,driver));
					field.setAccessible(false);
				} catch (ReflectiveOperationException e) {
					e.printStackTrace();
				}

			}
		}
	}

	private static Locator resolveSelectorStatement(Selector annotation) {
		return SelectorResolver.resolveTypeOfByStatement(annotation);
	}

	public static <T> T initElements( WebDriver driver, Class<T> pageClass) {
		T page = createPageInstance(driver, pageClass);
		injectValues(driver, page);
		return page;
	}

}
