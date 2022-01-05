import java.util.Scanner;

public class Shop {
    private Employee[] employees;
    private Customer[] customers;
    private Product[] products;






    public void crateAccount (){
        Scanner scanner = new Scanner(System.in);

        String firstName;
        String lastName;
        String userName;
        String password;
        int userType;

        boolean isStrongPassword;
        boolean userNameIsExist;
        boolean isEstaCostumeralse;

        System.out.println("-press 1 for costumer"+"\n" +"-press 2 for Employee" );
        userType = scanner.nextInt();
        do {
            System.out.println("Enter your first name: ");
            firstName = scanner.nextLine();
        }while (firstName.equals("uyuyu"));


        System.out.println("Enter your last Name : ");
        lastName = scanner.nextLine();




    }



    public Customer signUp (){
        boolean isCustomer = false;
        System.out.println("--Logging in--");
        Scanner scanner = new Scanner(System.in);
        String userNameToCheck;
        String passwordToCheck;


        System.out.println("Enter your username: ");
        userNameToCheck = scanner.nextLine();
        System.out.println("Enter your password: ");
        passwordToCheck = scanner.nextLine();


        for (int i = 0; i < this.customers.length; i++) {
            Customer currentCustomer = this.customers[i];
            if (currentCustomer.getUsername().equals(userNameToCheck) &&
                    currentCustomer.getPassword().equals(passwordToCheck)) {
                return currentCustomer;
            }
        }

        return null;
    }
}
