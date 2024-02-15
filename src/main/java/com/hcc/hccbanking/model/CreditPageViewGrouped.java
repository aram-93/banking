package com.hcc.hccbanking.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
public class CreditPageViewGrouped {
    private Config config;
    private List<Credit> creditPageViewItemListLegal;
    private List<Credit> creditPageViewItemListPersonal;
    private CalculatorInformation calculatorInfo;
}
