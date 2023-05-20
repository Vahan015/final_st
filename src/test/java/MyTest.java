import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.List;


public class MyTest {

    protected static MainPage mainPage;

    public static final String WEBDRIVER = "webdriver.chrome.driver";
    public static final String DRIVER_PATH = "src/main/java/org/example/drivers/chromedriver.exe";
    public static final String baseURL = "https://asos.com/";

    WebDriver driver;

    @BeforeClass
    public WebDriver setUp(){
        System.setProperty(WEBDRIVER,DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(baseURL);
        mainPage = new MainPage(driver);
        return driver;
    }

    @BeforeMethod
    public void refresh(){
        driver.get(baseURL);
    }

    @Test
    public void searchFunctionalityTest(){
        SearchPage SearchPage = mainPage.search("air");
        List<WebElement> search_results = SearchPage.getResults();
        for (WebElement element : search_results) {
            assert(element.getText().toLowerCase().contains("air"));
        }
    }

    @Test
    public void checkSavedItems(){
        SearchPage SearchPage = mainPage.search("bag");
        SearchPage.saveProduct();
        SavedPage SavedPage = mainPage.goToSavedItems();
        List<WebElement> results = SavedPage.getSavedItems();
        for (WebElement element : results) {
            assert(element.getText().toLowerCase().contains("bag"));
        }
    }

    @Test
    public void checkDeleteSavedItems() throws InterruptedException {
        SearchPage SearchPage = mainPage.search("bag");
        SearchPage.saveProduct();
        SavedPage SavedPage = mainPage.goToSavedItems();
        Thread.sleep(5000);
        SavedPage.deleteItem();
        Thread.sleep(5000);
        List<WebElement> results = SavedPage.getSavedItems();
        assert results.size() == 0;
    }

    @Test
    public void checkAddToCard(){
        SearchPage SearchPage = mainPage.search("bag");
        ProductPage ProductPage = SearchPage.goToProduct();
        ProductPage.addToCart();
        //As the website blocks from further process of adding to cart, we check if the error message appears to confirm that we pressed the 'add bag' button
        ProductPage.checkAdded();
    }

    //The website has a strange issues that redirects to two different sign up pages randomly.
    //Therefore, it may be required for you to run some register tests several times in order to get to
    //our targeted web page.
    @Test
    public void checkRegisterWrongEmail() throws InterruptedException {
        // Please hover around the 'account' logo for drop down to appear
        Thread.sleep(10000);
        RegisterPage RegisterPage = mainPage.goToRegisterPage();
        RegisterPage.testWrongEmail();
    }

    @Test
    public void checkRegisterCorrectEmail() throws InterruptedException {
        // Please hover around the 'account' logo for drop down to appear
        Thread.sleep(10000);
        RegisterPage RegisterPage = mainPage.goToRegisterPage();
        RegisterPage.testCorrectEmail();
    }

    @Test
    public void checkRegisterNoPassword() throws InterruptedException {
        // Please hover around the 'account' logo for drop down to appear
        Thread.sleep(10000);
        RegisterPage RegisterPage = mainPage.goToRegisterPage();
        RegisterPage.testNoPassword();
    }

    @Test
    public void checkRegisterCorrectPassword() throws InterruptedException {
        // Please hover around the 'account' logo for drop down to appear
        Thread.sleep(10000);
        RegisterPage RegisterPage = mainPage.goToRegisterPage();
        RegisterPage.testCorrectPassword();
    }



    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
