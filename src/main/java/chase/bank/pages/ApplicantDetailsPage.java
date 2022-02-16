package chase.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import chase.bank.base.Base_class;

public class ApplicantDetailsPage {

	public ApplicantDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='blx-nameBlock-firstName-text-validate-input-field']")
	public WebElement enterFirstName;
	@FindBy(xpath = "//input[@id='blx-nameBlock-lastName-text-validate-input-field']")
	public WebElement enterLastName;
	@FindBy(xpath = "//select[@id='select-blx-nameBlock-suffix-select-validate']")
	public WebElement selectSuffix;
	@FindBy(xpath = "//input[@id='dateOfBirth-text-validate-input-field']")
	public WebElement enterDob;
	@FindBy(xpath = "//input[@id='mothersMaidenName-text-validate-input-field']")
	public WebElement enterMothersName;
	@FindBy(xpath = "//select[@id='select-taxIdType-select-validate']")
	public WebElement selectTaxID;
	@FindBy(xpath = "//input[@id='maskedSocialSecurityNumber-text-validate-input-field']")
	public WebElement enterSSN;
	@FindBy(xpath = "//select[@id='select-addressType-blx-residentialAddressBlock-select-validate']")
	public WebElement selectAddressType;
	@FindBy(xpath = "//input[@id='streetAddress-blx-residentialAddressBlock-text-validate-input-field']")
	public WebElement enterAddress;
	@FindBy(xpath = "//input[@id='zipCode-blx-residentialAddressBlock-text-validate-input-field']")
	public WebElement enterZipCode;
	@FindBy(xpath = "//input[@id='city-blx-residentialAddressBlock-text-validate-input-field']")
	public WebElement enterCity;
	@FindBy(xpath = "//select[@name='stateId']")
	public WebElement selectState;
	@FindBy(xpath = "//input[@id='emailAddressId-text-validate-input-field']")
	public WebElement enterEmail;
	@FindBy(xpath = "//input[@id='phoneNumberId-text-validate-input-field']")
	public WebElement enterPhoneNum;
	@FindBy(xpath = "//input[@id='input-socialSecurityAdministrationDisclosureAcceptance']")
	public WebElement authorizationCheckBox;
	@FindBy(xpath = "//select[@id='select-residenceOwnership-select-validate']")
	public WebElement selectTypeOfResidence;
	@FindBy(xpath = "//select[@id='select-primaryIncomeSourceName-select-validate']")
	public WebElement selectIncome;
	@FindBy(xpath = "//input[@id='grossAnnualIncome-text-validate-input-field']")
	public WebElement enterGrossIncome;
	@FindBy(xpath = "//input[@id='input-paperlessStatements-radio-0']")
	public WebElement goPaperlessButton;
	@FindBy(xpath = "//input[@id='input-authorizedUsersHeader-radio-1']")
	public WebElement addUserButton;
	@FindBy(xpath = "//input[@id='input-balanceTransfer-radio-1']")
	public WebElement balanceTranserButton;
	@FindBy(xpath = "//input[@name='navigationAdvisoryCheckbox']")
	public WebElement agreementButton;
	@FindBy(xpath = "//mds-button[@id='SUBMIT-nav-ctr-btn']")
	public WebElement submitButton;
	
	private void enterFirstNameStep(String firstName) {
		Base_class.common_methods.scrollIntoViewTheElement(enterFirstName);
		Base_class.common_methods.writeText(enterFirstName, firstName);
	}

	private void enterLastNameStep(String lastName) {
		Base_class.common_methods.writeText(enterLastName, lastName);
	}
	
	private void selectSuffixStep(String suffixValue) {
		Base_class.common_methods.selectDropDown(selectSuffix, suffixValue);
	}
	
	private void inputDobStep(String dob) {
		Base_class.common_methods.writeText(enterDob, dob);
	}
	
	private void enterMothersNameStep(String mothersName) {
		Base_class.common_methods.writeText(enterMothersName, mothersName);
	}

	private void selectTaxIdStep(String taxID) {
		Base_class.common_methods.selectDropDown(selectTaxID, taxID);
	}
	
	private void enterSocial(String socialSecurityNum) {
		Base_class.common_methods.writeText(enterSSN, socialSecurityNum);
	}
	
	private void selectAddressTypeStep(String addressType) {
		Base_class.common_methods.selectDropDown(selectAddressType, addressType);
	}
	
	private void enterStreetAddressStep(String streetAddress) {
		Base_class.common_methods.writeText(enterAddress, streetAddress);
	}
	
	private void enterZipCodeStep(String zipCode) {
		Base_class.common_methods.writeText(enterZipCode, zipCode);
	}
	
	private void enterCityStep(String city) {
		Base_class.common_methods.writeText(enterCity, city);
	}
	
	private void selectStateStep(String state) {
		Base_class.common_methods.selectDropDown(selectState, state);
	}
	
	private void enterEmailStep(String email) {
		Base_class.common_methods.writeText(enterEmail, email);
	}
	
	private void enterPhoneNumStep(String phoneNum) {
		Base_class.common_methods.writeText(enterPhoneNum, phoneNum);
	}
	
	private void authorizationStep() {
		Base_class.common_methods.selectRadioButton(authorizationCheckBox);
	}
	
	private void residenceStep(String residence) {
		Base_class.common_methods.selectDropDown(selectTypeOfResidence, residence);
	}
	
	private void incomeStep(String income) {
		Base_class.common_methods.selectDropDown(selectIncome, income);
	}
	
	private void grossIncomeStep(String grossIncome) {
		Base_class.common_methods.writeText(enterGrossIncome, grossIncome);
	}
	
	private void goPaperlessStep() {
		Base_class.common_methods.selectRadioButton(goPaperlessButton);
	}
	
	private void addUserStep() {
		Base_class.common_methods.selectRadioButton(addUserButton);
	}
	
	private void balanceTransferStep() {
		Base_class.common_methods.selectRadioButton(balanceTranserButton);
	}
	
	private void agreementStep() {
		Base_class.common_methods.selectRadioButton(agreementButton);
	}
	
	private void clickSumbitButtonStep() {
		Base_class.common_methods.click(submitButton);
	}
	
	public void applicantInfoSteps(String firstName, String lastName, String suffixValue, String dob, String mothersName, String taxID, String socialSecurityNum, String addressType, String streetAddress, String zipCode, String city, String state, String email, String phoneNum, String residence, String income, String grossIncome) {
		enterFirstNameStep(firstName);
		enterLastNameStep(lastName);
		selectSuffixStep(suffixValue);
		inputDobStep(dob);
		enterMothersNameStep(mothersName);
		selectTaxIdStep(taxID);
		enterSocial(socialSecurityNum);
		selectAddressTypeStep(addressType);
		enterStreetAddressStep(streetAddress);
		enterZipCodeStep(zipCode);
		enterCityStep(city);
		selectStateStep(state);
		enterEmailStep(email);
		enterPhoneNumStep(phoneNum);
		authorizationStep();
		residenceStep(residence);
		incomeStep(income);
		grossIncomeStep(grossIncome);
		goPaperlessStep();
		addUserStep();
		balanceTransferStep();
		agreementStep();
		clickSumbitButtonStep();
	
	}
	
}
