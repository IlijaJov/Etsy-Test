package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import random.RandomData;

public class SearchPage extends BasicPage {

	// Setting up paths
	public By searchBar = By.name("search_query");
	public By searchBtn = By.xpath("//button[@data-id='gnav-search-submit-button']");
	public By filters = By.cssSelector("#search-filter-button");
	public By specialOffers = By.xpath("//label[@for='special-offers-free-shipping']");
	public By readyToShip = By.xpath("//*[contains(text(), '1 business day' )]");
	public By priceMin = By.cssSelector("#search-filter-min-price-input");
	public By priceMax = By.name("max");
	public By shop = By.xpath("//label[@for='shop-location-input-1']");
	public By applyBtn = By.xpath("//*[contains(text(),'Apply')]");
	public By shipTo = By.name("ship_to");

	// Importing constructors
	public SearchPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js, Actions actions) {
		super(driver, wait, js, actions);
		this.wait = new WebDriverWait(driver, 30, 10);
		this.js = (JavascriptExecutor) driver;
		this.actions = new Actions(driver);
	}

	// Finding and returning search bar
	public WebElement getSearchBar() {
		return driver.findElement(searchBar);
	}

	// Finding and returning search button
	public WebElement getSearchBtn() {
		return driver.findElement(searchBtn);
	}

	// Finding and returning all filters button
	public WebElement getFilters() {
		return driver.findElement(filters);
	}

	// Finding and returning special offers checkbox
	public WebElement getSpecialOffers() {
		return driver.findElement(specialOffers);
	}

	// Finding and returning ready to ship checkbox
	public WebElement getReadyToShip() {
		return driver.findElement(readyToShip);
	}

	// Finding and returning low price field
	public WebElement getPriceMin() {
		return driver.findElement(priceMin);
	}

	// Finding and returning high price field
	public WebElement getPriceMax() {
		return driver.findElement(priceMax);
	}

	// Finding and returning shop location radio button
	public WebElement getShop() {
		return driver.findElement(shop);
	}

	// Finding and returning ship to country dropdown
	public Select getShipTo() {
		Select country = new Select(driver.findElement(shipTo));
		return country;
	}

	// Finding and returning item
	public WebElement getItem(String itemNo) {
		return driver.findElement(By.xpath("//*[@data-position-num='" + itemNo + "']"));
	}

	// Finding and returning apply button
	public WebElement getApplyBtn() {
		return driver.findElement(applyBtn);
	}

	// Setting up a method for searching random items
	public void searchItems(String item) {
		// Entering random items in search bar
		this.getSearchBar().sendKeys(item);

		// Clicking on search button
		this.getSearchBtn().click();
	}

	// Setting up a method for selecting random items
	public void selectItems() {
		// Clicking on random item
		this.getItem(RandomData.randomNumber()).click();
	}

}
