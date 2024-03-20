import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DiwaliSale {

    // Offer Rule 1: Buy one, get one free, where the free product's price is <= the paid product's price.
    public static void offerRule1(Integer[] productPrices) {
        Arrays.sort(productPrices, (a, b) -> b - a); // Sort prices in descending order
        List<Integer> discountedItems = new LinkedList<>();
        List<Integer> payableItems = new LinkedList<>();

        for (int i = 0; i < productPrices.length - 1; i += 2) {
            payableItems.add(productPrices[i]);
            discountedItems.add(productPrices[i + 1]);
        }

        // If there's an odd number of products, the last one can't be paired for a discount.
        if (productPrices.length % 2 != 0) {
            payableItems.add(productPrices[productPrices.length - 1]);
        }

        System.out.println("Rule 1 - Payable Items: " + payableItems);
        System.out.println("Rule 1 - Discounted Items: " + discountedItems);
    }

    // Offer Rule 2: Buy one, get one free, where the free product's price is < the paid product's price.
    public static void offerRule2(Integer[] productPrices) {
        Arrays.sort(productPrices, (a, b) -> b - a); // Sort prices in descending order
        List<Integer> discountedItems = new LinkedList<>();
        List<Integer> payableItems = new LinkedList<>();

        for (int i = 0; i < productPrices.length; i++) {
            if (i % 2 == 0) { // Even index: higher price, hence payable
                payableItems.add(productPrices[i]);
            } else { // Odd index: lower price, hence discounted
                discountedItems.add(productPrices[i]);
            }
        }

        System.out.println("Rule 2 - Payable Items: " + payableItems);
        System.out.println("Rule 2 - Discounted Items: " + discountedItems);
    }

    // Offer Rule 3: Buy two, get two free, where each free product's price is < the first paid product's price.
    public static void offerRule3(Integer[] productPrices) {
        Arrays.sort(productPrices, (a, b) -> b - a); // Sort prices in descending order
        List<Integer> discountedItems = new LinkedList<>();
        List<Integer> payableItems = new LinkedList<>();

        for (int i = 0; i < productPrices.length; i++) {
            if (i % 2 == 0) { // First two items: payable
                payableItems.add(productPrices[i]);
            } else { // Subsequent items: potentially discounted
                discountedItems.add(productPrices[i]);
            }
        }

        System.out.println("Rule 3 - Payable Items: " + payableItems);
        System.out.println("Rule 3 - Discounted Items: " + discountedItems);
    }

    public static void main(String[] args) {
        Integer[] prices1 = {10, 20, 30, 40, 50, 60};
        Integer[] prices2 = {10,20,30,40,50,50,50,60};
        Integer[] prices3 = {5,5,10,20,30,40,50,50,50,60 };

        System.out.println("Example for Offer Rule 1:");
        offerRule1(prices1);

        System.out.println("\nExample for Offer Rule 2:");
        offerRule2(prices2);

        System.out.println("\nExample for Offer Rule 3:");
        offerRule3(prices3);
    }
}