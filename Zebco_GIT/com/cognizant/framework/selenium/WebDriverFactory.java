package com.cognizant.framework.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.*;

import com.cognizant.framework.FrameworkException;
import com.cognizant.framework.Settings;

/**
 * Factory class for creating the {@link WebDriver} object as required
 * 
 * @author Cognizant
 */
public class WebDriverFactory {
	private static Properties properties;

	private WebDriverFactory() {
		// To prevent external instantiation of this class
	}

	/**
	 * Function to return the appropriate {@link WebDriver} object based on the
	 * parameters passed
	 * 
	 * @param browser
	 *            The {@link Browser} to be used for the test execution
	 * @return The corresponding {@link WebDriver} object changed by Satyajit on
	 *         04-04-2017 02:10pm IST
	 */
	public static WebDriver getWebDriver(Browser browser) {
		WebDriver driver = null;
		properties = Settings.getInstance();
		boolean proxyRequired = Boolean.parseBoolean(properties.getProperty("ProxyRequired"));

		switch (browser) {
		case CHROME:
			// Takes the system proxy settings automatically

			System.setProperty("webdriver.chrome.driver", properties.getProperty("ChromeDriverPath"));

		 

			ChromeOptions options = new ChromeOptions();
			DesiredCapabilities capabilities_chrome = DesiredCapabilities.chrome();
			capabilities_chrome.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			options.addArguments("test-type");
			//options.addArguments("start-maximized");

			options.addArguments("--js-flags=--expose-gc");
			options.addArguments("--enable-precise-memory-info");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-default-apps");
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars");
			


			// options.addArguments("--dns-prefetch-disable");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
			break;

		case FIREFOX:
			// Takes the system proxy settings automatically
			System.setProperty("webdriver.gecko.driver", properties.getProperty("GeckoDriverPath"));

			// System.setProperty("webdriver.firefox.logfile","D:\\FirefoxLog.log");
			// DesiredCapabilities capabilities = new DesiredCapabilities();
			// DesiredCapabilities capabilities = getProxyCapabilities();
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			capabilities.setCapability("acceptInsecureCerts", true);
			capabilities.setCapability("assume_untrusted_cert_issuer", true);
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			// capabilities.setCapability("specificationLevel", 1);
			// capabilities.setCapability("firefox_binary","C:\\Users\\566479\\AppData\\Local\\Nightly\\firefox.exe");
			// capabilities.setCapability("firefox_binary","C:\\Users\\566479\\AppData\\Local\\Mozilla
			// Firefox\\firefox.exe");
			driver = new FirefoxDriver(capabilities);

			// driver = new FirefoxDriver();
			break;

		case GHOST_DRIVER:
			// Takes the system proxy settings automatically (I think!)

			System.setProperty("phantomjs.binary.path",
			properties.getProperty("PhantomJSPath"));
			driver = new PhantomJSDriver();
			break;

			/*System.setProperty("webdriver.chrome.driver", properties.getProperty("ChromeDriverPath"));
			ChromeOptions options2 = new ChromeOptions();
			DesiredCapabilities capabilities_chrome2 = DesiredCapabilities.chrome();
			capabilities_chrome2.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			options2.addArguments("test-type");
			options2.addArguments("start-maximized");
			options2.addArguments("--window-size=1366,768");
			options2.addArguments("--headless");
			options2.addArguments("--disable-gpu");*/
			//options2.addArguments("--no-sandbox");
			//options2.addArguments("--disable-dev-shm-usage");


			// options.addArguments("--dns-prefetch-disable");
			/*Map<String, Object> prefs2 = new HashMap<String, Object>();
			prefs2.put("credentials_enable_service", false);
			options2.setExperimentalOption("prefs", prefs2);

			driver = new ChromeDriver(options2);*/
			//break;

		case INTERNET_EXPLORER:
			// Takes the system proxy settings automatically

			System.setProperty("webdriver.ie.driver", properties.getProperty("InternetExplorerDriverPath"));

			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

			ieCapabilities.setCapability("nativeEvents", false);
			ieCapabilities.setCapability("ignoreZoomSetting", true);
			ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
			ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
			ieCapabilities.setCapability("disable-popup-blocking", true);
			ieCapabilities.setCapability("enablePersistentHover", true);
			ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			driver = new InternetExplorerDriver(ieCapabilities);
			break;

		case OPERA:
			// Does not take the system proxy settings automatically!
			// NTLM authentication for proxy NOT supported

			if (proxyRequired) {
				DesiredCapabilities desiredCapabilities = getProxyCapabilities();
				driver = new OperaDriver(desiredCapabilities);
			} else {
				driver = new OperaDriver();
			}

			break;

		case SAFARI:
			// Takes the system proxy settings automatically

			driver = new SafariDriver();
			break;
		
		case HTML_UNIT:
			driver=new HtmlUnitDriver();
			break;
			
		
		default:
			throw new FrameworkException("Unhandled browser!");
		}

		return driver;
	}

