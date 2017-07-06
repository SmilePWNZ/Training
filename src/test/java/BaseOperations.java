import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BaseOperations {

    private static By USERNAME_INPUT_FIELD_LOCATOR = By.cssSelector("[data-type=text]");
    private static By PASSWORD_INPUT_FIELD_LOCATOR = By.cssSelector("[data-type=password]");
    private static By LOGIN_BUTTON_LOCATOR = By.cssSelector("[type=submit]");
    private static By ADMIN_PAGE_LOGO_LOCATOR = By.cssSelector(".center-block.img-responsive");

    public static void loginToAdmin(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(USERNAME_INPUT_FIELD_LOCATOR).sendKeys("admin");
        driver.findElement(PASSWORD_INPUT_FIELD_LOCATOR).sendKeys("admin");
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADMIN_PAGE_LOGO_LOCATOR));
    }

    public static void openStoreMainPage(WebDriver driver) {
        driver.get("http://localhost/litecart");
    }

}
