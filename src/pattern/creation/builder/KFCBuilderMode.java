package pattern.creation.builder;

/**
 * Product(产品角色)
 */
class Meal {
    private String food;
    private String drink;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
}

/**
 * Builder（抽象建造者）
 */
abstract class MealBuilder {
    Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal(){
        return meal;
    }
}

/**
 * ConcreteBuilder（具体建造者）
 */
class MealA extends MealBuilder{

    public void buildDrink() {
        meal.setDrink("可乐");
    }

    public void buildFood() {
        meal.setFood("薯条");
    }

}

/**
 * ConcreteBuilder（具体建造者）
 */
class MealB extends MealBuilder{

    public void buildDrink() {
        meal.setDrink("柠檬果汁");
    }

    public void buildFood() {
        meal.setFood("鸡翅");
    }

}

/**
 * Director（指挥者）
 */
class KFCWaiter {
    private MealBuilder mealBuilder;

    public KFCWaiter(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }


    public Meal construct() {
        //准备食物
        mealBuilder.buildFood();
        //准备饮料
        mealBuilder.buildDrink();

        //准备完毕，返回一个完整的套餐给客户
        return mealBuilder.getMeal();
    }
}

public class KFCBuilderMode {
    public static void main(String[] args) {
        //套餐A
        MealBuilder a = new MealA();
        //准备套餐A的服务员
        KFCWaiter waiterA = new KFCWaiter(a);
        //获得套餐
        Meal mealA = waiterA.construct();
        System.out.print("套餐A的组成部分:");
        System.out.println("食物："+mealA.getFood()+"；   "+"饮品："+mealA.getDrink());

        //套餐B
        MealBuilder b = new MealB();
        KFCWaiter waiterB = new KFCWaiter(b);
        Meal mealB = waiterB.construct();
        System.out.print("套餐B的组成部分:");
        System.out.println("食物："+mealB.getFood()+"；   "+"饮品："+mealB.getDrink());

    }
}
