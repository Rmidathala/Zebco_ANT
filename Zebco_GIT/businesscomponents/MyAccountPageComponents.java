package businesscomponents;

import java.time.LocalTime;
import java.time.ZoneId;

import org.openqa.selenium.WebElement;

import com.cognizant.craft.ReusableLibrary;
import com.cognizant.craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import componentgroups.CommonFunctions;
import pages.MyAccountPageObjects;


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
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.lnkManageAddress), MyAccountPageObjects.lnkManageAddress.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.btnAddNewAddress), MyAccountPageObjects.btnAddNewAddress.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(MyAccountPageObjects.lblAddNewAddress), MyAccountPageObjects.lblAddNewAddress.getObjectname());
			String firstName = dataTable.getData("General_Data", "FirstName");
			String lastName = dataTable.getData("Genenral_Data", "LastName");
			String company = dataTable.getData("General_Data", "Company");
			String phone = dataTable.getData("General_Data", "Phone");
			String streetAddr = dataTable.getData("General_Data", "StreetAddress");
			String city = dataTable.getData("General_Data", "City");
			String state = dataTable.getData("General_Data", "State");
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxFirstName), firstName, MyAccountPageObjects.txtBoxFirstName.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxLastName), lastName, MyAccountPageObjects.txtBoxLastName.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxCompany), company, MyAccountPageObjects.txtBoxCompany.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxTelephone), phone, MyAccountPageObjects.txtBoxTelephone.getObjectname());
			
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxStreetAddressLine1), streetAddr, MyAccountPageObjects.txtBoxStreetAddressLine1.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(MyAccountPageObjects.txtBoxCity), city, MyAccountPageObjects.txtBoxCity.getObjectname());
			commonFunction.selectAnyElement(getPageElement(MyAccountPageObjects.txtBoxStreetAddressLine1), state, MyAccountPageObjects.txtBoxStreetAddressLine1.getObjectname());
		
			commonFunction.clickIfElementPresent(getPageElement(MyAccountPageObjects.btnSaveAddress), MyAccountPageObjects.btnSaveAddress.getObjectname());
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
			
		}catch(Exception e) {
			
		}
	}
	
	
}
