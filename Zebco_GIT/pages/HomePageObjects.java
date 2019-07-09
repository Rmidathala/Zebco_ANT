package pages;

import static pages.ObjectLocator.*;
public enum HomePageObjects implements PageObjects {
	
	zeboLogo("//strong[@class='logo']/img",XPATH,"Home Page - Zebco Logo"),
	
	lnkHeaderCombos("//span[text()='Combos']",XPATH,"Home Page - Header link - Comboss"),
	lnkHeaderReels("//span[text()='Reels']",XPATH,"Home Page - Header link - Reels"),
	lnkHeaderRods("//span[text()='Rods']",XPATH,"Home Page - Header link - Rods"),
	lnkHeaderMore("//span[text()='More']",XPATH,"Home Page - Header link - More"),
	
	//Combos sub links
	lnkHeaderCombosSubLinkSpinCast("(//span[text()='Spincast'])[1]",XPATH,"Home Page - Header - Comobos - Sub link - Spincast"),
	lblSpincast("h1",TAG,"Combos - Spincast Page - Title - SpinCast"),
	lnkHeaderCombosSubLinkSpinning("(//span[text()='Spinning'])[1]",XPATH,"Home Page - Header - Combos - Sub  link - Spinning"),
	lblSpinning("h1",TAG,"Spinning Page - Title - Spinning"),
	lnkHeaderCombosSubLinkTriggerSpin("(//span[text()='Triggerspin'])[1]",XPATH,"Home Page - Header Combox - Sub Link - Triggerspin"),
	lblTriggerSpin("h1",TAG,"Trigger Spin Page - Title - Trigger Spin"),
	lnkHeaderComboSublinkOther("(//span[text()='Other'])[1]",XPATH,"Home Page - Header Combos - Sub link - Other"),
	lblOther("h1",TAG,"Combos Sub link Other Page - Title - Other"),
	lnkHeaderCombosSublinkOtherSublinkBaitCast("(//span[text()='Baitcast'])[1]",XPATH,"Home Page - Combos - Sub link - Other - Sub link - BaitCast"),
	lblBaitcast("h1",TAG,"Combos Sub link Other sublink - Baitcast Page - Title - BaitCast"),
	lnkHeaderCombosSublinkOtherSublinkFly("(//span[text()='Fly'])[1]",XPATH,"Home Page - Combos - Sub Link - Other - Sub link - Fly"),
	lblFly("h1",TAG,"Combos Sub link Other sublink - Fly Page - Title - Fly"),
	
	//Reels Sub link
	lnkHeaderReelsSublinkSpincast("//li[@class='level1 nav-2-1 category-item first ui-menu-item']/a/span",XPATH,"Home Page - Header - Reels Sub link - Spincast"),
	lblReelSpincast("h1",TAG,"Reel - Spincast Page - Title - SpinCast"),
	lnkHeaderReelsSublinkSpinning("//li[@class='level1 nav-2-2 category-item ui-menu-item']/a/span",XPATH,"Home Page Header - Reels - Sub link - Spinning "),
	lblReelSpinning("h1",TAG,"Reels - Spinning Page - Title - Spinning"),
	lnkHeaderReelsSublinkTriggerSpin("//li[@class='level1 nav-2-3 category-item ui-menu-item']/a/span",XPATH,"Home Page - Header - Reels - Sub link - Triggerspin"),
	lblReelsTriggerSpin("h1",TAG,"Reels - Trigger Spin Page - Title - Triggerspin"),
	lnkHeaderReelsSublinkOther("//li[@class='level1 nav-2-4 category-item ui-menu-item']/a/span",XPATH,"Home Page - Header - Reels - Sub link - Other"),
	lblReelOther("h1",TAG,"Reels Sub link Other Page - Title - Other"),
	lnkHeaderReelsSublinkConventional("//li[@class='level1 nav-2-5 category-item last ui-menu-item']/a/span",XPATH,"Home Page - Header - Sub link - Conventional"),
	lblReelConventional("h1",TAG,"Reels Sub link Conventional Page - Title - Conventional"),
	
