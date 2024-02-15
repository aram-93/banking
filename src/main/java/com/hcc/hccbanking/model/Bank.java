package com.hcc.hccbanking.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
@Setter
public class Bank {
    private String name;
    private List<Credit> credits;
    private Config configInfo;
    private CalculatorInformation calculatorInfo;
}
