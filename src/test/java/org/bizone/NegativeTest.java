package org.bizone;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import java.util.List;

class TestCase extends TestBase {

        @Epic("TESTING FOR https://todomvc.com/examples/react/#")
        @Feature(value = "BiZone test work")
        @Severity(SeverityLevel.MINOR)
        @Description("in this test, we check whether it is possible to use all the letters of the English alphabet")
        @Story(value = "Test field for input and accept")
        @Test
        void abilityToEnterTheEnglishAlphabet() {
            addToDoInField("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz");
            executeAssert(1, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
            executeAssert("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz",
                    getNameWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
        }

        @Epic("TESTING FOR https://todomvc.com/examples/react/#")
        @Feature(value = "BiZone test work")
        @Severity(SeverityLevel.MINOR)
        @Description("in this test, we check whether it is possible to use all the letters of the Russian alphabet")
        @Story(value = "Test field for input and accept")
        @Test
        void abilityToEnterTheRussianAlphabet() {
            addToDoInField("АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя");
            executeAssert(1, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
            executeAssert("АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя",
                    getNameWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
        }

        @Epic("TESTING FOR https://todomvc.com/examples/react/#")
        @Feature(value = "BiZone test work")
        @Severity(SeverityLevel.MINOR)
        @Description("in this test, we check whether it is possible to use numbers")
        @Story(value = "Test field for input and accept")
        @Test
        void abilityToEnterTheNumber() {
            addToDoInField("1234567890");
            executeAssert(1, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
            executeAssert("1234567890",
                    getNameWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
        }

        @Epic("TESTING FOR https://todomvc.com/examples/react/#")
        @Feature(value = "BiZone test work")
        @Severity(SeverityLevel.MINOR)
        @Description("in this test, we check whether it is possible to use special characters")
        @Story(value = "Test field for input and accept")
        @Test
        void abilityToEnterTheSpecialCharacters() {
            addToDoInField("≈&⟨⟩’*⁂@\\‱[],{}•‸⁁⎀⟨⟩^:,⁒©,(ɔ)©¤†‡– —°⌀\"÷⹀ ⸗…℮!ª❧.♀♂>«»‐-☞·‽¡¿<◊☞º−×#№()%‰.¶⌑±′″‴?\"“”\"\"\"\"’''\"®§;℠//℗⌑∴⁀~™_|| /");
            executeAssert(1, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
            executeAssert("≈&⟨⟩’*⁂@\\‱[],{}•‸⁁⎀⟨⟩^:,⁒©,(ɔ)©¤†‡– —°⌀\"÷⹀ ⸗…℮!ª❧.♀♂>«»‐-☞·‽¡¿<◊☞º−×#№()%‰.¶⌑±′″‴?\"“”\"\"\"\"’''\"®§;℠//℗⌑∴⁀~™_|| /",
                    getNameWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
        }

        @Epic("TESTING FOR https://todomvc.com/examples/react/#")
        @Feature(value = "BiZone test work")
        @Severity(SeverityLevel.MINOR)
        @Description("in this test, we check whether it is possible to enter 256 characters")
        @Story(value = "Test field for input and accept")
        @Test
        void abilityToEnter256Characters() {
            addToDoInField("≈&⟨⟩’*⁂@\\‱[],{}•‸⁁⎀⟨⟩^:,⁒©,(ɔ)©¤†‡– —°⌀\"÷⹀ ⸗…℮!ª❧.♀♂>«»‐-☞·‽¡¿<◊☞º−×#№()%‰.¶⌑±′″‴?\"“”\"\"\"\"’''\"®§;℠//℗⌑∴⁀~™_|| /AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZzАаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя1234567890qwertyuuiop[]’’;lk");
            executeAssert(1, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
            executeAssert("≈&⟨⟩’*⁂@\\‱[],{}•‸⁁⎀⟨⟩^:,⁒©,(ɔ)©¤†‡– —°⌀\"÷⹀ ⸗…℮!ª❧.♀♂>«»‐-☞·‽¡¿<◊☞º−×#№()%‰.¶⌑±′″‴?\"“”\"\"\"\"’''\"®§;℠//℗⌑∴⁀~™_|| /AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZzАаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя1234567890qwertyuuiop[]’’;lk",
                    getNameWebElement("xpath", "/html/body/section/div/section/ul/li/div/label"));
        }

        @Epic("TESTING FOR https://todomvc.com/examples/react/#")
        @Feature(value = "BiZone test work")
        @Severity(SeverityLevel.MINOR)
        @Description("in this test, we check whether it is possible to create task")
        @Story(value = "Test field for input and accept")
        @Test
        void abilityToCreateEmptyTask() {
            addToDoInField("");
            executeAssert(0, getListWebElementSize("xpath", "/html/body/section/div/section/ul/li/div/label"));
        }

        @Epic("TESTING FOR https://todomvc.com/examples/react/#")
        @Feature(value = "BiZone test work")
        @Severity(SeverityLevel.MINOR)
        @Description("in this test, we check whether it is possible to rename task")
        @Story(value = "Test field for input and accept")
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
        @Severity(SeverityLevel.MINOR)
        @Description("in this test, we check whether it is possible to delete task click on cross")
        @Story(value = "Test field for input and accept")
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
        @Severity(SeverityLevel.MINOR)
        @Description("in this test, we check whether it is possible to delete task by deleting name")
        @Story(value = "Test field for input and accept")
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
        @Severity(SeverityLevel.MINOR)
        @Description("in this test, we check whether it is possible to mark task as completed")
        @Story(value = "Test field for input and accept")
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
        @Severity(SeverityLevel.MINOR)
        @Description("in this test, we check whether it is possible checking how the navigation works")
        @Story(value = "Test field for input and accept")
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
        @Severity(SeverityLevel.MINOR)
        @Description("in this test, we check whether it is possible mark all completed task")
        @Story(value = "Test field for input and accept")
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
        @Severity(SeverityLevel.MINOR)
        @Description("in this test, we check whether it is possible deleting all completed task")
        @Story(value = "Test field for input and accept")
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
