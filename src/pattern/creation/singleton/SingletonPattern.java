package pattern.creation.singleton;

public class SingletonPattern {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}


/***
 * 双重检验锁<br>
 * 这种双重检测机制在JDK1.5之前是有问题的，问题还是出在new对象的地方，由所谓的无序写入造成的。<br>
 * 一般来讲，当初始化一个对象的时候，会经历内存分配、初始化、返回对象在堆上的引用等一系列操作，这种方式产生的对象是
 * 一个完整的对象，可以正常使用。但是JAVA的无序写入可能会造成顺序的颠倒，即内存分配、返回对象引用、初始化的顺序，
 * 这种情况下对应到new对象的地方就是singleton已经不是null，而是指向了堆上的一个对象，但是该对象却还没有完成
 * 初始化动作。当后续的线程发现singleton不是null而直接使用的时候，就会出现意料之外的问题。
 * <p>
 * JDK1.5之后，可以使用volatile关键字修饰变量来解决无序写入产生的问题，因为volatile关键字的一个重要作用是禁止
 * 指令重排序，即保证不会出现内存分配、返回对象引用、初始化这样的顺序，从而使得双重检测真正发挥作用。
 */
class SingletonDoubleCheck {
    private volatile static SingletonDoubleCheck mInstance;

    private SingletonDoubleCheck() {};

    public static SingletonDoubleCheck getInstanceDoubleCheck() {
        if (mInstance == null) {
            synchronized (SingletonDoubleCheck.class) {
                if(mInstance == null) {
                    mInstance = new SingletonDoubleCheck();
                }
            }
        }
        return mInstance;
    }
}


/**
 * 饿汉式（静态常量）
 * <p>
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 * <p>
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 *
 */
class SingletonStatic {

    private final static SingletonStatic INSTANCE = new SingletonStatic();

    private SingletonStatic() {}

    public static SingletonStatic getInstance() {
        return INSTANCE;
    }
}


/**
 * 饿汉式（静态代码块）
 * <p>
 * 这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的
 * 代码，初始化类的实例。优缺点和上面是一样的。
 */
class SingletonStaticBlock {
    private static SingletonStaticBlock instance;

    static {
        instance = new SingletonStaticBlock();
    }

    private SingletonStaticBlock() {}

    public static SingletonStaticBlock getInstanceStaticBlock() {
        return instance;
    }
}


/**
 * 解决了多线程并发的问题，但是却带来了效率问题：<br>
 * 我们的目的是只创建一个实例，new对象处代码只会执行一次，也正是这个地方才需要同步，后面创建了实例之后，
 * singleton非空就会直接返回对象引用，而不用每次都在同步代码块中进行非空验证。
 */
class SingletonSync {
    private static SingletonSync mInstance;

    private SingletonSync() {}

    public static synchronized SingletonSync getInstanceSync() {
        if (mInstance == null) {
            mInstance = new SingletonSync();
        }
        return mInstance;
    }
}


/**
 * 这种方式跟饿汉式方式采用的机制类似，但又有不同。
 * <P>
 * 两者都是采用了类装载的机制来保证初始化实例时只有一个线程。不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，
 * 没有Lazy-Loading的作用，而静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，
 * 调用getInstanceInner方法，才会装载SingletonInstance类，从而完成Singleton的实例化。
 * <p>
 * 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
 * <p>
 * 优点：避免了线程不安全，延迟加载，效率高。
 */
class SingletonInner {

    private SingletonInner() {}

    private static class SingletonInstance {
        private static final SingletonInner INSTANCE = new SingletonInner();
    }

    public static SingletonInner getInstanceInner() {
        return SingletonInstance.INSTANCE;
    }
}

