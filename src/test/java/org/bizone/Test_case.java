package org.bizone;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test_case {

    WebDriver driver;
    Actions action;
    SoftAssert softAssert;
    @Before
    public void setUpDriver() {
        driver = new ChromeDriver();
        action = new Actions(driver);
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://todomvc.com/examples/react/#/active");
    }

    @Test
    public void createTodo() {
        driver.findElement(By.className("new-todo")).sendKeys("1", Keys.ENTER);
        List < WebElement > label = driver.findElements(By.xpath("/html/body/section/div/section/ul/li/div/label"));
        softAssert = new SoftAssert();
        softAssert.assertEquals(String.valueOf(label.size()), "1");
        softAssert.assertEquals(label.get(0).getAttribute("textContent"), "1");
        softAssert.assertAll();
    }

    @Test
    public void renameTodo() {
        driver.findElement(By.className("new-todo")).sendKeys("1", Keys.ENTER);
        List < WebElement > label = driver.findElements(By.xpath("/html/body/section/div/section/ul/li/div/label"));
        action.moveToElement(label.get(0)).build().perform();
        action.doubleClick(label.get(0)).perform();
        action.sendKeys(Keys.BACK_SPACE).build().perform();
        action.sendKeys("333").build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
        label = driver.findElements(By.xpath("/html/body/section/div/section/ul/li/div/label"));
        softAssert = new SoftAssert();
        softAssert.assertEquals(String.valueOf(label.size()), "1");
        softAssert.assertEquals(label.get(0).getAttribute("textContent"), "333");
        softAssert.assertAll();
    }

    @Test
    public void deleteTaskCross() {
        driver.findElement(By.className("new-todo")).sendKeys("1", Keys.ENTER);
        List < WebElement > button_destroy = driver.findElements(By.xpath("/html/body/section/div/section/ul/li/div/button"));
        List < WebElement > label = driver.findElements(By.xpath("/html/body/section/div/section/ul/li/div/label"));
        action.moveToElement(label.get(0)).build().perform();
        action.click(label.get(0)).perform();
        action.moveToElement(button_destroy.get(0)).perform();
        action.click(button_destroy.get(0)).perform();
        label = driver.findElements(By.xpath("/html/body/section/div/section/ul/li/div/label"));
        softAssert = new SoftAssert();
        softAssert.assertEquals(String.valueOf(label.size()), "0");
        softAssert.assertAll();
    }

    @Test
    public void deleteTaskByClearName() {
        driver.findElement(By.className("new-todo")).sendKeys("1", Keys.ENTER);
        List < WebElement > label = driver.findElements(By.xpath("/html/body/section/div/section/ul/li/div/label"));
        action.moveToElement(label.get(0)).build().perform();
        action.doubleClick(label.get(0)).perform();
        action.sendKeys(Keys.BACK_SPACE).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
        label = driver.findElements(By.xpath("/html/body/section/div/section/ul/li/div/label"));
        softAssert = new SoftAssert();
        softAssert.assertEquals(String.valueOf(label.size()), "0");
        softAssert.assertAll();
    }

    @Test
    public void markTaskComplet() {
        driver.findElement(By.className("new-todo")).sendKeys("1", Keys.ENTER);
        List < WebElement > button_toogle = driver.findElements(By.xpath("/html/body/section/div/section/ul/li/div/input"));
        action.moveToElement(button_toogle.get(0)).build().perform();
        action.click(button_toogle.get(0)).build().perform();
        WebElement button_completed = driver.findElement(By.xpath("/html/body/section/div/footer/ul/li[3]/a"));
        action.click(button_completed).build().perform();
        List < WebElement > completed_list = driver.findElements(By.cssSelector("html body.learn-bar section.todoapp div section.main ul.todo-list li.completed div.view label"));
        softAssert = new SoftAssert();
        softAssert.assertEquals(String.valueOf(completed_list.size()), "1");
        softAssert.assertAll();
    }
    @Test
    public void navigation() {
        driver.findElement(By.className("new-todo")).sendKeys("1", Keys.ENTER);
        driver.findElement(By.className("new-todo")).sendKeys("2", Keys.ENTER);
        driver.findElement(By.className("new-todo")).sendKeys("3", Keys.ENTER);
        List < WebElement > button_toogle = driver.findElements(By.xpath("/html/body/section/div/section/ul/li/div/input"));
        action.moveToElement(button_toogle.get(0)).build().perform();
        action.click(button_toogle.get(0)).build().perform();
        WebElement button_completed = driver.findElement(By.xpath("/html/body/section/div/footer/ul/li[3]/a"));
        WebElement button_all = driver.findElement(By.xpath("/html/body/section/div/footer/ul/li[1]/a"));
        WebElement button_active = driver.findElement(By.xpath("/html/body/section/div/footer/ul/li[2]/a"));
        softAssert = new SoftAssert();


        action.click(button_all).build().perform();
        List < WebElement > active_list = driver.findElements(By.xpath("/html/body/section/div/section/ul/li/div/label"));
        List < WebElement > completed_list = driver.findElements(By.cssSelector("html body.learn-bar section.todoapp div section.main ul.todo-list li.completed div.view label"));
        active_list.remove(completed_list.get(0));
        softAssert.assertEquals(String.valueOf(active_list.size()), "2");
        softAssert.assertEquals(String.valueOf(completed_list.size()), "1");
        softAssert.assertEquals(String.valueOf(completed_list.size() + active_list.size()), "3");

        action.click(button_active).build().perform();
        active_list = driver.findElements(By.xpath("/html/body/section/div/section/ul/li/div/label"));
        completed_list = driver.findElements(By.cssSelector("html body.learn-bar section.todoapp div section.main ul.todo-list li.completed div.view label"));
        softAssert.assertEquals(String.valueOf(active_list.size()), "2");
        softAssert.assertEquals(String.valueOf(completed_list.size()), "0");
        softAssert.assertEquals(String.valueOf(completed_list.size() + active_list.size()), "2");

        action.click(button_completed).build().perform();
        active_list = driver.findElements(By.xpath("/html/body/section/div/section/ul/li/div/label"));
        completed_list = driver.findElements(By.cssSelector("html body.learn-bar section.todoapp div section.main ul.todo-list li.completed div.view label"));
        active_list.remove(completed_list.get(0));
        softAssert.assertEquals(String.valueOf(active_list.size()), "0");
        softAssert.assertEquals(String.valueOf(completed_list.size()), "1");
        softAssert.assertEquals(String.valueOf(completed_list.size() + active_list.size()), "1");
        softAssert.assertAll();
    }

    @Test
    public void deleteCompletedTask(){
        driver.findElement(By.className("new-todo")).sendKeys("1", Keys.ENTER);
        driver.findElement(By.className("new-todo")).sendKeys("2", Keys.ENTER);
        driver.findElement(By.className("new-todo")).sendKeys("3", Keys.ENTER);
        driver.findElement(By.className("new-todo")).sendKeys("4", Keys.ENTER);
        driver.findElement(By.className("new-todo")).sendKeys("5", Keys.ENTER);
        driver.findElement(By.className("new-todo")).sendKeys("6", Keys.ENTER);
        WebElement markAllCompleted = driver.findElement(By.xpath("/html/body/section/div/section/label"));
        action.click(markAllCompleted).build().perform();
        WebElement button_completed = driver.findElement(By.xpath("/html/body/section/div/footer/ul/li[3]/a"));
        action.click(button_completed).build().perform();
        List < WebElement > completed_list = driver.findElements(By.cssSelector("html body.learn-bar section.todoapp div section.main ul.todo-list li.completed div.view label"));
        softAssert = new SoftAssert();
        softAssert.assertEquals(String.valueOf(completed_list.size()), "6");
        WebElement clearCompleted = driver.findElement(By.xpath("/html/body/section/div/footer/button"));
        action.click(clearCompleted).build().perform();
        List < WebElement > active_list = driver.findElements(By.xpath("/html/body/section/div/section/ul/li/div/label"));
        softAssert.assertEquals(String.valueOf(active_list.size()), "0");
        softAssert.assertAll();
    }
    @After
    public void close() {
        driver.close();
    }
}