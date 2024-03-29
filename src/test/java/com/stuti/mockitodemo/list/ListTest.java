package com.stuti.mockitodemo.list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ListTest {

    @Test
    void ListTest(){
       List listMock = mock(List.class);
      when(listMock.size()).thenReturn(3);
      assertEquals(3,listMock.size());
      assertEquals(3,listMock.size());

    }
    @Test
    void multipleReturn(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(1).thenReturn(2);
        assertEquals(1,listMock.size());
        assertEquals(2,listMock.size());
        assertEquals(2,listMock.size());
    }

    @Test
    void specificParameter() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("SomeString");
        assertEquals("SomeString", listMock.get(0));
        assertEquals(null,listMock.get(1));
    }

    @Test
    void genericParameter() {
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("SomeOtherString");
        assertEquals("SomeOtherString", listMock.get(0));
        assertEquals("SomeOtherString",listMock.get(1));
    }
}