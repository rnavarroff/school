import java.util.Scanner;
public class old {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        // black and white
        final double BW_A4 = 5.00;
        final double BW_SHORT = 5.00;
        final double BW_LONG = 8.00;
        // Colored
        final double COLORED_A4 = 10.00;
        final double COLORED_SHORT = 10.00;
        final double COLORED_LONG = 13.00;
        // Photocopy black and white
        final double COPY_BW_A4 = 2.00;
        final double COPY_BW_SHORT = 2.00;
        final double COPY_BW_LONG = 4.00;
        // Photocopy colored
        final double COPY_COLORED_A4 = 5.00;
        final double COPY_COLORED_SHORT = 5.00;
        final double COPY_COLORED_LONG = 7.00;

        // Running totals
        double totalEarnings = 0.00;
        int totalOrders = 0;
        int totalPages = 0;

        String records = "";
        int choice;

        do {
            System.out.println("\n- - - - PRINTING CENTER - - - -");
            System.out.println("1. Printing Services");
            System.out.println("2. Record Customer Order");
            System.out.println("3. Order Summary");
            System.out.println("4. Review Daily Sales");
            System.out.println("5. Exit");

            System.out.println("Enter Your Choice: ");
            choice = input.nextInt();

            while (choice < 1 || choice > 5) {
                System.out.println("Invalid Choice. Please enter 1 to 5 Only.");
                System.out.println("Enter Your Choice: ");
                choice = input.nextInt();
            }

            switch (choice) {
                // PRINT SERVICES
                case 1:
                    System.out.println("\n- - - - Browse Printing Services - - - -");
                    System.out.println("Black & White Print Service");
                    System.out.println("A4 Paper: P" + BW_A4);
                    System.out.println("Short Paper: P" + BW_SHORT);
                    System.out.println("Long Paper: P" + BW_LONG);

                    System.out.println("Colored Print Service");
                    System.out.println("A4 Paper: P" + COLORED_A4);
                    System.out.println("Short Paper: P" + COLORED_SHORT);
                    System.out.println("Long Paper: P" + COLORED_LONG);

                    System.out.println("Black & White Photocopy Service");
                    System.out.println("A4 Paper: P" + COPY_BW_A4);
                    System.out.println("Short Paper: P" + COPY_BW_SHORT);
                    System.out.println("Long Paper: P" + COPY_BW_LONG);

                    System.out.println("Colored Photocopy Service");
                    System.out.println("A4 Paper: P" + COPY_COLORED_A4);
                    System.out.println("Short Paper: P" + COPY_COLORED_SHORT);
                    System.out.println("Long Paper: P" + COPY_COLORED_LONG);
                    System.out.println("\n - - - - END - - - -");
                    break;

                case 2:
                    int service;
                    int paperSize;
                    int quantity;

                    double pricePerPage = 0.00;
                    double totalCost = 0.00;
                    double payment = 0.00;
                    double change = 0.00;

                    String serviceName = "";
                    String paperName = "";

                    System.out.println("\n=====Record Customer Order=====");
                    System.out.println("1. Black and White Print");
                    System.out.println("2. Colored Print");
                    System.out.println("3. Black & White Photocopy");
                    System.out.println("4. Colored Photocopy");
                    
                    System.out.println("Select service: ");
                    service = input.nextInt();

                    while (service < 1 || service > 4){
                        System.out.println("Invalid Service. Please enter 1 to 4 Only");
                        System.out.println("Select Service: ");
                        service = input.nextInt();
                    }

                    System.out.println("1. A4");
                    System.out.println("2. Short Bond Paper");
                    System.out.println("3. Long Bond Paper");

                    System.out.println("Select Paper Size: ");
                    paperSize = input.nextInt();  


                    while (paperSize < 1 || paperSize > 3){
                        System.out.println("Invalid Paper Size. Please enter 1 to 3 Only");
                        System.out.println("Select Paper Size: ");
                        paperSize = input.nextInt();
                    }

                    if (service == 1){
                        serviceName = "Black & White Printing";

                        if (paperSize == 1){
                            pricePerPage = BW_A4;
                        }else if (paperSize == 2){
                            pricePerPage = BW_SHORT;
                        }else {
                            pricePerPage = BW_LONG;
                        }

                    }else if  (service == 2){
                        serviceName = "Colored Printing";

                        if (paperSize == 1){
                            pricePerPage = COLORED_A4;
                        }else if (paperSize == 2){
                            pricePerPage = COLORED_SHORT;
                        }else {
                            pricePerPage = COLORED_LONG;
                        }
                    }else if (service == 3){
                        serviceName = "Black & White Photocopy";

                        if (paperSize == 1){
                            pricePerPage = COPY_BW_A4;
                        }else if (paperSize == 2){
                            pricePerPage = COPY_BW_SHORT;
                        }else {
                            pricePerPage = COPY_BW_LONG;
                        }
                    }else {
                        serviceName = "Colored Photocopy";

                        if (paperSize == 1){
                            pricePerPage = COPY_COLORED_A4;
                        }else if (paperSize == 2){
                            pricePerPage = COPY_COLORED_SHORT; 
                        }else {
                            pricePerPage = COPY_COLORED_LONG;
                        }
                    }

                    if (paperSize == 1){
                        paperName = "A4";
                    }else if (paperSize == 2){
                        paperName = "Short Bond Paper";
                    }else {
                        paperName = "Long Bond Paper";
                    }

                    System.out.println("Enter The Number Of Pages: ");
                    quantity = input.nextInt();

                    while (quantity <= 0 ){
                        System.out.println("Enter A Positive Number.");
                        System.out.println("Enter The Number Of Pages: ");
                        quantity = input.nextInt();
                    }

                    //Total Cost Computation
                    totalCost = pricePerPage * quantity;
                    System.out.printf("Total Cost: P%.2f%n", totalCost);

                    System.out.printf("Enter Payment: P");
                    payment = input.nextDouble();

                    while (payment < totalCost){
                        System.out.println("Insufficient Payment. Please enter enough payment.");
                        System.out.println("Enter Payment: P ");
                        payment = input.nextDouble();
                    }

                    // Computing change
                    change = payment - totalCost;

                    System.out.printf("Change: P%.2f%n", change);
                    break;

                    
                    
                default:
                    return;
            }

        } while (choice != 5);
    }
}
