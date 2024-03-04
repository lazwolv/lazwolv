import java.util.Scanner;
public class differentOptions {
    public static Scanner input=new Scanner(System.in);
/** Main method */
    public static void main(String[] args) {
        int option;
        double bmi;
        int num1;
        int num2;
        int start;
        int end;
        double weight=0;
        double height=0;
        display();
        option=input.nextInt();
        while(option!=4){
            if(option==1){
            bmiCalculation(weight, height);
            } else if(option==2){
                System.out.println("Enter first number");
                num1=input.nextInt();
                System.out.println("Enter second number");
                num2=input.nextInt();
                max(num1,num2);
            } else if(option==3){
                System.out.println("Enter integer");
                start=input.nextInt();
                System.out.println("Enter the loop end");
                end=input.nextInt();
                System.out.println("The sum is "+ sum(start, end));
            }else {
                System.out.println("Invalid entry");
            }
        display();
        option=input.nextInt();
        }//while
        System.out.println("The program ends here ");
    }//main
    //to display the options
    public static void display(){
    System.out.println("Thank you for your Business");
    System.out.println("1-BMI Caculaiton ");
    System.out.println("2-find max number ");
    System.out.println("3-find the sum ");
    System.out.println("4-End the program ");
    System.out.println("Enter your option ");
    }//display
    //bmi
    //calculating bmi method
    public static double bmiCalculation(double weight, double height){
        System.out.print("Enter Weight: ");
        weight=input.nextDouble();
        System.out.print("Enter height: ");
        height=input.nextDouble();
        double bmi;
        final double kilogramperpound=0.45359237;
        final double metersperinches=0.0254;
        weight=weight*kilogramperpound;
        height=height*metersperinches;
        bmi= weight/Math.pow(height,2);
        if (bmi < 18.5){
        System.out.println("BMI is: "+ bmi+" is underweight" );}
        else if (bmi<25.0){
        System.out.println("BMI is: "+ bmi+ " Normal");}
        else if (bmi<30){
        System.out.println("BMI is: "+ bmi+" Overweight");}
        else{
        System.out.println("BMI is: "+ bmi+" Obese");
        }//else
        return bmi;
    }//bmiCalculation
    //find the max
    public static int max(int i, int j){
        int result;
        if(i>j){
        System.out.println("i is the max "+i);
        result=i;
        }else{
        System.out.println("j is the max "+j);
        result=j;
        }
        return result;
    }//max
    //find the sum
    public static int sum(int i,int j){//i=1,j=10
    int sum=0;
    for(int x=i;x<=j; x++){
    sum =sum+x;
    }
    return sum;
    }//sum
    }//class differentOptions
