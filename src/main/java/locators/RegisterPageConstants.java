package locators;

import org.openqa.selenium.By;

public class RegisterPageConstants {
    public By email_second_id = By.id("checkEmailAddress");
    public By email_second_error = By.id("checkEmailAddress-error");
    public By email_first_id = By.id("EmailAddress");
    public By email_first_error = By.id("EmailAddress-error");
    public By password_id = By.id("Password");
    public By password_error = By.id("Password-error");
    public String email_invalid = "testtest";
    public String email_valid = "test@test.com";
}
