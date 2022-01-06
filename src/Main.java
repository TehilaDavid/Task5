import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();
        String userNameToCheck;
        String passwordToCheck;
        int employeeOrCustomer;
        int userChoice;

        do {
            do {
                System.out.println("1 - Create a new account\n" +
                        "2 - Login to an existing account\n" +
                        "3 - Exit");
                userChoice = scanner.nextInt();
            }while (userChoice != 1 && userChoice != 2 && userChoice != 3);


            if (userChoice == 1){
                shop.crateAccount();
            }

            if (userChoice == 2){
                System.out.println("--Logging in--");
                do {
                    System.out.println("Are you interested in logging in to an employee's or customer's account" +
                            "\n" + "for customer enter 1, for employee enter 2");
                    employeeOrCustomer = scanner.nextInt();
                }while (employeeOrCustomer != 1 && employeeOrCustomer != 2);

                userNameToCheck = scanner.nextLine();

                System.out.println("Enter your username: ");
                userNameToCheck = scanner.nextLine();
                System.out.println("Enter your password: ");
                passwordToCheck = scanner.nextLine();
                if (employeeOrCustomer == 1) {
                    Customer loggedCustomer = shop.signInCustomer(userNameToCheck,passwordToCheck);
                    if (loggedCustomer == null) {
                        System.out.println("Login failed, The username or password is incorrect");
                    }else {
                        System.out.print("Hello " + loggedCustomer.getFirstName() + " " + loggedCustomer.getLastName());
                        if (loggedCustomer.isClubMember()){
                            System.out.println(" (VIP)!");
                        }else {
                            System.out.println(" !");
                        }

                        shop.printProduct();





                    }
                }else {
                    Employee loggedEmployee = shop.signInEmployee(userNameToCheck,passwordToCheck);
                    if (loggedEmployee == null) {
                        System.out.println("Login failed, The username or password is incorrect");
                    }else {
                        System.out.print("Hello " + loggedEmployee.getFirstName() + " " + loggedEmployee.getLastName() + " (");
                        if (loggedEmployee.getRank() == 1) {
                            System.out.println("Regular employee)!");
                        }
                        if (loggedEmployee.getRank() == 2) {
                            System.out.println("Director)!");
                        }
                        if (loggedEmployee.getRank() == 3) {
                            System.out.println("member of the management team)!");
                        }






                    }

                }
            }
        }while (userChoice != 3);













    }
}
