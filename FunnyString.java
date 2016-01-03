import java.io.Console;
import java.util.Scanner;

public class FunnyString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTestCases = sc.nextInt();
		String[] testStrings = new String[numTestCases];
		
		int i = 0;
		while(i < numTestCases){
			testStrings[i] = sc.next();
			i++;
		}
		
		for (String s : testStrings) {
			if(isFunny(s)){
				System.out.println("Funny");
			}else {
				System.out.println("Not Funny");
			}
		}
		sc.close();

	}

	public static boolean isFunny(String s) {
		char[] cArray = s.toCharArray();
		int modDiffForward = 0;
		int modDiffBackward = 0;

		for (int i = 1, j = cArray.length - 1; i <= (cArray.length / 2); ++i, --j) {
			modDiffForward = Math.abs(cArray[i] - cArray[i - 1]);
			modDiffBackward = Math.abs(cArray[j] - cArray[j - 1]);

			if (modDiffForward != modDiffBackward) {
				return false;
			}
		}
		return true;
	}
}
