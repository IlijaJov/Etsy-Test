package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import random.RandomData;

public class SignInRegisterPage extends BasicPage {

	// Setting up paths
	public By signInBtn = By.xpath("//*[contains(text(), 'Sign in')]");
	public By email = By.id("join_neu_email_field");
	public By continueBtn = By.name("submit_attempt");
	public By firstName = By.id("join_neu_first_name_field");
	public By password = By.name("password");
	public By submitBtn = By.name("submit_attempt");
	public By welcomeMsg = By.xpath("//*[contains(text(), 'Welcome to Etsy,')]");

	// Importing constructors
	public SignInRegisterPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js, Actions actions) {
		super(driver, wait, js, actions);
		this.wait = new WebDriverWait(driver, 30, 10);
	}

	// Finding and returning sign in button
	public WebElement getSignInBtn() {
		return driver.findElement(signInBtn);
	}

	// Finding and returning email field
	public WebElement getEmail() {
		return driver.findElement(email);
	}

	// Finding and returning continue button
	public WebElement getContinueBtn() {
		return driver.findElement(continueBtn);
	}

	// Finding and returning first name field
	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}

	// Finding and returning password field
	public WebElement getPassword() {
		return driver.findElement(password);
	}

	// Finding and returning submit button
	public WebElement getSubmitBtn() {
		return driver.findElement(submitBtn);
	}

	// Setting up register method
	public void register() throws InterruptedException {
		// Clicking on sign in button
		this.getSignInBtn().click();

		// Waiting until email field is clickable and entering random email address
		this.wait.until(ExpectedConditions.elementToBeClickable(getEmail()));
		this.getEmail().sendKeys(RandomData.randomEmail());

		// Clicking on continue button
		this.getContinueBtn().click();

		// Pausing the app for one second
		Thread.sleep(1000);

		// Entering random first name in first name field
		this.getFirstName().sendKeys(RandomData.randomName());

		// Entering random password in password field
		this.getPassword().sendKeys(RandomData.randomPassword());

		// Pausing the app for one second
		Thread.sleep(1000);

		// Clicking on submit button
		this.getSubmitBtn().click();
	}

	// Setting up sign in method
	public void signIn(String email, String password) throws InterruptedException {
		// Clicking on sign in button
		this.getSignInBtn().click();

		// Pausing an app for one second
		Thread.sleep(1000);

		// Entering predefine email address in email field
		this.getEmail().sendKeys(email);

		// Clicking continue button
		this.getContinueBtn().click();

		// Pausing the app for one second
		Thread.sleep(1000);

		// Entering predefined password in password field
		this.getPassword().sendKeys(password);

		// Clicking submit button
		this.getSubmitBtn().click();
	}
}
