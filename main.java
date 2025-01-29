import java.util.*;

class Restaurant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Manager");
        System.out.println("2. Customer");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Manager");
                break;
            case 2:
                Customer customer = new Customer();
                customer.selectFood();
                break;
            case 3:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid choice");

        }
    }
}

class Customer {
    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();


    Customer() {
        System.out.println("Welcome to virtual restaurant");
    }

    void selectFood() {


        System.out.println("Choose number for given type of food\n\t1.vegetarian\n2.Non-Vegetarian ");
        int choiceFood = sc.nextInt();

        System.out.println("Choose your Food from given menu");
        if (choiceFood == 1) {
            menu.vegetarianFood();
        } else if (choiceFood == 2) {
            menu.nonVegetarian();
        } else {
            System.out.println("Invalid choice");
            return;
        }
        
        
        System.out.println("How many items you want to order?");
        int numberOfItems = sc.nextInt();
        int[] selectedFood = new int[numberOfItems];
        for (int itemCount = 0; itemCount < numberOfItems; itemCount++) {
            System.out.print("Enter the number of your dish (1 to " + menu.vegMenu.length + "): ");
            int selectedDish = sc.nextInt();
            if (selectedDish >= 1 && selectedDish <= menu.vegMenu.length) {
                selectedFood[itemCount] = selectedDish;
            } else {
                System.out.println("Invalid dish number, please try again.");
                itemCount--;  // Decrement to retry for this item
            }
        }

        Bill bill = new Bill();
        bill.calculateBill(selectedFood);
    }

    void payment() {
        System.out.println("Choose your payment method");
        String methodToPay = " 1. Credit Card\n 2. Debit Card\n 3. Net Banking\n 4. UPI\n 5. Cash";
        System.out.println(methodToPay);
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Credit Card");

                break;
            case 2:
                System.out.println("Debit Card");
                break;
            case 3:
                System.out.println("Net Banking");
                break;
            case 4:
                System.out.println("UPI");
                break;
            case 5:
                System.out.println("Cash");
                break;
            default:
                System.out.println("Invalid choice");
        }

    }

    void feedback() {

    }
}

class Menu {
    
    int sizeOfVegPrice = 20;
    String[] vegMenu = new String[sizeOfVegPrice];
    int[] vegPrice = new int[sizeOfVegPrice];

    int sizeOfNonVegPrice = 20;
    String[] nonVegMenu = new String[sizeOfNonVegPrice];
    int[] nonVegPrice = new int[sizeOfNonVegPrice];

    void vegetarianFood() {
        System.out.println("You chose Vegetarian food:-");
        System.out.println(
                "In Vegetarian we have more than 100 dishes,kindly chose your favourite from given list......");
        System.out.println("Here’s a list of popular vegetable-based dishes");
        String menu = "1. Paneer Butter Masala - 250\n" +
                "2. Aloo Gobi (Potato & Cauliflower Curry) - 200\n" +
                "3. Baingan Bharta (Roasted Eggplant Curry) - 220\n" +
                "4. Palak Paneer (Spinach with Cottage Cheese) - 240\n" +
                "5. Chana Masala (Chickpea Curry) - 210\n" +
                "6. Veg Biryani - 300\n" +
                "7. Dum Aloo (Potato Curry) - 230\n" +
                "8. Bhindi Masala (Okra Curry) - 200\n" +
                "9. Mixed Vegetable Curry - 250\n" +
                "10. Matar Paneer (Peas and Cottage Cheese Curry) - 260\n\n" +
                // "### **International Vegetable Dishes**\n" +
                "11. Ratatouille (French Vegetable Stew) - 280\n" +
                "12. Veggie Stir-Fry (Asian Style) - 320\n" +
                "13. Stuffed Bell Peppers (Mediterranean Style) - 300\n" +
                "14. Grilled Vegetable Skewers - 270\n" +
                "15. Vegetable Lasagna - 350\n" +
                "16. Thai Green Curry with Vegetables - 290\n" +
                "17. Cream of Mushroom Soup - 180\n" +
                "18. Veggie Tacos (Mexican Style) - 250\n" +
                "19. Veggie Sushi Rolls - 220\n" +
                "20. Greek Salad - 200\n\n";
        // "### **Snacks and Starters**\n";

        vegMenu = menu.split("\n");

        String[] vegMenuItems = menu.split("\n");

        int index = 0;
        for (String item : vegMenuItems) {
            if (item.contains("-")) {
                // Split by '-' to separate the item name and the price
                String[] parts = item.split(" - ");
                if (parts.length == 2) {
                    vegMenu[index] = parts[0].trim(); // Menu item name
                    vegPrice[index] = Integer.parseInt(parts[1].trim()); // Menu item price
                    index++;
                }
            }
        }

        for (int i = 0; i < vegMenu.length - 1; i++) {
            System.out.println(vegMenu[i] + " " + vegPrice[i] + "INR");
        }
    }

