package test;

import Base.Base;
import Register.Register;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoWebsite extends Base {

    Register register = new Register();

    @BeforeTest
    public void invokeBrowser() {
        register.invokeBrowser();
    }

    @Test()
    public void Register() {
        try {
            register.openURL("websiteURLKey");
            register.clickRegisterLink();
            register.details();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void closeBrowser() {
        register.closeBrowser();
    }

}