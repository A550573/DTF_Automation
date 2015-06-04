package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class RunWavesPage extends AnyManhattanPage{

	
	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public RunWavesPage(ScriptHelper scriptHelper) {
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
			if (getCurrentPage("RunWavesPage"))
				report.updateTestLog("Run Waves Page verification", "Run Waves loaded as expected.", Status.DONE);
			else
				report.updateTestLog("Run Waves Page verification", "Run Waves page loaded not loaded!!!!", Status.FAIL);
		}
		
		
		private enum enumPageObjects
		{
			btnSubmit, btnRunWave, WaveNumber, btnSubmitWave, ParametersTab, chkPackComplete, RuleType, ForceShipVia;
		}

		/**
		 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
		 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
		 * 			Values: btnSubmit, btnRunWave, WaveNumber
		 * @return	The WebElement object if it exists. Else returns null
		 */
		private WebElement getPageElement(String strElemName)
		{
			WebElement elemToFind = null;
			try {
				switch (enumPageObjects.valueOf(strElemName)) {
				
				case btnRunWave:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Run Wave']", "XPATH");
					break;
				case btnSubmit:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[starts-with(@value,'Submit')]", "XPATH");
					break;
				case btnSubmitWave:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Submit Wave']", "XPATH");
					break;
				case WaveNumber:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='dataForm:AwvNbrRun']", "XPATH");
					break;
				case ParametersTab:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='WaveControlTab_lnk']", "XPATH");
					break;
				case chkPackComplete:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:gp260']", "XPATH");
					break;
				case RuleType:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:rlType']", "XPATH");
					break;
				case ForceShipVia:
                    elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:gp1002']", "XPATH");
                    break;


		
			default:
				break;
			}
			report.updateTestLog("RunWavePage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("RunWavePage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	
		}
		
		/**
		 *********************************************************************** 
		 * Function selects the wave parameter.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	strWaveParameter
		 * @version 1.0
		 ***********************************************************************
		 */
		public void selectWaveParameter(String strWaveParameter){
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			List<WebElement> list = driver.findElements(By.xpath(".//*[@class='advtbl_col advtbl_body_col'][1]//span[1]"));
			int strRowNumToBeChecked = 0;
			for(WebElement ele:list){
				if(ele.getText().trim().contains(strWaveParameter.trim())){
					break;
				}else{
					strRowNumToBeChecked = strRowNumToBeChecked + 1;
					continue;
				}
				
			}
			libManhattanCommonFunctions.clickAnyElement(".//*[@id='checkAll_c"+strRowNumToBeChecked+"_dataForm:listView:dataTable']", "XPATH", "CheckBox");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnRunWave"), "Run Wave Button");
				
		}
		
		/**
		 *********************************************************************** 
		 * Function clicks on submit button.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void clickSubmit(){
			try{	
				libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSubmit"), "Submit Button");
			}catch(Exception e){
				report.updateTestLog("Submit Button", "Element Not Found", Status.FAIL);
			}
		}
		
		/**
		 *********************************************************************** 
		 * Function clicks on submit Wave button.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Nitika
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void clickOnSubmitWave(){
				if (libManhattanCommonFunctions.verifyElementPresent("//input[starts-with(@value,'Submit')]", "XPATH")){
					libManhattanCommonFunctions.waitForElementClickable("//input[starts-with(@value,'Submit')]", 25000);
					libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSubmit"), "Submit Button");
				}
				else
					{
					libManhattanCommonFunctions.clickAnyElement(getPageElement("btnSubmitWave"), "Submit Wave Button");
					}
		}
		
		/**
		 *********************************************************************** 
		 * Function to retrieve the wave number.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public String getWaveNumber(){
			String strWaveNumber = null;
			try{
				Thread.sleep(8000);
				libManhattanCommonFunctions.waitForElementVisibility("//span[contains(text(),'Wave Number is')]", 90000);
				strWaveNumber = driver.findElement(By.xpath("//a[@id='dataForm:AwvNbrRun']")).getText();
				System.out.println("Wave number generated is : "+strWaveNumber);
			}catch(Exception e){
				report.updateTestLog("Wave Number", "Element Not Found", Status.FAIL);
			}
			return strWaveNumber;
		}
		
		/**
		 *********************************************************************** 
		 * Function clicks on the wave number to view wave details.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void viewWave(){
			try{
				Thread.sleep(15000);
				libManhattanCommonFunctions.clickAnyElement(getPageElement("WaveNumber"), "WaveNumber");
				refreshWindow();
				libManhattanCommonFunctions.waitForElementVisibility("//span[@id='dataForm:listView:dataTable:0:shipWaveNbr']", 1000);
			}catch(Exception e){
				report.updateTestLog("Wave Page", "Element Not Found", Status.FAIL);
			} 
		}
		
		/**
		 *********************************************************************** 
		 * Function to select pack complete with wave.
		 * @return    Nothing is returned as of now 
		 * @Author    Yagna Priya D
		 * @param     strRuleType
		 * @version 1.0
		 ***********************************************************************
		 */
		public void checkPackCompleteWithWave(String strPackComplete){
			libManhattanCommonFunctions.clickAnyElement(getPageElement("ParametersTab"), "Parameters tab");                
			libManhattanCommonFunctions.checkAnyElement(getPageElement("chkPackComplete"), strPackComplete, "Check pack complete with wave");

		}
		

		/**
		 *********************************************************************** 
		 * Function selects the wave parameter.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Rahman
		 * @param 	strWaveParameter
		 * @version 1.0
		 ***********************************************************************
		 */
		public void selectWaveRules(String strWaveRule){
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			WebElement wbItemSeqTable = driver.findElement(By.xpath("//table[@id='dataForm:lview:dataTable_41_body']"));
			List<WebElement> wbTRList = wbItemSeqTable.findElements(By.tagName("TR"));	
			System.out.println("Total Rules : "+(wbTRList.size()-1));		
			System.out.println("Rules : "+wbTRList);		
			int strRowNumToBeChecked = 0;
			for(WebElement ele:wbTRList){
				if(ele.getText().trim().contains(strWaveRule.trim())){
//					libManhattanCommonFunctions.clickAnyElement("//span[@id='dataForm:lview:dataTable_41:"+strRowNumToBeChecked+":ruleNameText']", "XPATH", "Radio Box");
					break;//span[@id='dataForm:lview:dataTable_41:0:ruleNameText']
				}else{
					strRowNumToBeChecked = strRowNumToBeChecked + 1;
					continue;
				}
			}
			libManhattanCommonFunctions.clickAnyElement("//span[@id='dataForm:lview:dataTable_41:"+strRowNumToBeChecked+":ruleNameText']", "XPATH", "Radio Box");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnRunWave"), "Run Wave Button");

		}
		
		
		
		/**
		 * 
		 * @param   strMinSinglesOrders,strMinSinglesUnits,strMaxSinglesOrders,
		 * 			strMaxSinglesUnits,strMinMultiLineOrders,strMinMultiLineUnits
		 * 		 	strMinSinglesBypassiLPN,strMaxMultiLineOrders,strMaxMultiLineUnits
		 */
		
		public void enterWaveCapacityParameter(String strMinSinglesOrders, String strMinSinglesUnits, String strMaxSinglesOrders, String strMaxSinglesUnits,String strMinMultiLineOrders, String strMinMultiLineUnits, String strMinSinglesBypassiLPN, String strMaxMultiLineOrders,String strMaxMultiLineUnits){
			try{		
				libManhattanCommonFunctions.clickAnyElement(getPageElement("ParametersTab"), "Parameters tab");	
				libManhattanCommonFunctions.clearAndEnterText("//input[@id='dataForm:gpex0322']", "XPATH", strMinSinglesOrders);
				libManhattanCommonFunctions.clearAndEnterText("//input[@id='dataForm:gpex03212']", "XPATH", strMinSinglesUnits);
				libManhattanCommonFunctions.clearAndEnterText("//input[@id='dataForm:gpex0328']", "XPATH", strMaxSinglesOrders);
				libManhattanCommonFunctions.clearAndEnterText("//input[@id='dataForm:gpex03210']", "XPATH", strMaxSinglesUnits);
				libManhattanCommonFunctions.clearAndEnterText("//input[@id='dataForm:gpex03510']", "XPATH", strMinMultiLineOrders);
				libManhattanCommonFunctions.clearAndEnterText("//input[@id='dataForm:gpex03512']", "XPATH", strMinMultiLineUnits);
				libManhattanCommonFunctions.clearAndEnterText("//input[@id='dataForm:gpex03214']", "XPATH", strMinSinglesBypassiLPN);
				libManhattanCommonFunctions.clearAndEnterText("//input[@id='dataForm:gpex03502']", "XPATH", strMaxMultiLineOrders);
				libManhattanCommonFunctions.clearAndEnterText("//input[@id='dataForm:gpex03216']", "XPATH", strMaxMultiLineUnits);
				report.updateTestLog("Run Waves", "Wave capacity parameters updated", Status.PASS);
				Thread.sleep(5000);
			}catch(Exception e){

			}
		}
		
		
		/**
		 *********************************************************************** 
		 * Function selects rule type from the drop down box.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	strRuleType
		 * @version 1.0
		 ***********************************************************************
		 */
		public void selectRuleType(String strRuleType){
			try{
				Thread.sleep(3000);
				libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("RuleType"), strRuleType);
				Thread.sleep(3000);
			}catch(Exception e){
				report.updateTestLog("RunWave Page", "Element Not Found", Status.FAIL);
			} 
		}
		
		/**
		 *********************************************************************** 
		 * Function selects rule type from the drop down box.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	strRuleType
		 * @version 1.0
		 * @throws InterruptedException 
		 ***********************************************************************
		 */
		public void selectRule(String strRule) throws InterruptedException{
			List<WebElement> list = driver.findElements(By.xpath(".//*[@class='advtbl_col advtbl_body_col'][1]//span[1]"));
			int strRowNumToBeSelected = 0;
			for(WebElement ele:list){
				if(ele.getText().trim().equalsIgnoreCase(strRule.trim())){
					
					break;
				}else{
					strRowNumToBeSelected = strRowNumToBeSelected + 1;
					continue;
				}
//				System.out.println(ele.getText());
			}
			System.out.println("row number : " +strRowNumToBeSelected);
			libManhattanCommonFunctions.clickAnyElement(".//*[@id='dataForm:lview:dataTable_81:"+strRowNumToBeSelected+":ruleNameText']", "XPATH", "CheckBox");
//			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnAddRule"), "Add Rule Button");
				
		}
		
		/**
         *********************************************************************** 
         * Function selects rule type from the drop down box.
         * @return      Nothing is returned as of now 
         * @Author      Yagna Priya D
         * @param       strRuleType
         * @version 1.0
         ***********************************************************************
         */
        public void selectShipVia(String strForceShipvia){
                try{
//                      strForceShipvia="FedEx 2 Day Saturday";
                        if(!(strForceShipvia.equals(""))){
                                Thread.sleep(2000);
                                libManhattanCommonFunctions.clickAnyElement(getPageElement("ParametersTab"), "Parameters tab"); 
                                Thread.sleep(3000);
                                libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("ForceShipVia"), strForceShipvia);
                                Thread.sleep(3000);
                        }
                }catch(Exception e){
                        report.updateTestLog("RunWave Page", "Element Not Found", Status.FAIL);
                } 
        }


		
}
