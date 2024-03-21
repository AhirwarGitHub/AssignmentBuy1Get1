package com.assignment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RuleOneAPIResponse<D> {
    private final String responseStatus;
    private final String responseCode;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final String responseMessage;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final D data;
}
