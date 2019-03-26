package com.java.springbootstarter;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeIDGeneratorTest {

    @Test
    public  void testGetId(){
        Assert.assertEquals(EmployeeIDGenerator.getId(), "1001");
        Assert.assertEquals(EmployeeIDGenerator.getId(), "1002");
        Assert.assertEquals(EmployeeIDGenerator.getId(), "1003");
        Assert.assertEquals(EmployeeIDGenerator.getId(), "1004");
        Assert.assertEquals(EmployeeIDGenerator.getId(), "1005");
    }

}
