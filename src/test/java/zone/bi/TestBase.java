package zone.bi;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase{

    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    WebDriver driver;
    Actions action;

    @BeforeEach
    void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sav\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://todomvc.com/examples/react/");
    }

    @AfterEach
    public void close() {
        if (driver != null)
            driver.close();
    }
    @Step(value = "add ToDO in field")
    public void addToDoInField(String value) {
        driver.findElement(By.className("new-todo")).sendKeys(value, Keys.ENTER);
    }
    @Step(value = "Edit current name task")
    public void editNameTask(String text) {
        action.sendKeys(text).perform();
        action.sendKeys(Keys.ENTER).perform();
    }
    @Step(value = "Get name created element")
    public String getNameWebElement(String selector, String path) {
        List<WebElement> name = null;
        if (selector.equals("xpath")) {
            name = driver.findElements(By.xpath(path));
        }
        if (selector.equals("cssSelector")) {
            name = driver.findElements(By.cssSelector(path));
        }
        return name.get(0).getAttribute("textContent");
    }
    @Step(value = "Get created WebElement")
    public WebElement getWebElement(String selector, String path) {
        List<WebElement> name = null;
        if (selector.equals("xpath")) {
            name = driver.findElements(By.xpath(path));
        }
        if (selector.equals("cssSelector")) {
            name = driver.findElements(By.cssSelector(path));
        }
        return name.get(0);
    }
    @Step(value = "Get list size")
    public int getListWebElementSize(String selector, String path) {
        List<WebElement> name = null;
        if (selector.equals("xpath")) {
            name = driver.findElements(By.xpath(path));
        }
        if (selector.equals("cssSelector")) {
            name = driver.findElements(By.cssSelector(path));
        }
        return name.size();
    }
    @Step
    public void doubleClickOnElement(WebElement element){
        action.doubleClick(element).perform();
    }
    @Step
    public void clickOnElement(WebElement element){
        action.click(element).perform();
    }
    @Step
    public void moveToElement(WebElement element){
        action.moveToElement(element).perform();
    }
    @Step
    public void executeAssert(String expected, String real){
        attachScreenshot();
        Assertions.assertEquals(expected, real);
    }
    @Step
    public void executeAssert(int expected, int real){
        attachScreenshot();
        Assertions.assertEquals(expected, real);
    }
}
