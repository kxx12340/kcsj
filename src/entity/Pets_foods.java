package entity;

public class Pets_foods {
    private int id;
    private String name;
    private String flavor;
    private String type;
    private int price;
    private int Sales_status;

    public Pets_foods() {

    }

    public Pets_foods(int id, String name, String flavor, String type, int price, int sales_status) {
        this.id = id;
        this.name = name;
        this.flavor = flavor;
        this.type = type;
        this.price = price;
        Sales_status = sales_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSales_status() {
        return Sales_status;
    }

    public void setSales_status(int sales_status) {
        Sales_status = sales_status;
    }

    public String toString() {
        return "编号："+this.id+" 姓名："+this.name+" 味道："+this.flavor+" 类型："+this.type+" 价格："+this.price+" 销售状态："+this.Sales_status;
    }
}
