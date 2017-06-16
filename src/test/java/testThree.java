import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testThree extends BaseOperations {

    private static By CATALOG_MAIN_TAB_LOCATOR = By.xpath("//span[contains(text(), 'Catalog')]");

    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        loginToAdmin(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void navigateAdminTabs() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(CATALOG_MAIN_TAB_LOCATOR).click();
        Thread.sleep(5000);
    }
}
