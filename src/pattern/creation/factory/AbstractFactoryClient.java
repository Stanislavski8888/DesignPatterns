package pattern.creation.factory;

abstract class AbstractProductA {
    abstract void createProductA();
}

abstract class AbstractProductB {
    abstract void createProductB();
}

class ConcreteProductA1 extends AbstractProductA {
    public ConcreteProductA1() {
        System.out.println("Construct Concrete Product A1");
    }

    @Override
    void createProductA() {
        System.out.println("Create Product A1");
    }
}

class ConcreteProductA2 extends AbstractProductA {
    public ConcreteProductA2() {
        System.out.println("Construct Concrete Product A2");
    }

    @Override
    void createProductA() {
        System.out.println("Create Product A2");
    }
}

class ConcreteProductB1 extends AbstractProductB {
    public ConcreteProductB1() {
        System.out.println("Construct Concrete Product B1");
    }

    @Override
    void createProductB() {
        System.out.println("Create Product B1");
    }
}

class ConcreteProductB2 extends AbstractProductB {
    public ConcreteProductB2() {
        System.out.println("Construct Concrete Product B2");
    }

    @Override
    void createProductB() {
        System.out.println("Create Product B2");
    }
}

abstract class AbstractFactory {
    abstract AbstractProductA createProductA();
    abstract AbstractProductB createProductB();
}

class ConcreteFactoryA extends AbstractFactory {

    @Override
    AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }

}

class ConcreteFactoryB extends AbstractFactory {

    @Override
    AbstractProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    AbstractProductB createProductB() {
        return new ConcreteProductB2();
    }

}

class FactoryProducer {
    public static AbstractFactory getFactory(String factory) {
        if(factory == null)
            return null;

        if (factory.equalsIgnoreCase("A")) {
            return new ConcreteFactoryA();
        } else if (factory.equalsIgnoreCase("B")) {
            return new ConcreteFactoryB();
        }
        return null;
    }
}

public class AbstractFactoryClient {

    public static void main(String[] args) {
        AbstractFactory factoryA = FactoryProducer.getFactory("A");
        factoryA.createProductA().createProductA();
        factoryA.createProductB().createProductB();

        AbstractFactory factoryB = FactoryProducer.getFactory("B");
        factoryB.createProductA().createProductA();
        factoryB.createProductB().createProductB();
    }

}
