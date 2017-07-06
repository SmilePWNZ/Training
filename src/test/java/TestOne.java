import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestOne {
    private static By SEARCH_BAR_GOOGLE_LOCATOR = By.id("lst-ib");
    private static By SEARCH_BUTTON_GOOGLE_LOCATOR = By.id("_fZl");
    private static By SEARCH_BAR_AMAZON_LOCATOR = By.id("twotabsearchtextbox");
    private static By SEARCH_BUTTON_AMAZON_LOCATOR = By.xpath("//input[@type='submit']");


    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void openGoogle() {
        driver.get("http://google.com");
        driver.findElement(SEARCH_BAR_GOOGLE_LOCATOR).sendKeys("Selenium WebDriver");
        driver.findElement(SEARCH_BUTTON_GOOGLE_LOCATOR).click();
    }

    @Test
    public void openAmazon() {
        driver.get("http://amazon.com");
        driver.findElement(SEARCH_BAR_AMAZON_LOCATOR).sendKeys("Alexa");
        driver.findElement(SEARCH_BUTTON_AMAZON_LOCATOR).click();
    }
}
