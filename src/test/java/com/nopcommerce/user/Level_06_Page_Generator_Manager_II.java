package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_II extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, validPassword, existingEmail, invalidEmail, notExistEmail, incorrectPassword;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		// 1
		homePage = new UserHomePageObject(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		firstName = "Automation";
		lastName = "FC";
		existingEmail = "afc" + generateRandomNumber() + "@gmail.com";
		invalidEmail = "afc@123@1233@vn";
		notExistEmail = "afc" + generateRandomNumber() + "@hot.com";
		validPassword = "123456";
		incorrectPassword = "654321";
		System.out.println("Pre-condition - Step 01: Click to Register link");
		registerPage = homePage.openRegisterPage();
		System.out.println("Pre-condition - Step 02: Input to require fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		System.out.println("Pre-condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Pre-condition - Step 04: Confirm Success Message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		System.out.println("Pre-condition - Step 05: Click to Logout button");
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01_Empty_Data - Step 01: Click to Login link");
		loginPage = homePage.openLoginPage();
		System.out.println("Login_01_Empty_Data - Step 02: Click to Login button");
		loginPage.clickToLoginButton();
		System.out.println("Login_01_Empty_Data - Step 03: Verify error message display");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login_02_Invalid_Email - Step 01: Click to Login link");
		loginPage = homePage.openLoginPage();
		System.out.println("Login_02_Invalid_Email - Step 02: Input invalid email");
		loginPage.inputToEmailTextbox(invalidEmail);
		System.out.println("Login_02_Invalid_Email - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		System.out.println("Login_02_Invalid_Email - Step 04: Verify error message display");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Exist() {
		System.out.println("Login_03_Email_Not_Exist - Step 01: Click to Login link");
		loginPage = homePage.openLoginPage();
		System.out.println("Login_03_Email_Not_Exist - Step 02: Input not existing email");
		loginPage.inputToEmailTextbox(notExistEmail);
		System.out.println("Login_03_Email_Not_Exist - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		System.out.println("Login_03_Email_Not_Exist - Step 04: Verify error message display");
		Assert.assertEquals(loginPage.getErrorMessageUnsucessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		System.out.println("Login_04_Existing_Email_Empty_Password - Step 01: Click to Login link");
		loginPage = homePage.openLoginPage();
		System.out.println("Login_04_Existing_Email_Empty_Password - Step 02: Input existing email");
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");
		System.out.println("Login_04_Existing_Email_Empty_Password - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		System.out.println("Login_04_Existing_Email_Empty_Password - Step 04: Verify error message display");
		Assert.assertEquals(loginPage.getErrorMessageUnsucessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		System.out.println("Login_05_Existing_Email_Incorrect_Password - Step 01: Click to Login link");
		loginPage = homePage.openLoginPage();
		System.out.println("Login_05_Existing_Email_Incorrect_Password - Step 02: Input existing email with incorrect password");
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		System.out.println("Login_05_Existing_Email_Incorrect_Password - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		System.out.println("Login_05_Existing_Email_Incorrect_Password - Step 04: Verify error message display");
		Assert.assertEquals(loginPage.getErrorMessageUnsucessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Valid_Password() {
		System.out.println("Login_06_Valid_Email_Valid_Password - Step 01: Click to Login link");
		loginPage = homePage.openLoginPage();
		System.out.println("Login_06_Valid_Email_Valid_Password - Step 02: Input existing email with valid password");
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		System.out.println("Login_06_Valid_Email_Valid_Password - Step 03: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		System.out.println("Login_06_Valid_Email_Valid_Password - Step 04: Verify My Account Link displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
