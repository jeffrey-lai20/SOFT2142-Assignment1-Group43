public class ItemImpl implements Item {
    private String name;
    private double price;
    private TYPE type;
    private double quantity;
    
    public ItemImpl(String name, double price, TYPE type, double quantity) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public TYPE getType() {
        return this.type;
    }

    @Override
    public double getQuantity() {
        return this.quantity;

    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setType(TYPE t) {
        this.type = t;
    }


    @Override
    public void setQuantity(double quantity) {
        this.quantity = quantity;

    }

}