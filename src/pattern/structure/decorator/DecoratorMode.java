package pattern.structure.decorator;
interface Component {
    void defaultMethod();
}

class ConcreteComponent implements Component {
    @Override
    public void defaultMethod() {
        System.out.println("ConcreteComponent defaultMethod");
    }
}

abstract class Decorator implements Component {
    protected int addedState;

    public int getAddedState() {
        return addedState;
    }

    public void setAddedState(int addedState) {
        this.addedState = addedState;
    }

    @Override
    public void defaultMethod() {
        System.out.println("Decorator defaultMethod");
    }

    void addedBehaviour() {}
}

class ConcreteDecoratorA extends Decorator {
    @Override
    public int getAddedState() {
        return super.getAddedState();
    }

    @Override
    public void setAddedState(int addedState) {
        super.setAddedState(addedState);
    }

    @Override
    public void defaultMethod() {
        System.out.println("ConcreteDecoratorA defaultMethod");
    }

    @Override
    void addedBehaviour() {
        System.out.println("ConcreteDecoratorA addedBehaviour");
    }
}

class ConcreteDecoratorB extends Decorator {
    @Override
    public int getAddedState() {
        return super.getAddedState();
    }

    @Override
    public void setAddedState(int addedState) {
        super.setAddedState(addedState);
    }

    @Override
    public void defaultMethod() {
        System.out.println("ConcreteDecoratorB defaultMethod");
    }

    @Override
    void addedBehaviour() {
        System.out.println("ConcreteDecoratorB addedBehaviour");
    }
}


public class DecoratorMode {
    public static void main(String[] args) {

    }
}
