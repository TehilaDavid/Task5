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
                        "\n" + "for employee enter 1, for customer enter 2");
                employeeOrCustomer = scanner.nextInt();
            }while (employeeOrCustomer != 1 && employeeOrCustomer != 2);

            System.out.println("Enter your username: ");
            userNameToCheck = scanner.nextLine();
            System.out.println("Enter your password: ");
            passwordToCheck = scanner.nextLine();
            if (employeeOrCustomer == 1) {

            }else {
                shop.signInCustomer(userNameToCheck,passwordToCheck);
            }
        }












    }
}
