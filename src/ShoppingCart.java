public class ShoppingCart {
    private Product[] products;
    double totalPrice;
    //תאריך הרכישה

    public ShoppingCart (){
        this.products = new Product[0];
    }

    public void setProducts (Product productToAdd) {
        Product[] newProducts = new Product[this.products.length + 1];
        for (int i = 0; i < this.products.length; i++) {
            newProducts[i] = this.products[i];
        }
        newProducts[this.products.length] = productToAdd;
        this.products = newProducts;
    }

    public double getTotalPrice(){
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Product[] getProducts() {
        return this.products;
    }

    public String toString () {
        int listCounter = 0;
        String output = "";

        for (int i = 0; i < this.products.length; i++) {
            listCounter++;
            output += (listCounter + "." + this.products[i].getDescription() + "\n");
        }
        output += "-------------------------" + "\n" + "total:" + this.totalPrice + "\n";

        return output;
    }



}