package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextBox;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameTextBox;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextBox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextBox;

	@FindBy(xpath = "//button[text()='Register']")
	private WebElement registerButton;

	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;

	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;

	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;

	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;

	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMessage;

	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']//li")
	private WebElement existingEmailErrorMessage;

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);

	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public void inputToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextBox);
		sendKeyToElement(driver, firstNameTextBox, firstName);

	}

	public void inputToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextBox);
		sendKeyToElement(driver, lastNameTextBox, lastName);

	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextBox);
		sendKeyToElement(driver, emailTextBox, emailAddress);

	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextBox);
		sendKeyToElement(driver, passwordTextBox, password);

	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextBox);
		sendKeyToElement(driver, confirmPasswordTextBox, confirmPassword);

	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);

	}

	public String getExistingEmailErrorMessage() {
		waitForElementVisible(driver, existingEmailErrorMessage);
		return getElementText(driver, existingEmailErrorMessage);
	}
}
