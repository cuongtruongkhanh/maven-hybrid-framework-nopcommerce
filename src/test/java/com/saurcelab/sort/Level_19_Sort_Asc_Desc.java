package com.saurcelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.sauceLab.LoginPageObject;
import pageObjects.sauceLab.PageGeneratorManager;
import pageObjects.sauceLab.ProductPageObject;

public class Level_19_Sort_Asc_Desc extends BaseTest {

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String sauceAppUrl) {
		driver = getBrowserDriver(browserName, sauceAppUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.enterToUsernameTextbox("standard_user");
		loginPage.enterToPaswordTextbox("secret_sauce");
		productPage = loginPage.clickToLoginButton(driver);

	}

	// @Test
	public void Sort_01_Name() {
		productPage.selectItemInProductSortDropdown("Name (A to Z)");
		productPage.sleepInSecond(2);
		Assert.assertTrue(productPage.isProductNameSortByAscending());

		productPage.selectItemInProductSortDropdown("Name (Z to A)");
		Assert.assertTrue(productPage.isProductNameSortByDescending());

		productPage.sleepInSecond(2);
	}

	@Test
	public void User_02_Price() {
		productPage.selectItemInProductSortDropdown("Price (low to high)");
		productPage.sleepInSecond(2);
		Assert.assertTrue(productPage.isProductPriceSortByAscending());

		productPage.selectItemInProductSortDropdown("Price (high to low)");
		productPage.sleepInSecond(2);
		Assert.assertTrue(productPage.isProductPriceSortByDescending());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	WebDriver driver;
	LoginPageObject loginPage;
	ProductPageObject productPage;
}
