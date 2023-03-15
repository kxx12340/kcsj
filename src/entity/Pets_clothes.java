package entity;

public class Pets_clothes {
    private int id;
    private String style;
    private String size;
    private String color;
    private int price;
    private int Sales_status;

    public Pets_clothes() {
    }

    public Pets_clothes(int id, String style, String size, String color, int price, int sales_status) {
        this.id = id;
        this.style = style;
        this.size = size;
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getSize() {
        return size;
    }

    public void setSize() {
        this.size = size;
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
        return "编号："+this.id+" 样式："+this.style+" 尺码："+this.size+" 颜色："+this.color+" 价格："+this.price+" 销售状态："+this.Sales_status;
    }
}
