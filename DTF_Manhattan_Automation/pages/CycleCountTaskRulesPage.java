package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class CycleCountTaskRulesPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public CycleCountTaskRulesPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("CycleCountTaskRulesPage"))
			report.updateTestLog("Cycle Count Task Rules Page verification", "Cycle Count loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Cycle Count Task Rules Page verification", "Cycle Count page loaded not loaded!!!!", Status.FAIL);
	}


	private enum enumPageObjects
	{
		Apply,  Add, Run, Criteria, CriteriaDescription, DateandTime, Save, RuleName, TaskDescription, TaskPriority;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: Apply
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case Apply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("(//input[@value='Apply' and @title='Apply'])[1]", "XPATH");
				break;
			case Add:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//input[@value='Add']", "XPATH");
				break;
			case Criteria:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//input[@name='dataForm:critNbr']", "XPATH");
				break;
			case CriteriaDescription:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//input[@name='dataForm:critDesc']", "XPATH");
				break;
			case Run:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//input[@value='Run']", "XPATH");
				break;
			case DateandTime:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//input[@id='dataForm:nextCntDateTim']", "XPATH");
				break;
			case Save:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//input[@value='Save']", "XPATH");
				break;
			case RuleName:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//input[@id='dataForm:ruleNameInputBox']", "XPATH");
				break;
			case TaskDescription:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//input[@id='dataForm:taskDescInputBox']", "XPATH");
				break;
			case TaskPriority:
				elemToFind = libManhattanCommonFunctions.getElementByProperty(".//input[@id='dataForm:taskPrtyInputBox']", "XPATH");
				break;

			default:
				break;
			}
			report.updateTestLog("Cycle Count Task Rules Page- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("Cycle Count Task Rules Page- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}

	/**
	 *********************************************************************** 
	 * Function clicks on check box for the Task criteria
	 * @return 	Nothing is returned as of now 
	 * @Author 	Hifzur Rahman
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void SelectTaskCheckBox() {
		try {
			libManhattanCommonFunctions.clickAnyElement(getPageElement("TaskCheckBox"), "Check Box");//xpath not mapped
		} catch (Exception e) {
			report.updateTestLog("Cycle Count Task Rules Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function clicks on Add button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Hifzur Rahman
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void clickAddButton() {
		try {
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Add"), "Add button");
			Thread.sleep(2000);
		} catch (Exception e) {
			report.updateTestLog("Cycle Count Task Rules Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function clicks on Run button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Hifzur Rahman
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void clickRunButton() {
		try {
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Run"), "Add button");
			Thread.sleep(2000);
		} catch (Exception e) {
			report.updateTestLog("Cycle Count Task Rules Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function clicks on Add button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Hifzur Rahman
	 * @param 	None
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void clickSaveButton() {
		try {
			libManhattanCommonFunctions.clickAnyElement(getPageElement("Add"), "Add button");
			Thread.sleep(2000);
		} catch (Exception e) {
			report.updateTestLog("Cycle Count Task Rules Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function enters Criteria
	 * @return 	Nothing is returned as of now 
	 * @Author 	Hifzur Rahman 
	 * @param 	strCriteria
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void EnterCriteria(String strCriteria) {
		try {
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Criteria"), strCriteria,"Criteria");			
		} catch (Exception e) {
			report.updateTestLog("Cycle Count Task Rules Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function enters Criteria Description.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Hifzur Rahman 
	 * @param 	strCriDesp
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void EnterCriteriaDescription(String strCriDesp) {
		try {
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("CriteriaDescription"), strCriDesp,"Criteria Description");			
		} catch (Exception e) {
			report.updateTestLog("Cycle Count Task Rules Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function selects Count frequency
	 * @return 	Nothing is returned as of now 
	 * @Author 	Hifzur Rahman 
	 * @param 	strCountFrequency
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void SelectCountFrequency(String strCountFrequency) {
		try {		
			Select CountFrequency = new Select(driver.findElement(By.name("dataForm:cntfreq")));
			CountFrequency.selectByVisibleText(strCountFrequency);
		} catch (Exception e) {
			report.updateTestLog("Cycle Count Task Rules Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function selects Count Date and Time
	 * @return 	Nothing is returned as of now 
	 * @Author 	Hifzur Rahman 
	 * @param 	strDateTime
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void SelectCountDateandTime(String strDateTime) {
		try {			
			//			.//input[@title='Select date and time'] .//td[@class='day selected today']
			//			libManhattanCommonFunctions.clickAnyElement(getPageElement("Calendar"), "Calendar");
			Thread.sleep(2000);
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("DateandTime"), strDateTime,"Criteria");
			Thread.sleep(2000);
		} catch (Exception e) {
			report.updateTestLog("Cycle Count Task Rules Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function selects Update Last Count Date
	 * @return 	Nothing is returned as of now 
	 * @Author 	Hifzur Rahman 
	 * @param 	strUpdateLastCountDate
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void SelectUpdateLastCountDate(String strUpdateLastCountDate) {
		try {		
			Select UpdateLastCountDate = new Select(driver.findElement(By.name("dataForm:cntfreq")));
			UpdateLastCountDate.selectByVisibleText(strUpdateLastCountDate);
		} catch (Exception e) {
			report.updateTestLog("Cycle Count Task Rules Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function selects Column
	 * @return 	Nothing is returned as of now 
	 * @Author 	Hifzur Rahman 
	 * @param 	strColumn
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void SelectColumn(String strColumn) {
		try {		
			Select Column = new Select(driver.findElement(By.name("dataForm:ruleSelDtlDataTable:newRow_1:ruleSelDtlColumnList")));
			Column.selectByVisibleText(strColumn);
		} catch (Exception e) {
			report.updateTestLog("Cycle Count Task Rules Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function selects Operator
	 * @return 	Nothing is returned as of now 
	 * @Author 	Hifzur Rahman 
	 * @param 	strOperator
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void SelectOperator(String strOperator) {
		try {		
			Select Operator = new Select(driver.findElement(By.name("dataForm:ruleSelDtlDataTable:newRow_1:ruleSelDtlOperatorList")));
			Operator.selectByVisibleText(strOperator);
		} catch (Exception e) {
			report.updateTestLog("Cycle Count Task Rules Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function enters Comparison Value.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Hifzur Rahman 
	 * @param 	strCompVal
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void EnterComparisonValue(String strCompVal) {
		try {
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ComparisonValue"), strCompVal,"Comparison Value");			
		} catch (Exception e) {
			report.updateTestLog("Cycle Count Task Rules Page", "Element Not Found",Status.FAIL);
		}
	}

	/**
	 *********************************************************************** 
	 * Function enters Parameters.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Hifzur Rahman 
	 * @param 	strRuleName,strTaskDesc,strTaskPriority,strCreationStatus
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void EnterParameters(String strRuleName,String strTaskDesc,String strTaskPriority,String strCreationstatus) {
		try {
			driver.switchTo().defaultContent();
			List<WebElement> listOfFrames = libManhattanCommonFunctions.getElementsByProperty("//iframe[contains(@id,'ext-gen')]","XPATH");
			driver.switchTo().frame(listOfFrames.get(listOfFrames.size() - 1));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("RuleName"), strRuleName,"Rule Name");
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("TaskDescription"), strTaskDesc,"Task Description");
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("TaskPriority"), strTaskPriority,"Task Priority");
			Select Creationstatus = new Select(driver.findElement(By.name("dataForm:taskCreateStatCodeList")));
			Creationstatus.selectByVisibleText(strCreationstatus);
		} catch (Exception e) {
			report.updateTestLog("Cycle Count Task Rules Page", "Element Not Found",Status.FAIL);
		}
	}
}
