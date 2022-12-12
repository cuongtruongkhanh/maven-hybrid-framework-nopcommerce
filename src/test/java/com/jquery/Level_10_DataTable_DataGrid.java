package com.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuerry.datatable.HomePageObject;
import pageObjects.jQuerry.datatable.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	// @Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActived("10"));

		homePage.openPagingByPageNumber("20");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActived("20"));

		homePage.openPagingByPageNumber("7");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActived("7"));

		homePage.openPagingByPageNumber("8");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActived("8"));
	}

	// @Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		homePage.enterToHeaderTextboxByLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxByLabel("Females", "338282");
		homePage.enterToHeaderTextboxByLabel("Males", "349238");
		homePage.enterToHeaderTextboxByLabel("Total", "687522");
		homePage.sleepInSecond(2);

		homePage.enterToHeaderTextboxByLabel("Country", "Angola");
		homePage.enterToHeaderTextboxByLabel("Females", "276880");
		homePage.enterToHeaderTextboxByLabel("Males", "276472");
		homePage.enterToHeaderTextboxByLabel("Total", "553353");
		homePage.sleepInSecond(2);
	}

	@Test
	public void Table_03_Enter_To_Header() {
		// Đọc dữ liệu từ file contry.txt ra
		// Lưu vào 1 List<String> = Expected Value
		actualAllCountryValues = homePage.getValueCoutryEachRowAtAllPage();
	}

	// @Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.sleepInSecond(2);
		homePage.clicktoLoadButton();
		homePage.sleepInSecond(1);

		// Value de nhap lieu - tham so 1
		// Row number: tai row nao
		// Ex: nhap vao textbox tai dong so 3/5/2
		// Column name: Album/ Artist / Year / Price
//		homePage.enterToTextboxAtRowNumberByColumnName("Album", "1", "Titanic");
//		homePage.enterToTextboxAtRowNumberByColumnName("Artist", "1", "Michael Jackson");
//		homePage.enterToTextboxAtRowNumberByColumnName("Year", "1", "1997");
//		homePage.enterToTextboxAtRowNumberByColumnName("Price", "1", "5000");
//		homePage.SleepInSecond(2);
//
//		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "1", "Hong Kong");
//		homePage.SleepInSecond(2);
//		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "2", "Korea");
//		homePage.SleepInSecond(2);
//		homePage.selectDropdownByColumnNameAtRowNumber("Origin", "3", "Others");
//		homePage.SleepInSecond(2);

//		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "1");
//		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "2");
//		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "3");
//		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "4");
//		homePage.checkToCheckboxByColumnNameAtRowNumber("With Poster?", "5");
//
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "1");
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "2");
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "3");
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "4");
//		homePage.uncheckToCheckboxByColumnNameAtRowNumber("With Poster?", "5");

//		homePage.insertRowByRowNumber("2");
//		homePage.SleepInSecond(2);
//		homePage.deleteRowByRowNumber("2");
//		homePage.SleepInSecond(2);
//		homePage.moveupRowByRowNumber("4");
//		homePage.SleepInSecond(2);
//		homePage.movedownRowByRowNumber("4");
//		homePage.SleepInSecond(2);

		homePage.clickToIconByRowNumber("2", "Insert Row Above");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("2", "Remove Current Row");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("4", "Move Up");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRowNumber("4", "Move Down");
		homePage.sleepInSecond(2);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
