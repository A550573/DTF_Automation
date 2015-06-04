//package pages;
//
//
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.Toolkit;
//import java.awt.datatransfer.StringSelection;
//import java.awt.event.KeyEvent;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.StringWriter;
//
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//
//import com.cognizant.framework.Status;
//
//import functionallibraries.ManhattanCommonFunctions;
//import supportlibraries.ScriptHelper;
//
//
//import java.io.File;
//import java.io.IOException;
//
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.Cell;
//
//public class PostMessagePage extends AnyManhattanPage{
//
//	static String writAr[]={"stritemName","strDescription","strLongDescription","strDangerousGoodsID","strUnitWeight","strUnitVolume","strUnitHeight",
//		"strUnitWidth","strUnitLength","strCommodityLevelDesc","strItemBarCode","strVendorItemNbr","strTmpZone","strSplInstr1","strNMFCCode","strProdCatgry","strSalesGroup","strQuantity"};
//
//	static Map<String, String> map = new HashMap<String, String>();
//	static File strDirectoryPath = new File("C:\\Users\\A543457\\AutomationXMLData\\ItemFiles\\TUC");
//	static boolean blnFlag = false;
//	/**
//	 *********************************************************************** 
//	 * Constructor to initialize the page
//	 * @return 	Nothing is returned as of now  
//	 * @param 	scriptHelper The {@link ScriptHelper} object passed from the {@link TestScript}
//	 * @version 1.0
//	 ***********************************************************************
//	 */
//	public PostMessagePage(ScriptHelper scriptHelper) {
//		super(scriptHelper);
//		// TODO Auto-generated constructor stub
//		
//		
//	}	
//
//	/**
//	 *********************************************************************** 
//	 * Function to verify the current page.
//	 * @return 	Nothing is returned as of now 
//	 * @param 	None
//	 * @version 1.0
//	 ***********************************************************************
//	 */
//		@Override
//		protected void initializeUIMap()
//		{
//			libManhattanCommonFunctions = new ManhattanCommonFunctions(scriptHelper);
//			
//		}
//		
//		
//		public enum enumPageObjects
//		{
//			ChooseFile, textarea;
//		}
//
//		/**
//		 * Takes element name as a parameter defined in enumPageObjects and identifies the object based on the object definition
//		 * @param	strElemName The {@link strElemName} are objects identified so far in AnyManhattanPage.
//		 * 			Values: ChooseFile, textarea
//		 * @return	The WebElement object if it exists. Else returns null
//		 */
//		public WebElement getPageElement(String strElemName)
//		{
//			WebElement elemToFind = null;
//			try {
//				switch (enumPageObjects.valueOf(strElemName)) {
//				
//				case ChooseFile:
//					elemToFind = libManhattanCommonFunctions.getElementByProperty("//input[@id='dataForm:uploadedFileID']", "XPATH");
//					break;
//				case textarea:
//					elemToFind = libManhattanCommonFunctions.getElementByProperty("//*[@id='dataForm:xmlString']", "XPATH");
//					break;
//				
//			default:
//				break;
//			}
//			report.updateTestLog("Post Message- GET PAGE ELEMENT", "" + strElemName+ "is selected from Main menu", Status.DONE);
//		} catch (Exception e) {
//			report.updateTestLog("Post Message- GET PAGE ELEMENT", "" + strElemName+ "is not found", Status.FAIL);
//		}
//		return elemToFind;
//	
//		}
//		
//		/**
//		 *********************************************************************** 
//		 * Function clicks on choose file.
//		 * @return 	Nothing is returned as of now 
//		 * @Author 	Aishwarya
//		 * @param 	None
//		 * @version 1.0
//		 * @throws InterruptedException 
//		 ***********************************************************************
//		 */
//		public void clickPostMessage() throws InterruptedException{
//			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'ext-gen')]")));
//			libManhattanCommonFunctions.clickAnyElement(getPageElement("ChooseFile"), "Choose File");
//			Thread.sleep(3000);
//			
//		}
//		
//		/**
//		 *********************************************************************** 
//		 * Function uploads xml.
//		 * @return 	Nothing is returned as of now 
//		 * @Author 	Aishwarya
//		 * @param 	None
//		 * @version 1.0
//		 ***********************************************************************
//		 */
//		public void uploadxml() throws AWTException{
//			
//			try{
//			StringSelection ss = new StringSelection(strDirectoryPath+"\\Item_"+map.get("stritemName")+".xml");
//			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//			Robot robot = new Robot();
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(1200000);
//			
//			driver.findElement(By.xpath("[@type='submit']")).click();
//			report.updateTestLog("Verify File Upload", "File Uploaded", Status.PASS);
//			} catch (Exception e) {
//				report.updateTestLog("Verify File Upload", "File Not Uploaded", Status.FAIL);
//			}
//			
//		}
//		
//
//		/**
//		 *********************************************************************** 
//		 * Function converts xml to string.
//		 * @return 	Nothing is returned as of now 
//		 * @Author 	Aishwarya
//		 * @param 	None
//		 * @version 1.0
//		 ***********************************************************************
//		 */	
//	public String convertXMLFileToString() 
//    { 
//      try{ 
//        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance(); 
//        InputStream inputStream = new FileInputStream(new File(strDirectoryPath+"\\Item_"+map.get("stritemName")+".xml")); 
//        org.w3c.dom.Document doc = documentBuilderFactory.newDocumentBuilder().parse(inputStream); 
//        StringWriter stw = new StringWriter(); 
//        Transformer serializer = TransformerFactory.newInstance().newTransformer(); 
//        serializer.transform(new DOMSource(doc), new StreamResult(stw)); 
//       String strcopy = stw.toString();
//       System.out.println(strcopy);
//       driver.findElement(By.xpath("//*[@id='dataForm:xmlString']")).sendKeys(strcopy);
//      // libManhattanCommonFunctions.clearAndUpdateAnyElement(getPageElement("textarea"), strcopy, "textarea");
//      } 
//      catch (Exception e) { 
//        e.printStackTrace(); 
//      } 
//        return null; 
//    }
//		
//	public static void readExcelSheet()
//	{ 
//		/*File excelSheet = null;
//		Workbook workbook = null;    
//		String[] arrData = null;*/
//		String destFile = "C:\\Users\\A543457\\Desktop\\Item_Extract_Sql1.xls";
//		try {
//			Workbook wb = Workbook.getWorkbook(new File(destFile));
//			System.out.println(wb.getNumberOfSheets());
//			
//			
//			if (strDirectoryPath.exists()) {
//				strDirectoryPath.delete();
//			}
//			if (strDirectoryPath.mkdirs()){
//				blnFlag = true;
//			}
//			for(int sheetNo=0; sheetNo<wb.getNumberOfSheets()-1;sheetNo++)
//			{                
//				Sheet sheet = wb.getSheet(sheetNo);
//				int columns = sheet.getColumns();
//				int rows = sheet.getRows();
//				//String data;
//				System.out.println("Sheet Name\t"+wb.getSheet(sheetNo).getName());
//				for(int row = 1;row < rows;row++) {
//					int intPointer = 1;
//					for(int col = 0;col < columns;col++) {
//						//data = sheet.getCell(col, row).getContents();
//						Cell cell = sheet.getCell(col, row);
//
//						String strcellval=cell.getContents();
//
//						map.put(writAr[intPointer-1], strcellval);
//						intPointer = intPointer+1;
//					}
//					updateItemXML();	
//				}			
//			}
//		} catch(Exception ioe) {
//			ioe.printStackTrace();
//		}
//
//	}
//
//
//	public static void updateItemXML()throws ParserConfigurationException, SAXException, IOException, TransformerException{
//		String filePath = "C:\\Users\\A543457\\Desktop\\DTF_GFL_ITEM_1_sample_TUC.xml";
//		File xmlFile = new File(filePath);
//		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder dBuilder;
//
//		dBuilder = dbFactory.newDocumentBuilder();
//		Document doc = dBuilder.parse(xmlFile);
//		doc.getDocumentElement().normalize();
//
//		//update Element value
//		updateItemName(doc);
//		updateDescription(doc);
//		updateLongDescription(doc);
//		updateUnitWeight(doc);
//		updateUnitVolume(doc);
//		updateUnitHeight(doc);
//		updateUnitWidth(doc);
//		updateUnitLength(doc);
//		updateCommodityLevelDesc(doc);
//		updateItemBarCode(doc);
//
//		updateSupplierItemBarCode(doc);
//
//		updateVendorItemNbr(doc);
//
//		//write the updated document to file or console
//		doc.getDocumentElement().normalize();
//		TransformerFactory transformerFactory = TransformerFactory.newInstance();
//		Transformer transformer = transformerFactory.newTransformer();
//		DOMSource source = new DOMSource(doc);
//
//		if (blnFlag = true){
//			StreamResult result = new StreamResult(new File(strDirectoryPath+"\\Item_"+map.get("stritemName")+".xml"));
//			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//			transformer.transform(source, result);
//			System.out.println("Item XML file updated successfully");
//		}
//	}
//
//	public static void updateItemName(Document doc) {
//		NodeList employees = doc.getElementsByTagName("Item");
//		Element emp = null;
//		//loop for each employee
//		for(int i=0; i<employees.getLength();i++){
//			emp = (Element) employees.item(i);
//			Node name = emp.getElementsByTagName("ItemName").item(0).getFirstChild();
//			name.setNodeValue(map.get("stritemName"));
//		}
//	}
//	public static void updateDescription(Document doc) {
//		NodeList employees = doc.getElementsByTagName("Item");
//		Element emp = null;
//		//loop for each employee
//		for(int i=0; i<employees.getLength();i++){
//			emp = (Element) employees.item(i);
//			Node name = emp.getElementsByTagName("Description").item(0).getFirstChild();
//			name.setNodeValue(map.get("strDescription"));
//		}
//	}
//	public static void updateLongDescription(Document doc) {
//		NodeList employees = doc.getElementsByTagName("Item");
//		Element emp = null;
//		//loop for each employee
//		for(int i=0; i<employees.getLength();i++){
//			emp = (Element) employees.item(i);
//			Node name = emp.getElementsByTagName("LongDescription").item(0).getFirstChild();
//			name.setNodeValue(map.get("strLongDescription"));
//		}
//	}
//	public static void updateUnitWeight(Document doc) {
//		NodeList employees = doc.getElementsByTagName("Item");
//		Element emp = null;
//		//loop for each employee
//		for(int i=0; i<employees.getLength();i++){
//			emp = (Element) employees.item(i);
//			Node name = emp.getElementsByTagName("UnitWeight").item(0).getFirstChild();
//			name.setNodeValue(map.get("strUnitWeight"));
//		}
//	}
//
//	public static void updateUnitVolume(Document doc) {
//		NodeList employees = doc.getElementsByTagName("Item");
//		Element emp = null;
//		//loop for each employee
//		for(int i=0; i<employees.getLength();i++){
//			emp = (Element) employees.item(i);
//			Node name = emp.getElementsByTagName("UnitVolume").item(0).getFirstChild();
//			name.setNodeValue(map.get("strUnitVolume"));
//		}
//	}
//	public static void updateUnitHeight(Document doc) {
//		NodeList employees = doc.getElementsByTagName("Item");
//		Element emp = null;
//		//loop for each employee
//		for(int i=0; i<employees.getLength();i++){
//			emp = (Element) employees.item(i);
//			Node name = emp.getElementsByTagName("UnitHeight").item(0).getFirstChild();
//			name.setNodeValue(map.get("strUnitHeight"));
//		}
//	}
//	public static void updateUnitWidth(Document doc) {
//		NodeList employees = doc.getElementsByTagName("Item");
//		Element emp = null;
//		//loop for each employee
//		for(int i=0; i<employees.getLength();i++){
//			emp = (Element) employees.item(i);
//			Node name = emp.getElementsByTagName("UnitWidth").item(0).getFirstChild();
//			name.setNodeValue(map.get("strUnitWidth"));
//		}
//	}
//	public static void updateUnitLength(Document doc) {
//		NodeList employees = doc.getElementsByTagName("Item");
//		Element emp = null;
//		//loop for each employee
//		for(int i=0; i<employees.getLength();i++){
//			emp = (Element) employees.item(i);
//			Node name = emp.getElementsByTagName("UnitLength").item(0).getFirstChild();
//			name.setNodeValue(map.get("strUnitLength"));
//		}
//	}
//	public static void updateCommodityLevelDesc(Document doc) {
//		NodeList employees = doc.getElementsByTagName("Item");
//		Element emp = null;
//		//loop for each employee
//		for(int i=0; i<employees.getLength();i++){
//			emp = (Element) employees.item(i);
//			Node name = emp.getElementsByTagName("CommodityLevelDesc").item(0).getFirstChild();
//			name.setNodeValue(map.get("strCommodityLevelDesc"));
//		}
//	}
//	public static void updateItemBarCode(Document doc) {
//		NodeList employees = doc.getElementsByTagName("Item");
//		Element emp = null;
//		//loop for each employee
//		for(int i=0; i<employees.getLength();i++){
//			emp = (Element) employees.item(i);
//			Node name = emp.getElementsByTagName("ItemBarCode").item(0).getFirstChild();
//			name.setNodeValue(map.get("strItemBarCode"));
//		}
//	}
//	public static void updateSupplierItemBarCode(Document doc) {
//		NodeList employees = doc.getElementsByTagName("ItemSupplierXrefList");
//		Element emp = null;
//		//loop for each employee
//		for(int i=0; i<employees.getLength();i++){
//			emp = (Element) employees.item(i);
//			Node name = emp.getElementsByTagName("ItemBarCode").item(0).getFirstChild();
//			name.setNodeValue(map.get("strItemBarCode"));
//		}
//	}
//	public static void updateVendorItemNbr(Document doc) {
//		NodeList employees = doc.getElementsByTagName("ItemWmos");
//		Element emp = null;
//		//loop for each employee
//		for(int i=0; i<employees.getLength();i++){
//			emp = (Element) employees.item(i);
//			Node name = emp.getElementsByTagName("VendorItemNbr").item(0).getFirstChild();
//			name.setNodeValue(map.get("strVendorItemNbr"));
//		}
//	}
//	public static void updateTmpZone(Document doc) {
//		NodeList employees = doc.getElementsByTagName("ItemWmos");
//		Element emp = null;
//		//loop for each employee
//		for(int i=0; i<employees.getLength();i++){
//			emp = (Element) employees.item(i);
//			Node name = emp.getElementsByTagName("TmpZone").item(0).getFirstChild();
//			name.setNodeValue(map.get("strTmpZone"));
//		}
//	}
//	public static void updateSplInstr1(Document doc) {
//		NodeList employees = doc.getElementsByTagName("ItemWmos");
//		Element emp = null;
//		//loop for each employee
//		for(int i=0; i<employees.getLength();i++){
//			emp = (Element) employees.item(i);
//			Node name = emp.getElementsByTagName("SplInstrCode1").item(0).getFirstChild();
//			name.setNodeValue(map.get("strSplInstr1"));
//		}
//	}
//	
//	public static void updateNMFCCode(Document doc) {
//		NodeList employees = doc.getElementsByTagName("ItemWmos");
//		Element emp = null;
//		//loop for each employee
//		for(int i=0; i<employees.getLength();i++){
//			emp = (Element) employees.item(i);
//			Node name = emp.getElementsByTagName("NmfcCode").item(0).getFirstChild();
//			name.setNodeValue(map.get("strNMFCCode"));
//		}
//	}
////	public static void updateProdCatgry(Document doc) {
////		NodeList employees = doc.getElementsByTagName("ItemWmos");
////		Element emp = null;
////		//loop for each employee
////		for(int i=0; i<employees.getLength();i++){
////			emp = (Element) employees.item(i);
////			Node name = emp.getElementsByTagName("VendorItemNbr").item(0).getFirstChild();
////			name.setNodeValue(map.get("strVendorItemNbr"));
////		}
////	}
////	public static void updateVendorItemNbr(Document doc) {
////		NodeList employees = doc.getElementsByTagName("ItemWmos");
////		Element emp = null;
////		//loop for each employee
////		for(int i=0; i<employees.getLength();i++){
////			emp = (Element) employees.item(i);
////			Node name = emp.getElementsByTagName("VendorItemNbr").item(0).getFirstChild();
////			name.setNodeValue(map.get("strVendorItemNbr"));
////		}
////	}
////	public static void updateVendorItemNbr(Document doc) {
////		NodeList employees = doc.getElementsByTagName("ItemWmos");
////		Element emp = null;
////		//loop for each employee
////		for(int i=0; i<employees.getLength();i++){
////			emp = (Element) employees.item(i);
////			Node name = emp.getElementsByTagName("VendorItemNbr").item(0).getFirstChild();
////			name.setNodeValue(map.get("strVendorItemNbr"));
////		}
////	}
//		
//		
//		
//	
//}
