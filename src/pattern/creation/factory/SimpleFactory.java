package pattern.creation.factory;

interface Product {
    void createProduct();
}

class ProductA implements Product {
    @Override
    public void createProduct() {
        System.out.println("Create Product A");
    }

}

class ProductB implements Product {
    @Override
    public void createProduct() {
        System.out.println("Create Product B");
    }

}

class Factory {
    public static Product create(String product) {
        if(product == null)
            return null;

        if (product.equalsIgnoreCase("A")) {
            return new ProductA();
        } else if (product.equalsIgnoreCase("B")) {
            return new ProductB();
        }
        return null;
    }
}


public class SimpleFactory {

    public static void main(String[] args) {
        Product productA = Factory.create("A");
        productA.createProduct();

        Product productB = Factory.create("B");
        productB.createProduct();
    }

}
