
import java.util.ArrayList;

public class Customer {
    private String id;
    private String name;
    private ArrayList<Product> cart;

    public Customer(String Id, String Name){
        id = Id;
        name = Name;
        cart = new ArrayList<Product>(0);
    }

    public void addToCart(Product prod){
        cart.add(prod);
    }

    public void display(){
        System.out.println("id : " + id);
        System.out.println("name : " + name);
        System.out.print("cart: ");
        for(Product prod: cart){
            System.out.print(prod.getName() + ", ");
        }
        System.out.println();
    }
}