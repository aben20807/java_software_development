package main;

public class Subtraction implements IOperation{

	public String perform(String num1, String num2){
		
		if(num1.charAt(0) == '-' && num2.charAt(0) != '-'){//(-) - (+)
			IOperation operation = new Addition();
			return operation.perform(num1, "-"+num2);
		}
		else if(num1.charAt(0) != '-' && num2.charAt(0) == '-'){//(+) - (-)
			IOperation operation = new Addition();
			return operation.perform(num1, num2.substring(1));
		}
		else{
			
		}
		String ans = num1+"-"+num2;
		return ans;
	}
}
