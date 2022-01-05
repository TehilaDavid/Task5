public class Product {
    private String description;
    private int price;
    private int discountPercentages;
    private boolean isInStock;
    private int amount;

    public Product(String description,int price, int discountPercentages){
        this.description = description;
        this.price = price;
        this.discountPercentages = discountPercentages;
        isInStock = true;
    }


    public void isInStock (boolean isInStock) {
        this.isInStock = isInStock;
    }
}

