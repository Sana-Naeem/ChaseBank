package chase.bank.data;

public class ApplicantInfoDataClass {

	private String firstName;
	private String lastName;
	private String suffixValue;
	private String dob;
	private String mothersName;
	private String taxID;
	private String socialSecurityNum;
	private String addressType;
	private String streetAddress;
	private String zipCode;
	private String city;
	private String state;
	private String email;
	private String phoneNum;
	private String residence;
	private String income;
	private String grossIncome;

	public ApplicantInfoDataClass(String firstName, String lastName, String suffixValue, String dob, String mothersName,
			String taxID, String socialSecurityNum, String addressType, String streetAddress, String zipCode,
			String city, String state, String email, String phoneNum, String residence, String income,
			String grossIncome) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.suffixValue = suffixValue;
		this.dob = dob;
		this.mothersName = mothersName;
		this.taxID = taxID;
		this.socialSecurityNum = socialSecurityNum;
		this.addressType = addressType;
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
		this.email = email;
		this.phoneNum = phoneNum;
		this.residence = residence;
		this.income = income;
		this.grossIncome = grossIncome;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSuffixValue() {
		return suffixValue;
	}

	public String getDob() {
		return dob;
	}

	public String getMothersName() {
		return mothersName;
	}

	public String getTaxID() {
		return taxID;
	}

	public String getSocialSecurityNum() {
		return socialSecurityNum;
	}

	public String getAddressType() {
		return addressType;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getResidence() {
		return residence;
	}

	public String getIncome() {
		return income;
	}

	public String getGrossIncome() {
		return grossIncome;
	}

}
