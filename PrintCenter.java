import java.util.Scanner;

public class PrintCenter{
    
    // BLACK AND WHITE PRICES
        static final double BW_A4 = 5.00;
        static final double BW_SHORT = 5.00;
        static final double BW_LONG = 8.00;
        // COLORED PRICES
        static final double COLORED_A4 = 10.00;
        static final double COLORED_SHORT = 10.00;
        static final double COLORED_LONG = 13.00;
        // PHOTOCOPY B&W PRICES
        static final double COPY_BW_A4 = 2.00;
        static final double COPY_BW_SHORT = 2.00;
        static final double COPY_BW_LONG = 4.00;
        // PHOTOCOPY COLORED PRICES
        static final double COPY_COLORED_A4 = 5.00;
        static final double COPY_COLORED_SHORT = 5.00;
        static final double COPY_COLORED_LONG = 7.00;

        // RUNNING TOTALS
        static double totalEarnings = 0.00;
        static int totalOrders = 0;
        static int totalPages = 0;

        static String records = "";
        
        public static void main (String [] args){
            Scanner input = new Scanner (System.in);
            
            int choice;

            do {
                menu();

                System.out.print("\nEnter Your Choice: ");
                choice = input.nextInt();

                // INPUT VALIDATION FOR CHOICE
                while (choice < 1 || choice > 5){
                    System.out.println("\n!!!!! INCORRECT CHOICE. Please Try Again. !!!!!");
                    System.out.println("\nEnter Your Choice: ");
                    choice = input.nextInt();
                }

                switch (choice) {
                    case 1: 
                        service();
                        break;
                    case 2: 
                        customerOrder(input);
                        break;
                    case 5: 
                        System.out.println("Thank you for using the system!");
                        break;
                }
              
            } while (choice != 5);
   
        }

    // MENU OF OUR SYSTEM
    public static void menu(){
    System.out.println("\n= = = = = PRINTING SYSTEM = = = = = ");
    System.out.println("\n- Printing Services \t(1)");
    System.out.println("- Record Customer Order (2)");
    System.out.println("- Order Summary \t(3)");
    System.out.println("- Review Daily Sales \t(4)");
    System.out.println("- Exit          \t(5)");

    }

    // VIEWING OF PRINT SERVICES
    public static void service(){
    System.out.println("\n- - - - PRINTING SERVICES - - - -");

    System.out.println("\nBlack & White Print Service:");
    System.out.printf("A4 Paper:\tP%.2f%n", BW_A4);
    System.out.printf("Short Paper:\tP%.2f%n", BW_SHORT);
    System.out.printf("Long Paper:\tP%.2f%n", BW_LONG);

    System.out.println("\nColored Print Service:");
    System.out.printf("A4 Paper:\tP%.2f%n", COLORED_A4);
    System.out.printf("Short Paper:\tP%.2f%n", COLORED_SHORT);
    System.out.printf("Long Paper:\tP%.2f%n", COLORED_LONG);

    System.out.println("\nBlack & White Photocopy Service:");
    System.out.printf("A4 Paper:\tP%.2f%n", COPY_BW_A4);
    System.out.printf("Short Paper:\tP%.2f%n", COPY_BW_SHORT);
    System.out.printf("Long Paper:\tP%.2f%n", COPY_BW_LONG);

    System.out.println("\nColored Photocopy Service:");
    System.out.printf("A4 Paper:\tP%.2f%n", COPY_COLORED_A4);
    System.out.printf("Short Paper:\tP%.2f%n", COPY_COLORED_SHORT);
    System.out.printf("Long Paper:\tP%.2f%n", COPY_COLORED_LONG);
    System.out.println("\n- - - - END - - - -");
    }

