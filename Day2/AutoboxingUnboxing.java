package Day2;

//wrapper class ->> way to use a primitive data type as a object
//              ->> it is an obj that wraps or encapsulate primitive data types within an object

import java.util.ArrayList;

public class AutoboxingUnboxing {
    public static void main(String[] args) {

        //Autoboxing ->> automatic conversion by java compiler makes bet primitive data type and their corrosponding wrapper object classes
        // ex ->> int to Integer

        //primitive int to Integer
        int primitiveInt = 5;
        Integer wrappeInt = primitiveInt; //compiler convert int to Intger Automatically

        System.out.println("Autoboxing");
        System.out.println("primitive int: " + primitiveInt);
        System.out.println("Wrapped Integer: " + wrappeInt);

        //Unboxing ->> opposite/reverse of autoboxing
        //ex       ->> Integer to int

        //Integer to primitive int
        Integer anotherWrappedInt = new Integer(10);
        int anotherPrimitiveInt = anotherWrappedInt; // compiler converts Integer to int auto

        System.out.println("\nUnboxing");
        System.out.println("wrapped Integer: " + anotherWrappedInt);
        System.out.println("primitive int: " + anotherPrimitiveInt);

        //***********************************************************

        //Autoboxing in collections
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(15); //int to Integer

        System.out.println("\nAutoboxing in collection");
        System.out.println("ArrayList<Integer> : " + intList);

        ///Unboxing from collection
        int extarctedInt = intList.get(0);    //Integer to int
        System.out.println("\nUnboxing from collection");
        System.out.println("Extracted int from Array: " + extarctedInt);


    }
}
