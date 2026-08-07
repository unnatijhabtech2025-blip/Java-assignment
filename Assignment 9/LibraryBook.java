package jav;

public class LibraryBook {

    final String ISBN;
    String title;
    String author;
    double price;

    // Constructor
    LibraryBook(String i, String t, String a, double p) {

        ISBN = i;
        title = t;
        author = a;
        price = p;
    }
    void display() {

        System.out.println("ISBN : " + ISBN);
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price);
    }
    public static void main(String args[]) {

        LibraryBook obj = new LibraryBook(
                "978-0134685991",
                "Java Programming",
                "James Gosling",
                650
        );

        obj.display();
    }
}


