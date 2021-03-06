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
import pages.CheckoutPageObjects;

public class CheckOutPageComponents extends ReusableLibrary {



	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public CheckOutPageComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	CommonFunctions commonFunction = new CommonFunctions(scriptHelper);
	LocalTime liveTime = LocalTime.now(ZoneId.of("America/New_York"));
	WebDriverUtil webdriverutil = new WebDriverUtil(driver);
	
	private WebElement getPageElement(CheckoutPageObjects pageEnum) {
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
	
	public void enterShippingAddressDetails() {
		try {
			String email = commonFunction.randomAlphaNumeric(10)+"@rmail.com";
			String firstName = dataTable.getData("General_Data","FirstName");
			String lastName = dataTable.getData("General_Data","LastName");
			String company = dataTable.getData("General_Data","Company");
			String streetAddress1 = dataTable.getData("General_Data","StreetAddress");
			String city = dataTable.getData("General_Data","City");
			String state = dataTable.getData("General_Data","State");
			String zipCode = dataTable.getData("General_Data","ZipCode");
			String phoneNumber = dataTable.getData("General_Data","PhoneNumber");
			webdriverutil.waitUntilPageReadyStateComplete(20);
			Thread.sleep(2000);
			commonFunction.clearAndEnterTextTabOut(getPageElement(CheckoutPageObjects.txtBoxEmailAddress), email, CheckoutPageObjects.txtBoxEmailAddress.getObjectname());
			webdriverutil.waitUntilPageReadyStateComplete(20);
			Thread.sleep(2000);
			commonFunction.clearAndEnterText(getPageElement(CheckoutPageObjects.txtBoxFirstName), firstName, CheckoutPageObjects.txtBoxFirstName.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(CheckoutPageObjects.txtBoxLastName), lastName, CheckoutPageObjects.txtBoxLastName.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(CheckoutPageObjects.txtBoxCompany), company, CheckoutPageObjects.txtBoxCompany.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(CheckoutPageObjects.txtBoxStreetAddressLine1), streetAddress1, CheckoutPageObjects.txtBoxStreetAddressLine1.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(CheckoutPageObjects.txtBoxCity), city, CheckoutPageObjects.txtBoxCity.getObjectname());
			commonFunction.selectAnyElement(getPageElement(CheckoutPageObjects.drpDownState), state, CheckoutPageObjects.drpDownState.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(CheckoutPageObjects.txtBoxZipCode), zipCode, CheckoutPageObjects.txtBoxZipCode.getObjectname());
			commonFunction.clearAndEnterTextTabOut(getPageElement(CheckoutPageObjects.txtBoxPhoneNumber), phoneNumber, CheckoutPageObjects.txtBoxPhoneNumber.getObjectname());
		}catch(Exception e) {
			report.updateTestLog("Enter shipping Address Details", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void selectShippingMethod() {
		try {
			String shippingMethod = dataTable.getData("General_Data","ShippingMethod");
			if(shippingMethod.equalsIgnoreCase("Ground")) {
				commonFunction.clickIfElementPresentJavaScript(getPageElement(CheckoutPageObjects.radioBtnShippingMethodGround), CheckoutPageObjects.radioBtnShippingMethodGround.getObjectname());
			} else if(shippingMethod.equalsIgnoreCase("2ndDay")) {
				commonFunction.clickIfElementPresentJavaScript(getPageElement(CheckoutPageObjects.radioBtnShippingMethod2ndDay), CheckoutPageObjects.radioBtnShippingMethod2ndDay.getObjectname());
			} else {
				commonFunction.clickIfElementPresentJavaScript(getPageElement(CheckoutPageObjects.radioBtnShippingMethodNextDay), CheckoutPageObjects.radioBtnShippingMethodNextDay.getObjectname());
			}
		}catch(Exception e) {
			report.updateTestLog("Select Shipping Method", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void navigateToPaymentPage() {
		try {
			//driver.navigate().refresh();
			Thread.sleep(5000);
			commonFunction.clickIfElementPresent(getPageElement(CheckoutPageObjects.btnNext), CheckoutPageObjects.btnNext.getObjectname());
			if(commonFunction.isElementPresentContainsText(getPageElement(CheckoutPageObjects.titlePaymentMethod), CheckoutPageObjects.titlePaymentMethod.getObjectname(), "Payment Method:")) {
				report.updateTestLog("Verify user navigated to Payment Page",
						"User is successfully navigated to Payment Page", Status.PASS);
			} else {
				report.updateTestLog("Verify user navigated to Payment Page",
						"User is NOT navigated to Payment Page", Status.FAIL);
			}
			
		}catch(Exception e) {
			report.updateTestLog("Navigate to Payment Page", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void enterPaymentDetailsAndPlaceOrder() {
		try {

			String creditCardNumber = dataTable.getData("General_Data","CreditCard");
			String expMonth = dataTable.getData("General_Data","ExpMonth");
			String expYear = dataTable.getData("General_Data","ExpYear");
			String cvv = dataTable.getData("General_Data","CVV");
			String nameCard = dataTable.getData("General_Data","NameOnCard");
			if(driver.getCurrentUrl().contains("mcstaging")) {
				commonFunction.clickIfElementPresentJavaScript(getPageElement(CheckoutPageObjects.checkBoxCreditCard), CheckoutPageObjects.checkBoxCreditCard.getObjectname());
			}
			Thread.sleep(10000);
			driver.switchTo().frame(driver.findElement(By.id("xiintercept-iframe")));
			commonFunction.clearAndEnterText(getPageElement(CheckoutPageObjects.txtBoxNameOnCard), nameCard, CheckoutPageObjects.txtBoxNameOnCard.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(CheckoutPageObjects.txtBoxCreditCard), creditCardNumber, CheckoutPageObjects.txtBoxCreditCard.getObjectname());
			commonFunction.selectAnyElementByValue(getPageElement(CheckoutPageObjects.drpDownExpiryMonth), expMonth, CheckoutPageObjects.drpDownExpiryMonth.getObjectname());
			commonFunction.selectAnyElementByValue(getPageElement(CheckoutPageObjects.drpDonwExpiryYear), expYear, CheckoutPageObjects.drpDonwExpiryYear.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(CheckoutPageObjects.txtBoxCVV), cvv, CheckoutPageObjects.txtBoxCVV.getObjectname());
			driver.switchTo().defaultContent();
			if(driver.getCurrentUrl().contains("mcstaging")) {
				commonFunction.verifyIfElementIsPresent(getPageElement(CheckoutPageObjects.btnPlaceOrderSTG), CheckoutPageObjects.btnPlaceOrderSTG.getObjectname());
			}else {
			commonFunction.verifyIfElementIsPresent(getPageElement(CheckoutPageObjects.btnPlaceOrder), CheckoutPageObjects.btnPlaceOrder.getObjectname());
			}
			}catch(Exception e) {
			report.updateTestLog("Enter Payment Details and Place Order", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
}
