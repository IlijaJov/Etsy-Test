package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavoritesPage extends BasicPage {

	// Setting up paths
	public By addFavoritesBtn = By.xpath("//button[@data-ui='favorite-listing-button']");
	public By favoritesMsg = By.id("confirmation-toast");

	// Importing constructors
	public FavoritesPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js, Actions actions) {
		super(driver, wait, js, actions);
		this.wait = new WebDriverWait(driver, 30, 10);
		this.actions = new Actions(driver);
		this.js = (JavascriptExecutor) driver;
	}

	// Finding and returning add to favorites button
	public WebElement getAddFavoritesBtn() {
		return this.driver.findElement(addFavoritesBtn);
	}

	// Finding and returning added to favorites message
	public WebElement getFavoritesMsg() {
		return driver.findElement(favoritesMsg);
	}
}
