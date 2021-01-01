package pattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

abstract class Component {
    abstract void defaultMethod();
    protected void addComponent(Component cmp) {}
    protected void removeComponent(Component cmp) {}
    protected Component getChild(int i) {return null;}
}

class Leaf extends Component {

    @Override
    void defaultMethod() {
        System.out.println("Leaf defaultMethod");
    }
}

class Composite extends Component {
    List<Component> mContainer = new ArrayList<>();

    @Override
    void defaultMethod() {
        System.out.println("Composite defaultMethod");
    }

    @Override
    protected void addComponent(Component cmp) {
        mContainer.add(cmp);
    }

    @Override
    protected void removeComponent(Component cmp) {
        mContainer.remove(cmp);
    }

    @Override
    protected Component getChild(int i) {
        return mContainer.get(i);
    }
}

public class CompositeMode {
    public static void main(String[] args) {

    }
}
