package com.hcc.hccbanking.service.impl;

import com.hcc.hccbanking.model.*;
import com.hcc.hccbanking.payload.BankDTO;
import com.hcc.hccbanking.service.DataService;
import com.hcc.hccbanking.utils.ColorConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.hcc.hccbanking.model.Credit;

import javax.naming.NameNotFoundException;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class DataServiceImpl implements DataService {
    private static String bank = "INECOBANK";

    @Override
    public List<CreditPageViewItem> getCreditPageViewItemList(String clientType, String creditType) {
        List<CreditPageViewItem> creditPageViewItemList = new ArrayList<>();

        creditType = creditType.toUpperCase(Locale.ROOT);

        clientType = clientType.toUpperCase(Locale.ROOT);

        for (Partner partner : Partner.values()) {
            for (Credit credit : partner.getBank().getCredits()) {
                if (credit.getCreditType() == CreditType.valueOf(creditType) && credit.getClientType() == ClientType.valueOf(clientType) && !credit.isCreditRemoved()) {
                    CreditPageViewItem creditPageViewItemTemp = CreditPageViewItem.builder()
                            .credit(credit)
                            .config(partner.getBank().getConfigInfo())
                            .bankName(partner.getBank().getName())
                            .build();

                    creditPageViewItemList.add(creditPageViewItemTemp);
                }
            }
        }
        return creditPageViewItemList;
    }

    @Override
    public CreditPageViewGrouped getCreditPageViewGrouped(String bankName) {

        bankName = bankName.toUpperCase(Locale.ROOT);

        bank = bankName;

        Bank currentBank = Partner.valueOf(bank).getBank();

        Config currentConfig = Config.builder()
                .color(currentBank.getConfigInfo().getColor())
                .imgURL(currentBank.getConfigInfo().getImgURL())
                .build();

        String newColor = ColorConverter.convertFromHEXToRGBA(currentConfig.getColor(), 40);

        currentConfig.setColor(newColor);

        CreditPageViewGrouped creditPageViewGrouped = CreditPageViewGrouped.builder()
                .config(currentConfig)
                .calculatorInfo(currentBank.getCalculatorInfo())
                .creditPageViewItemListLegal(new ArrayList<>())
                .creditPageViewItemListPersonal(new ArrayList<>())
                .build();

        for (Credit credit : currentBank.getCredits()) {
            if (!credit.isCreditRemoved()) {
                if (credit.getClientType().toString().equals("PERSONAL")) {
                    creditPageViewGrouped.getCreditPageViewItemListPersonal().add(credit);
                } else {
                    creditPageViewGrouped.getCreditPageViewItemListLegal().add(credit);
                }
            }
        }

        return creditPageViewGrouped;
    }

    @Override
    public void updateBank(BankDTO bankDTO) {
        String bankName = bankDTO.getBankName();
        bankName = bankName.toUpperCase(Locale.ROOT);
        Partner partnerName = Partner.valueOf(bankName);
        partnerName.getBank().setName(bankDTO.getBankName());

        Integer id = bankDTO.getId();
        for (Partner partner : Partner.values()) {
            for (Credit credit : partner.getBank().getCredits()) {
                if (credit.getId().equals(id) && partner.name().equals(bankName) && !credit.isCreditRemoved()) {
                    credit.setDescription(bankDTO.getDescription());
                    credit.setCreditPercent(bankDTO.getPercent());
                }
            }
        }

    }

    @Override
    public boolean deleteBankInfo(BankDTO bankDTO) {
        String bankName = bankDTO.getBankName();
        bankName = bankName.toUpperCase(Locale.ROOT);

        for (Partner partner : Partner.values()) {
            for (Credit credit : partner.getBank().getCredits()) {
                if (credit.getId().equals(bankDTO.getId()) && partner.name().equals(bankName)) {
                    credit.setCreditRemoved(true);
                    return true;
                }
            }
        }
        return false;
    }
}
