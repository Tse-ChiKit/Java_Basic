package format;

import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;

public class DataFormatTest {

    @Test
    public void DecimalFormatTest(){
        int i = 12;
        DecimalFormat df = new DecimalFormat("000");
        Assert.assertEquals(df.format(i),"012");
    }
}
