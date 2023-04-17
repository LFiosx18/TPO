package tests.three;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.three.Person;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DomainTest {
    static Person person1;
    static Person person2;

    @BeforeAll
    public static void createAll() {
        person1 = new Person("Артур");
        person2 = new Person("Двухголовый человек");
    }

    @Test
    void checkToString() {
        assertEquals(person1.toString(), "Человек по имени Артур");
        assertEquals(person2.toString(), "Человек по имени Двухголовый человек");
    }

    @Test
    void checkFeelings() {
        person1.addFeeling("нервничал");;
        person1.addFeeling("был ошеломлён");
        person2.addFeeling("улыбался");

        String[] p1True = {"Артур нервничал", "Артур был ошеломлён"};
        String[] p1 = person1.getFeelings().toArray(new String[0]);
        assertArrayEquals(p1, p1True);

        String[] p2True = {"Двухголовый человек улыбался"};
        String[] p2 = person2.getFeelings().toArray(new String[0]);
        assertArrayEquals(p2, p2True);
    }

    @Test
    void checkActions() {
        person1.addAction(person1.getName(), "вошёл");
        person1.addAction(person1.getName(), "увидел", person2.getName());
        person2.addAction(person2.bodyParts.getBodyPart("правая голова"), "была занята делом");
        person2.addAction(person2.bodyParts.getBodyPart("левая голова"), "широко улыбалась");

        String actions1 = "Артур вошёл \nАртур увидел Двухголовый человек \n";
        assertEquals(person1.getActions().toString(), actions1);

        String actions2 = "Часть тела не найдена была занята делом \nЧасть тела не найдена широко улыбалась \n";
        assertEquals(person2.getActions().toString(), actions2);
    }

    @Test
    void checkBodyPart() {
        person1.bodyParts.bodyPartsAdd("глаза");
        person1.bodyParts.bodyPartsAdd("челюсть");
        assertEquals(person1.bodyParts.getBodyPart("глаза"), "глаза");
        assertEquals(person1.bodyParts.getBodyPart("челюсть"), "челюсть");
        assertEquals(person1.bodyParts.getBodyPart("нос"), "Часть тела не найдена");
    }
}
