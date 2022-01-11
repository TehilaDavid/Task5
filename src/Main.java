import java.util.Date;
import java.util.Scanner;

//זה מעודכןןןןן

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();
        String userNameToCheck;
        String passwordToCheck;
        int employeeOrCustomer;
        int userChoice;
        int employeeChoice;

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
                            "\n" + "for customer enter 1" +"\n"+ "for employee enter 2");
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



                        int customerChoice2;
                        do {

                            customerChoice2 = shop.purchase(loggedCustomer);
                            if (customerChoice2 == -1 && loggedCustomer.getShoppingCart().totalPrice != 0){
                                loggedCustomer.addToSumPurchases(loggedCustomer.getShoppingCart().totalPrice);
                                loggedCustomer.purchaseReset();
                                Date dateOfAcquisition = new Date();
                                loggedCustomer.setDateOfLastPurchase(dateOfAcquisition);
                            }
                        }while (customerChoice2 != -1);


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


                        do {
                            System.out.println("Enter your choice: " +
                                    "\n" + "1- Print a list of all customers" +
                                    "\n" + "2- Print a list of customer members in the club" +
                                    "\n" + "3- Print the list of customers who have made at least one purchase" +
                                    "\n" + "4- Print the customer whose purchase amount is the highest" +
                                    "\n" + "5- Adding a new product to the store" +
                                    "\n" + "6- Change inventory status for product" +
                                    "\n" + "7- Making a purchase" +
                                    "\n" + "8- Disconnect and return to the main menu");
                            employeeChoice = scanner.nextInt();
                        }while (employeeChoice > 8 || employeeChoice < 1);

                        switch (employeeChoice) {
                            case 1:
                                shop.printAllCustomers();
                                break;
                            case 2:
                                shop.printTheClubMemberCustomer();
                                break;
                            case 3:
                                shop.printCustomersWithAtLeastOnePurchase();
                                break;
                            case 4:
                                Customer[] customers = shop.getCustomers();
                                //ניסתי לעשות שאם אין לקוחות (המערך ריק כאילו) אז שלא יבדוק. ולא הצלחתי להשוות את זה לnull
                                if (customers.length == 0){
                                    System.out.println("there is no costumers");

                                }else {
                                    shop.printCustomerWithTheTopDollar();
                                }
                                break;
                            case 5:
                                shop.addNewProduct();
                                break;
                            case 6:
                                shop.changeIsInStock();
                                break;
                            case 7:
                                shop.purchase(loggedEmployee);
                                break;
                            case 8:
                                break;
                        }

                    }

                }
            }
        }while (userChoice != 3);

//        1 – הדפסת רשימת כל הלקוחות.
//        2 – הדפסת רשימת הלקוחות החברים במועדון בלבד.
//        3 – הדפסת רשימת הלקוחות שביצעו רכישה אחת לפחות.
//        4 – הדפסת הלקוח שסכום הרכישות שלו הוא הגבוה ביותר.
//        5 – הוספת מוצר חדש לחנות: המשתמש יתבקש להכניס את תיאור המוצר, מחיר המוצר ואחוזי ההנחה עבור המוצר שמקבלים חברי המועדון. נוסף על כך, כאשר מוצר מתווסף לחנות, יש לקבוע באופן אוטומטי כי המוצר נמצא במלאי.
//        6 – שינוי סטטוס מלאי עבור מוצר: עדכון עבור מוצר ספציפי האם הוא נמצא במלאי או לא. ללקוח תודפס רשימה ממוספרת של המוצרים, וכשהוא יבחר במספר המוצר יכניס האם קיים במלאי או לא.
//        7 – ביצוע רכישה: גם עובדי החנות הם סוג של לקוחות החנות, כיוון שהם יכולים להיות לרכוש מוצרים מהחנות. תהליך הרכישה של עובד בחנות זהה לתהליך הרכישה של לקוח רגיל, למעט הפרט הבא: עובד של החנות זכאי להנחה על כל החשבונית שלו, בהתאם לדרגתו. אם דרגתו הוא עובד רגיל – 10 אחוזים הנחה; מנהל – 20 אחוזים; וחבר בצוות ההנהלה – 30 אחוזים.
//        8 – התנתקות: מדפיסה את התפריט הראשי שוב.














    }

}