	private static DesiredCapabilities getProxyCapabilities() {
		properties = Settings.getInstance();
		String proxyUrl = properties.getProperty("ProxyHost") + ":" + properties.getProperty("ProxyPort");

		Proxy proxy = new Proxy();
		proxy.setProxyType(ProxyType.MANUAL);
		proxy.setHttpProxy(proxyUrl);
		proxy.setFtpProxy(proxyUrl);
		proxy.setSslProxy(proxyUrl);

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(CapabilityType.PROXY, proxy);

		return desiredCapabilities;
	}

	/**
	 * Function to return the {@link RemoteWebDriver} object based on the parameters
	 * passed
	 * 
	 * @param browser
	 *            The {@link Browser} to be used for the test execution
	 * @param browserVersion
	 *            The browser version to be used for the test execution
	 * @param platform
	 *            The {@link Platform} to be used for the test execution
	 * @param remoteUrl
	 *            The URL of the remote machine to be used for the test execution
	 * @return The corresponding {@link RemoteWebDriver} object
	 */
	public static WebDriver getRemoteWebDriver(Browser browser, String browserVersion, Platform platform,
			String remoteUrl) {
		// For running RemoteWebDriver tests in Chrome and IE:
		// The ChromeDriver and IEDriver executables needs to be in the PATH of the
		// remote machine
		// To set the executable path manually, use:
		// java -Dwebdriver.chrome.driver=/path/to/driver -jar
		// selenium-server-standalone.jar
		// java -Dwebdriver.ie.driver=/path/to/driver -jar
		// selenium-server-standalone.jar

		properties = Settings.getInstance();
		boolean proxyRequired = Boolean.parseBoolean(properties.getProperty("ProxyRequired"));

		DesiredCapabilities desiredCapabilities = null;
		if (browser.equals(Browser.OPERA) && proxyRequired) {
			desiredCapabilities = getProxyCapabilities();
		} else {
			desiredCapabilities = new DesiredCapabilities();
		}

		desiredCapabilities.setBrowserName(browser.getValue());

		if (browserVersion != null) {
			desiredCapabilities.setVersion(browserVersion);
		}
		if (platform != null) {
			desiredCapabilities.setPlatform(platform);
		}

		desiredCapabilities.setJavascriptEnabled(true); // Pre-requisite for remote execution

		URL url = getUrl(remoteUrl);

		return new RemoteWebDriver(url, desiredCapabilities);
	}

	private static URL getUrl(String remoteUrl) {
		URL url;
		try {
			url = new URL(remoteUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new FrameworkException("The specified remote URL is malformed");
		}
		return url;
	}

	/**
	 * Function to return the {@link RemoteWebDriver} object based on the parameters
	 * passed
	 * 
	 * @param browser
	 *            The {@link Browser} to be used for the test execution
	 * @param remoteUrl
	 *            The URL of the remote machine to be used for the test execution
	 * @return The corresponding {@link RemoteWebDriver} object
	 */
	public static WebDriver getRemoteWebDriver(Browser browser, String remoteUrl) {
		return getRemoteWebDriver(browser, null, null, remoteUrl);
	}

	/**
	 * Function to return the {@link ChromeDriver} object emulating the device
	 * specified by the user
	 * 
	 * @param deviceName
	 *            The name of the device to be emulated (check Chrome Dev Tools for
	 *            a list of available devices)
	 * @return The corresponding {@link ChromeDriver} object
	 */
	public static WebDriver getEmulatedWebDriver(String deviceName) {
		DesiredCapabilities desiredCapabilities = getEmulatedChromeDriverCapabilities(deviceName);

		properties = Settings.getInstance();
		System.setProperty("webdriver.chrome.driver", properties.getProperty("ChromeDriverPath"));

		return new ChromeDriver(desiredCapabilities);
	}

	private static DesiredCapabilities getEmulatedChromeDriverCapabilities(String deviceName) {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", deviceName);

		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);

		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

		return desiredCapabilities;
	}

