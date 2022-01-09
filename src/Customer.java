public class Customer {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean isClubMember;
    private ShoppingCart shoppingCart;
    private int numberOfPurchase;
    private double sumPurchases;


    public Customer (String firstName, String lastName,String username,String password,boolean isClubMember) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.isClubMember = isClubMember;
        this.shoppingCart = new ShoppingCart();
        this.numberOfPurchase = 0;
        this.sumPurchases = 0;
    }

    public String getFirstName () {
        return this.firstName;
    }

    public String getLastName () {
        return this.lastName;
    }

    public String getUsername () {
        return this.username;
    }

    public String getPassword () {
        return this.password;
    }

    public boolean isClubMember () {
        return this.isClubMember;
    }

    public void setShoppingCart (Product productToAdd){
        this.shoppingCart.setProducts(productToAdd);
    }

    public ShoppingCart getShoppingCart (){
        return this.shoppingCart;
    }

    public void addNumberOfPurchase() {
        this.numberOfPurchase += 1;
    }

    public void addToSumPurchases(double purchasePrice) {
        this.sumPurchases += purchasePrice;
    }

    public void purchaseReset() {
        this.shoppingCart = new ShoppingCart();
    }

    public int getNumberOfPurchase() {
        return this.numberOfPurchase;
    }

    public double getSumPurchases() {
        return this.sumPurchases;
    }

    public void calculatePrice (){
        double price = 0;
        for (int i = 0; i < this.shoppingCart.getProducts().length; i++) {
            price += this.shoppingCart.getProducts()[i].getPrice();
        }
        if (this.isClubMember()) {
            double discount = this.shoppingCart.getProducts()[this.shoppingCart.getProducts().length - 1].getDiscountPercentages();
            price = price * ((100 - discount)/100);
        }
        this.shoppingCart.setTotalPrice(price);
    }

    public String toString (){
        String output = this.firstName + " " + this.lastName;
        if (this.isClubMember) {
            output += " (VIP)";
        }
        output += "The amount of purchases: ";
        return output;
    }
//    -סך עלות כל הרכישות שביצע
//    -תאריך הרכישה האחרונה שביצע

}