	//Rods sub links
	lnkHeaderRodsSublinkCasting("//li[@class='level1 nav-3-1 category-item first ui-menu-item']/a/span",XPATH,"Home Page Header - Rods - Sub link - Casting"),
	lblRodsCasting("h1",TAG,"Rods Sub link Casting Page - Title - Casting"),
	lnkHeaderRodsSublinkSpinning("//li[@class='level1 nav-3-2 category-item last ui-menu-item']/a/span",XPATH,"Home Page Header - Rods - Sub link - Spinning"),
	lblRodsSpinning("h1",TAG,"Rods - Spinning Page - Title - Spinning"),
	
	// More Sub links
	lnkHeaderMoreSublinkLine("//li[@class='level1 nav-4-1 category-item first ui-menu-item']/a/span",XPATH,"Home Page - Header - More - Sub link - Line"),
	lblMoreSublinkLine("//strong[text()='Line']",XPATH,"More Sub Link - Line Label"),
	lnkHeaderMoreSublinkAccessories("//li[@class='level1 nav-4-2 category-item last ui-menu-item']/a/span",XPATH,"Home Page - Header - More - Sub link - Accessories"),
	lblMoreSubLineAccessories("//strong[text()='Accessories']",XPATH,"More Sub link - Accessories Label"),
	
	// Footer columns
	footerColAbout("(//div[@class='footer-links-large-title azo-sans font-brown'])[1]",XPATH,"Home page - Footer - Label - About"),
	footercolMyOrder("(//div[@class='footer-links-large-title azo-sans font-brown'])[2]",XPATH,"Home Page - footer - Label - My Order"),
	footerColSupport("(//div[@class='footer-links-large-title azo-sans font-brown'])[3]",XPATH,"Home page - Footer - Lable - Support"),
	footerColCotactUs("(//div[@class='footer-links-large-title azo-sans font-brown'])[4]",XPATH,"Home Page - Footer - Lable - Contact Us"),
	
	// Footer - About links
	footerColAboutLnkZebcoHeritage("(//a[@title='Zebco Heritage'])[1]",XPATH,"Home Page - Footer - About - Link - Zebco Heritage"),
	footerColAboutLnkCareers("(//a[@title='Careers'])[1]",XPATH,"Home Page Footer - About - Link Careers"),
	footerColAboutLnkResourceCenter("(//a[@title='Resource Center'])[1]",XPATH,"Home Page - Foooter - About - Link Resource Center"),
	
	//Footer My Order
	footerColMyOrderLnkTrackOrder("(//a[@title='Track Order'])[1]",XPATH,"Home Page - Footer - My Order - Link - Track Order"),
	footerColMyOrderLnkProductRegistration("(//a[@title='Product Registration'])[1]",XPATH,"Home Page - Footer - My Order - link - Product Registration"),
	footerColMyOrderLnkShippingPolicy("(//a[@title='Shipping Policy'])[1]",XPATH,"Home Page - Footer - My Order - Link - Shipping Policy"),
	footerColMyOrderLnkReturnsExchanges("(//a[@title='Returns & Exchanges'])[1]",XPATH,"Home Page - Footer - My Order - Link - Returns  & Exchanges"),
	footerColMyOrderLnkWarrentyInformation("(//a[@title='Warranty Information'])[1]",XPATH,"Home Page - Footer - My Order - Link Warrenty Information"),
	
	// Footer Support
	footerColSupportLnkFaq("(//a[@title='FAQ'])[1]",XPATH,"Home Page - Footer - Support - Link - FAQ"),
	footerColSupportLnkTipsMaintainance("(//a[@title='Tips & Maintenance'])[1]",XPATH,"Home Page - Footer - Support - Link - Tips & Maintenance"),
	footerColSupportLnkTroubleShooting("(//a[@title='Troubleshooting'])[1]",XPATH,"Home Page - Footer - Link - Troubleshooting"),
	footerColSupportLnkFindAServiceCenter("(//a[@title='Find A Service Center'])[1]",XPATH,"Home Page - Footer Link - Find a Service Center"),
	footerColSupportLnkFindARetailer("(//a[@title='Find A Retailer'])[1]",XPATH,"Home page - Footer - Support - Link - Find A Retailer"),
	
	//Footer Contact us
	footerColContactUsPhoneNumber("(//a[@title='Contact Us Phone Number'])[1]",XPATH,"Home Page - Footer - Contact Us - Phone Number link"),
	footerColContactUsSendAnEmail("(//a[@title='Send An Email'])[1]",XPATH,"Home Page - Footer - Contact Us - Link - Send an Email"),
	
