package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class DistributionOrderDetailsPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public DistributionOrderDetailsPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("DistributionOrderDetailsPage"))
			report.updateTestLog("Distribution Order Details Page verification", "Distribution Order Details loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Distribution Order Details Page verification", "Distribution Order Details page loaded not loaded!!!!", Status.FAIL);
	}

	private enum enumPageObjects
	{
		btnSave;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: Apply, DistributionOrderID, BtnView, BtnCancel
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case btnSave:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//button[contains(text(),'Save')]", "XPATH");
				break;

			default:
				break;
			}
			report.updateTestLog("DistributionOrderDetailsPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("DistributionOrderDetailsPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}

	/**
	 ************************************************************************ 
	 * Function edits the delivery End date
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strDate
	 * @version 1.0
	 ************************************************************************
	 */
	public void EditDeliveryEndDate(String strDate){
		try{		
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			libManhattanCommonFunctions.clearAndEnterText("//input[@id='deliveryEndDTTMString06']", "XPATH", strDate);
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSave"), "Save Button");	
			Thread.sleep(2000);
		}catch(Exception e){

		}
	}

}
