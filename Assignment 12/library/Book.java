package library;

public class Book {

    int bookId;
    String title;
    String author;
    double price;

    public Book(int id, String t, String a, double p) {

        bookId = id;
        title = t;
        author = a;
        price = p;
    }


    public void displayBook() {

        System.out.println("Book ID : " + bookId);
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price);
    }
}