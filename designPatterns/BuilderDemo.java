import java.util.List;
import java.util.ArrayList;

public class BuilderDemo {
    public static void main(String[] args) {
        Cashier c1 = new Cashier();
        Cashier c2 = new Cashier();

        List<Meal> meals = new ArrayList<>();

        meals.add(c1.takeOrderAndGiveMeal("happyMeal", "Pepsi"));
        meals.add(c2.takeOrderAndGiveMeal("happyMeal", "Coke"));
        meals.add(c1.takeOrderAndGiveMeal("mountainMeal", "Fanta"));
        meals.add(c2.takeOrderAndGiveMeal("mountainMeal", "Coke"));
        meals.add(c2.takeOrderAndGiveMeal("happyMeal", "Fanta"));

        for (Meal m : meals) {
            System.out.println(m.toString());
        }
    }
}

class Cashier {
    private MealBuilder builder;

    public Meal takeOrderAndGiveMeal(String mealName, String drinkType) {
        switch (mealName) {
            case "happyMeal":
                builder = new HappyMealBuilder(); //TODO: Refactor this, as this creates a lot of objects in the memory eventually
                break;

            case "mountainMeal":
                builder = new MountainMealBuilder(); //TODO: Refactor this, as this creates a lot of objects in the memory eventually
                break;
        }

        return this.builder.build(drinkType);
    }
}

abstract class MealBuilder {
    protected Meal meal;

    public void setMainItem(String item) {
        meal.setMainItem(item);
    }

    public void setSideItem(String item) {
        meal.setSideItem(item);
    }

    public void setDrink(String drink) {
        meal.setDrink(drink);
    }

    public abstract Meal build(String drinkType);
}

class HappyMealBuilder extends MealBuilder {
    @Override
    public Meal build(String drinkType) {
        this.meal = new Meal();

        this.setMainItem("Double Chicken Cheese Burger");
        this.setSideItem("French Fries - Medium");
        this.setDrink(drinkType + " - Medium");

        return this.meal;
    }
}

class MountainMealBuilder extends MealBuilder {
    @Override
    public Meal build(String drinkType) {
        this.meal = new Meal();

        this.setMainItem("Mountain Chicken Cheese Burger");
        this.setSideItem("French Fries - Large");
        this.setDrink(drinkType + " - Large");

        return this.meal;
    }
}

class Meal {
    private String mainItem;
    private String sideItem;
    private String drink;

    public void setMainItem(String item) {
        this.mainItem = item;
    }

    public String getMainItem() {
        return this.mainItem;
    }

    public void setSideItem(String item) {
        this.sideItem = item;
    }

    public String getSideItem() {
        return this.sideItem;
    }

    public void setDrink(String item) {
        this.drink = item;
    }

    public String getDrink() {
        return this.drink;
    }

    @Override
    public String toString() {
        return "---------------------------" +
        "\ncontent:" +
        "\n\tmainItem:" + mainItem +
        "\n\tsideItem:" + sideItem +
        "\n\tdrink:" + drink +
        "\n---------------------------";
    }
}