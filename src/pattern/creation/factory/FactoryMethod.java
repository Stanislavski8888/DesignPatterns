package pattern.creation.factory;

interface Products {
    void createProduct();
}

class ProductsA implements Products {
    public ProductsA() {
        System.out.println("Construct Product A");
    }

    @Override
    public void createProduct() {
        System.out.println("Create Product A");
    }
}

class ProductsB implements Products {
    public ProductsB() {
        System.out.println("Construct Product B");
    }

    @Override
    public void createProduct() {
        System.out.println("Create Product B");
    }
}

class ProductsC implements Products {
    public ProductsC() {
        System.out.println("Construct Product C");
    }

    @Override
    public void createProduct() {
        System.out.println("Create Product C");
    }
}

interface IFactory {
    Products create();
}

class FactoryA implements IFactory {
    @Override
    public Products create() {
        return new ProductsA();
    }
}

class FactoryB implements IFactory {
    @Override
    public Products create() {
        return new ProductsB();
    }
}

class FactoryC implements IFactory {
    @Override
    public Products create() {
        return new ProductsC();
    }
}

public class FactoryMethod {

    public static void main(String[] args) {
        IFactory factory;
        factory = new FactoryA();
        factory.create();
        factory = new FactoryB();
        factory.create();
        factory = new FactoryC();
        factory.create();
    }

}
