package supportlibraries;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.cognizant.framework.FrameworkException;
import com.cognizant.framework.Settings;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import com.opera.core.systems.OperaDriver;

/**
 * Factory class for creating the {@link WebDriver} object as required
 * 
 * @author Cognizant
 */
public class WebDriverFactory {
	private static Properties properties;

	/**
	 * Function to return the appropriate {@link WebDriver} object based on the
	 * parameters passed
	 * 
	 * @param browser
	 *            The {@link Browser} to be used for the test execution
	 * @return The corresponding {@link WebDriver} object
	 */
	public static WebDriver getDriver(Browser browser) {
		WebDriver driver = null;
		properties = Settings.getInstance();
		Boolean proxyRequired = Boolean.parseBoolean(properties
				.getProperty("ProxyRequired"));
		String relativePath = new File(System.getProperty("user.dir")).getAbsolutePath();

		switch (browser) {
		case Chrome:
			// Takes the system proxy settings automatically
			
			//System.setProperty("webdriver.chrome.driver",
				//	properties.getProperty("ChromeDriverPath"));
			
			System.setProperty("webdriver.chrome.driver",
					relativePath + "\\Driver\\" + properties.getProperty("ChromeDriverPath"));
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.quit();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		case Firefox:
			
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.quit();
			// Takes the system proxy settings automatically
			//FirefoxProfile defProfile = new ProfilesIni().getProfile("default");
			FirefoxProfile defProfile = new ProfilesIni().getProfile("default");
			defProfile.setAcceptUntrustedCertificates(true);
			DesiredCapabilities dcFF = DesiredCapabilities.firefox();
			dcFF.setCapability(FirefoxDriver.PROFILE, defProfile);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

			break;

		case HtmlUnit:
			// NTLM authentication for proxy supported

			driver = new HtmlUnitDriver();
			driver.manage().deleteAllCookies();
			driver.quit();
			if (proxyRequired) {
				driver = new HtmlUnitDriver() {
					@Override
					protected WebClient modifyWebClient(WebClient client) {
						DefaultCredentialsProvider credentialsProvider = new DefaultCredentialsProvider();
						credentialsProvider.addNTLMCredentials(properties
								.getProperty("Username"), properties
								.getProperty("Password"), properties
								.getProperty("ProxyHost"), Integer
								.parseInt(properties.getProperty("ProxyPort")),
								"", properties.getProperty("Domain"));
						client.setCredentialsProvider(credentialsProvider);
						return client;
					}
				};

				((HtmlUnitDriver) driver).setProxy(
						properties.getProperty("ProxyHost"),
						Integer.parseInt(properties.getProperty("ProxyPort")));
			} else {
				driver = new HtmlUnitDriver();
			}

			break;

		case InternetExplorer:
			//To manage cookies and settings
			properties = Settings.getInstance();
			System.setProperty("webdriver.ie.driver",
					properties.getProperty("InternetExplorerDriverPath"));
			driver = new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
			driver.quit();
			// Takes the system proxy settings automatically
			//properties = Settings.getInstance();
			System.setProperty("webdriver.ie.driver",
					properties.getProperty("InternetExplorerDriverPath"));
			/*/
			var options = new InternetExplorerDriver();
			options.IntroduceInstabilityByIgnoringProtectedModeSettings = true;
			driver = new InternetExplorerDriver(options);
			//*/
			//*/
			 DesiredCapabilities ieCapabilities = DesiredCapabilities
					.internetExplorer();
			ieCapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							false);
			ieCapabilities.setCapability(
					CapabilityType.ACCEPT_SSL_CERTS, true);
			ieCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,false);
			driver = new InternetExplorerDriver();
			//*/
			break;

		case Opera:
			//To manage cookies and settings
			driver =  new OperaDriver();
			driver.manage().deleteAllCookies();
			driver.quit();
			// NTLM authentication for proxy not supported

			if (proxyRequired) {
				DesiredCapabilities desiredCapabilities = getProxyCapabilities();
				driver = new OperaDriver(desiredCapabilities);
			} else {
				driver = new OperaDriver();
			}

			break;

