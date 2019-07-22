package pages;

import static pages.ObjectLocator.*;
public enum MyAccountPageObjects implements PageObjects {

titleMyAccount("//h1[@class='page-title']/span",XPATH,"My Account Page - Title - My Account"),
	
	// Left Hand navigation
	lblMyAccountLeftNavigation("//li[@class='nav item current']/strong",XPATH,"My Account Page - Label - My Account in Left Navigation"),
	lnkOrdersLeftNavigation("//a[text()='My Orders']",XPATH,"My Account Page - link - Orders"),
	lnkMyWishListLeftNavigation("//a[text()='My Wish List']",XPATH,"My Account Page - Link My Wish List In Left Navigation"),
	lnkAddressBookLeftNavigation("//a[text()='Address Book']",XPATH,"My Account Page - Link Address Book in Left Navigation"),
	lnkAccountInformationLeftNavigation("//a[text()='Account Information']",XPATH,"My Account Page - Link Account Information in Left Navigation"),
	lnkStoredPaymentMethodsLeftNavigation("//a[text()='Stored Payment Methods']",XPATH,"My Account Page - Link Account Information in Left Navigation"),
	lnkNewsletterSubscriptionLeftNavigation("//a[text()='Newsletter Subscriptions']",XPATH,"My Account Page - Link Account Information in Left Navigation"),
	lblCompareProducts("block-compare-heading",ID,"My Account Page - Label - Compare Products "),
	lblWishList("//strong[text()='My Wish List']",XPATH,"My Account Page - Label - Wish List"),
	
	// Main Page
	titleAccountInformation("//div[@class='block block-dashboard-info']/div/strong",XPATH,"My Account page - Title - Account Information"),
	
	// Contact Information
	subTitleContactInformation("//span[text()='Contact Information']",XPATH,"My Account Page - Label "),
	nameAndEmail("(//div[@class='box-content']/p)[1]",XPATH,"My Account Page - Name and Email in Contact Information section"),
	lnkEditContactInformation("//div[@class='box box-information']/div[@class='box-actions']/a[@class='action edit']",XPATH,"My Account Page - Edit Button"),
	lnkChangePassword("//a[@class='action change-password']",XPATH,"My Account Page - Link - Change Password"),
	
	titleEditAcountInformation("//h1[@class='page-title']/span",XPATH,"My Account Page - Title - Edit Account Information"),
	txtBoxCurrentPassword("current-password",ID,"My Account page - Edit Account Information Section - Current Password Text Box"),
	txtBoxNewPassword("//input[@id='password']",XPATH,"My Account Page - Edit Account Information Section - New Password Text Box"),
	txtBoxConfirmPassword("password-confirmation",ID,"My Account Page - Edit Account Information Section - Confirm Password Text Box"),
	btnSave("//button[@title='Save']",XPATH,"My Account Page - Edit Account Information - Save Button"),
	msgAccountInformationSaved("//div[@class='message-success success message']/div",XPATH,"My Account Page - message - You saved the account information."),
	// NewsLetters
	subTitleNewsletters("//span[text()='Newsletters']",XPATH,"My Account Page - Label - Newsletters"),
	msgSubscription("(//div[@class='box-content']/p)[2]",XPATH,"My Account Page - Message - You are subscribed to \"General Subscription\"."),
	lnkEditNewsletter("//div[@class='box box-newsletter']/div[2]/a",XPATH,"My Account Page - Link Edit in Newsletters section"),
	
	// Address Book
	subTitleAddressBook("//div[@class='block block-dashboard-addresses']/div/strong",XPATH,"My Account Page - Address Book sub Title"),
	lnkManageAddress("//div[@class='block block-dashboard-addresses']/div/a",XPATH,"My Account Page - Manage Address Link"),
	lblDefaultBillingAddress("//span[text()='Default Billing Address']",XPATH,"My Account Page - Label - Default Billing Address"),
	billingAddress("//div[@class='box box-billing-address']/div/address",XPATH,"My Account Page - Billing Address"),
	lnkEditDefalutBillingAddress("//div[@class='box box-address-billing']/div[2]/a",XPATH,"My Account Page - link Edit address in Defalut Billing Address"),
	lnkEditDefalutBillingAddressSTG("//div[@class='box box-address-billing']/div[2]/a",XPATH,"My Account Page - link Edit address in Defalut Billing Address"),
	
	lblDefaultShippingAddress("//div[@class='box box-shipping-address']/strong/span",XPATH,"My Account Page - label - Default Shipping Address"),
	shippingAddress("//div[@class='box box-shipping-address']/div/address",XPATH,"My Account page - Shipping Address - Default Shippng Address"),
	lnkEditDefaultShippingAddress("//div[@class='box box-shipping-address']/div[2]/a",XPATH,"My Account page - Edit Address in Defalut Shipping Address"),
	
	
	// Manage Address 
	btnAddNewAddress("//a[@class='action primary add']",XPATH,"My Account Page - Manage Address section - Link Add New Address"),
	
