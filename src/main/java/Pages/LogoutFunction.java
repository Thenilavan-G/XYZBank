package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Functions.Generic.*;

public class LogoutFunction {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public LogoutFunction(WebDriver driver) {
        //Call driver
        this.driver = driver;
    }

    By BackHome = By.xpath("/html/body/div/div/div[1]/button[1]");

    By Logout = By.xpath("/html/body/div/div/div[1]/button[2]");

    public void clickLogout() {
        click(Logout, 5);
    }

    public void backToHome() {
        click(BackHome, 5);
    }

}
