package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class SortingZonesPage extends AnyManhattanPage{

	
	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public SortingZonesPage(ScriptHelper scriptHelper) {
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
			if (getCurrentPage("SortingZonesPage"))
				report.updateTestLog("Sorting Zone Page verification", "Sorting zone page loaded as expected.", Status.DONE);
			else
				report.updateTestLog("Sorting Zone Page verification", "Sorting zone page loaded not loaded!!!!", Status.FAIL);
		}
		
		
		private enum enumPageObjects
		{
			SortingZone,Apply;
		}

		/**
		 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
		 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
		 * 			Values:SortingZone,Apply
		 * @return	The WebElement object if it exists. Else returns null
		 */
		private WebElement getPageElement(String strElemName)
		{
			WebElement elemToFind = null;
			try {
				switch (enumPageObjects.valueOf(strElemName)) {
				
				case SortingZone:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:sortingZoneMenu']", "XPATH");
					break;
				
			default:
				break;
			}
			report.updateTestLog("SortingZonesPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("SortingZonesPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	
		}
		
		
		/**
		 *********************************************************************** 
		 * Function selects the sorting zone.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	strSortingZone
		 * @version 1.0
		 ***********************************************************************
		 */
		public void selectSortingZone(String strSortingZone){
			try{
				driver.switchTo().defaultContent();
				List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
				driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
				Select SortingZone = new Select(driver.findElement(By.id("dataForm:sortingZoneMenu")));
				SortingZone.selectByVisibleText(strSortingZone);
			}catch(Exception e){
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);
			} 	
		}
		
		/**
		 *********************************************************************** 
		 * Function verifies the locations in the selected sorting zone.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Nitika
		 * @param 	None
		 * @version 1.0
		 * @param strItemNames 
		 ***********************************************************************
		 */
		public void verifyLocS_Zone(String strItemNames){
			try{
				libManhattanCommonFunctions.verifyItemsInList("//select[@id='duallist_DestinationListId']", "XPATH", "Selected Locations List", strItemNames);
				Thread.sleep(2000);
			}catch(Exception e){
				report.updateTestLog("Element", "Element Not Found", Status.FAIL);
			} 	
		}
}
