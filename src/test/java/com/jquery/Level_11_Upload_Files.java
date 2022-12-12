package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuerry.uploadfiles.HomePageObject;
import pageObjects.jQuerry.uploadfiles.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;

	String vietnamFileName = "Vietnam.jpg";
	String indonesiaFileName = "Indonesia.jpg";
	String thailandFileName = "Thailand.jpg";
	String[] multipleFiles = { vietnamFileName, indonesiaFileName, thailandFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		// Step 1 - Load single file
		homePage.uploadMultipleFiles(driver, vietnamFileName);

		// Step 2 - Verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(vietnamFileName));

		// Step 3 - click to start button
		homePage.clickToStartButton();

		// Step 4 - Verify single file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUploadedByName(vietnamFileName));

		// Step 5 - Verify singe file image uploaded success
		Assert.assertTrue(homePage.isFileImgUploadedByName(vietnamFileName));

	}

	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);
		// Step 1 - Load multiple files
		homePage.uploadMultipleFiles(driver, multipleFiles);

		// Step 2 - Verify multiple files loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(vietnamFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(indonesiaFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(thailandFileName));

		// Step 3 - click to start button
		homePage.clickToStartButton();

		// Step 4 - Verify multiple files link uploaded success
		Assert.assertTrue(homePage.isFileLinkUploadedByName(vietnamFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(indonesiaFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(thailandFileName));

		// Step 5 - Verify multiple files image uploaded success
		Assert.assertTrue(homePage.isFileImgUploadedByName(vietnamFileName));
		Assert.assertTrue(homePage.isFileImgUploadedByName(indonesiaFileName));
		Assert.assertTrue(homePage.isFileImgUploadedByName(thailandFileName));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
