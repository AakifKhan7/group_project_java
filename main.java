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
    System.out.println("Choose your Food from given menue");
    System.out.println("Choose number for given type of food\n\t1.vegetarian\n2.Non-Vegetarian ");
    int choiceFood = sc.nextInt();
    if(choiceFood==1){
        System.out.println("You chose Vegetatian food:-");
        System.out.println("In Vegtarian we have more than 100 dishes,kindly chose your favourite from given list......");
        Sytem.out.println("1. Indian Vegetarian Dishes:\n" + //
                        "Starters & Snacks:\n" + //
                        "\n" + //
                        "Paneer Tikka\n" + //
                        "Samosa\n" + //
                        "Aloo Tikki\n" + //
                        "Pakoras (Vegetable, Paneer, Onion)\n" + //
                        "Dhokla\n" + //
                        "Bhel Puri\n" + //
                        "Main Course:\n" + //
                        "\n" + //
                        "Paneer Butter Masala\n" + //
                        "Chole (Chickpea Curry)\n" + //
                        "Dal Makhani\n" + //
                        "Baingan Bharta (Mashed Eggplant)\n" + //
                        "Palak Paneer (Spinach and Cottage Cheese)\n" + //
                        "Veg Biryani\n" + //
                        "Rajma (Kidney Bean Curry)")
    }

}