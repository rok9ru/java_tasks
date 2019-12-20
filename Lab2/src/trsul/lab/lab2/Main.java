package trsul.lab.lab2;

import trsul.lab.lab2.animal.AnimalAbstract;
import trsul.lab.lab2.animal.GrassAnimal;
import trsul.lab.lab2.animal.GrassMeatAnimal;
import trsul.lab.lab2.animal.MeatAnimal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    private static int genRandom(int from, int till) {
        return from + (int) (Math.random() * till);
    }

    public static void main(String[] args) {
        ZooCollection zoo = new ZooCollection();

        for (int i = 0; i < 10; i++) {
            int rand = Main.genRandom(0, 10);
            if (rand < 3) {
                zoo.addAnimal(new GrassAnimal("Glass_" + i, i, Main.genRandom(1, 100)));
            } else if (rand > 6) {
                zoo.addAnimal(new MeatAnimal("Meat_" + i, i, Main.genRandom(1, 100)));
            } else {
                zoo.addAnimal(new GrassMeatAnimal("GrassMeat_" + i, i, Main.genRandom(1, 300)));
            }
        }

        System.out.println("Unsorted");

        zoo.print();


        zoo
                .getCollection()
                .sort(Comparator.comparing(AnimalAbstract::getFoodSize, Collections.reverseOrder())    //Сортировка по количеству необходимой еды
                        .thenComparing(AnimalAbstract::getName));                   //Сортировка по имени после сортировки по еде


        System.out.println("Sorted");
        zoo.print();


        System.out.println("First five names");
        for (int i = 0; (i < zoo.size()) && (i < 5); i++) {
            System.out.println(zoo.getCollection().get(i).getName());
        }

        System.out.println("Last three");

        for (int i = Math.max(zoo.size() - 3, 0); i < zoo.size(); i++) {
            System.out.println(zoo.getCollection().get(i).getId());
        }

        zoo.writeToFile("output.txt");
        zoo.getCollection().clear();
        System.out.println("Zoo clean");
        zoo.print();



        zoo.readFromFile("output.txt");
        System.out.println("From file");
        zoo.print();
    }
}
