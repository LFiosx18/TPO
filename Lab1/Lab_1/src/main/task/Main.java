package task;

import task.three.Person;
import task.two.HashTable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashTable<Number> col = new HashTable<>();
        double[] arr = {520, 999, 101, 1, 10, 54, 647, 17};
        System.out.println("Res: " + Arrays.toString(col.sort(arr, false, 1)));

//        Person artur = new Person("Artur");
//        Person monster = new Person("Monster");
//
//        print(artur.addBodyPart("голова"));
//
//
//        print(artur.addFeeling("нервничал"));
//        print(artur.addAction("вошёл"));
//        print(artur.addFeeling("был ошеломлён"));
//        artur.addFacePart("глаза", "голова");
//        print(artur.addAction("увидел", monster));
//
//        monster.addBodyPart("ноги");
//        print(monster.addAction("положил", monster.bodyParts.getBodyPart("ноги"), "на пульт"));
//        monster.addBodyPart("левой рукой");
//        monster.addBodyPart("правая голова");
//        monster.addFacePart("зубы", "правая голова");
//        print(monster.addAction("ковырялся", monster.bodyParts.getBodyPart("левой рукой"), "в зубах правой головы"));
//        print(monster.addAction(monster.bodyParts.getBodyPart("правая голова"), "занята делом"));
//        monster.addBodyPart("левая голова");
//        print(monster.addFeeling(monster.bodyParts.getBodyPart("левая голова"), "улыбалась"));
//
//        print(artur.addAction("не верил своим", artur.bodyParts.getBodyPart("глаза")));
//        artur.addFacePart("челюсть", "голова");
//        print(artur.addAction("челюсть отвисла"));
//
//        print(artur.getBodyParts());
//        print(artur.showActions());
    }

    public static void print(String str) {
        System.out.println(str);
    }
}