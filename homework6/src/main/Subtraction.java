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
			StringBuilder ans = new StringBuilder();
			String relation = "";
			IOperation operation = new Comparision();
			relation = operation.perform(num1, num2);
			//System.out.println(relation);
			if(relation.equals("0")){//num1 = num2
				return "0";
			}
			else{
				if(num1.charAt(0) == '-' && num2.charAt(0) == '-'){
					num1 = num1.substring(1);
					num2 = num2.substring(1);
				}
				if(operation.perform(num1, num2).equals("-1")){//let num1 > num2 after deleting '-'
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
				for(int i = 0; i < n1.length(); i++){
					char digit = (char) (n1.charAt(n1.length()-1-i) - n2.charAt(n2.length()-1-i) + '0');
					if(carry == -1){
						digit -= 1;
						carry = 0;
					}
					if(digit < '0'){
						carry = -1;
						digit += (char)('9' + 1 - '0');
					}
					ans.append(digit);
				}
				//System.out.println(ans);
				for(int i = ans.length()-1; i >= 0; i--){
					if(ans.charAt(i) != '0'){
						break;
					}
					else{
						ans.delete(ans.length()-1, ans.length());
					}
				}
			}
			if(relation.equals("-1")){
				return "-" + ans.reverse().toString();
			}
			else{
				return ans.reverse().toString();
			}
		}
	}
}
