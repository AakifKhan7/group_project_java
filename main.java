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
                Manager manager = new Manager();
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
    // Menu menu = new Menu();

    Customer() {
        System.out.println("Welcome to virtual restaurant");
    }

    void selectFood() {
        String food_type = "";

        System.out.println("Choose number for given type of food\n1.vegetarian\n2.Non-Vegetarian ");
        int choiceFood = sc.nextInt();

        System.out.println("Choose your Food from given menu");
        if (choiceFood == 1) {
            Menu.vegetarianFood();
            food_type = "vegetarian";
        } else if (choiceFood == 2) {
            Menu.nonVegetarian();
            food_type = "non-vegetarian";
        } else {
            System.out.println("Invalid choice");
            return;
        }

        System.out.print("How many items you want to order?: ");
        int numberOfItems = sc.nextInt();
        int[] selectedFood = new int[numberOfItems];
        for (int itemCount = 0; itemCount < numberOfItems; itemCount++) {
            System.out.print("Enter the number of your dish (1 to " + Menu.vegMenu.length + "): ");
            int selectedDish = sc.nextInt();
            if (selectedDish >= 1 && selectedDish <= Menu.vegMenu.length) {
                selectedFood[itemCount] = selectedDish;
            } else {
                System.out.println("Invalid dish number, please try again.");
                itemCount--;
            }
        }

        Bill bill = new Bill();
        double billTotal = bill.calculateBill(food_type, selectedFood);

        System.out.println();
        payment(billTotal);


        // payment.makePayment(billTotal);
    }
    Payment payment = new Payment();

    void payment(double billTotal) {
        System.out.println("Choose your payment method");
        String methodToPay = " 1. Credit Card\n 2. Debit Card\n 3. Net Banking\n 4. UPI\n 5. Cash";
        System.out.println(methodToPay);
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Credit Card");
                payment.payCreditCard(billTotal);

                break;
            case 2:
                System.out.println("Debit Card");
                payment.payDebitCard(billTotal);
                break;
            case 3:
                System.out.println("Net Banking");
                payment.payNetBanking(billTotal);
                break;
            case 4:
                System.out.println("UPI");
                payment.payUPI(billTotal);
                break;
            case 5:
                System.out.println("Cash");
                payment.payCash(billTotal);
                break;
            default:
                System.out.println("Invalid choice");
        }

    }

    void feedback() {

    }
}

class Menu {

    static int sizeOfVegPrice = 20;
    static String[] vegMenu = new String[sizeOfVegPrice];
    static int[] vegPrice = new int[sizeOfVegPrice];

    static int sizeOfNonVegPrice = 20;
    static String[] nonVegMenu = new String[sizeOfNonVegPrice];
    static int[] nonVegPrice = new int[sizeOfNonVegPrice];

