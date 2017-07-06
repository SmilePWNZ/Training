import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewProductInformationTab {

    String keywords = new String();
    String shortDescription = new String();
    String description = new String();
    String attributes = new String();
    String headTitle = new String();
    String metaDescription = new String();


    public AddNewProductInformationTab(String keywords, String shortDescription, String description, String attributes, String headTitle,
                                       String metaDescription) {
        this.keywords = keywords;
        this.shortDescription = shortDescription;
        this.description = description;
        this.attributes = attributes;
        this.headTitle = headTitle;
        this.metaDescription = metaDescription;
    }

    private static By INFORMATION_TAB_LOCATOR = By.xpath("//a[@href='#tab-information']");
    private static By MANUFACTURER_SELECTOR_LOCATOR = By.xpath("//select[contains(@name,'manufacturer_id')]");
    private static By ACME_MANUFACTURER_OPTION_LOCATOR = By.xpath("//option[contains(text(),'ACME Corp.')]");
    private static By SUPPLIER_SELECTOR_LOCATOR = By.xpath("//select[contains(@name,'supplier_id')]");
    private static By KEYWORDS_INPUT_LOCATOR = By.xpath("//input[contains(@name,'keywords')]");
    private static By SHORT_DESCRIPTION_INPUT_LOCATOR = By.xpath("//input[contains(@name,'short_description[en]')]");
    private static By DESCRIPTION_AREA_INPUT_LOCATOR = By.xpath("//div[contains(@dir,'ltr')]");
    private static By ATTRIBUTES_AREA_INPUT_LOCATOR = By.xpath("//textarea[contains(@name,'attributes[en]')]");
    private static By HEAD_TITLE_INPUT_LOCATOR = By.xpath("//input[contains(@name,'head_title[en]')]");
    private static By META_DESCRIPTION_INPUT_LOCATOR = By.xpath("//input[contains(@name,'meta_description[en]')]");

    private void navigateToInformationTab(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(INFORMATION_TAB_LOCATOR).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUPPLIER_SELECTOR_LOCATOR));
    }

    private void selectManufacturer (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(MANUFACTURER_SELECTOR_LOCATOR).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACME_MANUFACTURER_OPTION_LOCATOR));
        driver.findElement(ACME_MANUFACTURER_OPTION_LOCATOR).click();
    }

    private void addKeyWords(WebDriver driver) {
        driver.findElement(KEYWORDS_INPUT_LOCATOR).sendKeys(keywords);
    }

    private void addShortDescription(WebDriver driver) {
        driver.findElement(SHORT_DESCRIPTION_INPUT_LOCATOR).sendKeys(shortDescription);
    }

    private void addDescription(WebDriver driver) {
        driver.findElement(DESCRIPTION_AREA_INPUT_LOCATOR).sendKeys(description);
    }

    private void addAttributes(WebDriver driver) {
        driver.findElement(ATTRIBUTES_AREA_INPUT_LOCATOR).sendKeys(attributes);
    }

    private void addHeadTitle(WebDriver driver) {
        driver.findElement(HEAD_TITLE_INPUT_LOCATOR).sendKeys(headTitle);
    }

    private void addMetaDescription(WebDriver driver) {
        driver.findElement(META_DESCRIPTION_INPUT_LOCATOR).sendKeys(metaDescription);
    }

    public void fillInAllFieldsOnInformationTab(WebDriver driver) {
        navigateToInformationTab(driver);
        selectManufacturer(driver);
        addKeyWords(driver);
        addShortDescription(driver);
        addDescription(driver);
        addAttributes(driver);
        addHeadTitle(driver);
        addMetaDescription(driver);
    }

}
