package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

public class ProjectBase {

    public static WebDriver driver;
    //Set Project URL
    static String baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/";

    @BeforeSuite
    public void deleteDir() {
        //If e-mailable-report Available
        try {
            String filePath = "./target/surefire-reports/emailable-report.html";
            File file = new File(filePath);
            FileUtils.forceDelete(file);
        } catch (IOException e) {
            //...
        }
        //If testNG report Available
        try {
            String filePath = "./TestNGReport.pdf";
            File file = new File(filePath);
            FileUtils.forceDelete(file);
        } catch (IOException e) {
            //...
        }
        //If test-output report Available
        try {
            String filePath = "./test-output";
            File file = new File(filePath);
            FileUtils.forceDelete(file);
        } catch (IOException e) {
            //...
        }
    }

    //@BeforeTest
    public static void OpenChrome() {
        //Set up the chrome driver
        WebDriverManager.chromedriver().setup();
        //Using chrome options
        ChromeOptions options = new ChromeOptions();
        //Set page load strategy as Normal
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //Disable the browser notifications
        options.addArguments("--disable-notifications");
        //add the headless argument
        //options.addArguments("headless");
        //Initialize the driver
        driver = new ChromeDriver(options);
        //Maximize Window
        driver.manage().window().maximize();
        //Navigation
        driver.get(baseUrl);
        //Implicitly Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //Clear cell values
    @BeforeClass
    public void clearResult() {
        try {
            //Create an object of File class to open xlsx file
            File file = new File("./data/XYZBank_TestCase.xlsx");
            //Create an object of FileInputStream class to read exel file
            FileInputStream inputStream = new FileInputStream(file);
            //Creating workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            //Creating a Sheet object using the sheet Name
            XSSFSheet sheet = wb.getSheetAt(1);

            for (int i = 1; i <= 12; i++) {
                //Delete cell values
                sheet.getRow(i).createCell(10).setCellValue("");
                sheet.getRow(i).createCell(11).setCellValue("");
                sheet.getRow(i).createCell(12).setCellValue("");
            }

            //write the data in exel using output stream
            FileOutputStream outputStream = new FileOutputStream("./data/XYZBank_TestCase.xlsx");
            wb.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    //Set Pass or Fail Status
    @AfterMethod
    public void writeResult(ITestResult result) {
        try {
            File file = new File("./data/XYZBank_TestCase.xlsx");
            FileInputStream inputStream = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheetAt(1);

            if(Objects.equals(result.getName(), "OpenBrowserAndVerifyUI")) {
                int r = 1; int c = 11;
                    if (result.getStatus() == ITestResult.SUCCESS) {
                        sheet.getRow(r).createCell(10).setCellValue("Result as Expected");
                        sheet.getRow(r).createCell(c).setCellValue("PASS");
                    } else if (result.getStatus() == ITestResult.FAILURE) {
                        sheet.getRow(r).createCell(10).setCellValue("Result as not Expected");
                        sheet.getRow(r).createCell(c).setCellValue("FAIL");
                    } else if (result.getStatus() == ITestResult.SKIP) {
                        sheet.getRow(r).createCell(c).setCellValue("SKIP");
                    }
                }

            if(Objects.equals(result.getName(), "ClickCustomerLoginAndSelectName")) {
                int r = 2; int c = 11;
                if (result.getStatus() == ITestResult.SUCCESS) {
                    sheet.getRow(r).createCell(10).setCellValue("Result as Expected");
                    sheet.getRow(r).createCell(c).setCellValue("PASS");
                } else if (result.getStatus() == ITestResult.FAILURE) {
                    sheet.getRow(r).createCell(10).setCellValue("Result as not Expected");
                    sheet.getRow(r).createCell(c).setCellValue("FAIL");
                } else if (result.getStatus() == ITestResult.SKIP) {
                    sheet.getRow(r).createCell(c).setCellValue("SKIP");
                }
            }

            if(Objects.equals(result.getName(), "ClickLoginButton")) {
                int r = 3; int c = 11;
                if (result.getStatus() == ITestResult.SUCCESS) {
                    sheet.getRow(r).createCell(10).setCellValue("Result as Expected");
                    sheet.getRow(r).createCell(c).setCellValue("PASS");
                } else if (result.getStatus() == ITestResult.FAILURE) {
                    sheet.getRow(r).createCell(10).setCellValue("Result as not Expected");
                    sheet.getRow(r).createCell(c).setCellValue("FAIL");
                } else if (result.getStatus() == ITestResult.SKIP) {
                    sheet.getRow(r).createCell(c).setCellValue("SKIP");
                }
            }

            if(Objects.equals(result.getName(), "SelectAccountNumber")) {
                int r = 4; int c = 11;
                if (result.getStatus() == ITestResult.SUCCESS) {
                    sheet.getRow(r).createCell(10).setCellValue("Result as Expected");
                    sheet.getRow(r).createCell(c).setCellValue("PASS");
                } else if (result.getStatus() == ITestResult.FAILURE) {
                    sheet.getRow(r).createCell(10).setCellValue("Result as not Expected");
                    sheet.getRow(r).createCell(c).setCellValue("FAIL");
                } else if (result.getStatus() == ITestResult.SKIP) {
                    sheet.getRow(r).createCell(c).setCellValue("SKIP");
                }
            }

            if(Objects.equals(result.getName(), "AddDepositAmount")) {
                int r = 5; int c = 11;
                if (result.getStatus() == ITestResult.SUCCESS) {
                    sheet.getRow(r).createCell(10).setCellValue("Result as Expected");
                    sheet.getRow(r).createCell(c).setCellValue("PASS");
                } else if (result.getStatus() == ITestResult.FAILURE) {
                    sheet.getRow(r).createCell(10).setCellValue("Result as not Expected");
                    sheet.getRow(r).createCell(c).setCellValue("FAIL");
                } else if (result.getStatus() == ITestResult.SKIP) {
                    sheet.getRow(r).createCell(c).setCellValue("SKIP");
                }
            }

            if(Objects.equals(result.getName(), "WithdrawTheAmount")) {
                int r = 6; int c = 11;
                if (result.getStatus() == ITestResult.SUCCESS) {
                    sheet.getRow(r).createCell(10).setCellValue("Result as Expected");
                    sheet.getRow(r).createCell(c).setCellValue("PASS");
                } else if (result.getStatus() == ITestResult.FAILURE) {
                    sheet.getRow(r).createCell(10).setCellValue("Result as not Expected");
                    sheet.getRow(r).createCell(c).setCellValue("FAIL");
                } else if (result.getStatus() == ITestResult.SKIP) {
                    sheet.getRow(r).createCell(c).setCellValue("SKIP");
                }
            }

            if(Objects.equals(result.getName(), "VerifyTransactionsDetails")) {
                int r = 7; int c = 11;
                if (result.getStatus() == ITestResult.SUCCESS) {
                    sheet.getRow(r).createCell(10).setCellValue("Result as Expected");
                    sheet.getRow(r).createCell(c).setCellValue("PASS");
                } else if (result.getStatus() == ITestResult.FAILURE) {
                    sheet.getRow(r).createCell(10).setCellValue("Result as not Expected");
                    sheet.getRow(r).createCell(c).setCellValue("FAIL");
                } else if (result.getStatus() == ITestResult.SKIP) {
                    sheet.getRow(r).createCell(c).setCellValue("SKIP");
                }
            }

            if(Objects.equals(result.getName(), "ClickLogOutAndCloseBrowser")) {
                int r = 8; int c = 11;
                if (result.getStatus() == ITestResult.SUCCESS) {
                    sheet.getRow(r).createCell(10).setCellValue("Result as Expected");
                    sheet.getRow(r).createCell(c).setCellValue("PASS");
                } else if (result.getStatus() == ITestResult.FAILURE) {
                    sheet.getRow(r).createCell(10).setCellValue("Result as not Expected");
                    sheet.getRow(r).createCell(c).setCellValue("FAIL");
                } else if (result.getStatus() == ITestResult.SKIP) {
                    sheet.getRow(r).createCell(c).setCellValue("SKIP");
                }
            }

            FileOutputStream outputStream = new FileOutputStream("./data/XYZBank_TestCase.xlsx");
            wb.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @AfterClass
    public void setResult() {
        try {
            File file = new File("./data/XYZBank_TestCase.xlsx");
            FileInputStream inputStream = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheetAt(1);

            for (int i = 1; i <= 8; i++) {
                int c = 11;
                //Get Cell Value
                String d = sheet.getRow(i).getCell(c).getStringCellValue();
                if(d.equals("null") || d.isBlank() || d.isEmpty()) {
                    //Set Cell Value
                    sheet.getRow(i).createCell(c).setCellValue("Not Executed");
                } else if(d.equals("FAIL")) {
                    //Get Font Color
                    CellStyle style = wb.createCellStyle();
                    Font font = wb.createFont();
                    font.setColor(IndexedColors.RED.getIndex());
                    style.setFont(font);
                    //Set Font Color
                    Row row = sheet.getRow(i);
                    Cell cell1 = row.getCell(c);
                    cell1.setCellValue("FAIL");
                    cell1.setCellStyle(style);
                } else if(d.equals("PASS")) {
                    //Get Font Color
                    CellStyle style = wb.createCellStyle();
                    Font font = wb.createFont();
                    font.setColor(IndexedColors.GREEN.getIndex());
                    style.setFont(font);
                    //Set Font Color
                    Row row = sheet.getRow(i);
                    Cell cell1 = row.getCell(c);
                    cell1.setCellValue("PASS");
                    cell1.setCellStyle(style);
                } else if(d.equals("SKIP")) {
                    //Get Font Color
                    CellStyle style = wb.createCellStyle();
                    Font font = wb.createFont();
                    font.setColor(IndexedColors.ORANGE.getIndex());
                    style.setFont(font);
                    //Set Font Color
                    Row row = sheet.getRow(i);
                    Cell cell1 = row.getCell(c);
                    cell1.setCellValue("PASS");
                    cell1.setCellStyle(style);
                }
            }

            FileOutputStream outputStream = new FileOutputStream("./data/XYZBank_TestCase.xlsx");
            wb.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @AfterSuite
    public void closeChrome() {
        //Close the Browser
        driver.quit();
    }

}
