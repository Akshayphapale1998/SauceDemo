package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
	
	public static String getExcelSheet(String sheet,int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream file= new FileInputStream("C:\\Users\\aksha\\eclipse-workspace\\SwagLabs\\src\\main\\resources\\TestDate_SwagLabs.xlsx");
	
		String value =WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	
		return value;
	}

}
