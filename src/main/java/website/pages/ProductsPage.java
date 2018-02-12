package website.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.pagefactory.annotation.Selector;
import website.pages.page.BasePage;
import website.pages.page.annotation.Page;
import website.webelement.Element;

@Page(urlPath = "philosophy-psychology-social-sciences")
public class ProductsPage extends BasePage {

	@Selector(xpath = "//div[@data-sku='%s']")
	private Element product;

	@Selector(xpath = "//div[@class='BookTitle']/a[@class='Title']")
	private Element products;

	@Selector(linkText = "%s")
	private Element book;
	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public void clickProduct(String productText) {
		book.withValue(productText).click();
	}

	public void print() {
		for (WebElement element : products.getWebElementList()) {

			System.out.println(element.getText());
		}
	}

	public void clickProductBySku(String productSku) {
		product.withValue(productSku).click();
	}

}