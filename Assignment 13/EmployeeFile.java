import java.io.*;
public class EmployeeFile {
    public static void main(String args[]) {

        try {
            // Writing employee details to file
            FileWriter fw = new FileWriter("employee.txt");

            fw.write("Employee ID : 101\n");
            fw.write("Name : Unnati\n");
            fw.write("Department : CSE\n");
            fw.write("Salary : 50000");

            fw.close();

            System.out.println("Employee details written successfully.");

            // Reading employee details from file
            FileReader fr = new FileReader("employee.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("\nEmployee Details:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        }
        catch (IOException e) {

            System.out.println("File Error");

        }
    }
}