import java.util.Scanner;

public class Shop {
    private Employee[] employees;
    private Customer[] customers;
    private Product[] products;


    public void crateAccount() {
        Scanner scanner = new Scanner(System.in);

        String firstName;
        String lastName;
        String userName;
        String password;
        int userType;
        boolean userNameIsExist;
        boolean isCostumer;

        do {
            System.out.println("-press 1 for costumer" + "\n" + "-press 2 for Employee");
            userType = scanner.nextInt();
        } while (userType != 1 && userType != 2);

        if (userType == 1) {
            isCostumer = true;
        } else {
            isCostumer = false;
        }

        //הסקנר הבא לא עובד בלי זה משום מה, הוא מדלג על הראשון
        userName = scanner.nextLine();


        do {
            System.out.println("Enter your first name: ");
            firstName = scanner.nextLine();
        } while (hasDigit(firstName));


        do {
            System.out.println("Enter your last Name : ");
            lastName = scanner.nextLine();
        } while (hasDigit(lastName));

        System.out.println("Enter username: ");
        userName = scanner.nextLine();

        do {
            System.out.println("Enter password with 6 chars: ");
            password = scanner.nextLine();
        }while (password.length() < 6);
    }


//
//    public Employee signInEmployee (String usernameToCheck,String passwordToCheck) {
//        for (int i = 0; i < this.employees.length; i++) {
//            Customer currentEmployee = this.employees[i];
//            if (currentEmployee.getUsername().equals(usernameToCheck) &&
//                    currentEmployee.getPassword().equals(passwordToCheck)) {
//                return currentEmployee;
//            }
//        }
//        return null;
//    }


    public Customer signInCustomer(String usernameToCheck, String passwordToCheck) {

        for (int i = 0; i < this.customers.length; i++) {
            Customer currentCustomer = this.customers[i];
            if (currentCustomer.getUsername().equals(usernameToCheck) &&
                    currentCustomer.getPassword().equals(passwordToCheck)) {
                return currentCustomer;
            }
        }
        return null;
    }

    private boolean hasDigit(String stringToCheck) {
        boolean hasDigit = false;
        for (int i = 0; i < stringToCheck.length(); i++) {
            if (Character.isDigit(stringToCheck.charAt(i))) {
                hasDigit = true;
                break;
            }
        }
        return hasDigit;
    }




}
