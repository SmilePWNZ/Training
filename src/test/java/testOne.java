import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testOne {
    private static By SEARCH_BAR_LOCATOR = By.id("lst-ib");
    private static By SEARCH_BUTTON_LOCATOR = By.id("_fZl");


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
    public void openGoogle() throws InterruptedException {
        driver.get("http://google.com");
        driver.findElement(SEARCH_BAR_LOCATOR).sendKeys("Selenium WebDriver");
        driver.findElement(SEARCH_BUTTON_LOCATOR).click();
    }
}
