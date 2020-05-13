package pages;
import static pages.ObjectLocator.*;
public enum ProductDetailsPageObjects implements PageObjects{

	productMainImage("(//img[@class='fotorama__img'])[1]",XPATH,"Product Details page - Product Main Image"),
	productMainName("//h1[@class='page-title']/span",XPATH,"Product Details Page - Product Main name"),
	productMainStarRating("(//div[@class='bv_stars_component_container'])[1]",XPATH,"Product Details Page - Product Main Rating in Stars"),
	productRatingInNumber("(//div[@class='bv_avgRating_component_container notranslate'])[1]",XPATH,"Product Details Page - Product Main Rating in Decimal"),
	ProductReviewCountlink("//a[@class='pr-snippet-review-count']",XPATH,"Product Details Page - Product Review Count Link"),
	writeAReviewLink("(//*[@class='bv_button_buttonMinimalist '])[1]",XPATH,"Product Details Page - Product Write a Review Link"),
	titleQAndA("//div[@class='pr-snippet-qa-metrics']/abbr[@title='Questions & Answers']",XPATH,"Product Details Page - Product section - Q & A"),
	divQuestionAnsweredCount("//div[@class='pr-answered-question-circle']",XPATH,"Product Details Page - Questions Answsered Count"),
	answeredQuestionLink("//a[@class='pr-snippet-qa-answer-link']",XPATH,"product Details Page - Answsered Question link"),
	askAQuestionLink("(//*[@class='bv_button_buttonMinimalist '])[1]",XPATH,"Product Details page - Ask A Question Link"),
	viewStoreLocationlink("//a[text()='View Store Locations']",XPATH,"Product Details Page - View Store Location link"),
	productPrice("(//span[@class='price'])[1]",XPATH,"Product Details page - Product Price in $"),
	productPriceSTG("//span[@class='price-container price-final_price tax weee']/span/span",XPATH,"Product Details page - Product Price in $"),
	productDescription("//div[@class='description']",XPATH,"Product Details page - Product Description"),
	productDescriptionSTG("//div[@class='description']",XPATH,"Product Details page - Product Description"),
	
	productModels("//div[contains(@id,'grouped-pdp-simple')]",XPATH,"Product Details Page - Product Models"),
	quantitylabel("//label[@for='qty']",XPATH,"Product Details Page - Label - Quantity"),
	quantityDecrementor("qty-decrementor",ID,"Product Details Page - Product Decrementor"),
	productQuantity("//input[@title='Quantity']",XPATH,"Product Details Page - Product Quantity"),
	quantityIncrementor("qty-incrementor",ID,"Product Details Page - Product Incrementor"),
	btnAddToCart("//*[@id='product-addtocart-button']",XPATH,"Product Details Page - Button Add to Cart"),
	msgProductAdded("((//div[@class='messages'])[1]",XPATH,"Product Details Page - Product Added to Cart Message"),
	
	lnkWishList("//a[@data-action='add-to-wishlist']",XPATH,"Product Details Page - Link - Wish List"),
	msgProductAddedtoWishList("//div[@class='message-success success message']/div",XPATH,"Product Details page - Message - Product Added to Wish List"),
	lnkCompare("//a[@data-role='add-to-links']",XPATH,"Product Details Page - Link - Wish List"),
	msgProductAddedtoCompare("(//div[@class='messages']/div/div)[1]",XPATH,"Product Details page - Message - Product Added to Compare"),
	// Share section
	facebookIcon("//a[@title='Facebook']",XPATH,"Product Details Page - Share section - Facebook Icon"),
	twitterIcon("//a[@title='Twitter']",XPATH,"Product Details Page - Share Section - Twitter Icon"),
	sendMailIcon("//a[@class='action mailto friend']",XPATH,"Product Details Page - Share Section - Send Mail Icon"),
	
