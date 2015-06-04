package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import supportlibraries.ScriptHelper;

import com.cognizant.framework.Status;

import functionallibraries.ManhattanCommonFunctions;

public class ManifestsPage extends AnyManhattanPage{


	/**
	 *********************************************************************** 
	 * Constructor to initialize the page
	 * @return 	Nothing is returned as of now  
	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
	 * @version 1.0
	 ***********************************************************************
	 */
	public ManifestsPage(ScriptHelper scriptHelper) {
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
		if (getCurrentPage("ManifestsPage"))
			report.updateTestLog("Manifests Page verification", "Manifests loaded as expected.", Status.DONE);
		else
			report.updateTestLog("Manifests Page verification", "Manifests page loaded not loaded!!!!", Status.FAIL);
	}

	private enum enumPageObjects
	{
		 ManifestID, btnApply, ManifestedOLPNs, CloseManifests, Calendar, Today, More, ViewPLD;
	}

	/**
	 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
	 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
	 * 			Values: Apply, OrderID
	 * @return	The WebElement object if it exists. Else returns null
	 */
	private WebElement getPageElement(String strElemName)
	{
		WebElement elemToFind = null;
		try {
			switch (enumPageObjects.valueOf(strElemName)) {

			case ManifestID:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listView:filterId:field10value1']", "XPATH");
				break;
			case btnApply:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:listView:filterId:filterIdapply']", "XPATH");
				break;
			case ManifestedOLPNs:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Manifested oLPNs']", "XPATH");
				break;
			case CloseManifests:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@value='Close Manifest']", "XPATH");
				break;
			case Calendar:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@title='Select date']", "XPATH");
				break;
			case Today:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//div[contains(text(),'Today')]", "XPATH");
				break;
			case More:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='rmbuttons_1moreButton']", "XPATH");
				break;
			case ViewPLD:
				elemToFind = libManhattanCommonFunctions.getElementByProperty("//a[@id='rmButton_1ViewPLD1_167271540']", "XPATH");
				break;

			default:
				break;
			}
			report.updateTestLog("WavePage- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
		} catch (Exception e) {
			report.updateTestLog("WavePage- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
		}
		return elemToFind;

	}

	/**
	 *********************************************************************** 
	 * Function enters the manifest number and clicks on apply button.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strManifestId
	 * @version 1.0
	 ***********************************************************************
	 */
	public void searchManifestID(String strManifestId)
	{
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ManifestID"), strManifestId, "ManifestID");
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "Apply Button");
	}

	
	/**
	 *********************************************************************** 
	 * Function validates the manifest status.
	 * @return 	Nothing is returned as of now 
	 * @Author 	Nitika
	 * @param 	strManifestStatus
	 * @version 1.0
	 ***********************************************************************
	 */
	public void validateManifestStatus(String strManifestStatus){
		try{
			Thread.sleep(2000);
			String actualManifestStatus=libManhattanCommonFunctions.getElementByProperty("//span[@id='dataForm:listView:dataTable:0:val_Status']", "XPATH").getText();
			
			if(actualManifestStatus.trim().equals(strManifestStatus))
			{
				report.updateTestLog("Manifest Status verification", "Manifest Status: "+strManifestStatus, Status.PASS);
			}else
			{
				report.updateTestLog("Manifest Status verification", "Actual Manifest Status :"+actualManifestStatus+"Expected Manifest Status"+strManifestStatus, Status.FAIL);
			}
		}catch(Exception e){
			report.updateTestLog("Element", "Element Not Found", Status.FAIL);
			} 
	}
	
	/**
	 *********************************************************************** 
	 * Function Enters Manifest in the search box and clicks apply button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	strManifest
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void enterManifest(String strManifest) throws InterruptedException{
		//driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("ManifestID"), strManifest, "Manifest");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("btnApply"), "Apply");			
		Thread.sleep(3000);
	}
	/**
	 *********************************************************************** 
	 * Function selects Manifest that is displayed
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	None
	 * @version 1.0 
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void selectManifest() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.clickAnyElement("//input[@id='checkAll_c0_dataForm:listView:dataTable']","XPATH", "CheckBox");
		Thread.sleep(3000);

	}
	/**
	 *********************************************************************** 
	 * Function Clicks Manifested OLPNs button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	none
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void clickOnManifestedOLPNs() throws InterruptedException{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
		libManhattanCommonFunctions.clickAnyElement(getPageElement("ManifestedOLPNs"), "Manifested OLPNs Button");
		Thread.sleep(3000);
	}
	
	/** *********************************************************************** 
	 * Function Clicks Close Manifests button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	none
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void clickOnCloseManifests() throws InterruptedException{		
		libManhattanCommonFunctions.clickAnyElement(getPageElement("CloseManifests"), "Close Manifests Button");
		Thread.sleep(3000);
	}
	
	/**
	 *********************************************************************** 
	 * Function Selects Date
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	none
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void SelectDate() throws InterruptedException{		
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Calendar"), "Select Calendar");
		Thread.sleep(2000);
		libManhattanCommonFunctions.clickAnyElement(getPageElement("Today"), "Click Today");
		Thread.sleep(1000);
	}
	
	/**
	 *********************************************************************** 
	 * Function Clicks More button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	none
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void clickOnMore() throws InterruptedException{		
		libManhattanCommonFunctions.clickAnyElement(getPageElement("More"), "More Button");
		Thread.sleep(3000);
//		libManhattanCommonFunctions.clickAnyElement(getPageElement("ViewPLD"), "View PLD Link");
//		Thread.sleep(3000);
	}
	
	/**
	 *********************************************************************** 
	 * Function Clicks View PLD Link
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	none
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void clickViewPLD() throws InterruptedException{		
		libManhattanCommonFunctions.clickAnyElement(getPageElement("ViewPLD"), "View PLD Link");
		Thread.sleep(3000);
	}
	
	/**
	 *********************************************************************** 
	 * Function Clicks Manifested OLPNs button
	 * @return 	Nothing is returned as of now 
	 * @Author 	Rahman
	 * @param 	none
	 * @version 1.0
	 * @throws InterruptedException 
	 ***********************************************************************
	 */
	public void validatePLDFile(String strManifests) throws InterruptedException{
//		driver.switchTo().defaultContent();
		driver.switchTo().frame("VIewPLD_frameId");		
		String strPLDFile = driver.findElement(By.tagName("b")).getText();		
		System.out.println(strPLDFile);
//		driver.switchTo().defaultContent();
//		driver.findElement(By.xpath("(//div[@class='pop_close'])[4]")).click();
		String strText="PLD File for Manifest"+" "+strManifests;
		if(strPLDFile.contains(strText)){
			report.updateTestLog("PLD File verification", " "+strText+" is Generated.", Status.PASS);
		}
		else{
			report.updateTestLog("PLD File verification", " "+strText+" is not Generated.", Status.FAIL);
			}
		Thread.sleep(3000);
	}
}
