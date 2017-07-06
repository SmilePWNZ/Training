import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TaskSix extends BaseOperations {

    private static By CATALOG_TAB_LOCATOR = By.xpath("//span[contains(text(), 'Catalog')]");
    private static By ADD_NEW_PRODUCT_BUTTON_LOCATOR = By.xpath("//a[contains(text(), 'Add New Product')]");
    private static By SAVE_PRODUCT_BUTTON_LOCATOR = By.xpath("//button[contains(@type, 'submit')]");

    private static Date currentDate = new Date();
    private static Random rand = new Random();
    private static String productCode = String.valueOf(rand.nextInt(999));
    private static String productName = ("New Pepe ").concat(currentDate.toString());
    private static String productSku = String.valueOf(rand.nextInt(999));
    private static String productGtin = String.valueOf(rand.nextInt(999));
    private static String productTaric = String.valueOf(rand.nextInt(999));
    private static String productQuantity = "1";
    private static String productWeight = String.valueOf(rand.nextInt(999));
    private static String productWidth = String.valueOf(rand.nextInt(999));
    private static String productHeight = String.valueOf(rand.nextInt(999));
    private static String productLength = String.valueOf(rand.nextInt(999));
    private static String measureUnits = "cm";
    private static String dateValidFrom = "01012017";
    private static String dateValidTo = "01012018";
    private static String productImage = System.getProperty("user.dir").concat("/src/test/java/pepe.png");
    private static String keywords = ("New Product ").concat(currentDate.toString());
    private static String shortDescription = ("Short Description ").concat(currentDate.toString());
    private static String description = ("New Description ").concat(currentDate.toString());
    private static String attributes = ("New Attributes ").concat(currentDate.toString());
    private static String headTitle = ("New Head Title ").concat(currentDate.toString());
    private static String metaDescription = ("New Meta Description ").concat(currentDate.toString());
    private static Integer purchasePrice = 20;


    private WebDriver driver;
    private WebDriverWait wait;
    private AddNewProductGeneralTab generalTab = new AddNewProductGeneralTab(productCode, productName, productSku,
            productGtin, productTaric, productQuantity, productWeight, productWidth, productHeight, productLength,
            measureUnits, dateValidFrom, dateValidTo, productImage);
    private AddNewProductInformationTab informationTab = new AddNewProductInformationTab(keywords, shortDescription, description,
            attributes, headTitle, metaDescription);
    private AddNewProductPricesTab pricesTab = new AddNewProductPricesTab(purchasePrice);

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
        loginToAdmin(driver);
        wait = new WebDriverWait(driver, 5);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void addNewItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CATALOG_TAB_LOCATOR));
        driver.findElement(CATALOG_TAB_LOCATOR).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_NEW_PRODUCT_BUTTON_LOCATOR));
        driver.findElement(ADD_NEW_PRODUCT_BUTTON_LOCATOR).click();
        generalTab.fillInAllFieldsOnGeneralTab(driver);
        informationTab.fillInAllFieldsOnInformationTab(driver);
        pricesTab.fillInAllFieldsOnInformationTab(driver);
        saveNewItem();
        verifyNewItemCreated(productName);
    }

    private void saveNewItem() {
        driver.findElement(SAVE_PRODUCT_BUTTON_LOCATOR).click();
    }

    private void verifyNewItemCreated (String itemName) {
        List<WebElement> catalogTab = driver.findElements(CATALOG_TAB_LOCATOR);
        catalogTab.get(0).click();
        Assert.assertEquals(true, (driver.findElement(By.xpath("//a[contains(text(),'" + itemName +"')]"))).isDisplayed());
    }
}
