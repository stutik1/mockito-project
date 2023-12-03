package com.stuti.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl someBusinessImpl;

    @Test
    void SomeBusinessImplMockTest_basicTest() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{20, 50, 100});
        assertEquals(100, someBusinessImpl.findGreaterValue());
    }

    @Test
    void SomeBusinessImplMockTest_oneValueTest() {

        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{50});
        SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
        int result = someBusinessImpl.findGreaterValue();
        assertEquals(50, result);
    }

    @Test
    void SomeBusinessImplMockTest_emptyArray() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        int result = someBusinessImpl.findGreaterValue();
        assertEquals(Integer.MIN_VALUE, result);
    }
}