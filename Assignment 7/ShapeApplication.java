package jav;
class Shape {

    void area() {
        System.out.println("Area of shape");
    }
}
// Circle inherits Shape
class Circle extends Shape {

    int radius = 5;

    void area() {
        System.out.println("Area of Circle : " + (3.14 * radius * radius));
    }
}
// Rectangle inherits Shape
class Rectangle extends Shape {

    int length = 10;
    int breadth = 5;

    void area() {
        System.out.println("Area of Rectangle : " + (length * breadth));
    }
}
public class ShapeApplication {

    public static void main(String args[]) {

        Circle c = new Circle();
        Rectangle r = new Rectangle();

        c.area();
        r.area();
    }
}

