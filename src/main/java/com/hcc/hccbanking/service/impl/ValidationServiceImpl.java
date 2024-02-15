package com.hcc.hccbanking.service.impl;

import com.hcc.hccbanking.model.ClientType;
import com.hcc.hccbanking.model.CreditType;
import com.hcc.hccbanking.model.Partner;
import com.hcc.hccbanking.service.ValidationService;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean isBankNameValid(String bankName) {
        bankName = bankName.toUpperCase(Locale.ROOT);

        try {
            Partner.valueOf(bankName);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isClientTypeValid(String clientType) {
        clientType = clientType.toUpperCase(Locale.ROOT);
        try {
            ClientType.valueOf(clientType);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isCreditTypeValid(String creditType) {
        creditType = creditType.toUpperCase(Locale.ROOT);
        try {
            CreditType.valueOf(creditType);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
