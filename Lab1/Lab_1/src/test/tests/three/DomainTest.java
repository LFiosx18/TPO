package tests.three;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.three.Person;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DomainTest {
    static Person person1;
    static Person person2;

    @BeforeEach
    void createAll() {
        person1 = new Person("Артур");
        person2 = new Person("Двухголовый человек");
    }

    @Test
    void checkToString() {
        assertEquals(person1.toString(), "Существо по имени Артур");
        assertEquals(person2.toString(), "Существо по имени Двухголовый человек");
    }

    @Test
    void checkGetBodyParts() {
        person1.addBodyPart("рука");
        person1.addBodyPart("голова");
        person1.addBodyPart("челюсть");
        person1.addBodyPart("глаза");
        person1.addBodyPart("челюсть");
        person1.addBodyPart("рука");

        assertEquals(person1.getBodyParts(), "рука голова ");
    }

    @Test
    void checkAddBodyParts() {
        assertEquals(person1.addBodyPart("глаза"), "Часть тела \"глаза\" должна быть добавлена к голове");
        assertEquals(person1.addBodyPart("рука"), "У Артур есть рука");
        assertEquals(person1.addBodyPart("рука"), "Часть тела рука уже существует");
    }

    @Test
    void checkAddFacePart() {
        assertEquals(person1.addFacePart("глаза", "голова"), "Артур не имеет головы");
        person1.addBodyPart("голова");
        assertEquals(person1.addFacePart("глаза", "голова"), "У существа Артур в голова появился глаза");
        assertEquals(person1.addFacePart("нос", "левая голова"), "Неопознанная голова");
        assertEquals(person1.addFacePart("щёки", "голова"), "Неопознанная часть лица..");
    }

    @Test
    void checkAddFeeling() {
        assertEquals(person1.addFeeling("удивлён"), "У существа Артур нет головы, он не может испытывать чувтсва!");
        person1.addBodyPart("голова");
        assertEquals(person1.addFeeling("удивлён"), "Артур удивлён");
        assertEquals(person1.addFeeling("голова", "ошеломлён"), "голова ошеломлён");
        assertEquals(person1.addFeeling("нога", "счастлива"), "Такой части тела не найдено");
        person1.addBodyPart("рука");
        assertEquals(person1.addFeeling("рука", "разочарована"), "Такой головы не существует");
    }

    @Test
    void checkShowAction() {
        person1.addAction("зашёл");
        person1.addAction("посмотрел");
        person1.addAction("увидел", person2.getName());
        person1.addAction("развернулся", "упал", "поднялся", "пошёл домой");

        assertEquals(person1.showActions(), "Артур зашёл Артур посмотрел Артур увидел Двухголовый человек  Артур развернулся упал поднялся пошёл домой  ");
    }

}
