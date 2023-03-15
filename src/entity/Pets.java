package entity;

public class Pets {
    private int id;
    private String name;
    private int age;
    private String color;
    private String race;
    private int price;
    private int Sales_status;


    public Pets() {

    }

    public Pets(int id, String name, int age, String color, String race, int price, int sales_status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.color = color;
        this.race = race;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
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
        return "编号：" + this.id + " 姓名："+ this.name+ " 年龄："+this.age +" 颜色："+this.color+" 种族："+this.race+" 价格："+ this.price+" 销售状态："+this.Sales_status;
    }
}
