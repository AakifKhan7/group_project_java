import java.util.*;

// Restaurant: main class to display main menu and direct the flow
class Restaurant {
    // main: entry point; displays menu and processes user choice
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        System.out.println("1. Manager");
        System.out.println("2. Customer");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Manager");
                Manager manager = new Manager();
                manager.management();
                break;
            case 2:
                Customer customer = new Customer();
                break;
            case 3:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}

// Customer: handles customer interactions
class Customer {
    Scanner sc = new Scanner(System.in);
    String food_type = "";
    int numberOfSelectedFood = 0;
    int[] selectedFood;
    
    // Constructor: displays customer menu and processes options
    Customer() {
        System.out.println("Welcome Customer");
        boolean isCustomer = true;
        while(isCustomer) {
            System.out.println("1. Select Food");
            System.out.println("2. Bill & Payment");
            System.out.println("3. Feedback");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // flush newline
            switch (choice) {
                case 1:
                    selectFood();
                    break;
                case 2:
                    payBill();
                    break;
                case 3:
                    feedback();
                    break;
                case 4:
                    System.out.println("Exit");
                    isCustomer = false;
                    Restaurant.main(null);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    // selectFood: allows selection of food items and displays bill
    void selectFood() {
        food_type = "";
        System.out.println("Choose number for given type of food\n1.vegetarian\n2.Non-Vegetarian ");
        System.out.print("Enter your choice(1 - 2): ");
        int choiceFood = sc.nextInt();
        sc.nextLine(); // flush newline
        System.out.println("Choose your Food from given menu");
        if (choiceFood == 1) {
            Menu.printVegMenu();
            food_type = "vegetarian";
        } else if (choiceFood == 2) {
            Menu.printNonVegMenu();
            food_type = "non-vegetarian";
        } else {
            System.out.println("Invalid choice");
            return;
        }
        System.out.print("How many items you want to order?: ");
        numberOfSelectedFood = sc.nextInt() ;
        sc.nextLine(); // flush newline
        selectedFood = new int[numberOfSelectedFood];
        for (int itemCount = 0; itemCount < numberOfSelectedFood; itemCount++) {
            System.out.print("Enter the number of your dish : ");
            int selectedDish = sc.nextInt();
            sc.nextLine(); // flush newline
            if ((food_type.equals("vegetarian") && selectedDish >= 1 && selectedDish <= Menu.vegMenu.length) ||
                (food_type.equals("non-vegetarian") && selectedDish >= 1 && selectedDish <= Menu.nonVegMenu.length)) {
                selectedFood[itemCount] = selectedDish;
            } else {
                System.out.println("Invalid dish number, please try again.");
                itemCount--;
            }
        }
        System.out.println();
        System.out.println("Your bil is: " + getBill());
    }
    
    // getBill: calculates and returns the total bill amount
    double getBill(){
        if (selectedFood == null || selectedFood.length == 0) {
            System.out.println("No food selected. Please select food first.");
            return 0;
        }
        Bill bill = new Bill(food_type, selectedFood);
        return bill.billTotal;
    }
    
    // payBill: processes the payment for the order
    void payBill(){
        System.out.println();
        if(selectedFood == null){
            System.out.println("no item selected");
            return;
        }
        Payment payment = new Payment(food_type, selectedFood);
    }
    
    // feedback: collects customer rating and feedback
    void feedback() {
        int rating = 0;
        do {
            System.out.print("please give star rating to our service");
            rating = sc.nextInt();
            sc.nextLine(); // flush newline
        } while (rating < 1 || rating > 5);
        System.out.print("Please provide your feedback:");
        String feedback = sc.nextLine();
        for (int i = 0; i < FeedBack.starRating.length; i++) {
            if (FeedBack.starRating[i] == 0) {
                FeedBack.starRating[i] = rating;
                FeedBack.feedback[i] = feedback;
                break;
            }
        }
        System.out.println("Thank you for your feedback!");
    }
}

// Menu: manages food menus and prices
class Menu {
    static int sizeOfVegPrice = 20;
    static String[] vegMenu = new String[sizeOfVegPrice];
    static int[] vegPrice = new int[sizeOfVegPrice];
    static int sizeOfNonVegPrice = 20;
    static String[] nonVegMenu = new String[sizeOfNonVegPrice];
    static int[] nonVegPrice = new int[sizeOfNonVegPrice];
    static boolean isInitialized = false;
    
    // Constructor: initializes menus if not already initialized
    Menu() {
        if (!isInitialized) {
            vegetarianFood();
            nonVegetarian();
            isInitialized = true;
        }
    }
    
    // vegetarianFood: initializes vegetarian menu items and prices (menu string unchanged)
    static void vegetarianFood() {
        String menu = "Paneer Butter Masala                          - 250\n" +
                "Aloo Gobi (Potato & Cauliflower)             - 200\n" +
                "Baingan Bharta (Roasted Eggplant)            - 220\n" +
                "Palak Paneer (Spinach & Cottage Cheese)      - 240\n" +
                "Chana Masala (Chickpea Curry)                - 210\n" +
                "Veg Biryani                                  - 300\n" +
                "Dum Aloo (Potato Curry)                      - 230\n" +
                "Bhindi Masala (Okra Curry)                   - 200\n" +
                "Mixed Vegetable Curry                        - 250\n" +
                "Matar Paneer (Peas & Cottage Cheese)        - 260\n\n" +
                // /# International Vegetarian Dishes\n" +
                "Ratatouille (French Vegetable Stew)         - 280\n" +
                "Veggie Stir-Fry (Asian Style)               - 320\n" +
                "Stuffed Bell Peppers (Mediterranean)        - 300\n" +
                "Grilled Vegetable Skewers                   - 270\n" +
                "Vegetable Lasagna                           - 350\n" +
                "Thai Green Curry with Vegetables            - 290\n" +
                "Cream of Mushroom Soup                      - 180\n" +
                "Veggie Tacos (Mexican Style)                - 250\n" +
                "Veggie Sushi Rolls                          - 220\n" +
                "Greek Salad                                 - 200\n";
        String[] vegMenuItems = menu.split("\n");
        int index = 0;
        for (String item : vegMenuItems) {
            if (item.contains("-")) {
                String[] parts = item.split(" - ");
                if (parts.length == 2) {
                    vegMenu[index] = parts[0].trim();
                    vegPrice[index] = Integer.parseInt(parts[1].trim());
                    index++;
                }
            }
        }
    }
    
    // printVegMenu: prints the vegetarian menu
    static void printVegMenu() {
        for (int i = 0; i < sizeOfVegPrice; i++) {
            System.out.printf("%-5d %-45s %5d INR\n", i + 1, vegMenu[i], vegPrice[i]);
        }
    }
    
    // nonVegetarian: initializes non-vegetarian menu items and prices (menu string unchanged)
    static void nonVegetarian() {
        String menu = "Butter Chicken                           - 350\n" +
                "Chicken Tikka Masala                    - 320\n" +
                "Rogan Josh (Red Lamb)                    - 400\n" +
                "Chicken Do Pyaza                        - 310\n" +
                "Chicken Chettinad                       - 330\n" +
                "Malai Kofta                             - 280\n" +
                "Mutton Korma                            - 420\n" +
                "Goan Fish Curry                         - 370\n" +
                "Amritsari Fish                          - 360\n" +
                "Chicken Biryani                         - 380\n\n" +
                "Spaghetti and Meatballs                 - 340\n" +
                "Beef Stroganoff                         - 410\n" +
                "Chicken Parmesan                        - 360\n" +
                "Chicken Alfredo                         - 350\n" +
                "Chicken Quesadillas                     - 300\n" +
                "Chicken Fried Rice                      - 280\n" +
                "Chicken Fajitas                         - 310\n" +
                "Chicken Enchiladas                      - 320\n" +
                "Beef Tacos                              - 290\n" +
                "Beef Wellington                         - 450\n";
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
    }
    
    // printNonVegMenu: prints the non-vegetarian menu
    static void printNonVegMenu() {
        for (int i = 0; i < sizeOfNonVegPrice; i++) {
            System.out.printf("%5d %-45s %5d INR\n", i + 1,nonVegMenu[i], nonVegPrice[i]);
        }
    }
}

// Bill: calculates the total bill based on selected items
class Bill {
    double billTotal = 0;
    String food_type = "";
    int[] selectedFood;
    
    // Constructor: initializes bill calculation
    Bill(String food_type, int[] selectedFood) {
        this.food_type = food_type;
        this.selectedFood = selectedFood;
        billTotal = calculateBill(food_type, selectedFood);
    }
    
    // calculateBill: sums the prices of selected dishes and returns the total
    double calculateBill(String food_type, int[] selectedFood) {
        for (int i = 0; i < selectedFood.length; i++) {
            int dishIndex = selectedFood[i] - 1;
            if (dishIndex >= 0 && dishIndex < Menu.vegMenu.length) {
                if (food_type.equals("vegetarian")) {
                    System.out.println(Menu.vegMenu[dishIndex] + " - Rs." + Menu.vegPrice[dishIndex]);
                    this.billTotal += Menu.vegPrice[dishIndex];
                } else {
                    System.out.println(Menu.nonVegMenu[dishIndex] + " - Rs." + Menu.nonVegPrice[dishIndex]);
                    this.billTotal += Menu.nonVegPrice[dishIndex];
                }
            } else {
                System.out.println("Invalid dish selected.");
            }
        }
        System.out.println("Your total bill is: " + billTotal);
        return billTotal;
    }
}

// FeedBack: stores customer ratings and feedback
class FeedBack {
    static int[] starRating = new int[50];
    static String[] feedback = new String[50];
}

// Manager: handles manager operations
class Manager {
    Scanner sc = new Scanner(System.in);
    String password = "Admin123";
    
    // Constructor: verifies password for management access
    Manager() {
        System.out.print("Enter password to access management: ");
        String enteredPassword = sc.nextLine();
        if (!enteredPassword.equals(password)) {
            System.out.println("Incorrect password! Access denied.");
            Restaurant.main(null);
        }
        System.out.println("Access granted!");
        System.out.println("\nWelcome Manager");
    }
    
    // management: displays manager menu and processes the choice
    void management() {
        boolean isManager = true;
        while(isManager){
            System.out.println("1. Add Food");
            System.out.println("2. Remove Food");
            System.out.println("3. Update Food");
            System.out.println("4. View Feedback");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // flush newline
            switch (choice) {
                case 1:
                    System.out.println("Add Food");
                    addFood();
                    break;
                case 2:
                    System.out.println("Remove Food");
                    removeFood();
                    break;
                case 3:
                    System.out.println("Update Food");
                    updateFood();
                    break;
                case 4:
                    System.out.println("View Feedback");
                    getFeedback();
                    break;
                case 5:
                    System.out.println("Exit");
                    isManager = false;
                    Restaurant.main(null);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    // getFeedback: displays all customer feedback
    void getFeedback() {
        for (int i = 0; i < FeedBack.starRating.length; i++) {
            if (FeedBack.starRating[i] != 0) {
                System.out.println("Rating: " + FeedBack.starRating[i]);
                System.out.println("Feedback: " + FeedBack.feedback[i]);
                System.out.println();
            }
        }
    }
    
    // addFood: adds a new food item to the menu
    void addFood() {
        System.out.print("Enter food type (1. Vegetarian, 2. Non-Vegetarian): ");
        int foodType = sc.nextInt();
        sc.nextLine(); // flush newline
        System.out.print("Enter food name: ");
        String foodName = sc.nextLine();
        System.out.print("Enter price: ");
        int price = sc.nextInt();
        sc.nextLine(); // flush newline
        if (foodType == 1) {
            Menu.sizeOfVegPrice++;
            Menu.vegMenu = Arrays.copyOf(Menu.vegMenu, Menu.sizeOfVegPrice);
            Menu.vegPrice = Arrays.copyOf(Menu.vegPrice, Menu.sizeOfVegPrice);
            Menu.vegMenu[Menu.sizeOfVegPrice - 1] = foodName;
            Menu.vegPrice[Menu.sizeOfVegPrice - 1] = price;
            return;
        } else if (foodType == 2) {
            Menu.sizeOfNonVegPrice++;
            Menu.nonVegMenu = Arrays.copyOf(Menu.nonVegMenu, Menu.sizeOfNonVegPrice);
            Menu.nonVegPrice = Arrays.copyOf(Menu.nonVegPrice, Menu.sizeOfNonVegPrice);
            Menu.nonVegMenu[Menu.sizeOfNonVegPrice - 1] = foodName;
            Menu.nonVegPrice[Menu.sizeOfNonVegPrice - 1] = price;
            return;
        } else {
            System.out.println("Invalid choice");
        }
    }
    
    // removeFood: removes a food item from the menu
    void removeFood() {
        System.out.print("Enter food type (1. Vegetarian, 2. Non-Vegetarian): ");
        int foodType = sc.nextInt();
        sc.nextLine(); // flush newline
        System.out.print("Enter food number from menu to remove: ");
        int foodIndex = sc.nextInt() - 1;
        sc.nextLine(); // flush newline
        if (foodType == 1) {
            System.out.println(Menu.vegMenu[foodIndex] + " removed from the menu.");
            for (int i = 0; i < Menu.sizeOfVegPrice; i++) {
                if (Menu.vegMenu[i] != null && foodIndex == i) {
                    for (int j = i; j < Menu.sizeOfVegPrice - 1; j++) {
                        Menu.vegMenu[j] = Menu.vegMenu[j + 1];
                        Menu.vegPrice[j] = Menu.vegPrice[j + 1];
                    }
                    Menu.sizeOfVegPrice--;
                    Menu.vegMenu = Arrays.copyOf(Menu.vegMenu, Menu.sizeOfVegPrice);
                    Menu.vegPrice = Arrays.copyOf(Menu.vegPrice, Menu.sizeOfVegPrice);
                    return;
                }
            }
        } else if (foodType == 2) {
            System.out.println(Menu.nonVegMenu[foodIndex] + " removed from the menu.");
            for (int i = 0; i < Menu.sizeOfNonVegPrice; i++) {
                if (Menu.nonVegMenu[i] != null && foodIndex == i) {
                    for (int j = i; j < Menu.sizeOfNonVegPrice - 1; j++) {
                        Menu.nonVegMenu[j] = Menu.nonVegMenu[j + 1];
                        Menu.nonVegPrice[j] = Menu.nonVegPrice[j + 1];
                    }
                    Menu.sizeOfNonVegPrice--;
                    Menu.nonVegMenu = Arrays.copyOf(Menu.nonVegMenu, Menu.sizeOfNonVegPrice);
                    Menu.nonVegPrice = Arrays.copyOf(Menu.nonVegPrice, Menu.sizeOfNonVegPrice);
                    return;
                }
            }
        }
        System.out.println("Item not found in the menu.");
    }
    
    // updateFood: updates the price of an existing food item
    void updateFood() {
        System.out.print("Enter food type (1. Vegetarian, 2. Non-Vegetarian): ");
        int foodType = sc.nextInt();
        sc.nextLine(); // flush newline
        System.out.print("Enter item number from menu to update: ");
        int foodIndex = sc.nextInt() - 2;
        sc.nextLine(); // flush newline
        System.out.print("Enter new price: ");
        int newPrice = sc.nextInt();
        sc.nextLine(); // flush newline
        if (foodType == 1) {
            for (int i = 0; i < Menu.sizeOfVegPrice; i++) {
                if (Menu.vegMenu[i] != null && foodIndex == i) {
                    Menu.vegPrice[i] = newPrice;
                    System.out.println(Menu.vegMenu[i] + " price updated to " + newPrice + " INR.");
                    return;
                }
            }
        } else if (foodType == 2) {
            for (int i = 0; i < Menu.sizeOfNonVegPrice; i++) {
                if (Menu.nonVegMenu[i] != null && foodIndex == i) {
                    Menu.nonVegPrice[i] = newPrice;
                    System.out.println(Menu.nonVegMenu[i] + " price updated to " + newPrice + " INR.");
                    return;
                }
            }
        }
        System.out.println("Item not found in the menu.");
    }
}

// Payment: processes payment methods (extends Bill)
class Payment extends Bill {
    Scanner sc = new Scanner(System.in);
    double cardBalance = 50000;
    double netBankingBalance = 60000;
    double upiBalance = 30000;
    
    // Constructor: displays payment options and processes the selection
    Payment(String food_type, int[] selectedFood) {
        super(food_type, selectedFood);
        System.out.println("Choose your payment method");
        String methodToPay = " 1. Credit Card\n 2. Debit Card\n 3. Net Banking\n 4. UPI\n 5. Cash";
        System.out.println(methodToPay);
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // flush newline
        switch (choice) {
            case 1:
                System.out.println("Credit Card");
                payCreditCard();
                break;
            case 2:
                System.out.println("Debit Card");
                payDebitCard();
                break;
            case 3:
                System.out.println("Net Banking");
                payNetBanking();
                break;
            case 4:
                System.out.println("UPI");
                payUPI();
                break;
            case 5:
                System.out.println("Cash");
                payCash();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    
    // isValidCardNumber: validates a 16-digit card number
    boolean isValidCardNumber(long cardNo) {
        return String.valueOf(cardNo).length() == 16;
    }
    
    // isValidPIN: validates a 4-digit PIN
    boolean isValidPIN(int pin) {
        return String.valueOf(pin).length() == 4;
    }
    
    // payCreditCard: processes credit card payment
    void payCreditCard() {
        System.out.print("Enter valid details of your Credit Card:\n");
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
        if (cardBalance >= super.billTotal) {
            cardBalance -= super.billTotal;
            System.out.println("Payment successful! Remaining Balance: ₹" + cardBalance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    
    // payDebitCard: processes debit card payment
    void payDebitCard() {
        System.out.print("Enter valid details of your Debit Card:\n");
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
        if (cardBalance >= super.billTotal) {
            cardBalance -= super.billTotal;
            System.out.println("Payment successful! Remaining Balance: " + cardBalance + " Rs.");
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    
    // payNetBanking: processes net banking payment
    void payNetBanking() {
        System.out.print("Enter your Net Banking credentials:\n");
        System.out.print("Enter User ID: ");
        String userId = sc.next();
        System.out.print("Enter Password: ");
        String password = sc.next();
        if (netBankingBalance >= super.billTotal) {
            netBankingBalance -= super.billTotal;
            System.out.println("Payment successful! Remaining Balance: ₹" + netBankingBalance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    
    // payUPI: processes UPI payment
    void payUPI() {
        System.out.print("Enter your UPI ID (e.g., yourname@upi): ");
        String upiId;
        do {
            upiId = sc.next();
            if (!upiId.matches("^[a-zA-Z0-9]+@[a-zA-Z]+$")) {
                System.out.println("Invalid UPI ID! Please enter in the correct format (e.g., yourname@upi).");
                System.out.print("Enter your UPI ID (e.g., yourname@upi): ");
            }
        } while (!upiId.matches("^[a-zA-Z0-9]+@[a-zA-Z]+$"));
        System.out.print("Enter your 4-digit UPI PIN: ");
        int upiPin;
        do {
            upiPin = sc.nextInt();
            if (!isValidPIN(upiPin)) {
                System.out.println("Invalid PIN! Please enter a 4-digit PIN.");
                System.out.print("Enter your 4-digit UPI PIN: ");
            }
        } while (!isValidPIN(upiPin));
        if (upiBalance >= billTotal) {
            upiBalance -= billTotal;
            System.out.println("Payment successful! Remaining Balance: ₹" + upiBalance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    
    // payCash: processes cash payment
    void payCash() {
        double amount;
        do {
            System.out.print("Enter cash amount: ");
            amount = sc.nextDouble();
            if (amount < super.billTotal) {
                System.out.println("Insufficient amount! Please enter at least ₹" + super.billTotal);
            }
        } while(amount < billTotal);
        System.out.println("Payment successful! Change returned: ₹" + (amount - super.billTotal));
    }
}
