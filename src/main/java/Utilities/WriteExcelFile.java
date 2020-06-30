package Utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	/*****************************
	 * Write the output in Excel file
	 **********************************/

	public static String writeData(Hashtable<String, Object[]> dataSet) throws IOException {
		String fileName = DateUtils.getTimeStamp() + ".xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Headphone Results");
		sheet.setColumnWidth(0, 50 * 150);
		sheet.setColumnWidth(1, 50 * 150);
		Row headerRow = sheet.createRow(0);
		Cell headerCell1 = headerRow.createCell(0);
		Cell headerCell2 = headerRow.createCell(1);
		headerCell1.setCellValue("Principal for the first month");
		headerCell2.setCellValue("Interest for the first month");
		int rowNum = 1;
		Set<String> keys = dataSet.keySet();

		for (Object key : keys) {
			Row row = sheet.createRow(rowNum++);
			Object[] values = dataSet.get(key);
			int colNum = 0;
			for (Object value : values) {
				Cell cell = row.createCell(colNum++);
				if (value instanceof String) {
					cell.setCellValue((String) value);
				} else if (value instanceof Integer) {
					cell.setCellValue((Integer) value);
				}
			}
		}
		try {
			FileOutputStream fout = new FileOutputStream(
					System.getProperty("user.dir") + "\\test-output\\OutputExcelFile\\" + fileName);
			workbook.write(fout);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workbook.close();
		return fileName;
	}
}
