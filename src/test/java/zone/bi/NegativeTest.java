package zone.bi;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

class NegativeTest extends TestBase {
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
    }
