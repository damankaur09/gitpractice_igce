import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo1 {
	public String text;
	public static void main(String[] args) {
		RegExDemo1 textObject = new RegExDemo1();
		List<String> tokens = new ArrayList<>();
		int numOfSyllables = 0;
		textObject.text = new String("This is a test.  How many???  Senteeeeeeeeeences are here... there should be 5!  Right?");
		tokens = textObject.getTokens("[yaeiou]+");
		
		if(tokens != null){
			System.out.println(tokens.toString()+"\ncount : " + tokens.size());;
		} 
		for (String word : tokens) {
			numOfSyllables += countSyllables(word);
		}
		System.out.println("No of syllables : " + numOfSyllables);
	}
	
	public List<String> getTokens(String pattern){
		Pattern regularExp = Pattern.compile(pattern);
		Matcher matcher = regularExp.matcher(text);
		List<String> tokensList = new ArrayList<>();
		while (matcher.find()) {
			tokensList.add(matcher.group());
		}
		return tokensList;
	}
	
		protected static int countSyllables(String word)
		{
			int count = 0;
			word = word.toLowerCase();
			
			if(word.charAt(word.length() - 1) == 'e'){
				// Word ending with character 'e'.
				if(isESilent(word)){
					// If 'e' silent, then truncate whole word by one character
					// in the end eg(able, age, moose, wine etc).
					word = word.substring(0, word.length()-1);
					count += countAllSyllables(word);
				}else{
					// If 'e' is not silent,then simply increment syllable count by 1
					// for whole word eg(the).
					count ++;
				}
			}else{
				// word doesn't end with character 'e'
				count = countAllSyllables(word);
			}
		    return count;
		}
		
		/**
		 * Method to determine whether to count ending 'e' as syllable
		 * or not , by looking for any vowel or 'y' , in prefix substring
		 * of the given word.
		 * @return value
		 */
		protected static boolean isESilent(String word) {
			word = word.substring(0, word.length()-1);
			
			Pattern regExpression = Pattern.compile("[yaeiou]");
			Matcher matcher = regExpression.matcher(word);
			
			if(matcher.find()){
				return true;
			}else{
				return false;
			}
		}

		/**
		 * Helper Method to count syllables in word irrespective 
		 * of 'e' in end or not
		 * 
		 * @param word
		 * @return count
		 */
		protected static int countAllSyllables(String word) {
			int count = 0;
			Pattern regExpression = Pattern.compile("[yaeiou]+");
			Matcher matcher = regExpression.matcher(word);
			
			while(matcher.find()){
				++count;
			}
			return count;
		}

}
