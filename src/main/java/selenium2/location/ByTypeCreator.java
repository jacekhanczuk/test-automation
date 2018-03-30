package selenium.location;

import org.openqa.selenium.By;

public class ByTypeCreator {

	public static By getTypeOfFindByObject(Locator locator) {
		try {
			return (By) locator.getSelectorType().getConstructor(String.class).newInstance(locator.getExpression());
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static By getByTypeObjectWithValue(Locator locator, Object... args) {
		try {
			return (By) locator.getSelectorType().getConstructor(String.class).newInstance(locator.getExpressionWithValue(args));
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
		return null;
	}
}
