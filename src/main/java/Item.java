public interface Item {
    public String getName();
    public double getPrice();
    public TYPE getType();
    public void getQuantity();
    public void setName(String name);
    public void setPrice(double price);
    public void setType(TYPE t);
    public void setQuantity(double quantity);

    public enum TYPE {
        DRINKS,
        CHOCOLATES,
        CHIPS,
        LOLLIES,
    }
}
