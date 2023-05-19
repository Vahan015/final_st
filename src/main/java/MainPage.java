import locators.MainPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import javax.lang.model.element.Element;

public class MainPage {
    private WebDriver driver;
    MainPageConstants pageConstants = new MainPageConstants();


    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public SearchPage search(String searchText){
        driver.findElement(pageConstants.search_field).sendKeys(searchText, Keys.ENTER);
        return new SearchPage(driver);
    };
}
