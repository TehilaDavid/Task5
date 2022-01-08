public class Product {
    private String description;
    private int price;
    private int discountPercentages;
    private boolean isInStock;


    public Product(String description,int price, int discountPercentages){
        this.description = description;
        this.price = price;
        this.discountPercentages = discountPercentages;
        isInStock = true;
    }

    public int getPrice() {
        return price;
    }

    public boolean isInStock() {
        return this.isInStock;
    }

    public void isInStock (boolean isInStock) {
        this.isInStock = isInStock;
    }

    public String toString (){
        String output = "* " + this.description + " *" + "\n" + "the price is " + this.price + ", there is " + this.discountPercentages + "% discount for club members.";
        return output;
    }
}

