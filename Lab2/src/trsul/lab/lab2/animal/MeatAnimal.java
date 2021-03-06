package trsul.lab.lab2.animal;

import trsul.lab.lab2.food.FoodInterface;
import trsul.lab.lab2.food.GrassFood;
import trsul.lab.lab2.food.MeatFood;

public class MeatAnimal extends AnimalAbstract{

    public MeatAnimal(String name, int id, int foodSize) {
        super(name, id, foodSize);
    }

    @Override
    public boolean isFoodValid(FoodInterface food) {
        return food instanceof MeatFood;
    }

    @Override
    public void feed(FoodInterface food) {

    }


}
