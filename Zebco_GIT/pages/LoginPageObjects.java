package pages;

import static pages.ObjectLocator.*;
public enum LoginPageObjects implements PageObjects {

	titleCustomerLogin("//h1[@class='page-title']/span",XPATH,"Customer Login Page - Title - Customer Login"),
	
	txtBoxEmail("//input[@id='email']",XPATH,"Customer Login page - Text Box - Email "),
	txtBoxPassword("//input[@id='pass']",XPATH,"Customer Login page -Text Box - Pass"),
	btnSignIn("//button[@class='action login primary']",XPATH,"Customer Login page - Sign In button"),
	btnCreateAnAccount("//a[@class='action create primary']",XPATH,"Login Page - Button - Create An Account"),
	titleCreateNewCustomerAccount("//h1[@class='page-title']/span",XPATH,"Create new Customer Account Page - title - Create New Customer Account Page"),
	txtBoxFirstName("firstname",ID,"Create New Customer Account Page - First Name text Box"),
	txtBoxLastName("lastname",ID,"Create New Customer Account Page - Last name Text Box"),
	txtBoxEmailNewCustomerPage("email_address",ID,"Create New Customer Account Page - Text Box - Email"),
	txtBoxPasswordNewCustomerPage("//input[@id='password']",ID,"Create New Customer Account Page - Text Box - Password"),
	txtBoxConfirmPassword("password-confirmation",ID,"Create New Customer Account Page - Text Box - Confirm Password"),
	
	;

	String strProperty = "";
	ObjectLocator locatorType = null;
	String strObjName = "";

	public String getProperty() {
		return strProperty;
	}

	public ObjectLocator getLocatorType() {
		return locatorType;
	}

	private LoginPageObjects(String strPropertyValue, ObjectLocator locatorType, String strObjName) {
		this.strProperty = strPropertyValue;
		this.locatorType = locatorType;
		this.strObjName = strObjName;
	}

	@Override
	public String getObjectname() {
		// TODO Auto-generated method stub
		return strObjName;
	}
}
