package selenium.pagefactory;

import java.lang.reflect.Field;
import org.openqa.selenium.WebDriver;

import selenium.pagefactory.annotation.Selector;
import selenium.pagefactory.location.ElementLocator;
import selenium.pagefactory.location.SelectorResolver;
import selenium.webelement.Element;

public class PageFactory {

	private static <T> T createPageInstance(Class<T> pageClass, WebDriver driver) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static <T> void injectValues(T page, WebDriver driver) {
		Field[] declaredFields = page.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			if (field.isAnnotationPresent(Selector.class)) {
				Selector selector = field.getAnnotation(Selector.class);
				ElementLocator locator = resolveSelectorStatement(selector);
				Element element = null;
				try {
					element = (Element) field.getType().getConstructor(ElementLocator.class, WebDriver.class)
							.newInstance(locator, driver);
					field.setAccessible(true);
					field.set(page, element);
					field.setAccessible(false);
				} catch (ReflectiveOperationException e) {
					e.printStackTrace();
				}

			}
		}
	}

	private static ElementLocator resolveSelectorStatement(Selector annotation) {
		return SelectorResolver.resolveTypeOfByStatement(annotation);
	}

	public static <T> T initElements(Class<T> pageClass, WebDriver driver) {
		T page = createPageInstance(pageClass, driver);
		injectValues(page, driver);
		return page;
	}

}
