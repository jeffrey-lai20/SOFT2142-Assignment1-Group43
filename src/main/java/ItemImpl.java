public class ItemImpl implements Item {
    private String name;
    private double price;
    private TYPE type;
    
    public ItemImpl(String name, double price, TYPE type) {
        this.name = name;
        this.price = price;
        this.type = type;
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

}