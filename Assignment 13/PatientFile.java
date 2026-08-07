import java.io.*;
public class PatientFile {
    public static void main(String args[]) {

        try {

            // Writing patient details to file
            FileWriter fw = new FileWriter("patient.txt");

            fw.write("Patient ID : 201\n");
            fw.write("Name : Rahul\n");
            fw.write("Age : 35\n");
            fw.write("Diagnosis : Fever");

            fw.close();

            System.out.println("Patient details written successfully.");

            // Reading patient details from file
            FileReader fr = new FileReader("patient.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("\nPatient Details:");

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