    void nonVegetarian() {
        System.out.println("You chose Non-Vegetarian food:-");
        System.out.println(
                "In Non-Vegetarian we have more than 100 dishes,kindly chose your favourite from given list......");
        System.out.println("Here’s a list of popular Non-vegetable-based dishes");
        String menu = "### **Indian Non-Vegetarian Dishes**\n" +
                "1. Butter Chicken\n" +
                "2. Chicken Tikka Masala\n" +
                "3. Rogan Josh (Red Lamb)\n" +
                "4. Chicken Do Pyaza\n" +
                "5. Chicken Chettinad\n" +
                "6. Malai Kofta\n" +
                "7. Mutton Korma\n" +
                "8. Goan Fish Curry\n" +
                "9. Amritsari Fish\n" +
                "10. Chicken Biryani\n\n" +
                "### **International Non-Vegetarian Dishes**\n" +
                "11. Spaghetti and Meatballs\n" +
                "12. Beef Stroganoff\n" +
                "13. Chicken Parmesan\n" +
                "14. Chicken Alfredo\n" +
                "15. Chicken Quesadillas\n" +
                "16. Chicken Fried Rice\n" +
                "17. Chicken Fajitas\n" +
                "18. Chicken Enchiladas\n" +
                "19. Beef Tacos\n" +
                "20. Beef Wellington\n\n" +
                "### **Snacks and Starters**\n";

        nonVegMenu = menu.split("\n");

        // print menu
        for (String item : nonVegMenu) {
            System.out.println(item);
        }
    }
}

class Bill extends Customer{
//    Menu menu = new Menu();
//    String[] item = menu.vegMenu;
//    int[] price = menu.vegPrice;
    void calculateBill(int[] selectedFood) {
        int billTotal = 0;
        for (int i = 0; i < selectedFood.length; i++) {
            int dishIndex = selectedFood[i] - 1;
            if (dishIndex >= 0 && dishIndex < menu.vegMenu.length) {
                System.out.println(menu.vegMenu[dishIndex] + " - Rs." + menu.vegPrice[dishIndex]);
                billTotal += menu.vegPrice[dishIndex];
            } else {
                System.out.println("Invalid dish selected.");
            }

        }
        System.out.println("Your total bill is: " + billTotal);
    }
}

class Payment {
    Scanner sc = new Scanner(System.in);

    void payCash(int billTotal) {
        double amount = 0;
        do {
            System.out.println("Enter amount");
            amount = sc.nextDouble();
        } while (amount < billTotal);

        if (amount >= billTotal) {
            System.out.println(amount - billTotal + "You get return");
        }

    }
	
	void payCard(int billTotal){
		double amount=0;
		double cardBalance=50000;
		System.out.println("Enter valid details of your credit card:-");
		System.out.println("Enter Your card number:");
		int cardNo=sc.nextInt();
				
		do{
			System.out.println("Enter Your 4 digit PIN:");
			int cardPin=sc.nextInt();
		}while(cardPin>999 && cardPin<=1000);		
		
		if(cardBalance>=billTotal){
			System.out.println(cardBalance-billTotal+"Visit again!");
		}
	}
}

class Manager {
    Scanner sc = new Scanner(System.in);

    void management() {
        System.out.println("1. Add Food");
        System.out.println("2. Remove Food");
        System.out.println("3. Update Food");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Add Food");
                break;
            case 2:
                System.out.println("Remove Food");
                break;
            case 3:
                System.out.println("Update Food");
                break;
            case 4:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
