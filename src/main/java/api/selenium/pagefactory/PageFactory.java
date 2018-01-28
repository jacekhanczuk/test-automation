package api.selenium.pagefactory;

import java.lang.reflect.Field;
import org.openqa.selenium.WebDriver;

import api.selenium.pagefactory.annotation.Selector;
import api.selenium.pagefactory.location.SelectorResolver;
import website.elements.Element;
import website.locator.Locator;

public class PageFactory {

	private static <T> T createPageInstance(Class<T> pageClass) {
		try {
			return pageClass.newInstance();
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
				Locator locator = resolveSelectorStatement(selector);
				Element element = null;
				try {
					element = (Element) field.getType().getConstructor(Locator.class, WebDriver.class)
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

	private static Locator resolveSelectorStatement(Selector annotation) {
		return SelectorResolver.resolveTypeOfByStatement(annotation);
	}

	public static <T> T initElements(Class<T> pageClass, WebDriver driver) {
		T page = createPageInstance(pageClass);
		injectValues(page, driver);
		return page;
	}

}
