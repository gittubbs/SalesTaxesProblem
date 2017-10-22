package xpeppers.interview.main;

import java.io.File;
import java.util.Scanner;

import org.json.JSONObject;

import xpeppers.interview.input.hardcoded.Feeder;
import xpeppers.interview.input.json.JSONItemConverter;
import xpeppers.interview.shoppingbasket.ShoppingBasketListBD;
import xpeppers.interview.strategy.Item;
import xpeppers.interview.strategy.TaxStrategyHelper;

public class Launcher {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
	
		menu();
		int choice = sc.nextInt();
		
		
		switch(choice){
			
			case 1:
				feeder();
			case 2:
				json();
			case 3:
				manual();
			
			default:
				sc.close();
				System.exit(0);
		}
		
	
	}

	private static void manual() {
		int c = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.print("How many different Items? ");
		c = sc.nextInt();
		System.out.println();
		
		ShoppingBasketListBD s = new ShoppingBasketListBD();
		for(int i = 0; i<c; i++){
			
			System.out.print("Name: ");
			String name = sc.next();
			System.out.println();
			
			System.out.print("Price: ");
			double price = Double.parseDouble(sc.next());
			System.out.println();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			System.out.println();
			
			System.out.print("Is tax exempt? true or false: ");
			boolean isExempt = sc.nextBoolean();
			System.out.println();
			
			System.out.print("Is imported? true or false: ");
			boolean isImported = sc.nextBoolean();
			System.out.println();
			
			s.add(new Item(name, price, TaxStrategyHelper.getStrategy(isExempt, isImported)), quantity);
		}
		System.out.println();
		System.out.println();
		System.out.println(s.print());
		sc.close();
		System.exit(0);
	}

	@SuppressWarnings("resource")
	private static void json() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("How many different json files? One JSON per file allowed on one line only: ");
		int c = Integer.parseInt(sc.nextLine());
		
		
		ShoppingBasketListBD s = new ShoppingBasketListBD();
		for(int i = 0; i<c; i++){
			System.out.println("Please, insert the path: ");
			String path = sc.nextLine();
			String content = new Scanner(new File(path)).next();
			JSONObject json = new JSONObject(content);
			s.add(JSONItemConverter.toItem(json), JSONItemConverter.getQuantity(json));
		}
		System.out.println(s.print());
		sc.close();
		System.exit(0);
		
	}

	private static void feeder() {
		Feeder.main(null);
		System.exit(0);
		
	}

	private static void menu() {
		System.out.println("");
		System.out.println("");
		System.out.println("     Sales Taxes Problem:");
		System.out.println("");
		System.out.println("1: --- Fill data as track and show results");
		System.out.println("2: --- Fill data from JSON");
		System.out.println("3: --- Fill data manually");
		System.out.println("");
		
		
	}
	
	

}
