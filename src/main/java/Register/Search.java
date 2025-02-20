package Register;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Search extends Base {

    By searchBar = By.xpath("//input[@value='Search store']");
    By searchButton = By.xpath("//input[@value='Search']");
    By jeansAddtoCart = By.xpath("//div[@class='product-grid']//a[text()='Blue Jeans']//ancestor::div[@class='details']//div[@class='add-info']//div[@class='buttons']//input");
    By notification = By.xpath("//div[@id='bar-notification']/p[@class='content']");
    By laptopAddtoCart = By.xpath("//input[@value='Add to cart']");
    By jewelryAddtoCart = By.xpath("//input[@value='Add to cart']");
    By shoppingCart = By.xpath("//li[@id='topcartlink']//span[text()='Shopping cart']");
    By country = By.xpath("//select[@id='CountryId']");
    By zipCode = By.xpath("//input[@name='ZipPostalCode']");
    By checkBoxTerms = By.xpath("//input[@name='termsofservice']");
    By checkoutButton = By.xpath("//button[@name='checkout']");


    public void search(String product){
        findElement(searchBar).sendKeys(product);
        findElement(searchButton).click();
    }

    public void addToCart(){
        search("jeans");
        findElement(jeansAddtoCart).click();
        Assert.assertEquals(findElement(notification).getText(), "The product has been added to your shopping cart", "Product is not added to shopping cart");
        search("laptop");
        findElement(laptopAddtoCart).click();
        Assert.assertEquals(findElement(notification).getText(), "The product has been added to your shopping cart", "Product is not added to shopping cart");
        search("Black & White Diamond Heart");
        findElement(jewelryAddtoCart).click();
        Assert.assertEquals(findElement(notification).getText(), "The product has been added to your shopping cart", "Product is not added to shopping cart");
    }

    public void shoppingCart(){
        findElement(shoppingCart).click();
        Select objSelect =new Select(findElement(country));
        objSelect.selectByVisibleText("India");
        findElement(zipCode).sendKeys("23456");
        findElement(checkBoxTerms).click();
        findElement(checkoutButton).click();
    }
}