public interface Item {
    public String getName();
    public double getPrice();
    public TYPE getType();
    public Integer getQuantity();
    public void setName(String name);
    public void setPrice(double price);
    public void setType(TYPE t);
    public void setQuantity(Integer quantity);
    void setCode(String code);
    String getCode();

    public enum TYPE {
        DRINKS,
        CHOCOLATES,
        CHIPS,
        LOLLIES,
    }
}
