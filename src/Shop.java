import java.util.Scanner;

public class Shop {
    private Employee[] employees;
    private Customer[] customers;
    private Product[] products;

    public Shop() {
        this.employees = new Employee[0];
//        this.customers = new Customer[0];
//        this.products = new Product[0];
        Customer customer1 = new Customer("tehila","karavani","tehila","555555",true);
        Product product1 = new Product("milk",4,30);
        Product product2 = new Product("bred",10,20);
        Product product3 = new Product("water",8,15);
        Product[] products1 = {product1,product2,product3};
        Customer[] customers1 = {customer1};
        this.customers = customers1;
        this.products = products1;
    }


    public void crateAccount() {
        Scanner scanner = new Scanner(System.in);

        String firstName;
        String lastName;
        String userName;
        String password;
        int userType;
        int clubMemberChoice;
        int rank;
        boolean userNameIsExist;
        boolean isCostumer;
        boolean isClubMember;


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

        //לבדוק אם נמצא חשבון כזה
        System.out.println("Enter username: ");
        userName = scanner.nextLine();

        do {
            System.out.println("Enter password with 6 chars: ");
            password = scanner.nextLine();
        }while (password.length() < 6);

        do {
            System.out.println("If you are a club member tap 1 if you do not tap 2");
            clubMemberChoice = scanner.nextInt();
        }while (clubMemberChoice != 1 && clubMemberChoice != 2);

        if (clubMemberChoice == 1){
            isClubMember = true;
        }else {
            isClubMember = false;
        }



        if (isCostumer){
            addCustomerToArray(firstName,lastName,userName,password,isClubMember);
        }else {
            do {
                System.out.println("What is your rank\n" +
                        "1 - Regular employee.\n" +
                        "2 - Director.\n" +
                        "3 - member of the management team.");
                rank = scanner.nextInt();
            }while (rank != 1 && rank != 2 && rank != 3);
            addEmployeeToArray(firstName,lastName,userName,password,isClubMember,rank);
        }


    }

    public Employee signInEmployee (String usernameToCheck,String passwordToCheck) {
        for (int i = 0; i < this.employees.length; i++) {
            Employee currentEmployee = this.employees[i];
            if (currentEmployee.getUsername().equals(usernameToCheck) &&
                    currentEmployee.getPassword().equals(passwordToCheck)) {
                return currentEmployee;
            }
        }
        return null;
    }

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

    public void printProduct () {
        int counter = 1;
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i].isInStock()){
                System.out.println(counter);
                System.out.println(this.products[i] + "\n");
                counter++;
            }

        }
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

    private void addEmployeeToArray(String firstName,String lastName,String username, String password,boolean isClubMember, int rank) {
        Employee[] newEmployeeArray = new Employee[this.employees.length + 1];
        for (int i = 0; i < this.employees.length; i++) {
            newEmployeeArray[i] = this.employees[i];
        }
        Employee employeeToAdd = new Employee(firstName,lastName,username,password,isClubMember,rank);
        newEmployeeArray[this.employees.length] = employeeToAdd;
        this.employees = newEmployeeArray;
    }

    private void addCustomerToArray(String firstName,String lastName,String username, String password,boolean isClubMember) {
        Customer[] newCustomerArray = new Customer[this.customers.length + 1];
        for (int i = 0; i < this.customers.length; i++) {
            newCustomerArray[i] = this.customers[i];
        }
        Customer customerToAdd = new Customer(firstName,lastName,username,password,isClubMember);
        newCustomerArray[this.customers.length] = customerToAdd;
        this.customers = newCustomerArray;
    }




}
