package main;

public class Addition implements IOperation{
	
	public String perform(String num1, String num2){
		
		if(num1.charAt(0) == '-' && num2.charAt(0) != '-'){//(-) + (+)
			IOperation operation = new Subtraction();
			return operation.perform(num2, num1.substring(1));
		}
		else if(num1.charAt(0) != '-' && num2.charAt(0) == '-'){//(+) + (-)
			IOperation operation = new Subtraction();
			return operation.perform(num1, num2.substring(1));
		}
		else{
			boolean isBothNegative = false;
			if(num1.charAt(0) == '-' && num2.charAt(0) == '-'){
				isBothNegative = true;
				num1 = num1.substring(1);
				num2 = num2.substring(1);
			}
			
			//System.out.println(n1);
			//System.out.println(n2);
			if(num1.length() < num2.length()){//let length of num1 > num2
				String tmp = num1;//exchange
				num1 = num2;
				num2 = tmp;
			}
			StringBuilder n1 = new StringBuilder(num1);
			StringBuilder n2 = new StringBuilder(num2);
			for(int i = 0; i < num1.length() - num2.length();i++){
				n2.insert(0, '0');//insert '0' to num2 to let length of num1, num2 equal
				//System.out.println("add0");
			}
			//System.out.println(n1);
			//System.out.println(n2);
			
			int carry = 0;
			StringBuilder ans = new StringBuilder();
			for(int i = 0; i < n1.length(); i++){
				char digit = (char) (n1.charAt(n1.length()-1-i) + n2.charAt(n2.length()-1-i) - '0');
				if(carry == 1 && digit >= '0'){
					digit += 1;
					carry = 0;
				}
				if(digit > '9'){
					carry = 1;
					digit -= (char)('9' + 1 - '0');
				}
				ans.append(digit);
			}
			if(carry == 1){
				ans.append('1');
				carry = 0;
			}
			//System.out.println(ans);
			if(isBothNegative == true){
				return "-" + ans.reverse().toString();
			}
			else{
				return ans.reverse().toString();
			}
		}
	}
}
