package Day4;
public class ReverseString {

    public static String reverseString(String str){
        //convert the string to a character array
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length-1;

        //swap characters from start and end
        while(left< right){
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        
        }
        return new String (charArray);
    }
    public static void main(String [] args){
        String input = "Hello, world!";
        String reversed = reverseString(input);
        System.out.println("Reversed String: " + reversed);
    }
    }
 