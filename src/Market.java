import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Market {
    private ArrayList <Category> categories;
    private ArrayList <Product>  products;
    private ArrayList <Customer> customers;

    public Market()
    {
        categories = new ArrayList<Category>(0);
        products = new ArrayList<Product>(0);
        customers = new ArrayList<Customer>(0);
    }

    public void readAllProducts()
    {
        try
        {
            File file = new File ("FileProducts.txt");
            Scanner input = new Scanner(file);


            while(input.hasNextLine() )
            {
                
                String id1 = input.nextLine();
                String name1 = input.nextLine();

                String data = input.nextLine();
                ArrayList<Category> cats = new ArrayList<Category>(0);

                while(!data.equals("+"))
                {
                    for (Category cat: categories)
                    {
                        if(cat.hasName(data))
                        {
                            cats.add(cat);
                            break;
                        }
                    }
                    data = input.nextLine();
                }

                data = input.nextLine();
                ArrayList<String> elts = new ArrayList<String>();
                while(!data.equals("="))
                {
                    elts.add(data);
                    data = input.nextLine();
                }

                Product product = new Product (id1, name1, elts,cats);

                products.add(product);
                
            }
            input.close();
            associateProducts();
        }
        catch(FileNotFoundException e )
        {
            System.out.println(e.getMessage());
        }


    }

    public void readCategories()
    {
        try
        {
            File file = new File ("FileCategories.txt");
            Scanner input = new Scanner(file);

            while(input.hasNextLine() )
            {
                String name = input.nextLine();
                Category category = new Category (name);
                categories.add(category);
            }
            input.close();
        }
        catch(FileNotFoundException e )
        {
            System.out.println(e.getMessage());
        }

    }

    public void readCustomers()
    {
        try
        {
            File file = new File ("Customers.txt");
            Scanner input = new Scanner(file);

            while(input.hasNextLine() )
            {
                String id = input.nextLine();
                String name = input.nextLine();
                Customer customer = new Customer (id, name);
                String data = input.nextLine();
                while(!data.equals("=")){
                    for(Product product: products){
                        if (product.getId().equals(data)){
                            customer.addToCart(product);
                            break;
                        }
                    }
                    data = input.nextLine();
                }
                customers.add(customer);
            }
            input.close();
        }
        catch(FileNotFoundException e )
        {
            System.out.println(e.getMessage());
        }

    }

    public void displayProducts()
    {
        for (Product prod : products)
        {
            prod.display();
        }
    }

    public void displayCustomers()
    {
        for (Customer customer : customers)
        {
            customer.display();
            System.out.println();
        }
    }

    public void associateProducts(){
        for(Product product: products){
            for(String name: product.getAssosciatedNames()){
                for(Product associated: products){
                    if(name.equals(associated.getName())){
                        product.addAssociated(associated);
                    }
                }
            }
        }
    }


    public void displayProductList()
    {
        for (Product prod : products)
        {
            System.out.println("- " + prod.getName());
        }
    }

    public ArrayList<String> recommand (String productName)
    {

        ArrayList<String> recommandations = new ArrayList<String>(0);

        for(Product product : products)
        {
            if (productName.equals(product.getName()))
            {
                recommandations = product.getAssosciatedNames();
            }
        }
        return recommandations;
    }

    public void displayRecommandations(String productName)
    {
        System.out.println("Other product that coult intererst you :");
        
        ArrayList<String> recommandations = recommand(productName);
        
        for (String reco : recommandations)
        {
            System.out.println("- " + reco);
        }
    }
}
