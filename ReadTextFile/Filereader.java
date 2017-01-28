import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * @Author Antonio Maulucci http://www.antomau.com
 */
public class Filereader
{

   private static File file;

   private static Scanner in = new Scanner(System.in);
   private static Scanner inFile;
        public static void main(String[] args) throws FileNotFoundException
        {
            System.out.print("Nome del file da aprire?: ");
            System.out.println();
            file = new File(in.next());
            inFile = new Scanner(file);

            while (inFile.hasNext())
            {
                System.out.println(inFile.next());
            }
        }
}
