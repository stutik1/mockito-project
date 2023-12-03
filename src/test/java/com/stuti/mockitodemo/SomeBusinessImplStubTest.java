package com.stuti.mockitodemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeBusinessImplStubTest {

    @Test
    void findGreaterValue_basic(){
        DataServiceStub dataServiceStub = new DataServiceStub();
        SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = someBusinessImpl.findGreaterValue();
        assertEquals(50,result);
    }

    @Test
    void findGreaterValue_WithOneValue(){
        DataService dataServiceStub1 = new DataServiceStub1();
        SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceStub1);
        int result = someBusinessImpl.findGreaterValue();
        assertEquals(24,result);
    }
}

class DataServiceStub implements DataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{25,50,5};
    }
}
    class DataServiceStub1 implements DataService {

        @Override
        public int[] retrieveAllData() {
            return new int[]{24};
        }
    }
