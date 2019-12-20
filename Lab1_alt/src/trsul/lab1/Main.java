package trsul.lab1;

import java.util.Scanner;

public class Main {
        public static void main (String[] args){
            Scanner scan = new Scanner(System.in); //открытие сканнера для считывания пользовательского ввода
            Matrix matrix = new Matrix(scan);
            scan.close();
            matrix.displayMatrix();
        }
}
