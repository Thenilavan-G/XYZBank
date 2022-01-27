package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Functions.Generic.*;

public class CustomerDetails {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public CustomerDetails(WebDriver driver) {
        //Call driver
        this.driver = driver;
    }

    //CustomerLogin
    By CustomerLoginModule = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");
    //CustomerNameList
    By YourNameDropdown = By.cssSelector("select#userSelect");
    //CustomerLoginButton
    By CustomerLoginButton = By.xpath("/html/body/div/div/div[2]/div/form/button");
    //Mobile Number Text
    By nameText = By.cssSelector("span.fontBig");
    //Password
    By AccNumberDropdown = By.cssSelector("select#accountSelect");
    //SignIn Submit
    By VerifyAccNumber = By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[1]");

    By VerifyAccBalance = By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]");

    By VerifyCurrency = By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[3]");

    By ClickDeposit = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]");

    By ClickWithdraw = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]");

    By ClickTransactions = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]");

    By DepositAmount = By.cssSelector("input.form-control");

    By DepositButton = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");

    By DepositToaster = By.cssSelector("span.error");

    By WithdrawAmount = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");

    By WithdrawButton = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");

    By WithdrawToaster = By.cssSelector("span.error");

    By VerifyCreditDate = By.xpath("/html/body/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[1]");

    By VerifyCreditAmount = By.xpath("/html/body/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[2]");

    By VerifyTransType = By.xpath("/html/body/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td[3]");

    By VerifyDebitDate = By.xpath("/html/body/div/div/div[2]/div/div[2]/table/tbody/tr[2]/td[1]");

    By VerifyDebitAmount = By.xpath("/html/body/div/div/div[2]/div/div[2]/table/tbody/tr[2]/td[2]");

    By VerifyTransType2 = By.xpath("/html/body/div/div/div[2]/div/div[2]/table/tbody/tr[2]/td[3]");

    By BackHome = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");

    By Reset = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");

    public void clickCustomerLoginModule() {
        click(CustomerLoginModule, 5);
    }

    public void selectYourName() {
        dropDown(YourNameDropdown, "Harry Potter");
    }

    public void clickCustomerLogin() {
        click(CustomerLoginButton, 5);
    }

    public void verifyCustomerName() {
        getTextContains(nameText, 5, "Harry Potter");
    }

    public void selectAccountNumber() {
        dropDown(AccNumberDropdown, "1006");
    }

    public void verifyAccountNumber() {
        getTextContains(VerifyAccNumber, 5, "1006");
    }

    public void verifyAccountBalance() {
        getTextContains(VerifyAccBalance, 5, "0");
    }

    public void verifyCurrencyType() {
        getTextContains(VerifyCurrency, 5, "Rupee");
    }

    public void clickDeposit() {
        click(ClickDeposit, 5);
    }

    public void enterDepositAmount() {
        sendKeys(DepositAmount, "1000");
    }

    public void clickDepositButton() {
        click(DepositButton, 5);
    }

    public void verifyDepositToaster() {
        getTextContains(DepositToaster, 5, "Deposit Successful");
    }

    public void verifyDepositedAmount() {
        getTextContains(VerifyAccBalance, 5, "1000");
    }

    public void clickWithdraw() throws InterruptedException {
        Thread.sleep(3000);
        click(ClickWithdraw, 5);
    }

    public void enterWithdrawAmount() throws InterruptedException {
        Thread.sleep(3000);
        sendKeys(WithdrawAmount, "100");
    }

    public void clickWithdrawButton() throws InterruptedException {
        Thread.sleep(3000);
        click(WithdrawButton, 5);
    }

    public void verifyWithdrawToaster() throws InterruptedException {
        Thread.sleep(3000);
        getTextContains(WithdrawToaster, 5, "Transaction successful");
    }

    public void verifyWithdrawnAmount() {
        getTextContains(VerifyAccBalance, 5, "900");
    }

    public void clickTransactions() {
        click(ClickTransactions, 5);
    }

    public void verifyCreditedDate() {
        getTextNotNull(VerifyCreditDate, 5);
    }

    public void verifyCreditedAmount() {
        getTextContains(VerifyCreditAmount, 5, "1000");
    }

    public void verifyCreditType() {
        getTextContains(VerifyTransType, 5, "Credit");
    }

    public void verifyDebitedDate() {
        getTextNotNull(VerifyDebitDate, 5);
    }

    public void verifyDebitedAmount() {
        getTextContains(VerifyDebitAmount, 5, "100");
    }

    public void verifyDebitType() {
        getTextContains(VerifyTransType2, 5, "Debit");
    }

    public void clickReset() {
        click(Reset, 5);
    }

    public void clickBack() {
        click(BackHome, 5);
    }

    public void verifyFinalAccountBalance() {
        getTextContains(VerifyAccBalance, 5, "0");
    }

}
