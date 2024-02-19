import java.util.Scanner;

public class Hello
{
 public static void main(String[] args)
 {
   Scanner input = new Scanner(System.in);
   String password;

   /***** modify the following code to allow the user to repeat asking for a password for a total of 3 times" ***/
   
   System.out.print("enter the password: ");
   password = input.nextLine();

   //if ( password == "java" )
   if ( password.equalsIgnoreCase("java") )
   {
     int count = 0;
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
}//Hello


