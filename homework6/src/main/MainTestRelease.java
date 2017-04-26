package main;

import java.io.InputStream;
import java.util.ArrayList;

public class MainTestRelease {
	public static InputStream stream;

	public static void main(String[] args) {
		
		boolean allright = true;
		ArrayList<String> inputList = new ArrayList<String>();
		ArrayList<String> outputList = new ArrayList<String>();
		inputList.add("0 + 0");
		outputList.add("0");
		inputList.add("1 + 1");
		outputList.add("2");
		inputList.add("0 - 0");
		outputList.add("0");
		inputList.add("123 + 456");
		outputList.add("579");
		inputList.add("123 - 456");
		outputList.add("-333");
		inputList.add("123 > 456");
		outputList.add("false");
		inputList.add("123 < 456");
		outputList.add("true");
		inputList.add("123 = 456");
		outputList.add("false");
		inputList.add("0 = 0");
		outputList.add("true");
		inputList.add("0 < 0");
		outputList.add("false");
		inputList.add("0 < -1");
		outputList.add("false");
		inputList.add("0 = -1");
		outputList.add("false");
		inputList.add("99999 + 99999");
		outputList.add("199998");
		inputList.add("0 - 0 + 0 - 0 + 0 - 0");
		outputList.add("0");
		inputList.add("-123456789 + 987654321 - -123456789");
		outputList.add("987654321");
		inputList.add("9876543210123456789876543210123456789 + 123");
		outputList.add("9876543210123456789876543210123456912");
		inputList.add("-135792468123456789876543210123456789 < -1357924680123456789876543210123456789");
		outputList.add("false");
		inputList.add("12 + 3 + 4567 - 888");
		outputList.add("3694");
		inputList.add("1000 - 999");
		outputList.add("1");
		inputList.add("1000 - 9999");
		outputList.add("-8999");
		inputList.add("1000 - 3");
		outputList.add("997");
		inputList.add("3 - 1000");
		outputList.add("-997");
		for (int index = 0; index < inputList.size(); index++) {
			//String input = scanner.nextLine();
			String input = inputList.get(index);

			String output = MainCode(input);
			if(output.equals(outputList.get(index))){
				
			}
			else{
				allright = false;
				System.out.println("Question: " + input);
				System.out.println("Corr: " + outputList.get(index));
				System.out.println("Your: " + output);
			}
		}
		if(allright == true){
			System.out.println("All Correct");
		}
	}

	private static String MainCode(String inputFromTestList){
		//TODO 0.把原本public static void main(String[] args)裡的貼到這裡
		//TODO 1.註解掉所有Scanner相關的行
		
		//TODO 2.把scanner.nextLine()改成inputFromTestList
		
		//TODO 3. 輸出註解掉，並改為return
		/*******
		 * 例如原本是 System.out.print(answer);
		 * 改成 return answer;
		 *******/
		return "";
	}
	//TODO 4. 若原本的main class有其他function也請加入在下方
}
