package trsul.lab.lab2.animal;

import trsul.lab.lab2.food.FoodInterface;
import trsul.lab.lab2.food.GrassFood;

public class GrassAnimal extends AnimalAbstract {
    public GrassAnimal(String name, int id, int foodSize) {
        super(name, id, foodSize);
    }

    @Override
    public boolean isFoodValid(FoodInterface food) {
        return food instanceof GrassFood;
    }

    @Override
    public void feed(FoodInterface food) {

    }


}
