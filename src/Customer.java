public class Customer {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean isClubMember;
    private ShoppingCart[] purchases;

    public Customer (String firstName, String lastName,String username,String password,boolean isClubMember) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.isClubMember = isClubMember;
        this.purchases = new ShoppingCart[0];
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




    public String toString (){
        String output = this.firstName + " " + this.lastName;
        if (this.isClubMember) {
            output += " (VIP)";
        }
        output += "The amount of purchases: " + this.purchases.length;
        return output;
    }
//    -סך עלות כל הרכישות שביצע
//    -תאריך הרכישה האחרונה שביצע

}
