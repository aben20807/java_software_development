package main;

import java.util.Scanner;

public class MainOfHw5 {
	
	private static Scanner scanner;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		char mode = scanner.nextLine().charAt(0);
		//System.out.println(mode);
		String type = scanner.nextLine();//get Document, Email or File
		Document typeDocument = newType(type);
		//System.out.println(typeDocument.getClass());
		doMode(mode, typeDocument);
		scanner.close();
	}
	
	private static Document newType(String type){
		Document tmp;
		switch (type) {
		case "Document":
			tmp =  new Document();
			tmp.text = scanner.nextLine();
			break;
		
		case "Email":
			tmp = new Email();
			((Email) tmp).setSender(scanner.nextLine());
			((Email) tmp).setRecipient(scanner.nextLine());
			((Email) tmp).setTitle(scanner.nextLine());
			((Email) tmp).setText(scanner.nextLine());
			break;
		
		case "File":
			tmp = new File();
			((File) tmp).setPathname(scanner.nextLine());
			((File) tmp).setText(scanner.nextLine());
			break;
		
		default:
			tmp = null;
			break;
		}
		return tmp;
	}

	private static void doMode(char mode, Document typeDocument){
		if(typeDocument == null) return;
		switch (mode) {
		case 'A':
			System.out.println(typeDocument.toString());
			break;

		case 'B':
			String keyword = scanner.nextLine();
			String[] token = typeDocument.toString().split("[\\s']");
			boolean isFind = false;
			for (String i : token) {
				if(keyword.equals(i)){
					isFind = true;
					System.out.println("true");
					break;
				}
			}
			if(isFind == false){
				System.out.println("false");
			}
			break;
		case 'C':
	
			break;
		
		default:
			break;
		}
	}
}
