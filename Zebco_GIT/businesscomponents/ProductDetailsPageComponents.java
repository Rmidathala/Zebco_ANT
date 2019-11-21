package businesscomponents;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import componentgroups.CommonFunctions;
import pages.HomePageObjects;
import pages.LoginPageObjects;
import pages.ProductDetailsPageObjects;
import pages.ShoppingCartPageObjects;


public class ProductDetailsPageComponents extends ReusableLibrary {

	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 *                     {@link DriverScript}
	 */
	public ProductDetailsPageComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	CommonFunctions commonFunction = new CommonFunctions(scriptHelper);
	LocalTime liveTime = LocalTime.now(ZoneId.of("America/New_York"));
	WebDriverUtil webdriverutil = new WebDriverUtil(driver);

	
	private WebElement getPageElement(ProductDetailsPageObjects pageEnum) {
		WebElement element;
		try {
			element = commonFunction.getElementByProperty(pageEnum.getProperty(), pageEnum.getLocatorType().toString(),
					true);
			if (element != null) {
				System.out.println("Found the element: " + pageEnum.getObjectname());
				return element;
			} else {
				System.out.println("Element Not Found: " + pageEnum.getObjectname());
				return null;
			}
		} catch (Exception e) {
			report.updateTestLog("Home Page - get page element",
					pageEnum.toString() + " object is not defined or found.", Status.FAIL);
			return null;
		}
	}
	
	private WebElement getPageElement(ShoppingCartPageObjects pageEnum) {
		WebElement element;
		try {
			element = commonFunction.getElementByProperty(pageEnum.getProperty(), pageEnum.getLocatorType().toString(),
					true);
			if (element != null) {
				System.out.println("Found the element: " + pageEnum.getObjectname());
				return element;
			} else {
				System.out.println("Element Not Found: " + pageEnum.getObjectname());
				return null;
			}
		} catch (Exception e) {
			report.updateTestLog("Home Page - get page element",
					pageEnum.toString() + " object is not defined or found.", Status.FAIL);
			return null;
		}
	}
	
	private WebElement getPageElement(LoginPageObjects pageEnum) {
		WebElement element;
		try {
			element = commonFunction.getElementByProperty(pageEnum.getProperty(), pageEnum.getLocatorType().toString(),
					true);
			if (element != null) {
				System.out.println("Found the element: " + pageEnum.getObjectname());
				return element;
			} else {
				System.out.println("Element Not Found: " + pageEnum.getObjectname());
				return null;
			}
		} catch (Exception e) {
			report.updateTestLog("Home Page - get page element",
					pageEnum.toString() + " object is not defined or found.", Status.FAIL);
			return null;
		}
	}
	
