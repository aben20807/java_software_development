package main;

import java.text.DecimalFormat;
import java.util.Scanner;

public class RootOfEquation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double a = Double.valueOf(scanner.nextLine());
		double b = Double.valueOf(scanner.nextLine());
		double c = Double.valueOf(scanner.nextLine());
		DecimalFormat numberFormat = new DecimalFormat(scanner.nextLine());
		
		double x1 = ((-1*b) + Math.sqrt(b*b - 4*a*c))/(2*a);
		double x2 = ((-1*b) - Math.sqrt(b*b - 4*a*c))/(2*a);
		System.out.printf("%s\n%s", numberFormat.format(x1), numberFormat.format(x2));
		
		scanner.close();
	}

}
