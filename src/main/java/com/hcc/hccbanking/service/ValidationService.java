package com.hcc.hccbanking.service;

public interface ValidationService {
    boolean isBankNameValid(String bankName);

    boolean isClientTypeValid(String clientType);

    boolean isCreditTypeValid(String creditType);

}
