package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class urinalsTest {
    @Test
    public void Test() {
        System.out.println("====== Mohana Deepthi Karumanchi == TEST ONE EXECUTED =======");
        assertEquals(2, urinals.resultUrinals("1000001"));
    }

}