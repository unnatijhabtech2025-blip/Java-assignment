class Main {
    public static void main(String[] args) {
        String s = "Walter";
        String rev = "";
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            rev += c;
        }
        System.out.println(rev);
        StringBuilder str = new StringBuilder();
        str.append("Saul");
        str.reverse();
        System.out.println(str);
    }
}
