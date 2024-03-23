package com.assignment.service;

import com.assignment.dto.RuleAPIReturnResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class RuleEngineServiceImpl implements RuleEngineService {


    @Override
    public RuleAPIReturnResponse offerRuleOne(List<Integer> productPrices) {
        // Sort the list in descending order so that the highest priced items are considered first.
        Collections.sort(productPrices, Collections.reverseOrder());

        List<Integer> discountedItems = new LinkedList<>();
        List<Integer> payableItems = new LinkedList<>();

        for (int i = 0; i < productPrices.size() - 1; i += 2) {
            payableItems.add(productPrices.get(i));
            discountedItems.add(productPrices.get(i + 1));
        }
        // If there's an odd number of products, the last one can't be paired for a discount.
        if (productPrices.size() % 2 != 0) {
            payableItems.add(productPrices.get(productPrices.size() - 1));
        }
        log.info("Rule 1 - Payable Items: {}", payableItems);
        log.info("Rule 1 - Discounted Items: {}", discountedItems);

        RuleAPIReturnResponse response = RuleAPIReturnResponse.builder()
                .discountedItems(discountedItems)
                .payableItems(payableItems)
                .build();

        return response;
    }

    @Override
    public RuleAPIReturnResponse offerRuleTwo(List<Integer> productPrices) {
        Collections.sort(productPrices, Collections.reverseOrder());

        List<Integer> discountedItems = new ArrayList<>();
        List<Integer> payableItems = new ArrayList<>();

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

        log.info("Discounted Items: {}", discountedItems);
        log.info("Payable Items: {}", payableItems);


        RuleAPIReturnResponse response = RuleAPIReturnResponse.builder()
                .discountedItems(discountedItems)
                .payableItems(payableItems)
                .build();

        return response;
    }

    @Override
    public RuleAPIReturnResponse offerRuleThree(List<Integer> productPrices) {
         Collections.sort(productPrices, Collections.reverseOrder());

        List<Integer> discountedItems = new ArrayList<>();
        List<Integer> payableItems = new ArrayList<>();

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

        log.info("Discounted Items: {}", discountedItems);
        log.info("Payable Items: {}", payableItems);


        RuleAPIReturnResponse response = RuleAPIReturnResponse.builder()
                .discountedItems(discountedItems)
                .payableItems(payableItems)
                .build();

        return response;
    }


}
