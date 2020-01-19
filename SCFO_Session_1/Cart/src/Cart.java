package p1;
import java.util.Scanner;
//Cart class
class Cart {
	public static void main(String[] args) {
		int[] price = {10, 20, 30};
		int[] quantity = {0 , 0, 0};
		int[] quantityLeft = {100, 100, 100};
		String[] item = {"Pen", "Pencil", "Eraser"};
		System.out.println("\t\t\t\t ABHICART\n");
		System.out.println("Item List\n\t1.Pen@rs10\t2.Pencil@rs20\t3.Eraser@rs30\n");
		chooseOption( item, price, quantity, quantityLeft );
	}

	static void chooseOption(String item[], int[] price, int[] quantity, int[] quantityLeft) {                 //To choose correct option between 0 and 1
		int choice;
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Choose Appropriate option");
			System.out.println("1.Add item/Update Quantity");
			System.out.println("0.Generate Bill\n");
			choice = input.nextInt();
			switch(choice)
			{
				case 0 : {
					billing( item, price, quantity, quantityLeft );
					break;
				}
				case 1 : {
					updateItem( item, price, quantity, quantityLeft );
					break;
				}
				default : {
					System.out.println("Please choose the correct option");
					chooseOption( item, price, quantity, quantityLeft );
				}
			}
		} catch(Exception ex) {
			System.out.println("Please enter correct input");
			chooseOption( item, price, quantity, quantityLeft );
		}
	}

	static void billing(String[] item, int[] price, int[] quantity, int[] quantityLeft) {              //To check empty items or generation of bill and exit
		int total = 0, count = 0;
		for(int i = 0; i < item.length; i++) {
			if(quantity[i] != 0) {
				break;
			} else {
				count++;
			}
		}
		if(count == item.length) {
			System.out.println("Bill Can't be generated, reason : Empty Cart");
			chooseOption( item, price, quantity, quantityLeft );
		} else {
			System.out.println("Item list: ");
			for( int i=0; i<item.length; i++ ) {
				if( (quantity[i] > 0) && (quantityLeft[i] >= quantity[i]) ) {
					total = total + quantity[i] * price[i];
					System.out.println("Item name: "+item[i]+"\tQuantity:"+quantity[i]+"\tPrice: "+price[i] * quantity[i]);
				} if(quantityLeft[i]<quantity[i]) {
					System.out.println("");
				}
			}
			System.out.println("Hurray! Bill Generated:");
			System.out.println("Grand Total: "+total);
		}
	}

	static void updateItem(String item[], int[] price, int[] quantity, int[] quantityLeft) {                  // For Adding items/Updating items
		int idNum,option,total=0;
		try {
			int count = 0;
			Scanner input = new Scanner(System.in);
			System.out.println("Choose id number of the item");
			idNum = input.nextInt();
			System.out.println("Set Quantity");
			option = input.nextInt();
			quantity[idNum - 1] = option;
			for(int i = 0; i < item.length; i++) {
				if(quantity[i] != 0) {
					break;
				} else {
					count++;
				}
			}
			if(count == item.length) {
				System.out.println("No items have been added to the cart");
				chooseOption( item, price, quantity, quantityLeft);
			} else {
				for(int i = 0; i < item.length; i++) {
					if( (quantity[i] > 0) && (quantityLeft[i] >= quantity[i]) ) {
						total = total + quantity[i] * price[i];
						System.out.println("Item name: "+item[i]+"\tQuantity:"+quantity[i]+"\tPrice: "+price[i]*quantity[i]+"\nQuantity Left:"+(quantityLeft[i] - quantity[i])+"\n");
					}
					if(quantityLeft[i] < quantity[i]) {
						System.out.println("Error! You can't add more than the quantity");
					}
				}
				chooseOption(item, price, quantity, quantityLeft);
			}
		} catch(Exception ex) {
			System.out.println("Please enter correct input");
			updateItem(item,price,quantity,quantityLeft);
		}
	}
}