	// Add New Address
	lblAddNewAddress("//h1[@class='page-title']/span",XPATH,"My Account Page - Add New Address section - Title - Add New Address"),
	lblContactInformation("//span[text()='Contact Information']",XPATH,"My Account Page - Add New Address Section - Label - Contact Information"),
	txtBoxFirstName("//input[@name='firstname']",XPATH,"My Account Page -Add new Address Section -  Text Box - First Name"),
	txtBoxLastName("//input[@name='lastname']",XPATH,"My Account Page - Add New Address Section - Text Box  - Last Name"),
	txtBoxCompany("//input[@name='company']",XPATH,"My Account page - Add New Address Section - Text Box - Company"),
	txtBoxTelephone("//input[@name='telephone']",XPATH,"My Account page - Add new Address Section - Text Box Telephone"),
	
	// Street Address
	txtBoxStreetAddressLine1("street_1",ID,"My Account Page - Add new Address Section - Text Box - Street Address Line 1"),
	txtBoxCity("city",ID,"My Account Page - Add New Address Section - Text Box - City"),
	drpDownState("region_id",ID,"My Account Page- Add new Address section - Drop Down - State"),
	txtBoxZipCode("//input[@id='zip']",XPATH,"My Account Page - Add New Address Section - Zip code Text Box"),
	btnSaveAddress("//button[@title='Save Address']",XPATH,"My Account Page - Add New Address Section - Button Save Address"),
	msgNoAdditionalAddressEntry("//p[@class='empty']",XPATH,"My Account Page -Addtional Address Msg"),
	lnkDeleteAddress("//a[@class='action delete']",XPATH,"My Account Page - Add New Address Section - Addtional Address - Delete Address link"),
	msgAddressDeleted("//div[@class='message-success success message']/div",XPATH,"My Account Page - Address Book - msg: You deleted the address."),
	lnkeditAdditionlAddress("(//a[@class='action edit'])[3]",XPATH,"My Account Page - Edit Address link"),
	titleEditAddress("//h1[@class='page-title']/span",XPATH,"My Account Page - Edit Address Page - "),
	
	// Wish list section
	imgProduct("(//div[@class='product-item-info']/a)[1]",XPATH,"My Account Page - Wish List Section - Product Image"),
	btnAddToCart("//div[@class='actions-primary']/button[@title='Add to Cart']",XPATH,"My Account Page - Wish List Section - Button - Add To Cart"),
	lnkEditProduct("//a[@class='action edit']",XPATH,"My Account Page - Wish list section - Product - Link Edit"),
	lnkRemoveItem("//a[@title='Remove Item']",XPATH,"My Account Page - Wish List Section - Product Link - Remove Item"),	
	txtBoxQuantity("//input[@class='input-text qty']",XPATH,"My Account Page - Wish List Section - Text Box - Quantity"),
	emptyWishListMsg("//div[@class='message info empty']/span",XPATH,"My Account Page - Wish List section - Message: You have no items in your wish list."),
	btnUpdateWishList("//button[@title='Update Wish List']",XPATH,"My Account Page - Update Wish List button"),
	btnShareWishList("//button[@title='Share Wish List']",XPATH,"My Account Page - Share Wish List button"),
	btnAddAllToCart("//button[@title='Add All to Cart']",XPATH,"My Account Page - Add All To Cart Button"),
	// Wish List Sharing page
	lblWishListSharing("//h1/span",XPATH,"My Account Page - Wish List Sharing - label - Wish List Sharing"),
	txtAreaEmails("email_address",ID,"My Account Page - wish List Sharing - Text Area - Emails"),
	txtAreaMessage("//textarea[@id='message']",XPATH,"My Account Page - Wish List Sharing - Text Area - Message"),
	msgSuccessShareWishList("//div[@class='message-success success message']/div",XPATH,"My Account Page - Wish List Sharing - Success message - Your wish list has been shared."),
	// Account Information Page
	chkBoxChangeMail("//input[@id='change-email']",XPATH,"My Account Page - Account Information - Check box - Change Mail"),
	chkBoxChangePassword("//input[@id='change-password']",XPATH,"My Account Page - Account Information - Check Box - Change Password"),
	txtBoxEmail("//input[@id='email']",XPATH,"My Account Page - Account Information - Email Text Box"),
	
	btnSaveAddressOnVerifyAddressOverlay("//button[@class='action-primary action primary']",XPATH,"My Account Page - Verify Address Overlay - Save Address button"),
	// Newletter
	lblNewsLetter("//h1/span",XPATH,"My Account Page - Newsletter page - label - Newsletter"),
	chekBoxGeneralSubscription("//input[@id='subscription']",XPATH,"My Account Page  - News Letter - Checkbox - General Subscription"),
	btnSavenewsletterSubscription("//button[@title='Save']",XPATH,"My Account Page - Newsletter Subscription - Save Button"),
	msgSuccessNewsletterSubscription("//div[@class='message-success success message']/div",XPATH,"My Account page - success message for changes in newsletter subscription"),
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

	private MyAccountPageObjects(String strPropertyValue, ObjectLocator locatorType, String strObjName) {
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
