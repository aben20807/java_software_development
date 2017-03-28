package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double num = Double.parseDouble(scanner.nextLine());
		System.out.print("Origin:\t"+babylonian(num));
		System.out.print("\nOuO:\t"+roundByOuO(babylonian(num)));
		System.out.print("\nDecim:\t"+roundByDecimalFormat(babylonian(num)));
		System.out.print("\nBigDe:\t"+roundbyBigDecimal(babylonian(num)));
		scanner.close();
	}
	
	public static double babylonian(double num) {
		double guess = num / 2;
		double next;
		while(true){
			next = (guess + (num / guess)) / 2;
			//System.out.println(guess);
			if((Math.abs(guess - next) / next) >= 0.01)
				guess = next;
			else
				break;
		}
		return next;
	}

	public static String roundByOuO(double value){
		StringBuilder sb = new StringBuilder(((Double)(value)).toString());
		String resultString = "";
		double resultValue = 0D;
		boolean isFindDot = false;
		for(int i = 0; i < sb.length(); i++){
			if(sb.charAt(i) == '.'){
				isFindDot = true;
				sb = sb.append("00");//if value only 1 or 2 decimal add "00" can avoid StringIndexOutOfBoundsException
				resultString = sb.substring(0, i + 4).toString();//Cut after 3 decimal String
				break;
			}
		}
		if(isFindDot == false){//no dot represent value is integer
			return ((Double)(value)).toString();
		}
		else{
			int thirdDecimal = Integer.parseInt(resultString.substring(resultString.length()-1));
			//System.out.println(thirdDecimal);
			if(thirdDecimal >= 5){
				resultString = resultString.substring(0, resultString.length()-1);
				resultValue = Double.parseDouble(resultString) + 0.1;
			}
			else{
				resultString = resultString.substring(0, resultString.length()-1);
				resultValue = Double.parseDouble(resultString);
			}
		}
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(((Double)(resultValue)));
	}
	
	public static String roundByDecimalFormat(double value) {
		DecimalFormat df = new DecimalFormat("#.##");
//		return Double.parseDouble(df.format(value));
		return df.format(value);
	}
	
	public static String roundbyBigDecimal(double value) {
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    DecimalFormat df = new DecimalFormat("#.##");
//	    return bd.doubleValue();
	    return df.format(bd.doubleValue());
	}
}
