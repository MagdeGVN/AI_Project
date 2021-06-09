public class Category {
    private String name;

    public Category(String name)
    {
        this.name = name;
    }

    public boolean hasName(String name1)
    {
        return name1.equals(name);
    }

    public void display()
    {
        System.out.println(name);
    }
}
