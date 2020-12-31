package pattern.structure.adapter;

abstract class Shape {
    abstract void draw();
}

class Point extends Shape {
    @Override
    void draw() {
        System.out.println("Point");
    }
}

class Line extends Shape {
    @Override
    void draw() {
        System.out.println("Line");
    }
}

class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Square");
    }
}

class TextCircle {
    TextCircle(){}

    void textCircleDraw() {
        System.out.println("TextCircle Draw");
    }
}

class Circle extends Shape {
    TextCircle textCircle = new TextCircle();

    @Override
    void draw() {
        textCircle.textCircleDraw();
    }
}
public class ShapeExample {
    public static void main(String[] args) {
        Shape line = new Line();
        line.draw();

        Shape circle = new Circle();
        circle.draw();
    }
}
