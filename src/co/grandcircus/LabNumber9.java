/*
 * @author: Kevin Chung
 */
package co.grandcircus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LabNumber9 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String toContinue = "y";
		boolean beginChoice = false;
		boolean validGrocery = false;

		Map<String, Double> groceryItems = new HashMap<>();
		groceryItems.put("apple", 0.25);
		groceryItems.put("banana", 0.15);
		groceryItems.put("cauliflower", 1.59);
		groceryItems.put("dragonfruit", 2.19);
		groceryItems.put("elderberry", 1.79);
		groceryItems.put("figs", 2.09);
		groceryItems.put("grapefruit", 1.99);
		groceryItems.put("steak", 0.11);
		
		ArrayList<String> item = new ArrayList<>();
		ArrayList<Double> cost = new ArrayList<>();

		System.out.println("Welcome to Kevin's Market!\n");
		
		while (!beginChoice) {
			String inputChoice = Validator.getString(scan,
					"Would you like to enter items by the number or by name? (Enter number or name):");

			if (inputChoice.equalsIgnoreCase("number")) {
				while (toContinue.equals("y")) {
					System.out.println();
					System.out.printf("%-12s %7s\n", "Item", "Price");
					System.out.println("---------------------");
					int counter = 1;
					for (String key : groceryItems.keySet()) {
						System.out.printf(counter++ + ".%-12s $%-8.2f\n", key, groceryItems.get(key));
					}
					while (!validGrocery) {
						int userInput = Validator.getInt(scan, "\nWhat item would you like to order?");

						switch (userInput) {
						case 1:
							System.out.println("Adding banana to cart at " + "$" + groceryItems.get("banana") + ".");
							item.add("banana");
							cost.add(groceryItems.get("banana"));
							validGrocery = true;
							break;
						case 2:
							System.out.println("Adding figs to cart at " + "$" + groceryItems.get("figs") + ".");
							item.add("figs");
							cost.add(groceryItems.get("figs"));
							validGrocery = true;
							break;
						case 3:
							System.out.println("Adding apple to cart at " + "$" + groceryItems.get("apple") + ".");
							item.add("apple");
							cost.add(groceryItems.get("apple"));
							validGrocery = true;
							break;
						case 4:
							System.out.println(
									"Adding cauliflower to cart at " + "$" + groceryItems.get("cauliflower") + ".");
							item.add("cauliflower");
							cost.add(groceryItems.get("cauliflower"));
							validGrocery = true;
							break;
						case 5:
							System.out.println("Adding steak to cart at " + "$" + groceryItems.get("steak") + ".");
							item.add("steak");
							cost.add(groceryItems.get("steak"));
							validGrocery = true;
							break;
						case 6:
							System.out.println(
									"Adding grapefruit to cart at " + "$" + groceryItems.get("grapefruit") + ".");
							item.add("grapefruit");
							cost.add(groceryItems.get("grapefruit"));
							validGrocery = true;
							break;
						case 7:
							System.out.println(
									"Adding dragonfruit to cart at " + "$" + groceryItems.get("dragonfruit") + ".");
							item.add("dragonfruit");
							cost.add(groceryItems.get("dragonfruit"));
							validGrocery = true;
							break;
						case 8:
							System.out.println(
									"Adding elderberry to cart at " + "$" + groceryItems.get("elderberry") + ".");
							item.add("elderberry");
							cost.add(groceryItems.get("elderberry"));
							validGrocery = true;
							break;
						default:
							System.out.println("The item doesn't exist. Please try again.");
							validGrocery = true;
							break;
						}
					}

					toContinue = Validator.getString(scan, "\nWould you like to order anything else (y/n)?")
							.toLowerCase().substring(0, 1);
					validGrocery = false;
					beginChoice = true;
				}
			} else if (inputChoice.equalsIgnoreCase("name")) {
				while (toContinue.equals("y")) {
					System.out.println();
					System.out.printf("%-12s %5s\n", "Item", "Price");
					System.out.println("---------------------");
					for (String key : groceryItems.keySet()) {
						System.out.printf("%-12s $%-8.2f\n", key, groceryItems.get(key));
					}
					while (!validGrocery) {
						String userInput = Validator.getString(scan, "\nWhat item would you like to order?").toLowerCase();
						validGrocery = true;
						if (groceryItems.containsKey(userInput) == true) {
							System.out.println("Adding " + userInput + " to cart at " + "$" + groceryItems.get(userInput) + ".");
							item.add(userInput);
							cost.add(groceryItems.get(userInput));
							validGrocery = true;
						} else {
							System.out.println("Sorry, we don't have those.");
						}
					}

					toContinue = Validator.getString(scan, "\nWould you like to order anything else (y/n)?").toLowerCase().substring(0, 1);
					validGrocery = false;
					beginChoice = true;
				}
			} else {
				System.out.println("\nIncorrect option. Please try again.");
			}
		}
		System.out.println("\nThanks for your order!");
		System.out.println("Here's what you got:");

		int getItem = 0;
		for (String items : item) {
			System.out.printf("%-12s $%-7.2f\n", items, cost.get(getItem));
			getItem++;
		}

		System.out.printf("\nThe total cost is: $%.2f.", totalCost(cost));
		System.out.printf("\nThe average cost is $%.2f.", averageCost(cost));
		System.out.printf("\nThe most expensive item is $%.2f.", highestIndex(cost));
		System.out.printf("\nThe least expensive item is $%.2f.", lowestIndex(cost));

		scan.close();
	}

	public static Double totalCost(List<Double> cost) {
		double total = 0;
		for (Double num : cost) {
			total += num;
		}
		return total;
	}

	public static Double averageCost(List<Double> cost) {
		double total = 0;
		for (Double num : cost) {
			total += num;
		}
		return total / cost.size();
	}

	public static double highestIndex(List<Double> cost) {
		return Collections.max(cost);
	}

	public static double lowestIndex(List<Double> cost) {
		return Collections.min(cost);
	}
}
