package trsul.lab.lab2.animal;

import trsul.lab.lab2.food.FoodInterface;

public abstract class AnimalAbstract {
    private int id;
    private String name;
   protected int foodSize;


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getFoodSize() {
        return foodSize;
    }

    abstract public boolean isFoodValid(FoodInterface food);

    abstract public void feed(FoodInterface food);

    public String toString() {
        return "ID: " + this.id + " " +  this.name + " " + this.foodSize;
    }


    public AnimalAbstract(String name, int id, int foodSize){
        this.name=name;
        this.id=id;
        this.foodSize=foodSize;

    }

}
