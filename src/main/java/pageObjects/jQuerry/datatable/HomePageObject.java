package pageObjects.jQuerry.datatable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuerry.datatable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGING_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForAllElmentVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGING_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGING_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size = " + totalPage);

		List<String> allRowValueAllPage = new ArrayList<String>();

		// Duyệt qua tất cả các page
		for (int i = 1; i <= totalPage; i++) {
			clickToElement(driver, HomePageUI.PAGING_PAGE_BY_NUMBER, String.valueOf(i));

			List<WebElement> allRownElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			// Get text cua tat ca row mỗi page đưa vào ArrayList
			for (WebElement eachRow : allRownElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		// In tất cả giá trị row - tất cả các page
		for (String value : allRowValueAllPage) {
			System.out.println("-----------------------------------");
			System.out.println(value);
		}

		return allRowValueAllPage;
	}

	public List<String> getValueCoutryEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size = " + totalPage);

		List<String> allRowValueCountryAllPage = new ArrayList<String>();

		// Duyệt qua tất cả các page
		for (int i = 1; i <= totalPage; i++) {
			clickToElement(driver, HomePageUI.PAGING_PAGE_BY_NUMBER, String.valueOf(i));

			List<WebElement> allRownCountryEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			// Get text cua tat ca row mỗi page đưa vào ArrayList
			for (WebElement eachRow : allRownCountryEachPage) {
				allRowValueCountryAllPage.add(eachRow.getText());
			}
		}
		// In tất cả giá trị row - tất cả các page
		for (String countryValue : allRowValueCountryAllPage) {
			System.out.println(countryValue);
		}

		return allRowValueCountryAllPage;
	}

	public void enterToTextboxAtRowNumberByColumnName(String columnName, String rowNumber, String valueToEnter) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		sendKeyToElement(driver, HomePageUI.ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToEnter, rowNumber, String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber, String.valueOf(columnIndex));
	}

	public void clicktoLoadButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);

	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		unCheckToDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void insertRowByRowNumber(String rowNumber) {
		waitForElementClickable(driver, HomePageUI.INSERT_BY_ROW_INDEX, rowNumber);
		clickToElement(driver, HomePageUI.INSERT_BY_ROW_INDEX, rowNumber);
	}

	public void deleteRowByRowNumber(String rowNumber) {
		waitForElementClickable(driver, HomePageUI.DELETE_BY_ROW_INDEX, rowNumber);
		clickToElement(driver, HomePageUI.DELETE_BY_ROW_INDEX, rowNumber);
	}

	public void moveupRowByRowNumber(String rowNumber) {
		waitForElementClickable(driver, HomePageUI.MOVEUP_BY_ROW_INDEX, rowNumber);
		clickToElement(driver, HomePageUI.MOVEUP_BY_ROW_INDEX, rowNumber);
	}

	public void movedownRowByRowNumber(String rowNumber) {
		waitForElementClickable(driver, HomePageUI.MOVEDOWN_BY_ROW_INDEX, rowNumber);
		clickToElement(driver, HomePageUI.MOVEDOWN_BY_ROW_INDEX, rowNumber);
	}

	public void clickToIconByRowNumber(String rowNumber, String action) {
		waitForElementClickable(driver, HomePageUI.ICON_BY_ROW_INDEX, rowNumber, action);
		clickToElement(driver, HomePageUI.ICON_BY_ROW_INDEX, rowNumber, action);
	}

}
