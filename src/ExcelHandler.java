import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class ExcelHandler {
	/**
	 * reads the data of an excel file
	 * @throws IOException 
	 */
	public void readExcelFile(String full_file_path) throws IOException {
		
		try {
			FileInputStream fis = new FileInputStream(new File(full_file_path));

			Workbook wb = new HSSFWorkbook(fis);
			Sheet sheet1 = wb.getSheetAt(0);
			for (Row row : sheet1) {
				for (Cell cell : row) {
					CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
					System.out.print(cellRef.formatAsString());
					System.out.print(" - ");

					switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							System.out.println(cell.getRichStringCellValue().getString());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(cell)) {
								System.out.println(cell.getDateCellValue());
							} else {
								System.out.println(cell.getNumericCellValue());
							}
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							System.out.println(cell.getBooleanCellValue());
							break;
						case Cell.CELL_TYPE_FORMULA:
							System.out.println(cell.getCellFormula());
							break;
						default:
							System.out.println();
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * writes data to an excel file
	 */
	public void writeExcelFile() {
		
	}

}
