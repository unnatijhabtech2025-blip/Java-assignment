import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String str = sc.nextLine();

        str = str.trim(); 

        if (str.isEmpty()) {
            System.out.println("The sentence is empty.");
        } else {
            String[] words = str.split("\\s+"); 
            int wordCount = words.length; 
            System.out.println("Number of words: " + wordCount);
        }
        sc.close();
    }









