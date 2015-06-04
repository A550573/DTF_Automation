package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class RecallInventoryRulesPage extends AnyManhattanPage{

	
	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public RecallInventoryRulesPage(ScriptHelper scriptHelper) {
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
			if (getCurrentPage("RecallInventoryRulesPage"))
				report.updateTestLog("Recall Inventory Rules Page verification", "Distribution Order loaded as expected.", Status.DONE);
			else
				report.updateTestLog("Recall Inventory Rules Page verification", "Distribution Order page loaded not loaded!!!!", Status.FAIL);
		}
		
		
		private enum enumPageObjects
		{
			BtnAdd, EventDescription, BtnSave, RuleType, DefinitionTab, ParametersTab, BtnAddDefinition, ColumnList, OperatorList, ComparisionValue, AndOrList, Location, CheckDeallocateOnRecall, RuleName, Description, CheckSearchoLPNs, CheckSearchiLPNs, CheckSearchCasepick, CheckSearchTransitionalInventory, PickAllocationInventoryNeedType, ReserveAllocationInventoryNeedType, TaskCreationCriteria, iLPNLockToApply, PickLocationPutawayLockToApply, PickLocationInventoryLockToApply, oLPNLockToApply, CheckSearchActive, btnRun, btnCancel, CloseBracket, OpenBracket, Area, Position, Level, Bay, Aisle;
		}

		/**
		 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
		 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
		 * 			Values: BtnAdd, EventDescription, BtnSave, RuleType, DefinitionTab, ParametersTab, BtnAddDefinition, ColumnList, OperatorList, ComparisionValue, AndOrList, Location, CheckDeallocateOnRecall, RuleName, Description, CheckSearchoLPNs, CheckSearchiLPNs, CheckSearchCasepick, CheckSearchTransitionalInventory, PickAllocationInventoryNeedType, ReserveAllocationInventoryNeedType, TaskCreationCriteria, iLPNLockToApply, PickLocationPutawayLockToApply, PickLocationInventoryLockToApply, oLPNLockToApply, CheckSearchActive, btnRun, btnCancel, CloseBracket, OpenBracket, Area, Position, Level, Bay, Aisle
		 * 		
		 * @return	The WebElement object if it exists. Else returns null
		 */
		private WebElement getPageElement(String strElemName)
		{
			WebElement elemToFind = null;
			try {
				switch (enumPageObjects.valueOf(strElemName)) {
				
				case BtnAdd:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Add']", "XPATH");
					break;
				case EventDescription:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:eventParmDesc']", "XPATH");
					break;
				case BtnSave:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Save']", "XPATH");
					break;
				case RuleType:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:lview:rlType']", "XPATH");
					break;
				case DefinitionTab:
					elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@name='definitionTab']", "XPATH");
					break;
				case ParametersTab:
					elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@name='parameterTab']", "XPATH");
					break;
				case BtnAddDefinition:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:ruleSelAddButton']", "XPATH");
					break;
				case OpenBracket:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:ruleSelDtlDataTable:newRow_1:ruleSelDtlOpenParan']", "XPATH");
					break;
				case ColumnList:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:ruleSelDtlDataTable:newRow_1:ruleSelDtlColumnList']", "XPATH");
					break;
				case OperatorList:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:ruleSelDtlDataTable:newRow_1:ruleSelDtlOperatorList']", "XPATH");
					break;
				case ComparisionValue:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:ruleSelDtlDataTable:newRow_1:ruleSelDtlRuleCmparValue']", "XPATH");
					break;
				case CloseBracket:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:ruleSelDtlDataTable:newRow_1:ruleSelDtlCloseParan']", "XPATH");
					break;
				case AndOrList:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[contains(@id,'ruleSelDtlAndOrOrList')]", "XPATH");
					break;
				case RuleName:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:ruleNameInputBox']", "XPATH");
					break;
				case Description:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:ruleDescInputBox']", "XPATH");
					break;
				case CheckSearchiLPNs:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:SearchCasesQues2']", "XPATH");
					break;
				case CheckSearchActive:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:SearchActiveQues2']", "XPATH");
					break;
				case CheckSearchCasepick:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:SearchCasePickQues2']", "XPATH");
					break;
				case CheckSearchTransitionalInventory:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:SearchTransitionalQues2']", "XPATH");
					break;
				case CheckSearchoLPNs:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:SearchCartonsQues2']", "XPATH");
					break;
				case CheckDeallocateOnRecall:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:DeallocateonRecallQues2']", "XPATH");
					break;
				case PickAllocationInventoryNeedType:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:PickAllocationINT21']", "XPATH");
					break;
				case ReserveAllocationInventoryNeedType:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:ReserveAllocationINT21']", "XPATH");
					break;
				case TaskCreationCriteria:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:TaskCreationCriteria21']", "XPATH");
					break;
				case iLPNLockToApply:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:CaseLocktoApply2']", "XPATH");
					break;
				case PickLocationInventoryLockToApply:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:PickLocationLocktoApply2']", "XPATH");
					break;
				case PickLocationPutawayLockToApply:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:PickLocationPutawayLocktoApply2']", "XPATH");
					break;
				case oLPNLockToApply:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:CartonLocktoApply2']", "XPATH");
					break;
				case Location:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='locnClassdc_1']", "XPATH");
					break;
				case Area:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='areaRdc_1']", "XPATH");
					break;
				case Aisle:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='aisleRdc_1']", "XPATH");
					break;
				case Bay:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='bayRdc_1']", "XPATH");
					break;
				case Level:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='lvlRdc_1']", "XPATH");
					break;
				case Position:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='posnRdc_1']", "XPATH");
					break;
				case btnRun:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Run']", "XPATH");
					break;	
				case btnCancel:
					elemToFind = libManhattanCommonFunctions.getElementByProperty(".//*[@id='detailNavBar_cancelDtlBtn']", "XPATH");
					break;
				
			default:
				break;
			}
			report.updateTestLog("RecallInventoryRulesPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("RecallInventoryRulesPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	
		}
		
		/**
		 ************************************************************************ 
		 * Function clicks add button and enters event description 
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	strEventDescription
		 * @version 1.0
		 ************************************************************************
		 */
		public void addRecallRule(String strEventDescription){
			try{		
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
				libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnAdd"), "Add Button");
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("EventDescription"), strEventDescription, "Event Description");
				libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnSave"), "Save");			
			}catch(Exception e){
				
			}
		}
			
		/**
		 *********************************************************************** 
		 * Function verifies if rule list exists
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void verifyRuleListPresent(){
			try{
				libManhattanCommonFunctions.isElementPresentVerification(".//*[text()='Rule List']", "XPATH", "Rule List");
			}catch(Exception e){

			}
		}
		
		/**
		 ************************************************************************ 
		 * Function selects rule type and clicks on add button 
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	strRuleType
		 * @version 1.0
		 ************************************************************************
		 */
		public void selectRuleType(String strRuleType){
			try{						
				libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("RuleType"), strRuleType);
				Thread.sleep(2000);
				libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnAdd"), "Add Button");
				Thread.sleep(4000);
			}catch(Exception e){
				
			}
		}
			
		/**
		 *********************************************************************** 
		 * Function verifies if definition tab and parameters tab exists
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void verifyDefinitionAndParametersTabPresent(){
			try{
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@name='definitionTab']", "XPATH", "Definition Tab");
				libManhattanCommonFunctions.isElementPresentVerification(".//*[@name='parameterTab']", "XPATH", "Parameter Tab");
			}catch(Exception e){

			}
		}
		
		/**
		 ************************************************************************ 
		 * Function clicks add button in definition tab and enters definition details
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	strColumn, strOperator, strComparisionValue
		 * @version 1.0
		 ************************************************************************
		 */
		public void enterDefinitionDetails(String strColumn, String strOperator, String strComparisionValue){
			try{						
				libManhattanCommonFunctions.clickAnyElement(getPageElement("DefinitionTab"), "Definition Tab");	
				libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnAddDefinition"), "Add Button");
				Thread.sleep(2000);
				libManhattanCommonFunctions.clickAnyElement(getPageElement("OpenBracket"), "Open Bracket");
				libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("ColumnList"), strColumn);
				libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("OperatorList"), strOperator);
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ComparisionValue"), strComparisionValue, "Comparision Value");
				libManhattanCommonFunctions.clickAnyElement(getPageElement("CloseBracket"), "Close Bracket");
			}catch(Exception e){
				
			}
		}
		
		/**
		 ************************************************************************ 
		 * Function adds multiple definitions
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	strColumn, strOperator, strComparisionValue, strAddOrValue
		 * @version 1.0
		 ************************************************************************
		 */
		public void addMultipleDefintions(String strColumn,String strOperator, String strComparisionValue, String strAddOrValue){
			
			try{
				int i = 1,j = 0;
				if (strColumn.contains(";")){
					int intLoop = 0;
					for (String strCoulmnValue : strColumn.split(";")){	
						
						Thread.sleep(8000);
						String[] strOperatorValue = strOperator.split(";");
						String[] strComparisionValues = strComparisionValue.split(";");
						String[] strAddOrValues = strAddOrValue.split(";");
						libManhattanCommonFunctions.clickAnyElement(getPageElement("DefinitionTab"), "Definition Tab");	
						libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnAddDefinition"), "Add Button");
						Thread.sleep(2000);
						WebElement OpenBracket = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:ruleSelDtlDataTable:newRow_"+i+":ruleSelDtlOpenParan']", "XPATH");
						WebElement ColumnList = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:ruleSelDtlDataTable:newRow_"+i+":ruleSelDtlColumnList']", "XPATH");
						WebElement OperatorList = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:ruleSelDtlDataTable:newRow_"+i+":ruleSelDtlOperatorList']", "XPATH");
						WebElement ComparisionValue = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:ruleSelDtlDataTable:newRow_"+i+":ruleSelDtlRuleCmparValue']", "XPATH");
						WebElement CloseBracket = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:ruleSelDtlDataTable:newRow_"+i+":ruleSelDtlCloseParan']", "XPATH");
						
						libManhattanCommonFunctions.clickAnyElement(OpenBracket, "Open Bracket");
						libManhattanCommonFunctions.genericListBoxOptionSelector(ColumnList, strCoulmnValue);
						libManhattanCommonFunctions.genericListBoxOptionSelector(OperatorList, strOperatorValue[intLoop]);
						libManhattanCommonFunctions.clearAndUpdateAnyElement(ComparisionValue, strComparisionValues[intLoop], "Comparision Value");
						libManhattanCommonFunctions.clickAnyElement(CloseBracket, "Close Bracket");
						if (j >= 1){
							WebElement AndOrList = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:ruleSelDtlDataTable:newRow_"+j+":ruleSelDtlAndOrOrList']", "XPATH");
							libManhattanCommonFunctions.genericListBoxOptionSelector(AndOrList, strAddOrValues[intLoop]);
						}
						intLoop = intLoop + 1;
						i = i + 1;
						j = j + 1;

					}
				}
				
			}catch(Exception e){
				
			}
		}
		
		/**
		 ************************************************************************************************ 
		 * Function enters parameters details and clicks on save button
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	strRuleName, strDescription, strComparisionValue, strPickAllocationInventory, 
		 * 			strReserveAllocationInventory, strTaskCreationCrteria, striLPNLock, 
		 * 			strPickAllocationInventoryLock, stroLPNLock, strLocation, strSearchiLPN,
		 * 			strSearchActive, strSearchTransitionalInventory, strSearchoLPN, strDeallocateOnRecall
		 * @version 1.0 
		 *************************************************************************************************
		 */
		public void enterParametersDetails(String strRuleName, String strDescription, String strPickAllocationInventory, String strReserveAllocationInventory, String strTaskCreationCrteria, String striLPNLock, String strPickAllocationInventoryLock, String strPickAllocationPutawayLock, String stroLPNLock, String strSearchiLPN, String strSearchActive, String strSearchCasepick,  String strSearchTransitionalInventory, String strSearchoLPN, String strDeallocateOnRecall){
			try{						
				libManhattanCommonFunctions.clickAnyElement(getPageElement("ParametersTab"), "Parameters Tab");	
				Thread.sleep(3000);
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("RuleName"), strRuleName, "Rule Name");
				libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Description"), strDescription, "Description");
				libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("PickAllocationInventoryNeedType"), strPickAllocationInventory);
				libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("ReserveAllocationInventoryNeedType"), strReserveAllocationInventory);
				libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("TaskCreationCriteria"), strTaskCreationCrteria);
				libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("iLPNLockToApply"), striLPNLock);
				libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("PickLocationInventoryLockToApply"), strPickAllocationInventoryLock);
				libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("PickLocationPutawayLockToApply"), strPickAllocationPutawayLock);
				libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("oLPNLockToApply"), stroLPNLock);
				libManhattanCommonFunctions.checkAnyElement(getPageElement("CheckSearchiLPNs"), strSearchiLPN, "Check Search iLPN");
				libManhattanCommonFunctions.checkAnyElement(getPageElement("CheckSearchActive"), strSearchActive, "Check Search Active");
				libManhattanCommonFunctions.checkAnyElement(getPageElement("CheckSearchCasepick"), strSearchCasepick, "Check Search Active");
				libManhattanCommonFunctions.checkAnyElement(getPageElement("CheckSearchTransitionalInventory"), strSearchTransitionalInventory, "Check Search Transitional Inventory");
				libManhattanCommonFunctions.checkAnyElement(getPageElement("CheckSearchoLPNs"), strSearchoLPN, "Check Search oLPN");
				libManhattanCommonFunctions.checkAnyElement(getPageElement("CheckDeallocateOnRecall"), strDeallocateOnRecall, "Check Deallocate On recall");
			}catch(Exception e){
				
			}
		}
		
		/**
		 ************************************************************************ 
		 * Function enters location details in parameters tab
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	strLocation,strArea,strAisle,strBay,strLevel,strPosition
		 * @version 1.0
		 ************************************************************************
		 */
		public void enterLocationDetails(String strLocation, String strArea, String strAisle, String strBay, String strLevel, String strPosition){
			try{		
				if (strLocation.trim().equals("Active") || strLocation.trim().equals("Reserve")){
					libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("Location"), strLocation);
					Thread.sleep(3000);
					libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Area"), strArea, "Area");
					libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Aisle"), strAisle, "Aisle");
					libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Bay"), strBay, "Bay");
					libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Level"), strLevel, "Level");
					libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("Position"), strPosition, "Position");
				}
				else{
					libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("Location"), strLocation);
					Thread.sleep(2000);
				}
				libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnSave"), "Save Button");
				Thread.sleep(2000);
			}catch(Exception e){
				
			}
		}
		
		/**
		 ************************************************************************ 
		 * Function clicks on cancel button 
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	None
		 * @version 1.0
		 ************************************************************************
		 */
		public void clickCancelButton(){
			try{
				driver.navigate().back();
				libManhattanCommonFunctions.clickAnyElement(getPageElement("BtnCancel"), "Cancel Button");
				Thread.sleep(3000);
			}catch(Exception e){
				
			}
		}
		
		/**
		 ************************************************************************ 
		 * Function selects the event description and clicks on run button
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	strEventDescription
		 * @version 1.0
		 * @throws 	InterruptedException 
		 ************************************************************************
		 */
		public void selectEventDescription(String strEventDescription) throws InterruptedException{
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			List<WebElement> list = driver.findElements(By.xpath(".//*[@class='advtbl_col advtbl_body_col'][1]//span[1]"));
			int strRowNumToBeChecked = 0;
			for(WebElement ele:list){
				if(ele.getText().trim().contains(strEventDescription.trim())){
					break;
				}else{
					strRowNumToBeChecked = strRowNumToBeChecked + 1;
					continue;
				}	
			}
			libManhattanCommonFunctions.clickAnyElement(".//*[@id='checkAll_c"+strRowNumToBeChecked+"_dataForm:lvIEW:dataTable']", "XPATH", "CheckBox");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnRun"), "Run Button");
			Thread.sleep(12000);
		}
}
