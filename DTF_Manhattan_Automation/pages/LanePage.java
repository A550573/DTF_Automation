package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class LanePage extends AnyManhattanPage{
	ManhattanCommonFunctions libManhattanCommonFunctions;

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public LanePage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub

		try {
		} catch (Exception e) {
			report.updateTestLog("Lane-OBJECT IDENTIFICATION","Error in finding Page Object/element : " + e.getMessage(),Status.FAIL);
		}
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
		
		if (getCurrentPage("LanePage"))
		{
			report.updateTestLog("Lane Page verification", "Lane page loaded as expected.", Status.DONE);
		}
		else{
			report.updateTestLog("Lane Page verification", "Lane page loaded not loaded!!!!", Status.FAIL);
		}
	}


	private enum enumPageObjects
	{
		SavedViews,Apply, RouteTo, RouteType1, RouteType2, ExpandButton;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: SavedViews,Apply, RouteTo, RouteType1, RouteType2, ExpandButton.
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case SavedViews:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@id='combobox-1164-inputEl'])", "XPATH");
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
			report.updateTestLog("LanePage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("LanePage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}

	/**
	 *********************************************************************** 
	 * Function enters the saved view and clicks on apply button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strSavedView
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void selectView(String strSavedView) throws InterruptedException{

		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		//libManhattanCommonFunctions.waitForElementClickable("//*[@class='x-tool-expand-right']", 4000);
		//if(libManhattanCommonFunctions.isElementPresentVerification(getPageElement("ExpandButton"), "Expand Button")){
			libManhattanCommonFunctions.clickAnyElement(getPageElement("ExpandButton"), "Expand Button");
		//}
			Thread.sleep(5000);

		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("SavedViews"), strSavedView, "Saved View");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Apply"), "Apply");					
	}

	/**
	 *********************************************************************** 
	 * Function selects the lane id
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strLaneID
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	//@SuppressWarnings("static-access")
	public void selectLaneID(String strLaneID) throws InterruptedException{
		Thread.sleep(4000);
		//libManhattanCommonFunctions.fluentWait(driver, By.xpath(".//*[@class=' x-grid-cell x-grid-cell-gridcolumn-1265   ']//div[1]"));
		//libManhattanCommonFunctions.waitForElementVisibility(".//*[@class=' x-grid-cell x-grid-cell-gridcolumn-1353   ']//div[1]", 10000);
		List<WebElement> list = driver.findElements(By.xpath(".//*[@class=' x-grid-cell x-grid-cell-gridcolumn-1263   ']//div[1]"));
		int strRowNumToBeChecked = 1;
		for(WebElement ele:list){
			if(ele.getText().trim().contains(strLaneID.trim())){
				break;
			}else{
				strRowNumToBeChecked = strRowNumToBeChecked + 1;
				continue;
			}
		}
		libManhattanCommonFunctions.clickAnyElement("(.//*[@class='x-grid-row-checker'])["+strRowNumToBeChecked+"]", "XPATH", "CheckBox");		
	}

	/**
	 *********************************************************************** 
	 * Function validates route details
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strRouteTo, strRouteType1, strRouteType2
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateRouteDetails(String strRouteTo, String strRouteType1, String strRouteType2 ){							
		try{
			Thread.sleep(3000);
			String strActualRouteTo = libManhattanCommonFunctions.getElementByProperty("//div[@id='displayfield-1128-inputEl']", "XPATH").getText();
			String strActualRouteType1 = libManhattanCommonFunctions.getElementByProperty("//div[@id='displayfield-1132-inputEl']", "XPATH").getText();
			String strActualRouteType2 = libManhattanCommonFunctions.getElementByProperty("//div[@id='displayfield-1136-inputEl']", "XPATH").getText();
			if(strActualRouteTo.trim().toLowerCase().equals(strRouteTo.trim().toLowerCase()) && strActualRouteType1.trim().toLowerCase().equals(strRouteType1.trim().toLowerCase()) && strActualRouteType2.trim().toLowerCase().equals(strRouteType2.trim().toLowerCase()))
			{
				report.updateTestLog("Route Details verification", "Route To : "+strActualRouteTo +" || Route Type 1 : "+strActualRouteType1+" || Route Type 2 : "+strActualRouteType2+" is verified", Status.PASS);
			}else
			{
				report.updateTestLog("Route Details verification","Expected Route to : "+strRouteTo+" || Actual Route To : "+strActualRouteTo +" || Expected Route Type 1 : "+strRouteType1+" || Actual Route Type 1 : "+strActualRouteType1+" || Expected Route Type 2 : "+strRouteType2+" || Actual Route Type 2 : "+strActualRouteType2+" is verified", Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}  
	}

	/**
	 *********************************************************************** 
	 * Function verifies if the service level exists in the list
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strServiceLevel
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void verifyServiceLevel(String strServiceLevel){
		
		List<WebElement> list = driver.findElements(By.xpath(".//*[@class=' x-grid-cell x-grid-cell-gridcolumn-1153   ']//div[1]"));
		int strRowNumToBeChecked = 1;
		for(WebElement ele:list){
			if(ele.getText().trim().contains(strServiceLevel.trim())){
				report.updateTestLog("Service Level verification", strServiceLevel+" is present", Status.PASS);
				break;
			}else{
				strRowNumToBeChecked = strRowNumToBeChecked + 1;
				continue;
			}
		}	
	}
}
