package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;
import supportlibraries.ScriptHelper;

public class WeighAndManifestoLPNPage extends AnyManhattanPage{

	
	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public WeighAndManifestoLPNPage(ScriptHelper scriptHelper) {
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
			if (getCurrentPage("WeighAndManifestoLPNPage"))
				report.updateTestLog("WeighAndManifestoLPN Page verification", "WeighAndManifestoLPN page loaded as expected.", Status.DONE);
			else
				report.updateTestLog("WeighAndManifestoLPN Page verification", "WeighAndManifestoLPN page loaded not loaded!!!!", Status.FAIL);
		}
		
		
		private enum enumPageObjects
		{
			txtoLPNNumber, btnNext, btnManifest, btnExit, btnScanNextoLPN, txtActualWeight, btnAccept, selectShipVia;
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
				
				case txtoLPNNumber:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:EnterLPNNumber']", "XPATH");
					break;
				case btnNext:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Next >']", "XPATH");
					break;
				case btnManifest:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Manifest >']", "XPATH");
					break;
				case btnExit:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Exit']", "XPATH");
					break;
				case btnScanNextoLPN:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Scan Next oLPN >']", "XPATH");
					break;
				case txtActualWeight:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:actWeight']", "XPATH");
					break;//input[@value='Accept']
				case btnAccept:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Accept']", "XPATH");
					break;//select[@id='dataForm:shipviaList']
				case selectShipVia:
					elemToFind = libManhattanCommonFunctions.getElementByProperty("//select[@id='dataForm:shipviaList']", "XPATH");
					break;
			default:
				break;
			}
			report.updateTestLog("WeighAndManifestoLPNPage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("WeighAndManifestoLPNPage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;
	
		}
		
		/**
		 *********************************************************************** 
		 * Function enters the oLPN number and clicks on next button.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	strLPNNumber
		 * @version 1.0
		 ***********************************************************************
		 */
		public void enteroLPNNumber(String strLPNNumber){
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtoLPNNumber"), strLPNNumber,"oLPN Number");
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnNext"), "Next Button");
		}
		
		/**
		 *********************************************************************** 
		 * Function clicks on manifest button.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void clickManifest(){
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnManifest"), "Manifest Button");
		}
		
		/**
		 *********************************************************************** 
		 * Function clicks on exit button.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void clickExit(){
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnExit"), "Exit Button");
		}
		
		/**
		 *********************************************************************** 
		 * Function clicks on scan next olpn button.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void clickScanNextoLPN(){
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnScanNextoLPN"), "Scan Next oLPN Button");
		}
		
//		/**
//		 *********************************************************************** 
//		 * Functions to search multiple iLPNS and validate the status
//		 * @return 	Nothing is returned as of now 
//		 * @Author 	Jayashree
//		 * @param 	strLPN, strLPNFacilityStatus
//		 * @version 1.0 
//		 ***********************************************************************
//		 */
//		public void scanoLPNNumber(String strLPNNumber) {
//			try {
//				if (strLPNNumber.contains(";")) {
//					int intLoop = 0;
//					for (String strElement : strLPNNumber.split(";")) {
//						enteroLPNNumber(strElement);
//						Thread.sleep(3000);
//						
//						clickManifest();
//						Thread.sleep(3000);
//						clickScanNextoLPN();
//						Thread.sleep(2000);
//						intLoop = intLoop + 1;	
//					}
//					
//				}else{
//					//driver.switchTo().defaultContent();
//					enteroLPNNumber(strLPNNumber);
//					enterActualWeight();
//					clickManifest();
////					getManifestNumber();
////					clickExit();
//				}
////				if(libManhattanCommonFunctions.verifyElementPresent("//input[@value='Exit']", "XPATH")){
////					clickExit();
////					
////				}else{
////					report.updateTestLog("Weigh and manifest oLPN","Error cannot manifest oLPN", Status.FAIL);
////				}
//				
//			} catch (Exception e) {
//
//			}
//		}
		
