import java.util.Scanner;

public class Shop {
    private Employee[] employees;
    private Customer[] customers;
    private Product[] products;

    public Shop() {
//        this.employees = new Employee[0];
//        this.customers = new Customer[0];
//        this.products = new Product[0];
        Customer customer1 = new Customer("Tehila", "Karavani", "tehila", "555555", true);
        Employee employee1 = new Employee("Tehila", "David", "tehila1", "555555", false, 3);
        Product product1 = new Product("milk", 4, 30);
        Product product2 = new Product("bred", 10, 20);
        Product product3 = new Product("water", 8, 15);
        Customer[] customers1 = {customer1};
        Employee[] employees1 = {employee1};
        Product[] products1 = {product1, product2, product3};
        this.customers = customers1;
        this.employees = employees1;
        this.products = products1;
    }


    public void crateAccount() {
        Scanner scanner = new Scanner(System.in);

        String firstName;
        String lastName;
        String username;
        String password;
        int userType;
        int clubMemberChoice;
        int rank;
        boolean usernameIsExist;
        boolean isCostumer;
        boolean isClubMember;


        do {
            System.out.println("-for customer enter 1" + "\n" + "-for employee enter 2");
            userType = scanner.nextInt();
        } while (userType != 1 && userType != 2);

        if (userType == 1) {
            isCostumer = true;
        } else {
            isCostumer = false;
        }

        //הסקנר הבא לא עובד בלי זה משום מה, הוא מדלג על הראשון
        username = scanner.nextLine();


        do {
            System.out.println("Enter your first name: ");
            firstName = scanner.nextLine();
        } while (hasDigit(firstName));

        do {
            System.out.println("Enter your last Name : ");
            lastName = scanner.nextLine();
        } while (hasDigit(lastName));


        do {
            System.out.println("Enter username: ");
            username = scanner.nextLine();
            if (isCostumer) {
                usernameIsExist = isCustomerUsernameExist(username);
            }else {
                usernameIsExist = isEmployeeUsernameExist(username);
            }
            if (usernameIsExist) {
                System.out.println("Username is already taken.");
            }
        }while (usernameIsExist);


        do {
            System.out.println("Enter password with 6 chars: ");
            password = scanner.nextLine();
        } while (password.length() < 6);

        do {
            System.out.println("If you are a club member tap 1 if you do not tap 2");
            clubMemberChoice = scanner.nextInt();
        } while (clubMemberChoice != 1 && clubMemberChoice != 2);

        if (clubMemberChoice == 1) {
            isClubMember = true;
        } else {
            isClubMember = false;
        }


        if (isCostumer) {
            addCustomerToArray(firstName, lastName, username, password, isClubMember);
        } else {
            do {
                System.out.println("What is your rank\n" +
                        "1 - Regular employee.\n" +
                        "2 - Director.\n" +
                        "3 - member of the management team.");
                rank = scanner.nextInt();
            } while (rank != 1 && rank != 2 && rank != 3);
            addEmployeeToArray(firstName, lastName, username, password, isClubMember, rank);
        }


    }

    public Employee signInEmployee(String usernameToCheck, String passwordToCheck) {
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

    public Product[] productsInStock() {
        int counter = 1;
        Product[] productsInStock = new Product[this.products.length];
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i].isInStock()) {
                System.out.println(counter);
                System.out.println(this.products[i] + "\n");
                productsInStock[counter - 1] = this.products[1];
                counter++;
            }
        }
        Product[] productsInStockWithoutNull = new Product[counter - 1];
        for (int i = 0; i < counter - 1 ; i++) {
            productsInStockWithoutNull[i] = productsInStock[i];
        }
        return productsInStockWithoutNull;
    }

    public void purchase () {
        Scanner scanner = new Scanner(System.in);
        int counter = 1;
        int customerChoice;
        int howMany;
        int sum = 0;
        Product[] productsInStock = productsInStock();
        do {
            System.out.println("Enter");
            customerChoice = scanner.nextInt();
        }while (productsInStock.length < customerChoice || customerChoice < 0);

        do {
            System.out.println("How many?");
            howMany = scanner.nextInt();
        }while (howMany < 0);

        Product[] products1 = new Product[howMany];
        for (int i = 0; i < products1.length; i++) {
            products1[i] = productsInStock[customerChoice - 1];
        }
        sum += products1[0].getPrice() * howMany;
        System.out.println(sum);
        //לעשות אפשרות לעוד רכישות
        //להכניס לעגלת קניות בסוף
        //לשים את העגלה אצל הלקוח


    }



    public void printAllCustomers () {
        for (int i = 0; i < this.customers.length; i++) {
            System.out.println(i + 1);
            System.out.println(this.customers[i]);
        }
    }

    public void printTheClubMemberCustomer () {
        int counter = 1;
        for (int i = 0; i < this.customers.length; i++) {
            if (this.customers[i].isClubMember()){
                System.out.println(counter);
                System.out.println(this.customers[i]);
                counter++;
            }
        }
    }




    private boolean isEmployeeUsernameExist(String username) {
        boolean isExist = false;
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getUsername().equals(username)){
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    private boolean isCustomerUsernameExist(String username) {
        boolean isExist = false;
        for (int i = 0; i < this.customers.length; i++) {
            if (this.customers[i].getUsername().equals(username)){
                isExist = true;
                break;
            }
        }
        return isExist;
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

    private void addEmployeeToArray(String firstName, String lastName, String username, String password, boolean isClubMember, int rank) {
        Employee[] newEmployeeArray = new Employee[this.employees.length + 1];
        for (int i = 0; i < this.employees.length; i++) {
            newEmployeeArray[i] = this.employees[i];
        }
        Employee employeeToAdd = new Employee(firstName, lastName, username, password, isClubMember, rank);
        newEmployeeArray[this.employees.length] = employeeToAdd;
        this.employees = newEmployeeArray;
    }

    private void addCustomerToArray(String firstName, String lastName, String username, String password, boolean isClubMember) {
        Customer[] newCustomerArray = new Customer[this.customers.length + 1];
        for (int i = 0; i < this.customers.length; i++) {
            newCustomerArray[i] = this.customers[i];
        }
        Customer customerToAdd = new Customer(firstName, lastName, username, password, isClubMember);
        newCustomerArray[this.customers.length] = customerToAdd;
        this.customers = newCustomerArray;
    }


}
