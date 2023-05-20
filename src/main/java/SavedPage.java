import locators.SavedPageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SavedPage {
    private WebDriver driver;

    SavedPageConstants pageConstants = new SavedPageConstants();

    public SavedPage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getSavedItems(){
        return driver.findElements(pageConstants.saved_name);
    }

    public void deleteItem(){
        driver.findElement(pageConstants.delete_icon).click();
    }


}
