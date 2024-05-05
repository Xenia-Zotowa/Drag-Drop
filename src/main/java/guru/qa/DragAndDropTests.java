package guru.qa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    @Test

    void dragAndDrop () {

        //Открыть https://the-internet.herokuapp.com/drag_and_drop
        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");
        //Перенесите прямоугольник А на место В
        By draggableElement = By.id("column-a");
        By dropzone = By.id("column-b");
        Selenide.actions().dragAndDrop(Selenide.$(draggableElement), Selenide.$(dropzone)).perform();
        //Проверьте, что прямоугольники действительно поменялись
        Selenide.$("#column-a").shouldHave(Condition.text("B"));
        Selenide.$("#column-b").shouldHave(Condition.text("A"));
        //В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()
        Selenide.$("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        Selenide.$("#column-a").shouldHave(Condition.text("A"));
        Selenide.$("#column-b").shouldHave(Condition.text("B"));

    }
}
