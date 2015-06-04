package pages;

import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

public class oLPNDetailsPage extends AnyManhattanPage {

	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public oLPNDetailsPage(ScriptHelper scriptHelper) {
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
	protected void initializeUIMap() {
		libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
		if (getCurrentPage("oLPNDetailsPage"))
			report.updateTestLog("oLPN Details verification","oLPN Details loaded as expected.", Status.DONE);
		else
			report.updateTestLog("oLPN verification","oLPN loaded not loaded!!!!", Status.FAIL);
	}

	public enum enumPageObjects {
		btnHeader, btnLocks, 

	}
	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: btnHeader, btnLocks
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName) {
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case btnHeader:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='LPN_Header_Tab_lnk']", "XPATH");
				break;
			case btnLocks:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='LPN_Locks_Tab_lnk']", "XPATH");
				break;//span[@id='dataForm:ViewLPNHeaderOutbound_Ref_Field1_optxt']			

			default:
				break;
			}
			report.updateTestLog("AnyManhattan- GET PAGE ELEMENT", ""+ strElemName + "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("AnyManhattan- GET PAGE ELEMENT", ""+ strElemName + "is not found", Status.FAIL);
		}
		return elemToFind;
	}

	/**
	 *********************************************************************** 
	 * Function validates Manifest Number if exist else retrieves it.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strManifestNumber
	 * @version 1.0 
	 ***********************************************************************
	 */
	public void validateManifestNumber(String strManifestNumber){
		try {
			
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnHeader"), "Header Button");
			Thread.sleep(3000);
			String actualManifestNumber = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ViewLPNHeader_Manifest_outputText66']","XPATH").getText();			
			if(strManifestNumber.equals(actualManifestNumber.trim())){
				report.updateTestLog("Manifest Details", "Manifest : "+actualManifestNumber+" already Exists", Status.PASS);
			}
			else{
				report.updateTestLog("Manifest Details", "Manifest Created : "+actualManifestNumber, Status.PASS);
			}			
		} catch (Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
		}		
	}
	/**
	 *********************************************************************** 
	 * Function validates Manifest Number if exist else retrieves it.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strManifestNumber
	 * @version 1.0 
	 * @return 
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public String ValidateandRetrieveManifestNumber(String strManifestNumber) throws InterruptedException{	
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnHeader"), "Header Button");
			Thread.sleep(3000);
			String actualManifestNumber = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ViewLPNHeader_Manifest_outputText66']","XPATH").getText();			
			if(strManifestNumber.equals(actualManifestNumber.trim())){
				report.updateTestLog("Manifest Details", "Manifest : "+actualManifestNumber+" already Exists", Status.PASS);
			}
			else{
				report.updateTestLog("Manifest Details", "Manifest Created : "+actualManifestNumber, Status.PASS);
			}							 
		return actualManifestNumber;				
	}
	/**
	 *********************************************************************** 
	 * Function validates Manifest Number if exist else retrieves it.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strManifestNumber
	 * @version 1.0 
	 * @return 
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void ValidateReferenceField1(String strReferenceField) throws InterruptedException{	
		try{
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnHeader"), "Header Button");
			Thread.sleep(3000);
//			strReferenceField="96210002602523";			
			String actualReferenceField1 = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ViewLPNHeaderOutbound_Ref_Field1_optxt']","XPATH").getText();			
			if(strReferenceField.trim().equals(actualReferenceField1.trim())){
				report.updateTestLog("Reference Field Verification", "Reference Field : "+actualReferenceField1+" is Verified Successfully", Status.PASS);
			}
			else{
				report.updateTestLog("Reference Field Verification", " Expected Reference Field : "+strReferenceField+" Actual Reference Field : "+actualReferenceField1, Status.FAIL);
			}						 		
	}
		catch(Exception e) {
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
	}
	}
	
	/**
	 *********************************************************************** 
	 * Function validates Chute number and chute assignment type details
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	strChuteNumber, strChuteAssignmentType
	 * @version 1.0 
	 * @return 
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void validateChuteDetails(String strChuteNumber, String strChuteAssignmentType) throws InterruptedException{	
			libManhattanCommonFunctions.clickAnyElement(getPageElement("btnHeader"), "Header Button");
			Thread.sleep(3000);
			String actualChuteNumber = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ViewLPNHeader_Chute_Bool66']","XPATH").getText();			
			String actualChuteAssignmentType = libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:ViewLPNHeader_ChuteAssignmentType_outputText66']","XPATH").getText();
			if(strChuteNumber.equals(actualChuteNumber.trim()) && strChuteAssignmentType.equals(actualChuteAssignmentType.trim()) ){
				report.updateTestLog("Chute Details Validation", "Expected Chute Number : "+strChuteNumber+ "Actual Chute Number :" +actualChuteNumber+ "|| Expected Chute Assignment Type:" +strChuteAssignmentType+ "Actual Chute Assignment Type:" +actualChuteAssignmentType, Status.PASS);
			}
			else{
				report.updateTestLog("Chute Details Validation", "Expected Chute Number : "+strChuteNumber+ "Actual Chute Number :" +actualChuteNumber+ "|| Expected Chute Assignment Type:" +strChuteAssignmentType+ "Actual Chute Assignment Type:" +actualChuteAssignmentType, Status.FAIL);
			}							 				
	}
	
	/**
	 *********************************************************************** 
	 * Function validates Misc Instruction4
	 * @return 	Nothing is returned as of now 
	 * @Author 	Aishwarya
	 * @param 	strChuteNumber, strChuteAssignmentType
	 * @version 1.0 
	 * @return 
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void validateMiscInstruction4() throws InterruptedException{	
			String actualMiscInstruction4 = libManhattanCommonFunctions.getElementByProperty("//span[contains(@id, 'MiscInstruction_4')]","XPATH").getText();			
			if(actualMiscInstruction4 != null ){
				report.updateTestLog("Alpha Identifier Mapping Validation", "Misc Instruction 4 Field is not null and value is:" +actualMiscInstruction4, Status.PASS);
			}
			else{
				report.updateTestLog("Alpha Identifier Mapping Validation", "Misc Instruction 4 Field is not null and value is:" +actualMiscInstruction4, Status.FAIL);
			}							 				
	}

}
