package main;

public class Subtraction implements IOperation{

	public String perform(String num1, String num2){
		String ans = num1+"-"+num2;
		return ans;
	}
}