	lnkReturnPolicy("//a[@class='action toreturnpolicy px-4']",XPATH,"Product Details Page - Return Policy Link"),
	titleReturnPolicy("//h1[@class='page-title']/span",XPATH,"Return Policy Page - Title - Return Policy"),
	
	// Ask A Question Page
	lblAskAQuestion("//h1[@class='pr-header-title']",XPATH,"Ask A Question Page - Label Ask A Question"),
	productImage("//img[@alt='product image']",XPATH,"Ask A Question Page - Product Image"),
	productNameLink("//div[@class='table-cell']/a",XPATH,"Ask A Question Page - Product Name Link"),
	lblTypeOfQuestion("//label[@for='questionType-input']",XPATH,"Ask A Question Page - Label Type Of Question"),
	
	btnTheSeviceQuestionType("//div[@role='radiogroup']/div[1]",XPATH,"Ask A Question Page - Type Of Question - The Service"),
	btnTheProductQuestionType("//div[@role='radiogroup']/div[2]",XPATH,"Ask A Question Page - Type Of Question - The Product"),
	
	lblQuestion("//label[@for='questionText-input']",XPATH,"Ask A Question Page - Question label"),
	txtAreaQuestion("questionText-input",ID,"Ask A Question Page - Question - Text Area"),
	labelEmail("//label[@for='authorEmail-input']",XPATH,"Ask A Question - Label Email"),
	msgBelowEmailLabel("//div[@class='pr-helper-text']",XPATH,"Ask A Question Page - Message Below Email label : To receive your answer, please provide your email address."),
	
	txtBoxEmail("authorEmail-input",ID,"Ask A Question Page - Email Text Box"),
	labelNickName("//label[@for='authorName-input']",XPATH,"Ask A Question Page - Label Nick Name"),
	txtBoxNickName("authorName-input",ID,"Ask A Question Page - Text Box - Nick Name "),
	
	labelYourLocation("//label[@for='authorLocation-input']",XPATH,"Ask A Question Page - Label Your Location"),
	txtBoxYourLocation("authorLocation-input",ID,"Ask A Question Page - Your Location Text Box"),
	
	msgLegalTermsConditions("//p[@class='form-group pr-waq-legal-text']/span",XPATH,"Ask A Question Page - Message - Accepting Legal Terms And Conditions"),
	btnSubmit("//div[@role='button']",XPATH,"Ask A Question Page - Submit Button"),
	
	
	// Write A Review Page
	
	titleWriteAReview("//h3[@class='pr-header-title']",XPATH,"Write A Review Page - Title Write A Review"),
	productImageWriteAReivewPage("//img[@alt='product image']",XPATH,"Write A Review Page - Product Image"),
	
	lblOverallRating("//label[@for='pr-rating-input']",XPATH,"Write A Review Page - Label - Overall Rating"),
	overallRatinWriteAReview("//div[@id='pr-rating']/div",XPATH,"Write A Review Page - Overall Rating in Stars"),
	
	lblReviewTitle("//label[@for='pr-headline-input']",XPATH,"Write A Reivew Page - Label - Review Title"),
	txtBoxReviewTitle("pr-headline-input",ID,"Write A Review Page - Text Box - Review title"),
	
	lblReview("//label[@for='pr-comments-input']",XPATH,"Write A Reveiw Page - Label - Review"),
	txtBoxReview("pr-comments-input",ID,"Write A Review Page - Text Box - Review"),
	
	labelWouldYouRecomndToFrnd("//label[@for='pr-bottomline-input']",XPATH,"Write A Review Page - Label - Would You Recommend this Product To a Friend?"),
	btnYesRecomndToFrnd("//div[@class='btn-group btn-toggle btn-group-2-count btn-group-radio-vertical']/div[1]",XPATH,"Write A Review Page - Button - Yes, I would Recommend This Product To A Friend"),
	btnNoRecomndToFrnd("//div[@class='btn-group btn-toggle btn-group-2-count btn-group-radio-vertical']/div[2]",XPATH,"Write A Review Page - Button - No I would Not Recommend This Product To A Friend"),
	