		case Safari:
			//To manage cookies and settings
			driver =  new SafariDriver();
			driver.manage().deleteAllCookies();
			driver.quit();
			// Note that usage of SafariDriver requires lot of prior
			// configuration
			// Refer http://code.google.com/p/selenium/wiki/SafariDriver for
			// details

			// NTLM authentication for proxy not supported
			/*DesiredCapabilities safariCapabilities = DesiredCapabilities.safari();
			safariCapabilities
			.setCapability(SafariDriver.CLEAN_SESSION_CAPABILITY, true);
			safariCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			safariCapabilities.setCapability(
					CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
					false);*/
			if (proxyRequired) {
				DesiredCapabilities desiredCapabilities = getProxyCapabilities();
				driver = new SafariDriver(desiredCapabilities);
			} else {
				driver = new SafariDriver();
			}
			break;
		}
		driver.manage().deleteAllCookies();
		return driver;
	}

	/**
	 * Function to return the appropriate {@link WebDriver} object based on the
	 * parameters passed
	 * 
	 * @param browser
	 *            The {@link Browser} to be used for the test execution
	 * @param remoteUrl
	 *            The URL of the remote machine to be used for the test
	 *            execution
	 * @return The corresponding {@link WebDriver} object
	 */
	public static WebDriver getDriver(Browser browser, String remoteUrl) {
		return getDriver(browser, null, null, remoteUrl);
	}

	/**
	 * Function to return the appropriate {@link WebDriver} object based on the
	 * parameters passed
	 * 
	 * @param browser
	 *            The {@link Browser} to be used for the test execution
	 * @param browserVersion
	 *            The browser version to be used for the test execution
	 * @param platform
	 *            The {@link Platform} to be used for the test execution
	 * @param remoteUrl
	 *            The URL of the remote machine to be used for the test
	 *            execution
	 * @return The corresponding {@link WebDriver} object
	 */
	public static WebDriver getDriver(Browser browser, String browserVersion,
			Platform platform, String remoteUrl) {
		// For running RemoteWebDriver tests in Chrome and IE:
		// The ChromeDriver and IEDriver executables needs to be in the PATH of
		// the remote machine
		// To set the executable path manually, use:
		// java -Dwebdriver.chrome.driver=/path/to/driver -jar
		// selenium-server-standalone.jar
		// java -Dwebdriver.ie.driver=/path/to/driver -jar
		// selenium-server-standalone.jar

		properties = Settings.getInstance();
		Boolean proxyRequired = Boolean.parseBoolean(properties
				.getProperty("ProxyRequired"));

		DesiredCapabilities desiredCapabilities = null;
		if (proxyRequired) {
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

		desiredCapabilities.setJavascriptEnabled(true); // Pre-requisite for
														// remote execution

		URL url;
		try {
			url = new URL(remoteUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new FrameworkException(
					"The specified remote URL is malformed");
		}

		WebDriver driver = new RemoteWebDriver(url, desiredCapabilities);
		return driver;
	}

	private static DesiredCapabilities getProxyCapabilities() {
		Proxy proxy = new Proxy();
		proxy.setProxyType(ProxyType.MANUAL);

		properties = Settings.getInstance();
		String proxyUrl = properties.getProperty("ProxyHost") + ":"
				+ properties.getProperty("ProxyPort");

		proxy.setHttpProxy(proxyUrl);
		proxy.setFtpProxy(proxyUrl);
		proxy.setSslProxy(proxyUrl);
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(CapabilityType.PROXY, proxy);

		return desiredCapabilities;
	}

	public boolean switchToDifferentWindow(WebDriver driver,
			String strWindowTitle) {
		WebDriver popup = null;
		Boolean blnPopupFound = false;
		//String parentWindowHandle = driver.getWindowHandle();
		@SuppressWarnings("rawtypes")
		java.util.Iterator obj = (java.util.Iterator) driver.getWindowHandles()
				.iterator();
		// Window handle iterator object initiated
		while (obj.hasNext()) {
			String windowHandle = (String) obj.next();
			popup = driver.switchTo().window(windowHandle);
			if (popup.getTitle().contains(strWindowTitle)) {
				popup.get(popup.getCurrentUrl());
				blnPopupFound = true;
				return true;
			}
		}
		if (blnPopupFound)
			return true;
		else
			return false;
	}
}