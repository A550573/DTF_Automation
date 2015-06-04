package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class ManifestedOLPNsPage extends AnyManhattanPage{

	
	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public ManifestedOLPNsPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	
	}	

	/**
	 *********************************************************************** 
	 * Function to verify the current page.
	 * @return 	Nothing is returned as of now 
	 * @param 	None
	 * @version 1.0
	 ***********************************************************************
	 */
		@Override
		protected void initializeUIMap()
		{
			libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
			if (getCurrentPage("ManifestedOLPNsPage"))
				report.updateTestLog("Manifested OLPNs Page verification", "Manifested OLPNs Page loaded as expected.", Status.DONE);
			else
				report.updateTestLog("Manifested OLPNs Page verification", "Manifested OLPNs Page loaded not loaded!!!!", Status.FAIL);
		}
		
		
		private enum enumPageObjects
		{
			Apply, OLPN, DeManifestOLPN;
		}

		/**
		 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
		 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
		 * 			Values: Apply, Manifest;
		 * @return	The WebElement object if it exists. Else returns null
		 */
		private WebElement getPageElement(String strElemName)
		{
			WebElement elemToFind = null;
			try {
				switch (enumPageObjects.valueOf(strElemName)) {
				
				case OLPN:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:lview:filterId:field10value1']", "XPATH");
					break;
				case Apply:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Apply' and @title='Apply'])[1]", "XPATH");
					break;
				case DeManifestOLPN:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='De-Manifest oLPN']", "XPATH");
					break;
				
			default:
				break;
			}
			report.updateTestLog("Manifested OLPNs Page - GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("Manifested OLPNs Page - GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	
		}
	
		/**
		 *********************************************************************** 
		 * Function Enters OLPN in the search box and clicks apply button
		 * @return 	Nothing is returned as of now 
		 * @Author 	Rahman
		 * @param 	strManifest
		 * @version 1.0
		 * @throws InterruptedException 
		 ***********************************************************************
		 */
		public void enterOLPN(String strOLPN) throws InterruptedException{
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("OLPN"), strOLPN, "OLPN");
			Thread.sleep(3000);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");	
			Thread.sleep(3000);
		}
		/**
		 *********************************************************************** 
		 * Function selects OLPN that is displayed
		 * @return 	Nothing is returned as of now 
		 * @Author 	Rahman
		 * @param 	None
		 * @version 1.0 
		 * @throws InterruptedException 
		 ***********************************************************************
		 */
		public void selectOLPN() throws InterruptedException {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			libManhattanCommonFunctions
			.clickAnyElement(
					"//input[@id='checkAll_c0_dataForm:lview:dataTable']",
					"XPATH", "CheckBox");
			Thread.sleep(3000);

		}
		/**
		 *********************************************************************** 
		 * Function Clicks De-Manifest OLPN button
		 * @return 	Nothing is returned as of now 
		 * @Author 	Rahman
		 * @param 	none
		 * @version 1.0
		 * @throws InterruptedException 
		 ***********************************************************************
		 */
		public void clickOnDeManifestOLPN() throws InterruptedException{
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			libManhattanCommonFunctions.clickAnyElement(getPageElement("DeManifestOLPN"), "DE-Manifest OLPN Button");	
			Thread.sleep(3000);
		}
		
		
		
		/**
		 *********************************************************************** 
		 * Function verifies the displayed error msg
		 * @return 	Nothing is returned as of now 
		 * @Author 	Nitika
		 * @param 	none
		 * @version 1.0
		 * @throws InterruptedException 
		 ***********************************************************************
		 */
		public void verifyerrormsg(String strMsg)
		{
			if(libManhattanCommonFunctions.verifyElementPresent("//li[contains(text(),'"+strMsg+"')]", "XPATH")){
				report.updateTestLog("oLPn Page", "oLPN cannot be manifested, Error Msg : "+strMsg+"", Status.PASS);
			}else{
				report.updateTestLog("oLPn Page", "Invalid oLPN", Status.FAIL);
			}
		}
}

