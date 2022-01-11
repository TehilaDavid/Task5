public class Product {
    private String description;
    private int price;
    private double discountPercentages;
    private boolean isInStock;


    public Product(String description,int price, double discountPercentages){
        this.description = description;
        this.price = price;
        this.discountPercentages = discountPercentages;
        isInStock = true;
    }

    public String getDescription(){
        return this.description;
    }

    public int getPrice(){
        return this.price;
    }

    public boolean isInStock() {
        return this.isInStock;
    }

    public void isInStock (boolean isInStock) {
        this.isInStock = isInStock;
    }

    public double getDiscountPercentages() {
        return this.discountPercentages;
    }

    public String toString (){
        String output = this.description + "- " + "\n" + "price:" + this.price + ", there is " + this.discountPercentages + "% discount for club members.\n";
        return output;
    }
}