	lblNickNameWriteAReivew("//label[@for='pr-name-input']",XPATH,"Write A Reivew Page - Label - Nick Name"),
	txtBoxNickNameWriteAReview("pr-name-input",ID,"Write A Review Page - Text Box - Nick Name"),
	
	lblLocationWriteAReveiw("//label[@for='pr-location-input']",XPATH,"Write A Review Page - Label Location"),
	txtBoxLocationWriteAReview("pr-location-input",ID,"Write A Review Page - Text Box Location "),
	
	lblQualityOfProductWriteAReveiw("//label[@for='pr-qualityofproduct-input']",XPATH,"Write A Review Page - Label - Quality Of Product"),
	ratingQualityOfProductWriteAReview("//div[@id='pr-qualityofproduct']/div",XPATH,"Write A Review Page - Rating - Quality Of Product"),
	
	lblValueOfProductWriteAReview("//label[@for='pr-valueofproduct-input']",XPATH,"Write A Review Page - Label - Value Of Product"),
	ratingValueOfProductWriteAReview("//div[@id='pr-valueofproduct']/div",XPATH,"Write A Reviwe Page - Rating - Value of Product"),
	
	lblEaseOfUse("//label[@for='pr-easeofuse-input']",XPATH,"Write A Review Page - Label - Ease Of Use"),
	ratingEaseOfUseWriteAReview("//div[@id='pr-easeofuse']/div",XPATH,"Write A Review Page - Rating - Ease Of Use"),
	
	lblHowOldAreYouWriteAReveiw("//label[@for='pr-howoldareyou-input']",XPATH,"Write A Review Page - Label - How Old Are You"),
	drpDownHowOldAreYou("pr-howoldareyou-input",ID,"Write A Review Page - Drop Down - How Old Are You?"),
	
	lblWhatIsYourGenderWriteAReveiw("//label[@for='pr-whatisyourgender-input']",XPATH,"Write A Review Page - Label - What Is Your Gender?"),
	drpDownWhatIsYourGenderWriteAReivew("pr-whatisyourgender-input",ID,"Write A Review Page - Drop Down - What is your Gender?"),
	
	lblLevelOfFishingExpertise("//label[@for='pr-leveloffishingexpertise-input']",XPATH,"Write A Review Page - Label - Level Of Expertise"),
	drpDownLevelOfFishingExpertiseWriteAReview("pr-leveloffishingexpertise-input",ID,"Write A Review - Drop Down - Level Of Fishing Expertise"),
	
	lblWhichTypeFishRecomndCatching("//label[@for='pr-whichtypesoffishdoyourecommendcatchingwiththisprod-group']",XPATH,"Write A Review Page - Label - Which types of fish do you recommend catching with this product?"),
	listFishNames("//div[@id='pr-whichtypesoffishdoyourecommendcatchingwiththisprod-group']/div/div",XPATH,"Write A Review Page - List of fish names"),
	
	btnAddYourOwnWriteARview("//div[@class='pr-btn-add-tag']/a",XPATH,"Write A Review Page - Button - Add your Own"),
	
	
	lblDoYouReadProducReviewsWriteAReview("//label[@for='pr-didyoureadproductreviewsonlinebeforepurchasingthis-input']/span",XPATH,"Write A Review Page - Label - Do you read product reviews online before purchasing the product?"),
	drpDownDoYouReadProductReviewWriteAReview("pr-didyoureadproductreviewsonlinebeforepurchasingthis-input",ID,"Write A Review - Drop Down - Do you read product reviews online before purchasing the product?"),
	