    static void vegetarianFood() {
        System.out.println("You chose Vegetarian food:-");
        System.out.println(
                "In Vegetarian we have more than 100 dishes,kindly chose your favourite from given list......");
        System.out.println("Here’s a list of popular vegetable-based dishes");
        String menu = "1.   Paneer Butter Masala                          - 250\n" +
                "2.   Aloo Gobi (Potato & Cauliflower)             - 200\n" +
                "3.   Baingan Bharta (Roasted Eggplant)            - 220\n" +
                "4.   Palak Paneer (Spinach & Cottage Cheese)      - 240\n" +
                "5.   Chana Masala (Chickpea Curry)                - 210\n" +
                "6.   Veg Biryani                                  - 300\n" +
                "7.   Dum Aloo (Potato Curry)                      - 230\n" +
                "8.   Bhindi Masala (Okra Curry)                   - 200\n" +
                "9.   Mixed Vegetable Curry                        - 250\n" +
                "10.  Matar Paneer (Peas & Cottage Cheese)        - 260\n\n" +
                // "### International Vegetarian Dishes\n" +
                "11.  Ratatouille (French Vegetable Stew)         - 280\n" +
                "12.  Veggie Stir-Fry (Asian Style)               - 320\n" +
                "13.  Stuffed Bell Peppers (Mediterranean)        - 300\n" +
                "14.  Grilled Vegetable Skewers                   - 270\n" +
                "15.  Vegetable Lasagna                           - 350\n" +
                "16.  Thai Green Curry with Vegetables            - 290\n" +
                "17.  Cream of Mushroom Soup                      - 180\n" +
                "18.  Veggie Tacos (Mexican Style)                - 250\n" +
                "19.  Veggie Sushi Rolls                          - 220\n" +
                "20.  Greek Salad                                 - 200\n";
        ;
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
            System.out.printf("%-45s %5d INR\n", vegMenu[i], vegPrice[i]);
            // System.out.println(vegMenu[i] + " " + vegPrice[i] + " INR");
        }
    }

    static void nonVegetarian() {
        System.out.println("You chose Non-Vegetarian food:-");
        System.out.println(
                "In Non-Vegetarian we have more than 100 dishes, kindly choose your favourite from the given list......");
        System.out.println("Here’s a list of popular Non-vegetable-based dishes");

        String menu = "1.   Butter Chicken                           - 350\n" +
                "2.   Chicken Tikka Masala                    - 320\n" +
                "3.   Rogan Josh (Red Lamb)                    - 400\n" +
                "4.   Chicken Do Pyaza                        - 310\n" +
                "5.   Chicken Chettinad                       - 330\n" +
                "6.   Malai Kofta                             - 280\n" +
                "7.   Mutton Korma                            - 420\n" +
                "8.   Goan Fish Curry                         - 370\n" +
                "9.   Amritsari Fish                          - 360\n" +
                "10.  Chicken Biryani                         - 380\n\n" +
                "11.  Spaghetti and Meatballs                 - 340\n" +
                "12.  Beef Stroganoff                         - 410\n" +
                "13.  Chicken Parmesan                        - 360\n" +
                "14.  Chicken Alfredo                         - 350\n" +
                "15.  Chicken Quesadillas                     - 300\n" +
                "16.  Chicken Fried Rice                      - 280\n" +
                "17.  Chicken Fajitas                         - 310\n" +
                "18.  Chicken Enchiladas                      - 320\n" +
                "19.  Beef Tacos                              - 290\n" +
                "20.  Beef Wellington                         - 450\n";

        nonVegMenu = menu.split("\n");

        String[] nonVegMenuItems = menu.split("\n");

        int index = 0;
        for (String item : nonVegMenuItems) {
            if (item.contains("-")) {
                String[] parts = item.split(" - ");
                if (parts.length == 2) {
                    nonVegMenu[index] = parts[0].trim();
                    nonVegPrice[index] = Integer.parseInt(parts[1].trim());
                    index++;
                }
            }
        }

        for (int i = 0; i < nonVegMenu.length - 1; i++) {
            System.out.printf("%-45s %5d INR\n", nonVegMenu[i], nonVegPrice[i]);
            // System.out.println(nonVegMenu[i] + " " + nonVegPrice[i] + "INR");
        }
    }

}

class Bill {
    // Menu menu = new Menu();
    String[] item = Menu.vegMenu;
    int[] price = Menu.vegPrice;

    double calculateBill(String food_type, int[] selectedFood) {
        int billTotal = 0;
        for (int i = 0; i < selectedFood.length; i++) {
            int dishIndex = selectedFood[i] - 1;
            if (dishIndex >= 0 && dishIndex < Menu.vegMenu.length) {
                if (food_type == "vegetarian") {
                    System.out.println(Menu.vegMenu[dishIndex] + " - Rs." + Menu.vegPrice[dishIndex]);
                    billTotal += Menu.vegPrice[dishIndex];
                } else {
                    System.out.println(Menu.nonVegMenu[dishIndex] + " - Rs." + Menu.nonVegPrice[dishIndex]);
                    billTotal += Menu.nonVegPrice[dishIndex];
                }
            } else {
                System.out.println("Invalid dish selected.");
            }

        }
        System.out.println("Your total bill is: " + billTotal);
        return billTotal;
    }
}

