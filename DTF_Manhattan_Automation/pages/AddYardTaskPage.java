package pages;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class AddYardTaskPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public AddYardTaskPage(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}	

	/**
	 *********************************************************************** 
	 * Function to enable access to the methods.
	 * @return Nothing is returned as of now  
	 * @param scriptHelper
	 * @version 1.0
	 ***********************************************************************
	 */
	@Override
	protected void initializeUIMap()
	{
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		if (getCurrentPage("AddYardTaskPage"))
			report.updateTestLog("Add Yard Task Page verification", "Add Yards Task loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Add Yard Task Page verification", "Add Yards Task page not loaded!!!!", Status.FAIL);
	}


	private enum enumPageObjects
	{
		Facility, Carrier, Trailer, AssignedUser, DestinationLocation, TaskType, Priority, Save, YardTask, Apply, SearchDestinationBtn, Find, SelectDestination, SelectBtn;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: Facility, Carrier, Trailer, AssignedUser, DestinationLocation, TaskType, Priority, Save, YardTask, Apply, SearchDestinationBtn, Find, SelectDestination, SelectBtn
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case Facility:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:fac00122']", "XPATH");
				break;
			case Carrier:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:b16322']", "XPATH");
				break;
			case Trailer:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:b1622']", "XPATH");
				break;
			case AssignedUser:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:b1322']", "XPATH");
				break;
			case DestinationLocation:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:tskDestnLocn']", "XPATH");
				break;
			case TaskType:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:tskTypeSel']", "XPATH");
				break;
			case Priority:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:c2CondType1122']", "XPATH");
				break;
			case Save:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='rmButton_1Save1_167271240']", "XPATH");
				break;
			case YardTask:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:filterId:field10value1']", "XPATH");
				break;
			case Apply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:listView:filterId:filterIdapply']", "XPATH");
				break;
			case SearchDestinationBtn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:dstLkp']", "XPATH");
				break;
			case Find:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ymLocn_locgetlist1']", "XPATH");
				break;
			case SelectDestination:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ymslocnText1']//option", "XPATH");
				break;
			case SelectBtn:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='dataForm:ymLocn_SelectButton1']", "XPATH");
				break;


			default:
				break;
			}
			report.updateTestLog("AddYardTaskPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("AddYardTaskPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}

	/**
	 *********************************************************************** 
	 * Function enters the details to add an yard task.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Yagna Priya
	 * @param 	strFacility,strCarrier,strTrailer,strAssignedUser,
	 * 			strDestinationLocation,strTaskType,strPriority.
	 * @version 1.0
	 * @throws 	InterruptedException 
	 * @throws 	IOException 
	 ***********************************************************************
	 */
	public void enterYardTaskDetails(String strFacility, String strCarrier, String strTrailer, String strAssignedUser, String strDestinationLocation, String strTaskType, String strPriority) throws InterruptedException, IOException{
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("DestinationLocation"), strDestinationLocation, "DestinationLocation");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Carrier"), strCarrier, "Carrier");
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Trailer"), strTrailer, "Trailer");	
		Select TaskType = new Select(driver.findElement(By.id("dataForm:tskTypeSel")));
		TaskType.selectByVisibleText(strTaskType);
		Select Priority = new Select(driver.findElement(By.id("dataForm:c2CondType1122")));
		Priority.selectByVisibleText(strPriority);
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("AssignedUser"), strAssignedUser, "AssignedUser");

		libManhattanCommonFunctions.clickAnyElement(getPageElement("Save"), "Save");
		if(libManhattanCommonFunctions.verifyElementPresent("//a[contains(text(),'Override')]", "XPATH")){

			driver.findElement(By.xpath("//a[contains(text(),'Override')]")).click();
			driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
			Select overrideText = new Select(driver.findElement(By.id("dataForm:softcheckerrorsTable:0:reasoncode")));
			List <WebElement> wbItem = overrideText.getOptions();
			for (WebElement ele : wbItem){
				String strValue = ele.getText();
				if (strValue.contains("Yard Task Cancel"))
					overrideText.selectByVisibleText(strValue);
			}

			driver.findElement(By.xpath("//input[@value='save']")).click();
			if(libManhattanCommonFunctions.verifyElementPresent(".//*[contains(text(),'Move task already exists.')]", "XPATH"))

				report.updateTestLog("Add Yard Task Details", "Move task already exists", Status.FAIL);
			else
				report.updateTestLog("Add Yard Task Details", "Move task created", Status.PASS);
		}
		else if(libManhattanCommonFunctions.verifyElementPresent(".//*[contains(text(),'Move task already exists.')]", "XPATH"))

			report.updateTestLog("Add Yard Task Details", "Move task already exists for the destination location", Status.FAIL);
		else 
			report.updateTestLog("Add Yard Task Details", "Move task created", Status.PASS);		
	}

}
