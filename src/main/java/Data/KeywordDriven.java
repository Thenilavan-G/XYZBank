package Data;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class KeywordDriven {

    private static XSSFSheet ExcelWSheet;

    //This method is to set the File path and to open the Excel file
    //Pass Excel Path and SheetName as Arguments to this method
    public static void setExcelFile(String Path, String SheetName) throws Exception {
        FileInputStream ExcelFile = new FileInputStream(Path);
        XSSFWorkbook excelWBook = new XSSFWorkbook(ExcelFile);
        ExcelWSheet = excelWBook.getSheet(SheetName);
    }

    //This method is to read the test data from the Excel cell
    //In this we are passing parameters/arguments as Row Num and Col Num
    public static String getCellData(int RowNum, int ColNum) {
        XSSFCell cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
        return cell.getStringCellValue();
    }

}
