package Data;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataDriven {

    //Create an object of File class to open xlsx file
    public static File file = new File("./data/XYZBank_TestCase.xlsx");

    //Create an object of FileInputStream class to read exel file
    public static FileInputStream inputStream;

    static {
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Creating workbook instance that refers to .xlsx file
    public static XSSFWorkbook wb;

    static {
        try {
            wb = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Creating a Sheet object using the sheet Name
    public static XSSFSheet sheet = wb.getSheet("KeywordDriven");

    public static String customerName = sheet.getRow(2).getCell(6).getStringCellValue();
    public static String accountNumber = sheet.getRow(4).getCell(6).getStringCellValue();
    public static String depositAmount = sheet.getRow(5).getCell(6).getStringCellValue();
    public static String withdrawAmount = sheet.getRow(6).getCell(6).getStringCellValue();

}
