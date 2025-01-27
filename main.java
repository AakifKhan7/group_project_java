import java.util.*;

class restaurant {
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

    

    void selectFood(){
        System.out.println("Choose your Food from given menu");
        System.out.println("Choose number for given type of food\n\t1.vegetarian\n2.Non-Vegetarian ");
        int choiceFood = sc.nextInt();


        if(choiceFood==1){
            menu.vegetarianFood();
        }
        else if(choiceFood==2){
            menu.nonVegetarian();
        }
        else{
            System.out.println("Invalid choice");
        }


        System.out.print("Enter Given number of your dishes:");
        int selectedDish=sc.nextInt();
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

class Menu{
    String[] vegMenu;
    String[] nonVegMenu;
    void vegetarianFood() {
        System.out.println("You chose Vegetarian food:-");
        System.out.println("In Vegetarian we have more than 100 dishes,kindly chose your favourite from given list......");
        System.out.println("Here’s a list of popular vegetable-based dishes");
        String menu = "### **Indian Vegetable Dishes**\n" +
                "1. Paneer Butter Masala\n" +
                "2. Aloo Gobi (Potato & Cauliflower Curry)\n" +
                "3. Baingan Bharta (Roasted Eggplant Curry)\n" +
                "4. Palak Paneer (Spinach with Cottage Cheese)\n" +
                "5. Chana Masala (Chickpea Curry)\n" +
                "6. Veg Biryani\n" +
                "7. Dum Aloo (Potato Curry)\n" +
                "8. Bhindi Masala (Okra Curry)\n" +
                "9. Mixed Vegetable Curry\n" +
                "10. Matar Paneer (Peas and Cottage Cheese Curry)\n\n" +
                "### **International Vegetable Dishes**\n" +
                "11. Ratatouille (French Vegetable Stew)\n" +
                "12. Veggie Stir-Fry (Asian Style)\n" +
                "13. Stuffed Bell Peppers (Mediterranean Style)\n" +
                "14. Grilled Vegetable Skewers\n" +
                "15. Vegetable Lasagna\n" +
                "16. Thai Green Curry with Vegetables\n" +
                "17. Cream of Mushroom Soup\n" +
                "18. Veggie Tacos (Mexican Style)\n" +
                "19. Veggie Sushi Rolls\n" +
                "20. Greek Salad\n\n" +
                "### **Snacks and Starters**\n";
                vegMenu = menu.split("\n");
                for(String item : vegMenu){
                    System.out.println(item);
                }
    }

    void nonVegetarian(){
        System.out.println("You chose Non-Vegetarian food:-");
        System.out.println( "In Non-Vegetarian we have more than 100 dishes,kindly chose your favourite from given list......");
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


class Payment{
    Scanner sc = new Scanner(System.in);
    void payCash(int billTotal){
        double amount = 0;
        do{
            System.out.println("Enter amount");
            amount = sc.nextDouble();
        }while (amount < billTotal);
            
        if(amount >= billTotal){
            System.out.println(amount - billTotal + "You get return");
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
