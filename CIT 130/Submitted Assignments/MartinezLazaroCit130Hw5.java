/*
@author Lazaro Martinez
I pledge my word of honor that I have abided
by the CSN Academic Integrity Policy while
completing this assignment.
@file MartinezLazaroCit130Hw5.java
@version The date as 2024-02-18
@note Time taken 3 hours, spread out
@program This program provides options for comparing names,
calculating car speed, and handling invalid input gracefully.
*/

/* IPO
Start
Import Java Scanner Utility
Declare variables
Setup Scanner utility
While True Loop
    Output user choices
    Get choice
    Validate choice 1, 2 or 3

    If choice == 1
        Get four names
        Dowhile Loop
            Compare and sort names
        Output names in alphabetical order
        For loop to output every other letter and count them
    Else if choice == 2
        Get speed and time
        If time > 0
            Calculate distance
            Output distance in table format
            While 0 < speed < 120
                Calculate distance with increments of 5 for speed and 10 for time
        Else time < 0
            Output error message and back to selections
    Else if choice == 3
        Handle invalid input with error message
    Output choice to continue
    Get choice
    End
*/

import java.util.Scanner;

public class MartinezLazaroCit130Hw5{
    public static void main(String[] args) {
        
        double speed, time, distance;
        int choice;
        int numLetters = 0;
        String name1, name2, name3, name4, temp;
        boolean condition = true;
        boolean order;

        Scanner input = new Scanner(System.in);

        while (condition) {
            System.out.println("Select an option:");
            System.out.println("1. Compare names");
            System.out.println("2. Calculate car speed");
            System.out.println("3. Handling invalid input");

            choice = input.nextInt();
            input.nextLine();

            if (choice < 1 || choice > 3) {
                System.out.println("You entered an out of range number.");
            }

            if (choice == 1) {
                System.out.println("Enter the first name:");
                name1 = input.nextLine();
                System.out.println("Enter the second name:");
                name2 = input.nextLine();
                System.out.println("Enter the third name:");
                name3 = input.nextLine();
                System.out.println("Enter the fourth name:");
                name4 = input.nextLine();

                do {
                    order = false;

                    if (name1.compareTo(name2) > 0) {
                        temp = name1;
                        name1 = name2;
                        name2 = temp;
                        order = true;
                    }
                    if (name2.compareTo(name3) > 0) {
                        temp = name2;
                        name2 = name3;
                        name3 = temp;
                        order = true;
                    }
                    if (name3.compareTo(name4) > 0) {
                        temp = name3;
                        name3 = name4;
                        name4 = temp;
                        order = true;
                    }
                    if (name1.compareTo(name2) > 0) {
                        temp = name1;
                        name1 = name2;
                        name2 = temp;
                        order = true;
                    }
                } while (order);

                System.out.printf("In alphabetical order:\n%s\t%s\t%s\t%s\n", name1, name2, name3, name4);

                for (int i = 1; i < name1.length(); i+=2) {
                        System.out.print(name1.charAt(i) + " ");
                        numLetters ++;
                }
                System.out.printf("There are %d letters.\n", numLetters);
                numLetters = 0;
                
                for (int i = 1; i < name2.length(); i+=2) {
                    System.out.print(name2.charAt(i) + " ");
                    numLetters ++;
                }
                System.out.printf("There are %d letters.\n", numLetters);
                numLetters = 0;
                
                for (int i = 1; i < name3.length(); i+=2) {
                    System.out.print(name3.charAt(i) + " ");
                    numLetters ++;
                }
                System.out.printf("There are %d letters.\n", numLetters);
                numLetters = 0;
                
                for (int i = 1; i < name4.length(); i+=2) {
                    System.out.print(name4.charAt(i) + " ");
                    numLetters ++;
                }
                System.out.printf("There are %d letters.\n", numLetters);
                numLetters = 0;

            } else if (choice == 2) {
                System.out.println("Enter the speed:");
                speed = input.nextInt();
                System.out.println("Enter the time:");
                time = input.nextInt();

                if ( time >= 0) {

                    distance = speed * time;
                    
                    System.out.printf("Hour\tSpeed\tDistance\n");
                    System.out.printf("%.2f\t%.2f\t%.2f\n", time, speed, distance);
                    
                    while (speed > 0 && speed < 120){
                        speed = speed + 5;
                        time = time + 10;
                        distance = speed * time;
                        System.out.printf("%.2f\t%.2f\t%.2f\n", time, speed, distance);
                    }

                } else {
                    System.out.println("Invalid Time Value. Back to Selections");
                }

            } else if (choice == 3){
                System.out.println("You entered an out of range number.");
                }
        System.out.println("Would you like another selection? True or False?");
        condition = input.nextBoolean();

        if (condition == false) {
            System.out.println("Thank you for your time!");
        } // program closes
    
        }

    } // main

} // class
