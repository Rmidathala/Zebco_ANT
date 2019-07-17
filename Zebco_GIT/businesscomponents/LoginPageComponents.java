package businesscomponents;

import java.time.LocalTime;
import java.time.ZoneId;

import org.openqa.selenium.WebElement;

import com.cognizant.craft.ReusableLibrary;
import com.cognizant.craft.ScriptHelper;
import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import componentgroups.CommonFunctions;
import pages.LoginPageObjects;
import pages.MyAccountPageObjects;

public class LoginPageComponents extends ReusableLibrary {



	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public LoginPageComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	CommonFunctions commonFunction = new CommonFunctions(scriptHelper);
	LocalTime liveTime = LocalTime.now(ZoneId.of("America/New_York"));
	WebDriverUtil webdriverutil = new WebDriverUtil(driver);
	
	private WebElement getPageElement(LoginPageObjects pageEnum) {
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
			report.updateTestLog("Login page - get page element",
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
			report.updateTestLog("My Account Page - get page element",
					pageEnum.toString() + " object is not defined or found.", Status.FAIL);
			return null;
		}
	}
	
	
	public void loginToApplication() {
		try {
			String email = dataTable.getData("General_Data" ,"Email");
			String password = dataTable.getData("General_Data", "Password");
			commonFunction.clearAndEnterText(getPageElement(LoginPageObjects.txtBoxEmail), email, LoginPageObjects.txtBoxEmail.getObjectname());
			commonFunction.clearAndEnterText(getPageElement(LoginPageObjects.txtBoxPassword), password, LoginPageObjects.txtBoxPassword.getObjectname());
			commonFunction.clickIfElementPresent(getPageElement(LoginPageObjects.btnSignIn), LoginPageObjects.btnSignIn.getObjectname());
			if(commonFunction.isElementPresentContainsText(getPageElement(MyAccountPageObjects.titleMyAccount), MyAccountPageObjects.titleMyAccount.getObjectname(), "My Account")) {
				report.updateTestLog("Verify user is logged in successfully",
						"User is logged in successfully", Status.PASS);
			} else {
				report.updateTestLog("Verify user is logged in successfully",
						"User is NOT logged", Status.FAIL);
			}
		}catch(Exception e) {
			report.updateTestLog("Login to the Application", "Something went wrong!" + e.toString(),
					Status.FAIL);
		}
	}
}
