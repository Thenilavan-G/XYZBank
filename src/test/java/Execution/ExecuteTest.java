package Execution;

import Base.ProjectBase;
import Data.DataDriven;
import Pages.CustomerDetails;
import Pages.LoginFunction;
import Pages.LogoutFunction;
import TestNG.RetryAnalyzer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNG.Listener.class)
public class ExecuteTest extends ProjectBase {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public static void OpenBrowserAndVerifyUI() {
        LoginFunction logInObj = new LoginFunction(driver);

        ProjectBase.OpenChrome();
        logInObj.verifyBankName();
        logInObj.clickHome();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public static void ClickCustomerLoginAndSelectName() {
        CustomerDetails customerLogin = new CustomerDetails(driver);

        customerLogin.clickCustomerLoginModule();
        customerLogin.selectYourName();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public static void ClickLoginButton() {
        CustomerDetails customerLogin = new CustomerDetails(driver);

        customerLogin.clickCustomerLogin();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public static void SelectAccountNumber() {
        CustomerDetails customerLogin = new CustomerDetails(driver);

        customerLogin.verifyCustomerName();
        customerLogin.selectAccountNumber();
        customerLogin.verifyAccountNumber();
        customerLogin.verifyAccountBalance();
        customerLogin.verifyCurrencyType();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public static void AddDepositAmount() {
        CustomerDetails customerLogin = new CustomerDetails(driver);

        customerLogin.clickDeposit();
        customerLogin.enterDepositAmount();
        customerLogin.clickDepositButton();
        customerLogin.verifyDepositToaster();
        customerLogin.verifyDepositedAmount();
    }

    //@Test(retryAnalyzer = RetryAnalyzer.class)
    @Test
    public static void WithdrawTheAmount() throws InterruptedException {
        CustomerDetails customerLogin = new CustomerDetails(driver);

        customerLogin.clickWithdraw();
        customerLogin.enterWithdrawAmount();
        customerLogin.clickWithdrawButton();
        customerLogin.verifyWithdrawToaster();
        customerLogin.verifyWithdrawnAmount();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public static void VerifyTransactionsDetails() {
        CustomerDetails customerLogin = new CustomerDetails(driver);

        customerLogin.clickTransactions();
        customerLogin.verifyCreditedDate();
        customerLogin.verifyCreditedAmount();
        customerLogin.verifyCreditType();
        customerLogin.verifyDebitedDate();
        customerLogin.verifyDebitedAmount();
        customerLogin.verifyDebitType();
        customerLogin.clickReset();
        customerLogin.clickBack();
        customerLogin.verifyFinalAccountBalance();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public static void ClickLogOutAndCloseBrowser() {
        LogoutFunction logOutObj = new LogoutFunction(driver);

        logOutObj.clickLogout();
        logOutObj.backToHome();
    }

}
