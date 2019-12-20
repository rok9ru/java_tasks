package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.NullPointerException;

public class Main {


    public static void main(String[] args) {
        FileWorker fileWorker = new FileWorker("./");
        fileWorker.run();
    }
}
