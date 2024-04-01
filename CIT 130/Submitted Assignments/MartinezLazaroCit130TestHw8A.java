import java.util.Scanner;

class TestMartinezLazaroCit130Hw8A {
    public static void main(String[] args) {
        MartinezLazaroCit130Hw8A customer1 = new MartinezLazaroCit130Hw8A();
        customer1.getTotal();
        customer1.displayData();

        MartinezLazaroCit130Hw8A customer2 = new MartinezLazaroCit130Hw8A();
        customer2.assignData(250, 10000, 45000, "Foo Bar");
        customer2.getTotal();
        customer2.displayData();

        MartinezLazaroCit130Hw8A customer3 = new MartinezLazaroCit130Hw8A();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Customer Name:");
        customer3.customerName = input.nextLine();
        System.out.println("Enter checking account balance:");
        customer3.checking = input.nextDouble();
        System.out.println("Enter savings account balance:");
        customer3.savings = input.nextDouble();
        System.out.println("Enter CD account balance:");
        customer3.CD = input.nextDouble();
        customer3.getTotal();
        customer3.displayData();

        input.close();
    }
}
