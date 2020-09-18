
//ReceiptPrinter.java
//Anand Patil 7/10/20

/* This is a java file 'stub' or piece of a file designed to get you started on 
* learning to code in java, while at the same time, exploring a little more about
* collaboration, version control and multiple file scenarios.
*
*For this assignment, I would like you to fork, modify and commit this file, while
* adding the following elements to your code.
*
* The receipt printer file could take arguments or parametrs from another class
* This file will be purely for output
****************************************
* 40 characters is a standard width    * 
* for typical receipt paper, your task *
* is to make output from the screen    *
* look like it is printing to a small  *
* receipt type printer, with all the   *
* text formatted to 40 characters wide *
*                                      *
* Have fun with the assignment!!       *
****************************************
*/

import java.util.ArrayList;
import java.util.ArrayList;


public class ReceiptPrinter {
	public void printer(ArrayList<Integer> items)
	{
		final double TAX = .07;
		//Print two asertix bars
		asterix();
		asterix();

		//Print two dividers
		divider();
		divider();

		format("Anand's Coffee Stand");

		divider();
		format("5320 Main Street");
		format("Septemeber 10, 2020");

		//Print two dividers
		divider();
		divider();


		parseStringsFromArray(items);

		//Print two dividers
		divider();
		divider();

		//Get total
		double total = getTotal(items);
		format("Total: $" + String.format("%.02f", round(total)));

		//Get total with tax
		double priceWithTax = total * TAX;
		format("Tax: $" + String.format("%.02f", round(priceWithTax)));

		//Complete total
		format("Total with Tax: $" + String.format("%.02f", round(total + priceWithTax)));

		//Print two dividers
		divider();
		divider();

		//Print two asertix bars
		asterix();
		asterix();

	}


	/*


	Formatting the text


	*/



	//Create asertix bars
	public static void asterix()
	{
		String result = "";
		for (int i = 0; i < 40; i++)
		{
			result += "*";
		}
		System.out.println(result);
	}

	//Create dividers
	public static void divider()
	{
		//Format a * 38 spaces *
		String result = "*";
		for (int i = 0; i < 38; i++)
		{
			result += " ";
		}
		result += "*";
		System.out.println(result);
	}	

	public static void format(String centeredText)
	{
		//Number of asterix (accounting for the divison below)
		int numberofAsterix = 44;

		//Length of the text that needs to be centered
		int centeredTextLength = centeredText.length();

		//number of asterix subtracted by text (and then divided by two for two in each side) and minus two to account for the two sapces before and after the text
		numberofAsterix = (numberofAsterix - centeredTextLength - 2) / 2;
		String asterix = "";


		//Create the string of asterixes
		for (int i = 0; i < numberofAsterix - 2; i++)
		{
			asterix += "*";
		}


		//Print result
		if (centeredTextLength % 2 == 0)
		{
			System.out.println(asterix + " " + centeredText + " " + asterix);
		} else
		{
			//Acount for odd centered string by adding an extra asterix before to keep it centered
			System.out.println(asterix + "* " + centeredText + " " + asterix);
		}


	}



	/*



	Convert the items list to strings and numbers


	*/

	//Convert list choice to Strings
	private void parseStringsFromArray(ArrayList<Integer> choices)
	{
		String string = "";
		for (int i = 0; i < choices.size(); i++)
		{
			format("1x " + parseItemName(choices.get(i)) + " $" + getPrice(choices.get(i)));
		}
	}


	//Get item name from int choice
	public static String parseItemName(int choice)
	{
		if (choice == 1)
	    {
	    	return "Donut";
	    } else if (choice == 2)
	    {
	    	return "Coffee";
	    } else
	    {
	    	System.out.println("There was an internal error");
	    	System.exit(0);
	    	return "";
	    }
	}

	//Convert int choice into price (used by above method)
	private static double getPrice(int item)
	{
		final double donutPrice = 1.99;
		final double coffeePrice = 2.99;

		if (item == 1)
		{
			return donutPrice;
		}
		if (item == 2)
		{
			return coffeePrice;
		}
		System.out.println("System error.");
		return 0.00;

	}


	//Get total double from item list
	private static double getTotal(ArrayList<Integer> items)
	{
		double total = 0.0;
		for (int i = 0; i < items.size(); i++)
		{
			total += getPrice(items.get(i));
		}
		return total;
	}

	//Misc methods
	
	//Round numbers to correct number for money
	private static double round(double number)
	{
		number *= 100.0;
		number = (int) Math.round(number);
		number /= 100.0;

		return number;
	}

}