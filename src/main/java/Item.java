public interface Item {
    public String getName();
    public double getPrice();
    public TYPE getType();
    public void setName(String name);
    public void setPrice(double price);
    public void setType(TYPE t);

    public enum TYPE {
        DRINKS,
        CHOCOLATES,
        CHIPS,
        LOLLIES,
    }
}
