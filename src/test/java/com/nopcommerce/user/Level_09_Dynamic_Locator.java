package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {

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
	public void User_01_Register_Login() {
		registerPage = homePage.openRegisterPage();
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAdress);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();

		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(emailAdress);
		loginPage.inputToPasswordTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		customerInfoPage = homePage.openMyAccountPage();
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());

	}

	@Test
	public void User_02_Dynamic_Page() {
		// Knowledge cua Page Object
		// Page A khi chuyen qua Page B thi phai viet ham de mo qua page B (action: open/click/ ...)

		// Customer info -> address
		addressPage = customerInfoPage.openAddressPage(driver);
		// Address -> My Product review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		// My product review -> Reward point
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		// Reward Point -> Address
		addressPage = rewardPointPage.openAddressPage(driver);

		// Address -> Reward Point
		rewardPointPage = addressPage.openRewardPointPage(driver);
		// Reward Point -> My product review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		// My product review -> Address
		addressPage = myProductReviewPage.openAddressPage(driver);

		customerInfoPage = addressPage.openCustomerInfo(driver);

		myProductReviewPage = customerInfoPage.openMyProductReviewPage(driver);
	}

	@Test
	public void User_03_Dynamic_Page_01() {
		// My product review -> Reward point
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPagesAtMyAccountPageByName(driver, "Reward points");

		// Reward points -> Address
		addressPage = (UserAddressPageObject) rewardPointPage.openPagesAtMyAccountPageByName(driver, "Addresses");

		// Address -> Reward point
		rewardPointPage = (UserRewardPointPageObject) addressPage.openPagesAtMyAccountPageByName(driver, "Reward points");

		// Reward point -> My product review
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPagesAtMyAccountPageByName(driver, "My product reviews");

		// My product review -> CustomerInfo
		customerInfoPage = (UserCustomerInfoPageObject) myProductReviewPage.openPagesAtMyAccountPageByName(driver, "Customer info");
	}

	@Test
	public void User_03_Dynamic_Page_02() {
		// Customer info -> My product review
		customerInfoPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

		// My product review -> Reward point
		myProductReviewPage.openPagesAtMyAccountPageByName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);

		// Reward points -> Address
		rewardPointPage.openPagesAtMyAccountPageByName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);

		// Address -> Reward point
		addressPage.openPagesAtMyAccountPageByName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);

		// Reward point -> My product review
		rewardPointPage.openPagesAtMyAccountPageByName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

		// My product review -> CustomerInfo
		myProductReviewPage.openPagesAtMyAccountPageByName(driver, "Customer info");
		customerInfoPage = PageGeneratorManager.getUserCustomerInFoPage(driver);

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
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private String firstName, lastName, validPassword, emailAdress;

}
