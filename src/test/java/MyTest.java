import jdk.jfr.Registered;
import org.openqa.selenium.By;
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

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
