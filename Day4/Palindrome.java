package Day4;


import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();

        int number = 121; //example input
    boolean result = isPalindrome(number, 0);
System.out.println("is " + number + " a palindrome " + result);

}
public static boolean isPalindrome(int num, int temp){
    if(num == 0){
        return temp == 0;
    }
    temp = temp* 10 + num % 10;
    return isPalindrome(num /10, temp);
}
}