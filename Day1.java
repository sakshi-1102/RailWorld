import java.util.Scanner;

//public class Day1 {
//    public static void main(String [] args){
//      int n = 4;
//      int m = 5;
//
//      //outer loop
//        for(int i = 1; i<=n; i++){
//inner loop
//          for(int j = 1; j<=m; j++){
//              System.out.print("*");
//          }
//            System.out.println();
//        }
//    }
//}
public class Day1{
    public static void main(String [] args){
      Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the pattern");
        int n = sc.nextInt();

        for (int i= 0; i< n; i++){
            for(int j = 0; j<n; j++){
                if(i == j || i+j == n-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

}