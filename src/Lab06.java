package src;
import java.util.ArrayList;

public class Lab06 {
    public static void main(String[] args) {
        
        //TEST A
        System.out.println(removeR("onurcan"));
        System.out.println(removeR("m"));
        System.out.println(removeR("mar"));
        System.out.println(removeR("RARARAr"));
        System.out.println(removeR(""));
        System.out.println();

        //TEST B
        System.out.println(decimalToHex(1249));
        System.out.println();

        //TEST C
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("car");
        stringList.add("deal");
        stringList.add("eat");
        stringList.add("fly");
        stringList.add("zebra");
        System.out.println(stringList.toString());

        System.out.println(isInLexicographicOrder(stringList));
        System.out.println();

        //TEST D
        System.out.println(reverse("onurcan"));
        System.out.println();

        //TEST E
        System.out.println(inIncreasingOrder(436,0));
        System.out.println(inIncreasingOrder(147,0));
        System.out.println();

        printEvenIncreasingNumbers(3);
    }

    //PART A
    /**
     * This method returns the given string without r's.
     * @param string given string
     * @return string without r's
     */
    public static String removeR(String string)
    {
        //base case
        if (string.equals(""))
        {
            return "";
        }

        String currentLetter = string.substring(0, 1);
        String newString = string.substring(1);

        if (currentLetter.equals("r"))
        {
            return removeR(newString);
        }
        else
        {
            return currentLetter + removeR(newString);
        }
    }

    //PART B
    /**
     * This method returns a hexadecimal string version of given decimal number.
     * @param decimal given decimal number
     * @return hexadecimal string version of the given decimal number
     */
    public static String decimalToHex(int decimal)
    {
        //base case
        if (decimal < 16)
        {
            return Integer.toHexString(decimal);
        }

        return (decimalToHex(decimal / 16) + Integer.toHexString(decimal % 16)).toUpperCase();
    }

    //PART C
    /**
     * Overloaded version of the method below.
     * @param stringList the arraylist given
     * @return true/false
     */
    public static boolean isInLexicographicOrder(ArrayList<String> stringList)
    {
        return isInLexicographicOrder(stringList,0);
    }

    /**
     * A method which checks if the elements of an arraylist are in lexicographic order.
     * @param stringList given arraylist
     * @param indexOfList index that the method is currently checking
     * @return true/false
     */
    public static boolean isInLexicographicOrder(ArrayList<String> stringList, int indexOfList)
    {
        //base case
        if (indexOfList == stringList.size() - 1)
        {
            return true;
        }
        
        if ((stringList.get(indexOfList)).compareTo(stringList.get(indexOfList + 1)) <= 0)
        {
            indexOfList++;
            return isInLexicographicOrder(stringList, indexOfList);
        }
        else
        {
            return false;
        }  
    }

    //PART D
    /**
     * This method returns reversed version of given string.
     * @param string given string
     * @return reversed version of given string
     */
    public static String reverse(String string)
    {
        //base case
        if (string.equals("") || string.length() == 1)
        {
            return string;
        }

        String firstLetter = string.substring(0, 1);
        String newWord = string.substring(1);//old word without the first letter
        
        return reverse(newWord) + firstLetter;
    }

    //PART E
    /**
     * Overloaded version of the method below.
     * @param digitCount count of digits of required numbers
     */
    public static void printEvenIncreasingNumbers(int digitCount)
    {
        double firstNumber;
        
        if (digitCount > 1)
        {
            firstNumber = Math.pow(10, (double) (digitCount - 1));
        
            printEvenIncreasingNumbers(digitCount,(int)firstNumber);
        }
    }
    
    /**
     * This method prints even numbers with n digits, also that has increasing digits.
     * @param digitCount count of digits of required numbers
     * @param previousNumber number that is checked just before
     */
    public static void printEvenIncreasingNumbers(int digitCount, int previousNumber)
    {
        int newNumber = previousNumber + 2;

        //if new number does not pass the required number of digits
        if (!((Integer.toString(newNumber)).length() > digitCount))
        {
            //if number is in increasing order
            if(inIncreasingOrder(newNumber,0))
            {
                System.out.print(newNumber + " ");
            }
    
            printEvenIncreasingNumbers(digitCount,newNumber);
        }
    }

    /**
     * This method checks if given numbers digits are in increasing order.
     * @param number given number
     * @return true/false
     */
    public static boolean inIncreasingOrder(int number, int currentIndex)
    {
        String numberAString = "" + number;

        //base case
        if (currentIndex == numberAString.length() - 1)//cannot compare last index with anything
        {
            return true;
        }

        //if the nth digit is bigger than or equal to (n+1)th digit
        if (Character.getNumericValue(numberAString.charAt(currentIndex)) >= Character.getNumericValue(numberAString.charAt(currentIndex + 1)))
        {
            return false;
        }
        else
        {
            currentIndex++;
            return inIncreasingOrder(number, currentIndex);
        }
    }    
}
