public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        Market market = new Market();
        market.readCategories();
        market.readAllProducts();
        market.readCustomers();
        market.displayProducts();
        market.displayCustomers();
    }
}
