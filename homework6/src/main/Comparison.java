package main;

public class Comparison implements IOperation{

	public String perform(String num1, String num2){
		String ans = "0";
		if(num1.charAt(0) == '-' && num2.charAt(0) != '-'){//num1<0, num2>0
			ans = "-1";
		}
		else if(num1.charAt(0) != '-' && num2.charAt(0) == '-'){//num1>0, num2<0
			ans = "1";
		}
		else if(num1.charAt(0) != '-' && num2.charAt(0) != '-'){//num1>0, num2>0
			
			if(num1.length() > num2.length()){
				ans = "1";
			}
			else if(num1.length() < num2.length()){
				ans = "-1";
			}
			else{
				ans = Integer.toString(checkWhenSameSigned(num1, num2));
			}
		}
		else if(num1.charAt(0) == '-' && num2.charAt(0) == '-'){//num1<0, num2<0
			if(num1.length() > num2.length()){
				ans = "-1";
			}
			else if(num1.length() < num2.length()){
				ans = "1";
			}
			else{
				ans = Integer.toString(-1 * checkWhenSameSigned(num1, num2));
			}
		}
		//System.out.println(ans);
		return ans;
	}
	
	private int checkWhenSameSigned(String num1, String num2){
		int result = 0;
		for(int i = 0; i < num1.length(); i++){
			if(num1.charAt(i) > num2.charAt(i)){
				result = 1;
				break;
			}
			if(num1.charAt(i) < num2.charAt(i)){
				result = -1;
				break;
			}
		}
		return result;
	}
}