	//Search
	txtBoxSearch("//input[@id='search']",XPATH,"Home Page - Enter your Search Text Box"),
	navSearchResults("//li[@class='item search']/strong",XPATH,"Search Resutls Page - Navigation"),
	titleSearchResults("//h1[@class='page-title']/span",XPATH,"Search Results Page - Title - Search Results"),
	searchResultsProducts("//li[@class='item product product-item']",XPATH,"Search Results Page - Products"),
	msgNoSearchResults("//div[@class='message notice']/div",XPATH,"Search Results Page - No Search results message"),
	
	// Footer - Newsletter
	lblNewsletterSignUp("footer-newsletter-title",ID,"Home Page footer - News Letter Sign up label"),
	txtBoxNewletterEmail("//input[@id='footer-newsletter-input']",XPATH,"Home Page Footer - Newsletter - Email text box"),
	btnGoArrow("//button[@id='footer-newsletter-button']",XPATH,"Home Page Footer - Newsletter Go Arrow button"),
	msgSuccessNewsLetter("//div[@class='messages']/div/div",XPATH,"Newletter sign up success message - Thank you for your subscription."),
	
	// Connect with US 
	lblConnectWithUS("footer-social-links-title",ID,"Footer - Connect With Us Lable"),
	facebookIcon("//a[@title='Zebco Facebook']",XPATH,"Footer - Connect with US - Facebook icon"),
	twitterIcon("//a[@title='Zebco Twitter']",XPATH,"Footer - Connect with US - Twitter Icon"),
	instagramIcon("//a[@title='Zebco Instagram']",XPATH,"Footer - Connect With US - Instagram Icon"),
	youtubeIcon("//a[@title='Zebco Youtube']",XPATH,"Footer - Connect With US - YouTube Icon"),
	
	// Deep footer links
	lnkSiteMap("//a[@title='Site map']",XPATH,"Footer - Link - Site Map "),
	lnkPrivacyPolicy("//a[@title='Privacy policy']",XPATH,"Footer Link - Privacy Policy"),
	lnkTermsOfUse("//a[@title='Terms of use']",XPATH,"Footer Link - Terms Of Use"),
	lnkCASupplyChainAct("//a[@title='CA Supply Chain Act']",XPATH,"Footer Link - CA Supply Chain Act"),
	lnkAccessibility("//a[@title='Accessibility']",XPATH,"Footer link - Accessibility"),
	lblCopyRight("//div[@id='footer-copyright']/address",XPATH,"Footer - Copy right"),
	
	lblFindARetailer("footer-find-a-retailer-title",ID,"Home Page - Find a Retailer Label"),
	
	//Top Links
	iconFindRetailers("//a[@title='Retail Locations']/i",XPATH,"Home Page - Find Retailer Top Links"),
	lblStoreLocator("//h1[@class='page-title']/span",XPATH,"Store Locator Page - Label - Store Locator"),
	iconLogin("//a[@title='Link to Login']/i[2]",XPATH,"Home Page - Login Top Link"),
	lblCustomerLogin("//h1[@class='page-title']/span",XPATH,"Customer Login Page - Label - Customer Login"),
	iconMyCart("//a[@title='Link to Mini Cart']",XPATH,"Home Page - My Cart Icon - Top links"),
	
	
	// Adventure Tab
	btnStartAnAdventure("adventureButton",ID,"Home Page - Start and Adventure Button"),
	lblGrabRodAndReel("//div[@class='adventure w-100']/h2",XPATH,"Adventure Page - Grab a Rod & Reel. Choose Your Adventure."),
	msgPickTopicBelow("//div[@class='adventure w-100']/p",XPATH,"Adventure Page - Message - Pick a topic below and we'll hook you up with everything you need to know."),
	
	
	imgAddFishingToYourAdventure("//a[@title='Adventure + Fishing']/img",XPATH,"Adventure Page - Image - Add Fishing To Your Adventure"),
	lnkAddFishingToYourAdventure("//h3[@class='card-title']/a[@title='Add Fishing to your Adventure']",XPATH,"Adventure Page - Link - Add Fishing To Your Adventure"),
	msgAddFishingToYourAdventure("(//div[@class='card-body']/p)[1]",XPATH,"Adventure Page - Paragrah under the Image - Add Fishing To Your Adventure"),
	titleAddFishingToYourAdventure("//div[@class='container']/div/div/h1",XPATH,"Add Fishing To Your Adventure Page - Title - Add Fishing To YOur Adventure Page"),
	
