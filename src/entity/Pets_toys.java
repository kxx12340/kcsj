package entity;

public class Pets_toys {
    private int id;
    private String type;
    private String color;
    private int price;
    private int Sales_status;
    public Pets_toys() {
    }

    public Pets_toys(int id, String type, String color, int price, int sales_status) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.price = price;
        Sales_status = sales_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        return "编号："+this.id+" 类型："+this.type+" 颜色："+this.color+" 价格："+this.price+" 销售状态："+this.Sales_status;
    }
}
