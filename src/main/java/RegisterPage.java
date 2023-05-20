import locators.RegisterPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage {
    private WebDriver driver;

    RegisterPageConstants pageConstants = new RegisterPageConstants();

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void testWrongEmail(){
        List<WebElement> email_second = driver.findElements(pageConstants.email_second_id);
        if(email_second.get(0).isDisplayed()){
            email_second.get(0).sendKeys(pageConstants.email_invalid, Keys.ENTER);
            WebElement error = driver.findElement(pageConstants.email_second_error);
            assert error.isDisplayed();
        };

        List<WebElement> email_first = driver.findElements(pageConstants.email_first_id);
        if(email_first.get(0).isDisplayed()){
            email_first.get(0).sendKeys(pageConstants.email_invalid, Keys.ENTER);
            WebElement errorEmail = driver.findElement(pageConstants.email_first_error);
            WebElement errorPassword = driver.findElement(pageConstants.password_error);
            assert errorEmail.isDisplayed() && errorPassword.isDisplayed();
        };
    }

    public void testCorrectEmail(){
        List<WebElement> email_second = driver.findElements(pageConstants.email_second_id);
        if(email_second.get(0).isDisplayed()){
            email_second.get(0).sendKeys(pageConstants.email_valid, Keys.ENTER);
            List<WebElement> error = driver.findElements(pageConstants.email_second_error);
            assert error.size() == 0;
        };

        List<WebElement> email_first = driver.findElements(pageConstants.email_first_id);
        if(email_first.get(0).isDisplayed()){
            email_first.get(0).sendKeys(pageConstants.email_valid, Keys.ENTER);
            List<WebElement> errorEmail = driver.findElements(pageConstants.email_first_error);
            assert errorEmail.size() == 0;
        };
    }

    public void testNoPassword(){
        List<WebElement> email_second = driver.findElements(pageConstants.email_second_id);
        if(email_second.get(0).isDisplayed()){
            email_second.get(0).sendKeys(pageConstants.email_invalid, Keys.ENTER);
            WebElement error = driver.findElement(pageConstants.email_second_error);
            assert error.isDisplayed();
        };

        List<WebElement> email_first = driver.findElements(pageConstants.email_first_id);
        if(email_first.get(0).isDisplayed()){
            email_first.get(0).sendKeys(pageConstants.email_valid, Keys.ENTER);
            WebElement errorPassword = driver.findElement(pageConstants.password_error);
            assert errorPassword.isDisplayed();
        };
    }

    public void testCorrectPassword(){
        List<WebElement> email_second = driver.findElements(pageConstants.email_second_id);
        if(email_second.get(0).isDisplayed()){
            email_second.get(0).sendKeys(pageConstants.email_invalid, Keys.ENTER);
            WebElement error = driver.findElement(pageConstants.email_second_error);
            assert error.isDisplayed();
        };

        List<WebElement> email_first = driver.findElements(By.id("EmailAddress"));
        if(email_first.get(0).isDisplayed()){
            email_first.get(0).sendKeys(pageConstants.email_valid, Keys.ENTER);
            driver.findElement(pageConstants.password_id).sendKeys(pageConstants.email_invalid);
            List<WebElement> errorPassword = driver.findElements(pageConstants.password_error);
            assert errorPassword.size() == 0;
        };
    }
}
