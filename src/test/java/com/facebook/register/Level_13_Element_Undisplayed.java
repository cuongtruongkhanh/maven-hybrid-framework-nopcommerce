package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccount();
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());

	}

	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		loginPage.enterToEmailAddressTextbox("automationfc@gmail.com");
		loginPage.sleepInSecond(2);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());

		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(2);
		// verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}

	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickCloseIconAtRegisterForm();
		loginPage.sleepInSecond(2);

		// Verify False - Mong doi confirm Email undisplayed (false) -> mat rat nhieu thoi gian do phai doi den het timeout thi moi tra ve ket qua
		// verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());

		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
