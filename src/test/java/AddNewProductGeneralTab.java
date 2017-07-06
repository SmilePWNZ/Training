import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewProductGeneralTab {

    String productCode = new String();
    String productName = new String();
    String productSku = new String();
    String productGtin = new String();
    String productTaric = new String();
    String productQuantity = new String();
    String productWeight = new String();
    String productWidth = new String();
    String productHeight = new String();
    String productLength = new String();
    String measureUnits = new String();
    String dateValidFrom = new String();
    String dateValidTo = new String();
    String productImage = new String();

    public AddNewProductGeneralTab (String productCode, String productName, String productSku, String productGtin, String productTaric,
                                    String productQuantity, String productWeight, String productWidth, String productHeight,
                                    String productLength, String measureUnits, String dateValidFrom,
                                    String dateValidTo, String productImage) {
        this.productCode = productCode;
        this.productName = productName;
        this.productSku = productSku;
        this.productGtin = productGtin;
        this.productTaric = productTaric;
        this.productQuantity = productQuantity;
        this.productWeight = productWeight;
        this.productWidth = productWidth;
        this.productHeight = productHeight;
        this.productLength = productLength;
        this.measureUnits = measureUnits;
        this.dateValidFrom = dateValidFrom;
        this.dateValidTo = dateValidTo;
        this.productImage = productImage;
    }

    private static By CODE_FIELD_TITLE_LOCATOR = By.xpath("//label[contains(text(), 'Code')]");
    private static By GENERAL_TAB_LOCATOR = By.xpath("//a[@href='#tab-general']");
    private static By CODE_FIELD_INPUT_LOCATOR = By.xpath("//*[@name='code']");
    private static By NAME_FIELD_INPUT_LOCATOR = By.xpath("//*[@name='name[en]']");
    private static By SKU_FIELD_INPUT_LOCATOR = By.xpath("//*[@name='sku']");
    private static By GTIN_FIELD_INPUT_LOCATOR = By.xpath("//*[@name='gtin']");
    private static By TARIC_FIELD_INPUT_LOCATOR = By.xpath("//*[@name='taric']");
    private static By QUANTITY_FIELD_INPUT_LOCATOR = By.xpath("//*[@name='quantity']");
    private static By WEIGHT_FIELD_INPUT_LOCATOR = By.xpath("//*[@name='weight']");
    private static By WIDTH_FIELD_INPUT_LOCATOR = By.xpath("//*[@name='dim_x']");
    private static By HEIGHT_FIELD_INPUT_LOCATOR = By.xpath("//*[@name='dim_y']");
    private static By LENGTH_FIELD_INPUT_LOCATOR = By.xpath("//*[@name='dim_z']");
    private static By MEASURE_UNITS_FIELD_INPUT_LOCATOR = By.xpath("//*[@name='dim_class']");
    private static By GENDER_GROUP_UNISEX_CHECKBOX_LOCATOR = By.xpath("//input[contains(@value, '1-3')]");
    private static By DATE_VALID_FROM_INPUT_LOCATOR = By.xpath("//*[@name='date_valid_from']");
    private static By DATE_VALID_TO_INPUT_LOCATOR = By.xpath("//*[@name='date_valid_to']");
    private static By PRODUCT_IMAGE_UPLOAD_LOCATOR = By.xpath("//input[contains(@type,'file')]");

    private void navigateToGeneralTab (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(GENERAL_TAB_LOCATOR).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CODE_FIELD_TITLE_LOCATOR));
    }

    private void addProductCode (WebDriver driver) {
        driver.findElement(CODE_FIELD_INPUT_LOCATOR).sendKeys(productCode);
    }

    private void addProductName (WebDriver driver) {
        driver.findElement(NAME_FIELD_INPUT_LOCATOR).sendKeys(productName);
    }

    private void addProducSku(WebDriver driver) {
        driver.findElement(SKU_FIELD_INPUT_LOCATOR).sendKeys(productSku);
    }

    private void addProductGtin(WebDriver driver) {
        driver.findElement(GTIN_FIELD_INPUT_LOCATOR).sendKeys(productGtin);
    }

    private void addProductTaric(WebDriver driver) {
        driver.findElement(TARIC_FIELD_INPUT_LOCATOR).sendKeys(productTaric);
    }

    private void addProductQuantity(WebDriver driver) {
        driver.findElement(QUANTITY_FIELD_INPUT_LOCATOR).sendKeys(productQuantity);
    }

    private void addProductWeight(WebDriver driver) {
        driver.findElement(WEIGHT_FIELD_INPUT_LOCATOR).sendKeys(productWeight);
    }

    private void addProductWidth(WebDriver driver) {
        driver.findElement(WIDTH_FIELD_INPUT_LOCATOR).sendKeys(productWidth);
    }

    private void addProductHeight(WebDriver driver) {
        driver.findElement(HEIGHT_FIELD_INPUT_LOCATOR).sendKeys(productHeight);
    }

    private void addProductLength(WebDriver driver) {
        driver.findElement(LENGTH_FIELD_INPUT_LOCATOR).sendKeys(productLength);
    }

    private void addMeasureUnits(WebDriver driver) {
        driver.findElement(MEASURE_UNITS_FIELD_INPUT_LOCATOR).sendKeys(measureUnits);
    }

    private void addProductGenderGroup(WebDriver driver) {
        driver.findElement(GENDER_GROUP_UNISEX_CHECKBOX_LOCATOR).click();
    }

    private void addDateValidFrom(WebDriver driver) {
        driver.findElement(DATE_VALID_FROM_INPUT_LOCATOR).sendKeys(dateValidFrom);
    }

    private void addDateValidTo(WebDriver driver) {
        driver.findElement(DATE_VALID_TO_INPUT_LOCATOR).sendKeys(dateValidTo);
    }

    private void addProductImage(WebDriver driver) {
        driver.findElement(PRODUCT_IMAGE_UPLOAD_LOCATOR).sendKeys(productImage);
    }

    public void fillInAllFieldsOnGeneralTab(WebDriver driver) {
        navigateToGeneralTab(driver);
        addProductCode(driver);
        addProductName(driver);
        addProducSku(driver);
        addProductGtin(driver);
        addProductTaric(driver);
        addProductQuantity(driver);
        addProductWeight(driver);
        addProductWidth(driver);
        addProductHeight(driver);
        addProductLength(driver);
        addMeasureUnits(driver);
        addProductGenderGroup(driver);
        addDateValidFrom(driver);
        addDateValidTo(driver);
        addProductImage(driver);
    }


}
