import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskFive extends BaseOperations{

    private static By CAMPAIGN_PRODUCTS_TAB_LOCATOR = By.cssSelector(".active>a");
    private static By PRODUCT_CARD_LOCATOR = By.xpath("//div[contains(text(), 'Yellow Duck')]");
    private static By PRODUCT_PAGE_TITLE_LOCATOR = By.xpath("//*[@id='box-product']//*[@class='title']");
    private static By MAIN_PAGE_TITLE_LOCATOR = By.xpath("//*[@id='box-campaign-products']//div[@class='name']");
    private static By MAIN_PAGE_REGULAR_PRICE_LOCATOR = By.xpath("//*[@id='box-campaign-products']//s[contains(@class, 'regular-price')]");
    private static By MAIN_PAGE_CAMPAIGN_PRICE_LOCATOR = By.xpath("//*[@id='box-campaign-products']//strong[contains(@class, 'campaign-price')]");
    private static By PRODUCT_PAGE_REGULAR_PRICE_LOCATOR = By.xpath("//*[@id='box-product']//del[@class='regular-price']");
    private static By PRODUCT_PAGE_CAMPAIGN_PRICE_LOCATOR = By.xpath("//*[@id='box-product']//strong[@class='campaign-price']");

    private String productPageTitle = new String();
    private String mainPageTitle = new String();
    private String mainPageRegularPrice = new String();
    private String mainPageCampaignPrice = new String();
    private String mainPageCampaignPriceColor = new String();
    private String mainPageRegularPriceColor = new String();
    private String productPageRegularPrice = new String();
    private String productPageCampaignPrice = new String();
    private String productPageCampaignPriceColor = new String();
    private String productPageRegularPriceColor = new String();



    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        ChromeDriverManager.getInstance().setup();
        FirefoxDriverManager.getInstance().setup();
        InternetExplorerDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
//        driver = new InternetExplorerDriver();
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
        mainPageRegularPrice = driver.findElement(MAIN_PAGE_REGULAR_PRICE_LOCATOR).getText();
        mainPageCampaignPrice = driver.findElement(MAIN_PAGE_CAMPAIGN_PRICE_LOCATOR).getText();
        mainPageRegularPriceColor = driver.findElement(MAIN_PAGE_REGULAR_PRICE_LOCATOR).getCssValue("color");
        mainPageCampaignPriceColor = driver.findElement(MAIN_PAGE_CAMPAIGN_PRICE_LOCATOR).getCssValue("color");
        driver.findElement(PRODUCT_CARD_LOCATOR).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_PAGE_TITLE_LOCATOR));
        productPageTitle = driver.findElement(PRODUCT_PAGE_TITLE_LOCATOR).getText();
        productPageRegularPrice = driver.findElement(PRODUCT_PAGE_REGULAR_PRICE_LOCATOR).getText();
        productPageCampaignPrice = driver.findElement(PRODUCT_PAGE_CAMPAIGN_PRICE_LOCATOR).getText();
        productPageRegularPriceColor = driver.findElement(PRODUCT_PAGE_REGULAR_PRICE_LOCATOR).getCssValue("color");
        productPageCampaignPriceColor = driver.findElement(PRODUCT_PAGE_CAMPAIGN_PRICE_LOCATOR).getCssValue("color");
        Assert.assertEquals(productPageTitle, mainPageTitle);
        Assert.assertEquals(mainPageRegularPrice, productPageRegularPrice);
        Assert.assertEquals(mainPageCampaignPrice, productPageCampaignPrice);
        Assert.assertEquals(mainPageCampaignPriceColor, productPageCampaignPriceColor);
        Assert.assertEquals(mainPageRegularPriceColor, productPageRegularPriceColor);
    }

}
