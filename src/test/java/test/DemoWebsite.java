package test;

import Base.Base;
import Register.Register;
import Register.Search;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoWebsite extends Base {

    Register register = new Register();
    Search search = new Search();

    @BeforeTest
    public void invokeBrowser() {
        register.invokeBrowser();
    }

    public void Register() {
        try {
            register.openURL("websiteURLKey");
            register.clickRegisterLink();
            register.details();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSearch(){

    }
    @AfterTest
    public void closeBrowser() {
        register.closeBrowser();
    }

}