package Register;

import Base.Base;
import org.openqa.selenium.By;

public class Search extends Base {
    By searchBar = By.xpath("//input[@value='Search store']");
    By searchButton = By.xpath("//input[@value='Search']");

    public void search(String product){
        findElement(searchBar).sendKeys(product);
        findElement(searchButton).click();
    }

    public void addToCart(){
        search("jeans");
    }
}
