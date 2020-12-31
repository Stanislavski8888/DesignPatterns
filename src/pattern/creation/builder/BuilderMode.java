package pattern.creation.builder;

class Product {
    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    @Override
    public String toString() {
        return "partA = " + partA + ", partB = " + partB +", partC = " + partC;
    }

    private String partA; //可以是任意类型
    private String partB;
    private String partC;
}

abstract class Builder {
    protected Product product = new Product();

    public abstract void buildPartA(String a);

    public abstract void buildPartB(String b);

    public abstract void buildPartC(String c);

    public Product build() {
        return product;
    }
}

class ConcreteBuilder extends Builder {
    public void buildPartA(String a) {
        System.out.println("build Part A");
        product.setPartA(a);
    }

    public void buildPartB(String b) {
        System.out.println("build Part B");
        product.setPartB(b);
    }

    public void buildPartC(String c) {
        System.out.println("build Part C");
        product.setPartC(c);
    }
}


class Director {
    private Builder builder;

    //1 构造方法的方式注入builder对象
    public Director(Builder builder) {
        this.builder = builder;
    }

    //2 set方法注入builder对象
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Product construct(String a, String b, String c) {
        builder.buildPartA(a);
        builder.buildPartB(b);
        builder.buildPartC(c);
        return builder.build();
    }
}


public class BuilderMode {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct("A", "B", "C");

        System.out.println("product: " + product.toString());
    }
}
