import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Scanner;

public class calculate_pi {
    static void string_to_file(File file, String content) { //adds string to file overwriting all other
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
            System.out.println("File successfully updated.");
        } catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }

    static String[] file_to_string(File file) { //takes file in spefic format: line1=pi, line2=den
        String[] temp = new String[5];
        try {
            Scanner fread = new Scanner(file);
            int i = 0;
            while (fread.hasNextLine()) {
                temp[i] = fread.nextLine();
                i++;
            }
            fread.close();
            return temp;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            System.exit(0);
            return new String[]{"3", "2"};
        }
    }

    static void nl_string_to_file(File file, String content) { //adds string to file in a new line
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write("\n");
            writer.write(content);
            writer.close();
            System.out.println("File successfully updated.");
        } catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void main(String[] args) {

        BigDecimal pi;
        BigDecimal den;
        BigDecimal temp;

        File file = new File("pi_val.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File Created: " + file.getName());
                System.out.println();
                pi = new BigDecimal("3");
                den = new BigDecimal("2");
            } else {
                System.out.println("Loading File: " + file.getName());
                pi = new BigDecimal(file_to_string(file)[0]);
                den = new BigDecimal(file_to_string(file)[1]);
                System.out.println("File loaded successfully.");
                System.out.println();
            } //if file created, else load other
        } catch (Exception e) {
            System.out.println("Error: " + e);
            pi = new BigDecimal("");
            den = new BigDecimal("");
            System.exit(0);
        }//try catch of actually creating the file

        BigDecimal four = new BigDecimal("4");
        int digits = 999999;
        int t = 0;
        BigDecimal deno;
        BigDecimal denom;

        while (true) {
            deno = den.multiply(den.add(BigDecimal.valueOf(1))); //deno = n*(n+1)
            denom = deno.multiply(den.add(BigDecimal.valueOf(2)));
            //System.out.println(denom);

            pi = pi.add(four.divide(denom, digits, RoundingMode.HALF_UP));
            temp = pi;

            den = den.add(BigDecimal.valueOf(2));
            deno = den.multiply(den.add(BigDecimal.valueOf(1))); //denom = n*(n+1)*(n+2)
            denom = deno.multiply(den.add(BigDecimal.valueOf(2)));
            //System.out.println(denom);

            pi = pi.subtract(four.divide(denom, digits, RoundingMode.HALF_UP));

            den = den.add(BigDecimal.valueOf(2));
            if (temp == pi) {
                System.out.println("Max precision reached");
                break;
            }
            if (t >= 99) { //saves every 100 times
                t = 0;
                string_to_file(file, pi.toString());
                nl_string_to_file(file, den.toString());
                System.out.println(new Date());
                System.out.println();
                t++;
            } else {
                t++;
            }//if t >= 9, else t++
        } //while true loop
    } //public main
} //class calculate pi