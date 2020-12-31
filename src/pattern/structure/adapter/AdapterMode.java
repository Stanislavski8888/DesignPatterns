package pattern.structure.adapter;

interface Target{
    void targetMethod();
}

class TargetImpl implements Target {
    @Override
    public void targetMethod() {
        System.out.println("TargetImpl targetMethod");
    }
}
class Adaptee {
    Adaptee(){}

    void adapteeMethod(){
        System.out.println("Adaptee Method");
    }
}

class Adapter implements Target {
    Adaptee adaptee = new Adaptee();
    @Override
    public void targetMethod() {
        adaptee.adapteeMethod();
    }
}

public class AdapterMode {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.targetMethod();

        Target targetImpl = new TargetImpl();
        targetImpl.targetMethod();
    }
}
