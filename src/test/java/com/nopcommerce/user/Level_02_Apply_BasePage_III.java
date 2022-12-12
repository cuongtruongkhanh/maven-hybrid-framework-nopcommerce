package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Apply_BasePage_III extends BasePage {
	WebDriver driver;
	String emailAddress;
	// BasePage: Class
	// basePage: Object

	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		emailAddress = "afc" + generateRandomNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_With_Empty_Data() {
		waitForElementClickable(driver, "//a[text()='Register']");
		clickToElement(driver, "//a[text()='Register']");

		waitForElementClickable(driver, "//button[text()='Register']");
		clickToElement(driver, "//button[text()='Register']");

		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	@Test
	public void TC_02_Register_With_Invalid_Email() {
		waitForElementClickable(driver, "//a[text()='Register']");
		clickToElement(driver, "//a[text()='Register']");

		clickToElement(driver, "//input[@id='gender-male']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		sendKeyToElement(driver, "//input[@id='Email']", "123@456#$%");
		sendKeyToElement(driver, "//input[@id='Password']", "123456");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[text()='Register']");
		clickToElement(driver, "//button[text()='Register']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void TC_03_Register_Success() {
		waitForElementClickable(driver, "//a[text()='Register']");
		clickToElement(driver, "//a[text()='Register']");

		clickToElement(driver, "//input[@id='gender-male']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeyToElement(driver, "//input[@id='Password']", "123456");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[text()='Register']");
		clickToElement(driver, "//button[text()='Register']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

		clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void TC_04_Register_With_Existing_Email() {
		waitForElementClickable(driver, "//a[text()='Register']");
		clickToElement(driver, "//a[text()='Register']");

		clickToElement(driver, "//input[@id='gender-male']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeyToElement(driver, "//input[@id='Password']", "123456");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[text()='Register']");
		clickToElement(driver, "//button[text()='Register']");

		Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']//li"), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		waitForElementClickable(driver, "//a[text()='Register']");
		clickToElement(driver, "//a[text()='Register']");

		clickToElement(driver, "//input[@id='gender-male']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeyToElement(driver, "//input[@id='Password']", "12345");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");

		waitForElementClickable(driver, "//button[text()='Register']");
		clickToElement(driver, "//button[text()='Register']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Register_With_Invalid_Confirm_Password() {
		waitForElementClickable(driver, "//a[text()='Register']");
		clickToElement(driver, "//a[text()='Register']");

		clickToElement(driver, "//input[@id='gender-male']");
		sendKeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendKeyToElement(driver, "//input[@id='LastName']", "FC");
		sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeyToElement(driver, "//input[@id='Password']", "123456");
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");

		waitForElementClickable(driver, "//button[text()='Register']");
		clickToElement(driver, "//button[text()='Register']");

		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
