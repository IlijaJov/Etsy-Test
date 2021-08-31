package tests;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import random.RandomData;

public class MainTest extends BasicTest {

	@Test(priority = 0)
	public void registerAnAccount() throws InterruptedException {

		// Verifying that sign in button exists and clicking on it
		Assert.assertTrue(elementExists(signInRegisterPage.signInBtn), "Sign in button is not present.");
		signInRegisterPage.getSignInBtn().click();

		// Verifying that email field exists and waiting until it's clickable, then
		// entering random email address
		Assert.assertTrue(elementExists(signInRegisterPage.email), "Email field is not present.");
		this.wait.until(ExpectedConditions.elementToBeClickable(signInRegisterPage.getEmail()));
		signInRegisterPage.getEmail().sendKeys(RandomData.randomEmail());

		// Verifying that continue button exists, clicking on it
		Assert.assertTrue(elementExists(signInRegisterPage.continueBtn), "Continue button is not present.");
		signInRegisterPage.getContinueBtn().click();

		// Pausing the app for one second
		Thread.sleep(1000);

		// Verifying that first name field exists and entering random first name
		Assert.assertTrue(elementExists(signInRegisterPage.firstName), "First name field is not present.");
		signInRegisterPage.getFirstName().sendKeys(RandomData.randomName());

		// Verifying that password field exists and entering random password
		Assert.assertTrue(elementExists(signInRegisterPage.password), "Password field is not present.");
		signInRegisterPage.getPassword().sendKeys(RandomData.randomPassword());

		//// Pausing the app for one second
		Thread.sleep(1000);

		// Verifying that submit button exists and clicking on it
		Assert.assertTrue(elementExists(signInRegisterPage.submitBtn), "Submit button is not present.");
		signInRegisterPage.getSubmitBtn().click();

		// Refreshing the page
		driver.navigate().refresh();

		// Pausing the app for three seconds so that page refresh can be seen
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void LogIn() throws InterruptedException {

		// Verifying that sign in button exists and clicking on it
		Assert.assertTrue(elementExists(signInRegisterPage.signInBtn), "Sign in button is not present.");
		signInRegisterPage.getSignInBtn().click();

		// Pausing the app for one second
		Thread.sleep(1000);

		// Verifying that email field exists and entering predefined email address
		Assert.assertTrue(elementExists(signInRegisterPage.email), "Email field is not present.");
		signInRegisterPage.getEmail().sendKeys(email);

		// Verifying that continue button exists and clicking on it
		Assert.assertTrue(elementExists(signInRegisterPage.continueBtn), "Continue button is not present.");
		signInRegisterPage.getContinueBtn().click();

		// Pausing the app for one second
		Thread.sleep(1000);

		// Verifying that password field exists and entering predefined password
		Assert.assertTrue(elementExists(signInRegisterPage.password), "Password field is not present.");
		signInRegisterPage.getPassword().sendKeys(password);

		// Verifying that submit button exists and clicking on it
		Assert.assertTrue(elementExists(signInRegisterPage.submitBtn), "Submit button is not present.");
		signInRegisterPage.getSubmitBtn().click();

		// Refreshing the page
		driver.navigate().refresh();

		// Pausing the app for three seconds so that refresh can be seen
		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void filterItems() throws InterruptedException {

		// Verifying that search bar exists end entering random item to search
		Assert.assertTrue(elementExists(searchPage.searchBar), "Search bar is not present.");
		searchPage.getSearchBar().sendKeys(RandomData.randomItem());

		// Verifying that search button exists and clicking on it
		Assert.assertTrue(elementExists(searchPage.searchBtn), "Search button is not present.");
		searchPage.getSearchBtn().click();

		// Verifying that all filters button exists
		Assert.assertTrue(elementExists(searchPage.filters), "All filters button is not present.");
		// Waiting until all filters button is clickable
		this.wait.until(ExpectedConditions.elementToBeClickable(searchPage.getFilters()));
		// Clicking on all filters button
		searchPage.getFilters().click();

		// Pausing the app for one second
		Thread.sleep(1000);

		// Verifying that special offers checkbox exists and clicking on it
		Assert.assertTrue(elementExists(searchPage.specialOffers), "Special offers checkbox is not present.");
		searchPage.getSpecialOffers().click();

		// Pausing the app for one second
		Thread.sleep(1000);

		// Verifying that ready to ship in # days checkbox exists and clicking on it
		Assert.assertTrue(elementExists(searchPage.readyToShip), "Ready to ship checkbox is not present.");
		searchPage.getReadyToShip().click();

		// Pausing the app for one hundred milliseconds
		Thread.sleep(100);

		// Verifying that low price field exists and entering random minimal value
		Assert.assertTrue(elementExists(searchPage.priceMin), "Low price field is not present.");
		searchPage.getPriceMin().sendKeys(RandomData.randomMinNumber());

		// Pausing the app for one hundred milliseconds
		Thread.sleep(100);

		// Verifying that high price field exists and entering random maximal value
		Assert.assertTrue(elementExists(searchPage.priceMax), "High price field is not present.");
		searchPage.getPriceMax().sendKeys(RandomData.randomMaxNumber());

		// Pausing the app for five hundred milliseconds
		Thread.sleep(500);

		// Verifying that shop location radio button exists and clicking on it
		Assert.assertTrue(elementExists(searchPage.shop), "Shop location radio button is not present.");
		searchPage.getShop().click();

		// Scrolling down to ships to dropdown menu using javascript executor
		js.executeScript("arguments[0].scrollIntoView(true);", searchPage.getShipTo());

		// Pausing the app for one second
		Thread.sleep(1000);

		// Verifying that ships to dropdown menu exists and selecting Serbia from it
		Assert.assertTrue(elementExists(searchPage.shipTo), "Ship to dropdown menu is not present.");
		searchPage.getShipTo().selectByVisibleText("Serbia");

		// Verifying that apply button exists and clicking on it
		Assert.assertTrue(elementExists(searchPage.applyBtn), "Apply button is not present.");
		searchPage.getApplyBtn().click();
	}

	@Test(priority = 3) // This test can take different time to finish depending on the items as it has
						// to go through every if individually
	public void addToCart() throws InterruptedException { // also stale element reference can occur because the items
															// are selected randomly
															// and in one test same item can be opened twice
		// Setting up a for loop that will count three iterations
		for (int i = 0; i < 3; i++) {

			// Deleting text from search bar
			searchPage.getSearchBar().clear();

			// Using searchItems method to find random item
			searchPage.searchItems(RandomData.randomItem());

			// Pause an app for five hundred milliseconds
			Thread.sleep(500);

			// Using selectItems method to select random item on the page
			searchPage.selectItems();

			// Setting up an array list that will contain names of tabs
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

			// Switching to newly opened tab
			driver.switchTo().window(tabs.get(1));

			// Setting up booleans for checking whether options are present
			boolean variation0Present = false;
			boolean variation1Present = false;
			boolean personalizationPresent = false;

			// As not every item has the same options it is not possible to use assert
			// command because the test will fail
			// for not finding an element that should not be on page
			// Instead three if statements are added that check the size of these two
			// options and message field
			// If an option is found on page second value will be selected for it, or a
			// message will be entered
			// If an option isn't found a boolean will remain false and the test will
			// continue

			if (driver.findElements(By.id("variation-select-0")).size() != 0) {
				shoppingCartPage.getVariation0().selectByIndex(1);
			}

			else {
				variation0Present = false;
			}

			// Pausing the app for one second
			Thread.sleep(1000);

			if (driver.findElements(By.id("variation-select-1")).size() != 0) {
				shoppingCartPage.getVariation1().selectByIndex(1);
			}

			else {
				variation1Present = false;
			}

			// Pausing the app for one second
			Thread.sleep(1000);

			if (driver.findElements(By.id("personalization-input")).size() != 0
					&& driver.findElements(By.id("personalization-field-label")).size() == 0) {
				shoppingCartPage.getPersonalMsg().sendKeys("Happy Birthday");
			}

			else {
				personalizationPresent = false;
			}

			// Pausing the app for one second
			Thread.sleep(1000);

			// Verifying that add to cart button exists and and clicking on it
			Assert.assertTrue(elementExists(shoppingCartPage.addToCartBtn), "Add to cart button is not present.");
			shoppingCartPage.getAddToCartBtn().click();

			// Pausing the app for one second
			Thread.sleep(1000);

			// Closing the current tab
			driver.close();

			// Pausing the app for one second
			Thread.sleep(1000);

			// Switching back to first tab with items
			driver.switchTo().window(tabs.get(0));
		}
	}

	@Test(priority = 4)
	public void addToFavorites() throws InterruptedException {

		// Using signIn method to sign in with predefined email and password
		signInRegisterPage.signIn(email, password);

		// Waiting until sign in form has disappeared
		this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("join-neu-form")));

		// Setting up a for loop that will last three iterations
		for (int i = 0; i < 3; i++) {

			// Deleting text from search bar
			searchPage.getSearchBar().clear();

			// Using searchItems method to search for random items
			searchPage.searchItems(RandomData.randomItem());

			// Pausing the app for one second
			Thread.sleep(1000);

			// Using selectItems method to select random items
			searchPage.selectItems();

			// Setting up an array list that will contain names of tabs
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

			// Switching up to newly opened tab
			driver.switchTo().window(tabs.get(1));

			// Verifying that add to favorites button exists and clicking on it
			Assert.assertTrue(elementExists(favoritesPage.addFavoritesBtn), "Add to favorites button is not present.");
			favoritesPage.getAddFavoritesBtn().click();

			// Wait until item added to favorite message has disappeared
			this.wait.until(ExpectedConditions.invisibilityOf(favoritesPage.getFavoritesMsg()));

			// Closing current tab
			driver.close();

			// Pausing the app for one second
			Thread.sleep(1000);

			// Switching back to first tab with items
			driver.switchTo().window(tabs.get(0));
		}
	}

}
