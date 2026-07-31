public class Addition {
    void add1() {
        System.out.println(1 + 2);
    }
    static void add2() {
        System.out.println(2 + 3);
    }
    public static void main(String[] args) 
    {

        Addition obj = new Addition();
        obj.add1();
        Addition.add2();
    }
}