package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AddressExcelData {
	
	static String filePath = "C:\\Users\\Abhi\\eclipse-workspace\\Prestashop\\src\\main\\resources\\addressData.xlsx";
	
	public static String getCellData(int row,int col)throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		if(sheet == null) {
			throw new RuntimeException("Sheet not found");
		}
		if(sheet.getRow(row) == null) {
			throw new RuntimeException("Row not found");
		}
		
		
		DataFormatter formatter = new DataFormatter();

        String data = formatter.formatCellValue(sheet.getRow(row).getCell(col));
		
//		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		wb.close();
		return data;
		
	}
	
}
