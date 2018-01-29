package selenium.pagefactory.location;

import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.By.ByXPath;

import selenium.pagefactory.annotation.Selector;
import website.locator.Locator;

public class SelectorResolver {

	public static Locator resolveTypeOfByStatement(Selector selector) {
		return defineStatement(selector);
	}

	private static Locator defineStatement(Selector selector) {

		if (isDefined(selector.xpath())) {
			return createLocator(ByXPath.class, selector.xpath());
		}

		if (isDefined(selector.id())) {
			return createLocator(ById.class, selector.id());
		}

		if (isDefined(selector.css())) {
			return createLocator(ByCssSelector.class, selector.css());
		}

		if (isDefined(selector.className())) {
			return createLocator(ByClassName.class, selector.className());
		}

		if (isDefined(selector.linkText())) {
			return createLocator(ByLinkText.class, selector.linkText());
		}

		if (isDefined(selector.tagName())) {
			return createLocator(ByTagName.class, selector.tagName());
		}

		return null;
	}

	private static Locator createLocator(Class<?> selectorType, String expression) {
		return new Locator(selectorType, expression);
	}

	private static boolean isDefined(String selectorExpression) {
		return !selectorExpression.equals("") && selectorExpression != null;
	}
}
