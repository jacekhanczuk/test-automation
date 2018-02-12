package selenium.pagefactory.location;

import org.openqa.selenium.By;

public class ByTypeCreator {

	public static By getTypeOfFindByObject(ElementLocator locator) {
		try {
			return (By) locator.getSelectorType().getConstructor(String.class).newInstance(locator.getExpression());
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
		return null;
	}
}
