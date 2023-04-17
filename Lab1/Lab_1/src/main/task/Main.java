package task;

import task.three.Person;
import task.two.HashTable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person artur = new Person("Артур");
        Person monster = new Person("Странный человек");


        artur.addFeeling("нервничал");
        artur.addFeeling("был ошеломлён");
        artur.addAction(artur.getName(), "вошёл");
        artur.addAction(artur.getName(), "увидел", monster.getName());
        artur.bodyParts.bodyPartsAdd("глаза");
        artur.bodyParts.bodyPartsAdd("челюсть");
        artur.addAction(artur.getName(), "не верил своим", artur.bodyParts.getBodyPart("глаза"));
        artur.addAction("Его", artur.bodyParts.getBodyPart("челюсть"), "отвисла");


        monster.bodyParts.bodyPartsAdd("ноги");
        monster.addAction(monster.getName(), "положил на стол", monster.bodyParts.getBodyPart("ноги"));
        monster.bodyParts.bodyPartsAdd("левая рука");
        monster.bodyParts.bodyPartsAdd("правая голова");
        monster.bodyParts.bodyPartsAdd("зубы");
        monster.addAction(monster.getName(), "ковырял", monster.bodyParts.getBodyPart("левая рука"), "в", monster.bodyParts.getBodyPart("зубы"), monster.bodyParts.getBodyPart("правая голова"));
        monster.bodyParts.bodyPartsAdd("левая голова");
        monster.addAction(monster.bodyParts.getBodyPart("правая голова"), "была занята делом");
        monster.addAction(monster.bodyParts.getBodyPart("левая голова"), "широко улыбалась");

        System.out.println(artur.getActions());
        System.out.println(artur.getFeelings());
        System.out.println(monster.getActions());

    }
}