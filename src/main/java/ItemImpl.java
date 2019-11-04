public class ItemImpl implements Item {
    private String name;
    private double price;
    private TYPE type;
    private Integer quantity;
    private String code;

    public ItemImpl(String name, double price, TYPE type, Integer quantity, String code) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
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
    public Integer getQuantity() {
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
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString(){
        return this.getCode()+" - "+this.getName()+" - Quantity: "+this.getQuantity()+" - Price: $"+this.getPrice()+"\n";
    }

}