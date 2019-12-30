package operators;

import org.junit.Assert;
import org.junit.Test;

public class OperatorsTest {

    @Test
    public void xorTest() {

        Assert.assertEquals(2^3,1);
    }

    @Test
    public void andTest() {

        Assert.assertEquals(2&3,2);
    }

    @Test
    public void leftShiftTest() {

        Assert.assertEquals(2 << 3,16);
    }


    @Test
    public void rightShiftTest() {

        Assert.assertEquals(2 >> 3,0);
        Assert.assertEquals(2 >> 1,1);

    }


    @Test
    public void unsignedRightShift() {

        //补码：保证符号位不变，其余位置取反加1（从右往左遇到第一个1，然后剩下的全部取反就是了）
        Assert.assertEquals(-16 >>> 2 ,0b00111111111111111111111111111100);
    }
}
