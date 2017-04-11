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
		//new and initialize after getting type
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
		//switch mode to do
		if(typeDocument == null) return;
		switch (mode) {
		case 'A':
			doModeA(typeDocument);
			break;

		case 'B':
			doModeB(typeDocument);
			break;
		
		case 'C':
			doModeC(typeDocument);
			break;
		
		default:
			break;
		}
	}
	
	private static void doModeA(Document typeDocument){
		
		System.out.print(typeDocument.toString());
	}
	
	private static void doModeB(Document typeDocument){
		
		String keyword = scanner.nextLine();
		if(typeDocument.text.indexOf(keyword) == -1){
			System.out.print("false");
		}
		else{
			System.out.print("true");
		}
	}
	
	private static void doModeC(Document typeDocument){
		
		String changeVariable = scanner.nextLine();
		String newValueOfVariable = scanner.nextLine();
		//System.out.println(typeDocument.getClass().getName());
		switch (typeDocument.getClass().getName()) {//switch class name
		case "main.Document":
			switch (changeVariable) {//switch attribute in class
			case "text":
				typeDocument.setText(newValueOfVariable);
				break;

			default:
				break;
			}
			break;

		case "main.Email":
			switch (changeVariable) {//switch attribute in class
			case "text":
				((Email) typeDocument).setText(newValueOfVariable);
				break;
				
			case "sender":
				((Email) typeDocument).setSender(newValueOfVariable);
				break;
				
			case "recipient":
				((Email) typeDocument).setRecipient(newValueOfVariable);
				break;
				
			case "title":
				((Email) typeDocument).setTitle(newValueOfVariable);
				break;

			default:
				break;
			}
			break;
			
		case "main.File":
			switch (changeVariable) {//switch attribute in class
			case "text":
				((File) typeDocument).setText(newValueOfVariable);
				break;
				
			case "pathname":
				((File) typeDocument).setPathname(newValueOfVariable);
				break;

			default:
				break;
			}
			break;
			
		default:
			break;
		}
		
		System.out.print(typeDocument.toString());//print the updated text content
	}
}
