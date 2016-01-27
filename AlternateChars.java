import java.util.Scanner;

public class AlternateChars {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTestCases = sc.nextInt();
		String[] testStrings = new String[numTestCases];
		
		for(int i = 0; i < testStrings.length; i++){
			testStrings[i]  = sc.next();
			System.out.println(numOfDeletion(testStrings[i]));
		}
	}
	
	private static int numOfDeletion(String str){
		str = str.toLowerCase();
		char[] charArray = str.toCharArray();
		int delCount = 0;
		
		int p = 0;
		int q = p + 1;
		while(q < charArray.length) {
			if(charArray[p] == charArray[q]){
				++delCount;
				++q;
			}else{
				p = q;
				++q;
			}
		}
		
		return delCount;
	}
}
