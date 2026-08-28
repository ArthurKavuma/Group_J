public class GroupJ_BusinessSimulator {
    public static void main(String[] args) {
        String[] items = {"Bread", "Cake(slice)", "Doughnut", "Cookie"};
        double[] prices = {3500.00, 25000.00, 1000.00, 500.00};
        int[] quantities = {2, 2, 5, 10};

        printPriceList(items, prices);

        double[] subtotals = new double[items.length];
        boolean[] discountApplied = new boolean[items.length];

        for (int i = 0; i < items.length; i++) {
            subtotals[i] = calculateSubtotal(items[i], prices[i], quantities[i]);
            discountApplied[i] = isDiscounted(items[i], quantities[i]);
        }

        double grandTotal = 0;
        for (double s : subtotals) {
            grandTotal += s;
        }

        printReceipt(items, quantities, subtotals, discountApplied, grandTotal);
    }

    public static void printPriceList(String[] items, double[] prices) {
        System.out.println("===== SweetHome Bakery — Price List =====");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%-15s UGX %,10.2f%n", items[i], prices[i]);
        }
        System.out.println("==========================================");
        System.out.println();
    }

public static double calculateSubtotal(String item, double price, int quantity) {
    double subtotal = price * quantity;

    switch (item) {
        case "Bread":
            if (quantity >= 3) {
                subtotal *= 0.95; // 5% off
            }
        
        case "Cake(slice)":
            // never discounted
        
        case "Doughnut":
            if (quantity >= 6) {
                subtotal -= 500.00; // flat UGX 500 off
            }
    
        case "Cookie":
            if (quantity >= 10) {
                subtotal *= 0.90; // 10% off
            }
    
    }
    return subtotal;
}

  public static void printReceipt(String[] items, int[] quantities, double[] subtotals,
                                 boolean[] discountApplied, double grandTotal) {
    System.out.println("========== RECEIPT ==========");
    for (int i = 0; i < items.length; i++) {
        String note = discountApplied[i] ? "(discount applied)" : "(no discount)";
        System.out.printf("%-15s qty: %-3d  UGX %,10.2f  %s%n",
                items[i], quantities[i], subtotals[i], note);
    }
    System.out.println("------------------------------");
    System.out.printf("GRAND TOTAL: UGX %,.2f%n", grandTotal);
    System.out.println("==============================");
}