class Payment {
    Scanner sc = new Scanner(System.in);
    double cardBalance = 50000;
    double netBankingBalance = 60000;
    double upiBalance = 30000; 

    boolean isValidCardNumber(long cardNo) {
        return String.valueOf(cardNo).length() == 16;
    }

    boolean isValidPIN(int pin) {
        return String.valueOf(pin).length() == 4;
    }

    void payCreditCard(double billTotal) {
        System.out.println("Enter valid details of your Credit Card:");
        
        long cardNo;
        do {
            System.out.print("Enter your 16-digit card number: ");
            cardNo = sc.nextLong();
            if (!isValidCardNumber(cardNo)) {
                System.out.println("Invalid card number! Please enter a 16-digit number.");
            }
        } while (!isValidCardNumber(cardNo));

        int cardPin;
        do {
            System.out.print("Enter your 4-digit PIN: ");
            cardPin = sc.nextInt();
            if (!isValidPIN(cardPin)) {
                System.out.println("Invalid PIN! Please enter a 4-digit PIN.");
            }
        } while (!isValidPIN(cardPin));

        if (cardBalance >= billTotal) {
            cardBalance -= billTotal;
            System.out.println("Payment successful! Remaining Balance: ₹" + cardBalance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void payDebitCard(double billTotal) {
        System.out.println("Enter valid details of your Debit Card:");

        long cardNo;
        do {
            System.out.print("Enter your 16-digit card number: ");
            cardNo = sc.nextLong();
            if (!isValidCardNumber(cardNo)) {
                System.out.println("Invalid card number! Please enter a 16-digit number.");
            }
        } while (!isValidCardNumber(cardNo));

        int cardPin;
        do {
            System.out.print("Enter your 4-digit PIN: ");
            cardPin = sc.nextInt();
            if (!isValidPIN(cardPin)) {
                System.out.println("Invalid PIN! Please enter a 4-digit PIN.");
            }
        } while (!isValidPIN(cardPin));

        if (cardBalance >= billTotal) {
            cardBalance -= billTotal;
            System.out.println("Payment successful! Remaining Balance: ₹" + cardBalance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void payNetBanking(double billTotal) {
        System.out.println("Enter your Net Banking credentials:");
        System.out.print("Enter User ID: ");
        String userId = sc.next();
        System.out.print("Enter Password: ");
        String password = sc.next();

        if (netBankingBalance >= billTotal) {
            netBankingBalance -= billTotal;
            System.out.println("Payment successful! Remaining Balance: ₹" + netBankingBalance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void payUPI(double billTotal) {
        System.out.println("Enter your UPI ID (e.g., yourname@upi):");
        String upiId;
        do {
            upiId = sc.next();
            if (!upiId.matches("^[a-zA-Z0-9]+@[a-zA-Z]+$")) {
                System.out.println("Invalid UPI ID! Please enter in the correct format (e.g., yourname@upi).");
            }
        } while (!upiId.matches("^[a-zA-Z0-9]+@[a-zA-Z]+$"));

        System.out.print("Enter your 4-digit UPI PIN: ");
        int upiPin;
        do {
            upiPin = sc.nextInt();
            if (!isValidPIN(upiPin)) {
                System.out.println("Invalid PIN! Please enter a 4-digit PIN.");
            }
        } while (!isValidPIN(upiPin));

        if (upiBalance >= billTotal) {
            upiBalance -= billTotal;
            System.out.println("Payment successful! Remaining Balance: ₹" + upiBalance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void payCash(double billTotal) {
        double amount;
        do {
            System.out.println("Enter cash amount:");
            amount = sc.nextDouble();
            if (amount < billTotal) {
                System.out.println("Insufficient amount! Please enter at least ₹" + billTotal);
            }
        } while (amount < billTotal);

        System.out.println("Payment successful! Change returned: ₹" + (amount - billTotal));
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
