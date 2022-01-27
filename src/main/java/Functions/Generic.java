package Functions;

import Base.ProjectBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.time.Duration;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class Generic extends ProjectBase {

    //Page Load Timeout
    public static void pageLoadTimeOut(int s) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(s));
    }

    //Click
    public static void click(By e, int s) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(s))
                .until(ExpectedConditions.elementToBeClickable(e));
        element.click();
    }

    //IsDisplayed
    public static void isDisplay(By e, int s) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(s))
                .until(driver -> driver.findElement(e));
        assertTrue(element.isDisplayed());
    }

    //SendKeys
    public static void sendKeys(By e, String d) {
        WebElement element = driver.findElement(e);
        element.clear();
        element.sendKeys(d);
    }

    //Enter Key
    public static void enterKey() throws AWTException {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
    }

    //GetTextContains
    public static void getTextContains(By e, int s, String d) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(s))
                .until(ExpectedConditions.elementToBeClickable(e));
        String text = element.getText();
        assertTrue(text.contains(d));
    }

    //GetTextNotNull
    public static void getTextNotNull(By e, int s) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(s))
                .until(ExpectedConditions.presenceOfElementLocated(e));
        String text = element.getText();
        assertNotNull(text);
    }

    //Verify Bold Text
    public static void boldText(By e) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Find element (Electronics) using CSS Selector
        WebElement element = driver.findElement(e);
        String fontWeight = (String) js.executeScript("return getComputedStyle(arguments[0]).getPropertyValue('font-Weight');", element);
        if (fontWeight.trim().equals("bold")) {
            assertEquals(fontWeight.trim(), "bold");
        } else {
            assertNotEquals(fontWeight.trim(), "bold");
        }
    }

    //MouseHover
    public static void mouseHover(By e) {
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(e);
        actions.moveToElement(target).build().perform();
    }

    //Scroll-To-Element
    public static void scrollToElement(By e, int s) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(s))
                .until(ExpectedConditions.elementToBeClickable(e));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    //Scroll-Down
    public static void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //This  will scroll down the page by  1000 pixel vertical
        js.executeScript("window.scrollBy(0,700)");
    }

    //Scroll-Up
    public static void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //This  will scroll down the page by  1000 pixel vertical
        js.executeScript("window.scrollBy(0,-1000)");
    }

    //WindowHandle-Opened Tab
    public static void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    //WindowHandle-Previous Tab
    public static void switchToOldTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    //Close Tab
    public static void closeTab(){
        driver.close();
    }

    //Dropdown
    public static void dropDown(By e, String t) {
        Select dropDown = new Select(driver.findElement(e));
        dropDown.selectByVisibleText(t);
    }

    //Check-Box
    public static void checkBox(By e, int s) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(s))
                .until(ExpectedConditions.elementToBeClickable(e));
        //Check whether the Checkbox is toggled on
        if (element.isSelected()) {
            assertTrue(element.isSelected());
        } else {
            assertFalse(element.isSelected());
            //Check-In Product
            element.click();
        }
    }

    //Take Screenshots
    public static void getScreenshot(String screenshotname) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destFile = "./test-output/FailedTestScreenshots/" + screenshotname + ".jpg";
        FileUtils.copyFile(scrFile, new File(destFile));
        Reporter.log("<a href='" + "./FailedTestScreenshots/" + screenshotname + ".jpg" + "'> <img src='" + destFile + "' height='250' width='500'/> </a>");
    }

    //hyperlink screenshot
    public static void createScreenshotLink(int r, int c, String n) throws Exception {
        File file = new File("./data/XYZBank_TestCase.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheetAt(1);

        XSSFCreationHelper createHelper = wb.getCreationHelper();
        XSSFCellStyle hlink_style = wb.createCellStyle();
        XSSFFont hlink_font = wb.createFont();
        hlink_font.setUnderline(XSSFFont.U_SINGLE);
        hlink_font.setColor(IndexedColors.BLUE.getIndex());
        hlink_style.setFont(hlink_font);

        XSSFCell cell = sheet.getRow(r).createCell((short)c);
        cell.setCellValue("File Link");

        XSSFHyperlink link = createHelper.createHyperlink(XSSFHyperlink.LINK_FILE);
        link.setAddress("C:/Thenilavan/Automation/eclipse-workspace/Amazon/test-output/FailedTestScreenshots/FailedTestScreenshots_"+ n +".jpg");
        cell.setHyperlink(link);
        cell.setCellStyle(hlink_style);

        FileOutputStream out = new FileOutputStream("./data/XYZBank_TestCase.xlsx");
        wb.write(out);
        out.close();
    }

}
