package testscripts.prerecieving;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import pages.AnyManhattanPage;
import pages.CreateAsnFromPOPage;
import pages.LPNLockUnlockPage;
import pages.LoginPage;
import pages.MenuPage;
import pages.PurchaseOrderPage;
import pages.RFMenuPage;
import pages.iLPNDetailsPage;
import pages.iLPNPage;
import supportlibraries.DriverScript;

import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.Status;

/**
 * ################################################SCRIPT CREATION HISTORY ################################################
 * @Header(
 * Test Name     =      'GFL_WOO_CON_INB_PreRecv_05'
 * Description   =      'To locate a PO # in to WMOS using the Create ASN from PO  and Purchase orders screen.'
 * Author        =      'Nitika'
 * Created On    =      'June 2 2014'                                                                 
 * )
 * @version      =      '1.0'
 * @category     =		'Pre-Recieving'
 * ########################################################################################################################
 */

public class GFL_WOO_CON_INB_PreRecv_05 extends DriverScript{

	//*******************************Page Object Declarations**********************************************************//
	AnyManhattanPage pgObjAnyManhattanPage;
	LoginPage pgObjLoginPage;
	MenuPage pgObjMenuPage;
	PurchaseOrderPage pgObjPurchaseOrderPage;
	CreateAsnFromPOPage pgObjCreateAsnFromPOPage;

	@Test
	public void GFL_WOO_CON_INB_PreRecv_05()
	{
		testParameters.setIterationMode(IterationOptions.RunAllIterations);
		driveTestExecution();
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
	protected void executeTestCase() throws Exception {

		//*******************************Variable Declarations and Assignments**********************************\\
		String strSheetName = "prerecieving";

		//******************************Input from Datatable****************************************************\\
		String strUserID = dataTable.getData(strSheetName, "UserID");
		String strPassword = dataTable.getData(strSheetName, "Password");
		String strPurchaseID = dataTable.getData(strSheetName, "PO_ID");
		String strStatus = dataTable.getData(strSheetName, "LPN_Status");
		String strPoLines = dataTable.getData(strSheetName, "PO_Lines");

		//*************************************************Any Sears Page***************************************//
		report.addTestLogSubSection("LoginPage");
		pgObjLoginPage = new LoginPage(scriptHelper);
		pgObjLoginPage.loginWithValidUser(strUserID, strPassword);

		//*************************************************Menu Page***************************************//
		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage = new MenuPage(scriptHelper);
		pgObjMenuPage.clickMenuIcon();		
		pgObjMenuPage.clickSubLink("btnCategoryConfiguration", "btnPurchaseOrders");
		pgObjMenuPage.clickWindowMaximize();		

		//*************************************************Purchase Orders Page**************************************//
		report.addTestLogSubSection("Purchase Orders Page");
		pgObjPurchaseOrderPage = new PurchaseOrderPage(scriptHelper);
		pgObjPurchaseOrderPage.searchPurchaseOrderID(strPurchaseID);
		Thread.sleep(4000);
		pgObjPurchaseOrderPage.verifyPOTableHeaders();
		pgObjPurchaseOrderPage.validateiLPN(strStatus);
		pgObjPurchaseOrderPage.validateiLPNlines(strPoLines);
		Thread.sleep(2000);
		pgObjPurchaseOrderPage.closeWindow();

		//*************************************************Menu Page***************************************//
		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage.clickMenuIcon();		
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "lnkCreateASNs");
		pgObjMenuPage.clickWindowMaximize();

		//*************************************************Create ASN From PO Page**************************************//
		report.addTestLogSubSection("Create ASN From PO Page");
		pgObjCreateAsnFromPOPage = new CreateAsnFromPOPage(scriptHelper);
		pgObjCreateAsnFromPOPage.searchPurchaseOrderID(strPurchaseID);
		Thread.sleep(4000);
		pgObjCreateAsnFromPOPage.validatePoDetails(strPurchaseID, strPoLines,strStatus);
		
	}

	@Override
	protected void tearDown() {
		// TODO Auto-generated method stub

	}
}
