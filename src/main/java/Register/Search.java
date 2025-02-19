package Register;

import Base.Base;
import org.openqa.selenium.By;

public class Search extends Base {

    String notificationText;
    By searchBar = By.xpath("//input[@value='Search store']");
    By searchButton = By.xpath("//input[@value='Search']");
    By jeansAddtoCart = By.xpath("//div[@class='product-grid']//a[text()='Blue Jeans']//ancestor::div[@class='details']//div[@class='add-info']//div[@class='buttons']//input");
    By notification = By.xpath("//div[@id='bar-notification']/p[@class='content']");
    By laptopAddtoCart = By.xpath("//input[@value='Add to cart']");
    By jewelryAddtoCart = By.xpath("//input[@value='Add to cart']");
    By shoppingCart = By.xpath("//li[@id='topcartlink']//span[text()='Shopping cart']");

    public void search(String product){
        findElement(searchBar).sendKeys(product);
        findElement(searchButton).click();
    }

    public void addToCart(){
        search("jeans");
        findElement(jeansAddtoCart).click();
        notificationText = findElement(notification).getText();
        System.out.println(notificationText.equals("The product has been added to your shopping cart"));
        search("laptop");
        findElement(laptopAddtoCart).click();
        System.out.println(notificationText.equals("The product has been added to your "));
        search("Black & White Diamond Heart");
        findElement(jewelryAddtoCart).click();
    }

    public void shoppingCart(){
        findElement(shoppingCart).click();
    }
}
