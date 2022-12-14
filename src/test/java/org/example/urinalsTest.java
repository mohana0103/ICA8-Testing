package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class urinalsTest {
    @Test
    public void Test() {
        System.out.println("====== Mohana Deepthi Karumanchi == TEST ONE EXECUTED =======");
        assertEquals(2, urinals.resultUrinals("1000001"));
    }
    @Test
    public void Testtwo() {
        System.out.println("====== Mohana Deepthi Karumanchi == TEST TWO EXECUTED =======");
        assertEquals(1, urinals.resultUrinals("1000"));
    }

    @Test
    public void Testthree() {
        System.out.println("====== Mohana Deepthi Karumanchi == TEST THREE EXECUTED =======");
        assertEquals(-1, urinals.resultUrinals("111011"));
    }
    @Test
    public void Testfour() {
        System.out.println("====== Mohana Deepthi Karumanchi == TEST FOUR EXECUTED =======");
        assertEquals(0, urinals.resultUrinals("1"));
    }
    @Test
    public void Testfive() {
        System.out.println("====== Mohana Deepthi Karumanchi == TEST FIVE EXECUTED =======");
        assertEquals(0, urinals.resultUrinals("10"));
    }
    @Test
    public void Testsix() {
        System.out.println("====== Mohana Deepthi Karumanchi == TEST SIX EXECUTED =======");
        assertEquals(3, urinals.resultUrinals("00000"));
    }

}