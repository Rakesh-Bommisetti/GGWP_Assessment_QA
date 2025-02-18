package Register;

import Base.Base;
import org.openqa.selenium.By;

public class Register extends Base {
    By registerLink=By.linkText("Register");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By email = By.id("Email");
    By password = By.name("Password");
    By confirmPassword = By.name("ConfirmPassword");
    By registerButton = By.name("register-button");

    public void clickRegisterLink() throws Exception{
        try {
            findElement(registerLink).click();
            //wait(2000);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void details() throws Exception{
        try {
            findElement(firstName).sendKeys("Rakesh");
            wait(1000);
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            findElement(lastName).sendKeys("B");
            wait(1000);
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            findElement(email).sendKeys("rb@g.com");
            wait(1000);
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            findElement(password).sendKeys("123456");
            wait(1000);
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            findElement(confirmPassword).sendKeys("123456");
            wait(1000);
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            findElement(registerButton).click();
            wait(5000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
