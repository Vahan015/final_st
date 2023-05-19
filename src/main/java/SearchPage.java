import locators.SearchPageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    private WebDriver driver;

    SearchPageConstants pageConstants = new SearchPageConstants();


    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getResults(){
        return driver.findElements(pageConstants.item_name);
    }
}
