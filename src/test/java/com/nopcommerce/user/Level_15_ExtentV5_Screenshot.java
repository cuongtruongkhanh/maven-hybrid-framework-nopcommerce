package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;
//import reportConfig.ExtentManager;

public class Level_15_ExtentV5_Screenshot extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		emailAdress = "afc" + generateRandomNumber() + "@gmail.com";
		validPassword = "123456";

	}

	@Test
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to Register page");
		registerPage = homePage.openRegisterPage();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to Firstname textbox with value is " + firstName);
		registerPage.inputToFirstnameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to Lastname textbox with value is " + lastName);
		registerPage.inputToLastnameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email Adrress textbox with value is " + lastName);
		registerPage.inputToEmailTextbox(emailAdress);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password textbox with value is " + validPassword);
		registerPage.inputToPasswordTextbox(validPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to ConfirmPassword textbox with value is " + validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify Register Success Message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login to system successfully");

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.openLoginPage();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to email textbox with value is " + emailAdress);
		loginPage.inputToEmailTextbox(emailAdress);
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to password textbox with value is " + validPassword);
		loginPage.inputToPasswordTextbox(validPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to login button");
		homePage = loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify My Account Link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: Navigate to My Account Page");
		customerInfoPage = homePage.openMyAccountPage();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 07: Verify Customer Info page is displayed");
		Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private String firstName, lastName, validPassword, emailAdress;

}
