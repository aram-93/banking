package com.hcc.hccbanking.payload;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Builder
@Setter
public class BankDTO {

    private String bankName;
    private String description;
    private String name;
    private Integer id;
    private Double percent;
}
