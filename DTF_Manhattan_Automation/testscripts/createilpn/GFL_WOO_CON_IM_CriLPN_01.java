package testscripts.createilpn;

import java.util.concurrent.TimeUnit;

import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.Status;

import pages.AnyManhattanPage;
import pages.LoginPage;
import pages.MenuPage;
import pages.PixTransactionPage;
import pages.RFMenuPage;
import pages.TaskPage;
import pages.iLPNPage;
import supportlibraries.DriverScript;

/**
 * ################################################SCRIPT CREATION HISTORY ################################################
 * @Header(
 * Test Name	=       'GFL_WOO_CON_IM_CriLPN_01'
 * Description  =       'TM should be able to create an iLPN using RF with cycle count (CC) reason code.'
 * Author     	=       'Yagna Priya D'
 * Created On   =       'June 19 2014')
 * @version     =       '1.0'
 * @category    =		'Create iLPN'
 * ########################################################################################################################
 */



public class GFL_WOO_CON_IM_CriLPN_01 extends DriverScript{

	AnyManhattanPage pgObjAnyManhattanPage;
	LoginPage pgObjLoginPage;
	MenuPage pgObjMenuPage;
	iLPNPage pgObjiLPN;
	TaskPage pgObjTaskPage;
	PixTransactionPage pgObjPixTransactionPage;
	RFMenuPage pgObjRFMenuPage;

	public void GFL_WOO_CON_IM_CriLPN_01()
	{
		testParameters.setIterationMode(IterationOptions.RunAllIterations);
		driveTestExecution();
	}

	@Override
	protected void executeTestCase() throws Exception {
		//*******************************Variable Declarations and Assignments**********************************\\
		String strSheetName = "createilpn";

		//******************************Input from Datatable****************************************************\\
		String strUserID = dataTable.getData(strSheetName, "UserID");
		String strPassword = dataTable.getData(strSheetName, "Password");

		String strchoice1 = dataTable.getData(strSheetName, "Choice1");
		String strchoice2 = dataTable.getData(strSheetName, "Choice2");

		String strLPNNumber = dataTable.getData(strSheetName, "LPNNumber");
		String strReasonCode = dataTable.getData(strSheetName, "ReasonCode");

		String strItemBarcode = dataTable.getData(strSheetName, "ItemBarcode");
		String strItemNumber = dataTable.getData(strSheetName, "Item_Num");
		String strQuantity = dataTable.getData(strSheetName, "Quantity");

		String strTransactionType = dataTable.getData(strSheetName, "TransactionType");
		String strTransactionCode = dataTable.getData(strSheetName, "TransactionCode");

		String strActionCode = dataTable.getData(strSheetName, "ActionCode");
		String strAdjustmentQty = dataTable.getData(strSheetName, "AdjustmentQty");
		String strLPNStatus = dataTable.getData(strSheetName, "LPNStatus");

		//*************************************************Login Page***************************************//
		report.addTestLogSubSection("LoginPage");
		pgObjLoginPage = new LoginPage(scriptHelper);
		pgObjLoginPage.loginWithValidUser(strUserID, strPassword);
		Thread.sleep(8000);
		//*************************************************Menu Page***************************************//                               
		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage = new MenuPage(scriptHelper);
		pgObjMenuPage.clickMenuIcon();
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "btnRFMenu");
		Thread.sleep(2000);
		pgObjMenuPage.clickWindowMaximize();  

		//*************************************************RF Menu Page***************************************//                               
		report.addTestLogSubSection("RF Menu Page");
		pgObjRFMenuPage = new RFMenuPage(scriptHelper);
		pgObjRFMenuPage.switchFrame();
		pgObjRFMenuPage.enterchoice(strchoice1);
		pgObjRFMenuPage.pressEnter();
		Thread.sleep(4000); 
		pgObjRFMenuPage.clickOnPageDown();
		Thread.sleep(4000); 
		pgObjRFMenuPage.enterchoice(strchoice2);
		Thread.sleep(4000);  
		pgObjRFMenuPage.pressEnter();
		Thread.sleep(4000); 
		pgObjRFMenuPage.CreateLPN(strLPNNumber,strReasonCode,strItemNumber,strQuantity);
		pgObjRFMenuPage.closeWindow();

		//*************************************************Menu Page***************************************//                               
		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage = new MenuPage(scriptHelper);
		pgObjMenuPage.clickMenuIcon();
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "PixTransaction");
		Thread.sleep(2000);
		pgObjMenuPage.clickWindowMaximize();

		//************************************************PIX Transactions Page*****************************//                               
		report.addTestLogSubSection("PixTransaction Page");
		pgObjPixTransactionPage = new PixTransactionPage(scriptHelper);
		pgObjPixTransactionPage.searchPIXTransaction(strTransactionType, strTransactionCode);
		Thread.sleep(8000);
		pgObjPixTransactionPage.verifyPIXStatus(strLPNNumber,strActionCode, strAdjustmentQty);
		Thread.sleep(2000);
		pgObjPixTransactionPage.closeWindow();

		//*************************************************Menu Page***************************************//                               
		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage = new MenuPage(scriptHelper);
		pgObjMenuPage.clickMenuIcon();
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "btniLPNs");
		Thread.sleep(2000);
		pgObjMenuPage.clickWindowMaximize();	

		//************************************************iLPN Page*************************************//
		report.addTestLogSubSection("iLPN Page");                 
		pgObjiLPN = new iLPNPage(scriptHelper);
		pgObjiLPN.applyiLPN(strLPNNumber);
		pgObjiLPN.validateiLPNStatus(strLPNStatus);
		Thread.sleep(2000);
		pgObjiLPN.closeWindow();
	}

	@Override
	protected void setUp() {
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