		/**
         *********************************************************************** 
          * Functions to search multiple iLPNS and validate the status
         * @return    Nothing is returned as of now 
          * @Author    Jayashree
         * @param     strLPN, strLPNFacilityStatus
         * @version 1.0 
          ***********************************************************************
         */
         public void scanoLPNNumber(String strLPNNumber) {
                try {
                      if (strLPNNumber.contains(";")) {
                             int intLoop = 0;
                             for (String strElement : strLPNNumber.split(";")) {
                                    enteroLPNNumber(strElement);
                                    Thread.sleep(3000);
                                    enterActualWeight();
                                    clickManifest();
                                    Thread.sleep(3000);
                                    clickScanNextoLPN();
                                    Thread.sleep(2000);
                                    refreshWindow();
                                    intLoop = intLoop + 1;     
                             }
                             
                      }else{
                             //driver.switchTo().defaultContent();
                             enteroLPNNumber(strLPNNumber);
                             enterActualWeight();
                             clickManifest();
//                           getManifestNumber();
//                           clickExit();
                      }
//                    if(libManhattanCommonFunctions.verifyElementPresent("//input[@value='Exit']", "XPATH")){
//                           clickExit();
//                           
//                    }else{
//                           report.updateTestLog("Weigh and manifest oLPN","Error cannot manifest oLPN", Status.FAIL);
//                    }
                      
                } catch (Exception e) {

                }
         }

		
		/**
		 *********************************************************************** 
		 * Function retrieves manifest number.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public String getManifestNumber(){
			String strManifestNum = libManhattanCommonFunctions.getElementByProperty("//*[@id='dataForm:manifestNbr']","XPATH").getText();			
			return strManifestNum;
		}
		
		/**
		 *********************************************************************** 
		 * Function enters the actual weight from estimated weight.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	None
		 * @version 1.0
		 ***********************************************************************
		 */
		public void enterActualWeight(){
			String strActualWeight = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:estWeight']","XPATH").getText();
			libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("txtActualWeight"), strActualWeight,"Actual Weight");
		}
		/**
		 *********************************************************************** 
		 * Function enters the actual weight from estimated weight.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Rahman
		 * @param 	None
		 * @version 1.0
		 * @throws InterruptedException 
		 ***********************************************************************
		 */
		public void overrideManifestWarning(String strOLPN) throws InterruptedException{
//			String strOLPN = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:oLPN']","XPATH").getText();
			String strWarningMsg = libManhattanCommonFunctions.getElementByProperty("//span[contains(text(),'oLPN "+strOLPN+" cannot meet promised delivery. Needs upgrade')]","XPATH").getText();
			//span[contains(text(),'oLPN 9894170000023416 cannot meet promised delivery. Needs upgrade')]
			String strText = "oLPN "+strOLPN+" cannot meet promised delivery. Needs upgrade";
			//input[@value='Accept']
			if(strWarningMsg.contains(strText))
			{
				report.updateTestLog("Manifest Warning verification", "Warning : "+strWarningMsg +" is verified", Status.PASS);
			}
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnAccept"), "Accept Button");	
			Thread.sleep(3000);
		}
		/**
		 *********************************************************************** 
		 * Functions Scans olPNs and Assigns new Ship via
		 * @return 	Nothing is returned as of now 
		 * @Author 	Rahman
		 * @param 	strLPNNumber, strShipvia
		 * @version 1.0 
		 ***********************************************************************
		 */
		public void assignShipvia(String strLPNNumber,String strShipvia) {
			try {
				if (strLPNNumber.contains(";")) {
					int intLoop = 0;
					for (String strElement : strLPNNumber.split(";")) {
						enteroLPNNumber(strElement);
						Thread.sleep(3000);
						
						clickManifest();
						Thread.sleep(3000);
						clickScanNextoLPN();
						Thread.sleep(2000);
						intLoop = intLoop + 1;	
					}
					
				}else{
					//driver.switchTo().defaultContent();
					enteroLPNNumber(strLPNNumber);
					enterActualWeight();
					Thread.sleep(1000);
					libManhattanCommonFunctions.genericListBoxOptionSelector(getPageElement("selectShipVia"), strShipvia);
					Thread.sleep(1000);
					clickManifest();
//					getManifestNumber();
//					clickExit();
				}
//				if(libManhattanCommonFunctions.verifyElementPresent("//input[@value='Exit']", "XPATH")){
//					clickExit();
//					
//				}else{
//					report.updateTestLog("Weigh and manifest oLPN","Error cannot manifest oLPN", Status.FAIL);
//				}
				
			} catch (Exception e) {

			}
		}
		
		

		/**
		 *********************************************************************** 
		 * Function to check if oLPN cannot be manifested error message.
		 * @return 	Nothing is returned as of now 
		 * @Author 	Yagna Priya D
		 * @param 	strInventoryType
		 * @version 1.0
		 * @throws Exception 
		 ***********************************************************************
		 */
		public void checkManifestoLPNNotPossible() throws Exception{
			if(libManhattanCommonFunctions.verifyElementPresent("(//*[contains(text(),'Not all bundle oLPNs packed')])[1]", "XPATH") || (libManhattanCommonFunctions.verifyElementPresent("(//*[contains(text(),'Bundle Shortage, take to QA for')])[1]", "XPATH"))){
				report.updateTestLog("WeighAndManifestoLPN Page", "oLPN cannot be manifested", Status.PASS);
			}else{
				report.updateTestLog("WeighAndManifestoLPN Page", "oLPN cannot be manifested", Status.FAIL);
			}
		}
		
}
