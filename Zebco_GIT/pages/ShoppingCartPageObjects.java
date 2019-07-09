package pages;

import static pages.ObjectLocator.*;
public enum ShoppingCartPageObjects implements PageObjects {

	titleShoppingCart("//h1[@class='page-title']/span",XPATH,"Shopping Cart Page - Title - Shopping Cart"),
	btnGoToCheckout("//button[@title='Go to Checkout']",XPATH,"Shopping Cart page - Go to Checkout Button"),
	productImage("(//img[@class='product-image-photo'])[2]",XPATH,"Shopping Cart Page - Product Image"),
	productName("(//strong[@class='product-item-name']/a)[2]",XPATH,"Shopping Cart Page - Product Name"),
	
	lnkContinueShopping("//div[@id='cart-continue-shopping']/a",XPATH,"Shopping Cart Page - link - Continue Shopping"),
	paginationOverview("//a[text()='Overview']",XPATH,"Shopping Cart Page - Pagination 1 - Overview"),
	paginationBillingShipping("(//li[@class='opc-progress-bar-item']/span)[1]",XPATH,"Shopping Cart Page - Pagination 2 - Billing/Shipping"),
	paginationPayment("(//li[@class='opc-progress-bar-item']/span)[2]",XPATH,"Shopping Cart Page - Pagination 3 - Payment"),
	paginationConfirmation("(//li[@class='opc-progress-bar-item']/span)[3]",XPATH,"Shopping Cart Page - Pagination 4 - Confirmation"),
	lblItem("//table[@id='shopping-cart-table']/thead/tr/th[1]/span",XPATH,"Shopping Cart Page - Shopping Cart Table - Column Label Item"),
	lblPrice("//table[@id='shopping-cart-table']/thead/tr/th[2]/span",XPATH,"Shopping Cart Page - Shopping Cart Table - Column Label Price"),
	lblQty("//table[@id='shopping-cart-table']/thead/tr/th[3]/span",XPATH,"Shopping Cart Page - Shopping Cart Table - Column Label Qty"),
	lblSubTotal("//table[@id='shopping-cart-table']/thead/tr/th[4]/span",XPATH,"Shopping Cart Page - Shopping Cart Table - Column Label Sub total"),
	productPrice("//td[@data-th='Price']/span/span/span",XPATH,"Shopping Cart Page - Product Price"),
	productQty("//input[@title='Qty']",XPATH,"Shopping Cart page - Product Quantity"),
	productSubTotal("//td[@data-th='Subtotal']/span/span/span",XPATH,"Shopping Cart Page - Product Price"),
	btnEditParameters("//div[@class='actions-toolbar']/a[@title='Edit item parameters']",XPATH,"Shopping Cart Page - Edit Parameters button"),
	btnremoveProduct("//div[@class='actions-toolbar']/a[@title='Remove item']",XPATH,"Shopping Cart Page - Button - Remove the Product"),
	lnkMoveToWishList("//div[@class='actions-toolbar-row']/a[1]",XPATH,"Shopping Cart Page - Link - Move To Wish List"),
	btnUpdateShoppingCart("//button[@title='Update Shopping Cart']",XPATH,"Shopping Cart Page - Shopping Cart Table - Button - Update Shopping Cart"),
	itemCountOnMiniCart("//a[@title='Link to Mini Cart']/span[@class='counter qty']/span[1]",XPATH,"Mini Cart - Items added to cart"),
	msgProdutctMovedToWishList("//div[@role='alert']/div/div",XPATH,"Shopping Cart Page - Message - Product Moved to Wishlist"),
	
	// Summary section
	titleSummary("//strong[@class='summary title']",XPATH,"Shopping Cart Page - Summary section - Title - Summary"),
	estimateShippingTaxSection("block-shipping-heading",ID,"Shopping Cart Page - Estimate Shipping Tax Section"),
	drpDownState("//select[@name='region_id']",XPATH,"Shopping Cart Page - Estimation Shipping Tax Section - Drop Down State"),
	txtBoxZipCode("//input[@name='postcode']",XPATH,"Shopping Cart Page - Estimate Shipping Tax Section - Text box - Zipcode"),
	radioBtnGroundShipping("s_method_zebcoshipping_ground",ID,"Shopping Cart Page - Estimation Shipping Tax Section - Radio Button - Ground Shipping"),
	radioBtn2ndDayShipping("s_method_zebcoshipping_2nd_day",ID,"Shopping Cart Page - Estimate Shipping Tax Section - Radio Button - 2nd Day Shipping"),
	radioBtnNextDayShipping("s_method_zebcoshipping_next_day",ID,"Shopping Cart Page - Estimate Shipping Tax Section - Radio Button - Next Day Shipping"),
	
	lblSubtotalSummarySection("//tr[@class='totals sub']/th",XPATH,"Shopping Cart Page - Summary Section - label - Sub total"),
	priceSubTotalSummarySection("//tr[@class='totals sub']/td[@class='amount']/span",XPATH,"Shopping Cart Page - Summary Section - Price in $ Sub total"),
	lblshippingCharges("//tr[@class='totals shipping excl']/th",XPATH,"Shopping Cart Page - Summary Section - Shipping Type label"),
	priceShippingChargeSummarySection("//tr[@class='totals shipping excl']/td/span",XPATH,"Shopping Section - Price in $ Shipping Charge"),
	lblOrderTotalSummarySection("//tr[@class='grand totals']/th",XPATH,"Shopping Cart Page - Summary Section - Label - Order Total"),
	priceOrderTotalSummarySection("//td[@data-th='Order Total']/strong/span",XPATH,"Shopping Cart Page - Summary Section - Price in $ Order Total"),
	
	// Discount section
	lblHaveADiscount("cart-discount-title",ID,"Shopping Cart Page - Discount Section - Have a discount code? Apply it here. "),
	txtBoxCounponCode("//input[@name='coupon_code']",XPATH,"Shopping Cart Page - Discount Section - Enter dicount Code"),
	btnApplyDiscount("cart-discount-button",ID,"Shopping Cart Page - Discount Section - Button Apply Discount"),
	
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

	private ShoppingCartPageObjects(String strPropertyValue, ObjectLocator locatorType, String strObjName) {
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
