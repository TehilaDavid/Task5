public class ShoppingCart {
    private Product[] products;
    int totalPrice;
    //תאריך הרכישה

    public ShoppingCart (){
        this.products = new Product[0];
    }

    public void setProducts (Product productToAdd){
        Product[] newProducts = new Product[this.products.length + 1];
        for (int i = 0; i < this.products.length; i++) {
            newProducts[i] = this.products[i];
        }
        newProducts[this.products.length] = productToAdd;
        this.products = newProducts;

    }
    public int getTotalPrice(){
        calculatePrice();
        return this.totalPrice;
    }

    private void calculatePrice (){
        int price = 0;
        for (int i = 0; i < this.products.length; i++) {
            price += this.products[i].getPrice();

        }
        this.totalPrice = price;
    }


    public Product[] getProducts() {
        return this.products;
    }
}
