package com.hcc.hccbanking.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Credit {
    private Integer id;
    private String description;
    private ClientType clientType;
    private CreditType creditType;
    private Double creditPercent;
    private boolean creditRemoved;
}
