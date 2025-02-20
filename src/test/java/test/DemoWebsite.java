package test;

import Base.Base;
import Register.Register;
import Register.Search;
import Register.Checkout;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoWebsite extends Base {

    Register register = new Register();
    Search search = new Search();
    Checkout checkout =new Checkout();

    @BeforeTest
    public void invokeBrowser() {
        register.invokeBrowser();
    }


    @Test (priority = 1)
    public void Register() {
        try {
            register.openURL("websiteURLKey");
            register.clickRegisterLink();
            register.details();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test (priority = 2)
    public void Search(){
        try {
            search.addToCart();
            search.shoppingCart();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test (priority = 3)
    public void Checkout(){
        //checkout.openURL("websiteURLKey");
        //checkout.login();
        //search.shoppingCart();
        checkout.billingAddress();
        checkout.shippingAddress();
        checkout.shippingMethod();
        checkout.paymentMethod();
        checkout.paymentInfo();
        checkout.confirmOrder();
        checkout.verifyOrder();
    }

    @AfterTest
    public void closeBrowser() {
        register.closeBrowser();
    }

}