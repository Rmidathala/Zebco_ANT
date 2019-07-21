package businesscomponents;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import componentgroups.CommonFunctions;
import pages.CheckoutPageObjects;
import pages.ProductDetailsPageObjects;
import pages.ShoppingCartPageObjects;

public class ShoppingCartPageComponents extends ReusableLibrary {



	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public ShoppingCartPageComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	CommonFunctions commonFunction = new CommonFunctions(scriptHelper);
	LocalTime liveTime = LocalTime.now(ZoneId.of("America/New_York"));
	WebDriverUtil webdriverutil = new WebDriverUtil(driver);
	
	private WebElement getPageElement(ShoppingCartPageObjects pageEnum) {
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
			report.updateTestLog("Product Details Page - get page element",
					pageEnum.toString() + " object is not defined or found.", Status.FAIL);
			return null;
		}
	}
	
	public void navigateToCheckOutPage() {
		try {
			commonFunction.clickIfElementPresent(getPageElement(ShoppingCartPageObjects.btnGoToCheckout), ShoppingCartPageObjects.btnGoToCheckout.getObjectname());
			if(commonFunction.isElementPresentContainsText(getPageElement(CheckoutPageObjects.titleShippingAddress), CheckoutPageObjects.titleShippingAddress.getObjectname(), "Shipping Address")) {
				report.updateTestLog("Verify Navigation to Checkout Page",
						"User is successfully Navigated to Checkout page", Status.PASS);
			} else {
				report.updateTestLog("Verify Navigation to Checkout Page",
						"User is NOT Navigated to Checkout Page", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Navigate to Checkout Page", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void validateProductAddedToCart() {
		try {
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.productImage), ShoppingCartPageObjects.productImage.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.productName), ShoppingCartPageObjects.productName.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.btnGoToCheckout), ShoppingCartPageObjects.btnGoToCheckout.getObjectname());
		}catch(Exception e) {
			report.updateTestLog("Navigate to Checkout Page", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void validateShoppingCartPage() {
		try {
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.titleShoppingCart), ShoppingCartPageObjects.titleShoppingCart.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.paginationOverview), ShoppingCartPageObjects.paginationOverview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.paginationBillingShipping), ShoppingCartPageObjects.paginationBillingShipping.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.paginationPayment), ShoppingCartPageObjects.paginationPayment.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.paginationConfirmation), ShoppingCartPageObjects.paginationConfirmation.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.lblItem), ShoppingCartPageObjects.lblItem.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.lblPrice), ShoppingCartPageObjects.lblPrice.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.lblQty), ShoppingCartPageObjects.lblQty.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.lblSubTotal), ShoppingCartPageObjects.lblSubTotal.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.productPrice), ShoppingCartPageObjects.productPrice.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.productQty), ShoppingCartPageObjects.productQty.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.productSubTotal), ShoppingCartPageObjects.productSubTotal.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.btnEditParameters), ShoppingCartPageObjects.btnEditParameters.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.btnremoveProduct), ShoppingCartPageObjects.btnremoveProduct.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.lnkMoveToWishList), ShoppingCartPageObjects.lnkMoveToWishList.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.btnUpdateShoppingCart), ShoppingCartPageObjects.btnUpdateShoppingCart.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.titleSummary), ShoppingCartPageObjects.titleSummary.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.estimateShippingTaxSection), ShoppingCartPageObjects.estimateShippingTaxSection.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.btnGoToCheckout), ShoppingCartPageObjects.btnGoToCheckout.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.lblSubtotalSummarySection), ShoppingCartPageObjects.lblSubtotalSummarySection.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.priceSubTotalSummarySection), ShoppingCartPageObjects.priceSubTotalSummarySection.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.lblOrderTotalSummarySection), ShoppingCartPageObjects.lblOrderTotalSummarySection.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.priceOrderTotalSummarySection), ShoppingCartPageObjects.priceOrderTotalSummarySection.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.lblHaveADiscount), ShoppingCartPageObjects.lblHaveADiscount.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.txtBoxCounponCode), ShoppingCartPageObjects.txtBoxCounponCode.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.btnApplyDiscount), ShoppingCartPageObjects.btnApplyDiscount.getObjectname());
			
		}catch(Exception e) {
			report.updateTestLog("Validate Shopping Cart Page", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void validateShoppingCartQuantityUpdate() {
		try {
			double priceBeforeQuantityIncrease = Double.parseDouble(commonFunction.getTextFromElement(getPageElement(ShoppingCartPageObjects.productSubTotal)).substring(1));
			commonFunction.clearAndEnterText(getPageElement(ShoppingCartPageObjects.productQty), "2", ShoppingCartPageObjects.productQty.getObjectname());
			commonFunction.hitEnterKey(getPageElement(ShoppingCartPageObjects.productQty), ShoppingCartPageObjects.productQty.getObjectname());
			double priceAfterQuantityIncrease = Double.parseDouble(commonFunction.getTextFromElement(getPageElement(ShoppingCartPageObjects.productSubTotal)).substring(1));
			if(priceAfterQuantityIncrease==(priceBeforeQuantityIncrease*2)) {
				report.updateTestLog("Verify Quantity field in Shopping Cart is working",
						"User is successfully Navigated to Checkout page", Status.PASS);
			} else {
				report.updateTestLog("Verify Navigation to Checkout Page",
						"User is NOT Navigated to Checkout Page", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Validate Quantity in Shopping Cart", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void validateContinueShoppingLink() {
		try {
			commonFunction.clickIfElementPresent(getPageElement(ShoppingCartPageObjects.lnkContinueShopping), ShoppingCartPageObjects.lnkContinueShopping.getObjectname());
			if(driver.getCurrentUrl().equalsIgnoreCase("https://www.zebco.com")) {
				report.updateTestLog("Verify user navigates to Home Page on clicking Continue Shopping Link",
						"User is successfully Navigated to Home Page on clicking Continue Shopping Link", Status.PASS);
			} else {
				report.updateTestLog("Verify user navigates to Home Page on clicking Continue Shopping Link",
						"User is NOT Navigated to Home Page on clicking Continue Shopping Link", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Validate Continue Shopping Link in Shopping Cart Page", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void clearShoppingCart() {
		try {
			List<WebElement> removeBtns = commonFunction.getElementsByProperty(ShoppingCartPageObjects.btnremoveProduct.getProperty(), ShoppingCartPageObjects.btnremoveProduct.getLocatorType().toString());
			int i=1;
			for(WebElement removeBtn : removeBtns) {
				commonFunction.clickIfElementPresent(removeBtn, "Shopping Cart Page - Remove Product #"+i);
				i++;
				if(i<removeBtns.size()) {
				removeBtns = commonFunction.getElementsByProperty(ShoppingCartPageObjects.btnremoveProduct.getProperty(), ShoppingCartPageObjects.btnremoveProduct.getLocatorType().toString());
				}
			}
		}catch(Exception e) {
			report.updateTestLog("Validate Continue Shopping Link in Shopping Cart Page", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void validateMoveProductToWishListFromShoppingCart() {
		try {
			commonFunction.clickIfElementPresent(getPageElement(ShoppingCartPageObjects.lnkMoveToWishList), ShoppingCartPageObjects.lnkMoveToWishList.getObjectname());
			if(commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.msgProdutctMovedToWishList), ShoppingCartPageObjects.msgProdutctMovedToWishList.getObjectname())) {
				report.updateTestLog("Verify Product is successfully moved to Wishlist from Shopping Cart Page",
						"Product is successfully moved to Wishlist from Shopping Cart Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Product is successfully moved to Wishlist from Shopping Cart Page",
						"Product is NOT moved to Wishlist from Shopping Cart Page", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Validate Move Product To Wishlist from Shopping Cart Page", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void validateEstimateShippingAndTax() {
		try {
			String state = dataTable.getData("General_Data", "State");
			String zipCode = dataTable.getData("General_Data", "ZipCode");
			commonFunction.clickIfElementPresent(getPageElement(ShoppingCartPageObjects.estimateShippingTaxSection), ShoppingCartPageObjects.estimateShippingTaxSection.getObjectname());
			commonFunction.selectAnyElement(getPageElement(ShoppingCartPageObjects.drpDownState), state, ShoppingCartPageObjects.drpDownState.getObjectname());
			commonFunction.clearAndEnterTextTabOut(getPageElement(ShoppingCartPageObjects.txtBoxZipCode), zipCode, ShoppingCartPageObjects.txtBoxZipCode.getObjectname());
			Thread.sleep(5000);
			commonFunction.clickIfElementPresent(getPageElement(ShoppingCartPageObjects.radioBtnGroundShipping), ShoppingCartPageObjects.radioBtnGroundShipping.getObjectname());
			if(commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.lblshippingCharges), ShoppingCartPageObjects.lblshippingCharges.getObjectname()) && commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.priceShippingChargeSummarySection), ShoppingCartPageObjects.priceShippingChargeSummarySection.getObjectname())) {
				report.updateTestLog("Verify Estimate shipping and Tax in Shopping Cart Page",
						"Shipping value is successfully displayed on the Shopping Cart Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Estimate shipping and Tax in Shopping Cart Page",
						"Shipping value is NOT displayed on the Shopping Cart Page", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Validate Estimate Shipping And Tax", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void validateOrderSummaryInShoppingCartPage() {
		try {
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.titleSummary), ShoppingCartPageObjects.titleSummary.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.estimateShippingTaxSection), ShoppingCartPageObjects.estimateShippingTaxSection.getObjectname());
			String state = dataTable.getData("General_Data", "State");
			String zipCode = dataTable.getData("General_Data", "ZipCode");
			commonFunction.clickIfElementPresent(getPageElement(ShoppingCartPageObjects.estimateShippingTaxSection), ShoppingCartPageObjects.estimateShippingTaxSection.getObjectname());
			commonFunction.selectAnyElement(getPageElement(ShoppingCartPageObjects.drpDownState), state, ShoppingCartPageObjects.drpDownState.getObjectname());
			commonFunction.clearAndEnterTextTabOut(getPageElement(ShoppingCartPageObjects.txtBoxZipCode), zipCode, ShoppingCartPageObjects.txtBoxZipCode.getObjectname());
			Thread.sleep(5000);
			commonFunction.clickIfElementPresent(getPageElement(ShoppingCartPageObjects.radioBtnGroundShipping), ShoppingCartPageObjects.radioBtnGroundShipping.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.lblSubtotalSummarySection), ShoppingCartPageObjects.lblSubtotalSummarySection.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.priceSubTotalSummarySection), ShoppingCartPageObjects.priceSubTotalSummarySection.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.lblshippingCharges), ShoppingCartPageObjects.lblshippingCharges.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.priceShippingChargeSummarySection), ShoppingCartPageObjects.priceShippingChargeSummarySection.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.lblOrderTotalSummarySection), ShoppingCartPageObjects.lblOrderTotalSummarySection.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ShoppingCartPageObjects.priceOrderTotalSummarySection), ShoppingCartPageObjects.priceOrderTotalSummarySection.getObjectname());
		}catch(Exception e) {
			
		}
	}
	
	public void clearShoppingCartIfNotEmpty() {
		try {
			if(webdriverutil.objectExists(By.xpath(ShoppingCartPageObjects.itemCountOnMiniCart.getProperty()))) {
				commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.miniCartIcon), ProductDetailsPageObjects.miniCartIcon.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.miniCartbtnGoToCart), ProductDetailsPageObjects.miniCartbtnGoToCart.getObjectname());
			
			List<WebElement> removeBtns = commonFunction.getElementsByProperty(ShoppingCartPageObjects.btnremoveProduct.getProperty(), ShoppingCartPageObjects.btnremoveProduct.getLocatorType().toString());
			int i=1;
			for(WebElement removeBtn : removeBtns) {
				commonFunction.clickIfElementPresent(removeBtn, "Shopping Cart Page - Remove Product #"+i);
				i++;
				if(i<removeBtns.size()) {
				removeBtns = commonFunction.getElementsByProperty(ShoppingCartPageObjects.btnremoveProduct.getProperty(), ShoppingCartPageObjects.btnremoveProduct.getLocatorType().toString());
				}
			}
			}else {
				report.updateTestLog("Empty Shopping Cart",
						"Shopping Cart is already Empty", Status.DONE);
			}
		}catch(Exception e) {
			report.updateTestLog("Empty Shopping Cart", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
}
