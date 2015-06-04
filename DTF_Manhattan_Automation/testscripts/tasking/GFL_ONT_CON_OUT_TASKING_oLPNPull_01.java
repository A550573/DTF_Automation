package testscripts.tasking;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import pages.AnyManhattanPage;
import pages.DistributionOrderPage;
import pages.LoginPage;
import pages.MenuPage;
import pages.RFMenuPage;
import pages.RunWavesPage;
import pages.TaskPage;
import pages.WaveDetailsPage;
import pages.WavesPage;
import pages.iLPNDetailsPage;
import pages.iLPNPage;
import pages.oLPNPage;
import supportlibraries.DriverScript;

import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.Status;


/**
 * ################################################SCRIPT CREATION HISTORY ################################################
 * @Header(
 * Test Name     =      'GFL_ONT_CON_OUT_TASKING_oLPNPull_01'
 * Description   =      'This test scenario ensures that 'oLPN Wave' generates ' oLPN Pull Task' out of a Pallet Reserve 
 *                       location and TM with access to task group CPT should be able to complete them successfully using RF 
 *                       CTRL + E option.'
 * Author        =      'Nitika'
 * Created On    =      'Sep 30 2014'      
 * @version      =      '1.0'
 * @category     =       'Tasking'
 * ########################################################################################################################
 */

public class GFL_ONT_CON_OUT_TASKING_oLPNPull_01 extends DriverScript{

	//*******************************Page Object Declarations**********************************************************//
	AnyManhattanPage pgObjAnyManhattanPage;
	LoginPage pgObjLoginPage;
	MenuPage pgObjMenuPage;
	iLPNPage pgObjiLPNPage;
	RunWavesPage pgObjRunWavesPage;
	WavesPage pgObjWavesPage;
	WaveDetailsPage pgObjWaveDetailsPage;
	TaskPage pgObjTaskPage;
	RFMenuPage pgObjRFMenuPage;
	oLPNPage pgObjoLPNPage;
	DistributionOrderPage pgObjDistributionOrderPage;

	@Test
	public void GFL_ONT_CON_OUT_TASKING_oLPNPull_01()
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
		String strSheetName = "tasking";

		//******************************Input from Datatable****************************************************\\
		String strUserID = dataTable.getData(strSheetName, "UserID");
		String strPassword = dataTable.getData(strSheetName, "Password");
		String strWaveParameter = dataTable.getData(strSheetName, "WaveParameter");
		String strWaveStatus = dataTable.getData(strSheetName, "WaveStatus");
		String strHeaderStatus = dataTable.getData(strSheetName, "HeaderStatus");
		String strTaskType = dataTable.getData(strSheetName, "TaskType");
		String strTaskGrp = dataTable.getData(strSheetName, "TaskGrp");
		String strPallet = dataTable.getData(strSheetName, "Pallet_Id");
		String strDistributionOrderID = dataTable.getData(strSheetName, "DistributionOrderID");
		String strQty = dataTable.getData(strSheetName, "Quantity");
		String strStatus = dataTable.getData(strSheetName, "Status");
		String stroLPNStatus = dataTable.getData(strSheetName, "oLPNStatus");
		
		//*************************************************Any Sears Page***************************************//
		report.addTestLogSubSection("LoginPage");
		pgObjLoginPage = new LoginPage(scriptHelper);
		pgObjLoginPage.loginWithValidUser(strUserID, strPassword);

