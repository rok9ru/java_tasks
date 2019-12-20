package trsul.lab.lab2.animal;

import trsul.lab.lab2.food.FoodInterface;
import trsul.lab.lab2.food.GrassFood;
import trsul.lab.lab2.food.MeatFood;

public class GrassMeatAnimal extends AnimalAbstract {
    public GrassMeatAnimal(String name, int id, int foodSize) {
        super(name, id, foodSize);
    }

    @Override
    public boolean isFoodValid(FoodInterface food) {
        return (food instanceof MeatFood) || (food instanceof GrassFood);
    }

    @Override
    public void feed(FoodInterface food) {

    }


}
