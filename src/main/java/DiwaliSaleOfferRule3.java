import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DiwaliSaleOfferRule3 {

    // Offer Rule 3: Buy two products and get two products for free,
    // where each free product's price is < the price of the first paid product.
    public static void offerRule3(Integer[] productPrices) {
        Arrays.sort(productPrices, (a, b) -> b - a); // Sort prices in descending order
        List<Integer> discountedItems = new LinkedList<>();
        List<Integer> payableItems = new LinkedList<>();

        // Assuming first two highest prices are always paid
        if (productPrices.length >= 2) {
            payableItems.add(productPrices[0]); // First highest price
            payableItems.add(productPrices[1]); // Second highest price
        }

        // Now, find two highest-priced items that are less than the first paid product
        int countFreeItems = 0;
        for (int i = 2; i < productPrices.length && countFreeItems < 2; i++) {
            if (productPrices[i] < productPrices[0]) { // Less than the first (highest) paid product
                discountedItems.add(productPrices[i]);
                countFreeItems++;
            } else {
                payableItems.add(productPrices[i]); // If not eligible for free, then it's payable
            }
        }

        // Add remaining items to payable if not already considered
        for (int i = 2 + countFreeItems; i < productPrices.length; i++) {
            payableItems.add(productPrices[i]);
        }

        System.out.println("Rule 3 - Payable Items: " + payableItems);
        System.out.println("Rule 3 - Discounted Items: " + discountedItems);
    }

    public static void main(String[] args) {
        Integer[] prices1 = {10, 20, 30, 40, 40, 50, 60, 60};
        Integer[] prices2 = {5, 5, 10, 20, 30, 40, 50, 50, 50, 60};

        System.out.println("Example for Offer Rule 3:");
        offerRule3(prices1);

        System.out.println("\nExample for Offer Rule 3:");
        offerRule3(prices2);
    }
}