	public void validateSimpleProduct() {
		try {
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productMainImage), ProductDetailsPageObjects.productMainImage.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productMainName), ProductDetailsPageObjects.productMainName.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productMainStarRating), ProductDetailsPageObjects.productMainStarRating.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productRatingInNumber), ProductDetailsPageObjects.productRatingInNumber.getObjectname());
			//commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.ProductReviewCountlink), ProductDetailsPageObjects.ProductReviewCountlink.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.writeAReviewLink), ProductDetailsPageObjects.writeAReviewLink.getObjectname());
			//commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.titleQAndA), ProductDetailsPageObjects.titleQAndA.getObjectname());
			//commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.divQuestionAnsweredCount), ProductDetailsPageObjects.divQuestionAnsweredCount.getObjectname());
			//commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.answeredQuestionLink), ProductDetailsPageObjects.answeredQuestionLink.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.askAQuestionLink), ProductDetailsPageObjects.askAQuestionLink.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.viewStoreLocationlink), ProductDetailsPageObjects.viewStoreLocationlink.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productPrice), ProductDetailsPageObjects.productPrice.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productDescription), ProductDetailsPageObjects.productDescription.getObjectname());
			//commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productModels), ProductDetailsPageObjects.productModels.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.quantitylabel), ProductDetailsPageObjects.quantitylabel.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.quantityDecrementor), ProductDetailsPageObjects.quantityDecrementor.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productQuantity), ProductDetailsPageObjects.productQuantity.getObjectname());
			
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.quantityIncrementor), ProductDetailsPageObjects.quantityIncrementor.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnAddToCart), ProductDetailsPageObjects.btnAddToCart.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lnkWishList), ProductDetailsPageObjects.lnkWishList.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lnkCompare), ProductDetailsPageObjects.lnkCompare.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.facebookIcon), ProductDetailsPageObjects.facebookIcon.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.twitterIcon), ProductDetailsPageObjects.twitterIcon.getObjectname());
			
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.sendMailIcon), ProductDetailsPageObjects.sendMailIcon.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lnkReturnPolicy), ProductDetailsPageObjects.lnkReturnPolicy.getObjectname());
			
		}catch(Exception e) {
			report.updateTestLog("Validate Simple Product", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	
	public void validateSimpleProduct_STG() {
		try {
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productMainImage), ProductDetailsPageObjects.productMainImage.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productMainName), ProductDetailsPageObjects.productMainName.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productMainStarRating), ProductDetailsPageObjects.productMainStarRating.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productRatingInNumber), ProductDetailsPageObjects.productRatingInNumber.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.ProductReviewCountlink), ProductDetailsPageObjects.ProductReviewCountlink.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.writeAReviewLink), ProductDetailsPageObjects.writeAReviewLink.getObjectname());
			
			
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.viewStoreLocationlink), ProductDetailsPageObjects.viewStoreLocationlink.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productPrice), ProductDetailsPageObjects.productPrice.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productDescriptionSTG), ProductDetailsPageObjects.productDescriptionSTG.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productModels), ProductDetailsPageObjects.productModels.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.quantitylabel), ProductDetailsPageObjects.quantitylabel.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.quantityDecrementor), ProductDetailsPageObjects.quantityDecrementor.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productQuantity), ProductDetailsPageObjects.productQuantity.getObjectname());
			
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.quantityIncrementor), ProductDetailsPageObjects.quantityIncrementor.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnAddToCart), ProductDetailsPageObjects.btnAddToCart.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lnkWishList), ProductDetailsPageObjects.lnkWishList.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lnkCompare), ProductDetailsPageObjects.lnkCompare.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.facebookIcon), ProductDetailsPageObjects.facebookIcon.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.twitterIcon), ProductDetailsPageObjects.twitterIcon.getObjectname());
			
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.sendMailIcon), ProductDetailsPageObjects.sendMailIcon.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lnkReturnPolicy), ProductDetailsPageObjects.lnkReturnPolicy.getObjectname());
			
		}catch(Exception e) {
			report.updateTestLog("Validate Simple Product", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	
	
	
	public void validateGroupedProduct() {
		try {
			//commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productMainImage), ProductDetailsPageObjects.productMainImage.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productMainName), ProductDetailsPageObjects.productMainName.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productMainImage), ProductDetailsPageObjects.productMainImage.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productMainStarRating), ProductDetailsPageObjects.productMainStarRating.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productRatingInNumber), ProductDetailsPageObjects.productRatingInNumber.getObjectname());
			//commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.ProductReviewCountlink), ProductDetailsPageObjects.ProductReviewCountlink.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.writeAReviewLink), ProductDetailsPageObjects.writeAReviewLink.getObjectname());
			//commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.titleQAndA), ProductDetailsPageObjects.titleQAndA.getObjectname());
			//commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.divQuestionAnsweredCount), ProductDetailsPageObjects.divQuestionAnsweredCount.getObjectname());
			//commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.answeredQuestionLink), ProductDetailsPageObjects.answeredQuestionLink.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.askAQuestionLink), ProductDetailsPageObjects.askAQuestionLink.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.viewStoreLocationlink), ProductDetailsPageObjects.viewStoreLocationlink.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productPrice), ProductDetailsPageObjects.productPrice.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productDescription), ProductDetailsPageObjects.productDescription.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productModels), ProductDetailsPageObjects.productModels.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.quantitylabel), ProductDetailsPageObjects.quantitylabel.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.quantityDecrementor), ProductDetailsPageObjects.quantityDecrementor.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productQuantity), ProductDetailsPageObjects.productQuantity.getObjectname());
			List<WebElement> productModels = commonFunction.getElementsByProperty(ProductDetailsPageObjects.productModels.getProperty(), ProductDetailsPageObjects.productModels.getLocatorType().toString());
			int i=1;
			for(WebElement model : productModels) {
				commonFunction.verifyIfElementIsPresent(model, "Model #"+i);
				i++;
			}
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.quantityIncrementor), ProductDetailsPageObjects.quantityIncrementor.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnAddToCart), ProductDetailsPageObjects.btnAddToCart.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lnkWishList), ProductDetailsPageObjects.lnkWishList.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lnkCompare), ProductDetailsPageObjects.lnkCompare.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.facebookIcon), ProductDetailsPageObjects.facebookIcon.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.twitterIcon), ProductDetailsPageObjects.twitterIcon.getObjectname());
			
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.sendMailIcon), ProductDetailsPageObjects.sendMailIcon.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lnkReturnPolicy), ProductDetailsPageObjects.lnkReturnPolicy.getObjectname());
			
		}catch(Exception e) {
			report.updateTestLog("Validate Grouped Product", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	public void validateGroupedProduct_STG() {
		try {
			//commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productMainImage), ProductDetailsPageObjects.productMainImage.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productMainName), ProductDetailsPageObjects.productMainName.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productMainImage), ProductDetailsPageObjects.productMainImage.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productMainStarRating), ProductDetailsPageObjects.productMainStarRating.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productRatingInNumber), ProductDetailsPageObjects.productRatingInNumber.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.ProductReviewCountlink), ProductDetailsPageObjects.ProductReviewCountlink.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.writeAReviewLink), ProductDetailsPageObjects.writeAReviewLink.getObjectname());
			
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.askAQuestionLink), ProductDetailsPageObjects.askAQuestionLink.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.viewStoreLocationlink), ProductDetailsPageObjects.viewStoreLocationlink.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productPrice), ProductDetailsPageObjects.productPrice.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productDescription), ProductDetailsPageObjects.productDescription.getObjectname());
			//commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productModels), ProductDetailsPageObjects.productModels.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.quantitylabel), ProductDetailsPageObjects.quantitylabel.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.quantityDecrementor), ProductDetailsPageObjects.quantityDecrementor.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productQuantity), ProductDetailsPageObjects.productQuantity.getObjectname());
			List<WebElement> productModels = commonFunction.getElementsByProperty(ProductDetailsPageObjects.productModels.getProperty(), ProductDetailsPageObjects.productModels.getLocatorType().toString());
			int i=1;
			for(WebElement model : productModels) {
				commonFunction.verifyIfElementIsPresent(model, "Model #"+i);
				i++;
			}
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.quantityIncrementor), ProductDetailsPageObjects.quantityIncrementor.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnAddToCart), ProductDetailsPageObjects.btnAddToCart.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lnkWishList), ProductDetailsPageObjects.lnkWishList.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lnkCompare), ProductDetailsPageObjects.lnkCompare.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.facebookIcon), ProductDetailsPageObjects.facebookIcon.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.twitterIcon), ProductDetailsPageObjects.twitterIcon.getObjectname());
			
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.sendMailIcon), ProductDetailsPageObjects.sendMailIcon.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lnkReturnPolicy), ProductDetailsPageObjects.lnkReturnPolicy.getObjectname());
			
		}catch(Exception e) {
			report.updateTestLog("Validate Grouped Product", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	public void addProductToWishListFromProductDetailsPage() {
		try {
			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.lnkWishList), ProductDetailsPageObjects.lnkWishList.getObjectname());
			if(commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.msgProductAddedtoWishList), ProductDetailsPageObjects.msgProductAddedtoWishList.getObjectname())) {
				report.updateTestLog("Verify Product Added to wish list",
						"Product is successfully added to wish list", Status.PASS);
			} else {
				report.updateTestLog("Verify Product Added to wish list",
						"Product is NOT added to wish list", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Add Product To Wish list", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	
	public void addProductToCompareFromProductDetailsPage() {
		try {
			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.lnkCompare), ProductDetailsPageObjects.lnkCompare.getObjectname());
			Thread.sleep(4000);
			if(commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.msgProductAddedtoCompare), ProductDetailsPageObjects.msgProductAddedtoWishList.getObjectname())) {
				report.updateTestLog("Verify Product Added to Compare",
						"Product is successfully added to Compare", Status.PASS);
			} else {
				report.updateTestLog("Verify Product Added to Compare",
						"Product is NOT added to Compare", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Add Product To Compare", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	public void addProductToCart() {
		try {
			Thread.sleep(10000);
			//driver.findElement(By.xpath("//*[@id='product-addtocart-button']")).click();
			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.btnAddToCart), ProductDetailsPageObjects.btnAddToCart.getObjectname());
			Thread.sleep(8000);
			//driver.switchTo().activeElement().sendKeys(Keys.HOME);
			
			if(!driver.getTestParameters().getBrowser().getValue().contains("IE")) {
			if(commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartCounterqty), ProductDetailsPageObjects.miniCartCounterqty.getObjectname())) {
				report.updateTestLog("Verify Product Added to the cart",
						"Product is successfully added to the cart", Status.PASS);
			} else {
				report.updateTestLog("Verify Product Added to cart",
						"Product is NOT added to cart", Status.FAIL);
			}
			}
		}catch(Exception e) {
			report.updateTestLog("Add Product To Cart", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	public void validateShoppingCartOverlayAndNavigateToShoppingCart() {
		try {
			//commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.miniCartIcon), ProductDetailsPageObjects.miniCartIcon.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartItemCountMsg), ProductDetailsPageObjects.miniCartItemCountMsg.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartProductName), ProductDetailsPageObjects.miniCartProductName.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartProductImage), ProductDetailsPageObjects.miniCartProductImage.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartLabelQuantity), ProductDetailsPageObjects.miniCartLabelQuantity.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartQuanitityTextBox), ProductDetailsPageObjects.miniCartQuanitityTextBox.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.MiniCartProductPrice), ProductDetailsPageObjects.MiniCartProductPrice.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartLblCartSubTotal), ProductDetailsPageObjects.miniCartLblCartSubTotal.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartCartPrice), ProductDetailsPageObjects.miniCartCartPrice.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartbtnGoToCart), ProductDetailsPageObjects.miniCartbtnGoToCart.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.miniCartbtnGoToCart), ProductDetailsPageObjects.miniCartbtnGoToCart.getObjectname());
			if(commonFunction.isElementPresentContainsText(getPageElement(ShoppingCartPageObjects.titleShoppingCart), ShoppingCartPageObjects.titleShoppingCart.getObjectname(), "Shopping Cart")) {
				report.updateTestLog("Verify user navigated to Shopping Cart",
						"User Successfully navigated to Shopping Cart Page", Status.PASS);
			} else {
				report.updateTestLog("Verify user navigated to Shopping Cart",
						"User NOT navigated to Shopping Cart Page", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Validate Shopping Cart and Navigate to Shopping Cart", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	public void validateProductQuanityFunctionality() {
		try {
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.quantityDecrementor), ProductDetailsPageObjects.quantityDecrementor.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productQuantity), ProductDetailsPageObjects.productQuantity.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.quantityIncrementor), ProductDetailsPageObjects.quantityIncrementor.getObjectname());
			
			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.quantityIncrementor), ProductDetailsPageObjects.quantityIncrementor.getObjectname());
			
			if(commonFunction.isElementPresentContainsText(getPageElement(ProductDetailsPageObjects.productQuantity), ProductDetailsPageObjects.productQuantity.getObjectname(), "2")) {
				report.updateTestLog("Verify Product Quanity Incrementor",
						"Product Quanity Incrementor is working fine", Status.PASS);
			} else {
				report.updateTestLog("Verify Product Quantity Incrementor",
						"Product Quantity Incrementor is NOT Working Fine", Status.FAIL);
			}
			
			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.quantityDecrementor), ProductDetailsPageObjects.quantityDecrementor.getObjectname());
			if(commonFunction.isElementPresentContainsText(getPageElement(ProductDetailsPageObjects.productQuantity), ProductDetailsPageObjects.productQuantity.getObjectname(), "1")) {
				report.updateTestLog("Verify Product Quanity Decrementor",
						"Product Quanity Decrementor is working fine", Status.PASS);
			} else {
				report.updateTestLog("Verify Product Quantity Decrementor",
						"Product Quantity Decrementor is NOT Working Fine", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Validate Product Quantity Incrementor and Decrementor", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	public void navigateToAskAQuestionPage() {
		try {
			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.askAQuestionLink), ProductDetailsPageObjects.askAQuestionLink.getObjectname());
			if(commonFunction.isElementPresentContainsText(getPageElement(ProductDetailsPageObjects.lblAskAQuestion), ProductDetailsPageObjects.lblAskAQuestion.getObjectname(), "Ask a question")) {
				report.updateTestLog("Verify User navigated to Ask A Question Page",
						"User is successfully navigated to Ask A Question Page", Status.PASS);
			} else {
				report.updateTestLog("Verify user is navigated to Ask A Question Page",
						"User is NOT navigated to Ask A Question Page", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Navigate to Ask A Question Page", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	public void validateAskAQuestionPage() {
		try {
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblAskAQuestion), ProductDetailsPageObjects.lblAskAQuestion.getObjectname());
			
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productImage), ProductDetailsPageObjects.productImage.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productNameLink), ProductDetailsPageObjects.productNameLink.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblTypeOfQuestion), ProductDetailsPageObjects.lblTypeOfQuestion.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnTheSeviceQuestionType), ProductDetailsPageObjects.btnTheSeviceQuestionType.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnTheProductQuestionType), ProductDetailsPageObjects.btnTheProductQuestionType.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblQuestion), ProductDetailsPageObjects.lblQuestion.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.txtAreaQuestion), ProductDetailsPageObjects.txtAreaQuestion.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.labelEmail), ProductDetailsPageObjects.labelEmail.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.msgBelowEmailLabel), ProductDetailsPageObjects.msgBelowEmailLabel.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.txtBoxEmail), ProductDetailsPageObjects.txtBoxEmail.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.labelNickName), ProductDetailsPageObjects.labelNickName.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.txtBoxNickName), ProductDetailsPageObjects.txtBoxNickName.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.labelYourLocation), ProductDetailsPageObjects.labelYourLocation.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.txtBoxYourLocation), ProductDetailsPageObjects.txtBoxYourLocation.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.msgLegalTermsConditions), ProductDetailsPageObjects.msgLegalTermsConditions.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnSubmit), ProductDetailsPageObjects.btnSubmit.getObjectname());
		}catch(Exception e) {
			report.updateTestLog("Validate Ask A Question Page", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	public void navigateToWriteAReviewPage() {
		try {
			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.writeAReviewLink), ProductDetailsPageObjects.writeAReviewLink.getObjectname());
			Thread.sleep(5000);
			if(commonFunction.isElementPresentContainsText(getPageElement(ProductDetailsPageObjects.titleWriteAReview), ProductDetailsPageObjects.titleWriteAReview.getObjectname(), "Write a Review")) {
				report.updateTestLog("Verify User navigated to Write A Review Page",
						"User is successfully navigated to Write A Review Page", Status.PASS);
			} else {
				report.updateTestLog("Verify user is navigated to Write A Review Page",
						"User is NOT navigated to Write A Review Page", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Navigate to Write A Review Page", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	public void validateWriteAReviewPage() {
		try {
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.titleWriteAReview), ProductDetailsPageObjects.titleWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.productImageWriteAReivewPage), ProductDetailsPageObjects.productImageWriteAReivewPage.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblOverallRating), ProductDetailsPageObjects.lblOverallRating.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.overallRatinWriteAReview), ProductDetailsPageObjects.overallRatinWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblReviewTitle), ProductDetailsPageObjects.lblReviewTitle.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.txtBoxReviewTitle), ProductDetailsPageObjects.txtBoxReviewTitle.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblReview), ProductDetailsPageObjects.lblReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.txtBoxReview), ProductDetailsPageObjects.txtBoxReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.labelWouldYouRecomndToFrnd), ProductDetailsPageObjects.labelWouldYouRecomndToFrnd.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnYesRecomndToFrnd), ProductDetailsPageObjects.btnYesRecomndToFrnd.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnNoRecomndToFrnd), ProductDetailsPageObjects.titleWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblNickNameWriteAReivew), ProductDetailsPageObjects.lblNickNameWriteAReivew.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.txtBoxNickNameWriteAReview), ProductDetailsPageObjects.txtBoxNickNameWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblLocationWriteAReveiw), ProductDetailsPageObjects.lblLocationWriteAReveiw.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.txtBoxLocationWriteAReview), ProductDetailsPageObjects.txtBoxLocationWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblQualityOfProductWriteAReveiw), ProductDetailsPageObjects.lblQualityOfProductWriteAReveiw.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.ratingQualityOfProductWriteAReview), ProductDetailsPageObjects.ratingQualityOfProductWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblValueOfProductWriteAReview), ProductDetailsPageObjects.lblValueOfProductWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.ratingValueOfProductWriteAReview), ProductDetailsPageObjects.ratingValueOfProductWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblEaseOfUse), ProductDetailsPageObjects.lblEaseOfUse.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.ratingEaseOfUseWriteAReview), ProductDetailsPageObjects.ratingEaseOfUseWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblHowOldAreYouWriteAReveiw), ProductDetailsPageObjects.lblHowOldAreYouWriteAReveiw.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.drpDownHowOldAreYou), ProductDetailsPageObjects.drpDownHowOldAreYou.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblWhatIsYourGenderWriteAReveiw), ProductDetailsPageObjects.lblWhatIsYourGenderWriteAReveiw.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.drpDownWhatIsYourGenderWriteAReivew), ProductDetailsPageObjects.drpDownWhatIsYourGenderWriteAReivew.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblLevelOfFishingExpertise), ProductDetailsPageObjects.lblLevelOfFishingExpertise.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.drpDownLevelOfFishingExpertiseWriteAReview), ProductDetailsPageObjects.drpDownLevelOfFishingExpertiseWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblWhichTypeFishRecomndCatching), ProductDetailsPageObjects.lblWhichTypeFishRecomndCatching.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.listFishNames), ProductDetailsPageObjects.listFishNames.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnAddYourOwnWriteARview), ProductDetailsPageObjects.btnAddYourOwnWriteARview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblDoYouReadProducReviewsWriteAReview), ProductDetailsPageObjects.lblDoYouReadProducReviewsWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.drpDownDoYouReadProductReviewWriteAReview), ProductDetailsPageObjects.drpDownDoYouReadProductReviewWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblWouldYouRecomndZebcoProductToFrndWriteAReveiw), ProductDetailsPageObjects.lblWouldYouRecomndZebcoProductToFrndWriteAReveiw.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.scale1To10WoudYouRecomndZebcoProductToFrndWriteAReview), ProductDetailsPageObjects.scale1To10WoudYouRecomndZebcoProductToFrndWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblAddAnImageWriteAReview), ProductDetailsPageObjects.lblAddAnImageWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnAddAnImageWriteAReview), ProductDetailsPageObjects.btnAddAnImageWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblAddAVideoWriteAReview), ProductDetailsPageObjects.lblAddAVideoWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnAddaVideoWriteAReview), ProductDetailsPageObjects.btnAddaVideoWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.lblEmailWriteAReview), ProductDetailsPageObjects.lblEmailWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.txtBoxEmailWriteAReview), ProductDetailsPageObjects.txtBoxEmailWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.chckBoxAgreeTermsWriteAReview), ProductDetailsPageObjects.chckBoxAgreeTermsWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.chckDescpAgreeTermsWriteAReview), ProductDetailsPageObjects.chckDescpAgreeTermsWriteAReview.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.msgAgreeToTermsConditionWriteAReivew), ProductDetailsPageObjects.msgAgreeToTermsConditionWriteAReivew.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnSubmitReview), ProductDetailsPageObjects.btnSubmitReview.getObjectname());

		}catch(Exception e) {
			report.updateTestLog("Validate Write a Review Page", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	public void shareFacebookValidation() {
		try {
			String mainWindow = "";

			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.facebookIcon),
					HomePageObjects.facebookIcon.getObjectname());
			mainWindow = driver.getWindowHandle();
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("https://www.facebook.com/login.php")) {
					report.updateTestLog("Product Details Page - Share Section - Facebook Icon", "Navigated to facebook link - " + driver.getCurrentUrl(),
							Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Product Details Page - Share Section - Facebook Icon", "Not navigated to facebook link.", Status.FAIL);
				else {
					report.updateTestLog("Product Details Page - Share Section - Facebook Icon",
							"Not navigated to Facebook link in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
				}
			}
			driver.close();
			driver.switchTo().window(mainWindow);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in navigating to facebook page", "Exception is " + e.getMessage(),
					Status.FAIL);
		}
	}

	public void shareTwitterValidation() {
		try {
			String mainWindow = "";

			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.twitterIcon),
					HomePageObjects.twitterIcon.getObjectname());
			mainWindow = driver.getWindowHandle();
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("https://twitter.com/intent/tweet")) {
					report.updateTestLog("Product Details Page - Share Section - twitter Icon", "Navigated to Twitter link - " + driver.getCurrentUrl(),
							Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Product Details Page - Share Section - twitter Icon", "Not navigated to Twitter link.", Status.FAIL);
				else {
					report.updateTestLog("Product Details Page - Share Section - twitter Icon",
							"Not navigated to Twitter link in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
				}
			}
			driver.close();
			driver.switchTo().window(mainWindow);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in navigating to Twitter page", "Exception is " + e.getMessage(),
					Status.FAIL);
		}
	}

	
	public void valdiateShareLinks() {
		try {
			shareFacebookValidation();
			shareTwitterValidation();
			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.sendMailIcon),
					ProductDetailsPageObjects.sendMailIcon.getObjectname());
			if(commonFunction.isElementPresentContainsText(getPageElement(LoginPageObjects.titleCustomerLogin), LoginPageObjects.titleCustomerLogin.getObjectname(), "Customer Login")) {
				report.updateTestLog("Verify user navigated to the Login Page",
						"User Successfully navigated to Login Page", Status.PASS);
			} else {
				report.updateTestLog("Verify user navigated to Login Page",
						"User NOT navigated to Login Page", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Validate Share Links", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	public void validateReturnPolicy() {
		try {
			String mainWindow = "";
			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.lnkReturnPolicy),
					ProductDetailsPageObjects.lnkReturnPolicy.getObjectname());
			mainWindow = driver.getWindowHandle();
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
			
			for (int count = 1; count <= 5; count++) {
				if(commonFunction.isElementPresentContainsText(getPageElement(ProductDetailsPageObjects.titleReturnPolicy), ProductDetailsPageObjects.titleReturnPolicy.getObjectname(), "Returns & Exchanges")) {
					report.updateTestLog("Verify user navigated to the Return Policy Page",
							"User Successfully navigated to Return Policy Page", Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Verify user navigated to Return Policy Page",
							"User NOT navigated to Return Policy Page", Status.FAIL);
				else {
					report.updateTestLog("Product Details Page Returns & Exchanges - Return Policy Link",
							"Not navigated to Return Policy Page in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
				}
			}
			driver.close();
			driver.switchTo().window(mainWindow);
			
		}catch(Exception e) {
			report.updateTestLog("Validate Return Policy", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	public void validateMiniCart() {
		try {
			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.iconMiniCart),
					ProductDetailsPageObjects.iconMiniCart.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartItemCountMsg), ProductDetailsPageObjects.miniCartItemCountMsg.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartProductName), ProductDetailsPageObjects.miniCartProductName.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartProductImage), ProductDetailsPageObjects.miniCartProductImage.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartLabelQuantity), ProductDetailsPageObjects.miniCartLabelQuantity.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartQuanitityTextBox), ProductDetailsPageObjects.miniCartQuanitityTextBox.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.MiniCartProductPrice), ProductDetailsPageObjects.MiniCartProductPrice.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartLblCartSubTotal), ProductDetailsPageObjects.miniCartLblCartSubTotal.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartCartPrice), ProductDetailsPageObjects.miniCartCartPrice.getObjectname());
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.miniCartbtnGoToCart), ProductDetailsPageObjects.miniCartbtnGoToCart.getObjectname());
		
		}catch(Exception e) {
			report.updateTestLog("Validate Mini Cart Overlay", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	public void navigateToShoppingCartPage() {
		try {
			if (driver.findElement(By.xpath("//a[@class='action viewcart']")).isDisplayed()) {
				commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.miniCartbtnGoToCart), ProductDetailsPageObjects.miniCartbtnGoToCart.getObjectname());
			}
			else {
			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.miniCartIcon), ProductDetailsPageObjects.miniCartIcon.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.miniCartbtnGoToCart), ProductDetailsPageObjects.miniCartbtnGoToCart.getObjectname());
			}
			if(commonFunction.isElementPresentContainsText(getPageElement(ShoppingCartPageObjects.titleShoppingCart), ShoppingCartPageObjects.titleShoppingCart.getObjectname(), "Shopping Cart")) {
				report.updateTestLog("Verify user navigated to Shopping Cart",
						"User Successfully navigated to Shopping Cart Page", Status.PASS);
			} else {
				report.updateTestLog("Verify user navigated to Shopping Cart",
						"User NOT navigated to Shopping Cart Page", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Navigate To Shopping Cart Page", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	public void navigateToShoppingCartPageForSecondProduct() {
		try {
			commonFunction.clickIfElementPresent(getPageElement(ProductDetailsPageObjects.miniCartbtnGoToCart), ProductDetailsPageObjects.miniCartbtnGoToCart.getObjectname());
			if(commonFunction.isElementPresentContainsText(getPageElement(ShoppingCartPageObjects.titleShoppingCart), ShoppingCartPageObjects.titleShoppingCart.getObjectname(), "Shopping Cart")) {
				report.updateTestLog("Verify user navigated to Shopping Cart",
						"User Successfully navigated to Shopping Cart Page", Status.PASS);
			} else {
				report.updateTestLog("Verify user navigated to Shopping Cart",
						"User NOT navigated to Shopping Cart Page", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Navigate To Shopping Cart Page", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
}
