package store;

public class Product {
    private String ID;
    private String name;
    private String imageURL;
    private Double price;
    public Product(String id, String name, String image, Double price){
        ID = id;
        this.name = name;
        imageURL = image;
        this.price = price;
    }
    public String getID(){return ID;}
    public String getName(){return name;}
    public String getimage(){return imageURL;}
    public Double getPrice(){return price;}
}
