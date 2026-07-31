abstract class Shape{
    abstract void draw();
        void message(){
        System.out.println("Drawing shape");
    }
}

class Circle extends Shape{
    void draw(){
        System.out.println("Drawing circle");
    }
}

public class AbstractDemo{
    public static void main(String[] args){
        Shape s = new Circle();
        s.draw();
        s.message();
    }
}

