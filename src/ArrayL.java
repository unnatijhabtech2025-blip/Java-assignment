import java.util.ArrayList;

public class ArrayL {
    public static void main(String[] args) {

        ArrayList<Integer> arr1 = new ArrayList<>();

        arr1.add(1);
        arr1.add(1);
        arr1.add(1);

        arr1.add(2, 5);

        // ArrayList does not support addFirst() and addLast()
        // Use these instead:
        arr1.add(0, 9);      // add at first
        arr1.add(0);         // add at last

        System.out.println(arr1.size());
        System.out.println(arr1.contains(5));
        System.out.println(arr1.indexOf(5));

        arr1.remove(3);
        System.out.println(arr1.size());

        arr1.remove(3);
        System.out.println(arr1.size());

        arr1.clear();
        System.out.println(arr1);
    }
}