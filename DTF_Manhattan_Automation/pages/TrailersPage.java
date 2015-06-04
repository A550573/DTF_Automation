package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class TrailersPage extends AnyManhattanPage{

	
	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public TrailersPage(ScriptHelper scriptHelper) {
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
			if (getCurrentPage("TrailersPage"))
				report.updateTestLog("Trailers Page verification", "Trailers Page loaded as expected.", Status.DONE);
			else
				report.updateTestLog("Trailers Page verification", "Trailers page loaded not loaded!!!!", Status.FAIL);
		}
		
		
		private enum enumPageObjects
		{
			Apply, Trailer, CloseTrailer;
		}

		/**
		 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
		 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
		 * 			Values: Apply, Trailer
		 * @return	The WebElement object if it exists. Else returns null
		 */
		private WebElement getPageElement(String strElemName)
		{
			WebElement elemToFind = null;
			try {
				switch (enumPageObjects.valueOf(strElemName)) {
				
				case Trailer:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listView:filterId:trailerLookUpFilterId']", "XPATH");
					break;
				case Apply:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listView:filterId:filterIdapply']", "XPATH");
					break;
				case CloseTrailer:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Close Trailer']", "XPATH");
					break;
				
		
			default:
				break;
			}
			report.updateTestLog("TrailerPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("TrailerPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	
		}
		
		/**
		 *********************************************************************** 
		 * Function enters the trailer number in search box and clicks apply button
		 * @return 	Nothing is returned as of now 
		 * @Author 	Aishwariya
		 * @param 	strTrailer
		 * @version 1.0
		 ***********************************************************************
		 */
		public void searchTrailer(String strTrailer){
			
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]", "XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size()-1));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Trailer"), strTrailer, "Trailer");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");			
			
		}
		
		/**
		 *********************************************************************** 
		 * Function validates trailer table headers
		 * @return 	Nothing is returned as of now 
		 * @Author 	Aishwariya
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void validateTrailerTableHeaders(){
			try {
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Trailer']", "XPATH", "Trailer Header");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Locked']", "XPATH", "Locked Header");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Trailer Status']", "XPATH", "Trailer Status Header");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Appointment']", "XPATH", "Appointment Header");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Shipment']", "XPATH", "Shipment Header");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Purchase Order']", "XPATH", "Purchase Order Header");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='ASN']", "XPATH", "ASN Header");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Current Location']", "XPATH", "Current Location Header");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@id='dataForm:listView:dataTable']//span[text()='Carrier Code']", "XPATH", "ASN Header");
			} catch (IOException e) {
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);
			}
		}
		
		/**
		 *********************************************************************** 
		 * Function validates trailer current location
		 * @return 	Nothing is returned as of now 
		 * @Author 	Aishwariya
		 * @param 	strCurrentLocation
		 * @version 1.0
		 ***********************************************************************
		 */
		public void verifyTrailerCurrentLocation(String strCurrentLocation){							
				try{
					libManhattanCommonFunctions.wait(2000);
					String actualCurrentLocation = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:clocnDOut']", "XPATH").getText();
					if(actualCurrentLocation.trim().equals(strCurrentLocation))
					{
						report.updateTestLog("Trailer Status verification", "Status : "+actualCurrentLocation +" is verified", Status.PASS);
					}else
					{
						report.updateTestLog("Trailer Status verification","Expected Status : "+strCurrentLocation+" Actual Status : "+actualCurrentLocation, Status.FAIL);
					}
					}catch(Exception e){
						report.updateTestLog("Element", "Element Not Found", Status.FAIL);
					}  
			}

		/**
		 *********************************************************************** 
		 * Function validates trailer Status
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strStatus
		 * @version 1.0
		 ***********************************************************************
		 */
		public void validateTrailerStatus(String strStatus){
			try{
				String actualStatus = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:trlStatOut']", "XPATH").getText();
				if(actualStatus.trim().equals(strStatus))
				{
					report.updateTestLog("Trailer Status verification", "Status : "+actualStatus +" is verified", Status.PASS);
				}else
				{
					report.updateTestLog("Trailer Status verification","Expected Status : "+strStatus+" Actual Status : "+actualStatus, Status.FAIL);
				}
				}catch(Exception e){
					report.updateTestLog("Element", "Element Not Found", Status.FAIL);
				}  
		}
		
		/**
		 *********************************************************************** 
		 * Function closes an existing trailer
		 * @return 	Nothing is returned as of now 
		 * @Author 	Nitika
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void closetrailer()
		{
			libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c0_dataForm:listView:dataTable']","XPATH", "CheckBox");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("CloseTrailer"), "Close Trailer");
		}
}