	/**
	 * Function to return the {@link RemoteWebDriver} object emulating the device
	 * specified by the user
	 * 
	 * @param deviceName
	 *            The name of the device to be emulated (check Chrome Dev Tools for
	 *            a list of available devices)
	 * @param remoteUrl
	 *            The URL of the remote machine to be used for the test execution
	 * @return The corresponding {@link RemoteWebDriver} object
	 */
	public static WebDriver getEmulatedRemoteWebDriver(String deviceName, String remoteUrl) {
		DesiredCapabilities desiredCapabilities = getEmulatedChromeDriverCapabilities(deviceName);
		desiredCapabilities.setJavascriptEnabled(true); // Pre-requisite for remote execution

		URL url = getUrl(remoteUrl);

		return new RemoteWebDriver(url, desiredCapabilities);
	}

	/**
	 * Function to return the {@link ChromeDriver} object emulating the device
	 * attributes specified by the user
	 * 
	 * @param deviceWidth
	 *            The width of the device to be emulated (in pixels)
	 * @param deviceHeight
	 *            The height of the device to be emulated (in pixels)
	 * @param devicePixelRatio
	 *            The device's pixel ratio
	 * @param userAgent
	 *            The user agent string
	 * @return The corresponding {@link ChromeDriver} object
	 */
	public static WebDriver getEmulatedWebDriver(int deviceWidth, int deviceHeight, float devicePixelRatio,
			String userAgent) {
		DesiredCapabilities desiredCapabilities = getEmulatedChromeDriverCapabilities(deviceWidth, deviceHeight,
				devicePixelRatio, userAgent);

		properties = Settings.getInstance();
		System.setProperty("webdriver.chrome.driver", properties.getProperty("ChromeDriverPath"));

		return new ChromeDriver(desiredCapabilities);
	}

	private static DesiredCapabilities getEmulatedChromeDriverCapabilities(int deviceWidth, int deviceHeight,
			float devicePixelRatio, String userAgent) {
		Map<String, Object> deviceMetrics = new HashMap<String, Object>();
		deviceMetrics.put("width", deviceWidth);
		deviceMetrics.put("height", deviceHeight);
		deviceMetrics.put("pixelRatio", devicePixelRatio);

		Map<String, Object> mobileEmulation = new HashMap<String, Object>();
		mobileEmulation.put("deviceMetrics", deviceMetrics);
		// mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us;
		// Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko)
		// Chrome/18.0.1025.166 Mobile Safari/535.19");
		mobileEmulation.put("userAgent", userAgent);

		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);

		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		return desiredCapabilities;
	}

	/**
	 * Function to return the {@link RemoteWebDriver} object emulating the device
	 * attributes specified by the user
	 * 
	 * @param deviceWidth
	 *            The width of the device to be emulated (in pixels)
	 * @param deviceHeight
	 *            The height of the device to be emulated (in pixels)
	 * @param devicePixelRatio
	 *            The device's pixel ratio
	 * @param userAgent
	 *            The user agent string
	 * @param remoteUrl
	 *            The URL of the remote machine to be used for the test execution
	 * @return The corresponding {@link RemoteWebDriver} object
	 */
	public static WebDriver getEmulatedRemoteWebDriver(int deviceWidth, int deviceHeight, float devicePixelRatio,
			String userAgent, String remoteUrl) {
		DesiredCapabilities desiredCapabilities = getEmulatedChromeDriverCapabilities(deviceWidth, deviceHeight,
				devicePixelRatio, userAgent);
		desiredCapabilities.setJavascriptEnabled(true); // Pre-requisite for remote execution

		URL url = getUrl(remoteUrl);

		return new RemoteWebDriver(url, desiredCapabilities);
	}

}