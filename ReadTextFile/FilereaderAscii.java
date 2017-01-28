import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FilereaderAscii
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

            String token="";

            char subString;


            int asciiCode = 0;

            while (inFile.hasNext())
            {

                token = inFile.next();
                int index = 0;
                for (int i=0; i<token.length(); i++)
                {
                    subString = token.charAt(index);
                    System.out.println(subString);

                    asciiCode = (int) subString; //cast da CHAR a INTEGER
                    System.out.println("  --- Char's ASCII code is = " + asciiCode);

                    index++;
                }

                System.out.println();
            }
        }
}