    // RECORDING OF CUSTOMER'S ORDER
    public static void customerOrder(Scanner input){
    int service;
    int paperSize;
    int quantity;

    double pricePerPage = 0.00;
    double totalCost = 0.00;
    double payment = 0.00;
    double change = 0.00;

    String serviceName = " ";
    String paperName = " ";

    System.out.println("\n= = = = = RECORD ORDER = = = = =");
    System.out.println("\n- Black & White Print \t(1)");
    System.out.println("- Colored Print    \t(2)");
    System.out.println("- Black & White Photocopy (3)");
    System.out.println("- Colored Photocopy  \t(4)");

    System.out.print("\nSelect Service: ");
    service = input.nextInt();

    // INPUT VALIDATION FOR SERVICES
    while (service < 1 || service > 4){
        System.out.println("\n!!!!! INCORRECT SERVICE. Please input 1 to 4. !!!!!");
        System.out.print("\nSelect Service: ");
        service = input.nextInt();
    }

    System.out.println("\n= = = = = CHOOSE PAPER SIZE = = = = =");
    System.out.println("\n- A4 Bond Paper (1)");
    System.out.println("- Short Bond Paper (2)");
    System.out.println("- Long Bond Paper (3)");

    System.out.print("\nSelect Paper Size: ");
    paperSize = input.nextInt();

    // INPUT VALIDATION FOR PAPER SIZE
    while (paperSize < 1 || paperSize > 3){
        System.out.println("\n!!!!! INCORRECT PAPERSIZE. Please input 1 to 3. !!!!!");
        System.out.print("\nSelect Paper Size: ");
        paperSize = input.nextInt();
    }

    // PRICE PER PAGE & SERVICE NAMES
    switch (service){
        case 1: 
            serviceName = "Black & White Print";

            if (paperSize == 1){
                pricePerPage = BW_A4;
            }else if (paperSize == 2){
                pricePerPage = BW_SHORT;
            }else {
                pricePerPage = BW_LONG;
            }
            break;
        case 2: 
            serviceName = "Colored Print";

            if (paperSize == 1){
                pricePerPage = COLORED_A4;
            }else if (paperSize == 2){
                pricePerPage = COLORED_SHORT;
            }else {
                pricePerPage = COLORED_LONG;
            }
            break;
        case 3:
            serviceName = "Black & White Photocopy";

            if (paperSize == 1){
                pricePerPage = COPY_BW_A4;
            }else if (paperSize == 2){
                pricePerPage = COPY_BW_SHORT;
            }else {
                pricePerPage = COPY_BW_LONG;
            }
            break;
        case 4: 
            serviceName = "Colored Photocopy";

            if (paperSize == 1){
                pricePerPage = COPY_COLORED_A4;
            }else if (paperSize == 2){
                pricePerPage = COPY_COLORED_SHORT;
            }else {
                pricePerPage = COPY_COLORED_LONG;
            }
            break;
    }

    // PAPER NAMES
    if (paperSize == 1){
        paperName = "A4 Bond Paper";
    }else if (paperSize == 2){
        paperName = "Short Bond Paper";
    }else {
        paperName = "Long Bond Paper";
    }

    // HOW MANY PAGES THE CUSTOMER WANTS
    System.out.print("\nEnter The Number Of Pages: ");
    quantity = input.nextInt();

    // INPUT VALIDATION FOR QUANTITY
    while (quantity <= 0){
        System.out.println("\n!!!!! Enter a Positive Number. !!!!!");
        System.out.print("\nEnter The Number Of Pages: ");
        quantity = input.nextInt();
    }
    // TOTAL COST
    totalCost = pricePerPage * quantity;

    System.out.printf("\nTotal Cost: %.2f%n", totalCost);

    // PAYMENT
    System.out.print("\nEnter Your Payment: P");
    payment = input.nextDouble();
    System.out.printf("\nYour Payment: P%.2f%n", payment);

    // INPUT VALIDATION OF PAYMENT
    while (payment < totalCost){
        System.out.println("\n!!!!! INSUFFICIENT MONEY. Please Try Again. !!!!!");
        System.out.printf("\nEnter Your Payment: P%.2f", payment);
        payment = input.nextDouble();
    }

    // CHANGE
    change = payment - totalCost;
    System.out.printf("Change: P%.2f%n", change);

    }

}

