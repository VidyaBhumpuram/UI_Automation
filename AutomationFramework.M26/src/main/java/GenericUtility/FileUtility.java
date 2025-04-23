package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to File operations
 * @author Vidya
 */
public class FileUtility {
	
	/**
	 * This method will read data from property file for the key provided by caller and return the value to caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException{
		
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;		
	}
	
	
	/**
	 * This method will read data from Excel file and return the value to caller
	 * @param sheet
	 * @param rowId
	 * @param cellId
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readTestDataFromExcelFile(String sheetName, int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream fise = new FileInputStream("./src/test/resources/SwagLabTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String NAME = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();//used method chaining
		/*Row rw = sh.getRow(rowId);
		Cell cl = rw.getCell(cellId);
		String NAME = cl.getStringCellValue();*/
		return NAME;		
	}
}
