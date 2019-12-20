package com.company;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            ProperReader properReader = new ProperReader("File");
            properReader.setFile("File2");

            System.out.println("key2: " + properReader.readValue("key2"));
            System.out.println("key5: " + properReader.readValue("key5"));
            System.out.println("key55: " + properReader.readValue("key55"));

        } catch (IOException | PropertyNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }

}
