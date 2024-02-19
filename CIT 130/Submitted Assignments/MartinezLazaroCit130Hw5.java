/*
@author Lazaro Martinez
I pledge my word of honor that I have abided
by the CSN Academic Integrity Policy while
completing this assignment.
@file MartinezLazaroCit130Hw5.java
@version The date as 2024-02-18
@note Time taken 2 hours
@program This program provides options for comparing names,
calculating car speed, and handling invalid input gracefully.
*/

/* IPO
Start
Declare variables
Setup Scanner utility
Infinite While loop
Output user choices
Get choice
While choice in (1, 2, 3)
    If choice == 1
        Get names
        Compare names
        Sort names
        Output names
    Else if choice == 2
        Get speed and time
        Check time > 0
        Calculate distance


*/

import java.util.Scanner;

public class MartinezLazaroCit130Hw5{
    public static void main(String[] args) {
        
        int speed;
        int time;
        int distance;
        int choice;

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Compare names");
            System.out.println("2. Calculate car speed");
            System.out.println("3. Handling invalid input");

            choice = input.nextInt();

            while (choice == 1 || choice == 2 || choice == 3){
                if (choice == 1){
                    System.out.println("Enter a name:");
                    String name1 = input.nextLine();
                    System.out.println("Enter a name:");
                    String name2 = input.nextLine();
                    System.out.println("Enter a name:");
                    String name3 = input.nextLine();
                    System.out.println("Enter a name:");
                    String name4 = input.nextLine();

                    if (name1.compareTo(name2) > 0){
                        String temp = name1;
                        name1 = name2;
                        name2 = temp;
                    }
                    if (name2.compareTo(name3) > 0){
                        String temp = name2;
                        name2 = name3;
                        name3 = temp;
                    }
                    if (name3.compareTo(name4) > 0){
                        String temp = name3;
                        name3 = name4;
                        name4 = temp;
                    }
                    if (name1.compareTo(name2) > 0){
                        String temp = name1;
                        name1 = name2;
                        name2 = temp;
                    }

                    

                } else if (choice == 2){
                    System.out.println("Enter the speed:");
                    speed = input.nextInt();
                    System.out.println("Enter the time:");
                    time = input.nextInt();
                        while (time < 0){
                            System.out.println("Enter a valid time value:");
                            int time = input.nextInt();
                        }
                    int distance = speed * time;
                    System.out.printf("Time\tDistance\tSpeed\n");
                    System.out.printf("%d\t %d\t %d\n", time, distance, speed);
                    
                    while (speed > 0 && speed < 120){
                        speed = speed + 5;
                        time = time + 10;
                        distance = speed * time;
                        System.out.printf("%d\t%d\t%d\n", time, distance, speed);
                    }
                else {

                }
        }
    
    
    
    
    }

}