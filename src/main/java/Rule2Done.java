import java.util.*;

public class Rule2Done {



    public static void applyDiscount(List<Integer> productPrices) {
        // Sort the list in descending order so that the highest priced items are considered first.
        Collections.sort(productPrices, Collections.reverseOrder());

        List<Integer> discountedItems = new ArrayList<>();
        List<Integer> payableItems = new ArrayList<>();

        // Create a temporary list to keep track of items that are already paired.
        Set<Integer> usedIndexes = new HashSet<>();

        for (int i = 0; i < productPrices.size(); i++) {
            if (!usedIndexes.contains(i)) {
                int currentPrice = productPrices.get(i);
                payableItems.add(currentPrice);
                for (int j = i + 1; j < productPrices.size(); j++) {
                    if (!usedIndexes.contains(j) && productPrices.get(j) < currentPrice) {
                        discountedItems.add(productPrices.get(j));
                        usedIndexes.add(j); // Mark as paired
                        break; // Move to the next product in the main list
                    }
                }
            }
        }

        // Output the results
        System.out.println("Discounted Items: " + discountedItems);
        System.out.println("Payable Items: " + payableItems);
    }


    public static void main(String[] args) {
        List<Integer> productPriceList1 = Arrays.asList(10, 20, 30, 40, 40, 50, 60, 60);
        List<Integer> productPriceList2 = Arrays.asList(10, 20, 30, 40, 50, 50, 50, 60);

        System.out.println("Example 1:");
        applyDiscount(productPriceList1);

        System.out.println("\nExample 2:");
        applyDiscount(productPriceList2);
    }







}
