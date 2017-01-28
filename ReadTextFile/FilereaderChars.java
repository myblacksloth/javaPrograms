import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * @Author Antonio Maulucci http://www.antomau.com
 */
public class FilereaderChars
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

            while (inFile.hasNext())
            {

                token = inFile.next();
                int index = 0;
                for (int i=0; i<token.length(); i++)
                {
                    subString = token.charAt(index);
                    System.out.println(subString);
                    index++;
                }

                System.out.println();
            }
        }
}
