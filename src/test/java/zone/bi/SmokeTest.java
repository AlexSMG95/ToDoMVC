package zone.bi;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class SmokeTest extends TestBase{
    @Epic("TESTING FOR https://todomvc.com/examples/react/#")
    @Feature(value = "BiZone test work")
    @Description("in this test, we check whether it is possible to use all the letters of the English alphabet")
    @Test
    void abilityToEnterTheEnglishAlphabet() {
        addToDoInField("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz");
        executeAssert(2, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
        executeAssert("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz",
                getNameWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
    }

    @Epic("TESTING FOR https://todomvc.com/examples/react/#")
    @Feature(value = "BiZone test work")
    @Description("in this test, we check whether it is possible to use all the letters of the Russian alphabet")
    @Test
    void abilityToEnterTheRussianAlphabet() {
        addToDoInField("АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя");
        executeAssert(1, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
        executeAssert("АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя",
                getNameWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
    }

    @Epic("TESTING FOR https://todomvc.com/examples/react/#")
    @Feature(value = "BiZone test work")
    @Description("in this test, we check whether it is possible to use numbers")
    @Test
    void abilityToEnterTheNumber() {
        addToDoInField("1234567890");
        executeAssert(1, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
        executeAssert("1234567890",
                getNameWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
    }

    @Epic("TESTING FOR https://todomvc.com/examples/react/#")
    @Feature(value = "BiZone test work")
    @Description("in this test, we check whether it is possible to use special characters")
    @Test
    void abilityToEnterTheSpecialCharacters() {
        addToDoInField("≈&⟨⟩’*⁂@\\‱[],{}•‸⁁⎀⟨⟩^:,⁒©,(ɔ)©¤†‡– —°⌀\"÷⹀ ⸗…℮!ª❧.♀♂>«»‐-☞·‽¡¿<◊☞º−×#№()%‰.¶⌑±′″‴?\"“”\"\"\"\"’''\"®§;℠//℗⌑∴⁀~™_|| /");
        executeAssert(1, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
        executeAssert("≈&⟨⟩’*⁂@\\‱[],{}•‸⁁⎀⟨⟩^:,⁒©,(ɔ)©¤†‡– —°⌀\"÷⹀ ⸗…℮!ª❧.♀♂>«»‐-☞·‽¡¿<◊☞º−×#№()%‰.¶⌑±′″‴?\"“”\"\"\"\"’''\"®§;℠//℗⌑∴⁀~™_|| /",
                getNameWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
    }

    @Epic("TESTING FOR https://todomvc.com/examples/react/#")
    @Feature(value = "BiZone test work")
    @Description("in this test, we check whether it is possible to rename task")
    @Test
    void renameTask() {
        addToDoInField("Test");
        executeAssert("Test", getNameWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
        doubleClickOnElement(getWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
        editNameTask("Text");
        executeAssert("TestText", getNameWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));

    }

    @Epic("TESTING FOR https://todomvc.com/examples/react/#")
    @Feature(value = "BiZone test work")
    @Description("in this test, we check whether it is possible to delete task click on cross")
    @Test
    void deleteTaskClickOnCross() {
        addToDoInField("Test");
        executeAssert("Test", getNameWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
        moveToElement(getWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
        clickOnElement(getWebElement("xpath", "/html/body/section/div/section/ul/li/div/button"));
        executeAssert(0, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
    }

    @Epic("TESTING FOR https://todomvc.com/examples/react/#")
    @Feature(value = "BiZone test work")
    @Description("in this test, we check whether it is possible to delete task by deleting name")
    @Test
    void deleteTaskByDeletingName() {
        addToDoInField("Test");
        executeAssert("Test", getNameWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
        doubleClickOnElement(getWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
        for (int length = 0; length < getNameWebElement("xpath", "/html/body/section/div/section/ul/li/div/label").length(); length++) {
            action.sendKeys(Keys.BACK_SPACE).perform();
        }
        action.sendKeys(Keys.ENTER).perform();
        executeAssert(0, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
    }

    @Epic("TESTING FOR https://todomvc.com/examples/react/#")
    @Feature(value = "BiZone test work")
    @Description("in this test, we check whether it is possible to mark task as completed")
    @Test
    void markTaskAsCompleted() {
        addToDoInField("Test");
        addToDoInField("text");
        executeAssert("Test", getNameWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
        clickOnElement(getWebElement("xpath", "/html/body/section/div/section/ul/li/div/input"));
        executeAssert(1, getListWebElementSize("cssSelector", "html body.learn-bar section.todoapp div section.main ul.todo-list li.completed div.view label"));

    }

    @Epic("TESTING FOR https://todomvc.com/examples/react/#")
    @Feature(value = "BiZone test work")
    @Description("in this test, we check whether it is possible checking how the navigation works")
    @Test
    void navigation() {
        addToDoInField("Task 1");
        addToDoInField("Task 2");
        addToDoInField("Task 3");
        executeAssert(3, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
        clickOnElement(getWebElement("xpath", "/html/body/section/div/section/ul/li/div/input"));
        clickOnElement(getWebElement("xpath", "/html/body/section/div/footer/ul/li[2]/a"));
        executeAssert(2, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
        clickOnElement(getWebElement("xpath", "/html/body/section/div/footer/ul/li[3]/a"));
        executeAssert(1, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
    }

    @Epic("TESTING FOR https://todomvc.com/examples/react/#")
    @Feature(value = "BiZone test work")
    @Description("in this test, we check whether it is possible mark all completed task")
    @Test
    void markAllTaskAsCompleted() {
        addToDoInField("Task 1");
        addToDoInField("Task 2");
        addToDoInField("Task 3");
        executeAssert(3, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
        clickOnElement(getWebElement("xpath", "/html/body/section/div/section/label"));
        executeAssert(3, getListWebElementSize("cssSelector", "html body.learn-bar section.todoapp div section.main ul.todo-list li.completed div.view label"));
    }

    @Epic("TESTING FOR https://todomvc.com/examples/react/#")
    @Feature(value = "BiZone test work")
    @Description("in this test, we check whether it is possible deleting all completed task")
    @Test
    void deleteAllCompletedTask() {
        addToDoInField("Task 1");
        addToDoInField("Task 2");
        addToDoInField("Task 3");
        executeAssert(3, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
        clickOnElement(getWebElement("xpath", "/html/body/section/div/section/label"));
        executeAssert(3, getListWebElementSize("cssSelector", "html body.learn-bar section.todoapp div section.main ul.todo-list li.completed div.view label"));
        clickOnElement(getWebElement("xpath", "/html/body/section/div/footer/button"));
        executeAssert(0, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
    }
}