	lblWouldYouRecomndZebcoProductToFrndWriteAReveiw("//label[@for='pr-wouldyourecommendzebcobrandstoafriend-input']/span",XPATH,"Write A Review Page - Label - Would you recommend Zebco Brands to a friend? (1 being Never to 10 being Definitely)"),
	scale1To10WoudYouRecomndZebcoProductToFrndWriteAReview("//div[@aria-labelledby='pr-wouldyourecommendzebcobrandstoafriend']/div",XPATH,"Write A Review Page - Scale 1 to 10"),
	
	lblAddAnImageWriteAReview("//label[text()='Add an Image']",XPATH,"Write A Review Page - Label Add An Image"),
	btnAddAnImageWriteAReview("(//div[@class='pr-file-input-btn'])[1]",XPATH,"Write A Review Page - Button - Upload an Image "),
	
	
	lblAddAVideoWriteAReview("//label[text()='Add a Video']",XPATH,"Write A Review Page - Label Add a Video"),
	btnAddaVideoWriteAReview("(//div[@class='pr-file-input-btn'])[2]",XPATH,"Write A Review Page - Button - Upload a Video "),
	
	lblEmailWriteAReview("//label[@for='pr-email_collection-input']/span",XPATH,"Write A Review Page - Label - Email"),
	txtBoxEmailWriteAReview("pr-email_collection-input",ID,"Write A Review - Text Box - Email"),
	
	chckBoxAgreeTermsWriteAReview("//label[@class='pr-control-label']/input",XPATH,"Write a Review Page - Check Box -I agree with the terms and privacy policy"),
	chckDescpAgreeTermsWriteAReview("//div[@class='pr-checkbox']/label[@class='pr-control-label']/span",XPATH,"Write A Review Page - Check box - message - I agree with the terms and privac policy"),
	
	msgAgreeToTermsConditionWriteAReivew("//p[@class='pr-subscript']",XPATH,"Write A Review Page - Message - By submitting, you represent that you have read and agree to our "),
	
	btnSubmitReview("//div[@role='button']",XPATH,"Write A Review Page - Submit Review Button"),
	
	// Mini Cart Section
	
	iconMiniCart("//a[@title='Link to Mini Cart']",XPATH,"Product Details Page - Mini Cart Icon"),
	miniCartItemCountMsg("//div[@class='items-total']",XPATH,"Mini- Items Count message in Cart"),
	miniCartProductName("//strong[@class='product-item-name']/a",XPATH,"Mini Cart - Product Name"),
	miniCartProductImage("//img[@class='product-image-photo']",XPATH,"Mini Cart - Product Image"),
	miniCartLabelQuantity("//div[@class='details-qty qty']/label",XPATH,"Mini Cart - Quanity Label"),
	miniCartQuanitityTextBox("//input[@class='item-qty cart-item-qty']",XPATH,"Mini Cart - Quantity Text Box"),
	MiniCartProductPrice("//span[@class='minicart-price']/span",XPATH,"Mini Cart - Product Price"),
	miniCartLblCartSubTotal("//div[@class='subtotal']/span/span",XPATH,"Mini Cart - Label - Cart Sub Total"),
	miniCartCartPrice("//div[@class='amount price-container']/span/span",XPATH,"Mini Cart - Cart Sub Toal in $"),
	miniCartbtnGoToCart("//a[@class='action viewcart']",XPATH,"Mini Cart - Button - Go To Cart"),
	miniCartIcon("//a[@title='Link to Mini Cart']",XPATH,"Product Details Page - Mini Cart Icon"),
	miniCartCounterqty("(//*[@class='counter qty'])[1]",XPATH,"Product Details Page - Mini Cart Icon"),
	
	
	drpdwnSizeGroupProd("//*[@id='grouped-configurable-grouped-attr-size']",XPATH,"Grouped Product - select size"),
	drpdwnLengthGroupProd("//*[@id='grouped-configurable-grouped-attr-length']",XPATH,"Grouped Product - select length"),
	
	
	
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

	private ProductDetailsPageObjects(String strPropertyValue, ObjectLocator locatorType, String strObjName) {
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
