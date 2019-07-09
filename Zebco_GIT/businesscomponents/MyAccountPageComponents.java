package businesscomponents;

import java.time.LocalTime;
import java.time.ZoneId;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import componentgroups.CommonFunctions;
import pages.MyAccountPageObjects;
import pages.ProductDetailsPageObjects;


public class MyAccountPageComponents extends ReusableLibrary {

	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public MyAccountPageComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	CommonFunctions commonFunction = new CommonFunctions(scriptHelper);
	LocalTime liveTime = LocalTime.now(ZoneId.of("America/New_York"));
	WebDriverUtil webdriverutil = new WebDriverUtil(driver);
	
	private WebElement getPageElement(MyAccountPageObjects pageEnum) {
		WebElement element;
		try {
			element = commonFunction.getElementByProperty(pageEnum.getProperty(), pageEnum.getLocatorType().toString(),
					true);
			if (element != null) {
				System.out.println("Found the element: " + pageEnum.getObjectname());
			return element;
			}
			else {
				System.out.println("Element Not Found: "+pageEnum.getObjectname());
				return null;
			}
		} catch (Exception e) {
			report.updateTestLog("Home Page - get page element",
					pageEnum.toString() + " object is not defined or found.", Status.FAIL);
			return null;
		}
	}

	private WebElement getPageElement(ProductDetailsPageObjects pageEnum) {
		WebElement element;
		try {
			element = commonFunction.getElementByProperty(pageEnum.getProperty(), pageEnum.getLocatorType().toString(),
					true);
			if (element != null) {
				System.out.println("Found the element: " + pageEnum.getObjectname());
			return element;
			}
			else {
				System.out.println("Element Not Found: "+pageEnum.getObjectname());
				return null;
			}
		} catch (Exception e) {
			report.updateTestLog("Home Page - get page element",
					pageEnum.toString() + " object is not defined or found.", Status.FAIL);
			return null;
		}
	}
	public void validateMyAccountPage() {
		try {
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.titleMyAccount), MyAccountPageObjects.titleMyAccount.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lblMyAccountLeftNavigation), MyAccountPageObjects.lblMyAccountLeftNavigation.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lnkOrdersLeftNavigation), MyAccountPageObjects.lnkOrdersLeftNavigation.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lnkMyWishListLeftNavigation), MyAccountPageObjects.lnkMyWishListLeftNavigation.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lnkAddressBookLeftNavigation), MyAccountPageObjects.lnkAddressBookLeftNavigation.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lnkAccountInformationLeftNavigation), MyAccountPageObjects.lnkAccountInformationLeftNavigation.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lnkStoredPaymentMethodsLeftNavigation), MyAccountPageObjects.lnkStoredPaymentMethodsLeftNavigation.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lnkNewsletterSubscriptionLeftNavigation), MyAccountPageObjects.lnkNewsletterSubscriptionLeftNavigation.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lblCompareProducts), MyAccountPageObjects.lblCompareProducts.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lblWishList), MyAccountPageObjects.lblWishList.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.titleAccountInformation), MyAccountPageObjects.titleAccountInformation.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.subTitleContactInformation), MyAccountPageObjects.subTitleContactInformation.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.nameAndEmail), MyAccountPageObjects.nameAndEmail.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lnkEditContactInformation), MyAccountPageObjects.lnkEditContactInformation.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lnkChangePassword), MyAccountPageObjects.lnkChangePassword.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.subTitleNewsletters), MyAccountPageObjects.subTitleNewsletters.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.msgSubscription), MyAccountPageObjects.msgSubscription.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lnkEditNewsletter), MyAccountPageObjects.lnkEditNewsletter.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.subTitleAddressBook), MyAccountPageObjects.subTitleAddressBook.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lnkManageAddress), MyAccountPageObjects.lnkManageAddress.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lblDefaultBillingAddress), MyAccountPageObjects.lblDefaultBillingAddress.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.billingAddress), MyAccountPageObjects.billingAddress.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lnkEditDefalutBillingAddress), MyAccountPageObjects.lnkEditDefalutBillingAddress.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lblDefaultShippingAddress), MyAccountPageObjects.lblDefaultShippingAddress.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.shippingAddress), MyAccountPageObjects.shippingAddress.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lnkEditDefaultShippingAddress), MyAccountPageObjects.lnkEditDefaultShippingAddress.getObjectname());
			
		}catch(Exception e) {
			report.updateTestLog("My Account Page - Validate My Account Page", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void validateAddNewAddress() {
		try {
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.lnkAddressBookLeftNavigation), MyAccountPageObjects.lnkAddressBookLeftNavigation.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.btnAddNewAddress), MyAccountPageObjects.btnAddNewAddress.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lblAddNewAddress), MyAccountPageObjects.lblAddNewAddress.getObjectname());
			String firstName = dataTable.getData("General_Data", "FirstName");
			String lastName = dataTable.getData("Genenral_Data", "LastName");
			String company = dataTable.getData("General_Data", "Company");
			String phone = dataTable.getData("General_Data", "Phone");
			String streetAddr = dataTable.getData("General_Data", "StreetAddress");
			String city = dataTable.getData("General_Data", "City");
			String state = dataTable.getData("General_Data", "State");
			String zipCode = dataTable.getData("General_Data", "ZipCode");
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxFirstName), firstName, MyAccountPageObjects.txtBoxFirstName.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxLastName), lastName, MyAccountPageObjects.txtBoxLastName.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxCompany), company, MyAccountPageObjects.txtBoxCompany.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxTelephone), phone, MyAccountPageObjects.txtBoxTelephone.getObjectname());
			
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxStreetAddressLine1), streetAddr, MyAccountPageObjects.txtBoxStreetAddressLine1.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxCity), city, MyAccountPageObjects.txtBoxCity.getObjectname());
			commonFunction.selectAnyElement(getPageElement(MyAccountPageObjects.drpDownState), state, MyAccountPageObjects.drpDownState.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxZipCode), zipCode, MyAccountPageObjects.txtBoxZipCode.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.btnSaveAddress), MyAccountPageObjects.btnSaveAddress.getObjectname());
			if(webdriverutil.objectExists(By.xpath(MyAccountPageObjects.btnSaveAddressOnVerifyAddressOverlay.getProperty()))) {
				commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.btnSaveAddressOnVerifyAddressOverlay), MyAccountPageObjects.btnSaveAddressOnVerifyAddressOverlay.getObjectname());	
			}
			if(commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lnkDeleteAddress), MyAccountPageObjects.lnkDeleteAddress.getObjectname())) {
				report.updateTestLog("Verify Address is saved",
						"New Address is saved successfully", Status.PASS);
			} else {
				report.updateTestLog("Verify Address is saved",
						"New Address is NOT saved", Status.FAIL);
			}
			
		}catch(Exception e) {
			report.updateTestLog("My Account Page - Validate Add New Address", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}

	public void validateEditAddress() {
		try {
			
			String firstName = dataTable.getData("General_Data", "FirstName");
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.lnkEditDefalutBillingAddress), MyAccountPageObjects.lnkEditDefalutBillingAddress.getObjectname());
			if(commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.titleEditAddress), MyAccountPageObjects.titleEditAddress.getObjectname())) {
				report.updateTestLog("Verify user navigated to Edit Address Page",
						"User successfully navigated to edit address page", Status.PASS);
			} else {
				report.updateTestLog("Verify user navigated to Edit Address Page",
						"User NOT navigated to edit address page", Status.FAIL);
			}
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxFirstName), firstName, MyAccountPageObjects.txtBoxFirstName.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.btnSaveAddress), MyAccountPageObjects.btnSaveAddress.getObjectname());
		}catch(Exception e) {
			report.updateTestLog("My Account Page - Validate Edit Address", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void validateEditAdditionalAddress() {
		try {
			
			String firstName = dataTable.getData("General_Data", "FirstName");
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.lnkeditAdditionlAddress), MyAccountPageObjects.lnkeditAdditionlAddress.getObjectname());
			if(commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.titleEditAddress), MyAccountPageObjects.titleEditAddress.getObjectname())) {
				report.updateTestLog("Verify user navigated to Edit Address Page",
						"User successfully navigated to edit address page", Status.PASS);
			} else {
				report.updateTestLog("Verify user navigated to Edit Address Page",
						"User NOT navigated to edit address page", Status.FAIL);
			}
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxFirstName), firstName, MyAccountPageObjects.txtBoxFirstName.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.btnSaveAddress), MyAccountPageObjects.btnSaveAddress.getObjectname());
		}catch(Exception e) {
			report.updateTestLog("My Account Page - Validate Edit Address", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	public void validateChangePassword() {
		try {
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.lnkChangePassword), MyAccountPageObjects.lnkChangePassword.getObjectname());
			if(commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.titleEditAcountInformation), MyAccountPageObjects.titleEditAcountInformation.getObjectname())) {
				report.updateTestLog("Verify user navigated to Edit Account Information Page",
						"User successfully navigated to edit Account Information Page", Status.PASS);
			} else {
				report.updateTestLog("Verify user navigated to Edit Account Information Page",
						"User NOT navigated to edit Account Information Page", Status.FAIL);
			}
			String pass = dataTable.getData("General_Data", "Password");
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxCurrentPassword), pass, MyAccountPageObjects.txtBoxCurrentPassword.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxNewPassword), pass, MyAccountPageObjects.txtBoxNewPassword.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxConfirmPassword), pass, MyAccountPageObjects.txtBoxConfirmPassword.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.btnSave), MyAccountPageObjects.btnSave.getObjectname());
			if(commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.msgAccountInformationSaved), MyAccountPageObjects.msgAccountInformationSaved.getObjectname())) {
				report.updateTestLog("Verify Change Password functinality is working",
						"User is able to update and change the password", Status.PASS);
			} else {
				report.updateTestLog("Verify Change Password functinality is working",
						"User is NOT able to update and change the password", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("My Account Page - Validate Change Password", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void validateRemoveAddress() {
		try {
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.lnkDeleteAddress), MyAccountPageObjects.lnkDeleteAddress.getObjectname());
			if(commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.msgNoAdditionalAddressEntry), MyAccountPageObjects.msgNoAdditionalAddressEntry.getObjectname())) {
				report.updateTestLog("Verify Address is deleted",
						"User is able to delete Address successfully", Status.PASS);
			} else {
				report.updateTestLog("Verify Address is deleted",
						"User is NOT able to delete Address", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("My Account Page - Remove Address", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void navigateToWishListFromMyAccountPage() {
		try {
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.lnkMyWishListLeftNavigation), MyAccountPageObjects.lnkMyWishListLeftNavigation.getObjectname());
			if(commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.imgProduct), MyAccountPageObjects.imgProduct.getObjectname())) {
				report.updateTestLog("Verify user navigated to Wish list from My Account Page",
						"User successfully navigated to Wish List Page", Status.PASS);
			} else {
				report.updateTestLog("Verify user navigated to Wish list from My Account Page",
						"User NOT navigated to Wish List Page", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Navigate To Wish List from My Account Page", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void addProductToCartFromWishList() {
		try {
			commonFunction.mouseOver(getPageElement(MyAccountPageObjects.imgProduct), MyAccountPageObjects.imgProduct.getObjectname());
			if(commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.btnAddToCart), MyAccountPageObjects.btnAddToCart.getObjectname())) {
				report.updateTestLog("Verify product added to cart from wishlist",
						"Product is successfully added to cart from Wish list", Status.PASS);
			} else {
				report.updateTestLog("Verify product added to cart from wishlist",
						"Product is NOT added to cart from Wish list", Status.FAIL);
			}
			
		}catch(Exception e) {
			report.updateTestLog("Add Product to Cart From Wish List", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void removeProductFromWishList() {
		try {
			commonFunction.mouseOver(getPageElement(MyAccountPageObjects.imgProduct), MyAccountPageObjects.imgProduct.getObjectname());
			if(commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.lnkRemoveItem), MyAccountPageObjects.lnkRemoveItem.getObjectname())) {
				report.updateTestLog("Verify product added to cart from wishlist",
						"Product is successfully added to cart from Wish list", Status.PASS);
			} else {
				report.updateTestLog("Verify product added to cart from wishlist",
						"Product is NOT added to cart from Wish list", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Remove From Wish List", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void verifyAddAllToCartFromWishList() {
		try {
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.btnAddAllToCart), MyAccountPageObjects.btnAddAllToCart.getObjectname());
			if(commonFunction.isElementPresentContainsText(getPageElement(MyAccountPageObjects.emptyWishListMsg), MyAccountPageObjects.emptyWishListMsg.getObjectname(),"You have no items in your wish list.")) {
				report.updateTestLog("Verify if all the products are added to cart from wish list",
						"All the products in wish list are added to cart successfully", Status.PASS);
			} else {
				report.updateTestLog("Verify if all the products are added to cart from wish list",
						"All the products in wish list are NOT Added to cart", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Add All Product To Cart from Wish List", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	public void validateEditWishListProduct() {
		try {
			commonFunction.mouseOver(getPageElement(MyAccountPageObjects.imgProduct), MyAccountPageObjects.imgProduct.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxQuantity), "2", MyAccountPageObjects.txtBoxQuantity.getObjectname());
			commonFunction.hitEnterKey(getPageElement(MyAccountPageObjects.txtBoxQuantity), MyAccountPageObjects.txtBoxQuantity.getObjectname());
			commonFunction.mouseOver(getPageElement(MyAccountPageObjects.imgProduct), MyAccountPageObjects.imgProduct.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.lnkEditProduct), MyAccountPageObjects.lnkEditProduct.getObjectname());
			if(commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productMainName), ProductDetailsPageObjects.productMainName.getObjectname())) {
				report.updateTestLog("Verify user navigated to Product Details Page",
						"User successfully navigated to Product Details Page", Status.PASS);
			} else {
				report.updateTestLog("Verify user navigated to Product Details Page",
						"User NOT navigated to Product Details Page", Status.FAIL);
			}
			
			if(commonFunction.isElementPresentContainsText(getPageElement(ProductDetailsPageObjects.productQuantity), ProductDetailsPageObjects.productQuantity.getObjectname(),"2")) {
				report.updateTestLog("Verify Quantity is updated from the wish list",
						"Quanity is updated from the wish list", Status.PASS);
			} else {
				report.updateTestLog("Verify Quantity is updated from the wish list",
						"Quanity is not updated from the Wish list", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("My Account- Wish list - Edit Wish List product", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void validateShareWishList() {
		try {
			String email= dataTable.getData("General_Data", "Email_Share");
			String msg = dataTable.getData("General_Data", "Message");
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.btnShareWishList), MyAccountPageObjects.btnShareWishList.getObjectname());
			if(commonFunction.isElementPresentContainsText(getPageElement(MyAccountPageObjects.lblWishListSharing), MyAccountPageObjects.lblWishListSharing.getObjectname(),"Wish List Sharing")) {
				report.updateTestLog("Verify user navigated to Share Wish List Page",
						"User is successfully navigated to Share Wish List Page", Status.PASS);
			} else {
				report.updateTestLog("Verify user navigated to Share Wish List Page",
						"User is NOT navigated to Share Wish List Page", Status.FAIL);
			}
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtAreaEmails),email, MyAccountPageObjects.txtAreaEmails.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtAreaMessage), msg, MyAccountPageObjects.txtAreaMessage.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.btnShareWishList), MyAccountPageObjects.btnShareWishList.getObjectname());
			if(commonFunction.isElementPresentContainsText(getPageElement(MyAccountPageObjects.msgSuccessShareWishList), MyAccountPageObjects.msgSuccessShareWishList.getObjectname(),"Your wish list has been shared.")) {
				report.updateTestLog("Verify Wish List is shared",
						"Wish List is successfully Shared", Status.PASS);
			} else {
				report.updateTestLog("Verify Wish List is shared",
						"Wish List is NOT Shared", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("My Account- Wish list - Share Wish List", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	public void validateAccountInformationEdit() {
		try {
			String newEmail = commonFunction.randomAlphaNumeric(8)+"_automation@rmail.com";
			String pass = dataTable.getData("General_Data", "Password");
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.lnkAccountInformationLeftNavigation), MyAccountPageObjects.lnkAccountInformationLeftNavigation.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.chkBoxChangeMail), MyAccountPageObjects.chkBoxChangeMail.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.chkBoxChangePassword), MyAccountPageObjects.chkBoxChangePassword.getObjectname());
			dataTable.putData("MyAccountPageScenario", "Email", newEmail);
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxEmail), newEmail, MyAccountPageObjects.txtBoxEmail.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxCurrentPassword), pass, MyAccountPageObjects.txtBoxCurrentPassword.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxNewPassword), pass, MyAccountPageObjects.txtBoxNewPassword.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxConfirmPassword), pass, MyAccountPageObjects.txtBoxConfirmPassword.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.btnSave), MyAccountPageObjects.btnSave.getObjectname());
			if(commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.msgAccountInformationSaved), MyAccountPageObjects.msgAccountInformationSaved.getObjectname())) {
				report.updateTestLog("Verify Account Information Edit is working",
						"User is able to update info in Account Information Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Account Information Edit is working",
						"User is NOT able to update info in Account Information Page", Status.FAIL);
			}
			
		}catch(Exception e) {
			report.updateTestLog("My Account Page - Validate Account Information Edit", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	
	public void validateNewsletterSubscriptionChange() {
		try {
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.lnkNewsletterSubscriptionLeftNavigation), MyAccountPageObjects.lnkNewsletterSubscriptionLeftNavigation.getObjectname());
			if(commonFunction.isElementPresentContainsText(getPageElement(MyAccountPageObjects.lblNewsLetter), MyAccountPageObjects.lblNewsLetter.getObjectname(),"Newsletter Subscription")) {
				report.updateTestLog("Verify user navigated to News Letter subscrition Page",
						"User successfully navigated to newsletter subscription page", Status.PASS);
			} else {
				report.updateTestLog("Verify user navigated to News Letter subscrition Page",
						"User NOT navigated to newsletter subscription page", Status.FAIL);
			}
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.chekBoxGeneralSubscription), MyAccountPageObjects.chekBoxGeneralSubscription.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.btnSavenewsletterSubscription), MyAccountPageObjects.btnSavenewsletterSubscription.getObjectname());
		
			if(commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.msgSuccessNewsletterSubscription), MyAccountPageObjects.msgSuccessNewsletterSubscription.getObjectname())) {
				report.updateTestLog("Verify Newsletter subscription change is updated",
						"Newsletter subscription change is updated", Status.PASS);
			} else {
				report.updateTestLog("Verify Newsletter subscription change is updated",
						"Newsletter subscription change is NOT updated", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("My Account Page - Validate Newsletter subscription", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
}
