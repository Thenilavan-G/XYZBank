package Pages;

import Data.DataDriven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Functions.Generic.*;

public class LoginFunction {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public LoginFunction(WebDriver driver) {
        //Call driver
        this.driver = driver;
    }

    //BankName
    By BankName = By.cssSelector("strong.mainHeading");
    //Home
    By HomeButton = By.xpath("//button[@class='btn home']");

    public void verifyBankName() {
        getTextContains(BankName, 5, "XYZ Bank");
    }

    public void clickHome() {
        click(HomeButton, 5);
    }

}
