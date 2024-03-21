package com.assignment.controller;


import com.assignment.dto.ProductPriceList;
import com.assignment.dto.RuleOneAPIResponse;
import com.assignment.dto.RuleAPIReturnResponse;
import com.assignment.service.RuleEngineService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RuleEngineController {
    @Autowired
    RuleEngineService ruleEngineService;

    @PostMapping(value = "/getRuleOfferOne", produces = "application/json")
    @ApiOperation(value = "Offer Rule 1 --------> Buy 1 get 1")
    public ResponseEntity<Object> getRuleOfferOne(@RequestBody @Validated ProductPriceList productPriceList) {
        RuleAPIReturnResponse responseData = ruleEngineService.offerRuleOne(productPriceList.getProductPrices());
        return new ResponseEntity<>(RuleOneAPIResponse.builder()
                .responseCode("200")
                .responseMessage("Rule One Response Fetched Successfully ...")
                .data(responseData)
                .responseStatus("SUCCESS").build(), HttpStatus.OK);
    }


    @PostMapping(value = "/getRuleOfferTwo", produces = "application/json")
    @ApiOperation(value = "Offer Rule 2 --------> Buy 1 get 1 ")
    public ResponseEntity<Object> getRuleOfferTwo(@RequestBody @Validated ProductPriceList productPriceList) {
        RuleAPIReturnResponse responseData = ruleEngineService.offerRuleTwo(productPriceList.getProductPrices());
        return new ResponseEntity<>(RuleOneAPIResponse.builder()
                .responseCode("200")
                .responseMessage("Rule Two Response Fetched Successfully ...")
                .data(responseData)
                .responseStatus("SUCCESS").build(), HttpStatus.OK);
    }

    @PostMapping(value = "/getRuleOfferThree", produces = "application/json")
    @ApiOperation(value = "Offer Rule 3 --------> Buy 2 get 2 ")
    public ResponseEntity<Object> getRuleOfferThree(@RequestBody @Validated ProductPriceList productPriceList) {
        RuleAPIReturnResponse responseData = ruleEngineService.offerRuleThree(productPriceList.getProductPrices());
        return new ResponseEntity<>(RuleOneAPIResponse.builder()
                .responseCode("200")
                .responseMessage("Rule Three Response Fetched Successfully ...")
                .data(responseData)
                .responseStatus("SUCCESS").build(), HttpStatus.OK);
    }
}
