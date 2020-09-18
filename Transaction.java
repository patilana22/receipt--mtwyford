import java.util.Scanner;

public class Transaction {
	Scanner scan = new Scanner(System.in);

	public void greet()
	{
		System.out.println("Welcome! \nPlease choose an item: ");
	}


	public int purchase()
	{
		boolean isCompleted = false;
		int finalInt = 0;

		//Loop asking if they do not input a number 1...2
		while(!isCompleted)
		{
			System.out.print("Choose donut(1) or coffee(2)): ");
			int choice = scan.nextInt();


			//Make sure choice is valid
			if (choice > 0)
			{
				if (choice <= 2)
				{
					finalInt = choice;
					System.out.println("\n*-*- You chose 1x " + ReceiptPrinter.parseItemName(choice) + " -*-* \n");
					isCompleted = true;
				}
			}
		}
		return finalInt;
	}
}
