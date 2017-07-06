import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TaskFour extends BaseOperations {

    private static By NAVIGATION_TAB_LOCATOR = By.cssSelector("[id=app-]");
    private static By NAVIGATION_SUB_TAB_LOCATOR = By.cssSelector("[id^=doc]");

    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        FirefoxDriverManager.getInstance().setup();
//        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        loginToAdmin(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private List<String> getNavigationTabsNames (By locator) {
        List <WebElement> navigationTabs = driver.findElements(locator);
        List <String> tabNames = new ArrayList<>();
        for (WebElement element : navigationTabs) {
            String tabName = element.getText();
            tabNames.add(tabName);
        }
        return tabNames;
    }

    private By getTabByElement (String tabName) {
        return (By.xpath("//span[contains(text(),'" + tabName + "')]"));
    }

    private void verifyAdminTabs (List<String> tabNames) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        for (String name : tabNames) {
            By tabElement = getTabByElement(name);
            wait.until(ExpectedConditions.visibilityOfElementLocated(tabElement));
            driver.findElement(tabElement).click();
            driver.findElement(By.cssSelector("h1"));
            List<String> subTabNames = getNavigationTabsNames(NAVIGATION_SUB_TAB_LOCATOR);
            for (String subName : subTabNames) {
                By subTabElement = getTabByElement(subName);
                wait.until(ExpectedConditions.visibilityOfElementLocated(subTabElement));
                driver.findElement((subTabElement)).click();
                driver.findElement(By.cssSelector("h1"));
            }
        }
    }


    @Test
    public void navigateAdminTabs() throws InterruptedException {
        List<String> foundTabs = getNavigationTabsNames(NAVIGATION_TAB_LOCATOR);
        verifyAdminTabs(foundTabs);
        }
}
