import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public abstract class BaseOperations {

    private static By USERNAME_INPUT_FIELD_LOCATOR = By.cssSelector("[data-type=text]");
    private static By PASSWORD_INPUT_FIELD_LOCATOR = By.cssSelector("[data-type=password]");
    private static By LOGIN_BUTTON_LOCATOR = By.cssSelector("[type=submit]");

    public static void loginToAdmin(WebDriver driver) {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(USERNAME_INPUT_FIELD_LOCATOR).sendKeys("admin");
        driver.findElement(PASSWORD_INPUT_FIELD_LOCATOR).sendKeys("admin");
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
    }

}
