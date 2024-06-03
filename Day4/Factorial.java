package Day4;

import java.util.Scanner;

public class Factorial {
//recursive function to calculate factorial
public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
 int number= sc.nextInt();

int result = factorial(number);
    System.out.println("Factorial of " + number + " is " + result);


}
public static int factorial(int n){
    if(n<=1){
        return 1;
    }else{
        return n *factorial(n-1);
    }
}

    }


