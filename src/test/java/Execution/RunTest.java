package Execution;

import Base.ProjectBase;
import Data.KeywordDriven;
import org.testng.annotations.Test;

public class RunTest extends ProjectBase {

    @Test
    public static void xyzbank() throws Exception {
        //Here we are passing the Excel path and SheetName as arguments to connect with Excel file
        KeywordDriven.setExcelFile("./data/XYZBank_TestCase.xlsx", "KeywordDriven");
        //This is the loop for reading the values of the column 3 (Action Keyword) row by row
        for (int i = 1; i <= 8; i++) {
            //Storing the value of exel cell in sActionKeyword string variable
            String keys = KeywordDriven.getCellData(i, 8);
            if (keys.equals("Yes")) {
                String key = KeywordDriven.getCellData(i, 7);
                //Comparing the value of Excel cell with all the project keywords
                switch (key) {
                    case "OpenBrowserAndVerifyUI" -> ExecuteTest.OpenBrowserAndVerifyUI();
                    case "ClickCustomerLoginAndSelectName" -> ExecuteTest.ClickCustomerLoginAndSelectName();
                    case "ClickLoginButton" -> ExecuteTest.ClickLoginButton();
                    case "SelectAccountNumber" -> ExecuteTest.SelectAccountNumber();
                    case "AddDepositAmount" -> ExecuteTest.AddDepositAmount();
                    case "WithdrawTheAmount" -> ExecuteTest.WithdrawTheAmount();
                    case "VerifyTransactionsDetails" -> ExecuteTest.VerifyTransactionsDetails();
                    case "ClickLogOutAndCloseBrowser" -> ExecuteTest.ClickLogOutAndCloseBrowser();
                }
            }
        }
    }

}


