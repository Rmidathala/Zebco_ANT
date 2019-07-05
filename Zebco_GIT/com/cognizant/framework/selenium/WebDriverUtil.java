package com.cognizant.framework.selenium;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import org.openqa.selenium.TimeoutException;

/**
 * Class containing useful WebDriver utility functions
 * @author Cognizant
 */
public class WebDriverUtil {
	private CraftDriver driver;




	/**
	 * Constructor to initialize the {@link WebDriverUtil} object
	 * @param driver The {@link WebDriver} object
	 */
	public WebDriverUtil(CraftDriver driver) {
		this.driver = driver;
	}

	/**
	 * Function to pause the execution for the specified time period
	 * @param milliSeconds The wait time in milliseconds
	 */
	public void waitFor(long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Function to wait until the page loads completely
	 * @param timeOutInSeconds The wait timeout in seconds
	 */
	public void waitUntilPageLoaded(long timeOutInSeconds) {
		WebElement oldPage = driver.findElement(By.tagName("html"));

		(new WebDriverWait(driver.getWebDriver(), timeOutInSeconds))
		.until(ExpectedConditions.stalenessOf(oldPage));

	}

	/**
	 * Function to wait until the page readyState equals 'complete'
	 * @param timeOutInSeconds The wait timeout in seconds
	 */
	public void waitUntilPageReadyStateComplete(long timeOutInSeconds) {
		ExpectedCondition<Boolean> pageReadyStateComplete =
				new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		(new WebDriverWait(driver.getWebDriver(), timeOutInSeconds)).until(pageReadyStateComplete);
	}

	/**
	 * Function to wait until the specified element is located
	 * @param by The {@link WebDriver} locator used to identify the element
	 * @param timeOutInSeconds The wait timeout in seconds
	 */
	public void waitUntilElementLocated(By by, long timeOutInSeconds) {
		(new WebDriverWait(driver.getWebDriver(), timeOutInSeconds))
		.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	/**
	 * Function to wait until the specified element is visible
	 * @param by The {@link WebDriver} locator used to identify the element
	 * @param timeOutInSeconds The wait timeout in seconds
	 */
	public void waitUntilElementVisible(By by, long timeOutInSeconds) {
		(new WebDriverWait(driver.getWebDriver(), timeOutInSeconds))
		.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	/**
	 * Function to wait until the specified element is enabled
	 * @param by The {@link WebDriver} locator used to identify the element
	 * @param timeOutInSeconds The wait timeout in seconds
	 */
	public void waitUntilElementEnabled(By by, long timeOutInSeconds) {
		(new WebDriverWait(driver.getWebDriver(), timeOutInSeconds))
		.until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * Function to wait until the specified element is disabled
	 * @param by The {@link WebDriver} locator used to identify the element
	 * @param timeOutInSeconds The wait timeout in seconds
	 */
	public void waitUntilElementDisabled(By by, long timeOutInSeconds) {
		(new WebDriverWait(driver.getWebDriver(), timeOutInSeconds))
		.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(by)));
	}

	/**
	 * Function to select the specified value from a listbox
	 * @param by The {@link WebDriver} locator used to identify the listbox
	 * @param item The value to be selected within the listbox
	 */
	public void selectListItem(By by, String item) {
		Select dropDownList = new Select(driver.findElement(by));
		dropDownList.selectByVisibleText(item);
	}

	/**
	 * Function to do a mouseover on top of the specified element
	 * @param by The {@link WebDriver} locator used to identify the element
	 */
	public void mouseOver(By by) {
		try	{
			Actions actions = new Actions(driver.getWebDriver());
			actions.moveToElement(driver.findElement(by)).build().perform();
		}	catch(Exception e)	{
			e.printStackTrace();
		}
	}

	/**
	 * Function to verify whether the specified object exists within the current page
	 * @param by The {@link WebDriver} locator used to identify the element
	 * @return Boolean value indicating whether the specified object exists
	 */
	public Boolean objectExists(By by) {
		return !driver.findElements(by).isEmpty();
	}

	/**
	 * Function to verify whether the specified text is present within the current page
	 * @param textPattern The text to be verified
	 * @return Boolean value indicating whether the specified test is present
	 */
	public Boolean isTextPresent(String textPattern) {
		return driver.findElement(By.cssSelector("BODY")).getText().matches(textPattern);
	}

	/**
	 * Function to check if an alert is present on the current page
	 * @param timeOutInSeconds The number of seconds to wait while checking for the alert
	 * @return Boolean value indicating whether an alert is present
	 */
	public Boolean isAlertPresent(long timeOutInSeconds) {
		try {
			new WebDriverWait(driver.getWebDriver(), timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (TimeoutException ex) {
			return false;
		}
	}

	/**
	 * Function to highlight the element on  current page
	 * @param by The {@link WebDriver} locator used to identify the element
	 */	
	public void highlightElement(By by) throws InterruptedException{
		//waitUntilElementEnabled(by, 50);
		try	{
			//Creating JavaScriptExecuter Interface
			JavascriptExecutor executor = (JavascriptExecutor) driver.getWebDriver();
			for (int iCnt = 0; iCnt < 1; iCnt++) {
				//Execute java script			
				executor.executeScript("arguments[0].style.border='4px groove green'", driver.findElement(by));
				Thread.sleep(500);
				executor.executeScript("arguments[0].style.border=''", driver.findElement(by));			
			}
		}	catch (Exception e) {
			System.out.println("Exception - "+e.getMessage());
		}
	}

	public boolean isTxtPresent(String text, By by) {
		try {
			boolean temp = driver.findElement(by).getText().contains(text);
			return temp;
		} catch (Exception e) {
			return false;
		}
	}

	public void mouseHoverJScript(WebElement HoverElement) {
		try {
			if (isElementPresent(HoverElement)) {

				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				JavascriptExecutor executor = (JavascriptExecutor) driver.getWebDriver();
				executor.executeScript(mouseOverScript,HoverElement);

			} else {
				System.out.println("Element was not visible to hover " + "\n");

			}
		}	catch(Exception e)	{
			e.printStackTrace();
		}
		/*catch (StaleElementReferenceException e) {
		System.out.println("Element with " + HoverElement
				+ "is not attached to the page document"
				+ e.getStackTrace());
	} catch (NoSuchElementException e) {
		System.out.println("Element " + HoverElement + " was not found in DOM"
				+ e.getStackTrace());
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Error occurred while hovering"
				+ e.getStackTrace());
	}*/
	}

	public static boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()
					|| element.isEnabled())
				flag = true;
		}	
		catch(Exception e)	{
		}
		/*catch (NoSuchElementException e) {
		flag = false;
	} catch (StaleElementReferenceException e) {
		flag = false;
	}*/
		return flag;
	}

	public void customDynamicWait(By by, int seconds)		{
		try {
			for(int i=0 ; i<seconds ; i++)	{
				if(driver.findElements(by).size() == 0)
					Thread.sleep(1000);
				else
					break;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebElement getElement(By by)    {

		WebElement obj = null;
		try    {                   
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver.getWebDriver())
					.withTimeout(30, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);
			obj = wait.until(new Function<WebDriver, WebElement>()
			{
				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);
				}
			});
		}      catch (Exception e) {
			// TODO: handle exception
		}
		return obj;
	}


}