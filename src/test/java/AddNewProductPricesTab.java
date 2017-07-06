import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewProductPricesTab {

    int purchasePrice;
    int priceIncludingTaxUsd = purchasePrice + (purchasePrice * 1/5);
    int regularPriceEur = purchasePrice + (purchasePrice * 1/10);
    int priceIncludingTaxEur = regularPriceEur + (regularPriceEur * 1/5);

    public AddNewProductPricesTab(int purchasePrice) {

        this.purchasePrice = purchasePrice;
    }

    private static By PRICES_TAB_LOCATOR = By.xpath("//a[@href='#tab-prices']");
    private static By PURCHASE_PRICE_INPUT_LOCATOR = By.xpath("//select[contains(@name,'purchase_price')]");
    private static By PURCHASE_PRICE_CURRENCY_SELECTOR_LOCATOR = By.xpath("//select[contains(@name,'purchase_price_currency_code')]");
    private static By PURCHASE_PRICE_USD_OPTION_LOCATOR = By.xpath("//option[contains(@value,'USD')]");
    private static By TAX_CLASS_SELECTOR_LOCATOR = By.xpath("//select[contains(@name,'tax_class_id')]");
    private static By REGULAR_PRICE_USD_INPUT_LOCATOR = By.xpath("//input[contains(@name,'prices[USD]')]");
    private static By GROSS_PRICE_USD_INPUT_LOCATOR = By.xpath("//input[contains(@name,'gross_prices[USD]')]");
    private static By REGULAR_PRICE_EUR_INPUT_LOCATOR = By.xpath("//input[contains(@name,'prices[EUR]')]");
    private static By GROSS_PRICE_EUR_INPUT_LOCATOR = By.xpath("//input[contains(@name,'gross_prices[EUR]')]");

    private void navigateToPricesTab(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(PRICES_TAB_LOCATOR).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TAX_CLASS_SELECTOR_LOCATOR));
    }

    private void addPurchasePrice(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(PURCHASE_PRICE_INPUT_LOCATOR).sendKeys(String.valueOf(purchasePrice));
        driver.findElement(PURCHASE_PRICE_CURRENCY_SELECTOR_LOCATOR).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(PURCHASE_PRICE_USD_OPTION_LOCATOR));
        driver.findElement(PURCHASE_PRICE_USD_OPTION_LOCATOR).click();
    }

    private void addRegularPriceUsd(WebDriver driver) {
        driver.findElement(REGULAR_PRICE_USD_INPUT_LOCATOR).sendKeys(String.valueOf(purchasePrice));
    }

    private void addPriceIncludingTaxUsd(WebDriver driver) {
        driver.findElement(GROSS_PRICE_USD_INPUT_LOCATOR).sendKeys(String.valueOf(priceIncludingTaxUsd));
    }

    private void addRegularPriceEur(WebDriver driver) {
        driver.findElement(REGULAR_PRICE_EUR_INPUT_LOCATOR).sendKeys(String.valueOf(regularPriceEur));
    }

    private void addPriceIncludingTaxEur(WebDriver driver) {
        driver.findElement(GROSS_PRICE_EUR_INPUT_LOCATOR).sendKeys(String.valueOf(priceIncludingTaxEur));
    }


    public void fillInAllFieldsOnInformationTab(WebDriver driver) {
        navigateToPricesTab(driver);
        addPurchasePrice(driver);
        addRegularPriceUsd(driver);
        addPriceIncludingTaxUsd(driver);
        addRegularPriceEur(driver);
        addPriceIncludingTaxEur(driver);
    }


}
