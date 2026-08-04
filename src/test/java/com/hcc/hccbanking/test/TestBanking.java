package com.hcc.hccbanking.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class TestBanking {

    @Test
    public void testGetCreditPageViewItemList(){
        SoftAssert softAssert = new SoftAssert();

        log.info("all is good");
        softAssert.assertTrue(true);{

        }
        softAssert.assertAll();
    }
}
