package api.selenium.annotationlab;

import org.openqa.selenium.By;
import website.locator.Locator;

public class ByTypeCreator {

	public static By getByTypeObject(Locator locator) {
		try {
			return (By) locator.getSelectorType().getConstructor(String.class).newInstance(locator.getExpression());
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
		return null;
	}
}
