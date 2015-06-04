package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class TariffPage extends AnyManhattanPage{

	
	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public TariffPage(ScriptHelper scriptHelper) {
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
			if (getCurrentPage("TariffPage"))
				report.updateTestLog("Tariff Page verification", "Tariff page loaded as expected.", Status.DONE);
			else
				report.updateTestLog("Tariff Page verification", "Tariff page loaded not loaded!!!!", Status.FAIL);
		}
		
		
		private enum enumPageObjects
		{
			SavedViews,Apply, RouteTo, RouteType1, RouteType2, ExpandButton;
		}

		/**
		 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
		 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
		 * 			Values: DockDoor, Dock, Apply, DockDoorHeader, DockHeader, DockField, DockDoorField, ShipmentField, FacilityField, StatusField, ASNField, TrailerField, CarrierField, DockDoorStatus.
		 * @return	The WebElement object if it exists. Else returns null
		 */
		private WebElement getPageElement(String strElemName)
		{
			WebElement elemToFind = null;
			try {
				switch (enumPageObjects.valueOf(strElemName)) {
				
				case SavedViews:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@class='x-form-field x-form-text'])[2]", "XPATH");
					break;
				case Apply:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'Apply')]", "XPATH");
					break;
				case RouteTo:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//div[@id='displayfield-1109-inputEl']", "XPATH");
					break;
				case RouteType1:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//div[@id='displayfield-1113-inputEl']", "XPATH");
					break;
				case RouteType2:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//div[@id='displayfield-1117-inputEl']", "XPATH");
					break;
				case ExpandButton:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@class='x-tool-expand-right']", "XPATH");
					break;
			default:
				break;
			}
			report.updateTestLog("TariffPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("TariffPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	
		}
		
		/**
		 *********************************************************************** 
		 * Function selects the service level
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya
		 * @param 	strServiceLevel
		 * @version 1.0
		 * @throws InterruptedException 
		 ***********************************************************************
		 */
		public void selectServiceLevel(String strServiceLevel) throws InterruptedException{
			Thread.sleep(5000);
			List<WebElement> list = driver.findElements(By.xpath(".//*[@class=' x-grid-cell x-grid-cell-gridcolumn-1306   ']//div[1]"));
			int strRowNumToBeChecked = 1;
			for(WebElement ele:list){
				if(ele.getText().trim().contains(strServiceLevel.trim())){
					break;
				}else{
					strRowNumToBeChecked = strRowNumToBeChecked + 1;
					continue;
				}
				
			}
			libManhattanCommonFunctions.clickAnyElement("(.//*[@class=' x-grid-cell x-grid-cell-gridcolumn-1306   ']//div[1])["+strRowNumToBeChecked+"]", "XPATH", "Service Level");		
		}
		
		/**
		 *********************************************************************** 
		 * Function selects the least price
		 * @return 	leastPrice
		 * @Author 	Yagna Priya
		 * @param 	None
		 * @version 1.0
		 * @throws InterruptedException 
		 ***********************************************************************
		 */
		public void selectLeastPrice() throws InterruptedException{
			Thread.sleep(8000);
			libManhattanCommonFunctions.clickAnyElement("//div[@id='gridcolumn-1355-titleEl']", "XPATH", "Rate Header");
			Thread.sleep(8000);
			String strMinimumRate = libManhattanCommonFunctions.getElementByProperty(".//*[@class=' x-grid-cell x-grid-cell-gridcolumn-1355   ']", "XPATH").getText();
			System.out.println("Minimum Rate : "+strMinimumRate);
			report.updateTestLog("TariffPage","Minimum Rate is : "+strMinimumRate, Status.PASS);
		}
}
