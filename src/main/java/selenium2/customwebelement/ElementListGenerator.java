package selenium.customwebelement;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.location.Locator;

import java.util.ArrayList;
import java.util.List;

public class ElementListGenerator {

    public static List<CustomElement> generateListByIndex(CustomElement elementInterface, WebDriver webDriver) {
        List<CustomElement> customWebElementList = new ArrayList<>();
        List<WebElement> webElementList = elementInterface.getWebElementList();

        for (int i = 1; i <= webElementList.size(); i++) {
            customWebElementList.add(new CustomWebElement(new Locator(elementInterface.getLocator().getSelectorType(),
                            getIndexedExpression(elementInterface.getLocator().getExpression(), i)), webDriver));
        }
        return customWebElementList;
    }

    private static String getIndexedExpression(String expression, int index) {
        return "(" + expression + ")[" + Integer.toString(index) + "]";
    }
}
