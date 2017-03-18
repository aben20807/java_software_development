package main;

public class PigLatin {
	public static void main(String[] args){
		StringBuilder result = new StringBuilder();
		for(String arg: args){
			StringBuilder str = new StringBuilder(arg);//non thread safe
			if(isVowelAtStart(str)){
				str = str.append("ay");
			}
			else{//append first char to end, append "ay", and delete first char 
				str = str.append(str.charAt(0)).append("ay").delete(0, 1);
			}
			str.setCharAt(0, str.substring(0, 1).toUpperCase().charAt(0));//Upper first char
			result = result.append(str).append(" ");
		}
		String output_string = result.deleteCharAt(result.length()-1).toString();//delete last " "
		System.out.print(output_string);
	}
	
	public static boolean isVowelAtStart(StringBuilder input){//check if first char is vowel
		if(input.charAt(0) == 'a' ||
				input.charAt(0) == 'e' ||
				input.charAt(0) == 'i' ||
				input.charAt(0) == 'o' ||
				input.charAt(0) == 'u')
			return true;
		else
			return false;
	}
}
