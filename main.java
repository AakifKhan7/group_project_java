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
                System.out.println("Customer");
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

    Customer() {
        System.out.println("Welcome to virtual restaurant");
    }

    void vegetarianFood() {
        System.out.println("You chose Vegetarian food:-");
        System.out.println(
                "In Vegetarian we have more than 100 dishes,kindly chose your favourite from given list......");
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
    }

    void selectFood(){
        System.out.println("Choose your Food from given menu");
        System.out.println("Choose number for given type of food\n\t1.vegetarian\n2.Non-Vegetarian ");
        int choiceFood = sc.nextInt();


        if(choiceFood==1){
            vegetarianFood();
        }
        

        System.out.print("Enter Given number of your dishes:");
        int selectedDish=sc.nextInt();
    }

    void payment() {
    }

    void feedback() {
    }
}

class Manager {
    Scanner sc = new Scanner(System.in);

    void management() {

    }
}