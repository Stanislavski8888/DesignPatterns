package pattern.structure.bridge;

abstract class Abstraction {
    Implementation implementation;

    Abstraction(Implementation impl) {
        this.implementation = impl;
    }

    void service1() {
        implementation.facility1();
        implementation.facility2();
    }

    void service2() {
        implementation.facility2();
        implementation.facility3();
    }

    void service3() {
        implementation.facility1();
        implementation.facility2();
        implementation.facility4();
    }

    protected Implementation getImplementation() {
        return implementation;
    }
}

class ClientService1 extends Abstraction {
    ClientService1(Implementation impl) {
        super(impl);
    }

    void serviceA() {
        service1();
        service2();
    }

    void serviceB() {
        service2();
        service3();
    }
}

class ClientService2 extends Abstraction {
    ClientService2(Implementation impl) {
        super(impl);
    }

    void serviceE() {
        getImplementation().facility3();
    }
}

interface Implementation {
    void facility1();
    void facility2();
    void facility3();
    void facility4();
}

class Implementation1 implements Implementation {

    @Override
    public void facility1() {
        System.out.println("Implementation1: facility1");
    }

    @Override
    public void facility2() {
        System.out.println("Implementation1: facility2");
    }

    @Override
    public void facility3() {
        System.out.println("Implementation1: facility3");
    }

    @Override
    public void facility4() {
        System.out.println("Implementation1: facility4");
    }
}

class Implementation2 implements Implementation {

    @Override
    public void facility1() {
        System.out.println("Implementation2: facility1");
    }

    @Override
    public void facility2() {
        System.out.println("Implementation2: facility2");
    }

    @Override
    public void facility3() {
        System.out.println("Implementation2: facility3");
    }

    @Override
    public void facility4() {
        System.out.println("Implementation2: facility4");
    }
}

/**
 * 桥梁模式应该适用于以下环境:
 * <ol>
 * <li>当你的系统中有多个地方要使用到类似的行为,或者是多个类似行为的组合时,可以考
 * 虑使用桥梁模式来提高重用,并减少因为行为的差异而产生的子类。</li>
 * <li>系统中某个类的行为可能会有几种不同的变化趋势,为了有效的将变化封装,可以考虑
 * 将类的行为抽取出来。</li>
 * <li>当然上面的情况也可以是这样,行为可能要被不同相似类使用,也可以考虑使用桥梁模
 * 式来实现。</li>
 * </ol>
 * 桥梁模式使用了低耦合性的组合代替继承,使得它具备了不少好处:
 * <ol>
 * <li>将可能变化的部分单独封装起来,使得变化产生的影响最小,不用编译不必要的代码。</li>
 * <li>抽象部分和实现部分可以单独的变动,并且每一部分的扩充都不会破坏桥梁模式搭起来
 * 架子。</li>
 * <li>对于客户程序来说,你的实现细节是透明的。</li>
 * </ol>
 */
public class BridgeMode {
    public static void main(String[] args) {
        ClientService1 clientService1 = new ClientService1(new Implementation1());
        clientService1.serviceA();
        clientService1.serviceB();

        ClientService2 clientService2 = new ClientService2(new Implementation2());
        clientService2.serviceE();
        clientService2.service1();
    }
}
