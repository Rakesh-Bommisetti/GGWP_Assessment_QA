package Register;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Register extends Base {
    By registerLink=By.linkText("Register");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By email = By.id("Email");
    By password = By.name("Password");
    By confirmPassword = By.name("ConfirmPassword");
    By registerButton = By.name("register-button");
    By continueButton = By.xpath("//input[@value='Continue']");


    public void clickRegisterLink() {
        try {
            findElement(registerLink).click();
            //wait(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void details() {
        try {
            findElement(firstName).sendKeys("N");
            wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            findElement(lastName).sendKeys("B");
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            findElement(email).sendKeys("nbkk@g.com");
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            findElement(password).sendKeys("123456");
            wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            findElement(confirmPassword).sendKeys("123456");
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            findElement(registerButton).click();
        } catch (Exception e){
            e.printStackTrace();
        }


        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
            Assert.assertEquals(findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed", "Page title does not match the expected value");
            findElement(continueButton).click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
