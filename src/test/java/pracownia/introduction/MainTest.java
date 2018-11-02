package pracownia.introduction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static pracownia.introduction.Main.checkPESEL;
import static pracownia.introduction.Main.regex;

public class MainTest {

    @Test
    public void Test1(){

      Assert.assertTrue(  checkPESEL(regex("Daniel Matuszewski 96070905190")));
    }
    @Test
    public void Test2(){

        Assert.assertEquals(regex("Daniel Matuszewski 96070905190"),"96070905190");

    }
    @Test
    public void Test3(){
        Assert.assertFalse(  checkPESEL(regex("Daniel Matuszewski 96070905197")));

    }
}
