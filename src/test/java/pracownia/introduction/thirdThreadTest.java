package pracownia.introduction;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.*;
import static pracownia.introduction.thirdThread.timeCounter;
import static pracownia.introduction.thirdThread.timer;

public class thirdThreadTest {

    int[] hourTest =    {8 ,9 ,10,11,11,13,13,15,15,17};
    int[] minutesTest = {15,45,0 ,30,45,15,45,15,30,0};

    @Test
    public void test1(){
        assertEquals(timeCounter(hourTest[2],minutesTest[2],10,30),30);
    }
    @Test
    public void test2(){
        assertNotEquals(timeCounter(hourTest[2],minutesTest[2],10,30),56);
    }
    @Test
    public void test3(){
       timer(8,0);

    }
}