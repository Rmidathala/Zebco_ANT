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
import pages.ProductDetailsPageObjects;
import pages.ProductListingPageObjects;

public class ProductListingPageComponents extends ReusableLibrary {

	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper The {@link ScriptHelper} object passed from the
	 *                     {@link DriverScript}
	 */
	public ProductListingPageComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	CommonFunctions commonFunction = new CommonFunctions(scriptHelper);
	LocalTime liveTime = LocalTime.now(ZoneId.of("America/New_York"));
	WebDriverUtil webdriverutil = new WebDriverUtil(driver);

	private WebElement getPageElement(ProductListingPageObjects pageEnum) {
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

	public void applyFilterCombosPage() {
		try {
			List<WebElement> categoryFilter = commonFunction.getElementsByProperty(
					ProductListingPageObjects.nowShopppingByCategories.getProperty(),
					ProductListingPageObjects.nowShopppingByCategories.getLocatorType().toString());
			commonFunction.clickIfElementPresent(getPageElement(ProductListingPageObjects.combosCategoryFilterSpincast),
					ProductListingPageObjects.combosCategoryFilterSpincast.getObjectname());
			commonFunction.mouseOver(getPageElement(ProductListingPageObjects.lblShoppingOptions),ProductListingPageObjects.lblShoppingOptions.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(ProductListingPageObjects.combosPriceFilter0_24),
					ProductListingPageObjects.combosPriceFilter0_24.getObjectname());
			for (int i = 0; i < categoryFilter.size(); i++) {
				if (commonFunction.verifyIfElementIsPresent(categoryFilter.get(i),
						"Product Filter :" + categoryFilter.get(i).getText())) {
					report.updateTestLog("Verify Category Filter is working fine",
							"Filter on Product Listing Page is working fine", Status.PASS);
				} else {
					report.updateTestLog("Verify Category Filter is working fine",
							"Filter on Product Listing Page is NOT working fine", Status.FAIL);
				}

			}
		} catch (Exception e) {
			report.updateTestLog("Apply Filter on Combos Page", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}

	public void sortProductListing() {
		try {
			String sortBy = dataTable.getData("General_Data", "SortBy");
			commonFunction.clickIfElementPresent(getPageElement(ProductListingPageObjects.arrowArrowDecendingSort),
					ProductListingPageObjects.arrowArrowDecendingSort.getObjectname());
			commonFunction.selectAnyElementByValue(getPageElement(ProductListingPageObjects.drpDownSortBy), sortBy,
					ProductListingPageObjects.drpDownSortBy.getObjectname());
			// commonFunction.scrollIntoView(getPageElement(ProductListingPageObjects.descRodAndReelCombos));

		} catch (Exception e) {
			report.updateTestLog("Sort Combos Page", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}

	public void validateProductInProductListingPage() {
		try {
			List<WebElement> products = commonFunction.getElementsByProperty(
					ProductListingPageObjects.products.getProperty(),
					ProductListingPageObjects.products.getLocatorType().toString());
			List<WebElement> productImages = commonFunction.getElementsByProperty(
					ProductListingPageObjects.productImage.getProperty(),
					ProductListingPageObjects.productImage.getLocatorType().toString());
			List<WebElement> productItemLinks = commonFunction.getElementsByProperty(
					ProductListingPageObjects.productItemLink.getProperty(),
					ProductListingPageObjects.productItemLink.getLocatorType().toString());
			List<WebElement> productPrices = commonFunction.getElementsByProperty(
					ProductListingPageObjects.productPrice.getProperty(),
					ProductListingPageObjects.productPrice.getLocatorType().toString());
			List<WebElement> productRatings = commonFunction.getElementsByProperty(
					ProductListingPageObjects.productRatings.getProperty(),
					ProductListingPageObjects.productRatings.getLocatorType().toString());
			List<WebElement> productViewDetails =commonFunction.getElementsByProperty(
					ProductListingPageObjects.btnproductViewDetails.getProperty(),
					ProductListingPageObjects.btnproductViewDetails.getLocatorType().toString());;
			for (int i = 0; i < products.size(); i++) {
				commonFunction.verifyIfElementIsPresent(products.get(i), "Product#: " + i);
				commonFunction.verifyIfElementIsPresent(productImages.get(i), "Product Image#: " + i);
				commonFunction.verifyIfElementIsPresent(productItemLinks.get(i), "Product Item Link#: " + i);
				commonFunction.verifyIfElementIsPresent(productPrices.get(i), "Product Price of Product#: " + i);
				commonFunction.verifyIfElementIsPresent(productRatings.get(i), "Product Rating of Product#: " + i);
				commonFunction.scrollIntoView(products.get(i));
				commonFunction.mouseOver(products.get(i), "Product#: " + i);
				Thread.sleep(1000);
				commonFunction.verifyIfElementIsPresent(productViewDetails.get(i),
						"Product - View Details of Product#: " + i);
			}
			commonFunction.clickIfElementPresent(getPageElement(ProductListingPageObjects.btnShowAllCombos),
					ProductListingPageObjects.btnShowAllCombos.getObjectname());
			Thread.sleep(3000);
			List<WebElement> productsAfterShowAll = commonFunction.getElementsByProperty(
					ProductListingPageObjects.products.getProperty(),
					ProductListingPageObjects.products.getLocatorType().toString());
			if (products.size() < productsAfterShowAll.size()) {
				report.updateTestLog("Verify Show All Combos button on Product Listing Page",
						"Show All Button on Product Listing Page is working fine", Status.PASS);
			} else {
				report.updateTestLog("Verify Show All Combos button on Product Listing Page",
						"Show All Combos Button on the Product Listing Page is not Working", Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Validate Product Listing Page", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}

	public void validateProductInProductListingPageSTG() {
		try {
			List<WebElement> products = commonFunction.getElementsByProperty(
					ProductListingPageObjects.products.getProperty(),
					ProductListingPageObjects.products.getLocatorType().toString());
			List<WebElement> productImages = commonFunction.getElementsByProperty(
					ProductListingPageObjects.productImage.getProperty(),
					ProductListingPageObjects.productImage.getLocatorType().toString());
			List<WebElement> productItemLinks = commonFunction.getElementsByProperty(
					ProductListingPageObjects.productItemLink.getProperty(),
					ProductListingPageObjects.productItemLink.getLocatorType().toString());
			List<WebElement> productPrices = commonFunction.getElementsByProperty(
					ProductListingPageObjects.productPrice.getProperty(),
					ProductListingPageObjects.productPrice.getLocatorType().toString());
			List<WebElement> productRatings = commonFunction.getElementsByProperty(
					ProductListingPageObjects.productRatings.getProperty(),
					ProductListingPageObjects.productRatings.getLocatorType().toString());
			List<WebElement> productViewDetails=commonFunction.getElementsByProperty(
					ProductListingPageObjects.btnproductViewDetailsSTG.getProperty(),
					ProductListingPageObjects.btnproductViewDetailsSTG.getLocatorType().toString());
			System.out.println(productViewDetails.size());
			for (int i = 0; i < products.size()-5; i++) {
				commonFunction.verifyIfElementIsPresent(products.get(i), "Product#: " + i);
				commonFunction.verifyIfElementIsPresent(productImages.get(i), "Product Image#: " + i);
				commonFunction.verifyIfElementIsPresent(productItemLinks.get(i), "Product Item Link#: " + i);
				commonFunction.verifyIfElementIsPresent(productPrices.get(i), "Product Price of Product#: " + i);
				commonFunction.verifyIfElementIsPresent(productRatings.get(i), "Product Rating of Product#: " + i);
				commonFunction.scrollIntoView(products.get(i));
				commonFunction.mouseOver(products.get(i), "Product#: " + i);
				commonFunction.verifyIfElementIsPresent(productViewDetails.get(i),
						"Product - View Details of Product#: " + i);
			}
			commonFunction.clickIfElementPresent(getPageElement(ProductListingPageObjects.btnShowAllCombos),
					ProductListingPageObjects.btnShowAllCombos.getObjectname());
			Thread.sleep(3000);
			List<WebElement> productsAfterShowAll = commonFunction.getElementsByProperty(
					ProductListingPageObjects.products.getProperty(),
					ProductListingPageObjects.products.getLocatorType().toString());
			if (products.size() < productsAfterShowAll.size()) {
				report.updateTestLog("Verify Show All Combos button on Product Listing Page",
						"Show All Button on Product Listing Page is working fine", Status.PASS);
			} else {
				report.updateTestLog("Verify Show All Combos button on Product Listing Page",
						"Show All Combos Button on the Product Listing Page is not Working", Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Validate Product Listing Page", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	
	public void navigateToGroupedProduct() {
		try {
			
			commonFunction.scrollIntoView(getPageElement(ProductListingPageObjects.card1ProductName));
			commonFunction.mouseOver(getPageElement(ProductListingPageObjects.card1ProductName),ProductListingPageObjects.card1ProductName.getObjectname() );
			commonFunction.clickIfElementPresent(getPageElement(ProductListingPageObjects.Card1ShopNowBtn), ProductListingPageObjects.Card1ShopNowBtn.getObjectname());
			if (commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnAddToCart),
					ProductDetailsPageObjects.btnAddToCart.getObjectname())) {
				report.updateTestLog("Verify Navigation to Grouped Product Details Page",
						"User is successfully Navigated to  Grouped Product Details Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Navigation to Grouped Product Details Page",
						"User is NOT Navigated to Grouped Product Details Page", Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Navigate to Grouped Product Listing page", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void navigateToGroupedProduct_STG() {
		try {
			
			//commonFunction.scrollIntoView(getPageElement(ProductListingPageObjects.card1ProductName));
			commonFunction.mouseOver(getPageElement(ProductListingPageObjects.card1ProductName),ProductListingPageObjects.card1ProductName.getObjectname() );
			commonFunction.clickIfElementPresent(getPageElement(ProductListingPageObjects.shopBulletBtnSTG), ProductListingPageObjects.shopBulletBtnSTG.getObjectname());
			navigateToFirstProduct();
			
		} catch (Exception e) {
			report.updateTestLog("Navigate to Grouped Product Listing page", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
	
	public void navigateToFirstProduct() {
		try {
			List<WebElement> products = commonFunction.getElementsByProperty(
					ProductListingPageObjects.products.getProperty(),
					ProductListingPageObjects.products.getLocatorType().toString());
			List<WebElement> productViewDetails;
			if(driver.getCurrentUrl().contains("mcstaging")) {
				productViewDetails = commonFunction.getElementsByProperty(
						ProductListingPageObjects.btnproductViewDetailsSTG.getProperty(),
						ProductListingPageObjects.btnproductViewDetailsSTG.getLocatorType().toString());
			}else {
			productViewDetails = commonFunction.getElementsByProperty(
					ProductListingPageObjects.btnproductViewDetails.getProperty(),
					ProductListingPageObjects.btnproductViewDetails.getLocatorType().toString());
			}
			Thread.sleep(5000);
			commonFunction.scrollIntoView(products.get(0));
			commonFunction.mouseOver(products.get(0), "Product#: " + 1);
			commonFunction.clickIfElementPresent(productViewDetails.get(0), "Product - View Details of Product#: " + 1);
			if (commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnAddToCart),
					ProductDetailsPageObjects.btnAddToCart.getObjectname())) {
				report.updateTestLog("Verify Navigation to Product Details Page",
						"User is successfully Navigated to Product Details Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Navigation to Product Details Page",
						"User is NOT Navigated to Product Details Page", Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Navigate to Product Listing page", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}

	public void navigateToSecondProduct() {
		try {
			List<WebElement> products = commonFunction.getElementsByProperty(
					ProductListingPageObjects.products.getProperty(),
					ProductListingPageObjects.products.getLocatorType().toString());
			List<WebElement> productViewDetails;
			if(driver.getCurrentUrl().contains("mcstaging")) {
				productViewDetails = commonFunction.getElementsByProperty(
						ProductListingPageObjects.btnproductViewDetailsSTG.getProperty(),
						ProductListingPageObjects.btnproductViewDetailsSTG.getLocatorType().toString());
			}else {
			productViewDetails = commonFunction.getElementsByProperty(
					ProductListingPageObjects.btnproductViewDetails.getProperty(),
					ProductListingPageObjects.btnproductViewDetails.getLocatorType().toString());
			}
			commonFunction.scrollIntoView(products.get(1));
			commonFunction.mouseOver(products.get(1), "Product#: " + 2);
			commonFunction.clickIfElementPresent(productViewDetails.get(1), "Product - View Details of Product#: " + 2);
			if (commonFunction.verifyIfElementIsPresent(getPageElement(ProductDetailsPageObjects.btnAddToCart),
					ProductDetailsPageObjects.btnAddToCart.getObjectname())) {
				report.updateTestLog("Verify Navigation to Product Details Page",
						"User is successfully Navigated to Product Details Page", Status.PASS);
			} else {
				report.updateTestLog("Verify Navigation to Product Details Page",
						"User is NOT Navigated to Product Details Page", Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Navigate to Product Listing page", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}

	public void validateSortBy() {
		try {
			String sortBy1 = dataTable.getData("General_Data", "SortBy1");
			String sortBy2 = dataTable.getData("General_Data", "SortBy2");
			String sortBy3 = dataTable.getData("General_Data", "SortBy3");
			commonFunction.selectAnyElementByValue(getPageElement(ProductListingPageObjects.drpDownSortBy), sortBy1,
					ProductListingPageObjects.drpDownSortBy.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(ProductListingPageObjects.arrowArrowDecendingSort),
					ProductListingPageObjects.arrowArrowDecendingSort.getObjectname());

			commonFunction.selectAnyElementByValue(getPageElement(ProductListingPageObjects.drpDownSortBy), sortBy2,
					ProductListingPageObjects.drpDownSortBy.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(ProductListingPageObjects.arrowArrowDecendingSort),
					ProductListingPageObjects.arrowArrowDecendingSort.getObjectname());

			commonFunction.selectAnyElementByValue(getPageElement(ProductListingPageObjects.drpDownSortBy), sortBy3,
					ProductListingPageObjects.drpDownSortBy.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(ProductListingPageObjects.arrowArrowDecendingSort),
					ProductListingPageObjects.arrowArrowDecendingSort.getObjectname());
		} catch (Exception e) {
			report.updateTestLog("Product Listing Page - Validate Sort By functionality",
					"Something went wrong!" + e.toString(), Status.FAIL);
		}
	}

	public void addProductToCompareFromProductListingPage() {
		try {
			List<WebElement> products = commonFunction.getElementsByProperty(
					ProductListingPageObjects.products.getProperty(),
					ProductListingPageObjects.products.getLocatorType().toString());
			List<WebElement> compares = commonFunction.getElementsByProperty(
					ProductListingPageObjects.btnProductCompare.getProperty(),
					ProductListingPageObjects.btnProductCompare.getLocatorType().toString());
			for (int i = 0; i < 3; i++) {
				//commonFunction.scrollIntoView(products.get(i));
				commonFunction.mouseOver(products.get(i), "Product#: " + (i + 1));
				commonFunction.mouseOver(compares.get(i), "Product#: " + (i + 1));
				commonFunction.clickIfElementPresent(compares.get(i), "Add Product to Compare Product#: " + (i + 1));
				Thread.sleep(5000);
				if (commonFunction.verifyIfElementIsPresent(
						getPageElement(ProductListingPageObjects.msgProductAddedToCompare),
						ProductListingPageObjects.msgProductAddedToCompare.getObjectname())) {
					report.updateTestLog("Verify Product is added to Compare List",
							"Product is successfully added to Compare List", Status.PASS);
				} else {
					report.updateTestLog("Verify Product is added to Compare List",
							"Product is Not added to Compare List", Status.FAIL);
				}
				products = commonFunction.getElementsByProperty(
						ProductListingPageObjects.products.getProperty(),
						ProductListingPageObjects.products.getLocatorType().toString());
				compares = commonFunction.getElementsByProperty(
						ProductListingPageObjects.btnProductCompare.getProperty(),
						ProductListingPageObjects.btnProductCompare.getLocatorType().toString());
			}
		} catch (Exception e) {
			report.updateTestLog("Product Listing Page - Add product to Compare List",
					"Something went wrong!" + e.toString(), Status.FAIL);
		}
	}

	public void addProductToWishListFromProductListingPage() {
		try {
			List<WebElement> products = commonFunction.getElementsByProperty(
					ProductListingPageObjects.products.getProperty(),
					ProductListingPageObjects.products.getLocatorType().toString());
			List<WebElement> compares = commonFunction.getElementsByProperty(
					ProductListingPageObjects.btnProductCompare.getProperty(),
					ProductListingPageObjects.btnProductCompare.getLocatorType().toString());
			for (int i = 0; i < 4; i++) {
				commonFunction.scrollIntoView(products.get(i));
				commonFunction.mouseOver(products.get(i), "Product#: " + (i + 1));
				commonFunction.clickIfElementPresent(compares.get(i), "Product#: " + (i + 1));
				Thread.sleep(5000);
				if (commonFunction.verifyIfElementIsPresent(
						getPageElement(ProductListingPageObjects.msgProductAddedToCompare),
						ProductListingPageObjects.msgProductAddedToCompare.getObjectname())) {
					report.updateTestLog("Verify Product is added to Compare List",
							"Product is successfully added to Compare List", Status.PASS);
				} else {
					report.updateTestLog("Verify Product is added to Compare List",
							"Product is Not added to Compare List", Status.FAIL);
				}
			}
		} catch (Exception e) {
			report.updateTestLog("Product Listing Page - Add product to Compare List",
					"Something went wrong!" + e.toString(), Status.FAIL);
		}
	}

	public void validateCompareProductsSection() {
		try {
			commonFunction.verifyIfElementIsPresent(getPageElement(ProductListingPageObjects.lblCompareProducts),
					ProductListingPageObjects.lblCompareProducts.getObjectname());
			if (webdriverutil
					.objectExists(By.xpath(ProductListingPageObjects.compareSectionProductCounter.getProperty()))) {
				List<WebElement> products = commonFunction.getElementsByProperty(
						ProductListingPageObjects.productsInCompareSection.getProperty(),
						ProductListingPageObjects.productsInCompareSection.getLocatorType().toString());
				for (int i = 0; i < products.size(); i++) {
					commonFunction.verifyIfElementIsPresent(products.get(i), "Product#" + (i + 1));
				}
				commonFunction.verifyIfElementIsPresent(getPageElement(ProductListingPageObjects.btnCompare),
						ProductListingPageObjects.btnCompare.getObjectname());
				commonFunction.verifyIfElementIsPresent(
						getPageElement(ProductListingPageObjects.lnkClearAllCompareSection),
						ProductListingPageObjects.lnkClearAllCompareSection.getObjectname());
			}
		} catch (Exception e) {
			report.updateTestLog("Product Listing Page - Validate Compage Product Section",
					"Something went wrong!" + e.toString(), Status.FAIL);
		}
	}

	public void clearCompareSection() {
		try {
			if (webdriverutil.objectExists(By.xpath(ProductListingPageObjects.clearAllOkButton.getProperty()))) {
				commonFunction.clickIfElementPresent(
						getPageElement(ProductListingPageObjects.lnkClearAllCompareSection),
						ProductListingPageObjects.lnkClearAllCompareSection.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(ProductListingPageObjects.clearAllOkButton),
						ProductListingPageObjects.clearAllOkButton.getObjectname());
				if (commonFunction.isElementPresentContainsText(
						getPageElement(ProductListingPageObjects.emptyCompareSection),
						ProductListingPageObjects.emptyCompareSection.getObjectname(), "You have no items to compare.")
						&& commonFunction.isElementPresentContainsText(
								getPageElement(ProductListingPageObjects.msgEmptyCompareSection),
								ProductListingPageObjects.msgEmptyCompareSection.getObjectname(),
								"You cleared the comparison list.")) {
					report.updateTestLog("Verify Compare section is cleared", "Compare section is successfully cleared",
							Status.PASS);
				} else {
					report.updateTestLog("Verify Compare section is cleared", "Compare section is NOT cleared",
							Status.FAIL);
				}
			} else {
				report.updateTestLog("Compare Section is Empty?", "Compare section is already Empty", Status.DONE);
			}
		} catch (Exception e) {
			report.updateTestLog("Product Listing Page - Clear Compare Section", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}

	public void clearWishListSection() {
		try {
			if (webdriverutil.objectExists(By.xpath(ProductListingPageObjects.wishListCounter.getProperty()))) {
				List<WebElement> closeBtns = commonFunction.getElementsByProperty(
						ProductListingPageObjects.btnRemoveProductFromWishList.getProperty(),
						ProductListingPageObjects.btnRemoveProductFromWishList.getLocatorType().toString());
				for (int i = 0; i < closeBtns.size(); i++) {
					commonFunction.clickIfElementPresent(closeBtns.get(0), "Product#: " + (i + 1) + " is removed");
					Thread.sleep(5000);
					if (commonFunction.verifyIfElementIsPresent(
							getPageElement(ProductListingPageObjects.msgproductRemovedFromWishList),
							ProductListingPageObjects.msgproductRemovedFromWishList.getObjectname())) {
						report.updateTestLog("Verify product removed from Wish list section",
								"Product is successfully removed from Wish List section", Status.PASS);
					} else {
						report.updateTestLog("Verify product removed from Wish list section",
								"Product is NOT removed from Wish List section", Status.FAIL);
					}
					closeBtns = commonFunction.getElementsByProperty(
							ProductListingPageObjects.btnRemoveProductFromWishList.getProperty(),
							ProductListingPageObjects.btnRemoveProductFromWishList.getLocatorType().toString());
				}
			} else {
				report.updateTestLog("Verify Wish list section is Empty", "Wish List Section is already Empty",
						Status.DONE);
			}
		} catch (Exception e) {
			report.updateTestLog("Product Listing Page - Add product to Wish List",
					"Something went wrong!" + e.toString(), Status.FAIL);
		}
	}

	public void validateWishListSection() {
		try {
			if (webdriverutil.objectExists(By.xpath(ProductListingPageObjects.wishListCounter.getProperty()))) {
				List<WebElement> products = commonFunction.getElementsByProperty(
						ProductListingPageObjects.wishListProducts.getProperty(),
						ProductListingPageObjects.wishListProducts.getLocatorType().toString());
				List<WebElement> btnsAddToCart = commonFunction.getElementsByProperty(
						ProductListingPageObjects.btnsWishListAddToCart.getProperty(),
						ProductListingPageObjects.btnsWishListAddToCart.getLocatorType().toString());
				for (int i = 0; i < products.size(); i++) {
					commonFunction.verifyIfElementIsPresent(products.get(i), "Product#" + (i + 1));
					commonFunction.verifyIfElementIsPresent(btnsAddToCart.get(i),
							"Add to Cart Button for Product#" + (i + 1));
				}
				commonFunction.verifyIfElementIsPresent(getPageElement(ProductListingPageObjects.lnkGoToWishList),
						ProductListingPageObjects.lnkGoToWishList.getObjectname());
			}
		} catch (Exception e) {
			report.updateTestLog("Product Listing Page - Validate Wish List Section",
					"Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
	public void validateShowAllButtonInPLP() {
		try {
			List<WebElement> products = commonFunction.getElementsByProperty(
					ProductListingPageObjects.products.getProperty(),
					ProductListingPageObjects.products.getLocatorType().toString());
			commonFunction.clickIfElementPresent(getPageElement(ProductListingPageObjects.btnShowAllCombos),
					ProductListingPageObjects.btnShowAllCombos.getObjectname());
			Thread.sleep(5000);
			List<WebElement> productsAfterShowAll = commonFunction.getElementsByProperty(
					ProductListingPageObjects.products.getProperty(),
					ProductListingPageObjects.products.getLocatorType().toString());
			if (products.size() < productsAfterShowAll.size()) {
				report.updateTestLog("Verify Show All Combos button on Product Listing Page",
						"Show All Button on Product Listing Page is working fine", Status.PASS);
			} else {
				report.updateTestLog("Verify Show All Combos button on Product Listing Page",
						"Show All Combos Button on the Product Listing Page is not Working", Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("Validate show all button in Product Listing Page", "Something went wrong!" + e.toString(), Status.FAIL);
		}
	}
}
