package com.assignment.service;

import com.assignment.dto.RuleAPIReturnResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RuleEngineService {
    public RuleAPIReturnResponse offerRuleOne(List<Integer> productPrices);

    public RuleAPIReturnResponse offerRuleTwo(List<Integer> productPrices);
    public RuleAPIReturnResponse offerRuleThree(List<Integer> productPrices);

}
