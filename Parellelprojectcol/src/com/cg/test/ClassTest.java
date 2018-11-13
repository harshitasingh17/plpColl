package com.cg.test;

import org.junit.Assert;
import org.junit.Test;

import com.cg.exception.WalletException;
import com.cg.service.WalletService;
import com.cg.service.WalletServiceImpl;

public class ClassTest {
	@Test
    public void test_ValidateName_null() throws WalletException{
        WalletService service=new WalletServiceImpl();
        service.validateName(null);
    }
    
    @Test
    public void test_validateName_v1() throws WalletException{
    
        String name="Aete121";
        WalletService service=new WalletServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(false,result);
    }
    @Test
    public void test_validateName_v2() throws WalletException{
    
        String name="Amita";
        WalletService service=new WalletServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(true,result);
    }
    
  //TestClass cases for Mobile number
    
    
    @Test
    public void test_validateMobNo_v1() throws WalletException{
        String mobNo="ABCD91828288";
        WalletService service=new WalletServiceImpl();
        boolean result= service.validateMobileNo(mobNo);
        Assert.assertEquals(false,result);
    }
    @Test
    public void test_validateMobNo_v2() throws WalletException{
    
        String mobNo="9922974725";
        WalletService service=new WalletServiceImpl();
        boolean result= service.validateMobileNo(mobNo);
        Assert.assertEquals(true,result);
    }
}
