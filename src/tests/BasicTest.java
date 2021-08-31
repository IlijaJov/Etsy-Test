package tests;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.FavoritesPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.SignInRegisterPage;

public abstract class BasicTest {
	// Setting up attributes
	protected WebDriver driver;
	// protected WebDriver driver2; - Second driver option

	protected SearchPage searchPage;
	protected ShoppingCartPage shoppingCartPage;
	protected SignInRegisterPage signInRegisterPage;
	protected FavoritesPage favoritesPage;

	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	protected Actions actions;
	protected String baseURL = "https://www.etsy.com/";
	protected String email = "aiciqlbptdyxsdahha@tbbyt.net";
	protected String password = "password123";

	@BeforeMethod // Setting up a before method
	public void setup() {

		// Setting up drivers
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");

		// System.setProperty("webdriver.gecko.driver", "driver-lib\\geckodriver.exe");
		// - Second driver option
		driver = new ChromeDriver();

		// driver2 = new FirefoxDriver(); - Second driver option

		// Initiating full screen
		driver.manage().window().maximize();

		// Getting the web address
		driver.get(baseURL);

		// Setting up implicit wait and page loading wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Setting up javascript executor and explicit waiter
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, 30, 100);

		// defining pages
		searchPage = new SearchPage(driver, wait, js, actions);
		shoppingCartPage = new ShoppingCartPage(driver, wait, js, actions);
		signInRegisterPage = new SignInRegisterPage(driver, wait, js, actions);
		favoritesPage = new FavoritesPage(driver, wait, js, actions);

	}

	@AfterMethod // Setting up a clean up method
	public void cleanup(ITestResult result) throws IOException, InterruptedException {
		// Getting the result of a test
		if (result.getStatus() == ITestResult.FAILURE) {

			// Setting up date and time format and converting it to string
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
			LocalDateTime now = LocalDateTime.now();
			String dt = dtf.format(now);

			// Setting up a screenshot method
			File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scr, new File("./screenshots/" + dt + ".jpg"));
		}
		Thread.sleep(3000);
		driver.quit();
	}

	// Setting up a method for checking if elements exists
	public boolean elementExists(By by) {
		boolean exists = true;
		try {
			driver.findElement(by);
		} catch (Exception e) {
			exists = false;
		}
		return exists;
	}

}
