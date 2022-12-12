package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_08_Switch_Role extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		userEmailAddress = "afc" + generateRandomNumber() + "@gmail.com";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void Role_01_User_To_Admin() {
		registerPage = userHomePage.openRegisterPage();
		registerPage.registerAnAccount(firstName, lastName, userEmailAddress, userPassword);
//		registerPage.inputToFirstnameTextbox(firstName);
//		registerPage.inputToLastnameTextbox(lastName);
//		registerPage.inputToEmailTextbox(userEmailAddress);
//		registerPage.inputToPasswordTextbox(userPassword);
//		registerPage.inputToConfirmPasswordTextbox(userPassword);
//		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		userHomePage = registerPage.clickToLogoutLink();

		userLoginPage = userHomePage.openLoginPage();
		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

		// Home Page -> Customer Info
		userCustomerInfoPage = userHomePage.openMyAccountPage();

		// Customer Infor click log out -> Home Page
		userHomePage = userCustomerInfoPage.clickToLogoutLinkAtUserPage(driver);

		// User HomePage -> open Admin Page -> Login Page (Admin)
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_DEV_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		// login as Admin Role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());

		// Dashboard page click logout -> Login Paeg (Admin)
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);
	}

	@Test
	public void Role_02_Admin_To_User() {
		// Login Page (Admin) -> Open User URL -> Home Page (User)
		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_DEV_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		// Home Page -> Login Page (user)
		userLoginPage = userHomePage.openLoginPage();
		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private String firstName, lastName, userPassword, userEmailAddress, adminEmailAddress, adminPassword;

}
