package com.company;

public class Main {
    public static void main(String[] args) {
        MyStringBuilder test = new MyStringBuilder("This is test string, used for MyStringBuilder construction.");
        test.append(10).append("1111");


        System.out.println(test);

        test.printList();

       /* MyStringBuilder test = new MyStringBuilder("This is test string, used for MyStringBuilder construction.");
        System.out.printf("%s%n%n", test);

        test.append(" Appending this string, and next appending char, int, double: ");
        System.out.printf("%s%n%n", test);

        test.append('a');
        System.out.printf("%s%n%n", test);

        test.append(1);
        System.out.printf("%s%n%n", test);

        test.append(1.2345);
        System.out.printf("%s%n%n", test);

        test.printCommandList();

        test.undo();
        System.out.printf("%n%s%n%n", test);

        test.undo();
        System.out.printf("%s%n%n", test);

        test.undo();
        System.out.printf("%s%n%n", test);

        test.undo();
        System.out.printf("%s%n%n", test);

        test.insert(36, " (inserting string here) ");
        test.insert(8, false);
        test.insert(15, 1.2345);
        test.delete(23, 30);
        test.insert(40, '$');
        test.deleteCharAt(34);

        System.out.printf("%s%n%n", test);
        test.printCommandList();

        test.undo();
        System.out.printf("%n%s%n%n", test);

        test.undo();
        System.out.printf("%s%n%n", test);

        test.undo();
        System.out.printf("%s%n%n", test);

        test.undo();
        System.out.printf("%s%n%n", test);

        test.undo();
        System.out.printf("%s%n%n", test);

        test.undo();
        System.out.printf("%s%n%n", test);*/
    }
}