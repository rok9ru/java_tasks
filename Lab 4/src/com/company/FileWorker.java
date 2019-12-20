package com.company;

import java.io.*;

public class FileWorker {
    private StringBuilder path;

    public FileWorker(String p) {
        path = new StringBuilder(p);
    }

    public String getInputString() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    public String readFile(File file) throws IOException {
        int len = (int) file.length();
        byte[] bytes = new byte[len];
        FileInputStream fis = new FileInputStream(file);
        fis.read(bytes);

        return new String(bytes);
    }

    public void writeFile(File file, String text) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(text.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void openEditTxt(File file) throws IOException {
        StringBuilder content = new StringBuilder(readFile(file));
        while (true) {
            clearScreen();
            this.showEditHint();
            System.out.printf("Content of %s:%n%n", file.getName());
            System.out.println(content);
            String input = getInputString();
            switch (input) {
                case ":clear":
                    content.setLength(0);
                    break;
                case ":q":
                    return;
                case ":qs":
                    writeFile(file, content.toString());
                    return;
                case ":save":
                    writeFile(file, content.toString());
                    break;
                default:
                    content.append('\n').append(input);
                    break;
            }
        }
    }

    protected void showHint() {
        System.out.println(
                "help - показать справку\n" +
                        "show - показать файл в директории\n" +
                        "create- создать файл\n" +
                        " delete - удалить файл\n" +
                        "exit - выйти\n" +
                        "open - окрыть файл, сменить дирректорию\n"
        );
    }

    protected void showEditHint() {
        System.out.println(
                "Hint:\n" +
                        " :clear очистить файл\n"+
                        " :save - сохранить открытый файл\n" +
                        " :q - выйти без сохранения \n" +
                        " :qs - сохранить и выйти"
        );
    }

    public void run() {
        try {
            showHint();
            while (true) {
                String input = getInputString();
                switch (input) {
                    case "exit":
                        return;
                    case "show":
                        File dir = new File(path.toString());
                        File[] folder = dir.listFiles();
                        System.out.println(path);

                        assert folder != null;
                        for (File file : folder) {
                            if (file.isDirectory()) {
                                System.out.printf("\t\\%s\\%n", file.getName());
                            }
                        }

                        for (File file : folder) {
                            if (file.isFile()) {
                                System.out.printf("\t%s%n", file.getName());
                            }
                        }
                        break;
                    case "back":
                    case "..":
                        if (path.length() > 2) {
                            int i = 0;
                            do {
                                i++;
                            } while (path.charAt(path.length() - i) != '\\');
                            path.delete(path.length() - i, path.length());
                            if (path.length() == 2) path.append('\\');
                        } else {
                            path.append('\\');
                        }
                        break;
                    case "create":
                        String in = getInputString();
                        File newfile = new File(path.toString() + File.separator + in + "");
                        if (newfile.createNewFile()) {
                            System.err.printf("Файл %s%n создан.", in);
                        }

                        break;
                    case "delete":
                        String din = getInputString();
                        File file = new File(path + File.separator + din + "");
                        if (file.delete()) {
                            System.err.printf("Файл %s%n удален.", din);
                        }
                        break;

                    case "open":
                        System.out.print("Введите название файла:");
                        File f = new File(path + File.separator + getInputString() + "");
                        if (f.isDirectory()) {
                            path.append("\\");
                            path.append(input);
                        } else if (f.isFile()) {
                            if (getExtension(f).equals("txt")) {
                                openEditTxt(f);
                            } else {
                                System.out.printf("%nCannot open %s%nViewing and editing are available only for .txt files!", f.getName());
                            }
                        } else {
                            System.out.printf("%nCannot open %s%n", f.getName());
                        }
                        showHint();
                        break;
                    case "help":
                        showHint();
                        break;
                    default:
                        System.out.print("Invalid command!\n");
                        showHint();
                        break;
                }
            }
        } catch (IOException ex) {
            System.err.println("Error corrupted:");
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
