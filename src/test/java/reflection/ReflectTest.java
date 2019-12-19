package reflection;

import org.junit.Assert;
import org.junit.Test;
import pojo.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

    @Test
    public void testClassLoader() throws Throwable {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        ClassLoader loader2 = Class.forName("pojo.Car").getClassLoader();


        System.out.println("context " + loader);
        System.out.println("getclass " + loader2);

        Assert.assertEquals(loader.toString(),loader2.toString());

    }

    @Test
    public void initByDefaultConst() throws Throwable {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("pojo.Car");

        Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) cons.newInstance();

        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "A4");
        Method setColor = clazz.getMethod("setColor",String.class);
        setColor.invoke(car,"white");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed",int.class);
        setMaxSpeed.invoke(car,2000);

        car.introduce();
    }
}
