package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class Listeners extends AbstractWebDriverEventListener {


    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        //super.beforeNavigateTo(url, driver);
        System.out.println("url: " + url);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

        System.out.println("by" + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {

    }

     @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("klikam w: " + element);

        for(int i = 0; i < 1; i++){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: green; border: 3px solid red;");
        }


    }
}
