package chase.bank.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import chase.bank.reporting.Logger;


public class ExcelReader {

	Workbook workbook;
	Sheet sheet;

	public ExcelReader(String path, int sheetNum) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (IOException e) {
			e.printStackTrace();
			Logger.log("File Not Found @ " + path);
		}
		if (path.endsWith(".xls")) {
			try {
				workbook = new HSSFWorkbook(fis);
			} catch (IOException e) {
				e.printStackTrace();
				Logger.log("File Not Found @ " + path);
			}
		} else if (path.endsWith(".xlsx")) {
			try {
				workbook = new XSSFWorkbook(fis);
			} catch (IOException e) {
				e.printStackTrace();
				Logger.log("File Not Found @ " + path);
			}
		}
		sheet = workbook.getSheetAt(sheetNum);
	}
	
	public String[][] testData(){
		String[][] data = null;
		int totalRows = sheet.getLastRowNum() + 1;
		System.out.println("Total Rows : " + totalRows);
		int totalCells = sheet.getRow(0).getLastCellNum();
		
		DataFormatter formatter = new DataFormatter();
		data = new String[totalRows][totalCells];
		
		for(int i = 1; i < totalRows; i++) {
			Row row = sheet.getRow(i);
			for(int j = 0; j < totalCells; j++) {
				try {
					Cell cell = row.getCell(j);
					data[i][j] = formatter.formatCellValue(cell);
					//data[i][j] = cell.getStringCellValue();
					System.out.println(data[i][j]);
				}catch(NullPointerException e) {
					data[i][j] = "";
				}
			}
		}
		
		return data;
	}
}
