package pages;

import static pages.ObjectLocator.*;
public enum ProductListingPageObjects implements PageObjects{

combosCategoryFilterSpincast("(//div[@class='filter-options-title'])[1]/following::a[1]",XPATH,"Combos Page - Category - Spincast"),
combosPriceFilter0_24("//div[@class='filter-options']/div/div[2]/ol/li[1]/a",XPATH,"Combos Page - Category - Price filter - $ 0 - $24.99"),
drpDownSortBy("sorter",ID,"Product Listing Page - Sort By"),
arrowArrowDecendingSort("//div[@class='toolbar-sorter sorter']/a",XPATH,"Product Listing Page - Sort By - Decending Arrow"),

products("//ol[@class='products list items product-items']/li",XPATH,"Product Listing page - Products"),
productImage("//img[@class='product-image-photo']",XPATH,"Product Listing page - Product Image"),
productItemLink("//a[@class='product-item-link']",XPATH,"Product Listing Page - Product Item Link"),
productPrice("//span[@class='price']",XPATH,"Product Listing Page - Product Price"),
productRatings("//div[@class='pr-rating-stars']",XPATH,"Product Listing Page - Product Ratings"),
btnproductViewDetails("//div[@class='float-lg-right w50 text-right add-to-cart-btn']/a",XPATH,"Product Listing page - Product View Details Button"),
btnproductViewDetailsSTG("//div[@class='float-lg-right w50 text-right add-to-cart-btn']/a",XPATH,"Product Listing page - Product View Details Button"),
btnShowAllCombos("showAll",ID,"Product Listing Page - Show All button"),

descRodAndReelCombos("//div[@class='description']/p",XPATH,"Product Listing page - Product description - Rod and Reel Combos"),
lblCompareProducts("block-compare-heading",ID,"Product Listing Page - Commpare Products Label"),
lblNowShoppingBy("block-subtitle filter-current-subtitle",ID,"Product Listing Page - Now Shopping By label"),
lblShoppingOptions("//strong[text()='Shopping Options']",XPATH,"Product Listing Page - Label - Shopping Options"),


productsInCompareSections("//ol[@id='compare-items']/li",XPATH,"Product Listing Page - Products in Compare Section"),
btnCompare("//a[@class='action compare primary']",XPATH,"Product Listing Page - Compare Section - Compare Button"),
lnkClearAllCompareSection("compare-clear-all",ID,"Product Listing Page - Compare Section - Clear All link"),
clearAllOkButton("//button[@class='action-primary action-accept']",XPATH,"Product Listing Page - Clear All confirmation overlay - OK button"),
emptyCompareSection("//div[@class='empty']",XPATH,"Product Listing Page - Empty Compare Section - You have no items to compare."),
msgEmptyCompareSection("//div[@class='messages']/div/div",XPATH,"Product Listing Page - Clear All Compare Section"),
productsInCompareSection("//li[@class='product-item odd last']/a",XPATH,"Product Listing Page - Products in Coompare Section"),
compareSectionProductCounter("//div[@class='block block-compare']/div/span",XPATH,"Product Listing Page - Product counter in Comapre section"),
btnOkToRemoveProductFromCompareSection("//button[@class='action-primary action-accept']",XPATH,"Product Listing Page - Remove product from Compare section overlay - Ok Button"),

btnProductCompare("//div[@class='actions-secondary']/a[2]",XPATH,"Product Listing Page - Button - Compare"),
msgProductAddedToCompare("//div[@class='messages']/div/div",XPATH,"Product Listing Page - Message - Product added to Compare - You added product # to the comparison list."),
btnProductWishList("//div[@class='actions-secondary']/a[1]",XPATH,"Product Listing page Button - Wish"),
msgProductAddedToWishList("//div[@class='messages']/div/div",XPATH,"Product Listing Page - Message - Product added to Wish List - "),

btnRemoveProductFromWishList("//div[@class='product-item-actions']/div[@class='actions-secondary']/a",XPATH,"Product Listing Page - X button to Remove product from Wish List"),
wishListCounter("//span[@class='counter']",XPATH,"Product Listing Page - Wish List Counter"),
msgproductRemovedFromWishList("//div[@class='messages']/div/div",XPATH,"Product Listing page - Message - 'Product' has been removed from your Wish List."),
wishListProducts("//ol[@id='wishlist-sidebar']/li/div",XPATH,"Product Listing Page - Wish List Products"),
lnkGoToWishList("//a[@title='Go to Wish List']",XPATH,"Product Listing Page - Wish List Section - link - Go To Wish List"),
btnsWishListAddToCart("//div[@class='actions-primary']/button[@class='action tocart primary']",XPATH,"Product Listing Page - Wish List Section - Product - Add to Cart"),


nowShopppingByCategories("//ol[@class='items']/li/span",XPATH,"Now Shopping By Categories"),


// Card Image
card1ProductName("(//h5[@class='card-title'])[1]",XPATH,"Product Listing Page - Card 1 - Product name"),
Card1ShopNowBtn("//a[@title='SHOP NOW']",XPATH,"Product Listing Page - Card 1 - Shop Now Button"),
shopBulletBtnSTG("//a[text()='SHOP BULLET']",XPATH,"Product Listing Page - Card 1 - Shop Bullet button"),

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

private ProductListingPageObjects(String strPropertyValue, ObjectLocator locatorType, String strObjName) {
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