	imgFishForTheFirstTime("//a[@title='Fish for the First Time']/img",XPATH,"Adventure Page - Image - Fish For The First Time"),
	lnkFishForTheFirstTime("//h3[@class='card-title']/a[@title='Fish Like A Pro Example']",XPATH,"Adventure Page - Link - Fish For The First Time"),
	msgFishForTheFirstTime("(//div[@class='card-body']/p)[2]",XPATH,"Adventure Page - Paragraph Under the Image - Fish For The First Time"),
	titleFishForTheFirstTime("//section[@class='adventure-heading overflow-hidden']/div/div/div/h1",XPATH,"Fish For The First Time Page - Title - Fish For The First Time"),
	
	imgTeachSomeoneFishingExample("//a[@title='Teach Someone Fishing Example']/img",XPATH,"Adventure Page - Image - Teach Someone Fishing Example"),
	lnkTeachSomeoneFishingExample("//h3[@class='card-title']/a[@title='Teach Someone Fishing Example']",XPATH,"Adventure Page - Link - Teach Someone Fishing Example"),
	msgTeachSomeoneFishingExample("(//div[@class='card-body']/p)[3]",XPATH,"Adventure Page - Paragraph under the image - Teach Someone Fishing Example"),
	titleTeachSomeoneFishingExample("//section[@class='adventure-heading overflow-hidden']/div/div/div/h1",XPATH,"Teach Someone Fishing Example Page - Title - Teach Someone Fishing Example"),
		
	imgImproveFishingSkillsExample("//a[@title='Improve Fishing Skills Example']/img",XPATH,"Adventure Page - Image - Improve Fishing Skills Example"),
	lnkImproveFishingSkillsExample("//h3[@class='card-title']/a[@title='Improve Fishing Skills Example']",XPATH,"Adventure Page - Link - Improve Fishing Skills Example"),
	msgImproveFishingSkillsExample("(//div[@class='card-body']/p)[4]",XPATH,"Adventure Page - Paragraph under Improve Fishing Skills Example"),
	titleBeABetterAngler("//section[@class='adventure-heading overflow-hidden']/div/div/div/h1",XPATH,"Be a Better Angler Page - Title - Be a Better Angler"),
	
	titleFindARetailer("footer-find-a-retailer-title",ID,"Home Page - Find A Retail Label"),
	txtBoxEnterzipCode("//input[@placeholder='Enter your zip code']",XPATH,"Home Page - Find A Retailer Section - Text Box - Enter your zip code"),
	btnFindARetailer("footer-find-a-retailer-button",ID,"Home Page - serch Retailer button"),
	
	// Store Locator
	titleStoreLocator("//h1[@class='page-title']/span",XPATH,"Store Locator Page - Title - Store Locator"),
	titleSearch("//div[@id='amasty_locator_filter']/div/div/strong/span",XPATH,"Store Locator Page - Title - Search"),
	lblCurrentLocation("//label[@for='amlocator-search-wcb']",XPATH,"Store Locator Page - Label - Current Location"),
	txtBoxCurrentLocation("//input[@name='address']",XPATH,"Store Locator Page - Text Box - Current Location"),
	lblSearchRadius("//label[@for='radius']",XPATH,"Store Locator Page - Label - Search Radius"),
	drpDownSearchRadius("//select[@title='Search Radius']",XPATH,"Store Locator page - Drop Down - Search Radius"),
	btnSearch("//button[@title='Filter']",XPATH,"Store Locator Page - Button - Search"),
	btnLocateNearby("//button[@class='button locateNearBy']",XPATH,"Store Locator Page - Button - Locate Near By"),
	lblFirstStoreName("(//div[@class='location_header'])[1]",XPATH,"Store Locator Page - Store Name"),
	mapArea("//div[@class='amlocator_mapblock']",XPATH,"Store Locator Page - Google Map "),
	
	//logged in
	iconAccount("//span[@class='action toggle active']",XPATH,"Home Page - Header - Account icon"),
	lnkMyAccount("//div[@class='customer-menu']/ul/li[1]/a",XPATH,"Home Page - Header - Account - My Account link"),
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

	private HomePageObjects(String strPropertyValue, ObjectLocator locatorType, String strObjName) {
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
