import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Pangrams {
	private static boolean[] visitedArray ;

	public static void main(String[] args) {
		String stmt = "We promptly judged antique ivory buckles for the next prize";
		System.out.println("sentence pangram ? " + isPangram(stmt));
		
		Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        if(isPangram(input)){
            System.out.println("pangram");
        }else{
            System.out.println("not pangram");
        }
	}

	public static boolean isPangram(String s) {
		s = s.toUpperCase();
		int countOffset = 26;
		visitedArray = new boolean[26];

		Pattern regExpression = Pattern.compile("[A-Z]");
		Matcher matcher = regExpression.matcher(s);

		while (matcher.find()) {
			if (countOffset > 0) {
				int hashCode = matcher.group().hashCode();
				hashCode = calculateIndex(hashCode);

				visitedArray[hashCode] = true;
				--countOffset;
			} else {
				if (isArrayVisited()) {
					return true;
				}
				else{
					countOffset = 26;
				}
			}
		}

		return isArrayVisited();
	}

	/**
	 * Determine whether flag array has all characters visited or not.
	 */
	private static boolean isArrayVisited() {
		for (boolean b : visitedArray) {
			if (!b)
				return b;
		}
		return true;
	}

	/**
	 * Helper method to convert hashcode scale of letters A to Z from (65 -90)
	 * to (0 - 25)
	 * 
	 * @param hashCodeValue
	 * @return array index
	 */
	private static int calculateIndex(int hashCodeValue) {
		return hashCodeValue - 65;
	}
}