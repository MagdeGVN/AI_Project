import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        Market market = new Market();
        market.readCategories();
        market.readAllProducts();
        market.readCustomers();
        //market.displayProducts();
        //market.displayCustomers();

         
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Hello! What do you want to purchase?");
        market.displayProductList();
        String productName = keyboard.nextLine();

        System.out.print("\033\143");

        System.out.println("Your product is added to your cart...\n");
        market.displayRecommandations(productName);



    }
}
