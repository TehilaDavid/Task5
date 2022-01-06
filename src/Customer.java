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
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public String getUsername () {
        return this.username;
    }

    public String getPassword () {
        return this.password;
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
