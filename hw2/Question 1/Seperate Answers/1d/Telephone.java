import java.util.Scanner;

/**
   A telephone that takes simulated keystrokes and voice input
   from the user and simulates spoken text.
*/
public class Telephone
{
   /**
      Construct phone object.
      @param aScanner that reads text from a character-input stream
   */
   public Telephone(Scanner aScanner)
   {
      scanner = aScanner;
   }

   /**
      Speak a message to System.out.
      @param output the text that will be "spoken"
   */
   public void speak(String output)
   {
      System.out.println(output);
   }

   /**
      Loops reading user input and passes the input to the
      Connection object's methods dial, record or hangup.
      @param c the connection that connects this phone to the
      voice mail system
   */
   public void run(Connection c)
   {
      boolean more = true;
//      String in = "";

      while (more)
      {
         String input = scanner.nextLine();
//         in += input;
//         if (in.equals("#")) {
//            System.out.println("invalid entry");
//            in = "";
//            continue;
//         }
         if (input == null) return;
         if (input.equalsIgnoreCase("H")) {
//            in = "";
            c.hangup();
         }
         else if (input.equalsIgnoreCase("Q"))
            more = false;
//         else if (in.equals("#")) {
//            System.out.println("invalid entry");
//            in = "";
//            continue;
//         }
//         else if(in.matches(".*[a-zA-z].*")) {
//            in = "";
//            continue;
//         }
         else if (input.length() == 1) {
//                 && "1234567890#".contains(input))
            c.dial(input);
         }
         else {
            c.record(input);
         }
      }
   }

   private Scanner scanner;
}
