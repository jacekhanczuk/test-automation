package selenium.customwebelement;

import org.openqa.selenium.WebElement;
import selenium.location.Locator;

import java.util.List;

public interface CustomElement {

    boolean isDisplayed();

    boolean isEnabled();

    boolean isSelected();

    void click();

    void sendKeys(String text);

    String getText();

    String getAttribute(String attribute);

    CustomElement withValue(Object... args);

    Locator getLocator();

    WebElement getWebElement();

    List<WebElement> getWebElementList();

    List<CustomElement> getCustomElementList();

}
