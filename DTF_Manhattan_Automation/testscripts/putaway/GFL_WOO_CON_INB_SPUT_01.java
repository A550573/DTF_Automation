package testscripts.putaway;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import pages.AnyManhattanPage;
import pages.LPNLockUnlockPage;
import pages.LoginPage;
import pages.MenuPage;
import pages.RFMenuPage;
import pages.iLPNDetailsPage;
import pages.iLPNPage;
import supportlibraries.DriverScript;

import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.Status;


/**
 * ################################################SCRIPT CREATION HISTORY ################################################
 * @Header(
 * Test Name     =      'GFL_WOO_CON_INB_SPUT_01'
 * Description   =      'To perform System directed putaway from pallet reserve drop zone ZCJ to corresponding valid 
 * 						 reserve location in aisle ZCJ.'
 * Author        =      'Nitika'
 * Created On    =      'June 18 2014'                                                                 
 * )
 * @version      =      '1.0'
 * @category     =		'Putaway'
 * ########################################################################################################################
 */
public class GFL_WOO_CON_INB_SPUT_01 extends DriverScript{

	//*******************************Page Object Declarations**********************************************************//
	AnyManhattanPage pgObjAnyManhattanPage;
	LoginPage pgObjLoginPage;
	MenuPage pgObjMenuPage;
	iLPNPage pgObjiLPNPage;
	LPNLockUnlockPage pgObjLPNLockUnlockPage;
	iLPNDetailsPage pgObjiLPNDetailsPage;
	RFMenuPage pgObjRFMenuPage;

	@Test
	public void GFL_WOO_CON_INB_SPUT_01()
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
	protected void executeTestCase() throws Exception
	{
		//*******************************Variable Declarations and Assignments**********************************\\
		String strSheetName = "putaway";

		//******************************Input from Datatable ****************************************************\\
		String strUserID = dataTable.getData(strSheetName, "UserID");
		String strPassword = dataTable.getData(strSheetName, "Password");
		
		String striLPNNumber = dataTable.getData(strSheetName, "iLPNNumber");  
		String strFacilityStatus = dataTable.getData(strSheetName, "FacilityStatus");
		String strlockStatus = dataTable.getData(strSheetName, "LockStatus");
		String strFacility = dataTable.getData(strSheetName, "Facility");
		String strLockCode = dataTable.getData(strSheetName, "LockCode");
		String strFromLocation  = dataTable.getData(strSheetName, "From_Loc"); 
		String strToLocation = dataTable.getData(strSheetName, "To_Loc");
		
		String strTaskGrp = dataTable.getData(strSheetName, "Task_Grp");
		String strchoice1=dataTable.getData(strSheetName, "Choice_1");
		String strchoice2=dataTable.getData(strSheetName, "Choice_2");

		//*************************************************Any Sears Page***************************************//
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
		pgObjiLPNPage.applyiLPN(striLPNNumber);
		pgObjiLPNPage.validateSearchResult();			
		pgObjiLPNPage.validateiLPN(strFacilityStatus, strFacility);
		pgObjiLPNPage.SelectAllCheckBox();
		pgObjiLPNPage.clickViewButton();
		
		//*************************************************iLPN Details Page**************************************//
		report.addTestLogSubSection("iLPN Details Page");
		pgObjiLPNDetailsPage = new iLPNDetailsPage(scriptHelper);
		Thread.sleep(4000);
		pgObjiLPNDetailsPage.validateiLPNLocationDetails(strFromLocation,strToLocation);
		Thread.sleep(4000);
		pgObjiLPNDetailsPage.validateiLPNLockCode(strLockCode);
		Thread.sleep(2000);
		pgObjiLPNDetailsPage.closeWindow();
		
		//*************************************************Menu Page***************************************//                               
        report.addTestLogSubSection("Menu Page");
        pgObjMenuPage = new MenuPage(scriptHelper);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		pgObjMenuPage.clickMenuIcon();
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "btnRFMenu");
		pgObjMenuPage.clickWindowMaximize();  
		
		//*************************************************RF Menu Page***************************************//                               
        report.addTestLogSubSection("RF Menu Page");
        pgObjRFMenuPage = new RFMenuPage(scriptHelper);
        pgObjRFMenuPage.clickOptionsIcon();
        pgObjRFMenuPage.clickOnChangeTaskGrp();
        pgObjRFMenuPage.updateTaskGrp(strTaskGrp);
        Thread.sleep(4000);
        pgObjRFMenuPage.clickOptionsIcon();
        pgObjRFMenuPage.clickOnChangeTaskGrp();
        pgObjRFMenuPage.verifyupdatedTaskGrp(strTaskGrp);
        pgObjRFMenuPage.clickOnEnterButton();
        Thread.sleep(3000);
        pgObjRFMenuPage.enterchoice(strchoice1);
        pgObjRFMenuPage.pressEnter();
        Thread.sleep(3000);
        pgObjRFMenuPage.enterchoice(strchoice2);
        Thread.sleep(2000); 
        pgObjRFMenuPage.pressEnter();
        Thread.sleep(2000);
        pgObjRFMenuPage.enterLPNNumForBulk(striLPNNumber);
        pgObjRFMenuPage.pressEnter();
        Thread.sleep(2000);
        pgObjRFMenuPage.clickAcceptAndProceed();
        String strLocation = pgObjRFMenuPage.enterRLocForBulk();
        Thread.sleep(2000);
        pgObjRFMenuPage.pressEnter();
        pgObjRFMenuPage.closeWindow();
        
		//*************************************************Menu Page***************************************//

		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage.clickMenuIcon();		
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "btniLPNs");
		pgObjMenuPage.clickWindowMaximize();		
		
		//*************************************************iLPN Page**************************************//
		report.addTestLogSubSection("iLPN Page");
		pgObjiLPNPage.applyiLPN(striLPNNumber);			
		pgObjiLPNPage.validateiLPN(strFacilityStatus, strFacility);
		pgObjiLPNPage.verifyLockStatus(striLPNNumber, strlockStatus) ;
		pgObjiLPNPage.SelectAllCheckBox();
		pgObjiLPNPage.clickViewButton();
		
		//*************************************************iLPN Details Page**************************************//
		report.addTestLogSubSection("iLPN Details Page");
		pgObjiLPNDetailsPage = new iLPNDetailsPage(scriptHelper);
		Thread.sleep(4000);
		pgObjiLPNDetailsPage.validateiLPNLocationDetails(strToLocation,strLocation);
		Thread.sleep(4000);
		pgObjiLPNDetailsPage.closeWindow();

	}
	
	@Override
	protected void tearDown() {
		// TODO Auto-generated method stub

	}

}
