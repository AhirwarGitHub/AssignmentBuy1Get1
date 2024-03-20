import java.util.*;

public class DiscountOfferV3 {

    public static void main(String[] args) {
        List<Integer> productPriceList1 = Arrays.asList(10, 20, 30, 40, 40, 50, 60, 60);
        List<Integer> productPriceList2 = Arrays.asList(5, 5, 10, 20, 30, 40, 50, 50, 50, 60);

        System.out.println("Example 1:");
        applyDiscount(productPriceList1);

        System.out.println("\nExample 2:");
        applyDiscount(productPriceList2);
    }

    public static void applyDiscount(List<Integer> productPrices) {
        // Sort the list in descending order so that the highest priced items are considered first.
        Collections.sort(productPrices, Collections.reverseOrder());

        List<Integer> discountedItems = new ArrayList<>();
        List<Integer> payableItems = new ArrayList<>();

        // Iterate through the list in pairs
        for (int i = 0; i < productPrices.size(); i++) {
            // Add every two items as payable
            if (i < productPrices.size()) {
                payableItems.add(productPrices.get(i));
                if (i + 1 < productPrices.size()) {
                    payableItems.add(productPrices.get(i + 1));
                    i++; // Skip the next item since it has already been counted
                }
            }

            // Add the next two items as discounted, if they are cheaper than the first of the bought pair
            for (int j = 0; j < 2; j++) {
                if (i + 1 + j < productPrices.size() && productPrices.get(i + 1 + j) < productPrices.get(i - j)) {
                    discountedItems.add(productPrices.get(i + 1 + j));
                } else {
                    break; // Break if no cheaper product is found or list ends
                }
            }
            i += 2; // Move forward in the list by two, as we're dealing in pairs
        }

        // Output the results
        System.out.println("Discounted Items: " + discountedItems);
        System.out.println("Payable Items: " + payableItems);
    }
}
