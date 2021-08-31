package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasicPage {

	// Setting up paths
	public By addToCartBtn = By.xpath("//button[@class='wt-btn wt-btn--filled wt-width-full']");
	public By personalMsgOptional = By.id("personalization-field-label");
	public By personalMsg = By.id("personalization-input");
	public By variationZero = By.id("variation-select-0");
	public By variationFirst = By.id("variation-select-1");

	// Importing constructors
	public ShoppingCartPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js, Actions actions) {
		super(driver, wait, js, actions);
		this.wait = new WebDriverWait(driver, 30, 10);
		this.js = (JavascriptExecutor) driver;
	}

	// Finding and returning add to cart button
	public WebElement getAddToCartBtn() {
		return this.driver.findElement(addToCartBtn);
	}

	// Finding and returning first select option for items
	public Select getVariation0() {
		Select variation0 = new Select(driver.findElement(By.id("variation-select-0")));
		return variation0;
	}

	// Finding and returning second select option for items
	public Select getVariation1() {
		Select variation1 = new Select(driver.findElement(By.id("variation-select-1")));
		return variation1;
	}

	// Finding and returning personal message field
	public WebElement getPersonalMsg() {
		return driver.findElement(personalMsg);
	}

	// Finding and returning optional personal message field
	public WebElement getPersonalMsgOptional() {
		return driver.findElement(personalMsgOptional);
	}
}
