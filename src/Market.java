import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Market {
    private ArrayList <Category> categories;
    private ArrayList <Product>  products;

    public Market()
    {
        categories = new ArrayList<Category>(0);
        products = new ArrayList<Product>(0);
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

    public void displayProducts()
    {
        for (Product prod : products)
        {
            prod.display();
        }
    }
}
