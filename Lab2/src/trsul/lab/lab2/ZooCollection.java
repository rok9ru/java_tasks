package trsul.lab.lab2;

import trsul.lab.lab2.Main;
import trsul.lab.lab2.animal.AnimalAbstract;
import trsul.lab.lab2.animal.GrassAnimal;
import trsul.lab.lab2.animal.GrassMeatAnimal;
import trsul.lab.lab2.animal.MeatAnimal;

import java.io.*;
import java.util.ArrayList;

public class ZooCollection {
    ArrayList<AnimalAbstract> zoo = null;

    public ZooCollection() {
        zoo = new ArrayList<AnimalAbstract>();
    }

    public void addAnimal(AnimalAbstract an) {
        zoo.add(an);
    }

    public ArrayList<AnimalAbstract> getCollection() {
        return zoo;
    }


    public String toFileString(AnimalAbstract o) {
        return o.getClass().getSimpleName() + ", " + o.getId() + ", " + o.getName() + ", " + o.getFoodSize();
    }

    public boolean readFromFile(String fileName) {
        try {
            File file = new File(fileName);

            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;

            while ((st = br.readLine()) != null){

                String[] split = st.split(",");
                if(split.length != 4){
                    return false;
                }
               // System.out.println(split[0]);
                String cl = split[0].trim();
                String name = split[2].trim();
                int id = Integer.parseInt(split[1].trim());
                int foodSize = Integer.parseInt(split[3].trim());


                if(cl.equals(GrassAnimal.class.getSimpleName())){
                    this.addAnimal(new GrassAnimal(name, id, foodSize));
                }else if(cl.equals(GrassMeatAnimal.class.getSimpleName())){
                    this.addAnimal(new GrassMeatAnimal(name, id, foodSize));
                }else if(cl.equals(MeatAnimal.class.getSimpleName())){
                    this.addAnimal(new MeatAnimal(name, id, foodSize));
                }else{
                    System.out.println("Invalid animal type '" + split[0] + "'");
                }




               // System.out.println(st);
            }
        } catch (IOException  e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean writeToFile(String fileName) {
        try {
            FileWriter writer = null;
            writer = new FileWriter(fileName);
            for (AnimalAbstract animalAbstract : zoo) {
                writer.write(this.toFileString(animalAbstract) + System.lineSeparator());
            }
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public int size() {
        return zoo.size();
    }

    public void print(int from, int till) {
        for (int i = Math.max(from, 0); i < Math.min(till, zoo.size()); i++) {
            System.out.println(zoo.get(i));
        }

    }

    public void print() {
        this.print(0, zoo.size());
    }
}
