package testscripts.lockunlocklpns;

import org.junit.Test;

import pages.ASNPage;
import pages.AnyManhattanPage;
import pages.LoginPage;
import pages.MenuPage;
import pages.PixTransactionPage;
import pages.iLPNPage;
import pages.LPNLockUnlockPage;
import pages.PixTransactionPage;
import supportlibraries.DriverScript;

import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.Status;


/**
 * ################################################SCRIPT CREATION HISTORY ################################################
 * @Header(
 * Test Name	=       'GFL_ONT_CON_IM_L_UL_UI_02'
 * Description  =       'TM should be able to apply Transit Damage Lock Code on iLPN through UI before ASN verification'
 * Author     	=       'Nitika'
 * Created On   =       'Sept 24 2014'                                                                 
 * )
 * @version             1.0
 * @category    =		Lock iLPN
 * ########################################################################################################################
 */
public class GFL_ONT_CON_IM_L_UL_UI_02 extends DriverScript{

	//*******************************Page Object Declarations**********************************************************//
	AnyManhattanPage pgObjAnyManhattanPage;
	LoginPage pgObjLoginPage;
	MenuPage pgObjMenuPage;
	iLPNPage pgObjiLPNPage;
	LPNLockUnlockPage pgObjLPNLockUnlockPage;
	ASNPage pgObjASNPage;
	PixTransactionPage pgObjPixTransactionPage;


	@Test
	public void GFL_ONT_CON_IM_L_UL_UI_02()
	{
		testParameters.setIterationMode(IterationOptions.RunAllIterations);
		driveTestExecution();
	}

	@Override
	protected void executeTestCase() throws Exception
	{
		//*******************************Variable Declarations and Assignments**********************************\\
		String strSheetName = "lockunlocklpns";

		//******************************Input from Datatable****************************************************\\
		String strUserID = dataTable.getData(strSheetName, "UserID");
		String strPassword = dataTable.getData(strSheetName, "Password");
		String striLPNID=dataTable.getData(strSheetName, "iLPNID");  
		String strLockStatus_Before = dataTable.getData(strSheetName, "LockStatus_Before");
		String strLockStatus_After = dataTable.getData(strSheetName, "LockStatus_After");
		String strASNsNumber = dataTable.getData(strSheetName, "ASN_Number");
		String strLockCode = dataTable.getData(strSheetName, "LockCode");
		String strStatus = dataTable.getData(strSheetName, "ASNStatus");
		String strActionCode = dataTable.getData(strSheetName, "ActionCode");
		String strType = dataTable.getData(strSheetName, "TransType");
		String strCode = dataTable.getData(strSheetName, "TransCode");
		String strAdjQty = dataTable.getData(strSheetName, "AdjustmentQty");
		String strLPN=dataTable.getData(strSheetName, "iLPNID");
		
		//*************************************************Login Page***************************************//
		report.addTestLogSubSection("LoginPage");
		pgObjLoginPage = new LoginPage(scriptHelper);
		pgObjLoginPage.loginWithValidUser(strUserID, strPassword);

		//*************************************************Menu Page***************************************//
		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage = new MenuPage(scriptHelper);
		pgObjMenuPage.clickMenuIcon();
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "btniLPNs");
		pgObjMenuPage.clickWindowMaximize();		

		//*************************************************iLPN Page**************************************//
		report.addTestLogSubSection("iLPN Page");
		pgObjiLPNPage = new iLPNPage(scriptHelper);
		pgObjiLPNPage.applyiLPN(striLPNID);		
		pgObjiLPNPage.validateSearchResult();
		pgObjiLPNPage.verifyLockStatus(striLPNID,strLockStatus_Before);
		pgObjiLPNPage.closeWindow();
		
		//*************************************************Menu Page***************************************//
		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage = new MenuPage(scriptHelper);
		pgObjMenuPage.clickMenuIcon();
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "lnkASNs");
		pgObjMenuPage.clickWindowMaximize();	

		//*************************************************ASN page**************************************//
		report.addTestLogSubSection("ASN Number");
		pgObjASNPage = new ASNPage(scriptHelper);
		pgObjASNPage.enterASNsNumber(strASNsNumber);
//		pgObjASNPage.verifyASNTable();
		pgObjASNPage.verifyASNStatus(strStatus);
		pgObjASNPage.closeWindow();
		
		//*************************************************Menu Page***************************************//
		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage = new MenuPage(scriptHelper);
		pgObjMenuPage.clickMenuIcon();
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "btniLPNs");
		pgObjMenuPage.clickWindowMaximize();		


		//*************************************************iLPN Page**************************************//
		report.addTestLogSubSection("iLPN Page");
		pgObjiLPNPage.applyiLPN(striLPNID);		
		pgObjiLPNPage.SelectAllCheckBox();
		pgObjiLPNPage.clickLockOrUnlockButton_iLPNPage();	


		//*************************************************Lock Unlock page**************************************//
		pgObjLPNLockUnlockPage = new LPNLockUnlockPage(scriptHelper);
		report.addTestLogSubSection("Lock Unlock Page");
		pgObjLPNLockUnlockPage.lockiLPN(strLockCode);
		pgObjLPNLockUnlockPage.closeWindow();
		
		//*************************************************Menu Page***************************************//
		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage = new MenuPage(scriptHelper);
		pgObjMenuPage.clickMenuIcon();
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "btniLPNs");
		pgObjMenuPage.clickWindowMaximize();		
		
		//*************************************************iLPN page**************************************//
		report.addTestLogSubSection("iLPN");			
		pgObjiLPNPage.applyiLPN(striLPNID);
		pgObjiLPNPage.verifyLockStatus(striLPNID,strLockStatus_After);
		pgObjiLPNPage.closeWindow();
		
		//*************************************************Menu Page***************************************//
		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage = new MenuPage(scriptHelper);
		pgObjMenuPage.clickMenuIcon();
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "PixTransaction");
		pgObjMenuPage.clickWindowMaximize();

		//*************************************************Pix Transaction page**************************************//
		report.addTestLogSubSection("PIX Transaction");
		pgObjPixTransactionPage = new PixTransactionPage(scriptHelper);
		pgObjPixTransactionPage.searchPIXTransaction(strType, strCode);
		 Thread.sleep(8000);
		pgObjPixTransactionPage.verifyPIXStatus(strLPN, strActionCode, strAdjQty);	
	}
	@Override
	protected void setUp()
	{
		report.addTestLogSection("Setup");
		String strURL = properties.getProperty("ApplicationUrl");
		driver.get(strURL);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		report.updateTestLog("Invoke Application", "Invoke the application under test @ " +
				properties.getProperty("ApplicationUrl"), Status.DONE);
	}

	@Override
	protected void tearDown() {
		// TODO Auto-generated method stub

	}

}