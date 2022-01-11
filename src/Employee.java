public class Employee extends Customer{
    private int rank;

    public Employee(String firstName, String lastName, String username, String password, boolean isClubMember, int rank) {
        super(firstName, lastName, username, password, isClubMember);
        this.rank = rank;
    }

    public int getRank () {
        return rank;
    }


    public String toString () {
        return "";
    }

    public void calculatePrice (){
        double price = 0;
        double sum = 0;
        boolean isClubMember = this.isClubMember();
        for (int i = 0; i < this.getShoppingCart().getProducts().length; i++) {
            Product currentProduct = this.getShoppingCart().getProducts()[i];
            price = 0;
            price += currentProduct.getPrice();

            if (isClubMember) {
                double discount = currentProduct.getDiscountPercentages();
                sum += (price * ((100 - discount)/100));
            } else {
                sum += price;
            }
        }
        if (this.getRank() == 1){
            sum = sum * 0.9;
        }else  if (this.getRank() == 2) {
            sum = sum * 0.8;
        }else {
            sum = sum * 0.7;
        }
        this.getShoppingCart().setTotalPrice(sum);
    }
}