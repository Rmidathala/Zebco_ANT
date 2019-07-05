package componentgroups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.CraftDriver;
import com.cognizant.framework.selenium.WebDriverUtil;

import pages.PageObjects;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;

public class CommonFunctions extends ReusableLibrary {

	WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 30);
	WebDriverUtil webdriverutil = new WebDriverUtil(driver);
	public CommonFunctions(ScriptHelper scriptHelper) {
		super(scriptHelper);

	}
	
	/**
	 *********************************************************************
	 * Function to find an element by property NOT defined in the OR file.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A {@link WebElement} object.
	 *************************************************************************
	 */
	public WebElement getElementByProperty(String strObjectProperty, String strFindElementType, boolean displayError) {
		WebElement ele = null;
		try {
			if (strFindElementType.equalsIgnoreCase("CSS")) {
				try {
					ele = wait.until(
							ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(strObjectProperty))));
				} catch (TimeoutException t) {
					System.out.println("Did not find the Element within explicit wait time");
				}
				return ele;
			} else if (strFindElementType.equalsIgnoreCase("XPATH")) {
				try {
					ele = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(strObjectProperty))));
				} catch (TimeoutException t) {
					System.out.println("Did not find the Element within explicit wait time");
				}
				return ele;

			} else if (strFindElementType.equalsIgnoreCase("ID")) {
				try {
					ele = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(strObjectProperty))));
				} catch (TimeoutException t) {
					System.out.println("Did not find the Element within explicit wait time");
				}
				return ele;

			} else if (strFindElementType.equalsIgnoreCase("NAME")) {
				try {
					ele = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(strObjectProperty))));
				} catch (TimeoutException t) {
					System.out.println("Did not find the Element within explicit wait time");
				}
				return ele;

			}

			else if (strFindElementType.equalsIgnoreCase("LINKTEXT")) {
				try {
					ele = wait
							.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(strObjectProperty))));
				} catch (TimeoutException t) {
					System.out.println("Did not find the Element within explicit wait time");
				}
				return ele;

			}

			else if (strFindElementType.equalsIgnoreCase("TAG")) {
				try {
					ele = wait
							.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName(strObjectProperty))));
				} catch (TimeoutException t) {
					System.out.println("Did not find the Element within explicit wait time");
				}
				return ele;
			} else if (strFindElementType.equalsIgnoreCase("CLASSNAME")) {
				try {
					ele = wait
							.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(strObjectProperty))));
				} catch (TimeoutException t) {
					System.out.println("Did not find the Element within explicit wait time");
				}
				return ele;
			} else if (strFindElementType.equalsIgnoreCase("PARTIALLINKTEXT")) {
				try {
					ele = wait
							.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText(strObjectProperty))));
				} catch (TimeoutException t) {
					System.out.println("Did not find the Element within explicit wait time");
				}
				return ele;
			}

			/*
			 * else if (strFindElementType.equalsIgnoreCase("ACCESSIBILITYID")) { try { ele
			 * = wait .until(ExpectedConditions.visibilityOf(driver.getAppiumDriver().
			 * findElementByAccessibilityId(strObjectProperty))); } catch (TimeoutException
			 * t) {
			 * System.out.println("Did not find the Element within explicit wait time"); }
			 * return ele;
			 * 
			 * }
			 */
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			if (displayError) {
				report.updateTestLog("Verify if " + strFindElementType + " - " + strObjectProperty + " is present",
						"Element with property " + strFindElementType + " - " + strObjectProperty + " not found",
						Status.FAIL);
				return null;
			} else
				return null;
		}

		catch (Exception e) {
			report.updateTestLog("Verify if " + strFindElementType + " - " + strObjectProperty + " is present",
					"Element with property " + strFindElementType + " - " + strObjectProperty + " not found",
					Status.FAIL);
			return null;
		}
		return null;
	}

	public WebElement getPageElement(PageObjects pageObject) {
		try {

			WebElement element;
			element = getElementByProperty(pageObject.getProperty(), pageObject.getLocatorType().toString());

			return element;

		} catch (Exception e) {
			report.updateTestLog("get page element - get page element",
					pageObject.toString() + " object is not defined or found.", Status.FAIL);
			return null;
		}
	}

	/**
	 ********************************************************************
	 * Function to enter required data in text field.
	 * 
	 * @param ElementName
	 *            The {@link String} object that contains the page element
	 *            identification variable in OR.
	 * @param Text
	 *            The {@link String} object that contains the string to be entered
	 *            in the text field.
	 * @return void
	 *********************************************************************
	 */

	public boolean enterText(WebElement elemToUpdate, String strValueToUpdate, String strObjName) {

		if (!strValueToUpdate.trim().equalsIgnoreCase("IGNORE")) {
			try {

				updateAnyElement(wait.until(ExpectedConditions.visibilityOf(elemToUpdate)), strValueToUpdate,
						strObjName);
				return true;

			} catch (org.openqa.selenium.NoSuchElementException nsee) {
				report.updateTestLog("UPDATE ANY ELEMENT : " + strObjName,
						strObjName + " object does not exist in page", Status.FAIL);
			} catch (Exception e) {
				report.updateTestLog("UPDATE ANY ELEMENT",
						"Error in finding object - " + strObjName + ". Error Description - " + e.toString(),
						Status.FAIL);
			}
			return false;
		} else
			return true;
	}

	/**
	 ********************************************************************
	 * Function to clear existing text in a field and enter required data.
	 * 
	 * @param ElementName
	 *            The {@link String} object that contains the page element
	 *            identification variable in OR.
	 * @param Text
	 *            The {@link String} object that contains the string to be entered
	 *            in the text field.
	 * @return void
	 *********************************************************************
	 */

	public boolean clearAndEnterText(WebElement elemToUpdate, String strValueToUpdate, String strObjName) {

		// WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(elemToUpdate));
		/*
		 * if(driver.getCapabilities().getBrowserName().contains("IE")) { try {
		 * scrollIntoView(element); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 */
		if (!strValueToUpdate.trim().equalsIgnoreCase("IGNORE")) {
			try {
				if (element.isDisplayed() && element.isEnabled()) {
					element.clear();
					updateAnyElement(element, strValueToUpdate, strObjName);
					return true;
				} else {
					report.updateTestLog("Verify if the Element(" + strObjName + ") is present and update",
							strObjName + " is not enabled", Status.FAIL);
				}
			} catch (org.openqa.selenium.NoSuchElementException nsee) {
				report.updateTestLog("UPDATE ANY ELEMENT : " + strObjName,
						strObjName + " object does not exist in page", Status.FAIL);
			} catch (Exception e) {
				report.updateTestLog("UPDATE ANY ELEMENT",
						"Error in finding object - " + strObjName + ". Error Description - " + e.toString(),
						Status.FAIL);
			}
			return false;
		} else
			return true;
	}

	/**
	 ********************************************************************
	 * Function to clear existing text in a field and enter required data and then
	 * tab out.
	 * 
	 * @param ElementName
	 *            The {@link String} object that contains the page element
	 *            identification variable in OR.
	 * @param Text
	 *            The {@link String} object that contains the string to be entered
	 *            in the text field.
	 * @return void
	 *********************************************************************
	 */
	public boolean clearAndEnterTextTabOut(WebElement elemToUpdate, String strValueToUpdate, String strObjName) {

		// WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(elemToUpdate));

		if (!strValueToUpdate.trim().equalsIgnoreCase("IGNORE")) {
			try {
				if (element.isDisplayed() && element.isEnabled()) {
					element.clear();
					updateAnyElement(element, strValueToUpdate, strObjName);
					try {
						element.sendKeys(Keys.TAB);
					} catch (Exception e) {
						System.out.println(strObjName + " Unable to tab out");
					}
					return true;
				} else {
					report.updateTestLog("Verify if the Element(" + strObjName + ") is present and update",
							strObjName + " is not enabled", Status.FAIL);
				}
			} catch (org.openqa.selenium.NoSuchElementException nsee) {
				report.updateTestLog("UPDATE ANY ELEMENT : " + strObjName,
						strObjName + " object does not exist in page", Status.FAIL);
			} catch (Exception e) {
				report.updateTestLog("UPDATE ANY ELEMENT",
						"Error in finding object - " + strObjName + ". Error Description - " + e.toString(),
						Status.FAIL);
			}
			return false;
		} else
			return true;
	}

	/**
	 ****************************************************************************
	 * Function to Enter text in a given element
	 * 
	 * @param elemToUpdate
	 *            The {@link strObjProperty} element to be updated
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used for
	 *            reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 ***************************************************************************
	 */
	public boolean updateAnyElement(WebElement elemToUpdate, String strValueToUpdate, String strObjName) {

		if (!strValueToUpdate.trim().equalsIgnoreCase("IGNORE")) {
			try {
				if (elemToUpdate.isDisplayed() && elemToUpdate.isEnabled()) {

					elemToUpdate.sendKeys(strValueToUpdate);
					// Thread.sleep(1000);
					if (strObjName.equals("Password")) {
						report.updateTestLog("Verify if the Element(" + strObjName + ") is present and updated",
								strObjName + " is present and updated with value : "
										+ new String(new char[strValueToUpdate.length()]).replace("\0", "*"),
								Status.PASS);
					} else
						report.updateTestLog("Verify if the Element(" + strObjName + ") is present",
								"'" + strObjName + "'" + " is present and entered value : " + strValueToUpdate,
								Status.PASS);
					return true;

				} else {
					report.updateTestLog("Enter value in '" + strObjName + "'", strObjName + " is not enabled",
							Status.FAIL);
				}
			} catch (org.openqa.selenium.NoSuchElementException nsee) {
				report.updateTestLog("UPDATE ANY ELEMENT : " + strObjName,
						strObjName + " object does not exist in page", Status.FAIL);
			} catch (Exception e) {
				report.updateTestLog("Enter text in any ELEMENT",
						"Error in finding object - " + strObjName + ". Error Description - " + e.toString(),
						Status.FAIL);
			}
			return false;
		} else
			return true;
	}

	/**
	 ************************************************************* 
	 * Method to check/uncheck a checkbox based on the given option
	 * 
	 * @param elementToSelect
	 *            The {@link elementToSelect} element to be verified
	 * @param valueToSelect
	 *            The {@link strElemStateToVerify} describes the state to be set
	 *            which can be one of: Y/N
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used for
	 *            reporting purposes.
	 * @return None
	 ************************************************************* 
	 */
	public void clickIfElementPresent(WebElement elementToSelect, String strValueToSelect, String strObjName) {

		// WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementToSelect));
		if(driver.getCapabilities().getBrowserName().contains("IE")) {
			try {
				scrollIntoView(element);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String strStateToReport = " ";
		boolean blnValueToSelect = true;
		if (!(strValueToSelect.trim().equalsIgnoreCase("IGNORE"))) {
			if (strValueToSelect.trim().equalsIgnoreCase("N")) {
				blnValueToSelect = false;
				strStateToReport = " not ";
			}
			if (element.isEnabled()) {
				if (!blnValueToSelect && !element.isSelected()) {
					if (blnValueToSelect && element.isSelected()) {
						element.click();
					}
				}
				element.click();
				report.updateTestLog("Select the element (" + strObjName + ")",
						strObjName + " is" + strStateToReport + "checked as required", Status.DONE);

			} else {
				report.updateTestLog("Verify if the Element(" + strObjName + ") is present and selected",
						strObjName + " object is not enabled", Status.FAIL);
			}
		}
	}

	/**
	 *********************************************************************
	 * Function to find an element by property NOT defined in the OR file.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A {@link WebElement} object.
	 *************************************************************************
	 */
	public WebElement getElementByProperty(String strObjectProperty, String strFindElementType) {

		try {
			if (strFindElementType.equalsIgnoreCase("CSS"))
				return driver.findElement(By.cssSelector(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("XPATH"))
				return driver.findElement(By.xpath(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("ID"))
				return driver.findElement(By.id(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("NAME"))
				return driver.findElement(By.name(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("LINKTEXT"))
				return driver.findElement(By.linkText(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("TAG"))
				return driver.findElement(By.tagName(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("CLASS"))
				return driver.findElement(By.className(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("PARTIALLINKTEXT"))
				return driver.findElement(By.partialLinkText(strObjectProperty));
			else
				return null;
		} catch (org.openqa.selenium.NoSuchElementException nsee) {

			return null;
		}

		catch (Exception e) {
			return null;
		}
	}

	/**
	 ***************************************************************************
	 * Function to verify if an element is present in the application, not using OR.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A boolean value indicating if the searched Element is found.
	 ***************************************************************************
	 */
	public boolean isElementPresentVerification(WebElement elemToVerify, String strObjName) {

		try {
			// WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 20);

			if (wait.until(ExpectedConditions.visibilityOf(elemToVerify)).isDisplayed()) {
				return true;
			} else {
				report.updateTestLog((strObjName + " element is present"), strObjName + " is NOT displayed",
						Status.FAIL);
				return false;
			}
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("Error in identifying element (" + strObjName + ")", nsee.toString(), Status.FAIL);
			return false;
		} catch (Exception e) {
			report.updateTestLog("IS ELEMENT PRESENT VERIFICATION",
					"Error in identifying object (" + strObjName + ") -" + e.toString(), Status.FAIL);
			return false;
		}
	}

	/**
	 *************************************************************************** 
	 * Function to verify if an element is present in the application, not using OR.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A boolean value indicating if the searched Element is found.
	 ****************************************************************************
	 */
	public boolean isElementPresentVerification(String strObjectProperty, String strFindElementType, String strObjName)
			throws IOException {

		try {
			if (getElementByProperty(strObjectProperty, strFindElementType) != null) {
				report.updateTestLog((strObjName + " element is present").toUpperCase(),
						strObjName + " is verified successfully", Status.PASS);
				return true;
			} else
				return false;
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("Error in identifying element with string " + strObjectProperty, nsee.toString(),
					Status.FAIL);
			return false;
		} catch (Exception e) {
			report.updateTestLog("IS ELEMENT PRESENT VERIFICATION",
					"Error in identifying object (" + strObjName + ") -" + e.toString(), Status.FAIL);
			return false;
		}
	}

	/**
	 ***************************************************************************
	 * Function to verify whether a given Element is present within the page and
	 * click
	 * 
	 * @param strObjProperty
	 *            The {@link strObjProperty} defines the property value used for
	 *            identifying the object
	 * @param strObjPropertyType
	 *            The {@link strObjPropertyType} describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used for
	 *            reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 **********************************************************************
	 */
	public boolean clickIfElementPresent(WebElement element, String strObjName) {

		try {
			WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 30);
			/*
			 * if(driver.getCapabilities().getBrowserName().contains("IE")) { try {
			 * scrollIntoView(element); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); } }
			 */
			if (verifyIfElementIsPresent(wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element)),
					strObjName)) {
				wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element)).click();
				//Thread.sleep(1000);
				report.updateTestLog("Click '" + strObjName + "'", "'" + strObjName + "'" + " is present and clicked",
						Status.PASS);
				return true;
			} else {
				report.updateTestLog("Click '" + strObjName + "'", "'" + strObjName + "'" + " is not present",
						Status.FAIL);
				return false;
			}
		} 
		catch (Exception e) {
			report.updateTestLog("CLICK IF ELEMENT PRESENT", "Error in method - Error Description - " + e.toString(),
					Status.FAIL);
			return false;
		}
	}

	/*
	 * public boolean tapIfElementPresent(WebElement element, String strObjName){
	 * try{ WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 30); //
	 * Wait wait = new FluentWait(driver.getWebDriver()) // .withTimeout(timeout)
	 * // WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
	 * 
	 * if(isElementPresentVerification(ele, strObjName)){
	 * 
	 * @SuppressWarnings("rawtypes") TouchAction touchAction = new
	 * TouchAction((AndroidDriver)driver.getWebDriver());
	 * touchAction.press(ele).release().perform(); Thread.sleep(1000);
	 * report.updateTestLog("Tap '" + strObjName + "'", "'"+strObjName +"'" +
	 * " is present and clicked", Status.PASS); return true; } else{
	 * report.updateTestLog("Tap '" +strObjName + "'", "'"+strObjName +"'" +
	 * " is not present", Status.FAIL); return false; } } catch(Exception e){
	 * report.updateTestLog("TAP IF ELEMENT PRESENT",
	 * "Error in method - Error Description - " + e.toString(), Status.FAIL); return
	 * false; } }
	 */

	/**
	 *********************************************************************
	 * Function to find an element by property NOT defined in the OR file.
	 * 
	 * @param strObjectProperty
	 *            The {@link String} object that contains the page element
	 *            identification string.
	 * @param strFindElementType
	 *            The {@link String} object that describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @return A {@link WebElement} object.
	 *************************************************************************
	 */
	public List<WebElement> getElementsByProperty(String strObjectProperty, String strFindElementType) {

		try {
			// GlobalVariables.strImplicitWait="1";
			if (strFindElementType.equalsIgnoreCase("CSS"))
				return driver.findElements(By.cssSelector(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("XPATH"))
				return driver.findElements(By.xpath(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("ID"))
				return driver.findElements(By.id(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("NAME"))
				return driver.findElements(By.name(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("LINKTEXT"))
				return driver.findElements(By.linkText(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("TAG"))
				return driver.findElements(By.tagName(strObjectProperty));
			else if (strFindElementType.equalsIgnoreCase("CLASSNAME"))
				return driver.findElements(By.className(strObjectProperty));
			else
				return null;
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("Verify if " + strFindElementType + " - " + strObjectProperty + " is present",
					"Element with property " + strFindElementType + " - " + strObjectProperty + " not found",
					Status.FAIL);
			return null;
		}

		catch (Exception e) {
			report.updateTestLog("Verify if " + strFindElementType + " - " + strObjectProperty + " is present",
					"Element with property " + strFindElementType + " - " + strObjectProperty + " not found",
					Status.FAIL);
			return null;
		}
	}

	public int getDayOfMonth() {

		Calendar now = Calendar.getInstance();
		int day = (now.get(Calendar.DAY_OF_MONTH));
		return day;
	}

	public boolean scrollDown(CraftDriver driver) throws InterruptedException {
		// Get the size of screen.
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);

		// Find swipe start and end point from screen's with and height.
		// Find starty point which is at bottom side of screen.
		int starty = (int) (size.height * 0.80);
		// Find endy point which is at top side of screen.
		int endy = (int) (size.height * 0.20);
		// Find horizontal point where you wants to swipe. It is in middle of screen
		// width.
		int startx = size.width / 2;
		System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
		// Swipe from Bottom to Top.
		// driver.swipe(startx, starty, startx, endy, 3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
		return true;

	}

	public void scrollIntoView(WebElement element) throws InterruptedException {

		try {
			((JavascriptExecutor) driver.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);",
					wait.until(ExpectedConditions.visibilityOf(element)));
			report.updateTestLog("Scroll To the Element", "Scroll to the element completed" ,
					Status.DONE);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void scrollToPoint(WebElement element) throws InterruptedException {

		try {
			int x = element.getLocation().getX();
			int y = element.getLocation().getY();
			
			((JavascriptExecutor) driver.getWebDriver()).executeScript("window.scrollBy("+x,y+")");
			report.updateTestLog("Scroll To the Element", "Scroll to the element completed" ,
					Status.DONE);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/******************************************************************
	 * Method to Verify Element is Not Present within a parent element Negative
	 * Scenario
	 * 
	 * @param elemToVerify
	 * @param strObjName
	 *****************************************************************
	 */
	public boolean verifyIsElementNotPresent(WebElement elmt, String strParentElementName, String strObjectProperty,
			String strFindElementType, String strObjName) {

		try {

			if (strFindElementType.equalsIgnoreCase("CSS")) {
				elmt.findElement(By.cssSelector(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("XPATH")) {
				elmt.findElement(By.xpath(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("ID")) {
				elmt.findElement(By.id(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("NAME")) {
				elmt.findElement(By.name(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("LINKTEXT")) {
				elmt.findElement(By.linkText(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("TAG")) {
				elmt.findElement(By.tagName(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("CLASS")) {
				elmt.findElement(By.className(strObjectProperty));
			} else {
			}
			report.updateTestLog("verifyIsElementNotPresent".toUpperCase() + " - (" + strObjName + ")",
					"(" + strObjName + ")" + " Is Present with property : " + strObjectProperty + " within the Element "
							+ strParentElementName + "!!Not expected",
					Status.FAIL);
			return false;

		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog(
					"verifyIsElementNotPresent".toUpperCase() + " - identifying element (" + strObjName + ")",
					"(" + strObjName + ")" + " with property: " + strObjectProperty
							+ " Is Not Present within the Element " + strParentElementName + " as expected",
					Status.PASS);
			return true;
		}
	}

	/**
	 ************************************************************* 
	 * Method to check/Uncheck a check box based on the given option
	 * 
	 * @param elementToSelect
	 *            The {@link elementToSelect} element to be verified
	 * @param valueToSelect
	 *            The {@link strElemStateToVerify} describes the state to be set
	 *            which can be one of: Y/N
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used for
	 *            reporting purposes.
	 * @return None
	 ************************************************************* 
	 */

	public boolean verifyElementIsNotEnabled(WebElement elementToSelect, String strObjName) throws Exception {
		//Thread.sleep(4000);
		// scrollIntoView(elementToSelect);
		if (!elementToSelect.isEnabled()) {
			report.updateTestLog("Verify if '" + strObjName + "' is not enabled", "'" + strObjName + "' is not enabled",
					Status.PASS);
			return true;

		} else {

			report.updateTestLog("Verify if '" + strObjName + "' is enabled", "'" + strObjName + "' is enabled",
					Status.FAIL);
			return false;
		}

	}

	public void verifyElementIsNotEnabled(PageObjects pageObject) throws Exception {
		WebElement element = getPageElement(pageObject);
		String strObjName = pageObject.getObjectname();

		if (!element.isEnabled()) {
			report.updateTestLog("Verify if the Element(" + strObjName + ") is present and Enabled",
					strObjName + " object is enabled", Status.FAIL);

		} else {
			report.updateTestLog("Verify if the Element(" + strObjName + ") is present and Not Enabled",
					strObjName + " object is not enabled", Status.PASS);
		}

	}

	/*********************************************************
	 * Method to wait for Element visibility
	 * 
	 * @param property
	 *            - property value
	 * @param locator
	 *            - element locator type
	 * @param time
	 *            - synchronization timeout
	 * @return true/false *********************************************************
	 */
	public boolean waitForElementClickable(String locator, String property, long time, Boolean printError) {
		try {
			long startTime = System.currentTimeMillis();

			WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), time);
			if (locator.equalsIgnoreCase("css"))
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(property)));
			else if (locator.equalsIgnoreCase("linktext"))
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText(property)));
			else if (locator.equalsIgnoreCase("xpath"))
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(property)));
			else if (locator.equalsIgnoreCase("classname"))
				wait.until(ExpectedConditions.elementToBeClickable(By.className(property)));
			else if (locator.equalsIgnoreCase("name"))
				wait.until(ExpectedConditions.elementToBeClickable(By.name(property)));
			else
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(property)));
			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out.println("Elapsed time " + elapsedTime);
			Thread.sleep(1000);
			return true;
		} catch (Exception e) {
			if (printError)
				report.updateTestLog("Wait For Element to be clickable- element not clickable",
						"Waited for " + time + " seconds to find element with : " + property, Status.FAIL);
			return false;
		}
	}

	/**
	 *************************************************************************
	 * Method to verify an element which is a image ,href for which we get the
	 * String value using attribute.
	 * 
	 * @return A boolean value indicating if the searched Element is found. author
	 *         Ravi
	 *************************************************************************
	 */
	public boolean isElementPresentContainsAttributeText(String strObjectProperty, String strFindElementType,
			String StrObjName, String textToVerify, String attribute) throws IOException {

		try {
			
			if (isElementPresentVerification(strObjectProperty, strFindElementType, StrObjName)) {
				getElementByProperty(strObjectProperty, strFindElementType).getAttribute(attribute)
						.contains(textToVerify);
				report.updateTestLog("The Element(" + StrObjName + ") is present and Contains the text", textToVerify,
						Status.PASS);
				return true;
			} else {
				report.updateTestLog("The Element(" + StrObjName + ") is not present and does not contain the text",
						textToVerify, Status.FAIL);
				return false;
			}
		} catch (Exception e) {
			report.updateTestLog("IS ELEMENT PRESENTCONTAINS TEXT",
					"Error in method - Error Description - " + e.toString(), Status.FAIL);
			return false;
		}
	}

	public boolean isElementPresentContainsText(String strObjectProperty, String strFindElementType, String StrObjName,
			String textToVerify) throws IOException {
		
		try {
			WebElement ele =getElementByProperty(strObjectProperty, strFindElementType);
			if(driver.getCapabilities().getBrowserName().contains("IE")) {
				try {
					scrollIntoView(ele);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (isElementPresentVerification(strObjectProperty, strFindElementType, StrObjName)) {
				getElementByProperty(strObjectProperty, strFindElementType).getText().contains(textToVerify);
				report.updateTestLog("The Element(" + StrObjName + ") is present and Contains the text", textToVerify,
						Status.PASS);

				return true;
			} else {
				report.updateTestLog("The Element(" + StrObjName + ") is not present and does not contain the text",
						textToVerify, Status.FAIL);
				return false;
			}
		} catch (Exception e) {
			report.updateTestLog("IS ELEMENT PRESENTCONTAINS TEXT",
					"Error in method - Error Description - " + e.toString(), Status.FAIL);
			return false;
		}
	}

	/*
	 * Function go generate random alphanumeric number
	 * 
	 * @created by Ravi ID - 220097
	 * 
	 * @param count
	 */
	public String randomAlphaNumeric(int count) {
		final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return (builder.toString());
	}

	/*
	 * Function go generate random numeric number
	 * 
	 * @created by Ravi ID - 220097
	 * 
	 * @param count
	 */
	public String randomNumeric(int count) {
		final String NUMERIC_STRING = "0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * NUMERIC_STRING.length());
			builder.append(NUMERIC_STRING.charAt(character));
		}
		return (builder.toString());
	}

	public void SwitchControlToChildTab() throws Exception {
		try {

			String AlreadySelectedWindow = driver.getWindowHandle();
			System.out.println("AlreadySelectedWindow:" + AlreadySelectedWindow);

			Set<String> tab_handles = driver.getWindowHandles();
			int number_of_tabs = tab_handles.size();
			int new_tab_index = number_of_tabs - 1;
			driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in switchControlToChildTab Function while trying to switch tabs");
			report.updateTestLog("SwitchControlToChildTab", "Error in method - Error Description - " + e.toString(),
					Status.FAIL);
		}
	}

	public void closeChildTab() throws Exception {
		try {

			String AlreadySelectedWindow = driver.getWindowHandle();
			System.out.println("AlreadySelectedWindow:" + AlreadySelectedWindow);

			Set<String> tab_handles = driver.getWindowHandles();
			int number_of_tabs = tab_handles.size();
			int new_tab_index = number_of_tabs - 1;
			driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());
			driver.close();
			driver.switchTo().window(AlreadySelectedWindow);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in switchControlToChildTab Function while trying to switch tabs");
			report.updateTestLog("closeChildTab", "Error in method - Error Description - " + e.toString(), Status.FAIL);
		}
	}

	public void SwitchControlToParentTab() throws Exception {
		try {

			String AlreadySelectedWindow = driver.getWindowHandle();
			System.out.println("AlreadySelectedWindow:" + AlreadySelectedWindow);

			Set<String> tab_handles = driver.getWindowHandles();
			int number_of_tabs = tab_handles.size();
			@SuppressWarnings("unused")
			int new_tab_index = number_of_tabs - 1;
			driver.switchTo().window(tab_handles.toArray()[0].toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in switchControlToParentTab Function while trying to switch tabs");
			report.updateTestLog("SwitchControlToParentTab", "Error in method - Error Description - " + e.toString(),
					Status.FAIL);
		}
	}

	/***
	 ************************************************************* 
	 * Method to select an option directly from combo box/list box
	 * 
	 * @param elementToSelect
	 *            The {@link elementToSelect} element to be verified
	 * @param valueToSelect
	 *            The {@link strElemStateToVerify} describes the state to be
	 *            verified which can be either one of ENABLED/SELECTED/VALUE
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used for
	 *            reporting purposes.
	 * @return A boolean value indicating if selecting an option is done.
	 ************************************************************* 
	 */
	public void selectAnyElement(WebElement elementToSelect, String strValueToSelect, String strObjName) {

		// WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementToSelect));
		/*
		 * if(driver.getCapabilities().getBrowserName().contains("IE")) { try {
		 * scrollIntoView(element); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 */
		if (!(strValueToSelect.trim().equalsIgnoreCase("IGNORE"))) {
			if (element.isEnabled()) {
				// element.click();

				Select comSelElement = new Select(element);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
				comSelElement.selectByVisibleText(strValueToSelect);

				report.updateTestLog("Verify if the Element(" + strObjName + ") is present and selected",
						strObjName + " value : '" + strValueToSelect + "' is selected", Status.PASS);
			} else {
				report.updateTestLog("Verify if the Element(" + strObjName + ") is present and selected",
						strObjName + " object is not enabled", Status.FAIL);
			}
		}
	}

	/***
	 ************************************************************* 
	 * Method to select an option directly from combo box/list box
	 * 
	 * @param elementToSelect
	 *            The {@link elementToSelect} element to be verified
	 * @param valueToSelect
	 *            The {@link strElemStateToVerify} describes the state to be
	 *            verified which can be either one of ENABLED/SELECTED/VALUE
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used for
	 *            reporting purposes.
	 * @return A boolean value indicating if selecting an option is done.
	 ************************************************************* 
	 */
	public void selectAnyElementByValue(WebElement elementToSelect, String strValueToSelect, String strObjName) {

		// WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementToSelect));
		/*
		 * if(driver.getCapabilities().getBrowserName().contains("IE")) { try {
		 * scrollIntoView(element); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 */
		if (!(strValueToSelect.trim().equalsIgnoreCase("IGNORE"))) {
			if (element.isEnabled()) {
				// element.click();

				Select comSelElement = new Select(element);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
				comSelElement.selectByValue(strValueToSelect);

				report.updateTestLog("Verify if the Element(" + strObjName + ") is present and selected",
						strObjName + " value : '" + strValueToSelect + "' is selected", Status.DONE);
			} else {
				report.updateTestLog("Verify if the Element(" + strObjName + ") is present and selected",
						strObjName + " object is not enabled", Status.FAIL);
			}
		}
	}

	/***
	 ************************************************************* 
	 * Method to select an option directly from combo box/list box
	 * 
	 * @param elementToSelect
	 *            The {@link elementToSelect} element to be verified
	 * @param indexToSelect
	 *            Index to Select
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used for
	 *            reporting purposes.
	 * @return A boolean value indicating if selecting an option is done.
	 ************************************************************* 
	 */
	public void selectAnyElement(WebElement elementToSelect, int indexToSelect, String strObjName) {

		WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToSelect));
		/*
		 * if(driver.getCapabilities().getBrowserName().contains("IE")) { try {
		 * scrollIntoView(element); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 */
		if (indexToSelect > -1) {
			if (element.isEnabled()) {
				element.click();

				Select comSelElement = new Select(element);
			
				comSelElement.selectByIndex(indexToSelect);

				report.updateTestLog("Verify if the Element(" + strObjName + ") is present and selected",
						strObjName + " value : '" + indexToSelect + "' is selected", Status.DONE);
			} else {
				report.updateTestLog("Verify if the Element(" + strObjName + ") is present and selected",
						strObjName + " object is not enabled", Status.FAIL);
			}
		}
	}

	/**
	 * @author Kalyan
	 * @Param
	 * @return void
	 * @throws Exception
	 * @Description Clicks on OK button in alert window
	 * @Date Jan, 2018
	 */
	public void acceptAlertMessage() throws Exception {
		try {
			// WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 20);

			if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
				Alert alert = driver.getWebDriver().switchTo().alert();
				// String retrievedMessage = alert.getText().trim();
				alert.accept();
				report.updateTestLog("ACCEPT ALERT MESSAGE", "Clicked on OK button", Status.PASS);
			}

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("ACCEPT ALERT MESSAGE", "Error in method - Error Description - " + e.toString(),
					Status.FAIL);
		}

	}

	/**
	 * @author Kalyan
	 * @Description Get text from a particular field in the page
	 * @return
	 * @throws Exception
	 */
	public String getTextFromTextBox(WebElement element, String strObjName) throws Exception {
		try {
			// WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 20);
			// Webelement element = driver.getWebDriver().findElement(By.xpath(xpath));
			String textBoxValue = wait.until(ExpectedConditions.visibilityOf(element)).getText();
			report.updateTestLog("GET TEXT FROM TEXT BOX", "Clicked on OK button", Status.PASS);
			System.out.println("Text:" + textBoxValue);
			return textBoxValue;
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("GET TEXT FROM TEXT BOX", "Unable to get text from textbox", Status.FAIL);
			return null;
		}
	}

	public boolean isElementPresentContainsText(WebElement element, String StrObjName, String textToVerify)
			throws IOException {
		try {
			if (isElementPresentVerification(wait.until(ExpectedConditions.visibilityOf(element)), StrObjName)) {
				if (wait.until(ExpectedConditions.visibilityOf(element)).getText().contains(textToVerify)) {
					report.updateTestLog("The Element(" + StrObjName + ") is present and Contains the text:"+textToVerify,
							"Successfully verified the presence of text: "+textToVerify, Status.PASS);
				}
				return true;
			} else {
				report.updateTestLog("The Element(" + StrObjName + ") is not present and does not contain the text",
						textToVerify, Status.FAIL);
				return false;
			}
		} catch (Exception e) {
			report.updateTestLog("IS ELEMENT PRESENTCONTAINS TEXT",
					"Error in method - Error Description - " + e.toString(), Status.FAIL);
			return false;
		}
	}

	public void sendKeyENTER(WebElement element, String StrObjName) throws IOException {

		try {
			// WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 20);

			wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(Keys.ENTER);
			report.updateTestLog("Click Enter", "Successfully clicked enter", Status.PASS);
		} catch (Exception e) {
			report.updateTestLog("Click Enter", "Unable to click enter", Status.FAIL);
		}
	}

	/***************************************************************
	 * Method to Verify Element is Not Present For Negative Scenario
	 * 
	 * @param elemToVerify
	 * @param strObjName
	 **************************************************************
	 */

	public boolean verifyIsElementNotPresent(String strObjectProperty, String strFindElementType, String strObjName) {
		WebElement element = null;
		try {

			if (strFindElementType.equalsIgnoreCase("CSS")) {
				element = driver.findElement(By.cssSelector(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("XPATH")) {
				element = driver.findElement(By.xpath(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("ID")) {
				element = driver.findElement(By.id(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("NAME")) {
				element = driver.findElement(By.name(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("LINKTEXT")) {
				element = driver.findElement(By.linkText(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("TAG")) {
				element = driver.findElement(By.tagName(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("CLASS")) {
				element = driver.findElement(By.className(strObjectProperty));
			} else {
			}

			if (element.isDisplayed()) {
				report.updateTestLog("verifyIsElementNotPresent - (" + strObjName + ")",
						"(" + strObjName + ")" + " Is Present!!Not expected", Status.FAIL);
				return false;
			} else {
				report.updateTestLog("verifyIsElementNotPresent - identifying element (" + strObjName + ")",
						"(" + strObjName + ") is NOT PRESENT as expected", Status.PASS);
				return false;
			}

		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("verifyIsElementNotPresent - identifying element (" + strObjName + ")",
					"(" + strObjName + ") is NOT PRESENT as expected", Status.PASS);
			return true;
		}

	}

	/**
	 * @author Kalyan
	 * @Description click the element when it is clickable
	 * @return
	 * @throws Exception
	 */
	public void clickWhenReady(WebElement element, String strObjName, int timeout) {
		try {
			// WebElement element = null;
			WebDriverWait wait = new WebDriverWait((WebDriver) driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			report.updateTestLog("clickWhenReady", "Successfully clicked the desired element", Status.PASS);
			// element.click();
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			report.updateTestLog("clickWhenReady", "Unable to identify " + strObjName + " element during wait time",
					Status.FAIL);
		}
	}

	/**
	 * @author Kalyan
	 * @Description click when the element is visible
	 * @return
	 * @throws Exception
	 */
	public void clickWhenVisible(WebElement element, String strObjName, int timeout) {
		try {
			// WebElement element = null;
			WebDriverWait wait = new WebDriverWait((WebDriver) driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element)).click();
			report.updateTestLog("clickWhenVisible", "Successfully clicked the desired element", Status.PASS);
			// element.click();
		} catch (Exception e) {
			report.updateTestLog("clickWhenVisible", "Unable to identify " + strObjName + " element during wait time",
					Status.FAIL);
		}
	}

	public boolean verifyIfElementPresent(WebElement elemToVerify, String strObjName) {

		try {
			// WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 20);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(elemToVerify));

			if (element.isDisplayed()) {
				return true;
			} else {
				// report.updateTestLog((strObjName + " element is present"), strObjName
				// + " is NOT displayed", Status.FAIL);
				return false;
			}
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("Error in identifying element (" + strObjName + ")", nsee.toString(), Status.FAIL);
			return false;
		} catch (Exception e) {
			report.updateTestLog("IS ELEMENT PRESENT VERIFICATION",
					"Error in identifying object (" + strObjName + ") -" + e.toString(), Status.FAIL);
			return false;
		}
	}

	/**
	 * @author Kalyan
	 * @Description Get value from a particular attribute
	 * @return
	 * @throws Exception
	 */
	public String getValueFromAttribute(WebElement element, String strObjName, String attributeName) throws Exception {
		try {
			// WebDriverWait wait = new WebDriverWait(driver.getWebDriver(), 20);

			String textBoxValue = wait.until(ExpectedConditions.visibilityOf(element)).getAttribute(attributeName)
					.trim();
			report.updateTestLog("getValueFromAttribute", "Text present in an attribute", Status.PASS);
			System.out.println("Text:" + textBoxValue);
			return textBoxValue;
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("getValueFromAttribute", "Unable to get text from attribute", Status.FAIL);
			return null;
		}
	}

	/**
	 * @author Kalyan
	 * @Description Hover over an element
	 * @return void
	 * @throws Exception
	 */
	public void moveToAnElement(WebElement element, String strObjName) throws Exception {
		try {
			WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));

			if (ele.isDisplayed()) {
				Actions action = new Actions(driver.getWebDriver());
				action.moveToElement(ele).build().perform();

			} else {
				report.updateTestLog(("Verify " + strObjName + " element is present"), strObjName + " is NOT displayed",
						Status.FAIL);
			}

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("moveToAnElement", "Unable to hover over the element", Status.FAIL);
		}
	}

	// ------------------------------------------------from APP n SPA common
	// functions sheet------------------------------------------
	/**
	 ********************************************************************
	 * Function to clear existing text in a field.
	 * 
	 * @param ElementName
	 *            The {@link String} object that contains the page element
	 *            identification variable in OR.
	 * @return void
	 *********************************************************************
	 */

	public boolean clearText(WebElement elemToUpdate, String strObjName) {

		try {
			if (elemToUpdate.isDisplayed() && elemToUpdate.isEnabled()) {
				elemToUpdate.clear();
				return true;
			} else {
				report.updateTestLog("Verify if the Element(" + strObjName + ") is present and clear",
						strObjName + " is not enabled", Status.FAIL);
			}
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("UPDATE ANY ELEMENT : " + strObjName, strObjName + " object does not exist in page",
					Status.FAIL);
		} catch (Exception e) {
			report.updateTestLog("UPDATE ANY ELEMENT",
					"Error in finding object - " + strObjName + ". Error Description - " + e.toString(), Status.FAIL);
		}
		return false;

	}

	/**
	 ***************************************************************************
	 * Function to verify whether a given Element is present within the page and
	 * click
	 * 
	 * @param strObjProperty
	 *            The {@link strObjProperty} defines the property value used for
	 *            identifying the object
	 * @param strObjPropertyType
	 *            The {@link strObjPropertyType} describes the method used to
	 *            identify the element. Possible values are ID, NAME, LINKTEXT,
	 *            XPATH or CSS.
	 * @param strObjName
	 *            The {@link strObjName} is used for identifying the object used for
	 *            reporting purposes.
	 * @return A boolean value indicating if the searched Element is found.
	 **********************************************************************
	 */
	public boolean clickIfElementPresentJavaScript(WebElement element, String strObjName) {

		try {
			if (element.isDisplayed()) {
				System.out.println("The Element is displayed: " + strObjName);
				JavascriptExecutor executor = (JavascriptExecutor) driver.getWebDriver();
				executor.executeScript("arguments[0].click();", element);
				Thread.sleep(500);
				report.updateTestLog("Click '" + strObjName + "'", "'" + strObjName + "'" + " is present and clicked",
						Status.PASS);
				return true;
			} else {
				report.updateTestLog("Click '" + strObjName + "'", "'" + strObjName + "'" + " is not present",
						Status.FAIL);
				return false;
			}
		} catch (Exception e) {
			report.updateTestLog("CLICK IF ELEMENT PRESENT", "Error in method - Error Description - " + e.toString(),
					Status.FAIL);
			return false;
		}
	}

	/**
	 ****************************************************************************
	 * Function to verify and update test log if an element exists on the Webpage
	 * 
	 * @param elementToFind
	 *            Web element to find
	 * 
	 * @param objName
	 *            Name of the element which is to be searched
	 * @return true If the element exists on page
	 * 
	 * @return false If the element does not exist on page
	 ****************************************************************************
	 */
	public boolean verifyIfElementIsPresent(WebElement elementToFind, String objName) {

		try {
			if (elementToFind == null || (!elementToFind.isDisplayed())) {
				report.updateTestLog(objName, objName + " element is not displayed", Status.FAIL);
				return false;
			}
			if (elementToFind.isDisplayed()) {
				highlightElement(elementToFind);
				report.updateTestLog(objName, objName + " is displayed", Status.PASS);
				return true;
			} else {
				report.updateTestLog(objName, objName + " element is not displayed", Status.FAIL);
				return false;
			}

		} catch (Exception e) {
			report.updateTestLog(objName, objName + " element is not displayed", Status.FAIL);
			return false;
		}

	}

	public String getTextFromElement(WebElement element) {
		try {
			String text = element.getText();
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getSelectedTextFromDropDown(WebElement element) {
		try {
			Select s = new Select(element);
			return s.getFirstSelectedOption().getText();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public WebElement selectAStoreInListView(String strObjectProperty, int i, String strObjName) {

		try {
			List<WebElement> elements = driver.getWebDriver().findElements(By.xpath(strObjectProperty));
			int listSize = elements.size();
			if (listSize > 0) {
				return elements.get(i);
			} else {
				System.out.println("No stores are displayed");
				return null;
			}
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("Error in identifying element (" + strObjName + ")", nsee.toString(), Status.FAIL);
			return null;
		} catch (Exception e) {
			report.updateTestLog("selectFirstStoreInListView",
					"Error in identifying object (" + strObjName + ") -" + e.toString(), Status.FAIL);
			return null;
		}
	}

	public void clickTheChevronInListView(String strObjectProperty, String chevronObjectProperty, String strObjName) {

		try {
			List<WebElement> elements = driver.getWebDriver().findElements(By.xpath(strObjectProperty));
			if (isElementPresentVerification(elements.get(0), strObjName)) {
				elements.get(0).findElement(By.xpath(chevronObjectProperty)).click();
				report.updateTestLog("clickTheChevronInListView", "Clicked on right chevron of a store", Status.PASS);
			} else {
				System.out.println("No stores are displayed or Chevron is not displayed");
			}
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("Error in identifying element (" + strObjName + ")", nsee.toString(), Status.FAIL);
		} catch (Exception e) {
			report.updateTestLog("clickTheChevronInListView",
					"Error in identifying object (" + strObjName + ") -" + e.toString(), Status.FAIL);
		}
	}

	public void verifyStarIconInAllStoresInListView(String strObjectProperty, String starObjectProperty,
			String strObjName) {

		try {
			List<WebElement> elements = driver.getWebDriver().findElements(By.xpath(strObjectProperty));
			int count = 0;
			for (WebElement we : elements) {
				if (we.findElement(By.xpath(starObjectProperty)).isDisplayed()) {
					System.out.println("Star is displayed");
					count++;
				}
			}
			if (count > 0) {
				report.updateTestLog("verifyStarIconInAllStoresInListView", "Star icons are present in stores",
						Status.PASS);
			} else {
				report.updateTestLog("verifyStarIconInAllStoresInListView", "Star icons are not present in stores",
						Status.FAIL);
			}
		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			report.updateTestLog("Error in identifying element (" + strObjName + ")", nsee.toString(), Status.FAIL);
		} catch (Exception e) {
			report.updateTestLog("verifyStarIconInAllStoresInListView",
					"Error in identifying object (" + strObjName + ") -" + e.toString(), Status.FAIL);
		}
	}

	public WebElement getAnyObjectWithInAnyStoreInListView(String parentStrObjectProperty, int i,
			String parentStrObjName, String strFindElementType, String strObjectProperty) {

		try {
			WebElement parent = selectAStoreInListView(parentStrObjectProperty, i, parentStrObjName);
			if (strFindElementType.equalsIgnoreCase("CSS")) {
				return parent.findElement(By.cssSelector(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("XPATH")) {
				return parent.findElement(By.xpath(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("ID")) {
				return parent.findElement(By.id(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("NAME")) {
				return parent.findElement(By.name(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("LINKTEXT")) {
				return parent.findElement(By.linkText(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("TAG")) {
				return parent.findElement(By.tagName(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("CLASSNAME")) {
				return parent.findElement(By.className(strObjectProperty));
			} else if (strFindElementType.equalsIgnoreCase("PARTIALLINKTEXT")) {
				return parent.findElement(By.partialLinkText(strObjectProperty));
			} else {
				return null;
			}
		} catch (Exception e) {
			report.updateTestLog("getAnyObjectWithInAnyStoreInListView",
					"Error in identifying object (" + strObjectProperty + ") -" + e.toString(), Status.FAIL);
			return null;
		}
	}

	public void clickAnElementOfAStoreInListView(String parentStrObjectProperty, int i, String parentStrObjName,
			String strFindElementType, String strObjectProperty, String strObjName) {

		try {
			if (getAnyObjectWithInAnyStoreInListView(parentStrObjectProperty, i, parentStrObjName, strFindElementType,
					strObjectProperty).isDisplayed()) {
				getAnyObjectWithInAnyStoreInListView(parentStrObjectProperty, i, parentStrObjName, strFindElementType,
						strObjectProperty).click();
				report.updateTestLog("clickAnElementOfAStoreInListView", "Clicked the desired element", Status.PASS);
			} else {
				report.updateTestLog("clickAnElementOfAStoreInListView", "Element is not displayed", Status.FAIL);
			}
		} catch (Exception e) {
			report.updateTestLog("clickAnElementOfAStoreInListView",
					"Error in identifying object (" + strObjName + ") -" + e.toString(), Status.FAIL);
		}
	}

	public boolean verifyIfStoreElementPresentInListView(String parentStrObjectProperty, int i, String parentStrObjName,
			String strFindElementType, String strObjectProperty, String strObjName) {

		try {
			if (getAnyObjectWithInAnyStoreInListView(parentStrObjectProperty, i, parentStrObjName, strFindElementType,
					strObjectProperty).isDisplayed()) {
				// getAnyObjectWithInAnyStoreInListView(parentStrObjectProperty, i,
				// parentStrObjName, strFindElementType, strObjectProperty).click();
				report.updateTestLog("verifyIfStoreElementPresentInListView", "Desired element is displayed",
						Status.PASS);
				return true;
			} else {
				report.updateTestLog("verifyIfStoreElementPresentInListView", "Element is not displayed", Status.FAIL);
				return false;
			}
		} catch (Exception e) {
			report.updateTestLog("clickAnElementOfAStoreInListView",
					"Error in identifying object (" + strObjName + ") -" + e.toString(), Status.FAIL);
			return false;
		}
	}

	public void clickBubbleInMap() {

		try {
			TouchActions actions = new TouchActions(driver.getWebDriver());
			actions.move(207, 500).click().build().perform();
		} catch (Exception e) {
			report.updateTestLog("clickBubbleInMap", "Could not click the target", Status.FAIL);
		}
	}

	/*
	 * Method for validating image in UI 
	 */
	public boolean validateImage(String path, String screenName, String imageDesc)	{

		try {
			Screen screen = new Screen();
			Pattern pattern = new Pattern(path);
			screen.wait(pattern, 8);			

			//JavascriptExecutor executor = (JavascriptExecutor) driver.getWebDriver();
			//executor.executeScript("arguments[0].style.border=''", pattern);

			if (screen.exists(pattern) != null)	{
				report.updateTestLog(screenName + " page validation", imageDesc + " validation is successful", Status.PASS);
				return true;
			}
			else	{
				report.updateTestLog(screenName + " page validation", imageDesc + " validation is not successful", Status.FAIL);
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateImage", "Exception is - " + e, Status.FAIL);
			return false;
		}		
	}

	/**
	 * Function to highlight the element on  current page
	 * @param by The {@link WebDriver} locator used to identify the element
	 */	
	public void highlightElement(WebElement ele) throws InterruptedException{
		//waitUntilElementEnabled(by, 50);
		try	{
			//Creating JavaScriptExecuter Interface
			JavascriptExecutor executor = (JavascriptExecutor) driver.getWebDriver();
			for (int iCnt = 0; iCnt < 1; iCnt++) {
				//Execute java script			
				executor.executeScript("arguments[0].style.border='7px groove green'", ele);
				Thread.sleep(200);
				executor.executeScript("arguments[0].style.border=''", ele);			
			}
		}	catch (Exception e) {
			System.out.println("Exception - "+e.getMessage());
		}
	}
	/**
	 * Function to do a mouseover on top of the specified element
	 * @param by The {@link WebDriver} locator used to identify the element
	 */
	public void mouseOver(WebElement ele, String objectName) {
		Actions actions = new Actions(driver.getWebDriver());
		actions.moveToElement(ele).build().perform();
		report.updateTestLog("Mouse over the element: "+objectName, "Mouse over the element:"+objectName+" is success", Status.DONE);
	}
	
	public void hitEnterKey(WebElement ele, String objectName) {
		if(driver.getTestParameters().getExecutionMode().toString().equalsIgnoreCase("BROWSERSTACK")) {
		//ele.sendKeys(Keys.ENTER);
		//ele.sendKeys(Keys.RETURN);
		Actions action = new Actions(driver.getWebDriver());
		action.sendKeys(Keys.RETURN);
		action.build().perform();
		}else {
			Robot robot;
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		report.updateTestLog("Hit enter on the Text Box"+objectName, "Enter Key was hit successfully", Status.DONE);
		
	}
		
	public void selectDropDownvalue(WebElement ele1, String property, String objectName, String value) {
		try {
			System.out.println("Selecting the drop down value for: "+objectName);
			ele1.click();
			String finalxpath = property+value+"']";
			driver.findElement(By.xpath(finalxpath)).click();
			report.updateTestLog(objectName+ " Dropdown value select", objectName+ " Drop down value selected with value:"+value, Status.PASS);
		}catch(Exception e) {
			report.updateTestLog("Select Drop Down value",
					"Something really went wrong! :" + e.toString(), Status.FAIL);
		}
	}
}
