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
class Customer{

}
class Manager{
    Scanner sc=new Scanner(System.in);
    void management(){
    System.out.println("Choose your Food from given menue");
    System.out.println("Choose number for given type of food\n\t1.vegetarian\n2.Non-Vegetarian ");
    int choiceFood = sc.nextInt();
    if(choiceFood==1){
        System.out.println("You chose Vegetatian food:-");
        System.out.println("In Vegtarian we have more than 100 dishes,kindly chose your favourite from given list......");
        System.out.println("Here’s a list of popular vegetable-based dishes 
        ### **Indian Vegetable Dishes**
        1. Paneer Butter Masala  
        2. Aloo Gobi (Potato & Cauliflower Curry)  
        3. Baingan Bharta (Roasted Eggplant Curry)  
        4. Palak Paneer (Spinach with Cottage Cheese)  
        5. Chana Masala (Chickpea Curry)  
        6. Veg Biryani  
        7. Dum Aloo (Potato Curry)  
        8. Bhindi Masala (Okra Curry)  
        9. Mixed Vegetable Curry  
        10. Matar Paneer (Peas and Cottage Cheese Curry)  
        
        ### **International Vegetable Dishes**
        11. Ratatouille (French Vegetable Stew)  
        12. Veggie Stir-Fry (Asian Style)  
        13. Stuffed Bell Peppers (Mediterranean Style)  
        14. Grilled Vegetable Skewers  
        15. Vegetable Lasagna  
        16. Thai Green Curry with Vegetables  
        17. Cream of Mushroom Soup  
        18. Veggie Tacos (Mexican Style)  
        19. Veggie Sushi Rolls  
        20. Greek Salad  
        
        ### **Snacks and Starters**
        21. Veg Spring Rolls  
        22. Veggie Samosas  
        23. Corn and Spinach Fritters  
        24. Hummus with Veggie Sticks  
        25. Vegetable Manchurian  "

        System.out.print("Enter Given number of your dishes:")
        int selectedDish=sc.nextInt();
    }
    }
}