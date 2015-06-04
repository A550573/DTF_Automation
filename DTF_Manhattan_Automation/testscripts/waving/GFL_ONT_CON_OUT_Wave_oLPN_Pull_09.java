package testscripts.waving;


import org.junit.Test;

import pages.AnyManhattanPage;
import pages.DistributionOrderPage;
import pages.LoginPage;
import pages.MenuPage;
import pages.ShipmentsPage;
import pages.WavesPage;
import pages.iLPNPage;
import pages.oLPNPage;
import supportlibraries.DriverScript;

import com.cognizant.framework.IterationOptions;
import com.cognizant.framework.Status;


/**
* ################################################SCRIPT CREATION HISTORY ################################################
* @Header(
* Test Name     =       'GFL_ONT_CON_OUT_Wave_oLPN_Pull_09'
* Description  	=       'This test scenario ensure that ‘ oLPN Pull’ wave can't be undone using ‘Undo Wave’ after some of
* 						 the cartons in the wave have been Shipped.'
* Author        =       'Yagna Priya D'
* Created On   	=       'June 03 2014'                                                                 
 * )
* @version      =       '1.0'
* @category     =		'Waving'
* ########################################################################################################################
*/
public class GFL_ONT_CON_OUT_Wave_oLPN_Pull_09 extends DriverScript{

                //*******************************Page Object Declarations**********************************************************//
	AnyManhattanPage pgObjAnyManhattanPage;
	LoginPage pgObjLoginPage;
	MenuPage pgObjMenuPage;
	iLPNPage pgObjiLPNPage;
	DistributionOrderPage pgObjDistributionOrderPage;
	WavesPage pgObjWavesPage;
	oLPNPage pgObjoLPNPage;
	ShipmentsPage pgObjShipmentsPage;
                

                @Test
                public void GFL_ONT_CON_OUT_Wave_oLPN_Pull_09()
                {
                                testParameters.setIterationMode(IterationOptions.RunAllIterations);
                                driveTestExecution();
                }

                @Override
                protected void executeTestCase() throws Exception
                {
                    //*******************************Variable Declarations and Assignments**********************************\\
                    String strSheetName = "waving";

                    //******************************Input from Datatable****************************************************\\
                    String strUserID = dataTable.getData(strSheetName, "UserID");
                    String strPassword = dataTable.getData(strSheetName, "Password");
                    
                    String strDistributionOrderID = dataTable.getData(strSheetName, "DistributionOrderID");  
                    String strDistributionOrderStatus_Before = dataTable.getData(strSheetName, "DistributionOrderStatus_Before");
                    
                    String striLPNNumber = dataTable.getData(strSheetName, "iLPNNumber");  
                    String striLPNStatus_Before = dataTable.getData(strSheetName, "iLPNStatus_Before");
                    
                    String stroLPNNumber = dataTable.getData(strSheetName, "oLPNNumber");  
                    String stroLPNStatus_Before = dataTable.getData(strSheetName, "oLPNStatus_Before");
                    String stroLPNStatus_After = dataTable.getData(strSheetName, "oLPNStatus_After");
                    
                    String strWaveNumber = dataTable.getData(strSheetName, "WaveNumber");  
                    String strWaveStatus = dataTable.getData(strSheetName, "WaveStatus");
                    
                    String strDistributionOrderStatus_After = dataTable.getData(strSheetName, "DistributionOrderStatus_After");  
                    String striLPNStatus_After = dataTable.getData(strSheetName, "iLPNStatus_After"); 
               
                  //*************************************************Login Page***************************************//
                	report.addTestLogSubSection("LoginPage");
            		pgObjLoginPage = new LoginPage(scriptHelper);
            		pgObjLoginPage.loginWithValidUser(strUserID, strPassword);
                    Thread.sleep(8000);
                    //*************************************************Menu Page***************************************//
            		report.addTestLogSubSection("Menu Page");		
            		pgObjMenuPage = new MenuPage(scriptHelper);
            		pgObjMenuPage.clickMenuIcon();
            		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "DistributionOrders");
            		pgObjMenuPage.clickWindowMaximize();		
            		//*************************************************Distribution Page**************************************//
            		report.addTestLogSubSection("Distribution Order Page");
            				
