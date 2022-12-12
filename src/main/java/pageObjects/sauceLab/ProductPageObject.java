package pageObjects.sauceLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.sauceLab.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String itemValue) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, itemValue);

	}

	public boolean isProductNameSortByAscending() {
		List<String> productNameList = new ArrayList<>();
		List<String> productSortList = new ArrayList<>();
		List<WebElement> productNames = getListWebElement(driver, ProductPageUI.PRODUCT_NAMES);

		for (WebElement productName : productNames) {
			productNameList.add(productName.getText());
			System.out.println(productName.getText());
		}

		for (String sortList : productNameList) {
			productSortList.add(sortList);
		}

		Collections.sort(productSortList);

		for (String sortList : productSortList) {
			System.out.println(sortList);
		}

		return productNameList.equals(productSortList);
	}

	public boolean isProductNameSortByDescending() {
		List<String> productNameList = new ArrayList<>();
		List<String> productSortList = new ArrayList<>();
		List<WebElement> productNames = getListWebElement(driver, ProductPageUI.PRODUCT_NAMES);

		for (WebElement productName : productNames) {
			productNameList.add(productName.getText());
			System.out.println(productName.getText());
		}

		for (String sortList : productNameList) {
			productSortList.add(sortList);
		}

		Collections.sort(productSortList);
		Collections.reverse(productSortList);

		for (String sortList : productSortList) {
			System.out.println(sortList);
		}

		return productNameList.equals(productSortList);
	}

	public boolean isProductPriceSortByAscending() {
		List<Float> productPriceList = new ArrayList<>();
		List<Float> productSortList = new ArrayList<>();
		List<WebElement> productNames = getListWebElement(driver, ProductPageUI.PRODUCT_PRICES);

		for (WebElement priceName : productNames) {
			System.out.println(priceName.getText());
			productPriceList.add(Float.parseFloat(priceName.getText().replace("$", "")));
		}

		for (Float sortList : productPriceList) {
			productSortList.add(sortList);
		}

		Collections.sort(productSortList);

		for (Float sortList : productSortList) {
			System.out.println(sortList);
		}

		return productPriceList.equals(productSortList);
	}

	public boolean isProductPriceSortByDescending() {
		List<Float> productPriceList = new ArrayList<>();
		List<Float> productSortList = new ArrayList<>();
		List<WebElement> productNames = getListWebElement(driver, ProductPageUI.PRODUCT_PRICES);

		for (WebElement priceName : productNames) {
			System.out.println(priceName.getText());
			productPriceList.add(Float.parseFloat(priceName.getText().replace("$", "")));
		}

		for (Float sortList : productPriceList) {
			productSortList.add(sortList);
		}

		Collections.sort(productSortList);
		Collections.reverse(productSortList);

		for (Float sortList : productSortList) {
			System.out.println(sortList);
		}

		return productPriceList.equals(productSortList);
	}
}
