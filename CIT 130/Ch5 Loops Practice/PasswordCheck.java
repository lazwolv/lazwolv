import java.util.Scanner;
// check a password - give 3 tries

public class PasswordCheck   
{
 public static void main(String[] args)
 {
   Scanner input = new Scanner(System.in);
   String password = "";
   int count = 0;
   int retry = 1;
   
   
   /***** modify the following code to allow the user to repeat asking for a password for a total of 3 times" ***/

   while (retry <= 3 )
    {
     System.out.print("enter the password: ");
     password = input.nextLine();
     
     if ( password.equalsIgnoreCase("java") )
     {
       retry = 6;  //or any number more than 3 - to exit the loop
     }
     else
     {
       System.out.println("Invalid password. You have " + (3 - retry) + " attempts remaining." );
       retry++;
     }//else
   }
   if ( password.equalsIgnoreCase("java") )  //allowing the user to enter the program
   {
     while (count < 5)
     {
       System.out.println((count + 1) + ": Welcome to Java");
       count++;
     }//while count < 5
   }//if
   else
   {
     System.out.println("access denied");
   }//else
 }//main
}//PasswordCheck
