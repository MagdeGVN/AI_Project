import java.util.ArrayList;

public class Product {
    private int id;
    private String name;
    private ArrayList<String> associatedNames;
    private ArrayList<Product> associatedProducts;
    private ArrayList<Category> category;

    public Product(int id, String name, ArrayList<String> aNames, ArrayList<Product> aProducts)
    {
        this.id = id;
        this.name = name;

        associatedNames = new ArrayList<String>(0);
        for (int i=0; i<aNames.size(); i++)
        {
            associatedNames.add(aNames.get(i));
        }
        
        associatedProducts = new ArrayList<Product>(0);
        for (int i=0; i<aProducts.size(); i++)
        {
            associatedProducts.add(aProducts.get(i));
        }

        category = new ArrayList<Category>(0);
    }
}
