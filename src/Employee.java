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
}