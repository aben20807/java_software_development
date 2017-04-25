package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner scanner;
	
	public static void main(String[] args) {

		scanner =  new Scanner(System.in);
		ArrayList<Character> symbolList = new ArrayList<Character>();
		ArrayList<String> numberList = new ArrayList<String>();
		String input = scanner.nextLine();
		int numBegin = 0;
		for(int i = 0; i < input.length()-2; i++){
			//System.out.println(input.charAt(i+2));
			if(input.charAt(i) == ' ' && 
				input.charAt(i+2) == ' ' &&
				(input.charAt(i+1) == '+' || 
				input.charAt(i+1) == '-' ||
				input.charAt(i+1) == '>' ||
				input.charAt(i+1) == '<' ||
				input.charAt(i+1) == '=' )){
				symbolList.add(input.charAt(i+1));
				String tmpString = input.substring(numBegin, i);//number
				numberList.add(tmpString);
				//System.out.println(numBegin+","+(i)+","+tmpString);
				numBegin += (tmpString.length()+3);
			}
		}
		//add last number
		numberList.add(input.substring(numBegin, input.length()));
		
//		for(int i = 0; i < symbolList.size(); i++){
//			System.out.println(symbolList.get(i));
//		}
//		for(int i = 0; i < numberList.size(); i++){
//			System.out.println(numberList.get(i));
//		}
		String ans = numberList.get(0);//first number
		for(int i = 0; i < symbolList.size(); i++){
			ans = operateSelect(ans, numberList.get(i+1), symbolList.get(i));
		}
		System.out.print(ans);
		scanner.close();
	}

	private static String operateSelect(String n1, String n2, char symbol){
		
		IOperation operation;
		switch (symbol) {
		case '+':
			operation = new Addition();
			return operation.perform(n1, n2);
		case '-':
			operation = new Subtraction();
			return operation.perform(n1, n2);
		case '>':
		case '<':
		case '=':
			operation = new Comparision();
			//System.out.println(symbol + " " + operation.perform(n1, n2));
			if(symbol == '>' && operation.perform(n1, n2).equals("1"))
				return "true";
			else if(symbol == '=' && operation.perform(n1, n2).equals("0"))
				return "true";
			else if(symbol == '<' && operation.perform(n1, n2).equals("-1"))
				return "true";
			else
				return "false";
		default:
			operation = null;
			return "";
		}
	}
}
