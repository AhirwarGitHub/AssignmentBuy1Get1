import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfferRule3Application {

    // Utility method to apply Offer Rule 3
    public static void applyOfferRule3(Integer[] productPrices) {
        // Sort the prices in descending order
        Arrays.sort(productPrices, (a, b) -> b - a);

        List<Integer> discountedItems = new ArrayList<>();
        List<Integer> payableItems = new ArrayList<>();

        // The first two most expensive items are always payable
        payableItems.add(productPrices[0]);
        int countPaid = 1; // Counter for paid items (up to two)
        int countFree = 0; // Counter for free items (up to two)

        for (int i = 1; i < productPrices.length && (countPaid < 2 || countFree < 2); i++) {
            // If less than two items have been paid, add the next most expensive item to payable items
            if (countPaid < 2) {
                payableItems.add(productPrices[i]);
                countPaid++;
            } else if (productPrices[i] < payableItems.get(0) && countFree < 2) {
                // If an item's price is less than the first (most expensive) paid item and less than two items have been given for free, it becomes a free item
                discountedItems.add(productPrices[i]);
                countFree++;
            }
        }

        // Remaining items that haven't been categorized yet
        for (int i = countPaid + countFree; i < productPrices.length; i++) {
            if (payableItems.size() < 4) {
                payableItems.add(productPrices[i]); // Add remaining to payable if less than four total paid items
            } else {
                discountedItems.add(productPrices[i]); // Otherwise, they are considered as additional discounted items
            }
        }

        System.out.println("Payable Items: " + payableItems);
        System.out.println("Discounted Items: " + discountedItems);
    }

    public static void main(String[] args) {
        Integer[] prices1 = {10, 20, 30, 40, 40, 50, 60, 60};
        System.out.println("Example 1:");
        applyOfferRule3(prices1);

        Integer[] prices2 = {5, 5, 10, 20, 30, 40, 50, 50, 50, 60};
        System.out.println("\nExample 2:");
        applyOfferRule3(prices2);
    }
}