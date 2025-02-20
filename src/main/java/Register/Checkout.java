package Register;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Checkout extends Base {
    //Billing Address locators
    By countryBilling = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    By cityBilling = By.xpath("//input[@id='BillingNewAddress_City']");
    By address1Textbox = By.xpath("//input[@id='BillingNewAddress_Address1']");
    By zipCode = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    By phoneNumber = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
    By continueButton = By.xpath("//div[@id='billing-buttons-container']/input[@value='Continue']");

    //Shipping Address locators
    By continueButtonShipping = By.xpath("//li[@class='tab-section allow active']//div[@id='shipping-buttons-container']/input[@value='Continue']");

    //Shipping Method locators
    By continueButtonShippingMethod = By.xpath("//div[@id='shipping-method-buttons-container']/input[@value='Continue']");
    By continueButtonPaymentMethod = By.xpath("//div[@id='payment-method-buttons-container']/input[@value='Continue']");
    By continueButtonPaymentInfo = By.xpath("//div[@id='payment-info-buttons-container']/input[@value='Continue']");
    By cofirmButtonConfirmOrder = By.xpath("//div[@id='confirm-order-buttons-container']/input[@value='Confirm']");

    By email = By.id("Email");
    By password = By.name("Password");
    public void login(){
        findElement(By.xpath("//div[@class='header-links']//a[@class='ico-login']")).click();
        try {
            findElement(email).sendKeys("nbk@g.com");
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            findElement(password).sendKeys("123456");
            //wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        } catch (Exception e){
            e.printStackTrace();
        }
        findElement(By.xpath("//input[@value='Log in']")).click();
    }

    public void billingAddress() {
        try {
            Select objSelect = new Select(findElement(countryBilling));
            objSelect.selectByVisibleText("India");
            findElement(cityBilling).sendKeys("Hyd");
            findElement(address1Textbox).sendKeys("Mindspace");
            findElement(zipCode).sendKeys("123456");
            findElement(phoneNumber).sendKeys("9876543210");
            findElement(continueButton).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shippingAddress() {
        try {
            //wait.until(ExpectedConditions.invisibilityOfElementLocated(continueButtonShipping));
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            findElement(continueButtonShipping).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shippingMethod() {
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            findElement(continueButtonShippingMethod).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void paymentMethod() {
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            findElement(continueButtonPaymentMethod).click();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void paymentInfo() {
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            findElement(continueButtonPaymentInfo).click();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void confirmOrder(){
        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            findElement(cofirmButtonConfirmOrder).click();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void verifyOrder(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String str="Your order has been successfully processed!";
        String st=findElement(By.xpath("//div[@class='title']")).getText();
        System.out.println(st.equals(str));
    }

}