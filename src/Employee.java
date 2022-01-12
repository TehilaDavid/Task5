public class Employee extends Customer{
    private static final double THE_PERCENTAGE_A_REGULAR_EMPLOYEE_PAYS = 0.9;
    private static final double THE_PERCENTAGE_A_DIRECTOR_PAYS = 0.8;
    private static final double THE_PERCENTAGE_A_MEMBER_OF_THE_MANAGEMENT_TEAM_PAYS = 0.7;
    private static final int REGULAR_EMPLOYEE_RANK = 1;
    private static final int DIRECTOR_RANK = 2;


    private int rank;

    public Employee(String firstName, String lastName, String username, String password, boolean isClubMember, int rank) {
        super(firstName, lastName, username, password, isClubMember);
        this.rank = rank;
    }

    public int getRank () {
        return rank;
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
        if (this.getRank() == REGULAR_EMPLOYEE_RANK){
            sum = sum * THE_PERCENTAGE_A_REGULAR_EMPLOYEE_PAYS;
        }else  if (this.getRank() == DIRECTOR_RANK) {
            sum = sum * THE_PERCENTAGE_A_DIRECTOR_PAYS;
        }else {
            sum = sum * THE_PERCENTAGE_A_MEMBER_OF_THE_MANAGEMENT_TEAM_PAYS;
        }
        this.getShoppingCart().setTotalPrice(sum);
    }
}