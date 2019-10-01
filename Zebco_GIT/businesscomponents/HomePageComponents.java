package businesscomponents;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import componentgroups.CommonFunctions;
import pages.HomePageObjects;
import pages.MyAccountPageObjects;


public class HomePageComponents extends ReusableLibrary {



		/**
		 * Constructor to initialize the component library
		 * 
		 * @param scriptHelper
		 *            The {@link ScriptHelper} object passed from the
		 *            {@link DriverScript}
		 */
		public HomePageComponents(ScriptHelper scriptHelper) {
			super(scriptHelper);
		}

		CommonFunctions commonFunction = new CommonFunctions(scriptHelper);
		LocalTime liveTime = LocalTime.now(ZoneId.of("America/New_York"));
		WebDriverUtil webdriverutil = new WebDriverUtil(driver);
		
		private WebElement getPageElement(HomePageObjects pageEnum) {
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
		
		public void invokeApplication() {
			try {

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				String applicationURL = dataTable.getData("General_Data", "ApplicationURL");
				driver.get(applicationURL);

				report.updateTestLog("Invoke Application", "Invoked the application under test @ " + applicationURL,
						Status.DONE);
				System.out.println("Application is launched....");
			} catch (Exception e) {
				e.printStackTrace();
				report.updateTestLog("Invoke Application", "Unable to Launch the Application" + e.toString(),
						Status.WARNING);
			}
		}
		
		public void verifyHeaderLinkNavigation() {
			try {
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lnkHeaderCombos),
						HomePageObjects.lnkHeaderCombos.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lnkHeaderReels),
						HomePageObjects.lnkHeaderReels.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lnkHeaderRods),
						HomePageObjects.lnkHeaderRods.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lnkHeaderMore),
						HomePageObjects.lnkHeaderMore.getObjectname());
				
				// Validate Combos link
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderCombos),
						HomePageObjects.lnkHeaderCombos.getObjectname());
				if (driver.getCurrentUrl().contains("/fishing-combos")|| driver.getCurrentUrl().contains("/combos")) {
					report.updateTestLog("Verify Navigation Menu link -Combos",
							"User is successfully Navigated to Combos Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation Menu link -Combos",
							"User is NOT Navigated to Combos Page", Status.FAIL);
				}
				driver.navigate().back();
				
				// Validate Reels link
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderReels),
						HomePageObjects.lnkHeaderReels.getObjectname());
				if (driver.getCurrentUrl().contains("/fishing-reels") || driver.getCurrentUrl().contains("/reels")) {
					report.updateTestLog("Verify Navigation Menu link -Reels",
							"User is successfully Navigated to Reels Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation Menu link -Reels",
							"User is NOT Navigated to Reels Page", Status.FAIL);
				}
				driver.navigate().back();
				
				// Validate Rods link
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderRods),
						HomePageObjects.lnkHeaderRods.getObjectname());
				if (driver.getCurrentUrl().contains("/fishing-rods") || driver.getCurrentUrl().contains("/rods")) {
					report.updateTestLog("Verify Navigation Menu link -Rods",
							"User is successfully Navigated to Fising Rods Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation Menu link -Fising Rods",
							"User is NOT Navigated to Fising Rods Page", Status.FAIL);
				}
				driver.navigate().back();
				
				// Validate More link
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderMore),
						HomePageObjects.lnkHeaderMore.getObjectname());
				if (driver.getCurrentUrl().contains("/more")) {
					report.updateTestLog("Verify Navigation Menu link -More",
							"User is successfully Navigated to More Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation Menu link -More",
							"User is NOT Navigated to More Page", Status.FAIL);
				}
			}catch(Exception e) {
				report.updateTestLog("Home Page - Navigation Menu and header logo", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void validateFooterLinksDisplayed() {
			try {
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.footerColAbout));
				
				//Footer Column headings
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColAbout),
						HomePageObjects.footerColAbout.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footercolMyOrder),
						HomePageObjects.footercolMyOrder.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColSupport),
						HomePageObjects.footerColSupport.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColCotactUs),
						HomePageObjects.footerColCotactUs.getObjectname());
				//Footer - About Links
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColAboutLnkZebcoHeritage),
						HomePageObjects.footerColAboutLnkZebcoHeritage.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColAboutLnkCareers),
						HomePageObjects.footerColAboutLnkCareers.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColAboutLnkResourceCenter),
						HomePageObjects.footerColAboutLnkResourceCenter.getObjectname());
				//Footer - My Order Links
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColMyOrderLnkTrackOrder),
						HomePageObjects.footerColMyOrderLnkTrackOrder.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColMyOrderLnkProductRegistration),
						HomePageObjects.footerColMyOrderLnkProductRegistration.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColMyOrderLnkShippingPolicy),
						HomePageObjects.footerColMyOrderLnkShippingPolicy.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColMyOrderLnkReturnsExchanges),
						HomePageObjects.footerColMyOrderLnkReturnsExchanges.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColMyOrderLnkWarrentyInformation),
						HomePageObjects.footerColMyOrderLnkWarrentyInformation.getObjectname());
				//Footer - Support links
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColSupportLnkFaq),
						HomePageObjects.footerColSupportLnkFaq.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColSupportLnkTipsMaintainance),
						HomePageObjects.footerColSupportLnkTipsMaintainance.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColSupportLnkTroubleShooting),
						HomePageObjects.footerColSupportLnkTroubleShooting.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColSupportLnkFindAServiceCenter),
						HomePageObjects.footerColSupportLnkFindAServiceCenter.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColSupportLnkFindARetailer),
						HomePageObjects.footerColSupportLnkFindARetailer.getObjectname());
				//Foooter - Contact Us links
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColContactUsPhoneNumber),
						HomePageObjects.footerColContactUsPhoneNumber.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColContactUsSendAnEmail),
						HomePageObjects.footerColContactUsSendAnEmail.getObjectname());
			}catch(Exception e) {
				report.updateTestLog("Home Page - Validate Footer links displayed", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void validateFooterlinks() {
			try {
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				
				//Footer Column headings
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColAbout),
						HomePageObjects.footerColAbout.getObjectname());
				
				// Validate Zebco Heritage link
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.footerColAboutLnkZebcoHeritage),
						HomePageObjects.footerColAboutLnkZebcoHeritage.getObjectname());
				if (driver.getCurrentUrl().contains("/about-us/history")) {
					report.updateTestLog("Verify Navigation to Footer - About Us - zeboco Heritage Page",
							"User is successfully Navigated to Footer - About Us - zeboco Heritage Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Footer - About Us - zeboco Heritage Page",
							"User is NOT Navigated to Footer - About Us - zeboco Heritage Page", Status.FAIL);
				}
				// Validate Careers link
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				footerCareersValidation();
				//Validate Resource Center
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.footerColAboutLnkResourceCenter),
						HomePageObjects.footerColAboutLnkResourceCenter.getObjectname());
				if (driver.getCurrentUrl().contains("/resource-center")) {
					report.updateTestLog("Verify Navigation to Footer - About Us - Resource Center Page",
							"User is successfully Navigated to Footer - About Us - Resource Center Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Footer - About Us - Resource Center Page",
							"User is NOT Navigated to Footer - About Us - Resource Center Page", Status.FAIL);
				}
				
				//Footer Column headings
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footercolMyOrder),
						HomePageObjects.footercolMyOrder.getObjectname());
				//Validate Resource Center
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.footerColMyOrderLnkTrackOrder),
						HomePageObjects.footerColMyOrderLnkTrackOrder.getObjectname());
				if (driver.getCurrentUrl().contains("/orderlookup")) {
					report.updateTestLog("Verify Navigation to Footer - My Order - Track Order Page",
							"User is successfully Navigated to Footer - My Order - Track Order Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Footer - My Order - Track Order Page",
							"User is NOT Navigated to Footer - My Order - Track Order Page", Status.FAIL);
				}
				
				//Validate Product Registration
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.footerColMyOrderLnkProductRegistration),
						HomePageObjects.footerColMyOrderLnkProductRegistration.getObjectname());
				if (driver.getCurrentUrl().contains("/product-registration")) {
					report.updateTestLog("Verify Navigation to Footer - My Order - Product Registration Page",
							"User is successfully Navigated to Footer - My Order - Product Registration Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Footer - My Order - Product Registration Page",
							"User is NOT Navigated to Footer - My Order - Product Registration Page", Status.FAIL);
				}
				
				//Validate Shipping Policy
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.footerColMyOrderLnkShippingPolicy),
						HomePageObjects.footerColMyOrderLnkShippingPolicy.getObjectname());
				if (driver.getCurrentUrl().contains("/shipping-policy")) {
					report.updateTestLog("Verify Navigation to Footer - My Order - Shipping Policy Page",
							"User is successfully Navigated to Footer - My Order - Shipping Policy Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Footer - My Order - Shipping policy Page",
							"User is NOT Navigated to Footer - My Order - Shipping Policy Page", Status.FAIL);
				}
				
				//Validate Returns and Exchanges
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.footerColMyOrderLnkReturnsExchanges),
						HomePageObjects.footerColMyOrderLnkReturnsExchanges.getObjectname());
				if (driver.getCurrentUrl().contains("/returns-exchanges")) {
					report.updateTestLog("Verify Navigation to Footer - My Order - Returns and Exchanges Page",
							"User is successfully Navigated to Footer - My Order - Returns and Exchanges Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Footer - My Order - Returns and Exchanges Page",
							"User is NOT Navigated to Footer - My Order - Returns and Exchanges Page", Status.FAIL);
				}
				
				//Validate Warrenty Information
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.footerColMyOrderLnkWarrentyInformation),
						HomePageObjects.footerColMyOrderLnkWarrentyInformation.getObjectname());
				if (driver.getCurrentUrl().contains("/warranty")) {
					report.updateTestLog("Verify Navigation to Footer - My Order - Warrenty Information Page",
							"User is successfully Navigated to Footer - My Order - Warrenty Information Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Footer - My Order - Warrenty Information Page",
							"User is NOT Navigated to Footer - My Order - Warrenty Information Page", Status.FAIL);
				}
				
				//Footer Column headings
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColSupport),
						HomePageObjects.footerColSupport.getObjectname());
				//Validate FAQ Page
				
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.footerColSupportLnkFaq),
						HomePageObjects.footerColSupportLnkFaq.getObjectname());
				if (driver.getCurrentUrl().contains("/faqs")) {
					report.updateTestLog("Verify Navigation to Footer - Support - FAQ Page",
							"User is successfully Navigated to Footer - Support - FAQ Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Footer - Support - FAQ Page",
							"User is NOT Navigated to Footer - Support - FAQ Page", Status.FAIL);
				}
				
				//Validate Tips & Maintenance
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.footerColSupportLnkTipsMaintainance),
						HomePageObjects.footerColSupportLnkTipsMaintainance.getObjectname());
				if (driver.getCurrentUrl().contains("/tips-maintenance")) {
					report.updateTestLog("Verify Navigation to Footer - Support - Tips & Maintenance Page",
							"User is successfully Navigated to Footer - Support - Tips & Maintenance Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Footer - Support - Tips & Maintenance Page",
							"User is NOT Navigated to Footer - Support - Tips & Maintenance Page", Status.FAIL);
				}
				
				//Validate Trouble Shooting Page
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.footerColSupportLnkTroubleShooting),
						HomePageObjects.footerColSupportLnkTroubleShooting.getObjectname());
				if (driver.getCurrentUrl().contains("/troubleshooting")) {
					report.updateTestLog("Verify Navigation to Footer - Support -  Trouble Shooting Page",
							"User is successfully Navigated to Footer - Support -  Trouble Shooting Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Footer - Support -  Trouble Shooting Page",
							"User is NOT Navigated to Footer - Support -  Trouble Shooting Page", Status.FAIL);
				}
				
				//Validate Find a Service Center Page
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.footerColSupportLnkFindAServiceCenter),
						HomePageObjects.footerColSupportLnkFindAServiceCenter.getObjectname());
				if (driver.getCurrentUrl().contains("/service-centers")) {
					report.updateTestLog("Verify Navigation to Footer - Support - Find a Service Page",
							"User is successfully Navigated to Footer - Support - Find a Service Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Footer - Support - Find a Service Page",
							"User is NOT Navigated to Footer - Support - Find a Service Page", Status.FAIL);
				}
				driver.navigate().back();
				//Validate Find a Retailer Page
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.footerColSupportLnkFindARetailer),
						HomePageObjects.footerColSupportLnkFindARetailer.getObjectname());
				if (driver.getCurrentUrl().contains("/retail-locations")) {
					report.updateTestLog("Verify Navigation to Footer - Support - Find a Retailer Page",
							"User is successfully Navigated to Footer - Support - Find a Retailer Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Footer - Support - Find a Retailer Page",
							"User is NOT Navigated to Footer - Support - Find a Retailer Page", Status.FAIL);
				}
				driver.navigate().back();
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				//Footer Column headings
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColCotactUs),
						HomePageObjects.footerColCotactUs.getObjectname());
				
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.footerColContactUsPhoneNumber),
						HomePageObjects.footerColContactUsPhoneNumber.getObjectname());
				//Validate FAQ Page
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblFindARetailer));
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.footerColContactUsSendAnEmail),
						HomePageObjects.footerColContactUsSendAnEmail.getObjectname());
				if (driver.getCurrentUrl().contains("/contact-form")) {
					report.updateTestLog("Verify Navigation to Footer - Contact Us - Send An Email Page",
							"User is successfully Navigated to Footer - Contact Us - Send An Email Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Footer - Contact Us - Send An Email Page",
							"User is NOT Navigated to Footer - Contact Us - Send An Email Page", Status.FAIL);
				}
			}catch(Exception e) {
				report.updateTestLog("Home Page - Validate Footer links ", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
			
		}
		
		public void validateNewsletterFooter() {
			try {
				String email = commonFunction.randomAlphaNumeric(10)+"@rmail.com";
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblNewsletterSignUp));
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lblNewsletterSignUp),
						HomePageObjects.lblNewsletterSignUp.getObjectname());
				commonFunction.clearAndEnterText(getPageElement(HomePageObjects.txtBoxNewletterEmail), email, HomePageObjects.txtBoxNewletterEmail.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.btnGoArrow),
						HomePageObjects.btnGoArrow.getObjectname());
				Thread.sleep(5000);
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.msgSuccessNewsLetter), HomePageObjects.msgSuccessNewsLetter.getObjectname(), "Thank you for your subscription.")){
					report.updateTestLog("Verify user is Subscribed successfully to Newsletter",
							"User is successfully Subscribed to newsletter", Status.PASS);
				} else {
					report.updateTestLog("Verify user is Subscribed successfully to Newsletter",
							"User is NOT Subscribed to newsletter", Status.FAIL);
				}
				
			}catch(Exception e) {
				report.updateTestLog("Home Page - Validate Newsletter sign up", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void validateNewsletterFooterRegisteredEmail() {
			try {
				String email = "automation@rmail.com";
				commonFunction.scrollIntoView(getPageElement(HomePageObjects.lblNewsletterSignUp));
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lblNewsletterSignUp),
						HomePageObjects.lblNewsletterSignUp.getObjectname());
				commonFunction.clearAndEnterText(getPageElement(HomePageObjects.txtBoxNewletterEmail), email, HomePageObjects.txtBoxNewletterEmail.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.btnGoArrow),
						HomePageObjects.btnGoArrow.getObjectname());
				Thread.sleep(8000);
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.msgSuccessNewsLetter), HomePageObjects.msgSuccessNewsLetter.getObjectname(), "There was a problem with the subscription: This email address is already subscribed.")){
					report.updateTestLog("Verify error message: There was a problem with the subscription: This email address is already subscribed. is displayed on subscribing already subscribed email address",
							"Error message is displayed for already subscribed Email Address", Status.PASS);
				} else {
					report.updateTestLog("Verify error message: There was a problem with the subscription: This email address is already subscribed. is displayed on subscribing already subscribed email address",
							"Error message is NOT displayed for already subscribed Email Address", Status.FAIL);
				}
				
			}catch(Exception e) {
				report.updateTestLog("Home Page - Validate Newsletter sign up for already registered email", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		
		public void footerCareersValidation() {
			try {
				String mainWindow = "";
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.footerColAboutLnkCareers),
						HomePageObjects.footerColAboutLnkCareers.getObjectname());
				mainWindow = driver.getWindowHandle();
				driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
				for (int count = 1; count <= 5; count++) {
					if (driver.getCurrentUrl().contains("https://jobs.wcbradley.com/")) {
						report.updateTestLog("Home Page screen - Footer - About Us - Careers Link", "Navigated to Careers link - " + driver.getCurrentUrl(),
								Status.PASS);
						break;
					} else if (count == 5)
						report.updateTestLog("Home Page screen - Footer - About Us - Careers Link","Not Navigated to Careers Page ", Status.FAIL);
					else {
						report.updateTestLog("Home Page screen - Footer - About Us - Careers Link",
								"Not navigated to Careers link in 2 seconds. Will retry in another 2 seconds.",
								Status.DONE);
					}
				}
				driver.close();
				driver.switchTo().window(mainWindow);

			} catch (Exception e) {
				e.printStackTrace();
				report.updateTestLog("Exception in navigating to Careers page", "Exception is " + e.getMessage(),
						Status.FAIL);
			}
		}
		
		public void footerFacebookValidation() {
			try {
				String mainWindow = "";

				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.facebookIcon),
						HomePageObjects.facebookIcon.getObjectname());
				mainWindow = driver.getWindowHandle();
				driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
				for (int count = 1; count <= 5; count++) {
					if (driver.getCurrentUrl().contains("https://www.facebook.com/ZebcoFishing")) {
						report.updateTestLog("Home Page screen", "Navigated to facebook link - " + driver.getCurrentUrl(),
								Status.PASS);
						break;
					} else if (count == 5)
						report.updateTestLog("Home Page screen", "Not navigated to facebook link.", Status.FAIL);
					else {
						report.updateTestLog("Home Page screen",
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

		public void footerTwitterValidation() {
			try {
				String mainWindow = "";

				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.twitterIcon),
						HomePageObjects.twitterIcon.getObjectname());
				mainWindow = driver.getWindowHandle();
				driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
				for (int count = 1; count <= 5; count++) {
					if (driver.getCurrentUrl().contains("https://twitter.com/ZebcoFishing")) {
						report.updateTestLog("Home Page screen", "Navigated to Twitter link - " + driver.getCurrentUrl(),
								Status.PASS);
						break;
					} else if (count == 5)
						report.updateTestLog("Home Page screen", "Not navigated to Twitter link.", Status.FAIL);
					else {
						report.updateTestLog("Home Page screen",
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


		public void footerInstagramValidation() {
			try {
				String mainWindow = "";

				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.instagramIcon),
						HomePageObjects.instagramIcon.getObjectname());
				mainWindow = driver.getWindowHandle();
				driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
				for (int count = 1; count <= 5; count++) {
					if (driver.getCurrentUrl().contains("https://www.instagram.com/zebcofishing/")) {
						report.updateTestLog("Home Page screen", "Navigated to Instagram link - " + driver.getCurrentUrl(),
								Status.PASS);
						break;
					} else if (count == 5)
						report.updateTestLog("Home Page screen", "Not navigated to Instagram link.", Status.FAIL);
					else {
						report.updateTestLog("Home Page screen",
								"Not navigated to Instagram link in 2 seconds. Will retry in another 2 seconds.",
								Status.DONE);
					}
				}
				driver.close();
				driver.switchTo().window(mainWindow);

			} catch (Exception e) {
				e.printStackTrace();
				report.updateTestLog("Exception in navigating to Instagram page", "Exception is " + e.getMessage(),
						Status.FAIL);
			}
		}

		public void footerYoutubeValidation() {
			try {
				String mainWindow = "";

				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.youtubeIcon),
						HomePageObjects.youtubeIcon.getObjectname());
				mainWindow = driver.getWindowHandle();
				driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
				for (int count = 1; count <= 5; count++) {
					if (driver.getCurrentUrl().contains("https://www.youtube.com/c/ZebcoFishing")) {
						report.updateTestLog("Home Page screen", "Navigated to Youtube link - " + driver.getCurrentUrl(),
								Status.PASS);
						break;
					} else if (count == 5)
						report.updateTestLog("Home Page screen", "Not navigated to Youtube link.", Status.FAIL);
					else {
						report.updateTestLog("Home Page screen",
								"Not navigated to Youtube link in 2 seconds. Will retry in another 2 seconds.",
								Status.DONE);
					}
				}
				driver.close();
				driver.switchTo().window(mainWindow);

			} catch (Exception e) {
				e.printStackTrace();
				report.updateTestLog("Exception in navigating to Youtube page", "Exception is " + e.getMessage(),
						Status.FAIL);
			}
		}

		/*
		 * Method for validating social media links at footer
		 */
		public void validateSocialMediaLinksFooter() {
			try {
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lblConnectWithUS),
						HomePageObjects.lblConnectWithUS.getObjectname());
				footerTwitterValidation();
				footerFacebookValidation();
				footerInstagramValidation();
				footerYoutubeValidation();
			} catch (Exception e) {
				report.updateTestLog("Exception in validateSocialMediaLinksFooter", "Exception is " + e.getMessage(),
						Status.FAIL);
			}
		}

		public void validateBodyCopyLinks() {
			try {
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkSiteMap),
						HomePageObjects.lnkSiteMap.getObjectname());
				if (driver.getCurrentUrl().contains("/sitemap")) {
					report.updateTestLog("Verify User navigated to Site Map Page",
							"User is successfully navigated to Site Map  page", Status.PASS);
				} else {
					report.updateTestLog("Verify User navigated to Site Map  Page",
							"User is NOT navigated to Site Map  page", Status.FAIL);
				}
				
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkPrivacyPolicy),
						HomePageObjects.lnkPrivacyPolicy.getObjectname());
				if (driver.getCurrentUrl().contains("/privacy")) {
					report.updateTestLog("Verify User navigated to Privacy Policy Page",
							"User is successfully navigated to Privacy Policy page", Status.PASS);
				} else {
					report.updateTestLog("Verify User navigated to Privacy Policy Page",
							"User is NOT navigated to Privacy Policy page", Status.FAIL);
				}

				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkTermsOfUse),
						HomePageObjects.lnkTermsOfUse.getObjectname());
				if (driver.getCurrentUrl().contains("/terms-of-use")) {
					report.updateTestLog("Verify User navigated to Terms of Use Page",
							"User is successfully navigated to Terms of Use  page", Status.PASS);
				} else {
					report.updateTestLog("Verify User navigated to Terms of Use  Page",
							"User is NOT navigated to Terms of Use  page", Status.FAIL);
				}

				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkCASupplyChainAct),
						HomePageObjects.lnkCASupplyChainAct.getObjectname());
				if (driver.getCurrentUrl().contains("/supply-chain-act")) {
					report.updateTestLog("Verify User navigated to CA Supply Chains Act Page",
							"User is successfully navigated to CA Supply Chains Act  page", Status.PASS);
				} else {
					report.updateTestLog("Verify User navigated to CA Supply Chains Act  Page",
							"User is NOT navigated to CA Supply Chains Act  page", Status.FAIL);
				}

				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkAccessibility),
						HomePageObjects.lnkAccessibility.getObjectname());
				if (driver.getCurrentUrl().contains("/accessibility")) {
					report.updateTestLog("Verify User navigated to Accessibility Statement Page",
							"User is successfully navigated to Accessibility Statement page", Status.PASS);
				} else {
					report.updateTestLog("Verify User navigated to Accessibility Statement  Page",
							"User is NOT navigated to Accessibility Statement  page", Status.FAIL);
				}

				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lblCopyRight),
						HomePageObjects.lblCopyRight.getObjectname());
			} catch (Exception e) {
				report.updateTestLog("Body and Copy Links -  Validation", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		public void validateValidSearch() {
			try {
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.txtBoxSearch),
						HomePageObjects.txtBoxSearch.getObjectname());
				commonFunction.clearAndEnterText(getPageElement(HomePageObjects.txtBoxSearch), "reels", HomePageObjects.txtBoxSearch.getObjectname());
				commonFunction.hitEnterKey(getPageElement(HomePageObjects.txtBoxSearch),
						HomePageObjects.txtBoxSearch.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.navSearchResults),
						HomePageObjects.navSearchResults.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.titleSearchResults),
						HomePageObjects.titleSearchResults.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.searchResultsProducts),
						HomePageObjects.searchResultsProducts.getObjectname());
			}catch(Exception e) {
				report.updateTestLog("Home Page - Valid Search Results validation", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void validateInvalidSearch() {
			try {
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.txtBoxSearch),
						HomePageObjects.txtBoxSearch.getObjectname());
				commonFunction.clearAndEnterText(getPageElement(HomePageObjects.txtBoxSearch), "123243#$#", HomePageObjects.txtBoxSearch.getObjectname());
				commonFunction.hitEnterKey(getPageElement(HomePageObjects.txtBoxSearch),
						HomePageObjects.txtBoxSearch.getObjectname());
				Thread.sleep(3000);
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.msgNoSearchResults),
						HomePageObjects.msgNoSearchResults.getObjectname());
			}catch(Exception e) {
				report.updateTestLog("Home Page - Invalid Search Results validation", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void navigateToCombos() {
			try {
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderCombos),
						HomePageObjects.lnkHeaderCombos.getObjectname());
				if (driver.getCurrentUrl().contains("/fishing-combos") || driver.getCurrentUrl().contains("/combos")) {
					report.updateTestLog("Verify Navigation Menu link -Combos",
							"User is successfully Navigated to Combos Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation Menu link -Combos",
							"User is NOT Navigated to Combos Page", Status.FAIL);
				}
			}catch(Exception e) {
				report.updateTestLog("Navigate to Combos Page", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		public void navigateToReels() {
			try {
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderReels),
						HomePageObjects.lnkHeaderReels.getObjectname());
				if (driver.getCurrentUrl().contains("/reels")) {
					report.updateTestLog("Verify Navigation Menu link -Combos",
							"User is successfully Navigated to Combos Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation Menu link -Combos",
							"User is NOT Navigated to Combos Page", Status.FAIL);
				}
			}catch(Exception e) {
				report.updateTestLog("Navigate to Combos Page", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		public void validateZebcoLogo() {
			try {
				if(driver.getCurrentUrl().contains("mcstaging")) {
					commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.zebcoLogoSTG),
							HomePageObjects.zebcoLogoSTG.getObjectname());
				} else {
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.zeboLogo),
						HomePageObjects.zeboLogo.getObjectname());
				}
			}catch(Exception e) {
				report.updateTestLog("Home Page -Validate Zebco Icon", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void validateHomePageTopLinks() {
			try {
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.iconFindRetailers),
						HomePageObjects.iconFindRetailers.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.iconLogin),
						HomePageObjects.iconLogin.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.iconMyCart),
						HomePageObjects.iconMyCart.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.iconFindRetailers),
						HomePageObjects.iconFindRetailers.getObjectname());
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblStoreLocator), HomePageObjects.lblStoreLocator.getObjectname(), "Store locator") && driver.getCurrentUrl().contains("/retail-locations/")) {
					report.updateTestLog("Verify Navigation to Top Link - Find Retailers",
							"User is successfully Navigated to Find Retailers Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Top Link - Find Retailers",
							"User is NOT Navigated to Find Retailers Page", Status.FAIL);
				}
				
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.iconLogin),
						HomePageObjects.iconLogin.getObjectname());
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblCustomerLogin), HomePageObjects.lblCustomerLogin.getObjectname(), "Customer Login") && driver.getCurrentUrl().contains("/customer/account/login/")) {
					report.updateTestLog("Verify Navigation to Top Link - Customer Login Page",
							"User is successfully Navigated to Customer Login Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Top Link - Customer Login Page",
							"User is NOT Navigated to Customer Login Page", Status.FAIL);
				}
				

			}catch(Exception e) {
				report.updateTestLog("Home Page - Zebco Top link validation", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void validateCombosSubLinks_STG() {
			try {
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderCombos), HomePageObjects.lnkHeaderCombos.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderCombosSubLinkSpinCast),
						HomePageObjects.lnkHeaderCombosSubLinkSpinCast.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblSpincast), HomePageObjects.lblSpincast.getObjectname(), "Spincast") && driver.getCurrentUrl().contains("/combos/spincast")) {
					report.updateTestLog("Verify Navigation to Combos Sub link - Spincast page",
							"User is successfully Navigated to Combos Sub link - Spincast page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Combos Sub link - Spincast page",
							"User is NOT Navigated to Combos Sub link - Spincast page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderCombos), HomePageObjects.lnkHeaderCombos.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderCombosSubLinkSpinning),
						HomePageObjects.lnkHeaderCombosSubLinkSpinning.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblSpinning), HomePageObjects.lblSpinning.getObjectname(), "Spinning") && driver.getCurrentUrl().contains("/combos/spinning")) {
					report.updateTestLog("Verify Navigation to Combos Sub link - Spinning page",
							"User is successfully Navigated to Combos Sub link - Spinning page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Combos Sub link - Spinning page",
							"User is NOT Navigated to Combos Sub link - Spinning page", Status.FAIL);
				}
				
						
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderCombos), HomePageObjects.lnkHeaderCombos.getObjectname());
				
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderCombosSublinkOtherSublinkBaitCast),
						HomePageObjects.lnkHeaderCombosSublinkOtherSublinkBaitCast.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblBaitcast), HomePageObjects.lblBaitcast.getObjectname(), "Baitcast") && driver.getCurrentUrl().contains("/combos/baitcast")) {
					report.updateTestLog("Verify Navigation to Combos Sub link - Sub-Sublink other - BaitCast Page",
							"User is successfully Navigated to Combos Sub link - Sub-Sublink other - BaitCast Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Combos Sub link - Sub-Sublink other - BaitCast Page",
							"User is NOT Navigated to Combos Sub link - Sub-Sublink other - BaitCast Page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderCombos), HomePageObjects.lnkHeaderCombos.getObjectname());
				
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderCombosSublinkOtherSublinkFly),
						HomePageObjects.lnkHeaderCombosSublinkOtherSublinkFly.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblFly), HomePageObjects.lblFly.getObjectname(), "Fly") && driver.getCurrentUrl().contains("/combos/fly")) {
					report.updateTestLog("Verify Navigation to Combos Sub link - Sub-Sublink other - Fly Page",
							"User is successfully Navigated to Combos Sub link - Sub-Sublink other - Fly Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Combos Sub link - Sub-Sublink other - Fly Page",
							"User is NOT Navigated to Combos Sub link - Sub-Sublink other - Fly Page", Status.FAIL);
				}
			}catch(Exception e) {
				report.updateTestLog("Home Page - Combos Sub link validation", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void validateCombosSubLinks() {
			try {
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderCombos), HomePageObjects.lnkHeaderCombos.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderCombosSubLinkSpinCast),
						HomePageObjects.lnkHeaderCombosSubLinkSpinCast.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblSpincast), HomePageObjects.lblSpincast.getObjectname(), "Spincast") && driver.getCurrentUrl().contains("/fishing-combos/spincast")) {
					report.updateTestLog("Verify Navigation to Combos Sub link - Spincast page",
							"User is successfully Navigated to Combos Sub link - Spincast page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Combos Sub link - Spincast page",
							"User is NOT Navigated to Combos Sub link - Spincast page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderCombos), HomePageObjects.lnkHeaderCombos.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderCombosSubLinkSpinning),
						HomePageObjects.lnkHeaderCombosSubLinkSpinning.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblSpinning), HomePageObjects.lblSpinning.getObjectname(), "Spinning") && driver.getCurrentUrl().contains("/fishing-combos/spinning")) {
					report.updateTestLog("Verify Navigation to Combos Sub link - Spinning page",
							"User is successfully Navigated to Combos Sub link - Spinning page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Combos Sub link - Spinning page",
							"User is NOT Navigated to Combos Sub link - Spinning page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderCombos), HomePageObjects.lnkHeaderCombos.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderCombosSubLinkTriggerSpin),
						HomePageObjects.lnkHeaderCombosSubLinkTriggerSpin.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblTriggerSpin), HomePageObjects.lblTriggerSpin.getObjectname(), "Triggerspin") && driver.getCurrentUrl().contains("/fishing-combos/triggerspin")) {
					report.updateTestLog("Verify Navigation to Combos Sub link - Triggerspin page",
							"User is successfully Navigated to Combos Sub link - Triggerspin page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Combos Sub link - Triggerspin page",
							"User is NOT Navigated to Combos Sub link - Triggerspin page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderCombos), HomePageObjects.lnkHeaderCombos.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderComboSublinkOther),
						HomePageObjects.lnkHeaderComboSublinkOther.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblOther), HomePageObjects.lblOther.getObjectname(), "Other") && driver.getCurrentUrl().contains("/fishing-combos/other")) {
					report.updateTestLog("Verify Navigation to Combos Sub link - Other page",
							"User is successfully Navigated to Combos Sub link - Other page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Combos Sub link - Other page",
							"User is NOT Navigated to Combos Sub link - Other page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderCombos), HomePageObjects.lnkHeaderCombos.getObjectname());
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderComboSublinkOther), HomePageObjects.lnkHeaderComboSublinkOther.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderCombosSublinkOtherSublinkBaitCast),
						HomePageObjects.lnkHeaderCombosSublinkOtherSublinkBaitCast.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblBaitcast), HomePageObjects.lblBaitcast.getObjectname(), "Baitcast") && driver.getCurrentUrl().contains("/fishing-combos/other/baitcast")) {
					report.updateTestLog("Verify Navigation to Combos Sub link - Sub-Sublink other - BaitCast Page",
							"User is successfully Navigated to Combos Sub link - Sub-Sublink other - BaitCast Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Combos Sub link - Sub-Sublink other - BaitCast Page",
							"User is NOT Navigated to Combos Sub link - Sub-Sublink other - BaitCast Page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderCombos), HomePageObjects.lnkHeaderCombos.getObjectname());
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderComboSublinkOther), HomePageObjects.lnkHeaderComboSublinkOther.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderCombosSublinkOtherSublinkFly),
						HomePageObjects.lnkHeaderCombosSublinkOtherSublinkFly.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblFly), HomePageObjects.lblFly.getObjectname(), "Fly") && driver.getCurrentUrl().contains("/fishing-combos/other/fly")) {
					report.updateTestLog("Verify Navigation to Combos Sub link - Sub-Sublink other - Fly Page",
							"User is successfully Navigated to Combos Sub link - Sub-Sublink other - Fly Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Combos Sub link - Sub-Sublink other - Fly Page",
							"User is NOT Navigated to Combos Sub link - Sub-Sublink other - Fly Page", Status.FAIL);
				}
			}catch(Exception e) {
				report.updateTestLog("Home Page - Combos Sub link validation", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void validateReelsSubLinks() {
			try {
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderReels), HomePageObjects.lnkHeaderReels.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderReelsSublinkSpincast),
						HomePageObjects.lnkHeaderReelsSublinkSpincast.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblReelSpincast), HomePageObjects.lblReelSpincast.getObjectname(), "Spincast") && driver.getCurrentUrl().contains("/fishing-reels/spincast")) {
					report.updateTestLog("Verify Navigation to Reels Sub link - Spincast page",
							"User is successfully Navigated to Reels Sub link - Spincast page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Reels Sub link - Spincast page",
							"User is NOT Navigated to Reels Sub link - Spincast page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderReels), HomePageObjects.lnkHeaderReels.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderReelsSublinkSpinning),
						HomePageObjects.lnkHeaderReelsSublinkSpinning.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblReelSpinning), HomePageObjects.lblReelSpinning.getObjectname(), "Spinning") && driver.getCurrentUrl().contains("/fishing-reels/spinning")) {
					report.updateTestLog("Verify Navigation to Reels Sub link - Spinning page",
							"User is successfully Navigated to Reels Sub link - Spinning page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Reels Sub link - Spinning page",
							"User is NOT Navigated to Reels Sub link - Spinning page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderReels), HomePageObjects.lnkHeaderReels.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderReelsSublinkTriggerSpin),
						HomePageObjects.lnkHeaderReelsSublinkTriggerSpin.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblReelsTriggerSpin), HomePageObjects.lblReelsTriggerSpin.getObjectname(), "Triggerspin") && driver.getCurrentUrl().contains("/fishing-reels/triggerspin")) {
					report.updateTestLog("Verify Navigation to Reels Sub link - Triggerspin page",
							"User is successfully Navigated to Reels Sub link - Triggerspin page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Reels Sub link - Triggerspin page",
							"User is NOT Navigated to Reels Sub link - Triggerspin page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderReels), HomePageObjects.lnkHeaderReels.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderReelsSublinkOther),
						HomePageObjects.lnkHeaderReelsSublinkOther.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblReelOther), HomePageObjects.lblReelOther.getObjectname(), "Other") && driver.getCurrentUrl().contains("/fishing-reels/other")) {
					report.updateTestLog("Verify Navigation to Reels Sub link - Other page",
							"User is successfully Navigated to Reels Sub link - Other page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Reels Sub link - Other page",
							"User is NOT Navigated to Reels Sub link - Other page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderReels), HomePageObjects.lnkHeaderReels.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderReelsSublinkConventional),
						HomePageObjects.lnkHeaderReelsSublinkConventional.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblReelConventional), HomePageObjects.lblReelConventional.getObjectname(), "Conventional") && driver.getCurrentUrl().contains("/fishing-reels/conventional")) {
					report.updateTestLog("Verify Navigation to Reels Sub link - Conventional Page",
							"User is successfully Navigated to Reels Sub link - Conventional Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Reels Sub link - Conventional Page",
							"User is NOT Navigated to Reels Sub link - Conventional Page", Status.FAIL);
				}
				
				
			}catch(Exception e) {
				report.updateTestLog("Home Page - Reels Sub link validation", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void validateReelsSubLinks_STG() {
			try {
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderReels), HomePageObjects.lnkHeaderReels.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderReelsSublinkSpincast),
						HomePageObjects.lnkHeaderReelsSublinkSpincast.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblReelSpincast), HomePageObjects.lblReelSpincast.getObjectname(), "Spincast") && driver.getCurrentUrl().contains("/reels/spincast")) {
					report.updateTestLog("Verify Navigation to Reels Sub link - Spincast page",
							"User is successfully Navigated to Reels Sub link - Spincast page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Reels Sub link - Spincast page",
							"User is NOT Navigated to Reels Sub link - Spincast page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderReels), HomePageObjects.lnkHeaderReels.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderReelsSublinkSpinning),
						HomePageObjects.lnkHeaderReelsSublinkSpinning.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblReelSpinning), HomePageObjects.lblReelSpinning.getObjectname(), "Spinning") && driver.getCurrentUrl().contains("/reels/spinning")) {
					report.updateTestLog("Verify Navigation to Reels Sub link - Spinning page",
							"User is successfully Navigated to Reels Sub link - Spinning page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Reels Sub link - Spinning page",
							"User is NOT Navigated to Reels Sub link - Spinning page", Status.FAIL);
				}
				
						
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderReels), HomePageObjects.lnkHeaderReels.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderReelsSublinkConventional),
						HomePageObjects.lnkHeaderReelsSublinkConventional.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblReelConventional), HomePageObjects.lblReelConventional.getObjectname(), "Conventional") && driver.getCurrentUrl().contains("/reels/conventional")) {
					report.updateTestLog("Verify Navigation to Reels Sub link - Conventional Page",
							"User is successfully Navigated to Reels Sub link - Conventional Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Reels Sub link - Conventional Page",
							"User is NOT Navigated to Reels Sub link - Conventional Page", Status.FAIL);
				}
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderReels), HomePageObjects.lnkHeaderReels.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderReelSubLinkBaitCast_STG),
						HomePageObjects.lnkHeaderReelSubLinkBaitCast_STG.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblBaitcast), HomePageObjects.lblBaitcast.getObjectname(), "Baitcast") && driver.getCurrentUrl().contains("/reels/baitcast")) {
					report.updateTestLog("Verify Navigation to Reels Sub link -  BaitCast Page",
							"User is successfully Navigated to Reels Sub link -  BaitCast Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Reels Sub link  - BaitCast Page",
							"User is NOT Navigated to Reels Sub link -  BaitCast Page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderReels), HomePageObjects.lnkHeaderReels.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderReelSubLinkFly_STG),
						HomePageObjects.lnkHeaderReelSubLinkFly_STG.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblFly), HomePageObjects.lblFly.getObjectname(), "Fly") && driver.getCurrentUrl().contains("/reels/fly")) {
					report.updateTestLog("Verify Navigation to Reels Sub link - - Fly Page",
							"User is successfully Navigated to Reels Sub link - - Fly Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Reels Sub link - Fly Page",
							"User is NOT Navigated to Reels Sub link -  Fly Page", Status.FAIL);
				}
				
			}catch(Exception e) {
				report.updateTestLog("Home Page - Reels Sub link validation", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void validateRodsSubLinks() {
			try {
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderRods), HomePageObjects.lnkHeaderRods.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderRodsSublinkCasting),
						HomePageObjects.lnkHeaderRodsSublinkCasting.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblRodsCasting), HomePageObjects.lblRodsCasting.getObjectname(), "Casting") && driver.getCurrentUrl().contains("/fishing-rods/casting")) {
					report.updateTestLog("Verify Navigation to Rods Sub link - Casting page",
							"User is successfully Navigated to Rods Sub link - Casting page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Rods Sub link - Casting page",
							"User is NOT Navigated to Rods Sub link - Casting page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderRods), HomePageObjects.lnkHeaderRods.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderRodsSublinkSpinning),
						HomePageObjects.lnkHeaderRodsSublinkSpinning.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblRodsSpinning), HomePageObjects.lblRodsSpinning.getObjectname(), "Spinning") && driver.getCurrentUrl().contains("/fishing-rods/spinning")) {
					report.updateTestLog("Verify Navigation to Rods Sub link - Spinning page",
							"User is successfully Navigated to Rods Sub link - Spinning page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Rods Sub link - Spinning page",
							"User is NOT Navigated to Rods Sub link - Spinning page", Status.FAIL);
				}
				
				
			}catch(Exception e) {
				report.updateTestLog("Home Page - Rods Sub link validation", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void validateRodsSubLinks_STG() {
			try {
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderRods), HomePageObjects.lnkHeaderRods.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderRodsSublinkCasting),
						HomePageObjects.lnkHeaderRodsSublinkCasting.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblRodsCasting), HomePageObjects.lblRodsCasting.getObjectname(), "Casting") && driver.getCurrentUrl().contains("/rods/casting")) {
					report.updateTestLog("Verify Navigation to Rods Sub link - Casting page",
							"User is successfully Navigated to Rods Sub link - Casting page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Rods Sub link - Casting page",
							"User is NOT Navigated to Rods Sub link - Casting page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderRods), HomePageObjects.lnkHeaderRods.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderRodsSublinkSpinning_STG),
						HomePageObjects.lnkHeaderRodsSublinkSpinning_STG.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblRodsSpinning), HomePageObjects.lblRodsSpinning.getObjectname(), "Spinning") && driver.getCurrentUrl().contains("/rods/spinning")) {
					report.updateTestLog("Verify Navigation to Rods Sub link - Spinning page",
							"User is successfully Navigated to Rods Sub link - Spinning page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Rods Sub link - Spinning page",
							"User is NOT Navigated to Rods Sub link - Spinning page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderRods), HomePageObjects.lnkHeaderRods.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderRodsSubLinkSpincast_STG),
						HomePageObjects.lnkHeaderRodsSubLinkSpincast_STG.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblRodsSpincast), HomePageObjects.lblRodsSpincast.getObjectname(), "Spincast") && driver.getCurrentUrl().contains("/rods/spincast")) {
					report.updateTestLog("Verify Navigation to Rods Sub link - Spincast page",
							"User is successfully Navigated to Rods Sub link - Spincast page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Rods Sub link - Spincast page",
							"User is NOT Navigated to Rods Sub link - Spincast page", Status.FAIL);
				}
				
			}catch(Exception e) {
				report.updateTestLog("Home Page - Rods Sub link validation", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void validateMoreSubLinks() {
			try {
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderMore), HomePageObjects.lnkHeaderMore.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderMoreSublinkLine),
						HomePageObjects.lnkHeaderMoreSublinkLine.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblMoreSublinkLine), HomePageObjects.lblMoreSublinkLine.getObjectname(), "Line") && driver.getCurrentUrl().contains("/more/fishing-line")) {
					report.updateTestLog("Verify Navigation to More Sub link - Fishing Line page",
							"User is successfully Navigated to More Sub link - Fishing Line page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to More Sub link - Fishing Line page",
							"User is NOT Navigated to Rods Sub More - Fishing Line page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderMore), HomePageObjects.lnkHeaderMore.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderMoreSublinkAccessories),
						HomePageObjects.lnkHeaderMoreSublinkAccessories.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblMoreSubLineAccessories), HomePageObjects.lblMoreSubLineAccessories.getObjectname(), "Accessories") && driver.getCurrentUrl().contains("/more/accessories")) {
					report.updateTestLog("Verify Navigation to More Sub link - Accessories page",
							"User is successfully Navigated to More Sub link - Accessories page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to More Sub link - Accessories page",
							"User is NOT Navigated to More Sub link - Accessories page", Status.FAIL);
				}
				
				
			}catch(Exception e) {
				report.updateTestLog("Home Page - More Sub link validation", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void validateMoreSubLinks_STG() {
			try {
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderMore), HomePageObjects.lnkHeaderMore.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderMoreSublinkLine),
						HomePageObjects.lnkHeaderMoreSublinkLine.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblMoreSublinkLine_STG), HomePageObjects.lblMoreSublinkLine_STG.getObjectname(), "Line") && driver.getCurrentUrl().contains("/more/line")) {
					report.updateTestLog("Verify Navigation to More Sub link - Fishing Line page",
							"User is successfully Navigated to More Sub link - Fishing Line page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to More Sub link - Fishing Line page",
							"User is NOT Navigated to Rods Sub More - Fishing Line page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderMore), HomePageObjects.lnkHeaderMore.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderMoreSublinkAccessoriesSTG),
						HomePageObjects.lnkHeaderMoreSublinkAccessoriesSTG.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblMoreSubLineAccessories_STG), HomePageObjects.lblMoreSubLineAccessories_STG.getObjectname(), "Accessories") && driver.getCurrentUrl().contains("/more/accessories")) {
					report.updateTestLog("Verify Navigation to More Sub link - Accessories page",
							"User is successfully Navigated to More Sub link - Accessories page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to More Sub link - Accessories page",
							"User is NOT Navigated to More Sub link - Accessories page", Status.FAIL);
				}
				
				commonFunction.mouseOver(getPageElement(HomePageObjects.lnkHeaderMore), HomePageObjects.lnkHeaderMore.getObjectname());
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkHeaderMoreSublinkApparal),
						HomePageObjects.lnkHeaderMoreSublinkApparal.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblMoreSubLineApparal_STG), HomePageObjects.lblMoreSubLineApparal_STG.getObjectname(), "Accessories") && driver.getCurrentUrl().contains("/more/apparel")) {
					report.updateTestLog("Verify Navigation to More Sub link - Apparal page",
							"User is successfully Navigated to More Sub link - Apparal page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to More Sub link - Apparal page",
							"User is NOT Navigated to More Sub link - Apparal page", Status.FAIL);
				}
			}catch(Exception e) {
				report.updateTestLog("Home Page - More Sub link validation", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		
		public void validateAdventureTab() {
			try {
				commonFunction.clickIfElementPresentJavaScript(getPageElement(HomePageObjects.btnStartAnAdventure),
						HomePageObjects.btnStartAnAdventure.getObjectname());	
				
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lblGrabRodAndReel), HomePageObjects.lblGrabRodAndReel.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.msgPickTopicBelow), HomePageObjects.msgPickTopicBelow.getObjectname());
				
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.imgAddFishingToYourAdventure), HomePageObjects.imgAddFishingToYourAdventure.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lnkAddFishingToYourAdventure), HomePageObjects.lnkAddFishingToYourAdventure.getObjectname());
				commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.msgAddFishingToYourAdventure), HomePageObjects.msgAddFishingToYourAdventure.getObjectname(), "Whatever you love to do outdoors, a little fishing only adds to the adventure.");
				
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.imgFishForTheFirstTime), HomePageObjects.imgFishForTheFirstTime.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lnkFishForTheFirstTime), HomePageObjects.lnkFishForTheFirstTime.getObjectname());
				commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.msgFishForTheFirstTime), HomePageObjects.msgFishForTheFirstTime.getObjectname(), "With easy-casting Zebco gear and a few tips, you'll be fishing like a pro in no time.");
				
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.imgTeachSomeoneFishingExample), HomePageObjects.imgTeachSomeoneFishingExample.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lnkTeachSomeoneFishingExample), HomePageObjects.lnkTeachSomeoneFishingExample.getObjectname());
				commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.msgTeachSomeoneFishingExample), HomePageObjects.msgTeachSomeoneFishingExample.getObjectname(), "From \"how-to\" videos to helpful tips for kids, we make it easy to share your love for fishing.");
				
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.imgImproveFishingSkillsExample), HomePageObjects.imgImproveFishingSkillsExample.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lnkImproveFishingSkillsExample), HomePageObjects.lnkImproveFishingSkillsExample.getObjectname());
				commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.msgImproveFishingSkillsExample), HomePageObjects.msgImproveFishingSkillsExample.getObjectname(), "If you've got the basics down, we can show you how to take your fishing skills up a notch.");
				
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkAddFishingToYourAdventure),
						HomePageObjects.lnkAddFishingToYourAdventure.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.titleAddFishingToYourAdventure), HomePageObjects.titleAddFishingToYourAdventure.getObjectname(), "Add Fishing to your Adventure.") && driver.getCurrentUrl().contains("/adventure/add-fishing-to-your-adventure")) {
					report.updateTestLog("Verify Navigation to Add Fishing To Your Adventure Page",
							"User is successfully Navigated to Add Fishing To Your Adventure Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Add Fishing To Your Adventure Page",
							"User is NOT Navigated to Add Fishing To Your Adventure Page", Status.FAIL);
				}
				
				commonFunction.clickIfElementPresentJavaScript(getPageElement(HomePageObjects.btnStartAnAdventure),
						HomePageObjects.btnStartAnAdventure.getObjectname());	
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkFishForTheFirstTime),
						HomePageObjects.lnkFishForTheFirstTime.getObjectname());
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.titleFishForTheFirstTime), HomePageObjects.titleFishForTheFirstTime.getObjectname(), "Fish for the first time.") && driver.getCurrentUrl().contains("/adventure/fish-for-the-first-time")) {
					report.updateTestLog("Verify Navigation to Fish for the first time Page",
							"User is successfully Navigated to Fish for the first time Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Fish for the first time Page",
							"User is NOT Navigated to Fish for the first time Page", Status.FAIL);
				}
				commonFunction.clickIfElementPresentJavaScript(getPageElement(HomePageObjects.btnStartAnAdventure),
						HomePageObjects.btnStartAnAdventure.getObjectname());	
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkTeachSomeoneFishingExample),
						HomePageObjects.lnkTeachSomeoneFishingExample.getObjectname());
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.titleTeachSomeoneFishingExample), HomePageObjects.titleTeachSomeoneFishingExample.getObjectname(), "Teach Someone to Fish.") && driver.getCurrentUrl().contains("/adventure/teach-someone-to-fish")) {
					report.updateTestLog("Verify Navigation to Teach Someone to Fish Page",
							"User is successfully Navigated to Teach Someone to Fish Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Teach Someone to Fish Page",
							"User is NOT Navigated to Teach Someone to Fish Page", Status.FAIL);
				}
				
				commonFunction.clickIfElementPresentJavaScript(getPageElement(HomePageObjects.btnStartAnAdventure),
						HomePageObjects.btnStartAnAdventure.getObjectname());	
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkImproveFishingSkillsExample),
						HomePageObjects.lnkImproveFishingSkillsExample.getObjectname());
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.titleBeABetterAngler), HomePageObjects.titleBeABetterAngler.getObjectname(), "Be a better angler.") && driver.getCurrentUrl().contains("/adventure/be-a-better-angler")) {
					report.updateTestLog("Verify Navigation to Be a better angler Page",
							"User is successfully Navigated to Be a better angler Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Be a better angler Page",
							"User is NOT Navigated to Be a better angler Page", Status.FAIL);
				}
			}catch(Exception e) {
				report.updateTestLog("Home Page - Adventure Tab validation", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		
		}
		
		public void validateAdventureTab_STG() {
			try {
				commonFunction.clickIfElementPresentJavaScript(getPageElement(HomePageObjects.btnStartAnAdventure),
						HomePageObjects.btnStartAnAdventure.getObjectname());	
				
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lblGrabRodAndReel), HomePageObjects.lblGrabRodAndReel.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.msgPickTopicBelow), HomePageObjects.msgPickTopicBelow.getObjectname());
				
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.imgOutFitYourEntourageSTG), HomePageObjects.imgOutFitYourEntourageSTG.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lnkOutFitYourEntourageSTG), HomePageObjects.lnkOutFitYourEntourageSTG.getObjectname());
				commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.msgOutFitYourEntourageSTG), HomePageObjects.msgOutFitYourEntourageSTG.getObjectname(), "Going camping or kayaking? We can show you how easy it is to reel in some good times.");
				
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.imgFishForTheFirstTimeSTG), HomePageObjects.imgFishForTheFirstTimeSTG.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lnkFishForTheFirstTimeSTG), HomePageObjects.lnkFishForTheFirstTimeSTG.getObjectname());
				commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.msgFishForTheFirstTime), HomePageObjects.msgFishForTheFirstTime.getObjectname(), "With easy-casting Zebco gear and a few tips, you'll be fishing like a pro in no time.");
				
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.imgTeachSomeoneFishingExample), HomePageObjects.imgTeachSomeoneFishingExample.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lnkTeachSomeoneFishingExample), HomePageObjects.lnkTeachSomeoneFishingExample.getObjectname());
				commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.msgTeachSomeoneFishingExample), HomePageObjects.msgTeachSomeoneFishingExample.getObjectname(), "From \"how-to\" videos to helpful tips for kids, we make it easy to share your love for fishing.");
				
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.imgImproveFishingSkillsExample), HomePageObjects.imgImproveFishingSkillsExample.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lnkImproveFishingSkillsExample), HomePageObjects.lnkImproveFishingSkillsExample.getObjectname());
				commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.msgImproveFishingSkillsExample), HomePageObjects.msgImproveFishingSkillsExample.getObjectname(), "If you've got the basics down, we can show you how to take your fishing skills up a notch.");
				
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkOutFitYourEntourageSTG),
						HomePageObjects.lnkOutFitYourEntourageSTG.getObjectname());	
				if(commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.titleOutfitYourEntourageSTG), HomePageObjects.titleOutfitYourEntourageSTG.getObjectname())) {
					report.updateTestLog("Verify Navigation to Outfitting guide  Page",
							"User is successfully Navigated to Outfitting guide Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Outfitting guide  Page",
							"User is NOT Navigated to Outfitting guide  Page", Status.FAIL);
				}
				
				commonFunction.clickIfElementPresentJavaScript(getPageElement(HomePageObjects.btnStartAnAdventure),
						HomePageObjects.btnStartAnAdventure.getObjectname());	
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkFishForTheFirstTimeSTG),
						HomePageObjects.lnkFishForTheFirstTimeSTG.getObjectname());
				if(commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.titleFishForTheFirstTimeSTG), HomePageObjects.titleFishForTheFirstTimeSTG.getObjectname())) {
					report.updateTestLog("Verify Navigation to Fish for the first time Page",
							"User is successfully Navigated to Fish for the first time Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Fish for the first time Page",
							"User is NOT Navigated to Fish for the first time Page", Status.FAIL);
				}
				commonFunction.clickIfElementPresentJavaScript(getPageElement(HomePageObjects.btnStartAnAdventure),
						HomePageObjects.btnStartAnAdventure.getObjectname());	
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkTeachSomeoneFishingExample),
						HomePageObjects.lnkTeachSomeoneFishingExample.getObjectname());
				if(commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.titleTeachSomeoneFishingExampleSTG), HomePageObjects.titleTeachSomeoneFishingExampleSTG.getObjectname())) {
					report.updateTestLog("Verify Navigation to Teach Someone to Fish Page",
							"User is successfully Navigated to Teach Someone to Fish Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Teach Someone to Fish Page",
							"User is NOT Navigated to Teach Someone to Fish Page", Status.FAIL);
				}
				
				commonFunction.clickIfElementPresentJavaScript(getPageElement(HomePageObjects.btnStartAnAdventure),
						HomePageObjects.btnStartAnAdventure.getObjectname());	
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkImproveFishingSkillsExample),
						HomePageObjects.lnkImproveFishingSkillsExample.getObjectname());
				if(commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.titleBeABetterAnglerSTG), HomePageObjects.titleBeABetterAnglerSTG.getObjectname())) {
					report.updateTestLog("Verify Navigation to Be a better angler Page",
							"User is successfully Navigated to Be a better angler Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Be a better angler Page",
							"User is NOT Navigated to Be a better angler Page", Status.FAIL);
				}
			}catch(Exception e) {
				report.updateTestLog("Home Page - Adventure Tab validation", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		
		}
		
		
		public void navigateToLoginPage() {
			try {
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.iconLogin), HomePageObjects.iconLogin.getObjectname());
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.lblCustomerLogin), HomePageObjects.lblCustomerLogin.getObjectname(), "Customer Login")) {
					report.updateTestLog("Verify user navigated to Login page",
							"User is successfully Navigated to Login Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Login Page",
							"User is NOT Navigated to Login Page", Status.FAIL);
				}
			}catch(Exception e) {
				report.updateTestLog("Navigate To Login Page", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void validateFindARetailerFunctionality() {
			try {
				String zipcode = dataTable.getData("General_Data", "ZipCode");
				commonFunction.clearAndEnterText(getPageElement(HomePageObjects.txtBoxEnterzipCode), zipcode, HomePageObjects.txtBoxEnterzipCode.getObjectname());
				getPageElement(HomePageObjects.txtBoxEnterzipCode).sendKeys(Keys.ARROW_DOWN);
				commonFunction.hitEnterKey(getPageElement(HomePageObjects.txtBoxEnterzipCode), HomePageObjects.txtBoxEnterzipCode.getObjectname());
				//commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.btnFindARetailer), HomePageObjects.btnFindARetailer.getObjectname());
				if(commonFunction.isElementPresentContainsText(getPageElement(HomePageObjects.titleStoreLocator), HomePageObjects.titleStoreLocator.getObjectname(), "Store locator")) {
					report.updateTestLog("Verify user navigated to Store Locator Page",
							"User is successfully Navigated to Store Locator Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to Store Locator Page",
							"User is NOT Navigated to Store Locator Page", Status.FAIL);
				}	
				
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.titleStoreLocator), HomePageObjects.titleStoreLocator.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.titleSearch), HomePageObjects.titleSearch.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lblCurrentLocation), HomePageObjects.lblCurrentLocation.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.txtBoxCurrentLocation), HomePageObjects.txtBoxCurrentLocation.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lblSearchRadius), HomePageObjects.lblSearchRadius.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.drpDownSearchRadius), HomePageObjects.drpDownSearchRadius.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.btnSearch), HomePageObjects.btnSearch.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.btnLocateNearby), HomePageObjects.btnLocateNearby.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.lblFirstStoreName), HomePageObjects.lblFirstStoreName.getObjectname());
				commonFunction.verifyIfElementIsPresent(getPageElement(HomePageObjects.mapArea), HomePageObjects.mapArea.getObjectname());
			}catch(Exception e) {
				report.updateTestLog("Navigate To Find A Retailer", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void navigateToMyAccountPage() {
			try {
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.iconAccount),
						HomePageObjects.iconAccount.getObjectname());	
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkMyAccount),
						HomePageObjects.lnkMyAccount.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(MyAccountPageObjects.titleMyAccount), MyAccountPageObjects.titleMyAccount.getObjectname(), "My Account")) {
					report.updateTestLog("Verify user navigated to My Account page",
							"User is successfully Navigated to  My Account Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to  My Account Page",
							"User is NOT Navigated to  My Account Page", Status.FAIL);
				}
			}catch(Exception e) {
				report.updateTestLog("Navigate To My Account Page", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
		
		public void navigateToMyAccountPage_STG() {
			try {
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.iconAccount_STG),
						HomePageObjects.iconAccount_STG.getObjectname());	
				commonFunction.clickIfElementPresent(getPageElement(HomePageObjects.lnkMyAccount),
						HomePageObjects.lnkMyAccount.getObjectname());	
				if(commonFunction.isElementPresentContainsText(getPageElement(MyAccountPageObjects.titleMyAccount), MyAccountPageObjects.titleMyAccount.getObjectname(), "My Account")) {
					report.updateTestLog("Verify user navigated to My Account page",
							"User is successfully Navigated to  My Account Page", Status.PASS);
				} else {
					report.updateTestLog("Verify Navigation to  My Account Page",
							"User is NOT Navigated to  My Account Page", Status.FAIL);
				}
			}catch(Exception e) {
				report.updateTestLog("Navigate To My Account Page", "Something went wrong!" + e.toString(),
						Status.FAIL);
			}
		}
}


