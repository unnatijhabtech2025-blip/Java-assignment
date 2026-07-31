public class Book {
    String title;
    String author;
    float price;

    Book() {
        title = " ";
        author = " ";
        price = 0.0f;
    }


    Book(String t, String a) {
        title = t;
        author = a;
        price = 0.0f;
    }

    Book(String t, String a, float p) {
        title = t;
        author = a;
        price = p;
    }

    void print() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("-------------------");
    }

    public static void main(String[] args) {

        Book b1 = new Book();
        b1.print();

        Book b2 = new Book("Java Programming", "John Doe");
        b2.print();

        Book b3 = new Book("Python Basics", "Guido", 499.99f);
        b3.print();
    }
}