import java.util.*;

public class DiscountOfferRule3 {

    public static void main(String[] args) {
        List<Integer> productPriceList1 = Arrays.asList(10, 20, 30, 40, 40, 50, 60, 60);
        List<Integer> productPriceList2 = Arrays.asList(5, 5, 10, 20, 30, 40, 50, 50, 50, 60);

        System.out.println("Example 1:");
        applyDiscount(productPriceList1);

        System.out.println("\nExample 2:");
        applyDiscount(productPriceList2);
    }

    public static void applyDiscount(List<Integer> productPrices) {
        // Sort the list in descending order so the highest priced items are considered first.
        Collections.sort(productPrices, Collections.reverseOrder());

        List<Integer> discountedItems = new ArrayList<>();
        List<Integer> payableItems = new ArrayList<>();

        // Create a temporary list to keep track of items that are already paired.
        Set<Integer> usedIndexes = new HashSet<>();

        for (int i = 0; i < productPrices.size(); i++) {
            if (!usedIndexes.contains(i)) {
                int currentPrice = productPrices.get(i);
                // Add the current and next highest priced item that hasn't been used to the payable list.
                payableItems.add(currentPrice);
                usedIndexes.add(i); // Mark current item as used.

                // Try to add one more to payable if exists and not yet at the end.
                if (i + 1 < productPrices.size() && !usedIndexes.contains(i + 1)) {
                    int nextPrice = productPrices.get(i + 1);
                    payableItems.add(nextPrice);
                    usedIndexes.add(i + 1); // Mark next item as used.
                }

                // Now, try to find two items to mark as free.
                int freeItemsAdded = 0;
                for (int j = i + 1; j < productPrices.size(); j++) {
                    if (!usedIndexes.contains(j) && productPrices.get(j) < currentPrice) {
                        discountedItems.add(productPrices.get(j));
                        usedIndexes.add(j); // Mark as used.
                        freeItemsAdded++;
                        if (freeItemsAdded == 2) {
                            break; // Stop after adding two free items.
                        }
                    }
                }
            }
        }

        // Output the results
        System.out.println("Discounted Items: " + discountedItems);
        System.out.println("Payable Items: " + payableItems);
    }
}