		//*************************************************Menu Page***************************************//
		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage = new MenuPage(scriptHelper);
		pgObjMenuPage.clickMenuIcon();                          
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "DistributionOrders");
		pgObjMenuPage.clickWindowMaximize();          

		//*************************************************Distribution Orders Page**************************************//
		report.addTestLogSubSection("Distribution Orders Page");
		pgObjDistributionOrderPage = new DistributionOrderPage(scriptHelper);
		pgObjDistributionOrderPage.searchDistributionOrderID(strDistributionOrderID);
		Thread.sleep(4000);
		pgObjDistributionOrderPage.validateDistributionOrderStatus(strHeaderStatus);
		pgObjDistributionOrderPage.WaveAllDO();

		//*************************************************Run Waves Page**************************************//
		report.addTestLogSubSection("Run Waves Page");
		pgObjRunWavesPage = new RunWavesPage(scriptHelper);
		Thread.sleep(4000);
		pgObjRunWavesPage.selectWaveParameter(strWaveParameter);
		pgObjRunWavesPage.clickOnSubmitWave();
		Thread.sleep(4000);
		String WaveNum = pgObjRunWavesPage.getWaveNumber();
		System.out.println(WaveNum);
		pgObjRunWavesPage.closeWindow();

		//*************************************************Menu Page***************************************//
		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage = new MenuPage(scriptHelper);
		pgObjMenuPage.clickMenuIcon();                          
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "Waves");
		pgObjMenuPage.clickWindowMaximize();          

		//*************************************************Waves Page**************************************//
		report.addTestLogSubSection("Waves Page");
		pgObjWavesPage = new WavesPage(scriptHelper);
		pgObjWavesPage.searchWaveNumber(WaveNum);
		Thread.sleep(2000);
		pgObjWavesPage.viewWaveDetails();

		//*************************************************Wave Details Page**************************************//
		report.addTestLogSubSection("Wave Details Page");
		pgObjWaveDetailsPage = new WaveDetailsPage(scriptHelper);
		pgObjWaveDetailsPage.WaitForWave(strWaveStatus);
		Thread.sleep(2000);
		pgObjWaveDetailsPage.ViewLPNDetails();

		//*************************************************oLPN Page**************************************//
		report.addTestLogSubSection("oLPN Page");
		pgObjoLPNPage = new oLPNPage(scriptHelper);
		Thread.sleep(2000);
		pgObjoLPNPage.validateoLPNStatus(stroLPNStatus);
		String[] strLPNId =pgObjoLPNPage.RetreiveandValidateMultipleOlpn(stroLPNStatus);
		pgObjoLPNPage.closeWindow();

		//*************************************************Menu Page***************************************//
		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage.clickMenuIcon();                          
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "Waves");
		pgObjMenuPage.clickWindowMaximize();          

		//*************************************************Waves Page**************************************//
		report.addTestLogSubSection("Waves Page");
		pgObjWavesPage = new WavesPage(scriptHelper);
		pgObjWavesPage.searchWaveNumber(WaveNum);
		pgObjWavesPage.viewWaveDetails();

		//*************************************************Wave Details Page**************************************//
		report.addTestLogSubSection("Wave Details Page");
		pgObjWaveDetailsPage = new WaveDetailsPage(scriptHelper);
		Thread.sleep(4000);
		pgObjWaveDetailsPage.ViewTaskDetails();

		//*************************************************Tasks Page**************************************//
		report.addTestLogSubSection("Tasks Page");
		pgObjTaskPage = new TaskPage(scriptHelper);
		String strTaskId = pgObjTaskPage.getTaskId();
		pgObjTaskPage.validateTaskDetails(strTaskType,strHeaderStatus);
		pgObjTaskPage.closeWindow();

		//*************************************************Menu Page***************************************//
		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage = new MenuPage(scriptHelper);
		pgObjMenuPage.clickMenuIcon();                          
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "btnRFMenu");
		pgObjMenuPage.clickWindowMaximize();                     

		//*************************************************RF Menu Page**************************************//
		report.addTestLogSubSection("RF Menu Page");
		pgObjRFMenuPage = new RFMenuPage(scriptHelper);
		pgObjRFMenuPage.clickOptionsIcon();
		Thread.sleep(2000);
		pgObjRFMenuPage.clickOnChangeTaskGrp();
		pgObjRFMenuPage.updateTaskGrp(strTaskGrp);
		Thread.sleep(2000);
		pgObjRFMenuPage.clickOptionsIcon();
		Thread.sleep(2000);                       
		String[] strMultipleTaskId=pgObjRFMenuPage.splitDataValues(strTaskId);
		String[] strMultiplePallet=pgObjRFMenuPage.splitDataValues(strPallet);
		for(int i=0;i<strMultipleTaskId.length;i++){
			pgObjRFMenuPage.enterTask(strMultipleTaskId[i]);
			String Item_Num = pgObjRFMenuPage.enterLPNTask(strQty,strMultiplePallet[i]);
		}
		pgObjRFMenuPage.closeWindow();

		//*************************************************Menu Page***************************************//
		report.addTestLogSubSection("Menu Page");
		pgObjMenuPage.clickMenuIcon();                          
		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "oLPNs");
		pgObjMenuPage.clickWindowMaximize();          

		//*************************************************oLPN Page**************************************//
		report.addTestLogSubSection("oLPN Page");
		pgObjoLPNPage = new oLPNPage(scriptHelper);
		pgObjoLPNPage.searchoLPN(strLPNId[0]);
		Thread.sleep(4000);
		pgObjoLPNPage.validateoLPNStatus(strStatus);

	}

	@Override
	protected void tearDown() {
		// TODO Auto-generated method stub

	}

}
