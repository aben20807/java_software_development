package main;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class SpecialNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		char mode = input.charAt(0);//get mode
		long num = Long.parseLong(input.substring(2));//get number after "="
		if(mode == 'X'){
			if(isSpecialNumber(num)){
				System.out.print("true");
			}
			else{
				System.out.print("false");
			}
		}
		else if(mode == 'Y'){
			System.out.println(getNthSpecialNumber((int)(num)));
		}
		else;
		scanner.close();
	}
	
	public static boolean isSpecialNumber(long num){
		while(num % 2 == 0){//if num is divisible by 2 ,then divide 2
			num /= 2;
		}
		while(num % 3 == 0){
			num /= 3;
		}
		while(num % 5 == 0){
			num /= 5;
		}
		if(num == 1){//if after dividing num = 1, represent num is special number
			return true;
		}
		else{
			//System.out.println(num);//debug
			return false;
		}
	}

	public static long getNthSpecialNumber(int num){
		List<Long> specialSeries = new ArrayList<Long>();//create list to store special number series
		specialSeries.add((long)(1));//first element of special number
		List<Long> specialSeriesOf2h = new ArrayList<Long>();//create list to store 2h series
		List<Long> specialSeriesOf3h = new ArrayList<Long>();
		List<Long> specialSeriesOf5h = new ArrayList<Long>();
		for(int i = 0; i < num; i++){
			specialSeriesOf2h.add(specialSeries.get(i) * 2);//add 2 times of previous number into 2h series
			specialSeriesOf3h.add(specialSeries.get(i) * 3);
			specialSeriesOf5h.add(specialSeries.get(i) * 5);
			
			long minOf2h = specialSeriesOf2h.get(0);//minimum number of each series is at index(0)
			long minOf3h = specialSeriesOf3h.get(0);
			long minOf5h = specialSeriesOf5h.get(0);
			long min = (long)(0);//get minimum number among minimum number of 2h, 3h,5h series
			
			if((minOf2h <= minOf3h) && (minOf2h <= minOf5h)){//compare element at index(0) of 2h, 3h, 5h
				min = minOf2h;
				if(minOf3h == minOf2h){//if minimum of 3h then also need to remove to avoid to repeat
					specialSeriesOf3h.remove(0);
				}
				if(minOf5h == minOf2h){
					specialSeriesOf5h.remove(0);
				}
				specialSeriesOf2h.remove(0);//remove the number which adding in special number series
			}
			else if((minOf3h <= minOf2h) && (minOf3h <= minOf5h)){
				min = minOf3h;
				if(minOf2h == minOf3h){
					specialSeriesOf2h.remove(0);
				}
				if(minOf5h == minOf3h){
					specialSeriesOf5h.remove(0);
				}
				specialSeriesOf3h.remove(0);
			}
			else if((minOf5h <= minOf2h) && (minOf5h <= minOf3h)){
				min = minOf5h;
				if(minOf2h == minOf5h){
					specialSeriesOf2h.remove(0);
				}
				if(minOf3h == minOf5h){
					specialSeriesOf3h.remove(0);
				}
				specialSeriesOf5h.remove(0);
			}
			else;
			specialSeries.add(min);//add number into special number series
		}
		return specialSeries.get(num-1);//nth special number is at index(n-1)
	}
}