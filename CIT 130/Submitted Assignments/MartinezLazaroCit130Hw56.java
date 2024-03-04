/*
@author Lazaro Martinez
I pledge my word of honor that I have abided
by the CSN Academic Integrity Policy while
completing this assignment.
@file MartinezLazaroCit130Hw56.java
@version The date as 2024-03-03
@note Time taken 3-4 hours, spread out
@program a simple library book management system with basic functionality to add,
display, borrow, and return books. It ensures that the user enters valid input
that if a user input a negative quantity, the program will handle it.
*/

/* IPO
Start
Import Java Scanner Utility
Declare variables
Setup Scanner utility
*/

import java.util.Scanner;

public class MartinezLazaroCit130Hw56 {
    // setup scanner
    public static Scanner input = new Scanner(System.in);

    // declare variables
    static String title;
    static String authorFirstName;
    static String authorLastName;
    static int ISBN;
    static int quantity;
    static double bookCode;
    public static void main(String[] args) {
        
        boolean condition = true;
        int choice;

        while(condition) {

            choices();

            choice = input.nextInt();

            if (choice == 1) {
                addBook();
            } else if (choice == 2) {
                displayBook();
            } else if (choice == 3) {
                borrowBook();
            } else if (choice == 4) {
                returnBook();
            } else if (choice == 5) {
                System.out.println("Thank you for using the Library Book Inventory Management System.");
                condition = false;// exit
            } else {// invalid choice
                System.out.println("Invalid choice. Please try again.");
            }
            
        } //while true
        
    } //main
    
    public static void choices() {
        System.out.println("Library Book Inventory Management:");
        System.out.println("1. Add a Book");
        System.out.println("2. Display Book Information");
        System.out.println("3. Borrow a Book");
        System.out.println("4. Return a Book");
        System.out.println("5. Exit");
        System.out.println("Enter your choice:");
    } // choices
    
    public static void addBook() {
        System.out.println("Enter title:");
        input.nextLine();//needed to flush newline character because it kept skipping title input request
        title = input.nextLine();
        System.out.println("Enter author first name:");
        authorFirstName = input.nextLine();
        System.out.println("Enter author last name:");
        authorLastName = input.nextLine();
        System.out.println("Enter Book ISBM:");
        ISBN = input.nextInt();
        System.out.println("Enter quantity:");
        quantity = input.nextInt();
        System.out.println("Book added successfully.");
        bookCode = (Math.random() * 999) + 1;

    } //add books

    public static void displayBook() {
        System.out.println("Book Information:");
        System.out.printf("\nBook Code Generated: %.04f\n", bookCode);
        System.out.printf("Title: %s\n", title);
        System.out.printf("Author First Name: %s\n", authorFirstName);
        System.out.printf("Author Last Name: %s\n", authorLastName);
        System.out.printf("Author Initials: %s.%s\n", Character.toUpperCase(authorFirstName.charAt(0)), Character.toUpperCase(authorLastName.charAt(0)));
        System.out.printf("ISBN: %d\n", ISBN);
        System.out.printf("Quantity: %d\n", quantity);

    } //display book

    public static void borrowBook() {
        if (quantity > 0) {
            quantity --;
            System.out.println("Book borrowed successfully.");
        }
        else {
            System.out.println("Insufficient quantity. Enter 0 for quantity to go back to choices.");
            quantity = input.nextInt(); //allows user to enter 0 to go back to choices.
        }
    } //borrow book
    
    public static void returnBook() {
        if (quantity > 0) {
            quantity ++;
            System.out.println("Book returned successfully.");
        }
        else {
            System.out.println("Insufficient quantity. Enter 0 for quantity to go back to choices.");
            quantity = input.nextInt(); //allows user to enter 0 to go back to choices.
        }

    } //return book

} //class