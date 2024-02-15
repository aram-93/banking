package com.hcc.hccbanking.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreditPageViewItem {
    private Credit credit;
    private Config config;
    private String bankName;
    private String name;
}
