package pages;

import static pages.ObjectLocator.*;
public enum CheckoutPageObjects  implements PageObjects {

	titleShippingAddress("//li[@id='shipping']/div[1]",XPATH,"Shipping Address Page - Shipping Address Title"),
	
	txtBoxEmailAddress("//div[@class='control _with-tooltip']/input[@id='customer-email']",XPATH,"Shipping Address Page - Text Box - Email Address"),
	txtBoxFirstName("//input[@name='firstname']",XPATH,"Shipping Address Page - Text Box - First Name"),
	txtBoxLastName("//input[@name='lastname']",XPATH,"Shipping Address Page - Text Box - Last Name"),
	txtBoxCompany("//input[@name='company']",XPATH,"Shipping Address Page - Text Box - Company"),
	txtBoxStreetAddressLine1("//input[@name='street[0]']",XPATH,"Shipping Address Page - Text Box - Street Address Line 1"),
	txtBoxStreetAddressLine2("//input[@name='street[1]']",XPATH,"Shipping Address Page - Text Box - Street Address Line 2"),
	txtBoxStreetAddressLine3("//input[@name='street[2]']",XPATH,"Shipping Address Page - Text Box - Street Address Line 3"),
	txtBoxCity("//input[@name='city']",XPATH,"Shipping Address Page - Text Box - City"),
	drpDownState("//select[@name='region_id']",XPATH,"Shipping Address Page - Drop Down - State"),
	txtBoxZipCode("//input[@name='postcode']",XPATH,"Shipping Address Page - Text Box - Zip Code"),
	drpDownCountry("//select[@name='country_id']",XPATH,"Shipping Address Page - Drop Down - Country"),
	txtBoxPhoneNumber("//input[@name='telephone']",XPATH,"Shipping Address Page - Text Box - Phone Number"),
	titleShippingMethods("//div[@class='checkout-shipping-method']/div[1]",XPATH,"Shipping Address Page - Shipping Methods Title"),
	radioBtnShippingMethodGround("//input[@value='zebcoshipping_ground']",XPATH,"Shipping Address Page - Shipping Methods- Ground radio Button"),
	radioBtnShippingMethod2ndDay("//input[@value='zebcoshipping_2nd_day']",XPATH,"Shipping Address Page - Shipping Methods- 2nd Day radio Button"),
	radioBtnShippingMethodNextDay("//input[@value='zebcoshipping_next_day']",XPATH,"Shipping Address Page - Shipping Methods- Next Day radio Button"),
	btnNext("//button[@class='button action continue primary']",XPATH,"Shipping Address Page - Next Button"),
	
	// Payment page
	
	txtBoxCreditCard("//input[@title='Credit Card Number']",XPATH,"Payment Page - Credit Card Number text box"),
	drpDownExpiryMonth("//select[@name='payment[cc_exp_month]']",XPATH,"Payment Page - Expiry Month Drop Down"),
	drpDonwExpiryYear("//select[@name='payment[cc_exp_year]']",XPATH,"Payment page - Expiry Year Drop Down"),
	txtBoxCVV("//input[@name='payment[cc_cid]']",XPATH,"Payment Page - CVV text Box"),
	btnPlaceOrder("//button[@title='Place Order']",XPATH,"Payment Page - Place Orer Button"),
	
	titlePaymentMethod("//div[@class='payment-group']/div[@class='step-title']",XPATH,"Payment Page - title Payment Method"),
	
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

	private CheckoutPageObjects(String strPropertyValue, ObjectLocator locatorType, String strObjName) {
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
