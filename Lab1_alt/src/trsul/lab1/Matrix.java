package trsul.lab1;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Matrix {
    private int[][] matrix;

    public Matrix(Scanner scan) {
        int row = setRow(scan);
        int column =setColumn(scan);
        matrix = new int[row][column];
        for (int i=0; i<row; i++){                                      //Случайным образом добавляем в каждую строку по одной единице
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(column);
            matrix[i][randomInt] = 1;
        }

    }

    public int setRow(Scanner scan) {                        //Указываем с клавиатуры количество рядов матрицы
        int row;
        System.out.println("Please enter the rows in the matrix");
        row = scan.nextInt();
        return row;
    }
    public int setColumn(Scanner scan){                      //Указываем с клавиатуры количество столбцов матрицы
        int column;
        System.out.println("Please enter the columns in the matrix");
        column = scan.nextInt();
        return column;
    }

    public void displayMatrix(){                 //Отображение матрицы
        System.out.println("Matrix:\n");
        System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n")); //Вывод каждой строки с новой строки

    }
}
