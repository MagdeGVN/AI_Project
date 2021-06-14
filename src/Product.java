import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Product {
    private String id;
    private String name;
    private ArrayList<String> associatedNames;
    private ArrayList<Product> associatedProducts;
    private ArrayList<Category> categories;

    public Product(String id, String name, ArrayList<String> aNames,ArrayList<Category> cats)
    {
        this.id = id;
        this.name = name;

        associatedNames = new ArrayList<String>(0);
        for (int i=0; i<aNames.size(); i++)
        {
            associatedNames.add(aNames.get(i));
        }
        
        associatedProducts = new ArrayList<Product>(0);

        categories = cats;
    }

    public void display()
    {
        System.out.println("id : "+ id);
        System.out.println("name : "+ name);
        int i =0;
        for (Category cat : categories)
        {
            i++;
            System.out.print("Category "+i+" : ");
            cat.display();
        }
        i = 0;
        for (Product product : associatedProducts)
        {
            i++;
            System.out.println("Associated product "+ i + " : " + product.getName());
        }
        

    }

    public ArrayList <String> getAssosciatedNames(){
        return associatedNames;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public void addAssociated(Product prod){
        associatedProducts.add(prod);
    }
}
