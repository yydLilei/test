package com.ll.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class CalculatorTest {
    private Calculator mCalculator;
    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
        System.out.println("setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    public void sum() throws Exception {
        System.out.println("sum");
        //expected: 6, sum of 1 and 5
        assertEquals(6d, mCalculator.sum(1d, 5d), 0);
    }

    @Test
    public void substract() throws Exception {
        System.out.println("substract");
        assertEquals(6d, mCalculator.substract(1d, 5d), 0);
    }

    @Test
    public void divide() throws Exception {

    }

    @Test
    public void multiply() throws Exception {

    }

}