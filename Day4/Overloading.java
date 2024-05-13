package Day4;
public class Overloading {
  //method to add 2 variables  
public static int add(int a, int b){
    return a +b;
}

//method to add 2 doubles 
public static double add(double a, double b){
    return a+ b;
}

// Methid to ass 3 intrgers
public static int add(int a, int b, int c){
    return a+b+c;
}

public static void main (String args[]){
    //test cases
    int sum1 = Overloading.add(3, 4);
    System.out.println("sum of integers: " + sum1);

    double sum2 = Overloading.add(3.4, 5.4);
    System.out.println("sum of dubles: " + sum2);

    int sum3 = Overloading.add(2,4,5);
    System.out.println("sum of 3 intergers: " + sum3);
}
}

   