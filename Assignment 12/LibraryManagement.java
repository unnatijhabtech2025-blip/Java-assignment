package jav;

import library.Book;

public class LibraryManagement {

    public static void main(String args[]) {

        Book b = new Book(
                101,
                "Java Programming",
                "James Gosling",
                650
        );

        System.out.println("Book Details:");
        b.displayBook();
    }
}