            		pgObjDistributionOrderPage = new DistributionOrderPage(scriptHelper);
            		pgObjDistributionOrderPage.loopSearchDistributionOrder(strDistributionOrderID, strDistributionOrderStatus_Before);
            		pgObjDistributionOrderPage.closeWindow();
            		//*************************************************Menu Page***************************************//
            		pgObjMenuPage.clickMenuIcon();
            		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "btniLPNs");
            		pgObjMenuPage.clickWindowMaximize();
            		//*************************************************iLPN Page**************************************//
            		report.addTestLogSubSection("iLPN Page");               		
            		pgObjiLPNPage = new iLPNPage(scriptHelper);
            		pgObjiLPNPage.loopSearchiLPN(striLPNNumber,striLPNStatus_Before);
            		pgObjiLPNPage.closeWindow();   
            		//*************************************************Menu Page***************************************//
            		report.addTestLogSubSection("Menu Page");
            		pgObjMenuPage.clickMenuIcon();
            		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "oLPNs");
            		pgObjMenuPage.clickWindowMaximize();
            		//*************************************************oLPN Page**************************************//
            		report.addTestLogSubSection("oLPN Page");	
            		pgObjoLPNPage = new oLPNPage(scriptHelper);
            		pgObjoLPNPage.searchAndValidateMultipleoLPN(stroLPNNumber,stroLPNStatus_Before);
            		pgObjoLPNPage.closeWindow();  
            		//*************************************************Menu Page***************************************//
            		report.addTestLogSubSection("Menu Page");
            		pgObjMenuPage.clickMenuIcon();
            		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "Waves");
            		pgObjMenuPage.clickWindowMaximize();
            		//*************************************************Waves Page**************************************//
            		report.addTestLogSubSection("Waves Page");
            		pgObjWavesPage = new WavesPage(scriptHelper);
            		pgObjWavesPage.searchWaveNumber(strWaveNumber);
            		pgObjWavesPage.selectWave(strWaveNumber);
            		pgObjWavesPage.clickUndoWave();
            		Thread.sleep(5000);            		
            		pgObjWavesPage.closeWindow();
            		//*************************************************Menu Page***************************************//
            		pgObjMenuPage.clickMenuIcon();
            		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "Waves");
            		pgObjMenuPage.clickWindowMaximize();
            		//*************************************************Waves Page**************************************//
            		Thread.sleep(5000);
            		pgObjWavesPage.searchWaveNumber(strWaveNumber);
            		pgObjWavesPage.selectWave(strWaveNumber);
            		pgObjWavesPage.validateWaveStatus(strWaveStatus);
            		pgObjWavesPage.closeWindow();
            		//*************************************************Menu Page***************************************//
            		report.addTestLogSubSection("Menu Page");
            		pgObjMenuPage.clickMenuIcon();
            		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "DistributionOrders");
            		pgObjMenuPage.clickWindowMaximize();
            		//*************************************************Distribution Order page**************************************//
            		report.addTestLogSubSection("Distribution Order Page");		
            		pgObjDistributionOrderPage = new DistributionOrderPage(scriptHelper);
            		pgObjDistributionOrderPage.loopSearchDistributionOrder(strDistributionOrderID, strDistributionOrderStatus_After);
            		pgObjDistributionOrderPage.closeWindow();
            		//*************************************************Menu Page***************************************//
            		report.addTestLogSubSection("Menu Page");
            		pgObjMenuPage.clickMenuIcon();
            		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "btniLPNs");
            		pgObjMenuPage.clickWindowMaximize();
            		//*************************************************iLPN Page**************************************//
            		report.addTestLogSubSection("iLPN Page");
            		pgObjiLPNPage = new iLPNPage(scriptHelper);
            		pgObjiLPNPage.loopSearchiLPN(striLPNNumber,striLPNStatus_After);
            		pgObjiLPNPage.closeWindow();   
            		//*************************************************Menu Page***************************************//
            		report.addTestLogSubSection("Menu Page");
            		pgObjMenuPage.clickMenuIcon();
            		pgObjMenuPage.clickSubLink("btnCategoryDistribution", "oLPNs");
            		pgObjMenuPage.clickWindowMaximize();
            		//*************************************************oLPN Page**************************************//
            		report.addTestLogSubSection("oLPN Page");	
            		pgObjoLPNPage = new oLPNPage(scriptHelper);
            		pgObjoLPNPage.searchAndValidateMultipleoLPN(stroLPNNumber, stroLPNStatus_After);
            		pgObjoLPNPage.closeWindow();                   		
            
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
