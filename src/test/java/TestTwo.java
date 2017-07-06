import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestTwo {

    private static By USERNAME_INPUT_FIELD_LOCATOR = By.cssSelector("[data-type=text]");
    private static By PASSWORD_INPUT_FIELD_LOCATOR = By.cssSelector("[data-type=password]");
    private static By LOGIN_BUTTON_LOCATOR = By.cssSelector("[type='submit']");

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
    public void loginToAdmin() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(USERNAME_INPUT_FIELD_LOCATOR).sendKeys("admin");
        driver.findElement(PASSWORD_INPUT_FIELD_LOCATOR).sendKeys("admin");
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
    }
}
