import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class taskFive extends BaseOperations{

    private static By CAMPAIGN_PRODUCTS_TAB_LOCATOR = By.cssSelector(".active>a");
    private static By PRODUCT_CARD_LOCATOR = By.xpath("//div[contains(text(), 'Yellow Duck')]");
    private static By PRODUCT_PAGE_TITLE_LOCATOR = By.xpath("//*[@id='box-product']/../..//*[@class='title']");
    private static By MAIN_PAGE_TITLE_LOCATOR = By.xpath(".//*[@id='box-campaign-products']//div[@class='name']");
    private static By VIEW_FULL_PAGE_LINK_LOCATOR = By.id("view-full-page");

    private String productPageTitle = new String();
    private String mainPageTitle = new String();
    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        openStoreMainPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifyProductPage () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(CAMPAIGN_PRODUCTS_TAB_LOCATOR).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MAIN_PAGE_TITLE_LOCATOR));
        mainPageTitle = driver.findElement(MAIN_PAGE_TITLE_LOCATOR).getText();
        driver.findElement(PRODUCT_CARD_LOCATOR).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_PAGE_TITLE_LOCATOR));
        productPageTitle = driver.findElement(PRODUCT_PAGE_TITLE_LOCATOR).getText();
        Assert.assertEquals(productPageTitle, mainPageTitle);
    }

}
