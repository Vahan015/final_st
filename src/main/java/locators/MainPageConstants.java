package locators;

import org.openqa.selenium.By;

public class MainPageConstants {
    public By search_field = By.id("chrome-search");
    public By heart_icon = By.xpath("//*[@id=\"chrome-sticky-header\"]/div[1]/div/ul/li[2]/a");
    public By register_icon = By.xpath("//*[@id=\"myaccount-dropdown\"]/div/div/div/div[2]/ul/li[1]/a");
}
