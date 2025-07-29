package com.hcc.hccbanking.service;

import com.hcc.hccbanking.model.CreditPageViewGrouped;
import com.hcc.hccbanking.model.CreditPageViewItem;
import com.hcc.hccbanking.payload.BankDTO;

import java.util.List;

public interface DataService {
//vklfd;bk
    List<CreditPageViewItem> getCreditPageViewItemList(String clientType, String creditType);

    CreditPageViewGrouped getCreditPageViewGrouped(String bankName);

    void updateBank(BankDTO bankDTO);
    boolean deleteBankInfo(BankDTO bankDTO);
}
